/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.GestureEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.input.internal.InputManagerImpl;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$GestureEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$input$InputManager;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.gestureEventDispatcher = (GestureEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$GestureEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$GestureEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.GestureEventDispatcher")) : class$de$vw$mib$event$dispatcher$GestureEventDispatcher).getName()));
        ServiceManager.viewEventDispatcher = (ViewEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        bundleContext.registerService(new String[]{(class$de$vw$mib$input$InputManager == null ? (class$de$vw$mib$input$InputManager = Activator.class$("de.vw.mib.input.InputManager")) : class$de$vw$mib$input$InputManager).getName()}, (Object)new InputManagerImpl(), null);
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

