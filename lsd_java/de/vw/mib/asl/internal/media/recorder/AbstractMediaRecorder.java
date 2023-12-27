/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.recorder.MediaRecorderPersistence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRecorder;

public abstract class AbstractMediaRecorder
extends AbstractMediaTarget {
    private static final int[] ATTR_MEDIA_RECORDER = new int[]{1, 5, 4, 7, 3, 6, 2, 8};
    private DSIMediaRecorder mDsiMediaRecorder;
    private DSIListener mDsiMediaRecorderListener;
    private static final int EV_DIAG_RECEIVE_CODING_DATA;
    private static final int EV_DIAG_RECEIVE_ADAPT_DATA;
    private Coding mCodingData = null;
    private Adaptation mAdaptationData = null;
    private MediaRecorderPersistence persistence = null;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorder;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorderListener;

    protected MediaRecorderPersistence getPersistence() {
        if (this.persistence == null) {
            this.persistence = new MediaRecorderPersistence();
        }
        return this.persistence;
    }

    public AbstractMediaRecorder(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public DSIMediaRecorder getDSI() {
        return this.mDsiMediaRecorder;
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMediaRecorder = (DSIMediaRecorder)dSIProxy.getService(this, class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = AbstractMediaRecorder.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder);
        this.mDsiMediaRecorderListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$media$DSIMediaRecorderListener == null ? (class$org$dsi$ifc$media$DSIMediaRecorderListener = AbstractMediaRecorder.class$("org.dsi.ifc.media.DSIMediaRecorderListener")) : class$org$dsi$ifc$media$DSIMediaRecorderListener);
        this.mDsiMediaRecorder.setNotification(ATTR_MEDIA_RECORDER, this.mDsiMediaRecorderListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$media$DSIMediaRecorderListener == null ? (class$org$dsi$ifc$media$DSIMediaRecorderListener = AbstractMediaRecorder.class$("org.dsi.ifc.media.DSIMediaRecorderListener")) : class$org$dsi$ifc$media$DSIMediaRecorderListener, this.mDsiMediaRecorderListener);
    }

    private void unregisterDSI() {
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$media$DSIMediaRecorderListener == null ? (class$org$dsi$ifc$media$DSIMediaRecorderListener = AbstractMediaRecorder.class$("org.dsi.ifc.media.DSIMediaRecorderListener")) : class$org$dsi$ifc$media$DSIMediaRecorderListener, this.mDsiMediaRecorderListener);
        this.mDsiMediaRecorder = null;
        this.mDsiMediaRecorderListener = null;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObserver(-2075192832);
                ServiceManager.aslPropertyManager.valueChangedBoolean(40, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(38, false);
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1568276224);
                this.registerDSI();
                EventGeneric eventGeneric2 = this.newEvent(279909120, -1517944576);
                eventGeneric2.setObject(0, this);
                this.sendSafe(eventGeneric2);
                break;
            }
            case 107: {
                this.unregisterDSI();
                this.valueChangedBoolean(39, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(40, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(38, false);
                break;
            }
            case 1200004: {
                if (this.isNamespaceKey(eventGeneric, -687821311, 1L)) {
                    ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
                }
                if (!this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1568276224);
                break;
            }
            case 100001: {
                if (eventGeneric.getResult() != 0 || !this.isNamespaceKey(eventGeneric, -687821311, 1L)) break;
                this.mCodingData = (Coding)eventGeneric.getObject(1);
                this.handleDiagnosisValuesChanged();
                break;
            }
            case 100002: {
                if (eventGeneric.getResult() != 0 || !this.isNamespaceKey(eventGeneric, -536825343, 0)) break;
                this.mAdaptationData = (Adaptation)eventGeneric.getObject(1);
                this.handleDiagnosisValuesChanged();
                break;
            }
        }
    }

    private boolean isNamespaceKey(EventGeneric eventGeneric, int n, long l) {
        int n2 = eventGeneric.getInt(2);
        long l2 = eventGeneric.getLong(3);
        return n2 == n && l2 == l;
    }

    private void handleDiagnosisValuesChanged() {
        if (this.mCodingData != null && this.mAdaptationData != null) {
            boolean bl = this.mCodingData.getBoolean(107) && this.mAdaptationData.getBoolean(113);
            boolean bl2 = this.mCodingData.getBoolean(108) && this.mAdaptationData.getBoolean(114);
            ServiceManager.aslPropertyManager.valueChangedBoolean(40, bl);
            ServiceManager.aslPropertyManager.valueChangedBoolean(38, bl2);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

