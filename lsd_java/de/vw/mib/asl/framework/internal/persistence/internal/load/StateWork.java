/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.load;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApi;
import de.vw.mib.asl.framework.internal.persistence.internal.PrivateUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.config.PersistenceConfig;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.load.PersistenceLoadNamespaceTarget;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

class StateWork
extends AbstractHsmState {
    static final int EV_READ_RESPONSE;
    private static final boolean LOAD_PERSISTENCE_2_NAMESPACES;
    private final PersistenceLoadNamespaceTarget mTarget;
    private int mLastRequestedNamespaceId;
    private long mLastRequestedKey;
    private int mNamespaceIndex;
    private int mKeyIndex;
    private long mTime;
    private LongIntMap mKey2Type = new LongIntOptHashMap();
    private final PersistenceServices services = PersistenceServicesProvider.getPersistenceServices();
    private final PersistenceKeyProvider persistenceKeys;

    public StateWork(PersistenceLoadNamespaceTarget persistenceLoadNamespaceTarget, HsmState hsmState) {
        super(persistenceLoadNamespaceTarget.getHsm(), "Work", hsmState);
        this.mTarget = persistenceLoadNamespaceTarget;
        this.persistenceKeys = this.services.getPersistenceKeyProvider();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("State Load:Work", true);
                break;
            }
            case 3: {
                this.handleHsmStart();
                break;
            }
            case 100001: {
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                if (n != this.mLastRequestedNamespaceId || l != this.mLastRequestedKey || this.requestField()) break;
                this.trans(this.mTarget.mStateIdle);
                break;
            }
            case 4: {
                this.sendBack();
                long l = this.mTime != 0L ? ServiceManager.timerManager.getSystemTimeMillis() - this.mTime : 0L;
                PersDebug.trace(new StringBuffer().append("Pre-Load Namespace ").append(this.mLastRequestedNamespaceId).append(" done, Time: ").append(l).append(" ms").toString(), true);
                break;
            }
            case 7: {
                this.sendBack();
                this.trans(this.mTarget.mStateInactive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleHsmStart() {
        if (this.mTarget.mCurrentRequest == null) {
            this.trans(this.mTarget.mStateIdle);
        } else {
            boolean bl;
            this.mLastRequestedNamespaceId = this.mTarget.mCurrentRequest.getInt(0);
            this.mLastRequestedKey = 0L;
            this.mKeyIndex = 0;
            this.mTime = 0L;
            PersDebug.trace(new StringBuffer().append("Pre-Load Namespace ").append(this.mLastRequestedNamespaceId).toString(), true);
            PersDebug.writeTableHeader();
            this.mNamespaceIndex = PrivateUtil.getIndexOfNamespaceInArray(this.mLastRequestedNamespaceId);
            boolean bl2 = bl = this.mLastRequestedNamespaceId >= 5050 && this.mLastRequestedNamespaceId < 5100;
            if (bl && !LOAD_PERSISTENCE_2_NAMESPACES) {
                this.mTarget.mCurrentRequest.setResult(9);
                this.trans(this.mTarget.mStateIdle);
                PersDebug.warn(new StringBuffer().append("Skipping the loading of the persistence 2.0 namespace: ").append(this.mLastRequestedNamespaceId).toString());
            } else if (!(bl || this.mNamespaceIndex >= 0 && this.mNamespaceIndex < PrivateUtil.getNumberOfNamespaces())) {
                this.mTarget.mCurrentRequest.setResult(5);
                this.trans(this.mTarget.mStateIdle);
            } else if (!bl && PrivateUtil.getNumberOfKeysInNamespace(this.mNamespaceIndex) <= 0) {
                this.mTarget.mCurrentRequest.setResult(0);
                this.trans(this.mTarget.mStateIdle);
            } else {
                if (!this.mTarget.mCurrentRequest.isBlocked()) {
                    this.mTarget.mCurrentRequest.setBlocked(true);
                }
                this.mTime = ServiceManager.timerManager.getSystemTimeMillis();
                this.collectFields();
                if (!this.requestField()) {
                    this.trans(this.mTarget.mStateIdle);
                }
            }
        }
    }

    private void sendBack() {
        if (this.mTarget.mCurrentRequest != null && this.mTarget.mCurrentRequest.isBlocked()) {
            this.mTarget.mCurrentRequest.setBlocked(false);
            ServiceManager.eventMain.getEventDispatcher().sendBack(this.mTarget.mCurrentRequest);
            this.mTarget.mCurrentRequest = null;
        }
    }

    private void collectFields() {
        this.mKey2Type.clear();
        for (int i2 = 0; i2 < PrivateUtil.getNumberOfKeysInNamespace(this.mNamespaceIndex); ++i2) {
            long l = PersistenceConfig.makeKey(PrivateUtil.getKeyOfNamespaceByIndex(this.mNamespaceIndex, i2), PersistenceConfig.mCurrentUser);
            this.mKey2Type.put(l, PrivateUtil.getTypeOfKeyInNamespace(this.mNamespaceIndex, i2));
        }
        ModuleDescriptor moduleDescriptor = this.services.getModuleDescriptorRegistry().getOrCreateDescriptor(this.mLastRequestedNamespaceId);
        if (moduleDescriptor == null) {
            return;
        }
        byte by = moduleDescriptor.getProfile();
        int[] nArray = this.persistenceKeys.retrieveCommonPersistableIds(this.mLastRequestedNamespaceId);
        int[] nArray2 = this.persistenceKeys.retrieveUserSpecificPersistableIds(this.mLastRequestedNamespaceId);
        boolean bl = true;
        this.collectPersistenceKeys(nArray, !bl, by);
        this.collectPersistenceKeys(nArray2, bl, by);
    }

    private void collectPersistenceKeys(int[] nArray, boolean bl, byte by) {
        int n;
        for (n = 0; n < nArray.length; ++n) {
            int n2 = nArray[n];
            long l = PersistenceKeyUtil.calcCommonKey(n2);
            this.mKey2Type.put(l, 3);
            if (!bl) continue;
            long l2 = PersistenceKeyUtil.calcUserKey(n2, by);
            this.mKey2Type.put(l2, 3);
        }
        n = 0;
        this.mKey2Type.put(n, 3);
    }

    private boolean requestField() {
        boolean bl = false;
        do {
            LongIterator longIterator;
            if (!(longIterator = this.mKey2Type.keyIterator()).hasNext()) {
                return false;
            }
            long l = longIterator.next();
            int n = this.mKey2Type.get(l);
            this.mKey2Type.remove(l);
            this.mLastRequestedKey = l;
            try {
                switch (n) {
                    case 1: {
                        this.persistenceAsyncApi().readInt(this.mTarget.getTargetId(), -1585053440, this.mLastRequestedNamespaceId, l);
                        bl = true;
                        break;
                    }
                    case 2: {
                        this.persistenceAsyncApi().readString(this.mTarget.getTargetId(), -1585053440, this.mLastRequestedNamespaceId, l);
                        bl = true;
                        break;
                    }
                    case 3: {
                        this.persistenceAsyncApi().readByteArray(this.mTarget.getTargetId(), -1585053440, this.mLastRequestedNamespaceId, l);
                        bl = true;
                        break;
                    }
                    case 4: {
                        this.persistenceAsyncApi().readStringArray(this.mTarget.getTargetId(), -1585053440, this.mLastRequestedNamespaceId, l);
                        bl = true;
                        break;
                    }
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                PersDebug.error(new StringBuffer().append("IllegalArgumentException for field ").append(PrivateUtil.getKeyOfNamespaceByIndex(this.mNamespaceIndex, this.mKeyIndex)).toString(), illegalArgumentException);
            }
            catch (GenericEventException genericEventException) {
                PersDebug.error(new StringBuffer().append("GenericEventException for field ").append(PrivateUtil.getKeyOfNamespaceByIndex(this.mNamespaceIndex, this.mKeyIndex)).toString(), genericEventException);
            }
        } while (!bl);
        return bl;
    }

    private AslPersistenceAsyncApi persistenceAsyncApi() {
        return PersistenceServicesProvider.getPersistenceServices().getAslPersistenceAsyncApi();
    }

    static {
        LOAD_PERSISTENCE_2_NAMESPACES = !Boolean.getBoolean("de.vw.mib.asl.persistence.skipPersistence2Namespaces");
    }
}

