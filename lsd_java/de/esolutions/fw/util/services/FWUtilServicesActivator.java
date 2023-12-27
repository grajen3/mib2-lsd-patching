/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services;

import de.esolutions.fw.util.commons.error.DefaultFatalErrorHandler;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.SystemTimeSource;
import de.esolutions.fw.util.services.RecurseErrorTestCallback;
import de.esolutions.fw.util.services.ServicesConfigProvider;
import de.esolutions.fw.util.services.gctracing.GCTracing;
import de.esolutions.fw.util.services.job.DispatcherManager;
import de.esolutions.fw.util.services.threading.ThreadPoolManager;
import de.esolutions.fw.util.services.tracing.FwServicesTracing;
import de.esolutions.fw.util.tracing.TraceClient;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class FWUtilServicesActivator
implements BundleActivator {
    private ServiceReference srefTimeSource;
    private ITimeSource timeSource;
    private ServicesConfigProvider configProvider;
    private ThreadPoolManager threadPoolManager;
    private ServiceRegistration threadPoolManagerService;
    private ServiceRegistration dumpInfoProvService;
    private DispatcherManager dispatcherManager;
    private ServiceRegistration dispatcherManagerService;
    private IFatalErrorHandler fatalErrorHandler;
    private ServiceRegistration fatalErrorHandlerService;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$timeout$ITimeSource;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$threading$IThreadPoolManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$job$IDispatcherManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$IFatalErrorHandler;

    @Override
    public void start(BundleContext bundleContext) {
        TraceClient.init("hmi");
        try {
            this.srefTimeSource = bundleContext.getServiceReference((class$de$esolutions$fw$util$commons$timeout$ITimeSource == null ? (class$de$esolutions$fw$util$commons$timeout$ITimeSource = FWUtilServicesActivator.class$("de.esolutions.fw.util.commons.timeout.ITimeSource")) : class$de$esolutions$fw$util$commons$timeout$ITimeSource).getName());
            if (this.srefTimeSource != null) {
                this.timeSource = (ITimeSource)bundleContext.getService(this.srefTimeSource);
            }
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
        if (this.timeSource == null) {
            this.timeSource = new SystemTimeSource();
        }
        this.configProvider = new ServicesConfigProvider();
        this.registerFatalErrorHandler(bundleContext, this.configProvider);
        this.threadPoolManager = new ThreadPoolManager(this.configProvider.getThreadPoolsConfig(), this.timeSource);
        this.threadPoolManagerService = bundleContext.registerService((class$de$esolutions$fw$util$commons$threading$IThreadPoolManager == null ? (class$de$esolutions$fw$util$commons$threading$IThreadPoolManager = FWUtilServicesActivator.class$("de.esolutions.fw.util.commons.threading.IThreadPoolManager")) : class$de$esolutions$fw$util$commons$threading$IThreadPoolManager).getName(), (Object)this.threadPoolManager, (Dictionary)new Hashtable());
        this.dumpInfoProvService = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = FWUtilServicesActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)this.threadPoolManager, null);
        this.dispatcherManager = new DispatcherManager(this.configProvider.getDispatchersConfig(), this.timeSource, this.threadPoolManager, bundleContext);
        if (this.configProvider.getGCTracingEnabled()) {
            try {
                Class.forName("com.microdoc.j9.IGCListener");
                GCTracing.activate();
            }
            catch (Throwable throwable) {
                FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "garbage collector tracing is not available! reason=%1", throwable);
            }
        } else {
            FwServicesTracing.GARBAGE_COLLECTOR.log((short)2, "garbage collector tracing is not activated");
        }
        this.dispatcherManagerService = bundleContext.registerService((class$de$esolutions$fw$util$commons$job$IDispatcherManager == null ? (class$de$esolutions$fw$util$commons$job$IDispatcherManager = FWUtilServicesActivator.class$("de.esolutions.fw.util.commons.job.IDispatcherManager")) : class$de$esolutions$fw$util$commons$job$IDispatcherManager).getName(), (Object)this.dispatcherManager, (Dictionary)new Hashtable());
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.registerCallback("test_recurse", new RecurseErrorTestCallback());
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.unregisterFatalErrorHandler();
        if (this.dispatcherManagerService != null) {
            this.dispatcherManagerService.unregister();
        }
        if (this.threadPoolManagerService != null) {
            this.threadPoolManagerService.unregister();
        }
        if (this.dumpInfoProvService != null) {
            this.dumpInfoProvService.unregister();
        }
        if (this.srefTimeSource != null) {
            bundleContext.ungetService(this.srefTimeSource);
        }
        this.dispatcherManager = null;
        this.dispatcherManagerService = null;
        this.dumpInfoProvService = null;
        this.threadPoolManager = null;
        this.threadPoolManagerService = null;
        this.configProvider = null;
        this.srefTimeSource = null;
        this.timeSource = null;
        this.fatalErrorHandler = null;
    }

    private void registerFatalErrorHandler(BundleContext bundleContext, ServicesConfigProvider servicesConfigProvider) {
        boolean bl = servicesConfigProvider.getKillOnError();
        this.fatalErrorHandler = new DefaultFatalErrorHandler(bl);
        this.fatalErrorHandlerService = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$IFatalErrorHandler == null ? (class$de$esolutions$fw$util$commons$error$IFatalErrorHandler = FWUtilServicesActivator.class$("de.esolutions.fw.util.commons.error.IFatalErrorHandler")) : class$de$esolutions$fw$util$commons$error$IFatalErrorHandler).getName(), (Object)this.fatalErrorHandler, (Dictionary)new Hashtable());
    }

    private void unregisterFatalErrorHandler() {
        if (this.fatalErrorHandlerService != null) {
            this.fatalErrorHandlerService.unregister();
            this.fatalErrorHandlerService = null;
        }
        this.fatalErrorHandler = null;
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

