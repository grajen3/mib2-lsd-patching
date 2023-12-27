/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.ASIServiceProvider;
import de.vw.mib.asi.ASIServiceRegistry;
import de.vw.mib.asi.impl.ASIInstanceHandler;
import de.vw.mib.asi.impl.ASIInstanceHandlerFactory;
import de.vw.mib.asi.impl.ASIServiceFactory;
import de.vw.mib.asi.impl.ASIServiceRegistryImpl$ASIServiceProviderListener;
import de.vw.mib.asi.instance.ASIInstanceResponse;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

class ASIServiceRegistryImpl
implements ASIServiceRegistry {
    private final BundleContext context;
    private final ClassifiedLogger clogger;
    private final ASIServiceFactory serviceFactory;
    private final ASIInstanceHandlerFactory handlerFactory;
    private final Map instanceHandlers = new HashMap();
    private final ServiceListener providerListener = new ASIServiceRegistryImpl$ASIServiceProviderListener(this);
    static /* synthetic */ Class class$de$vw$mib$asi$ASIServiceProvider;

    ASIServiceRegistryImpl(BundleContext bundleContext, ASIServiceFactory aSIServiceFactory, ClassifiedLogger classifiedLogger) {
        this.context = bundleContext;
        this.clogger = classifiedLogger;
        this.serviceFactory = aSIServiceFactory;
        this.handlerFactory = new ASIInstanceHandlerFactory(bundleContext, classifiedLogger, aSIServiceFactory);
    }

    void start() {
        this.clogger.info().append("ASIServiceRegistry started").log();
        this.context.addServiceListener(this.providerListener, new StringBuffer().append("(objectClass=").append((class$de$vw$mib$asi$ASIServiceProvider == null ? (class$de$vw$mib$asi$ASIServiceProvider = ASIServiceRegistryImpl.class$("de.vw.mib.asi.ASIServiceProvider")) : class$de$vw$mib$asi$ASIServiceProvider).getName()).append(")").toString());
    }

    void stop() {
        this.context.removeServiceListener(this.providerListener);
    }

    @Override
    public void registerService(Class clazz, int n, String string, ASIService aSIService, ASIProperties aSIProperties) {
        ASIInstanceHandler aSIInstanceHandler = this.getInstanceHandler(clazz, true);
        aSIInstanceHandler.registerService(n, string, aSIService, aSIProperties);
    }

    @Override
    public void registerAllDevicesService(Class clazz, int n, ASIService aSIService, ASIProperties aSIProperties) {
        this.registerService(clazz, n, "*", aSIService, aSIProperties);
    }

    @Override
    public void unregisterService(Class clazz, int n) {
        ASIInstanceHandler aSIInstanceHandler = this.getInstanceHandler(clazz, false);
        if (null != aSIInstanceHandler) {
            aSIInstanceHandler.unregisterService(n);
        }
    }

    void requestASIInstanceId(String string, String string2, ASIInstanceResponse aSIInstanceResponse) {
        this.clogger.info().append("ASIServiceRegistry#requestInstanceId: asiId=").append(string).append(", deviceId=").append(string2).log();
        Class clazz = this.serviceFactory.getServiceClass(string);
        if (null == clazz) {
            aSIInstanceResponse.responseInstanceId(string, string2, -1, 2);
        } else {
            ASIInstanceHandler aSIInstanceHandler = this.getInstanceHandler(clazz, true);
            aSIInstanceHandler.requestInstanceId(string2, aSIInstanceResponse);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ASIInstanceHandler getInstanceHandler(Class clazz, boolean bl) {
        ASIInstanceHandler aSIInstanceHandler;
        Map map = this.instanceHandlers;
        synchronized (map) {
            aSIInstanceHandler = (ASIInstanceHandler)this.instanceHandlers.get(clazz);
            if (null == aSIInstanceHandler && bl) {
                String string = this.serviceFactory.getASIId(clazz);
                if (null == string) {
                    throw new IllegalArgumentException(new StringBuffer().append("Not a valid ASI service class: ").append(clazz.getName()).toString());
                }
                aSIInstanceHandler = this.handlerFactory.createASIHandler(clazz, string);
                this.instanceHandlers.put(clazz, aSIInstanceHandler);
            }
        }
        return aSIInstanceHandler;
    }

    void providerRegistered(Class clazz, ServiceReference serviceReference) {
        this.getInstanceHandler(clazz, true).setServiceProvider((ASIServiceProvider)this.context.getService(serviceReference));
    }

    void providerUnregistering(Class clazz, ServiceReference serviceReference) {
        ASIInstanceHandler aSIInstanceHandler = this.getInstanceHandler(clazz, false);
        if (null != aSIInstanceHandler) {
            aSIInstanceHandler.setServiceProvider(null);
        }
        this.context.ungetService(serviceReference);
    }

    ClassifiedLogger getLogger() {
        return this.clogger;
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

