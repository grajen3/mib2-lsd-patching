/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.animation.control.AnimationManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.repaint.internal.RepaintManagerImpl;
import de.vw.mib.repaint.internal.ServiceManager;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$animation$control$AnimationManager;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$RepaintEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$repaint$RepaintManager;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.eventDispatcher = (FrameworkEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()));
        ServiceManager.animationManager = (AnimationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$animation$control$AnimationManager == null ? (class$de$vw$mib$animation$control$AnimationManager = Activator.class$("de.vw.mib.animation.control.AnimationManager")) : class$de$vw$mib$animation$control$AnimationManager).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$consumer$RepaintEventConsumer == null ? (class$de$vw$mib$event$consumer$RepaintEventConsumer = Activator.class$("de.vw.mib.event.consumer.RepaintEventConsumer")) : class$de$vw$mib$event$consumer$RepaintEventConsumer).getName(), (class$de$vw$mib$repaint$RepaintManager == null ? (class$de$vw$mib$repaint$RepaintManager = Activator.class$("de.vw.mib.repaint.RepaintManager")) : class$de$vw$mib$repaint$RepaintManager).getName()}, (Object)new RepaintManagerImpl(ServiceManager.loggerFactory), null);
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

