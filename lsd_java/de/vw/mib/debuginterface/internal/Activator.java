/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.internal;

import de.vw.mib.cio.framework.diag.CioDiagService;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.diag.DebugDatapool;
import de.vw.mib.debug.screenshot.ScreenshotProvider;
import de.vw.mib.debuginterface.internal.Activator$1;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.internal.TesterTargetFactoryImpl;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.graphics.display.spi.DisplaySPI;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext context = null;
    private Logger logger;
    private boolean rumbling;
    static /* synthetic */ Class class$de$vw$mib$datapool$ModelDatapool;
    static /* synthetic */ Class class$de$vw$mib$list$DynamicListManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$debug$screenshot$ScreenshotProvider;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$DesktopDiag;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$graphics$display$spi$DisplaySPI;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$tester$TesterTargetService;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.context.getService(serviceEvent.getServiceReference());
        String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
        try {
            if (serviceEvent.getType() == 1) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object);
                }
            }
            if (!this.rumbling && ServiceManager.ge != null) {
                this.makeReadyToRumble();
            }
        }
        catch (Exception exception) {
            this.logger.error(1, "", exception);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        ServiceReference serviceReference;
        int n;
        this.context = bundleContext;
        ServiceManager.context = bundleContext;
        this.getRequiredServices();
        String string = "(|";
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = Activator.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$list$DynamicListManager == null ? (class$de$vw$mib$list$DynamicListManager = Activator.class$("de.vw.mib.list.DynamicListManager")) : class$de$vw$mib$list$DynamicListManager).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = Activator.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = Activator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$debug$screenshot$ScreenshotProvider == null ? (class$de$vw$mib$debug$screenshot$ScreenshotProvider = Activator.class$("de.vw.mib.debug.screenshot.ScreenshotProvider")) : class$de$vw$mib$debug$screenshot$ScreenshotProvider).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$viewmanager$DesktopDiag == null ? (class$de$vw$mib$viewmanager$DesktopDiag = Activator.class$("de.vw.mib.viewmanager.DesktopDiag")) : class$de$vw$mib$viewmanager$DesktopDiag).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()).append(")").toString();
        string = new StringBuffer().append(string).append(")").toString();
        this.context.addServiceListener(this, string);
        string = "(|";
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$viewmanager$DesktopDiag == null ? (class$de$vw$mib$viewmanager$DesktopDiag = Activator.class$("de.vw.mib.viewmanager.DesktopDiag")) : class$de$vw$mib$viewmanager$DesktopDiag).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$list$DynamicListManager == null ? (class$de$vw$mib$list$DynamicListManager = Activator.class$("de.vw.mib.list.DynamicListManager")) : class$de$vw$mib$list$DynamicListManager).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$debug$screenshot$ScreenshotProvider == null ? (class$de$vw$mib$debug$screenshot$ScreenshotProvider = Activator.class$("de.vw.mib.debug.screenshot.ScreenshotProvider")) : class$de$vw$mib$debug$screenshot$ScreenshotProvider).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = Activator.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = Activator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName()).append(")").toString();
        string = new StringBuffer().append(string).append("(objectClass=").append((class$de$vw$mib$cio$framework$diag$CioDiagService == null ? (class$de$vw$mib$cio$framework$diag$CioDiagService = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagService")) : class$de$vw$mib$cio$framework$diag$CioDiagService).getName()).append(")").toString();
        string = new StringBuffer().append(string).append(")").toString();
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (n = 0; n < serviceReferenceArray.length; ++n) {
            serviceReference = serviceReferenceArray[n];
            this.serviceChanged(new ServiceEvent(1, serviceReference));
        }
        serviceReferenceArray = this.context.getServiceReferences((class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = Activator.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool).getName(), null);
        for (n = 0; n < serviceReferenceArray.length; ++n) {
            serviceReference = serviceReferenceArray[n];
            this.serviceChanged(new ServiceEvent(1, serviceReference));
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.logger.info(1, "DebugInterface stopped");
    }

    private void getRequiredServices() {
        ServiceManager.loggerFactory = (LoggerFactory)this.context.getService(this.context.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        this.logger = ServiceManager.loggerFactory.getLogger(64);
        ServiceManager.configurationManager = (ConfigurationManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.statemachineEventDispatcher = (StatemachineEventDispatcher)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcher")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher).getName()));
        ServiceManager.frameworkEventDispatcher = (FrameworkEventDispatcher)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()));
        ServiceManager.systemEventDispatcher = (SystemEventDispatcher)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName()));
        ServiceManager.displaySPI = (DisplaySPI)this.context.getService(this.context.getServiceReference((class$de$vw$mib$graphics$display$spi$DisplaySPI == null ? (class$de$vw$mib$graphics$display$spi$DisplaySPI = Activator.class$("de.vw.mib.graphics.display.spi.DisplaySPI")) : class$de$vw$mib$graphics$display$spi$DisplaySPI).getName()));
        ServiceManager.timerManager = (TimerManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceManager.errorHandler = (ErrorHandler)this.context.getService(this.context.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        ServiceManager.threadManager = (MIBThreadManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName()));
        ServiceManager.binaryLogger = (BinaryLogger)this.context.getService(this.context.getServiceReference((class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger == null ? (class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger = Activator.class$("de.vw.mib.debugmanager.unifiedlogging.BinaryLogger")) : class$de$vw$mib$debugmanager$unifiedlogging$BinaryLogger).getName()));
    }

    private void handleServiceRegistered(String string, Object object) {
        if (object instanceof DebugDatapool) {
            ServiceManager.datapool = (DebugDatapool)object;
        } else if (object instanceof ScreenshotProvider) {
            ServiceManager.screenshotProvider = (ScreenshotProvider)object;
        } else if ((class$de$vw$mib$list$DynamicListManager == null ? (class$de$vw$mib$list$DynamicListManager = Activator.class$("de.vw.mib.list.DynamicListManager")) : class$de$vw$mib$list$DynamicListManager).getName().equals(string)) {
            ServiceManager.dynamicListManager = (DynamicListManager)object;
        } else if ((class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = Activator.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory).getName().equals(string)) {
            ServiceManager.mEventFactory = (EventFactory)object;
        } else if ((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = Activator.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName().equals(string)) {
            ServiceManager.ge = (GenericEvents)object;
        } else if ((class$de$vw$mib$cio$framework$diag$CioDiagService == null ? (class$de$vw$mib$cio$framework$diag$CioDiagService = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagService")) : class$de$vw$mib$cio$framework$diag$CioDiagService).getName().equals(string)) {
            ServiceManager.cioDiagService = (CioDiagService)object;
        } else if ((class$de$vw$mib$viewmanager$DesktopDiag == null ? (class$de$vw$mib$viewmanager$DesktopDiag = Activator.class$("de.vw.mib.viewmanager.DesktopDiag")) : class$de$vw$mib$viewmanager$DesktopDiag).getName().equals(string)) {
            if (ServiceManager.viewManager != null) {
                return;
            }
            ServiceManager.viewManager = new Activator$1(this, object);
        }
    }

    private void makeReadyToRumble() {
        TesterTargetFactoryImpl testerTargetFactoryImpl = new TesterTargetFactoryImpl(this.context);
        this.context.registerService((class$de$vw$mib$debugmanager$tester$TesterTargetService == null ? (class$de$vw$mib$debugmanager$tester$TesterTargetService = Activator.class$("de.vw.mib.debugmanager.tester.TesterTargetService")) : class$de$vw$mib$debugmanager$tester$TesterTargetService).getName(), (Object)testerTargetFactoryImpl, null);
        this.logger.info(1, "--- DebugInterface ready to rumble! ---");
        this.rumbling = true;
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

