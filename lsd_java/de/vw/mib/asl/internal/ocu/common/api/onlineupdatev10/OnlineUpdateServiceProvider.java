/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10;

import de.vw.mib.asl.api.ocu.ecall.ECallServiceProvider;
import de.vw.mib.asl.api.ocu.eni.ENIServiceProvider;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxy;
import de.vw.mib.asl.internal.ocu.eni.api.EniServiceProxy;
import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;

public class OnlineUpdateServiceProvider
extends AbstractTarget
implements de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceProvider,
ServiceListenerNotifier,
OnlineUpdateService$IteratorProvider {
    private de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService onlineUpdateService;
    private HashSet serviceListenerRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener;

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    private EniServiceProxy getEniServiceProxy() {
        return (EniServiceProxy)((Object)ENIServiceProvider.getENIService(ENIServiceProvider.ENI_SERVICE_VERSION_1_0));
    }

    private ECallServiceProxy getECallServiceProxy() {
        return (ECallServiceProxy)((Object)ECallServiceProvider.getECallService(ECallServiceProvider.ECALL_SERVICE_VERSION_1_0));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        this.getEniServiceProxy().deMarshallServiceListener(eventGeneric, this);
        this.getECallServiceProxy().deMarshallServiceListener(eventGeneric, this);
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService getOnlineUpdateService() {
        if (this.onlineUpdateService == null) {
            this.onlineUpdateService = new OnlineUpdateService(this);
            try {
                this.register(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), 1963595520, "hsmtask");
            }
            catch (Exception exception) {
                this.getTextLogger().error(this.getSubClassifier(), "Can't start OnlineUpdateService target", exception);
            }
        }
        return this.onlineUpdateService;
    }

    @Override
    public void registerOnlineUpdateServiceListener(OnlineUpdateServiceListener onlineUpdateServiceListener) {
        if (this.getServiceListenerRegistry().isEmpty()) {
            this.getOnlineUpdateService();
            this.registerForServices();
        }
        this.getServiceListenerRegistry().add(onlineUpdateServiceListener);
    }

    @Override
    public void unRegisterOnlineUpdateServiceListener(OnlineUpdateServiceListener onlineUpdateServiceListener) {
        this.getServiceListenerRegistry().remove(onlineUpdateServiceListener);
        if (this.getServiceListenerRegistry().isEmpty()) {
            this.unRegisterForServices();
        }
    }

    private void _registerForServices(Class clazz, int[] nArray) {
        this.addObservers(nArray);
    }

    private void registerForServices() {
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener, OnlineUpdateListServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener, CurrentOnlineUpdateStateServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener, ChallengeDataServiceListener.SERVICE_CONSTANTS);
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener, RemoteProcessServiceListener.SERVICE_CONSTANTS);
    }

    private void _unregisterServices(Class clazz, int[] nArray) {
        this.removeObservers(nArray);
    }

    private void unRegisterForServices() {
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener, OnlineUpdateListServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener, CurrentOnlineUpdateStateServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener, ChallengeDataServiceListener.SERVICE_CONSTANTS);
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener = OnlineUpdateServiceProvider.class$("de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$RemoteProcessServiceListener, RemoteProcessServiceListener.SERVICE_CONSTANTS);
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
            serviceNotifier.notifyServiceListener(this.getOnlineUpdateService());
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

