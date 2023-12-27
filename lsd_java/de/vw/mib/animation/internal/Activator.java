/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.animation.internal.AnimationManagerImpl;
import de.vw.mib.animation.internal.ServiceManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$AnimationEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$animation$control$AnimationManager;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.eventDispatcher = (FrameworkEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$consumer$AnimationEventConsumer == null ? (class$de$vw$mib$event$consumer$AnimationEventConsumer = Activator.class$("de.vw.mib.event.consumer.AnimationEventConsumer")) : class$de$vw$mib$event$consumer$AnimationEventConsumer).getName(), (class$de$vw$mib$animation$control$AnimationManager == null ? (class$de$vw$mib$animation$control$AnimationManager = Activator.class$("de.vw.mib.animation.control.AnimationManager")) : class$de$vw$mib$animation$control$AnimationManager).getName()}, (Object)new AnimationManagerImpl(ServiceManager.loggerFactory), null);
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

