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
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.BapTelephoneAdapter$_BapTelephoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneCallInfo;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import java.util.Iterator;
import java.util.List;

public class BapTelephoneAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
BapTelephoneService,
BAPValueObserver {
    private BAPObserverRegistry _bapObserverRegistry;
    private static final int[] BAP_TELEPHONE_PROPERTY_IDS = BapTelephoneDelegate.BAP_TELEPHONE_PROPERTIES;
    private BapTelephoneAdapter$_BapTelephoneCallInfo[] _callInfos;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService = BapTelephoneAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$telephone$BapTelephoneService;
    }

    private BAPObserverRegistry getBapTelephoneObserverRegistry() {
        BAPLogicalControlUnit bAPLogicalControlUnit;
        if (this._bapObserverRegistry == null && (bAPLogicalControlUnit = new BAPInterfaceProvider(ServiceManager.bundleContext).getBapDispatcher().getLogicalControlUnit(40)) != null) {
            this._bapObserverRegistry = bAPLogicalControlUnit.getBapObserverRegistry();
        }
        return this._bapObserverRegistry;
    }

    @Override
    public void register() {
        super.register();
        for (int n : BAP_TELEPHONE_PROPERTY_IDS) {
            this.getBapTelephoneObserverRegistry().getBapValueObservable(n).addObserver(this, new Integer(n));
        }
    }

    @Override
    public void unregister() {
        super.unregister();
        for (int n : BAP_TELEPHONE_PROPERTY_IDS) {
            this.getBapTelephoneObserverRegistry().getBapValueObservable(n).removeObserver(this);
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
        this.getBapTelephoneObserverRegistry().flushAllBapValueObserverables();
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                BapTelephoneDelegate bapTelephoneDelegate = (BapTelephoneDelegate)iterator.next();
                bapTelephoneDelegate.updateBapTelephone(this, n);
            }
        }
    }

    @Override
    public BapTelephoneCallInfo[] getCallInfos() {
        if (this._callInfos == null) {
            this._callInfos = new BapTelephoneAdapter$_BapTelephoneCallInfo[0];
        }
        return this._callInfos;
    }

    private void _storeBapInfoData(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 22: {
                if (this._callInfos == null || this._callInfos.length == 0) {
                    this._callInfos = new BapTelephoneAdapter$_BapTelephoneCallInfo[7];
                }
                CallState_Status callState_Status = (CallState_Status)bAPEntity;
                this._callInfos[0] = new BapTelephoneAdapter$_BapTelephoneCallInfo(1, callState_Status.callState0, callState_Status.callType0);
                this._callInfos[1] = new BapTelephoneAdapter$_BapTelephoneCallInfo(2, callState_Status.callState1, callState_Status.callType1);
                this._callInfos[2] = new BapTelephoneAdapter$_BapTelephoneCallInfo(3, callState_Status.callState2, callState_Status.callType2);
                this._callInfos[3] = new BapTelephoneAdapter$_BapTelephoneCallInfo(4, callState_Status.callState3, callState_Status.callType3);
                this._callInfos[4] = new BapTelephoneAdapter$_BapTelephoneCallInfo(5, callState_Status.callState4, callState_Status.callType4);
                this._callInfos[5] = new BapTelephoneAdapter$_BapTelephoneCallInfo(6, callState_Status.callState5, callState_Status.callType5);
                this._callInfos[6] = new BapTelephoneAdapter$_BapTelephoneCallInfo(7, callState_Status.callState6, callState_Status.callType6);
                break;
            }
        }
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        int n = (Integer)object;
        this._storeBapInfoData(n, bAPEntity);
        this._notifyServiceDelegates(n);
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

