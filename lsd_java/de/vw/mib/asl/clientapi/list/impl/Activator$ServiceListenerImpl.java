/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListFactoryImpl;
import de.vw.mib.asl.clientapi.list.impl.Activator;
import de.vw.mib.asl.clientapi.list.impl.Activator$ServiceListenerImpl$1;
import de.vw.mib.asl.clientapi.list.impl.Activator$ServicesImpl;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
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
    private Activator$ServicesImpl services = new Activator$ServicesImpl();
    private ServiceReference srTimerManager;
    private ServiceReference srThreadSwitchingTarget;
    private ServiceReference srHMIListDataFactory;
    private ServiceReference srHMIListRegistry;
    private ServiceRegistration srListFactory;
    private ASLClientListFactoryImpl listFactory;

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
        String string = Activator$ServiceListenerImpl.createFilter();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (int i2 = 0; null != serviceReferenceArray && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceRegistered(serviceReferenceArray[i2]);
        }
    }

    void close() {
        Activator$ServiceListenerImpl.unregister(this.srListFactory);
        this.srListFactory = null;
        this.listFactory = null;
        this.unget(this.srHMIListRegistry);
        this.srHMIListRegistry = null;
        this.unget(this.srHMIListDataFactory);
        this.srHMIListDataFactory = null;
        this.unget(this.srThreadSwitchingTarget);
        this.srThreadSwitchingTarget = null;
        this.unget(this.srTimerManager);
        this.srTimerManager = null;
        this.services = null;
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

    private void checkListFactoryRegistration() {
        if (null == this.srListFactory && this.services.isReady()) {
            this.listFactory = new ASLClientListFactoryImpl(this.services, this.services.registry);
            this.srListFactory = this.context.registerService((Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory == null ? (Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory = Activator.class$("de.vw.mib.asl.clientapi.list.ASLClientListFactory")) : Activator.class$de$vw$mib$asl$clientapi$list$ASLClientListFactory).getName(), (Object)this.listFactory, (Dictionary)null);
        }
    }

    void serviceRegistered(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if ((Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? Activator.class$("de.vw.mib.log4mib.LoggerFactory") : Activator.class$de$vw$mib$log4mib$LoggerFactory).getName().equals(string)) {
                LoggerFactory loggerFactory = (LoggerFactory)this.context.getService(serviceReference);
                Logger logger = loggerFactory.getLogger(0x1008000);
                this.services.clogger = new Activator$ServiceListenerImpl$1(this, 2, "[ASLClientList] ", logger);
                this.context.ungetService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) {
                this.unget(this.srTimerManager);
                this.srTimerManager = serviceReference;
                this.services.timerManager = (TimerManager)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                this.unget(this.srThreadSwitchingTarget);
                this.srThreadSwitchingTarget = serviceReference;
                this.services.invoker = (ThreadSwitchingTarget)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$list$HMIListDataFactory == null ? Activator.class$("de.vw.mib.list.HMIListDataFactory") : Activator.class$de$vw$mib$list$HMIListDataFactory).getName().equals(string)) {
                this.unget(this.srHMIListDataFactory);
                this.srHMIListDataFactory = serviceReference;
                this.services.factory = (HMIListDataFactory)this.context.getService(serviceReference);
                continue;
            }
            if (!(Activator.class$de$vw$mib$list$HMIListRegistry == null ? Activator.class$("de.vw.mib.list.HMIListRegistry") : Activator.class$de$vw$mib$list$HMIListRegistry).getName().equals(string)) continue;
            this.unget(this.srHMIListRegistry);
            this.srHMIListRegistry = serviceReference;
            this.services.registry = (HMIListRegistry)this.context.getService(serviceReference);
        }
        this.checkListFactoryRegistration();
    }

    void serviceUnregistering(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if ((Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) {
                this.unget(this.srTimerManager);
                this.srTimerManager = null;
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                this.unget(this.srThreadSwitchingTarget);
                this.srThreadSwitchingTarget = null;
                continue;
            }
            if ((Activator.class$de$vw$mib$list$HMIListDataFactory == null ? Activator.class$("de.vw.mib.list.HMIListDataFactory") : Activator.class$de$vw$mib$list$HMIListDataFactory).getName().equals(string)) {
                this.unget(this.srHMIListDataFactory);
                this.srHMIListDataFactory = null;
                continue;
            }
            if (!(Activator.class$de$vw$mib$list$HMIListRegistry == null ? Activator.class$("de.vw.mib.list.HMIListRegistry") : Activator.class$de$vw$mib$list$HMIListRegistry).getName().equals(string)) continue;
            this.unget(this.srHMIListRegistry);
            this.srHMIListRegistry = null;
        }
    }

    private static String createFilter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(|");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? (Activator.class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : Activator.class$de$vw$mib$log4mib$LoggerFactory);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$timer$TimerManager == null ? (Activator.class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : Activator.class$de$vw$mib$timer$TimerManager);
        stringBuffer.append("(&");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget);
        stringBuffer.append("(").append("genericEvents.task").append("=").append("hsmtask").append(")");
        stringBuffer.append(")");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$list$HMIListDataFactory == null ? (Activator.class$de$vw$mib$list$HMIListDataFactory = Activator.class$("de.vw.mib.list.HMIListDataFactory")) : Activator.class$de$vw$mib$list$HMIListDataFactory);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$list$HMIListRegistry == null ? (Activator.class$de$vw$mib$list$HMIListRegistry = Activator.class$("de.vw.mib.list.HMIListRegistry")) : Activator.class$de$vw$mib$list$HMIListRegistry);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private static StringBuffer appendObjectClass(StringBuffer stringBuffer, Class clazz) {
        return stringBuffer.append("(").append("objectClass").append("=").append(clazz.getName()).append(")");
    }
}

