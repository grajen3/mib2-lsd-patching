/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.api.carplay.ASLCarPlayFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.OCUServiceProxyConstants;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallApiServices;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallInternalServices;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxy;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller$1;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller$2;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller$ECallServiceNotifier;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

public class ECallServiceProxyMarshaller
implements ECallServiceProxy,
ECallInternalServices,
ECallApiServices,
OCUServiceProxyConstants {
    private boolean _marshallingEnabled = false;
    private IntObjectOptHashMap _quedEvents;
    private ECallServiceProxyMarshaller$ECallServiceNotifier _ecallServiceNotifier;
    private IntObjectOptHashMap _serviceListenerRegistry;
    private int modelOcuServiceState;
    private int modelOcuServiceType;
    private boolean modelOcuEcallManual112Present;
    private int modelOcuCallState;
    private int modelOcuDisconnectReason;
    private int modelOcuCallType;
    private int ocuMenuServiceType;
    private int modelLastOcuCallType;
    private boolean hangupButtonAvailable;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$ECallServiceProxyMarshaller;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$ECallApiServices;

    private static void sendSafe(EventGeneric eventGeneric) {
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private static void triggerService(EventGeneric eventGeneric) {
        if (ServiceManager.eventMain.getServiceRegister().existService(eventGeneric.getServiceId())) {
            ServiceManager.eventMain.getServiceRegister().triggerObserver(eventGeneric.getServiceId(), eventGeneric);
        }
    }

    private void sendSafeInternal(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(1879709440);
        if (this.getMarshallingEnabled()) {
            ECallServiceProxyMarshaller.sendSafe(eventGeneric);
        } else {
            this.getQuedEvents().put(eventGeneric.getReceiverEventId(), eventGeneric);
        }
    }

    private static EventGeneric createPrivateEvent(int n) {
        return ServiceManager.mGenericEventFactory.newEvent(1879709440, 1879709440, n);
    }

    private static EventGeneric createServiceEvent(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n);
        eventGeneric.setReceiverEventId(n);
        return eventGeneric;
    }

    private IntObjectOptHashMap getQuedEvents() {
        if (this._quedEvents == null) {
            this._quedEvents = new IntObjectOptHashMap();
        }
        return this._quedEvents;
    }

    private void clearQueuedEvents() {
        this.getQuedEvents().clear();
    }

    public void marshallingBecomesAvailable() {
        Iterator iterator = this.getQuedEvents().values().iterator();
        while (iterator.hasNext()) {
            EventGeneric eventGeneric = (EventGeneric)iterator.next();
            ECallServiceProxyMarshaller.sendSafe(eventGeneric);
        }
        this.clearQueuedEvents();
    }

    private IntObjectOptHashMap getServiceListenerRegistry() {
        if (this._serviceListenerRegistry == null) {
            this._serviceListenerRegistry = new IntObjectOptHashMap();
        }
        return this._serviceListenerRegistry;
    }

    private ECallServiceProxyMarshaller$ECallServiceNotifier getECallServiceNotifier() {
        if (this._ecallServiceNotifier == null) {
            this._ecallServiceNotifier = new ECallServiceProxyMarshaller$ECallServiceNotifier();
        }
        return this._ecallServiceNotifier;
    }

    private ECallServiceProxyMarshaller$ECallServiceNotifier getECallServiceNotifier(EventGeneric eventGeneric, Method method) {
        int n = eventGeneric.getParamCount();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = eventGeneric.getPrimitiveObject(i2);
            if (objectArray[i2] != null) continue;
            try {
                if (eventGeneric.getParamType(i2) == 12) {
                    objectArray[i2] = eventGeneric.getObject(i2);
                    continue;
                }
                if (eventGeneric.getParamType(i2) != 5) continue;
                objectArray[i2] = eventGeneric.getString(i2);
                continue;
            }
            catch (GenericEventException genericEventException) {
                objectArray[i2] = null;
            }
        }
        ECallServiceProxyMarshaller$ECallServiceNotifier eCallServiceProxyMarshaller$ECallServiceNotifier = this.getECallServiceNotifier();
        eCallServiceProxyMarshaller$ECallServiceNotifier.setMethod(method);
        eCallServiceProxyMarshaller$ECallServiceNotifier.setArgs(objectArray);
        return eCallServiceProxyMarshaller$ECallServiceNotifier;
    }

    @Override
    public void setMarshallingEnabled(boolean bl) {
        if (this._marshallingEnabled != bl) {
            this._marshallingEnabled = bl;
            if (bl) {
                this.marshallingBecomesAvailable();
            }
        }
    }

    private boolean getMarshallingEnabled() {
        return this._marshallingEnabled;
    }

    @Override
    public boolean deMarshallEvent(EventGeneric eventGeneric, ECallInternalServices eCallInternalServices) {
        ECallInternalServices eCallInternalServices2 = eCallInternalServices;
        boolean bl = this.deMarshallEvent(eventGeneric, (OCUService)eCallInternalServices2);
        if (!bl) {
            switch (eventGeneric.getReceiverEventId()) {
                case 14: {
                    this.notifyServiceClientRegistered(eventGeneric.getInt(0), eCallInternalServices);
                    break;
                }
                default: {
                    bl = this.deMarshallServiceListener(eventGeneric, eCallInternalServices);
                }
            }
        }
        return bl;
    }

    @Override
    public boolean deMarshallEvent(EventGeneric eventGeneric, OCUService oCUService) {
        boolean bl = true;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                oCUService.stateEntry();
                break;
            }
            case 3: {
                oCUService.stateStart();
                break;
            }
            case 4: {
                oCUService.stateExit();
                break;
            }
            case 100000: {
                oCUService.bapStateStatus(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 100001: {
                oCUService.indication(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3), eventGeneric.getInt(4));
                break;
            }
            case 100002: {
                oCUService.indicationVoid(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 100003: {
                oCUService.indicationByteSequence(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getByteArray(3));
                break;
            }
            case 100004: {
                oCUService.indicationError(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 100005: {
                oCUService.acknowledge(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 100006: {
                oCUService.asyncException(eventGeneric.getInt(0), eventGeneric.getString(1), eventGeneric.getInt(2));
                break;
            }
            case 100007: {
                oCUService.initialize();
                break;
            }
            case 100008: {
                oCUService.request(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3));
                break;
            }
            case 100009: {
                oCUService.requestVoid(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 100010: {
                oCUService.requestByteSequence(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getByteArray(2));
                break;
            }
            case 100011: {
                oCUService.requestError(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void registerServiceListener(Class clazz, int[] nArray) {
        IntObjectOptHashMap intObjectOptHashMap = this.getServiceListenerRegistry();
        if (nArray.length > 0 && intObjectOptHashMap.get(nArray[0]) == null) {
            Object[] objectArray = clazz.getDeclaredMethods();
            if (!$assertionsDisabled && objectArray.length != nArray.length) {
                throw new AssertionError((Object)"Incompatible service constants");
            }
            Arrays.sort(objectArray, new ECallServiceProxyMarshaller$1(this));
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                intObjectOptHashMap.put(nArray[i2], objectArray[i2]);
            }
        }
    }

    @Override
    public void unregisterServiceListener(Class clazz, int[] nArray) {
        IntObjectOptHashMap intObjectOptHashMap = this.getServiceListenerRegistry();
        if (nArray.length > 0) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                intObjectOptHashMap.remove(nArray[i2]);
            }
        }
    }

    @Override
    public Object getService(Class clazz) {
        ECallServiceProxyMarshaller eCallServiceProxyMarshaller = Arrays.asList((class$de$vw$mib$asl$internal$ocu$ecall$api$ECallApiServices == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$ECallApiServices = ECallServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.ecall.api.ECallApiServices")) : class$de$vw$mib$asl$internal$ocu$ecall$api$ECallApiServices).getInterfaces()).contains(clazz) ? this : null;
        return eCallServiceProxyMarshaller;
    }

    @Override
    public boolean deMarshallServiceListener(EventGeneric eventGeneric, ServiceListenerNotifier serviceListenerNotifier) {
        boolean bl;
        Method method = (Method)this.getServiceListenerRegistry().get(eventGeneric.getReceiverEventId());
        if (method != null) {
            serviceListenerNotifier.notifyServiceListener(method.getDeclaringClass(), this.getECallServiceNotifier(eventGeneric, method));
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    private boolean notifyServiceClientRegistered(int n, ServiceListenerNotifier serviceListenerNotifier) {
        boolean bl;
        Method method = (Method)this.getServiceListenerRegistry().get(n);
        if (method != null) {
            serviceListenerNotifier.notifyServiceListener(method.getDeclaringClass(), new ECallServiceProxyMarshaller$2(this, n));
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1601830656);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1585053440);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        eventGeneric.setInt(4, n5);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1568276224);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1551499008);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setByteArray(3, byArray);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1534721792);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1517944576);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1501167360);
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void initialize() {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1484390144);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void request(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1467612928);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestVoid(int n, int n2) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1450835712);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestByteSequence(int n, int n2, byte[] byArray) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1434058496);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setByteArray(2, byArray);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestError(int n, int n2) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createPrivateEvent(-1417281280);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void stateEntry() {
        throw new UnsupportedOperationException("stateEntry shall be called only from proxy marshaller");
    }

    @Override
    public void stateStart() {
        throw new UnsupportedOperationException("stateStart shall be called only from proxy marshaller");
    }

    @Override
    public void stateExit() {
        throw new UnsupportedOperationException("stateExit shall be called only from proxy marshaller");
    }

    @Override
    public void notifyServiceListener(Class clazz, ServiceNotifier serviceNotifier) {
        throw new UnsupportedOperationException("notifyServiceListener shall be called only from proxy marshaller");
    }

    @Override
    public void requestConnection(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setSenderEventId(-1400504064);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, false);
        eventGeneric.setBoolean(2, false);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void releaseConnection(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
        eventGeneric.setInt(0, n);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void phoneCallHangupAll() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1695664640);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void phoneActivateDeactivatePhoneFunctionality(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1561446912);
        eventGeneric.setBoolean(0, bl);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void updateOcuCallType(int n) {
        this.modelOcuCallType = n;
        int n2 = this.ocuMenuServiceType == 0 ? this.modelOcuCallType : this.modelOcuServiceType;
        if (this.modelLastOcuCallType != n2) {
            this.modelLastOcuCallType = n2;
            ServiceManager.aslPropertyManager.valueChangedInteger(-763161344, this.modelLastOcuCallType);
        }
    }

    @Override
    public void updateOcuCallState(int n) {
        this.modelOcuCallState = n;
        int n2 = this.ocuMenuServiceType == 0 ? this.modelOcuCallState : (this.ocuMenuServiceType == 1 && (this.modelOcuServiceState == 2 && this.modelOcuCallState == 5 || this.modelOcuEcallManual112Present) ? 0 : (this.ocuMenuServiceType == 1 ? this.modelOcuCallState : (this.ocuMenuServiceType == 2 && this.modelOcuServiceState == -1 ? 1 : (this.ocuMenuServiceType == 2 ? 0 : this.modelOcuCallState))));
        ServiceManager.aslPropertyManager.valueChangedInteger(310646016, n2);
        this.updateDisconnectReason(this.modelOcuDisconnectReason);
        this._updateServiceStateToModel();
    }

    @Override
    public void updateOcu2Available(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(126096640, bl);
    }

    @Override
    public void updateSupportedServices(boolean bl, boolean bl2, boolean bl3) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(394532096, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(411309312, bl2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(377754880, bl3);
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createServiceEvent(-1856483584);
        eventGeneric.setBoolean(0, bl);
        eventGeneric.setBoolean(1, bl2);
        eventGeneric.setBoolean(2, bl3);
        ECallServiceProxyMarshaller.triggerService(eventGeneric);
    }

    @Override
    public void updateHangupAvailable(boolean bl) {
        this.hangupButtonAvailable = bl;
        if (this.modelOcuServiceType == 4 || this.modelOcuServiceType == 3) {
            this.hangupButtonAvailable = true;
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(109319424, this.hangupButtonAvailable);
    }

    @Override
    public void updateSignalStrength(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(75764992, n);
    }

    @Override
    public void informPhoneCallTerminatedByError(int n) {
        switch (n) {
            case 4: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-360508160);
                break;
            }
            case 1: 
            case 2: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-343730944);
                break;
            }
            default: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-377285376);
            }
        }
    }

    @Override
    public void informServiceCallNotLicensed() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-528280320);
    }

    @Override
    public void informUsmConfirmationPending(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(495195392, bl);
    }

    @Override
    public void updateEmergencyCallRequested(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(444863744, bl);
    }

    @Override
    public void updateServiceState(int n, int n2) {
        this.modelOcuServiceState = n;
        this.modelOcuServiceType = n2;
        this.updateOcuCallType(this.modelOcuCallType);
        this.updateOcuCallState(this.modelOcuCallState);
        this.updateHangupAvailable(this.hangupButtonAvailable);
    }

    private void _updateServiceStateToModel() {
        int n = this.ocuMenuServiceType == 2 ? (this.modelOcuServiceState == -1 ? 0 : this.modelOcuServiceState) : (this.ocuMenuServiceType == 1 && this.modelOcuEcallManual112Present ? 8 : (this.modelOcuServiceState == 2 && this.modelOcuCallState == 5 ? this.modelOcuServiceState : 0));
        ServiceManager.aslPropertyManager.valueChangedInteger(360977664, n);
    }

    @Override
    public void updateDisconnectReason(int n) {
        this.modelOcuDisconnectReason = n;
        int n2 = this.modelOcuCallState == 6 ? n : 0;
        ServiceManager.aslPropertyManager.valueChangedInteger(327423232, n2);
    }

    @Override
    public void updateOcuManualECall112Present(boolean bl) {
        this.modelOcuEcallManual112Present = bl;
        this.updateServiceState(this.modelOcuServiceState, this.modelOcuServiceType);
    }

    @Override
    public void updateOcuMenuServiceType(int n) {
        if (this.ocuMenuServiceType != n) {
            this.ocuMenuServiceType = n;
            this.updateServiceState(this.modelOcuServiceState, this.modelOcuServiceType);
        }
    }

    @Override
    public void carPlayHangupAllCalls() {
        if (ASLCarPlayFactory.getCarPlayApi().getServices() != null && ASLCarPlayFactory.getCarPlayApi().getServices().isReady()) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-2087888128);
            ECallServiceProxyMarshaller.sendSafe(eventGeneric);
        }
    }

    @Override
    public void androidAutoHangupAllCalls() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1046848000);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void smartphoneIntegrationEstablishConnection() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(689200384);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void smartphoneIntegrationQuitConnection() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(705977600);
        ECallServiceProxyMarshaller.sendSafe(eventGeneric);
    }

    @Override
    public void updateECallOperationState(boolean bl) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createServiceEvent(-1890038016);
        eventGeneric.setBoolean(0, bl);
        ECallServiceProxyMarshaller.triggerService(eventGeneric);
    }

    @Override
    public void updateRegisterState(boolean bl) {
        EventGeneric eventGeneric = ECallServiceProxyMarshaller.createServiceEvent(-1873260800);
        eventGeneric.setBoolean(0, bl);
        ECallServiceProxyMarshaller.triggerService(eventGeneric);
    }

    @Override
    public void updateOcuServiceModeVisibility(boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$ocu$ecall$api$ECallServiceProxyMarshaller == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$ECallServiceProxyMarshaller = ECallServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller")) : class$de$vw$mib$asl$internal$ocu$ecall$api$ECallServiceProxyMarshaller).desiredAssertionStatus();
    }
}

