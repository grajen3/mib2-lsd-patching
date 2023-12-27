/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap;

import de.vw.mib.asl.api.bap.BAPInterfaceProvider;
import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdActiveSource;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdCurrentStationHandle;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStation_Handle_Status;
import java.util.Iterator;
import java.util.List;

public class BapAudioSdAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
BapAudioSdService,
BAPValueObserver,
BapAudioSdActiveSource,
BapAudioSdCurrentStationHandle {
    private BAPObserverRegistry _bapObserverRegistry;
    private static final int[] BAP_AUDIO_SD_PROPERTY_IDS = BapAudioSdDelegate.BAP_AUDIO_SD_PROPERTIES;
    private int _activeSourceSourceType;
    private int _activeSourceSourceListReference;
    private int _currentStationHandleCurrentStationHandle;
    private int _currentStationHandlePresetListRef;
    private int _currentStationHandlePresetListAbsPos;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService = BapAudioSdAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService;
    }

    private BAPObserverRegistry getBapAudioSdObserverRegistry() {
        BAPLogicalControlUnit bAPLogicalControlUnit;
        if (this._bapObserverRegistry == null && (bAPLogicalControlUnit = new BAPInterfaceProvider(ServiceManager.bundleContext).getBapDispatcher().getLogicalControlUnit(49)) != null) {
            this._bapObserverRegistry = bAPLogicalControlUnit.getBapObserverRegistry();
        }
        return this._bapObserverRegistry;
    }

    @Override
    public void register() {
        super.register();
        for (int n : BAP_AUDIO_SD_PROPERTY_IDS) {
            this.getBapAudioSdObserverRegistry().getBapValueObservable(n).addObserver(this, new Integer(n));
        }
    }

    @Override
    public void unregister() {
        super.unregister();
        for (int n : BAP_AUDIO_SD_PROPERTY_IDS) {
            this.getBapAudioSdObserverRegistry().getBapValueObservable(n).removeObserver(this);
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return null;
    }

    @Override
    protected int[] getListIds() {
        return null;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void updateAllServiceListeners() {
        super.updateAllServiceListeners();
        this.getBapAudioSdObserverRegistry().flushAllBapValueObserverables();
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                BapAudioSdDelegate bapAudioSdDelegate = (BapAudioSdDelegate)iterator.next();
                bapAudioSdDelegate.updateBapAudioSd(this, n);
            }
        }
    }

    @Override
    public BapAudioSdActiveSource getActiveSource() {
        return this;
    }

    @Override
    public BapAudioSdCurrentStationHandle getCurrentStationHandle() {
        return this;
    }

    @Override
    public int getActiveSourceSourceType() {
        return this._activeSourceSourceType;
    }

    @Override
    public int getActiveSourceSourceListReference() {
        return this._activeSourceSourceListReference;
    }

    @Override
    public int getCurrentStationHandleCurrentStationHandle() {
        return this._currentStationHandleCurrentStationHandle;
    }

    @Override
    public int getCurrentStationHandlePresetListReference() {
        return this._currentStationHandlePresetListRef;
    }

    @Override
    public int getCurrentStationHandlePresetListAbsPos() {
        return this._currentStationHandlePresetListAbsPos;
    }

    private static int _mapBapSourceTypePictureServerSourceType(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 2;
                break;
            }
            case 17: {
                n2 = 17;
                break;
            }
            case 13: {
                n2 = 14;
                break;
            }
            case 14: {
                n2 = 13;
                break;
            }
            case 32: {
                n2 = 32;
                break;
            }
            case 21: {
                n2 = 21;
                break;
            }
            case 22: {
                n2 = 22;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 24: {
                n2 = 24;
                break;
            }
            case 23: {
                n2 = 23;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 18: {
                n2 = 18;
                break;
            }
            case 31: {
                n2 = 25;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 16: {
                n2 = 16;
                break;
            }
            case 10: {
                n2 = 10;
                break;
            }
            case 33: {
                n2 = 33;
                break;
            }
            case 20: {
                n2 = 20;
                break;
            }
            case 0: {
                n2 = 0;
                break;
            }
            case 34: {
                n2 = 28;
                break;
            }
            case 35: {
                n2 = 35;
                break;
            }
            case 15: 
            case 28: {
                n2 = 15;
                break;
            }
            case 11: 
            case 27: {
                n2 = 11;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 12: {
                n2 = 12;
                break;
            }
            case 9: {
                n2 = 9;
                break;
            }
            case 255: {
                n2 = 255;
                break;
            }
            case 19: {
                n2 = 19;
                break;
            }
            default: {
                n2 = 255;
            }
        }
        return n2;
    }

    private boolean _storeBapInfoData(int n, BAPEntity bAPEntity) {
        boolean bl;
        switch (n) {
            case 16: {
                ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPEntity;
                int n2 = BapAudioSdAdapter._mapBapSourceTypePictureServerSourceType(activeSource_Status.sourceType);
                int n3 = activeSource_Status.sourceList_Reference;
                boolean bl2 = bl = n2 != this._activeSourceSourceType || n3 != this._activeSourceSourceListReference;
                if (!bl) break;
                this._activeSourceSourceType = n2;
                this._activeSourceSourceListReference = n3;
                break;
            }
            case 22: {
                int n4;
                boolean bl3;
                int n5;
                boolean bl4;
                boolean bl5;
                CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)bAPEntity;
                int n6 = currentStation_Handle_Status.fsgHandle;
                boolean bl6 = bl5 = n6 != this._currentStationHandleCurrentStationHandle;
                if (bl5) {
                    this._currentStationHandleCurrentStationHandle = n6;
                }
                boolean bl7 = bl4 = (n5 = currentStation_Handle_Status.presetList_Ref) != this._currentStationHandlePresetListRef;
                if (bl4) {
                    this._currentStationHandlePresetListRef = n5;
                }
                boolean bl8 = bl3 = (n4 = currentStation_Handle_Status.presetList_absolutePosition) != this._currentStationHandlePresetListAbsPos;
                if (bl3) {
                    this._currentStationHandlePresetListAbsPos = n4;
                }
                bl = bl5 || bl4 || bl3;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        int n = (Integer)object;
        if (this._storeBapInfoData(n, bAPEntity)) {
            this._notifyServiceDelegates(n);
        }
    }

    @Override
    public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
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

