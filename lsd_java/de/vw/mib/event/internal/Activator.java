/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.coreapi.asl.SystemEventSender;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.SystemEventIdMap;
import de.vw.mib.event.consumer.ASLStartupManagerEventConsumer;
import de.vw.mib.event.consumer.AnimationEventConsumer;
import de.vw.mib.event.consumer.AppStartupManagerEventConsumer;
import de.vw.mib.event.consumer.BAPSystemEventConsumer;
import de.vw.mib.event.consumer.DatapoolEventConsumer;
import de.vw.mib.event.consumer.GestureEventConsumer;
import de.vw.mib.event.consumer.LSChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackManagerEventConsumer;
import de.vw.mib.event.consumer.PowerStateEventConsumer;
import de.vw.mib.event.consumer.RepaintEventConsumer;
import de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer;
import de.vw.mib.event.consumer.StartupManagerEventConsumer;
import de.vw.mib.event.consumer.StatemachineManagerEventConsumer;
import de.vw.mib.event.consumer.ViewManagerEventConsumer;
import de.vw.mib.event.internal.Activator$PopupStackChangeHandler;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.EventTracerList;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.diag.EventTracer;
import de.vw.mib.event.internal.dispatcher.EventDispatcherManagerImpl;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.threads.internal.AsyncServiceFactoryImpl;
import de.vw.mib.timer.TimerManager;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    private ConfigurationManager configManager;
    private BundleContext context;
    private EventDispatcherManagerImpl dispatcherManager;
    private EventTracerList eventTracerList;
    private final Activator$PopupStackChangeHandler popupStackChangeHandler = new Activator$PopupStackChangeHandler(this);
    static /* synthetic */ Class class$de$vw$mib$event$consumer$AnimationEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$BAPSystemEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$DatapoolEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$LSChangeEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$PowerStateEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$RepaintEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$StartupManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$ViewManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$GestureEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$SystemEventIdMap;
    static /* synthetic */ Class class$de$vw$mib$event$internal$diag$EventTracer;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$EventDispatcherManager;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscUserInteractionFilterService;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$DatapoolEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$coreapi$client$SystemEventListener;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$GestureEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$internal$diag$EventDispatcherDiag;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$coreapi$asl$SystemEventSender;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            Object object;
            block2: {
                object = this.context.getService(serviceEvent.getServiceReference());
                if (serviceEvent.getType() != 1) break block2;
                String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object);
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3], object);
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.getRequiredServices(bundleContext);
        this.createAndRegisterProvidedServices(bundleContext);
        this.dispatcherManager.startStartupDispatchingThread();
        this.addServiceListener(new String[]{(class$de$vw$mib$event$consumer$AnimationEventConsumer == null ? (class$de$vw$mib$event$consumer$AnimationEventConsumer = Activator.class$("de.vw.mib.event.consumer.AnimationEventConsumer")) : class$de$vw$mib$event$consumer$AnimationEventConsumer).getName(), (class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.AppStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.ASLStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$BAPSystemEventConsumer == null ? (class$de$vw$mib$event$consumer$BAPSystemEventConsumer = Activator.class$("de.vw.mib.event.consumer.BAPSystemEventConsumer")) : class$de$vw$mib$event$consumer$BAPSystemEventConsumer).getName(), (class$de$vw$mib$event$consumer$DatapoolEventConsumer == null ? (class$de$vw$mib$event$consumer$DatapoolEventConsumer = Activator.class$("de.vw.mib.event.consumer.DatapoolEventConsumer")) : class$de$vw$mib$event$consumer$DatapoolEventConsumer).getName(), (class$de$vw$mib$event$consumer$LSChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$LSChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.LSChangeEventConsumer")) : class$de$vw$mib$event$consumer$LSChangeEventConsumer).getName(), (class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackChangeEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer).getName(), (class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackManagerEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$PowerStateEventConsumer == null ? (class$de$vw$mib$event$consumer$PowerStateEventConsumer = Activator.class$("de.vw.mib.event.consumer.PowerStateEventConsumer")) : class$de$vw$mib$event$consumer$PowerStateEventConsumer).getName(), (class$de$vw$mib$event$consumer$RepaintEventConsumer == null ? (class$de$vw$mib$event$consumer$RepaintEventConsumer = Activator.class$("de.vw.mib.event.consumer.RepaintEventConsumer")) : class$de$vw$mib$event$consumer$RepaintEventConsumer).getName(), (class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer == null ? (class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer = Activator.class$("de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer")) : class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer).getName(), (class$de$vw$mib$event$consumer$StartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$StartupManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StatemachineManagerEventConsumer")) : class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$ViewManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ViewManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.ViewManagerEventConsumer")) : class$de$vw$mib$event$consumer$ViewManagerEventConsumer).getName(), (class$de$vw$mib$event$consumer$GestureEventConsumer == null ? (class$de$vw$mib$event$consumer$GestureEventConsumer = Activator.class$("de.vw.mib.event.consumer.GestureEventConsumer")) : class$de$vw$mib$event$consumer$GestureEventConsumer).getName(), (class$de$vw$mib$event$SystemEventIdMap == null ? (class$de$vw$mib$event$SystemEventIdMap = Activator.class$("de.vw.mib.event.SystemEventIdMap")) : class$de$vw$mib$event$SystemEventIdMap).getName(), (class$de$vw$mib$event$internal$diag$EventTracer == null ? (class$de$vw$mib$event$internal$diag$EventTracer = Activator.class$("de.vw.mib.event.internal.diag.EventTracer")) : class$de$vw$mib$event$internal$diag$EventTracer).getName()});
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void addServiceListener(String[] stringArray) {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("(|");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringBuffer.append("(").append("objectClass").append("=").append(stringArray[i2]).append(")");
        }
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (int i3 = 0; serviceReferenceArray != null && i3 < serviceReferenceArray.length; ++i3) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i3]));
        }
    }

    private void createAndRegisterProvidedServices(BundleContext bundleContext) {
        EventFactory eventFactory = new EventFactory(this.configManager);
        int n = 500;
        int n2 = 25;
        int n3 = 25;
        this.dispatcherManager = new EventDispatcherManagerImpl(eventFactory, n, n2, n3);
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$dispatcher$EventDispatcherManager == null ? (class$de$vw$mib$event$dispatcher$EventDispatcherManager = Activator.class$("de.vw.mib.event.dispatcher.EventDispatcherManager")) : class$de$vw$mib$event$dispatcher$EventDispatcherManager).getName(), (class$de$vw$mib$lsctng$LscUserInteractionFilterService == null ? (class$de$vw$mib$lsctng$LscUserInteractionFilterService = Activator.class$("de.vw.mib.lsctng.LscUserInteractionFilterService")) : class$de$vw$mib$lsctng$LscUserInteractionFilterService).getName()}, (Object)this.dispatcherManager, null);
        bundleContext.registerService((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName(), (Object)this.dispatcherManager.getStartupEventDispatcher(), null);
        bundleContext.registerService((class$de$vw$mib$event$dispatcher$DatapoolEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$DatapoolEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.DatapoolEventDispatcher")) : class$de$vw$mib$event$dispatcher$DatapoolEventDispatcher).getName(), (Object)this.dispatcherManager.getDatapoolEventDispatcher(), null);
        bundleContext.registerService((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName(), (Object)this.dispatcherManager.getFrameworkEventDispatcher(), null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcher")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher).getName(), (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt = Activator.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt).getName()}, (Object)this.dispatcherManager.getStatemachineEventDispatcher(), null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName(), (class$de$vw$mib$coreapi$client$SystemEventListener == null ? (class$de$vw$mib$coreapi$client$SystemEventListener = Activator.class$("de.vw.mib.coreapi.client.SystemEventListener")) : class$de$vw$mib$coreapi$client$SystemEventListener).getName()}, (Object)this.dispatcherManager.getSystemEventDispatcher(), null);
        if (ServiceManager.systemEventSender == null) {
            ServiceManager.systemEventSender = (SystemEventSender)((Object)this.dispatcherManager.getSystemEventDispatcher());
        }
        bundleContext.registerService((class$de$vw$mib$event$dispatcher$GestureEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$GestureEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.GestureEventDispatcher")) : class$de$vw$mib$event$dispatcher$GestureEventDispatcher).getName(), (Object)this.dispatcherManager.getGestureEventDispatcher(), null);
        bundleContext.registerService((class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher).getName(), (Object)this.dispatcherManager.getViewEventDispatcher(), null);
        bundleContext.registerService((class$de$vw$mib$event$internal$diag$EventDispatcherDiag == null ? (class$de$vw$mib$event$internal$diag$EventDispatcherDiag = Activator.class$("de.vw.mib.event.internal.diag.EventDispatcherDiag")) : class$de$vw$mib$event$internal$diag$EventDispatcherDiag).getName(), (Object)this.dispatcherManager.getMainDispatcher(), null);
        AsyncServiceFactoryImpl asyncServiceFactoryImpl = new AsyncServiceFactoryImpl(this.dispatcherManager.getFrameworkEventDispatcher());
        Properties properties = new Properties();
        properties.put("MIBThreadId", String.valueOf(2));
        bundleContext.registerService((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), (Object)asyncServiceFactoryImpl, (Dictionary)properties);
    }

    private void getRequiredServices(BundleContext bundleContext) {
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.errorHandler = (ErrorHandler)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        this.configManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.threadManager = (MIBThreadManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$coreapi$asl$SystemEventSender == null ? (class$de$vw$mib$coreapi$asl$SystemEventSender = Activator.class$("de.vw.mib.coreapi.asl.SystemEventSender")) : class$de$vw$mib$coreapi$asl$SystemEventSender).getName());
        ServiceManager.systemEventSender = serviceReference != null ? (SystemEventSender)bundleContext.getService(serviceReference) : null;
    }

    private void handleServiceRegistered(String string, Object object) {
        if ((class$de$vw$mib$event$consumer$AnimationEventConsumer == null ? (class$de$vw$mib$event$consumer$AnimationEventConsumer = Activator.class$("de.vw.mib.event.consumer.AnimationEventConsumer")) : class$de$vw$mib$event$consumer$AnimationEventConsumer).getName().equals(string)) {
            ServiceManager.animationManager = (AnimationEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.AppStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer).getName().equals(string)) {
            ServiceManager.appStartupManager = (AppStartupManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.ASLStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer).getName().equals(string)) {
            ServiceManager.aslStartupManager = (ASLStartupManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$BAPSystemEventConsumer == null ? (class$de$vw$mib$event$consumer$BAPSystemEventConsumer = Activator.class$("de.vw.mib.event.consumer.BAPSystemEventConsumer")) : class$de$vw$mib$event$consumer$BAPSystemEventConsumer).getName().equals(string)) {
            ServiceManager.bapSystemEventConsumer = (BAPSystemEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$DatapoolEventConsumer == null ? (class$de$vw$mib$event$consumer$DatapoolEventConsumer = Activator.class$("de.vw.mib.event.consumer.DatapoolEventConsumer")) : class$de$vw$mib$event$consumer$DatapoolEventConsumer).getName().equals(string)) {
            ServiceManager.datapool = (DatapoolEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$LSChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$LSChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.LSChangeEventConsumer")) : class$de$vw$mib$event$consumer$LSChangeEventConsumer).getName().equals(string)) {
            ServiceManager.lsChanger = (LSChangeEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackChangeEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer).getName().equals(string)) {
            if (ServiceManager.popupStackChangeEventConsumer != this.popupStackChangeHandler) {
                ServiceManager.popupStackChangeEventConsumer = this.popupStackChangeHandler;
            }
            this.popupStackChangeHandler.addConsumer((PopupStackChangeEventConsumer)object);
        } else if ((class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackManagerEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer).getName().equals(string)) {
            ServiceManager.popupStackManager = (PopupStackManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$PowerStateEventConsumer == null ? (class$de$vw$mib$event$consumer$PowerStateEventConsumer = Activator.class$("de.vw.mib.event.consumer.PowerStateEventConsumer")) : class$de$vw$mib$event$consumer$PowerStateEventConsumer).getName().equals(string)) {
            ServiceManager.powerStateEventConsumer = (PowerStateEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$RepaintEventConsumer == null ? (class$de$vw$mib$event$consumer$RepaintEventConsumer = Activator.class$("de.vw.mib.event.consumer.RepaintEventConsumer")) : class$de$vw$mib$event$consumer$RepaintEventConsumer).getName().equals(string)) {
            ServiceManager.repaintManager = (RepaintEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer == null ? (class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer = Activator.class$("de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer")) : class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer).getName().equals(string)) {
            ServiceManager.restoreFactorySettingsEventConsumer = (RestoreFactorySettingsEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$StartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$StartupManagerEventConsumer).getName().equals(string)) {
            ServiceManager.startupManager = (StartupManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StatemachineManagerEventConsumer")) : class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer).getName().equals(string)) {
            ServiceManager.statemachineManager = (StatemachineManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$ViewManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ViewManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.ViewManagerEventConsumer")) : class$de$vw$mib$event$consumer$ViewManagerEventConsumer).getName().equals(string)) {
            ServiceManager.viewManager = (ViewManagerEventConsumer)object;
        } else if ((class$de$vw$mib$event$consumer$GestureEventConsumer == null ? (class$de$vw$mib$event$consumer$GestureEventConsumer = Activator.class$("de.vw.mib.event.consumer.GestureEventConsumer")) : class$de$vw$mib$event$consumer$GestureEventConsumer).getName().equals(string)) {
            ServiceManager.gestureEventConsumer = (GestureEventConsumer)object;
        } else if ((class$de$vw$mib$event$SystemEventIdMap == null ? (class$de$vw$mib$event$SystemEventIdMap = Activator.class$("de.vw.mib.event.SystemEventIdMap")) : class$de$vw$mib$event$SystemEventIdMap).getName().equals(string)) {
            if (System.getProperty("useSystemEventIdMap") != null) {
                ServiceManager.systemEventIdMap = (SystemEventIdMap)object;
            }
        } else if ((class$de$vw$mib$event$internal$diag$EventTracer == null ? (class$de$vw$mib$event$internal$diag$EventTracer = Activator.class$("de.vw.mib.event.internal.diag.EventTracer")) : class$de$vw$mib$event$internal$diag$EventTracer).getName().equals(string)) {
            EventTracer eventTracer = (EventTracer)object;
            if (ServiceManager.eventTracer == EventTracer.EMPTY_EVENT_TRACER) {
                ServiceManager.eventTracer = eventTracer;
            } else if (ServiceManager.eventTracer == this.eventTracerList) {
                this.eventTracerList.addEventTracer(eventTracer);
            } else {
                if (this.eventTracerList == null) {
                    this.eventTracerList = new EventTracerList();
                }
                this.eventTracerList.addEventTracer(ServiceManager.eventTracer);
                this.eventTracerList.addEventTracer(eventTracer);
                ServiceManager.eventTracer = this.eventTracerList;
            }
        }
    }

    private void handleServiceUnregistering(String string, Object object) {
        if ((class$de$vw$mib$event$internal$diag$EventTracer == null ? (class$de$vw$mib$event$internal$diag$EventTracer = Activator.class$("de.vw.mib.event.internal.diag.EventTracer")) : class$de$vw$mib$event$internal$diag$EventTracer).getName().equals(string)) {
            EventTracer eventTracer = (EventTracer)object;
            if (ServiceManager.eventTracer == eventTracer) {
                ServiceManager.eventTracer = EventTracer.EMPTY_EVENT_TRACER;
            } else if (ServiceManager.eventTracer == this.eventTracerList) {
                ServiceManager.eventTracer = this.eventTracerList.removeEventTracer(eventTracer);
            }
        } else if ((class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackChangeEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackChangeEventConsumer).getName().equals(string)) {
            if (ServiceManager.popupStackChangeEventConsumer != this.popupStackChangeHandler) {
                return;
            }
            this.popupStackChangeHandler.removeConsumer((PopupStackChangeEventConsumer)object);
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

