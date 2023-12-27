/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.diag.TimerDiag;
import de.vw.mib.timer.internal.EmptyTimerDiag;
import de.vw.mib.timer.internal.MIBTimerManager;
import de.vw.mib.timer.internal.ServiceManager;
import de.vw.mib.timer.spi.TimerSPI;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext bundleContext;
    private MIBTimerManager timerManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$timer$diag$TimerDiag;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.bundleContext.getService(serviceEvent.getServiceReference());
        if (!(object instanceof TimerDiag)) {
            return;
        }
        if (serviceEvent.getType() == 1) {
            this.setTimerDiag((TimerDiag)object);
        } else {
            this.setTimerDiag(null);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)this.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        ServiceManager.errorHandler = (ErrorHandler)this.getService(class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler);
        ServiceManager.timerSPI = (TimerSPI)this.getService(class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = Activator.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI);
        ServiceManager.threadManager = (MIBThreadManager)this.getService(class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager);
        this.timerManager = new MIBTimerManager();
        bundleContext.registerService((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName(), (Object)this.timerManager, null);
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$timer$diag$TimerDiag == null ? (class$de$vw$mib$timer$diag$TimerDiag = Activator.class$("de.vw.mib.timer.diag.TimerDiag")) : class$de$vw$mib$timer$diag$TimerDiag).getName()).append(")");
        String string = stringBuffer.toString();
        bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences((class$de$vw$mib$timer$diag$TimerDiag == null ? (class$de$vw$mib$timer$diag$TimerDiag = Activator.class$("de.vw.mib.timer.diag.TimerDiag")) : class$de$vw$mib$timer$diag$TimerDiag).getName(), null);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
        this.timerManager.startTimerThread();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private Object getService(Class clazz) {
        return this.bundleContext.getService(this.bundleContext.getServiceReference(clazz.getName()));
    }

    private void setTimerDiag(TimerDiag timerDiag) {
        ServiceManager.timerDiag = timerDiag != null ? timerDiag : new EmptyTimerDiag();
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

