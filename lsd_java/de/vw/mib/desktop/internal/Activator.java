/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.debugmanager.performance.PerformanceTracingService;
import de.vw.mib.desktop.internal.Activator$1;
import de.vw.mib.desktop.internal.DesktopManagerImpl;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.popup.PopupStackManagerImpl;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandlerProviderImpl;
import de.vw.mib.desktop.internal.viewhandler.cache.ViewHandlerCacheImpl;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.proximation.ProximityInstaller;
import de.vw.mib.repaint.RepaintManager;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.skin.V2vAnimationIndexProvider;
import de.vw.mib.sm.StatemachineManager;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.ViewCompositor;
import de.vw.mib.viewmanager.internal.DiagViewListListener;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import de.vw.mib.viewmanager.internal.popup.PopupInformationTable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
implements BundleActivator,
ServiceListener {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceTracingService;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinClassLoader;
    static /* synthetic */ Class class$de$vw$mib$skin$V2vAnimationIndexProvider;
    static /* synthetic */ Class class$de$vw$mib$sm$StatemachineManager;
    static /* synthetic */ Class class$de$vw$mib$view$ViewCompositor;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$ViewHandlerFactory;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupInformationHandler;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$DiagViewListListener;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$proximation$ProximityInstaller;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopInformationReceiver;
    static /* synthetic */ Class class$de$vw$mib$repaint$RepaintManager;
    static /* synthetic */ Class class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupSpeechSegueService;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopManager;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$GestureEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$ViewManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$skin$ViewLanguageSkinChanger;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$DesktopDiag;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopDiagnosticsProviderService;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = ServiceManager.bundleContext.getService(serviceEvent.getServiceReference());
        if (object instanceof DiagViewListListener) {
            ServiceManager.diagViewListListener = serviceEvent.getType() == 1 ? (DiagViewListListener)object : new Activator$1(this);
        } else if (object instanceof PerfService) {
            ServiceManager.perfService = (PerfService)object;
        } else if (object instanceof ProximityInstaller) {
            switch (serviceEvent.getType()) {
                case 1: {
                    ServiceManager.proximityInstaller = (ProximityInstaller)object;
                    break;
                }
                case 4: {
                    ServiceManager.proximityInstaller = null;
                    break;
                }
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        DesktopManagerImpl desktopManagerImpl;
        ViewHandlerFactory viewHandlerFactory;
        TimerManager timerManager;
        ServiceManager.bundleContext = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        Logger logger = ServiceManager.loggerFactory.getLogger(1024);
        boolean bl = logger.isTraceEnabled(128);
        long[] lArray = new long[16];
        ServiceManager.timerManager = timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        if (bl) {
            lArray[0] = timerManager.getSystemTimeMicros();
        }
        if (bl) {
            lArray[1] = timerManager.getSystemTimeMicros();
        }
        ServiceManager.performanceTracer = (PerformanceTracingService)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$debugmanager$performance$PerformanceTracingService == null ? (class$de$vw$mib$debugmanager$performance$PerformanceTracingService = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceTracingService")) : class$de$vw$mib$debugmanager$performance$PerformanceTracingService).getName()));
        ServiceManager.errorHandler = (ErrorHandler)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        ServiceManager.eventDispatcher = (FrameworkEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()));
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.popupInformationTable = (PopupInformationTable)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable == null ? (class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable = Activator.class$("de.vw.mib.viewmanager.internal.popup.PopupInformationTable")) : class$de$vw$mib$viewmanager$internal$popup$PopupInformationTable).getName()));
        ServiceManager.skinClassLoader = (SkinClassLoader)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$skin$SkinClassLoader == null ? (class$de$vw$mib$skin$SkinClassLoader = Activator.class$("de.vw.mib.skin.SkinClassLoader")) : class$de$vw$mib$skin$SkinClassLoader).getName()));
        ServiceManager.v2vAnimationIndexProvider = (V2vAnimationIndexProvider)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$skin$V2vAnimationIndexProvider == null ? (class$de$vw$mib$skin$V2vAnimationIndexProvider = Activator.class$("de.vw.mib.skin.V2vAnimationIndexProvider")) : class$de$vw$mib$skin$V2vAnimationIndexProvider).getName()));
        ServiceManager.statemachineManager = (StatemachineManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$sm$StatemachineManager == null ? (class$de$vw$mib$sm$StatemachineManager = Activator.class$("de.vw.mib.sm.StatemachineManager")) : class$de$vw$mib$sm$StatemachineManager).getName()));
        ServiceManager.viewCompositor = (ViewCompositor)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$view$ViewCompositor == null ? (class$de$vw$mib$view$ViewCompositor = Activator.class$("de.vw.mib.view.ViewCompositor")) : class$de$vw$mib$view$ViewCompositor).getName()));
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), "(MIBThreadId=2)");
        AsyncServiceFactory asyncServiceFactory = (AsyncServiceFactory)bundleContext.getService(serviceReferenceArray[0]);
        ServiceManager.viewHandlerFactory = viewHandlerFactory = (ViewHandlerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$viewmanager$internal$ViewHandlerFactory == null ? (class$de$vw$mib$viewmanager$internal$ViewHandlerFactory = Activator.class$("de.vw.mib.viewmanager.internal.ViewHandlerFactory")) : class$de$vw$mib$viewmanager$internal$ViewHandlerFactory).getName()));
        if (bl) {
            lArray[2] = timerManager.getSystemTimeMicros();
        }
        ViewHandlerCacheImpl viewHandlerCacheImpl = new ViewHandlerCacheImpl(viewHandlerFactory, ServiceManager.configurationManager.getViewHandlerCacheSize());
        if (bl) {
            lArray[3] = timerManager.getSystemTimeMicros();
        }
        SmartViewHandlerProviderImpl smartViewHandlerProviderImpl = new SmartViewHandlerProviderImpl(viewHandlerCacheImpl);
        ServiceManager.smartViewHandlerProvider = smartViewHandlerProviderImpl;
        if (bl) {
            lArray[4] = timerManager.getSystemTimeMicros();
        }
        PopupStackManagerImpl popupStackManagerImpl = new PopupStackManagerImpl();
        ServiceManager.popupStackManager = popupStackManagerImpl;
        if (bl) {
            lArray[5] = timerManager.getSystemTimeMicros();
        }
        ServiceManager.popupInformationHandlerServiceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = Activator.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler).getName(), (ServiceTrackerCustomizer)ServiceManager.popupStackManager);
        ServiceManager.popupInformationHandlerServiceTracker.open();
        if (bl) {
            lArray[6] = timerManager.getSystemTimeMicros();
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$viewmanager$internal$DiagViewListListener == null ? (class$de$vw$mib$viewmanager$internal$DiagViewListListener = Activator.class$("de.vw.mib.viewmanager.internal.DiagViewListListener")) : class$de$vw$mib$viewmanager$internal$DiagViewListListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = Activator.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$proximation$ProximityInstaller == null ? (class$de$vw$mib$proximation$ProximityInstaller = Activator.class$("de.vw.mib.proximation.ProximityInstaller")) : class$de$vw$mib$proximation$ProximityInstaller).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        ServiceManager.bundleContext.addServiceListener(this, string);
        if (bl) {
            lArray[7] = timerManager.getSystemTimeMicros();
        }
        ServiceReference[] serviceReferenceArray2 = ServiceManager.bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray2 != null && i2 < serviceReferenceArray2.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray2[i2]));
        }
        if (bl) {
            lArray[8] = timerManager.getSystemTimeMicros();
        }
        ServiceManager.desktopManager = desktopManagerImpl = new DesktopManagerImpl(ServiceManager.loggerFactory);
        if (bl) {
            lArray[9] = timerManager.getSystemTimeMicros();
        }
        ServiceManager.desktopInformationReceiverServiceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$desktop$DesktopInformationReceiver == null ? (class$de$vw$mib$desktop$DesktopInformationReceiver = Activator.class$("de.vw.mib.desktop.DesktopInformationReceiver")) : class$de$vw$mib$desktop$DesktopInformationReceiver).getName(), (ServiceTrackerCustomizer)ServiceManager.desktopManager);
        ServiceManager.desktopInformationReceiverServiceTracker.open();
        if (bl) {
            lArray[10] = timerManager.getSystemTimeMicros();
        }
        ServiceManager.repaintManager = (RepaintManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$repaint$RepaintManager == null ? (class$de$vw$mib$repaint$RepaintManager = Activator.class$("de.vw.mib.repaint.RepaintManager")) : class$de$vw$mib$repaint$RepaintManager).getName()));
        ServiceManager.repaintManager.registerRepaintHandler(desktopManagerImpl);
        if (bl) {
            lArray[11] = timerManager.getSystemTimeMicros();
        }
        bundleContext.registerService((class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler == null ? (class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler = Activator.class$("de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler")) : class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler).getName(), asyncServiceFactory.createNarrow(desktopManagerImpl, new Class[]{class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler == null ? (class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler = Activator.class$("de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler")) : class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler}), null);
        if (bl) {
            lArray[12] = timerManager.getSystemTimeMicros();
        }
        bundleContext.registerService((class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.PopupStackManagerEventConsumer")) : class$de$vw$mib$event$consumer$PopupStackManagerEventConsumer).getName(), (Object)ServiceManager.popupStackManager, null);
        if (bl) {
            lArray[13] = timerManager.getSystemTimeMicros();
        }
        bundleContext.registerService((class$de$vw$mib$popup$PopupSpeechSegueService == null ? (class$de$vw$mib$popup$PopupSpeechSegueService = Activator.class$("de.vw.mib.popup.PopupSpeechSegueService")) : class$de$vw$mib$popup$PopupSpeechSegueService).getName(), asyncServiceFactory.createNarrow(popupStackManagerImpl, new Class[]{class$de$vw$mib$popup$PopupSpeechSegueService == null ? (class$de$vw$mib$popup$PopupSpeechSegueService = Activator.class$("de.vw.mib.popup.PopupSpeechSegueService")) : class$de$vw$mib$popup$PopupSpeechSegueService}), null);
        if (bl) {
            lArray[14] = timerManager.getSystemTimeMicros();
        }
        bundleContext.registerService(new String[]{(class$de$vw$mib$desktop$DesktopManager == null ? (class$de$vw$mib$desktop$DesktopManager = Activator.class$("de.vw.mib.desktop.DesktopManager")) : class$de$vw$mib$desktop$DesktopManager).getName(), (class$de$vw$mib$event$consumer$GestureEventConsumer == null ? (class$de$vw$mib$event$consumer$GestureEventConsumer = Activator.class$("de.vw.mib.event.consumer.GestureEventConsumer")) : class$de$vw$mib$event$consumer$GestureEventConsumer).getName(), (class$de$vw$mib$event$consumer$ViewManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ViewManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.ViewManagerEventConsumer")) : class$de$vw$mib$event$consumer$ViewManagerEventConsumer).getName(), (class$de$vw$mib$skin$ViewLanguageSkinChanger == null ? (class$de$vw$mib$skin$ViewLanguageSkinChanger = Activator.class$("de.vw.mib.skin.ViewLanguageSkinChanger")) : class$de$vw$mib$skin$ViewLanguageSkinChanger).getName(), (class$de$vw$mib$viewmanager$DesktopDiag == null ? (class$de$vw$mib$viewmanager$DesktopDiag = Activator.class$("de.vw.mib.viewmanager.DesktopDiag")) : class$de$vw$mib$viewmanager$DesktopDiag).getName(), (class$de$vw$mib$desktop$DesktopDiagnosticsProviderService == null ? (class$de$vw$mib$desktop$DesktopDiagnosticsProviderService = Activator.class$("de.vw.mib.desktop.DesktopDiagnosticsProviderService")) : class$de$vw$mib$desktop$DesktopDiagnosticsProviderService).getName()}, (Object)desktopManagerImpl, null);
        if (bl) {
            lArray[15] = timerManager.getSystemTimeMicros();
        }
        if (bl) {
            int n = 15;
            long l = lArray[n] - lArray[0];
            String[] stringArray = new String[]{null, "-", "{getService()}", "new 'ViewHandlerCacheImpl'", "new 'SmartViewHandlerProviderImpl'", "new 'PopupStackManagerImpl'", "new 'ServiceTracker('PopupInformationHandler')'.open()", "addServiceListener('DiagViewListListener', 'PerfService', 'ProximityInstaller')", "getServiceReferences('DiagViewListListener', 'PerfService', 'ProximityInstaller').serviceChanged 'REGISTERED'", "new 'DesktopManagerImpl'", "new 'ServiceTracker('DesktopInformationReceiver')'.open()", "registerRepaintHandler 'desktopManagerImpl'", "asyncServiceFactory.create 'DriverDistractionPreventionHandler'", "registerService 'PopupStackManagerEventConsumer'", "asyncServiceFactory.create 'PopupSpeechSegueService'", "registerService 'ViewManagerEventConsumer', 'ViewLanguageSkinChanger',\u2026"};
            for (int i3 = 1; i3 <= n; ++i3) {
                logger.trace(128).append(i3).append(". ").append(lArray[i3] - lArray[0]).append(" (").append(lArray[i3] - lArray[i3 - 1]).append(") ").append((long)(0 * (lArray[i3] - lArray[i3 - 1]) / l)).append("% [").append(stringArray[i3]).append("]").log();
            }
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        ServiceManager.popupInformationHandlerServiceTracker.close();
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

