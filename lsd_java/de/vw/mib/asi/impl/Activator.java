/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.esolutions.fw.comm.agent.Agent;
import de.vw.mib.asi.ASIPropertiesImpl;
import de.vw.mib.asi.impl.ASIInstanceImpl;
import de.vw.mib.asi.impl.ASIServiceFactory;
import de.vw.mib.asi.impl.ASIServiceRegistryImpl;
import de.vw.mib.asi.impl.Activator$AgentStateListener;
import de.vw.mib.asi.impl.ClassifiedLoggerImpl;
import de.vw.mib.asi.instance.ASIInstance;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private static final String LOG_PREFIX;
    private static final int INSTANCE_SERVICE_INSTANCE_ID;
    private BundleContext context;
    private ServiceReference srLoggerFactory;
    private ClassifiedLogger clogger;
    private ASIServiceFactory factory;
    private ASIServiceRegistryImpl registry;
    private ServiceRegistration srRegistry;
    private Activator$AgentStateListener stateListener;
    private ASIInstance instanceService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asi$instance$ASIInstance;
    static /* synthetic */ Class class$de$vw$mib$asi$ASIServiceRegistry;

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.srLoggerFactory = this.context.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        Logger logger = null != this.srLoggerFactory ? ((LoggerFactory)this.context.getService(this.srLoggerFactory)).getLogger(5) : null;
        this.clogger = new ClassifiedLoggerImpl(logger, 1, "[ASIAdapter] ");
        this.clogger.normal().append("ASI Adapter started").log();
        this.factory = new ASIServiceFactory(this.clogger);
        this.registry = new ASIServiceRegistryImpl(this.context, this.factory, this.clogger);
        this.registry.start();
        this.stateListener = new Activator$AgentStateListener(this.clogger);
        Agent.registerAgentStateListener(this.stateListener);
        this.instanceService = new ASIInstanceImpl(this.registry);
        this.registry.registerAllDevicesService(class$de$vw$mib$asi$instance$ASIInstance == null ? (class$de$vw$mib$asi$instance$ASIInstance = Activator.class$("de.vw.mib.asi.instance.ASIInstance")) : class$de$vw$mib$asi$instance$ASIInstance, 0, this.instanceService, new ASIPropertiesImpl());
        this.srRegistry = this.context.registerService((class$de$vw$mib$asi$ASIServiceRegistry == null ? (class$de$vw$mib$asi$ASIServiceRegistry = Activator.class$("de.vw.mib.asi.ASIServiceRegistry")) : class$de$vw$mib$asi$ASIServiceRegistry).getName(), (Object)this.registry, (Dictionary)null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (null != this.registry) {
            if (null != this.instanceService) {
                this.registry.unregisterService(class$de$vw$mib$asi$instance$ASIInstance == null ? (class$de$vw$mib$asi$instance$ASIInstance = Activator.class$("de.vw.mib.asi.instance.ASIInstance")) : class$de$vw$mib$asi$instance$ASIInstance, 0);
            }
            if (null != this.srRegistry) {
                this.srRegistry.unregister();
            }
            this.registry.stop();
        }
        this.instanceService = null;
        this.srRegistry = null;
        this.registry = null;
        this.factory = null;
        if (null != this.stateListener) {
            Agent.unregisterAgentStateListener(this.stateListener);
        }
        if (null != this.srLoggerFactory) {
            bundleContext.ungetService(this.srLoggerFactory);
            this.srLoggerFactory = null;
        }
        this.context = null;
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

