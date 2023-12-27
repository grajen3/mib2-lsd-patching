/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.Activator$FWLogger;
import de.vw.mib.asl.framework.internal.framework.Activator$ServiceListenerImpl;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.component.ASLComponentFactoryImpl;
import de.vw.mib.asl.framework.internal.framework.component.ASLComponentRegistryImpl;
import de.vw.mib.asl.framework.internal.framework.speller.ASLAPISpellerFactoryImpl;
import de.vw.mib.asl.internal.ASLDatapoolManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.LoggerFactory;
import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private BundleContext context;
    private Activator$ServiceListenerImpl serviceListener;
    private LoggerFactory loggerFactory;
    private ASLDatapoolManager datapoolManager;
    private ServiceRegistration srPropertyManager;
    private ServiceRegistration srComponentRegistry;
    private ServiceRegistration srAPI;
    private ServiceRegistration srDSIProxy;
    private ServiceRegistration srSpellerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$component$ASLComponentRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$speller$ASLAPISpellerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$list$ASLListManager;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat4Asl;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$ImageManager;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$org$dsi$ifc$base$ServiceAdmin;
    static /* synthetic */ Class class$de$vw$mib$sound$SoundWaveplayer;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$list$DynamicListManager;

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.bundleContext = bundleContext;
        this.loggerFactory = (LoggerFactory)this.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        if (null != this.loggerFactory) {
            ServiceManager.logger = this.loggerFactory.getLogger(1);
            ServiceManager.logger2 = this.loggerFactory.getLogger(32768);
            ServiceManager.dsiTraceLogger = this.loggerFactory.getLogger(16);
            ServiceManager.loggerFW = this.loggerFactory.getLogger(0x1008000);
        }
        ServiceManager.loggerFWCore = new Activator$FWLogger(1, "[ASL-Framework] ");
        ServiceManager.loggerDSIProxy = new Activator$FWLogger(8, "[DSIProxy] ");
        LogMessage logMessage = ServiceManager.loggerFWCore.info();
        if (null != logMessage) {
            logMessage.append("Activator started.").log();
        }
        this.datapoolManager = new ASLDatapoolManager();
        this.srPropertyManager = bundleContext.registerService((class$de$vw$mib$asl$ASLPropertyManager == null ? (class$de$vw$mib$asl$ASLPropertyManager = Activator.class$("de.vw.mib.asl.ASLPropertyManager")) : class$de$vw$mib$asl$ASLPropertyManager).getName(), (Object)this.datapoolManager, (Dictionary)null);
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        ServiceManager.componentFactory = new ASLComponentFactoryImpl(aSLFrameworkAPI.getServices(), this.loggerFactory, ServiceManager.loggerFWCore);
        ServiceManager.componentRegistry = new ASLComponentRegistryImpl();
        ASLFactoryBase.transferAPIs(ServiceManager.componentRegistry);
        this.srComponentRegistry = bundleContext.registerService((class$de$vw$mib$asl$framework$api$framework$component$ASLComponentRegistry == null ? (class$de$vw$mib$asl$framework$api$framework$component$ASLComponentRegistry = Activator.class$("de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry")) : class$de$vw$mib$asl$framework$api$framework$component$ASLComponentRegistry).getName(), (Object)ServiceManager.componentRegistry, (Dictionary)null);
        this.registerServiceListener(this.datapoolManager);
        ASLAPISpellerFactoryImpl aSLAPISpellerFactoryImpl = new ASLAPISpellerFactoryImpl();
        this.srSpellerFactory = bundleContext.registerService((class$de$vw$mib$asl$framework$api$framework$speller$ASLAPISpellerFactory == null ? (class$de$vw$mib$asl$framework$api$framework$speller$ASLAPISpellerFactory = Activator.class$("de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerFactory")) : class$de$vw$mib$asl$framework$api$framework$speller$ASLAPISpellerFactory).getName(), (Object)aSLAPISpellerFactoryImpl, (Dictionary)null);
        ServiceManager.spellerFactory = aSLAPISpellerFactoryImpl;
        this.srAPI = bundleContext.registerService((class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI == null ? (class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI = Activator.class$("de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI")) : class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI).getName(), (Object)aSLFrameworkAPI, (Dictionary)null);
        ServiceManager.componentRegistry.registerAPI(class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI == null ? (class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI = Activator.class$("de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI")) : class$de$vw$mib$asl$framework$api$framework$ASLFrameworkAPI, aSLFrameworkAPI);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (null != this.srAPI) {
            this.srAPI.unregister();
            this.srAPI = null;
        }
        if (null != this.srSpellerFactory) {
            ServiceManager.spellerFactory = null;
            this.srSpellerFactory.unregister();
            this.srSpellerFactory = null;
        }
        if (null != this.srDSIProxy) {
            this.srDSIProxy.unregister();
            this.srDSIProxy = null;
        }
        this.unregisterServiceListener();
        if (null != this.srComponentRegistry) {
            this.srComponentRegistry.unregister();
            this.srComponentRegistry = null;
            ServiceManager.componentRegistry = null;
        }
        if (null != this.srPropertyManager) {
            this.srPropertyManager.unregister();
            this.srPropertyManager = null;
        }
        if (null != this.datapoolManager) {
            this.datapoolManager.setDatapool(null);
            this.datapoolManager = null;
        }
        ServiceManager.loggerDSIProxy = null;
        ServiceManager.loggerFW = null;
        if (null != this.loggerFactory) {
            this.ungetService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
            this.loggerFactory = null;
            ServiceManager.dsiTraceLogger = null;
            ServiceManager.logger2 = null;
            ServiceManager.logger = null;
        }
        this.context = null;
    }

    private Object getService(Class clazz) {
        ServiceReference serviceReference = this.context.getServiceReference(clazz.getName());
        return null != serviceReference ? this.context.getService(serviceReference) : (Object)null;
    }

    private void ungetService(Class clazz) {
        ServiceReference serviceReference = this.context.getServiceReference(clazz.getName());
        if (null != serviceReference) {
            this.context.ungetService(serviceReference);
        }
    }

    private void registerServiceListener(ASLDatapoolManager aSLDatapoolManager) {
        if (null == this.serviceListener) {
            String string = Activator$ServiceListenerImpl.createFilter();
            this.serviceListener = new Activator$ServiceListenerImpl(this.context, aSLDatapoolManager);
            this.context.addServiceListener(this.serviceListener, string);
            ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
            for (int i2 = 0; null != serviceReferenceArray && i2 < serviceReferenceArray.length; ++i2) {
                this.serviceListener.serviceRegistered(serviceReferenceArray[i2]);
            }
        }
    }

    private void unregisterServiceListener() {
        if (null != this.serviceListener) {
            this.context.removeServiceListener(this.serviceListener);
            this.serviceListener = null;
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

