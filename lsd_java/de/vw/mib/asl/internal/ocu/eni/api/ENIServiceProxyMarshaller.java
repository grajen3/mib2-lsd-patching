/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.api.ocu.eni.ENIService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.OCUServiceProxyConstants;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller$1;
import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller$2;
import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller$3;
import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller$ENIServiceNotifier;
import de.vw.mib.asl.internal.ocu.eni.api.EniInternalServices;
import de.vw.mib.asl.internal.ocu.eni.api.EniServiceProxy;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;

public class ENIServiceProxyMarshaller
implements EniServiceProxy,
ENIService,
EniInternalServices,
OCUServiceProxyConstants,
InvocationHandler {
    private boolean _marshallingEnabled = false;
    private IntObjectOptHashMap _quedEvents;
    private ENIServiceProxyMarshaller$ENIServiceNotifier _eniServiceNotifier;
    private IntObjectOptHashMap _serviceListenerRegistry;
    private ObjectIntOptHashMap _serviceMethodListenerRegistry;
    private Object _eniApiServiceProvider;
    private Object _eniApiServiceListenerProvider;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$ENIServiceProxyMarshaller;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServices;

    private static void sendSafe(EventGeneric eventGeneric) {
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private static void triggerService(EventGeneric eventGeneric) {
        if (ServiceManager.eventMain.getServiceRegister().existService(eventGeneric.getServiceId())) {
            ServiceManager.eventMain.getServiceRegister().triggerObserver(eventGeneric.getServiceId(), eventGeneric);
        }
    }

    private void sendSafeInternal(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(1896486656);
        if (this.getMarshallingEnabled()) {
            ENIServiceProxyMarshaller.sendSafe(eventGeneric);
        } else {
            this.getQuedEvents().put(eventGeneric.getReceiverEventId(), eventGeneric);
        }
    }

    private static EventGeneric createPrivateEvent(int n) {
        return ServiceManager.mGenericEventFactory.newEvent(1896486656, 1896486656, n);
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
            ENIServiceProxyMarshaller.sendSafe(eventGeneric);
        }
        this.clearQueuedEvents();
    }

    private IntObjectOptHashMap getServiceListenerRegistry() {
        if (this._serviceListenerRegistry == null) {
            this._serviceListenerRegistry = new IntObjectOptHashMap();
        }
        return this._serviceListenerRegistry;
    }

    private ObjectIntOptHashMap getServiceMethodListenerRegistry() {
        if (this._serviceMethodListenerRegistry == null) {
            this._serviceMethodListenerRegistry = new ObjectIntOptHashMap();
        }
        return this._serviceMethodListenerRegistry;
    }

    private ENIServiceProxyMarshaller$ENIServiceNotifier getENIServiceNotifier() {
        if (this._eniServiceNotifier == null) {
            this._eniServiceNotifier = new ENIServiceProxyMarshaller$ENIServiceNotifier();
        }
        return this._eniServiceNotifier;
    }

    protected ENIServiceProxyMarshaller$ENIServiceNotifier getENIServiceNotifier(EventGeneric eventGeneric, Method method) {
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
        ENIServiceProxyMarshaller$ENIServiceNotifier eNIServiceProxyMarshaller$ENIServiceNotifier = this.getENIServiceNotifier();
        eNIServiceProxyMarshaller$ENIServiceNotifier.setMethod(method);
        eNIServiceProxyMarshaller$ENIServiceNotifier.setArgs(objectArray);
        return eNIServiceProxyMarshaller$ENIServiceNotifier;
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
    public boolean deMarshallEvent(EventGeneric eventGeneric, EniInternalServices eniInternalServices) {
        EniInternalServices eniInternalServices2 = eniInternalServices;
        boolean bl = this.deMarshallEvent(eventGeneric, (OCUService)eniInternalServices2);
        if (!bl) {
            switch (eventGeneric.getReceiverEventId()) {
                case 14: {
                    this.notifyServiceClientRegistered(eventGeneric.getInt(0), eniInternalServices);
                    break;
                }
                default: {
                    bl = this.deMarshallServiceListener(eventGeneric, eniInternalServices);
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
        ObjectIntOptHashMap objectIntOptHashMap = this.getServiceMethodListenerRegistry();
        if (nArray.length > 0 && intObjectOptHashMap.get(nArray[0]) == null) {
            Object[] objectArray = clazz.getDeclaredMethods();
            if (!$assertionsDisabled && objectArray.length != nArray.length) {
                throw new AssertionError((Object)"Incompatible service constants");
            }
            Arrays.sort(objectArray, new ENIServiceProxyMarshaller$1(this));
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                intObjectOptHashMap.put(nArray[i2], objectArray[i2]);
                objectIntOptHashMap.put(objectArray[i2], nArray[i2]);
            }
        }
    }

    @Override
    public void unregisterServiceListener(Class clazz, int[] nArray) {
        IntObjectOptHashMap intObjectOptHashMap = this.getServiceListenerRegistry();
        ObjectIntOptHashMap objectIntOptHashMap = this.getServiceMethodListenerRegistry();
        if (nArray.length > 0) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                Object object = intObjectOptHashMap.remove(nArray[i2]);
                objectIntOptHashMap.remove(object);
            }
        }
    }

    @Override
    public Object getService(Class clazz) {
        if (Arrays.asList((class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners = ENIServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.eni.api.EniApiServiceListeners")) : class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners).getInterfaces()).contains(clazz)) {
            if (this._eniApiServiceListenerProvider == null) {
                this._eniApiServiceListenerProvider = Proxy.newProxyInstance(super.getClass().getClassLoader(), new Class[]{class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners = ENIServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.eni.api.EniApiServiceListeners")) : class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServiceListeners}, this);
            }
            return this._eniApiServiceListenerProvider;
        }
        return null;
    }

    @Override
    public boolean deMarshallServiceListener(EventGeneric eventGeneric, ServiceListenerNotifier serviceListenerNotifier) {
        boolean bl;
        Method method = null;
        Object[] objectArray = null;
        if (this.getServiceListenerRegistry().containsKey(eventGeneric.getReceiverEventId()) || eventGeneric.getReceiverEventId() == -1182400256) {
            try {
                method = (Method)eventGeneric.getObject(0);
                objectArray = (Object[])eventGeneric.getObject(1);
            }
            catch (GenericEventException genericEventException) {
                throw new RuntimeException(genericEventException.getCause());
            }
        }
        if (method != null) {
            ENIServiceProxyMarshaller$ENIServiceNotifier eNIServiceProxyMarshaller$ENIServiceNotifier = this.getENIServiceNotifier();
            eNIServiceProxyMarshaller$ENIServiceNotifier.setMethod(method);
            eNIServiceProxyMarshaller$ENIServiceNotifier.setArgs(objectArray);
            serviceListenerNotifier.notifyServiceListener(method.getDeclaringClass(), eNIServiceProxyMarshaller$ENIServiceNotifier);
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
            serviceListenerNotifier.notifyServiceListener(method.getDeclaringClass(), new ENIServiceProxyMarshaller$2(this, n));
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1601830656);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1585053440);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        eventGeneric.setInt(4, n5);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1568276224);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1551499008);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setByteArray(3, byArray);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1534721792);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1517944576);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1501167360);
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void initialize() {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1484390144);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void request(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1467612928);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestVoid(int n, int n2) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1450835712);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestByteSequence(int n, int n2, byte[] byArray) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1434058496);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setByteArray(2, byArray);
        this.sendSafeInternal(eventGeneric);
    }

    @Override
    public void requestError(int n, int n2) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createPrivateEvent(-1417281280);
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
    public Object invoke(Object object, Method method, Object[] objectArray) {
        int n = this.getServiceMethodListenerRegistry().get(method);
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.createServiceEvent(n);
        eventGeneric.setObject(0, method);
        eventGeneric.setObject(1, objectArray);
        ENIServiceProxyMarshaller.triggerService(eventGeneric);
        return null;
    }

    @Override
    public Object getEniApiServices() {
        if (this._eniApiServiceProvider == null) {
            this._eniApiServiceProvider = Proxy.newProxyInstance(super.getClass().getClassLoader(), new Class[]{class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServices == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServices = ENIServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.eni.api.EniApiServices")) : class$de$vw$mib$asl$internal$ocu$eni$api$EniApiServices}, new ENIServiceProxyMarshaller$3(this));
        }
        return this._eniApiServiceProvider;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ EventGeneric access$000(int n) {
        return ENIServiceProxyMarshaller.createPrivateEvent(n);
    }

    static /* synthetic */ void access$100(ENIServiceProxyMarshaller eNIServiceProxyMarshaller, EventGeneric eventGeneric) {
        eNIServiceProxyMarshaller.sendSafeInternal(eventGeneric);
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$ocu$eni$api$ENIServiceProxyMarshaller == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$ENIServiceProxyMarshaller = ENIServiceProxyMarshaller.class$("de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller")) : class$de$vw$mib$asl$internal$ocu$eni$api$ENIServiceProxyMarshaller).desiredAssertionStatus();
    }
}

