/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.ServiceRetriever;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.internal.generated.SpeechConfiguration;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

final class SpeechServiceManager
extends ServiceRetriever
implements FrameworkServices {
    private Services SSM_ASL_API_SERVICES = null;
    private AsyncServiceFactory SSM_ASYNC_SERVICE_FACTORY = null;
    private ConfigurationManager SSM_CONFIGURATION_MANAGER = null;
    private ThreadSwitchingTarget SSM_THREAD_SWITCHING_TARGET = null;
    private TimerManager SSM_TIMER_MANAGER = null;
    private Framework4U SSM_FRAMEWORK_4_U = null;
    private SystemEventDispatcher SSM_SYSTEM_EVENT_DISPATCHER = null;
    private FrameworkEventDispatcher SSM_FRAMEWORK_EVENT_DISPATCHER = null;
    private SpeechConfiguration SSM_CONFIGURATION;
    private static String SSM_ASYNC_SERVICE_FACTORY_FILTER = "(MIBThreadId=3)";
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$framework4u$Framework4U;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$configuration$internal$generated$SpeechConfiguration;

    SpeechServiceManager(BundleContext bundleContext, Services services) {
        super(bundleContext);
        this.SSM_ASL_API_SERVICES = services;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        if (this.SSM_ASYNC_SERVICE_FACTORY == null) {
            this.SSM_ASYNC_SERVICE_FACTORY = (AsyncServiceFactory)this.retrieveService(class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = SpeechServiceManager.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory, SSM_ASYNC_SERVICE_FACTORY_FILTER);
        }
        return this.SSM_ASYNC_SERVICE_FACTORY;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        if (this.SSM_THREAD_SWITCHING_TARGET == null) {
            this.SSM_THREAD_SWITCHING_TARGET = (ThreadSwitchingTarget)this.retrieveService(class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = SpeechServiceManager.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget);
        }
        return this.SSM_THREAD_SWITCHING_TARGET;
    }

    @Override
    public TimerManager getTimerManager() {
        if (this.SSM_TIMER_MANAGER == null) {
            this.SSM_TIMER_MANAGER = (TimerManager)this.retrieveService(class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = SpeechServiceManager.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager);
        }
        return this.SSM_TIMER_MANAGER;
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        if (this.SSM_CONFIGURATION_MANAGER == null) {
            this.SSM_CONFIGURATION_MANAGER = (ConfigurationManager)this.retrieveService(class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = SpeechServiceManager.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager);
        }
        return this.SSM_CONFIGURATION_MANAGER;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        if (this.SSM_SYSTEM_EVENT_DISPATCHER == null) {
            this.SSM_SYSTEM_EVENT_DISPATCHER = (SystemEventDispatcher)this.retrieveService(class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = SpeechServiceManager.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher, null);
        }
        return this.SSM_SYSTEM_EVENT_DISPATCHER;
    }

    public Services getApiServices() {
        return this.SSM_ASL_API_SERVICES;
    }

    @Override
    public Framework4U getFramework4u() {
        if (this.SSM_FRAMEWORK_4_U == null) {
            this.SSM_FRAMEWORK_4_U = (Framework4U)this.retrieveService(class$de$vw$mib$framework4u$Framework4U == null ? (class$de$vw$mib$framework4u$Framework4U = SpeechServiceManager.class$("de.vw.mib.framework4u.Framework4U")) : class$de$vw$mib$framework4u$Framework4U, null);
        }
        return this.SSM_FRAMEWORK_4_U;
    }

    @Override
    public FrameworkEventDispatcher getFrameworkEventDispatcher() {
        if (this.SSM_FRAMEWORK_EVENT_DISPATCHER == null) {
            this.SSM_FRAMEWORK_EVENT_DISPATCHER = (FrameworkEventDispatcher)this.retrieveService(class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = SpeechServiceManager.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher, null);
        }
        return this.SSM_FRAMEWORK_EVENT_DISPATCHER;
    }

    @Override
    public SpeechConfiguration getSpeechConfiguration() {
        if (this.SSM_CONFIGURATION == null) {
            this.SSM_CONFIGURATION = (SpeechConfiguration)this.retrieveService(class$de$vw$mib$configuration$internal$generated$SpeechConfiguration == null ? (class$de$vw$mib$configuration$internal$generated$SpeechConfiguration = SpeechServiceManager.class$("de.vw.mib.configuration.internal.generated.SpeechConfiguration")) : class$de$vw$mib$configuration$internal$generated$SpeechConfiguration, null);
        }
        return this.SSM_CONFIGURATION;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
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

