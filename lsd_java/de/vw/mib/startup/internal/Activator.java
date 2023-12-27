/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.event.dispatcher.EventDispatcherManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.startup.internal.ContextStartupManagerImpl;
import de.vw.mib.startup.internal.ServiceManager;
import de.vw.mib.startup.internal.StartupManager;
import de.vw.mib.threads.MIBThreadManager;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivatorExtension {
    private boolean preloaded = false;
    private StartupManager startupManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$EventDispatcherManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$StartupManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$startup$StartupManagerService;
    static /* synthetic */ Class class$de$vw$mib$startup$ContextStartupManager;

    @Override
    public void preload(BundleContext bundleContext) {
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.eventDispatcherManager = (EventDispatcherManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$EventDispatcherManager == null ? (class$de$vw$mib$event$dispatcher$EventDispatcherManager = Activator.class$("de.vw.mib.event.dispatcher.EventDispatcherManager")) : class$de$vw$mib$event$dispatcher$EventDispatcherManager).getName()));
        ServiceManager.frameworkEventDispatcher = (FrameworkEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()));
        ServiceManager.startupEventDispatcher = (StartupEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName()));
        ServiceManager.threadManager = (MIBThreadManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName()));
        this.startupManager = new StartupManager();
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$consumer$StartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$StartupManagerEventConsumer).getName(), (class$de$vw$mib$startup$StartupManagerService == null ? (class$de$vw$mib$startup$StartupManagerService = Activator.class$("de.vw.mib.startup.StartupManagerService")) : class$de$vw$mib$startup$StartupManagerService).getName()}, (Object)this.startupManager, null);
        bundleContext.registerService((class$de$vw$mib$startup$ContextStartupManager == null ? (class$de$vw$mib$startup$ContextStartupManager = Activator.class$("de.vw.mib.startup.ContextStartupManager")) : class$de$vw$mib$startup$ContextStartupManager).getName(), (Object)new ContextStartupManagerImpl(), null);
        this.preloaded = true;
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
        this.startupManager.startManagedBundles();
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

