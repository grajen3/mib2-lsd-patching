/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ASLClientAPIRegistryImpl;
import de.vw.mib.asl.clientapi.impl.Activator;
import de.vw.mib.asl.clientapi.impl.Activator$ServiceListenerImpl$1;
import de.vw.mib.asl.clientapi.impl.Activator$ServiceListenerImpl$ClockTimerCallback;
import de.vw.mib.asl.clientapi.impl.ClockImpl;
import de.vw.mib.asl.clientapi.impl.ServicesImpl;
import de.vw.mib.asl.clientapi.list.ASLClientListFactory;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

class Activator$ServiceListenerImpl
implements ServiceListener {
    private final BundleContext context;
    private ServicesImpl services;
    private ServiceReference srASLClientListFactory;
    private ServiceReference srHMIListRegistry;
    private ServiceReference srLoggerFactory;
    private ServiceReference srThreadSwitchingTarget;
    private ServiceReference srTimerManager;
    private TimerManager timerManager;
    private Timer clockTimer;
    private ServiceRegistration srASLClientAPIRegistry;
    private ASLClientAPIRegistryImpl apiRegistry;

    Activator$ServiceListenerImpl(BundleContext bundleContext) {
        this.context = bundleContext;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        int n = serviceEvent.getType();
        ServiceReference serviceReference = serviceEvent.getServiceReference();
        switch (n) {
            case 1: {
                this.serviceRegistered(serviceReference);
                break;
            }
            case 4: {
                this.serviceUnregistering(serviceReference);
                break;
            }
        }
    }

    void open() {
        this.services = new ServicesImpl();
        String string = Activator$ServiceListenerImpl.createFilter();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (int i2 = 0; null != serviceReferenceArray && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceRegistered(serviceReferenceArray[i2]);
        }
    }

    void close() {
        this.clockTimer.stop();
        this.clockTimer = null;
        Activator$ServiceListenerImpl.unregister(this.srASLClientAPIRegistry);
        this.srASLClientAPIRegistry = null;
        this.apiRegistry = null;
        this.unget(this.srHMIListRegistry);
        this.srHMIListRegistry = null;
        this.unget(this.srASLClientListFactory);
        this.srASLClientAPIRegistry = null;
        this.unget(this.srThreadSwitchingTarget);
        this.srThreadSwitchingTarget = null;
        this.unget(this.srTimerManager);
        this.srTimerManager = null;
        this.timerManager = null;
        this.unget(this.srLoggerFactory);
        this.srLoggerFactory = null;
        this.services = null;
    }

    private void checkAPIRegistryRegistration() {
        if (null == this.srASLClientAPIRegistry && this.services.isReady()) {
            this.apiRegistry = new ASLClientAPIRegistryImpl(this.services);
            this.srASLClientAPIRegistry = this.context.registerService((Activator.class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry == null ? (Activator.class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry = Activator.class$("de.vw.mib.asl.clientapi.ASLClientAPIRegistry")) : Activator.class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry).getName(), (Object)this.apiRegistry, (Dictionary)null);
            this.clockTimer.start();
        }
    }

    private void checkClockTimer() {
        if (null == this.clockTimer && null != this.timerManager && null != this.services.aslInvoker) {
            this.services.clock = new ClockImpl(1000);
            this.clockTimer = this.timerManager.createTimer("ASLClientAPI-Clock", 0, false, new Activator$ServiceListenerImpl$ClockTimerCallback(this), this.services.aslInvoker);
        }
    }

    void onClockTimer() {
        ClockImpl clockImpl;
        ServicesImpl servicesImpl = this.services;
        if (null != servicesImpl && null != (clockImpl = servicesImpl.clock)) {
            block4: {
                try {
                    this.services.clock.onTimer();
                }
                catch (RuntimeException runtimeException) {
                    ClassifiedLogger classifiedLogger = servicesImpl.clogger;
                    if (null == classifiedLogger) break block4;
                    classifiedLogger.error().append("onClockTimer failed").attachThrowable(runtimeException).log();
                }
            }
            Timer timer = this.clockTimer;
            if (null != timer) {
                timer.start();
            }
        }
    }

    private void serviceRegistered(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if ((Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? Activator.class$("de.vw.mib.log4mib.LoggerFactory") : Activator.class$de$vw$mib$log4mib$LoggerFactory).getName().equals(string)) {
                LoggerFactory loggerFactory;
                this.unget(this.srLoggerFactory);
                this.srLoggerFactory = serviceReference;
                this.services.loggerFactory = loggerFactory = (LoggerFactory)this.context.getService(serviceReference);
                Logger logger = loggerFactory.getLogger(0x1008000);
                this.services.clogger = new Activator$ServiceListenerImpl$1(this, 32, "[ASLClientAPI] ", logger);
                continue;
            }
            if ((Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) {
                this.unget(this.srTimerManager);
                this.srTimerManager = serviceReference;
                this.timerManager = (TimerManager)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                this.unget(this.srThreadSwitchingTarget);
                this.srThreadSwitchingTarget = serviceReference;
                this.services.aslInvoker = (ThreadSwitchingTarget)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory == null ? Activator.class$("de.vw.mib.asl.clientapi.list.ASLClientListFactory") : Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory).getName().equals(string)) {
                this.unget(this.srASLClientListFactory);
                this.srASLClientListFactory = serviceReference;
                this.services.clientListFactory = (ASLClientListFactory)this.context.getService(serviceReference);
                continue;
            }
            if (!(Activator.class$de$vw$mib$list$HMIListRegistry == null ? Activator.class$("de.vw.mib.list.HMIListRegistry") : Activator.class$de$vw$mib$list$HMIListRegistry).getName().equals(string)) continue;
            this.unget(this.srHMIListRegistry);
            this.srHMIListRegistry = serviceReference;
            this.services.listRegistry = (HMIListRegistry)this.context.getService(serviceReference);
        }
        this.checkClockTimer();
        this.checkAPIRegistryRegistration();
    }

    private void serviceUnregistering(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if ((Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory == null ? Activator.class$("de.vw.mib.asl.clientapi.list.ASLClientListFactory") : Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory).getName().equals(string)) {
                this.unget(this.srASLClientListFactory);
                this.srASLClientListFactory = null;
                continue;
            }
            if ((Activator.class$de$vw$mib$list$HMIListRegistry == null ? Activator.class$("de.vw.mib.list.HMIListRegistry") : Activator.class$de$vw$mib$list$HMIListRegistry).getName().equals(string)) {
                this.unget(this.srHMIListRegistry);
                this.srHMIListRegistry = null;
                continue;
            }
            if ((Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? Activator.class$("de.vw.mib.log4mib.LoggerFactory") : Activator.class$de$vw$mib$log4mib$LoggerFactory).getName().equals(string)) {
                this.unget(this.srLoggerFactory);
                this.srLoggerFactory = null;
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                this.unget(this.srThreadSwitchingTarget);
                this.srThreadSwitchingTarget = null;
                continue;
            }
            if (!(Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) continue;
            this.unget(this.srTimerManager);
            this.srTimerManager = null;
            this.timerManager = null;
        }
    }

    private void unget(ServiceReference serviceReference) {
        if (null != serviceReference) {
            this.context.ungetService(serviceReference);
        }
    }

    private static void unregister(ServiceRegistration serviceRegistration) {
        if (null != serviceRegistration) {
            serviceRegistration.unregister();
        }
    }

    private static String createFilter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(|");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory == null ? (Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory = Activator.class$("de.vw.mib.asl.clientapi.list.ASLClientListFactory")) : Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$list$HMIListRegistry == null ? (Activator.class$de$vw$mib$list$HMIListRegistry = Activator.class$("de.vw.mib.list.HMIListRegistry")) : Activator.class$de$vw$mib$list$HMIListRegistry);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? (Activator.class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : Activator.class$de$vw$mib$log4mib$LoggerFactory);
        stringBuffer.append("(&");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget);
        stringBuffer.append("(").append("genericEvents.task").append("=").append("hsmtask").append(")");
        stringBuffer.append(")");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$timer$TimerManager == null ? (Activator.class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : Activator.class$de$vw$mib$timer$TimerManager);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private static StringBuffer appendObjectClass(StringBuffer stringBuffer, Class clazz) {
        return stringBuffer.append("(").append("objectClass").append("=").append(clazz.getName()).append(")");
    }
}

