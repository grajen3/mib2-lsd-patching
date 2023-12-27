/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10;

import de.vw.mib.asl.api.ocu.ecall.ECallServiceProvider;
import de.vw.mib.asl.api.ocu.eni.ENIServiceProvider;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.OnlineNetworkService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxy;
import de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.EniServiceProxy;
import de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;

public class OnlineNetworkServiceProvider
extends AbstractTarget
implements de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceProvider,
ServiceListenerNotifier,
OnlineNetworkService$IteratorProvider {
    private de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService onlineNetworkService;
    private HashSet serviceListenerRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener;

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        this.getEniServiceProxy().deMarshallServiceListener(eventGeneric, this);
        this.getECallServiceProxy().deMarshallServiceListener(eventGeneric, this);
    }

    private EniServiceProxy getEniServiceProxy() {
        return (EniServiceProxy)((Object)ENIServiceProvider.getENIService(ENIServiceProvider.ENI_SERVICE_VERSION_1_0));
    }

    private ECallServiceProxy getECallServiceProxy() {
        return (ECallServiceProxy)((Object)ECallServiceProvider.getECallService(ECallServiceProvider.ECALL_SERVICE_VERSION_1_0));
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService getOnlineNetworkService() {
        if (this.onlineNetworkService == null) {
            this.onlineNetworkService = new OnlineNetworkService(this);
            try {
                this.register(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), 1913263872, "hsmtask");
            }
            catch (Exception exception) {
                this.getTextLogger().error(this.getSubClassifier(), "Can't start OnlineNetworkService target", exception);
            }
        }
        return this.onlineNetworkService;
    }

    @Override
    public void registerOnlineNetworkServiceListener(OnlineNetworkServiceListener onlineNetworkServiceListener) {
        if (this.getServiceListenerRegistry().size() == 0) {
            this.getOnlineNetworkService();
            this.registerForServices();
        }
        this.getServiceListenerRegistry().add(onlineNetworkServiceListener);
    }

    @Override
    public void unRegisterOnlineNetworkServiceListener(OnlineNetworkServiceListener onlineNetworkServiceListener) {
        this.getServiceListenerRegistry().remove(onlineNetworkServiceListener);
        if (this.getServiceListenerRegistry().size() == 0) {
            this.unRegisterForServices();
        }
    }

    private void _registerForServices(Class clazz, int[] nArray) {
        this.addObservers(nArray);
    }

    private void registerForServices() {
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener, UserListServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener, ServiceListServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener, RemoteProcessServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener, OperationStateServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener, de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener, FunctionSupportServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener, RegisterStateServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener, ActiveMonitoringsServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener, PrivacySetupServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener, ConnectionStateServiceListener.SERVICE_CONSTANTS);
    }

    private void _unregisterServices(Class clazz, int[] nArray) {
        this.removeObservers(nArray);
    }

    private void unRegisterForServices() {
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener, UserListServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener, ServiceListServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener, RemoteProcessServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OperationStateServiceListener, OperationStateServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener, de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.FunctionSupportServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$FunctionSupportServiceListener, FunctionSupportServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.RegisterStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$RegisterStateServiceListener, RegisterStateServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener, ActiveMonitoringsServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.PrivacySetupServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$PrivacySetupServiceListener, PrivacySetupServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener = OnlineNetworkServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ConnectionStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ConnectionStateServiceListener, ConnectionStateServiceListener.SERVICE_CONSTANTS);
    }

    private HashSet getServiceListenerRegistry() {
        if (this.serviceListenerRegistry == null) {
            this.serviceListenerRegistry = new HashSet();
        }
        return this.serviceListenerRegistry;
    }

    @Override
    public void notifyServiceListener(Class clazz, ServiceNotifier serviceNotifier) {
        try {
            serviceNotifier.notifyServiceListener(this.getOnlineNetworkService());
        }
        catch (InvocationTargetException invocationTargetException) {
            this.getTextLogger().error(this.getSubClassifier(), "Error during notify of service listener", invocationTargetException.getCause());
        }
        catch (Exception exception) {
            this.getTextLogger().error(this.getSubClassifier(), "Error during notify of service listener", exception);
        }
    }

    @Override
    public Iterator getIterator() {
        return this.getServiceListenerRegistry().iterator();
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

