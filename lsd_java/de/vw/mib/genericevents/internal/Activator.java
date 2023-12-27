/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.genericevents.GenericEventFactory;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.diag.GenericEventTracer;
import de.vw.mib.genericevents.diag.HsmStateTracer;
import de.vw.mib.genericevents.impl.GenericEventsImpl;
import de.vw.mib.genericevents.impl.ThreadSwitchingTargetImpl;
import de.vw.mib.genericevents.internal.ASLDownEventServiceImpl;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.threads.internal.AsyncServiceFactoryImpl;
import de.vw.mib.timer.TimerManager;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivatorExtension,
ServiceListener {
    public static final String ACTIVATE_POOLING;
    private BundleContext context;
    private boolean preloaded = false;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$coreapi$client$ASLDownEventService;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$diag$GenericEventTracer;
    static /* synthetic */ Class class$de$vw$mib$genericevents$diag$HsmStateTracer;

    @Override
    public void preload(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.logManager = (LogManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()));
        ServiceManager.mLogger = ServiceManager.loggerFactory.getLogger(128);
        ServiceManager.errorHandler = (ErrorHandler)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        ServiceManager.mTimerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceManager.mThreadManager = (MIBThreadManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName()));
        ServiceManager.mEventContext = new GenericEventsImpl(ServiceManager.loggerFactory);
        bundleContext.registerService((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = Activator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName(), (Object)ServiceManager.mEventContext, null);
        if (Boolean.getBoolean("GenericEvents.activatePooling")) {
            ServiceManager.mEventFactory = new GenericEventFactory();
        }
        bundleContext.registerService((class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = Activator.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory).getName(), (Object)ServiceManager.mEventFactory, null);
        if (bundleContext.getServiceReference((class$de$vw$mib$coreapi$client$ASLDownEventService == null ? (class$de$vw$mib$coreapi$client$ASLDownEventService = Activator.class$("de.vw.mib.coreapi.client.ASLDownEventService")) : class$de$vw$mib$coreapi$client$ASLDownEventService).getName()) == null) {
            bundleContext.registerService((class$de$vw$mib$coreapi$client$ASLDownEventService == null ? (class$de$vw$mib$coreapi$client$ASLDownEventService = Activator.class$("de.vw.mib.coreapi.client.ASLDownEventService")) : class$de$vw$mib$coreapi$client$ASLDownEventService).getName(), (Object)new ASLDownEventServiceImpl(ServiceManager.mEventFactory, ServiceManager.mEventContext.getServiceRegister()), null);
        }
        TaskInterface taskInterface = ServiceManager.mEventContext.createAsyncTask("hsmtask");
        ServiceManager.mThreadManager.createThread(3, (MIBRunnable)((Object)taskInterface));
        taskInterface.start();
        ThreadSwitchingTargetImpl threadSwitchingTargetImpl = new ThreadSwitchingTargetImpl(ServiceManager.mEventContext, taskInterface);
        ServiceManager.mEventContext.getEventDispatcher().registerTarget(threadSwitchingTargetImpl, "hsmtask");
        Properties properties = new Properties();
        properties.put("genericEvents.task", "hsmtask");
        bundleContext.registerService((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName(), (Object)threadSwitchingTargetImpl, (Dictionary)properties);
        AsyncServiceFactoryImpl asyncServiceFactoryImpl = new AsyncServiceFactoryImpl(threadSwitchingTargetImpl);
        properties = new Properties();
        properties.put("MIBThreadId", String.valueOf(3));
        bundleContext.registerService((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), (Object)asyncServiceFactoryImpl, (Dictionary)properties);
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("(|");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$genericevents$diag$GenericEventTracer == null ? (class$de$vw$mib$genericevents$diag$GenericEventTracer = Activator.class$("de.vw.mib.genericevents.diag.GenericEventTracer")) : class$de$vw$mib$genericevents$diag$GenericEventTracer).getName()).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$genericevents$diag$HsmStateTracer == null ? (class$de$vw$mib$genericevents$diag$HsmStateTracer = Activator.class$("de.vw.mib.genericevents.diag.HsmStateTracer")) : class$de$vw$mib$genericevents$diag$HsmStateTracer).getName()).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences((class$de$vw$mib$genericevents$diag$GenericEventTracer == null ? (class$de$vw$mib$genericevents$diag$GenericEventTracer = Activator.class$("de.vw.mib.genericevents.diag.GenericEventTracer")) : class$de$vw$mib$genericevents$diag$GenericEventTracer).getName(), null);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
        this.preloaded = true;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.context.getService(serviceEvent.getServiceReference());
        if (object instanceof GenericEventTracer) {
            ServiceManager.eventTracer = serviceEvent.getType() == 1 ? (GenericEventTracer)object : GenericEventTracer.EMPTY_TRACER;
        } else if (object instanceof HsmStateTracer) {
            ServiceManager.hsmTracer = serviceEvent.getType() == 1 ? (HsmStateTracer)object : HsmStateTracer.EMPTY_TRACER;
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
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

