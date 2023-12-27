/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.voiceservices10;

import de.vw.mib.asl.api.ocu.ecall.ECallServiceProvider;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.common.api.voiceservices10.VoiceService;
import de.vw.mib.asl.internal.ocu.common.api.voiceservices10.VoiceService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxy;
import de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;

public class VoiceServiceProvider
extends AbstractTarget
implements de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceProvider,
ServiceListenerNotifier,
VoiceService$IteratorProvider {
    private de.vw.mib.asl.api.ocu.voiceservices10.VoiceService voiceService;
    private HashSet serviceListenerRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener;

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        this.getECallServiceProxy().deMarshallServiceListener(eventGeneric, this);
    }

    @Override
    public int getClassifier() {
        return 2;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    private ECallServiceProxy getECallServiceProxy() {
        return (ECallServiceProxy)((Object)ECallServiceProvider.getECallService(ECallServiceProvider.ECALL_SERVICE_VERSION_1_0));
    }

    @Override
    public de.vw.mib.asl.api.ocu.voiceservices10.VoiceService getVoiceService() {
        if (this.voiceService == null) {
            this.voiceService = new VoiceService(this);
            try {
                this.register(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), 1946818304, "hsmtask");
            }
            catch (Exception exception) {
                this.getTextLogger().error(this.getSubClassifier(), "Can't start OnlineNetworkService target", exception);
            }
        }
        return this.voiceService;
    }

    @Override
    public void registerVoiceServiceLister(VoiceServiceListener voiceServiceListener) {
        if (this.getServiceListenerRegistry().size() == 0) {
            this.getVoiceService();
            this.registerForServices();
        }
        this.getServiceListenerRegistry().add(voiceServiceListener);
    }

    @Override
    public void unregisterVoiceServiceLister(VoiceServiceListener voiceServiceListener) {
        this.getServiceListenerRegistry().remove(voiceServiceListener);
        if (this.getServiceListenerRegistry().size() == 0) {
            this.unRegisterForServices();
        }
    }

    private void _registerForServices(Class clazz, int[] nArray) {
        this.addObservers(nArray);
    }

    private void registerForServices() {
        this._registerForServices(class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener = VoiceServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener, SupportedServicesListener.SERVICE_CONSTANTS);
    }

    private void _unregisterServices(Class clazz, int[] nArray) {
        this.removeObservers(nArray);
    }

    private void unRegisterForServices() {
        this._unregisterServices(class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener = VoiceServiceProvider.class$("de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$voice$SupportedServicesListener, SupportedServicesListener.SERVICE_CONSTANTS);
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
            serviceNotifier.notifyServiceListener(this.getVoiceService());
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

