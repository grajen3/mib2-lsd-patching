/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.Activator;
import de.vw.mib.asl.framework.internal.framework.Activator$ASLWrapperInitializer;
import de.vw.mib.asl.framework.internal.framework.Activator$DatapoolInitializer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.ASLDatapoolManager;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat4Asl;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.sound.SoundWaveplayer;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.TimerManager;
import java.util.LinkedList;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

class Activator$ServiceListenerImpl
implements ServiceListener,
MIBInvoker {
    private final LinkedList queue = new LinkedList();
    private final BundleContext context;
    private final ASLDatapoolManager datapoolManager;
    private final Activator$ASLWrapperInitializer aslWrapperInitializer;

    Activator$ServiceListenerImpl(BundleContext bundleContext, ASLDatapoolManager aSLDatapoolManager) {
        this.context = bundleContext;
        this.datapoolManager = aSLDatapoolManager;
        this.aslWrapperInitializer = new Activator$ASLWrapperInitializer(bundleContext, this, ServiceManager.loggerFWCore);
    }

    static String createFilter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(|");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$datapool$ASLDatapool == null ? (Activator.class$de$vw$mib$datapool$ASLDatapool = Activator.class$("de.vw.mib.datapool.ASLDatapool")) : Activator.class$de$vw$mib$datapool$ASLDatapool);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = Activator.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$asl$internal$list$ASLListManager == null ? (Activator.class$de$vw$mib$asl$internal$list$ASLListManager = Activator.class$("de.vw.mib.asl.internal.list.ASLListManager")) : Activator.class$de$vw$mib$asl$internal$list$ASLListManager);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$error$ErrorHandler == null ? (Activator.class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : Activator.class$de$vw$mib$error$ErrorHandler);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$genericevents$EventFactory == null ? (Activator.class$de$vw$mib$genericevents$EventFactory = Activator.class$("de.vw.mib.genericevents.EventFactory")) : Activator.class$de$vw$mib$genericevents$EventFactory);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$format$FixFormat4Asl == null ? (Activator.class$de$vw$mib$format$FixFormat4Asl = Activator.class$("de.vw.mib.format.FixFormat4Asl")) : Activator.class$de$vw$mib$format$FixFormat4Asl);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$genericevents$GenericEvents == null ? (Activator.class$de$vw$mib$genericevents$GenericEvents = Activator.class$("de.vw.mib.genericevents.GenericEvents")) : Activator.class$de$vw$mib$genericevents$GenericEvents);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$graphics$image$ImageManager == null ? (Activator.class$de$vw$mib$graphics$image$ImageManager = Activator.class$("de.vw.mib.graphics.image.ImageManager")) : Activator.class$de$vw$mib$graphics$image$ImageManager);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$perf$service$PerfService == null ? (Activator.class$de$vw$mib$perf$service$PerfService = Activator.class$("de.vw.mib.perf.service.PerfService")) : Activator.class$de$vw$mib$perf$service$PerfService);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$org$dsi$ifc$base$ServiceAdmin == null ? (Activator.class$org$dsi$ifc$base$ServiceAdmin = Activator.class$("org.dsi.ifc.base.ServiceAdmin")) : Activator.class$org$dsi$ifc$base$ServiceAdmin);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$sound$SoundWaveplayer == null ? (Activator.class$de$vw$mib$sound$SoundWaveplayer = Activator.class$("de.vw.mib.sound.SoundWaveplayer")) : Activator.class$de$vw$mib$sound$SoundWaveplayer);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher);
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$timer$TimerManager == null ? (Activator.class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : Activator.class$de$vw$mib$timer$TimerManager);
        stringBuffer.append("(&");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget);
        stringBuffer.append("(").append("genericEvents.task").append("=").append("hsmtask").append(")");
        stringBuffer.append(")");
        stringBuffer.append("(&");
        stringBuffer = Activator$ServiceListenerImpl.appendObjectClass(stringBuffer, Activator.class$de$vw$mib$threads$AsyncServiceFactory == null ? (Activator.class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : Activator.class$de$vw$mib$threads$AsyncServiceFactory);
        stringBuffer.append("(").append("MIBThreadId").append("=").append(3).append(")");
        stringBuffer.append(")");
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private static StringBuffer appendObjectClass(StringBuffer stringBuffer, Class clazz) {
        return stringBuffer.append("(").append("objectClass").append("=").append(clazz.getName()).append(")");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void serviceRegistered(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            Object object;
            String string = stringArray[i2];
            if ((Activator.class$de$vw$mib$datapool$ASLDatapool == null ? Activator.class$("de.vw.mib.datapool.ASLDatapool") : Activator.class$de$vw$mib$datapool$ASLDatapool).getName().equals(string)) {
                object = (ASLDatapool)this.context.getService(serviceReference);
                this.invoke(new Activator$DatapoolInitializer(this.datapoolManager, (ASLDatapool)object));
                continue;
            }
            if ((Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? Activator.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry") : Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName().equals(string)) {
                ServiceManager.deviceRegistry = object = (ASLDeviceRegistry)this.context.getService(serviceReference);
                this.aslWrapperInitializer.setDeviceRegistry((ASLDeviceRegistry)object);
                continue;
            }
            if ((Activator.class$de$vw$mib$asl$internal$list$ASLListManager == null ? Activator.class$("de.vw.mib.asl.internal.list.ASLListManager") : Activator.class$de$vw$mib$asl$internal$list$ASLListManager).getName().equals(string)) {
                ServiceManager.listManager = (ASLListManager)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$threads$AsyncServiceFactory == null ? Activator.class$("de.vw.mib.threads.AsyncServiceFactory") : Activator.class$de$vw$mib$threads$AsyncServiceFactory).getName().equals(string)) {
                ServiceManager.aslAsyncServiceFactory = (AsyncServiceFactory)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$error$ErrorHandler == null ? Activator.class$("de.vw.mib.error.ErrorHandler") : Activator.class$de$vw$mib$error$ErrorHandler).getName().equals(string)) {
                ServiceManager.errorHandler = (ErrorHandler)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$EventFactory == null ? Activator.class$("de.vw.mib.genericevents.EventFactory") : Activator.class$de$vw$mib$genericevents$EventFactory).getName().equals(string)) {
                ServiceManager.mGenericEventFactory = (EventFactory)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$format$FixFormat4Asl == null ? Activator.class$("de.vw.mib.format.FixFormat4Asl") : Activator.class$de$vw$mib$format$FixFormat4Asl).getName().equals(string)) {
                ServiceManager.fixFormat4Asl = (FixFormat4Asl)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$GenericEvents == null ? Activator.class$("de.vw.mib.genericevents.GenericEvents") : Activator.class$de$vw$mib$genericevents$GenericEvents).getName().equals(string)) {
                ServiceManager.eventMain = object = (GenericEvents)this.context.getService(serviceReference);
                this.aslWrapperInitializer.setServiceRegister(object.getServiceRegister());
                continue;
            }
            if ((Activator.class$de$vw$mib$graphics$image$ImageManager == null ? Activator.class$("de.vw.mib.graphics.image.ImageManager") : Activator.class$de$vw$mib$graphics$image$ImageManager).getName().equals(string)) {
                ServiceManager.imageManager = (ImageManager)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$perf$service$PerfService == null ? Activator.class$("de.vw.mib.perf.service.PerfService") : Activator.class$de$vw$mib$perf$service$PerfService).getName().equals(string)) {
                ServiceManager.perfService = (PerfService)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$org$dsi$ifc$base$ServiceAdmin == null ? Activator.class$("org.dsi.ifc.base.ServiceAdmin") : Activator.class$org$dsi$ifc$base$ServiceAdmin).getName().equals(string)) {
                ServiceManager.dsiServiceAdmin = (ServiceAdmin)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$sound$SoundWaveplayer == null ? Activator.class$("de.vw.mib.sound.SoundWaveplayer") : Activator.class$de$vw$mib$sound$SoundWaveplayer).getName().equals(string)) {
                ServiceManager.soundWaveplayer = (SoundWaveplayer)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? Activator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher") : Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName().equals(string)) {
                ServiceManager.eventDispatcher = (SystemEventDispatcher)this.context.getService(serviceReference);
                continue;
            }
            if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                object = this.queue;
                synchronized (object) {
                    ThreadSwitchingTarget threadSwitchingTarget;
                    ServiceManager.aslThreadSwitch = threadSwitchingTarget = (ThreadSwitchingTarget)this.context.getService(serviceReference);
                    while (!this.queue.isEmpty()) {
                        threadSwitchingTarget.enqueue((Runnable)this.queue.removeFirst());
                    }
                    continue;
                }
            }
            if (!(Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) continue;
            ServiceManager.timerManager = (TimerManager)this.context.getService(serviceReference);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void serviceUnregistering(ServiceReference serviceReference) {
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            boolean bl = true;
            if ((Activator.class$de$vw$mib$datapool$ASLDatapool == null ? Activator.class$("de.vw.mib.datapool.ASLDatapool") : Activator.class$de$vw$mib$datapool$ASLDatapool).getName().equals(string)) {
                this.datapoolManager.setDatapool(null);
            } else if ((Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? Activator.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry") : Activator.class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName().equals(string)) {
                ServiceManager.deviceRegistry = null;
            } else if ((Activator.class$de$vw$mib$asl$internal$list$ASLListManager == null ? Activator.class$("de.vw.mib.asl.internal.list.ASLListManager") : Activator.class$de$vw$mib$asl$internal$list$ASLListManager).getName().equals(string)) {
                ServiceManager.listManager = null;
            } else if ((Activator.class$de$vw$mib$threads$AsyncServiceFactory == null ? Activator.class$("de.vw.mib.threads.AsyncServiceFactory") : Activator.class$de$vw$mib$threads$AsyncServiceFactory).getName().equals(string)) {
                ServiceManager.aslAsyncServiceFactory = null;
            } else if ((Activator.class$de$vw$mib$error$ErrorHandler == null ? Activator.class$("de.vw.mib.error.ErrorHandler") : Activator.class$de$vw$mib$error$ErrorHandler).getName().equals(string)) {
                ServiceManager.errorHandler = null;
            } else if ((Activator.class$de$vw$mib$genericevents$EventFactory == null ? Activator.class$("de.vw.mib.genericevents.EventFactory") : Activator.class$de$vw$mib$genericevents$EventFactory).getName().equals(string)) {
                ServiceManager.mGenericEventFactory = null;
            } else if ((Activator.class$de$vw$mib$format$FixFormat4Asl == null ? Activator.class$("de.vw.mib.format.FixFormat4Asl") : Activator.class$de$vw$mib$format$FixFormat4Asl).getName().equals(string)) {
                ServiceManager.fixFormat4Asl = null;
            } else if ((Activator.class$de$vw$mib$genericevents$GenericEvents == null ? Activator.class$("de.vw.mib.genericevents.GenericEvents") : Activator.class$de$vw$mib$genericevents$GenericEvents).getName().equals(string)) {
                ServiceManager.eventMain = null;
            } else if ((Activator.class$de$vw$mib$graphics$image$ImageManager == null ? Activator.class$("de.vw.mib.graphics.image.ImageManager") : Activator.class$de$vw$mib$graphics$image$ImageManager).getName().equals(string)) {
                ServiceManager.imageManager = null;
            } else if ((Activator.class$de$vw$mib$perf$service$PerfService == null ? Activator.class$("de.vw.mib.perf.service.PerfService") : Activator.class$de$vw$mib$perf$service$PerfService).getName().equals(string)) {
                ServiceManager.perfService = null;
            } else if ((Activator.class$org$dsi$ifc$base$ServiceAdmin == null ? Activator.class$("org.dsi.ifc.base.ServiceAdmin") : Activator.class$org$dsi$ifc$base$ServiceAdmin).getName().equals(string)) {
                ServiceManager.dsiServiceAdmin = null;
            } else if ((Activator.class$de$vw$mib$sound$SoundWaveplayer == null ? Activator.class$("de.vw.mib.sound.SoundWaveplayer") : Activator.class$de$vw$mib$sound$SoundWaveplayer).getName().equals(string)) {
                ServiceManager.soundWaveplayer = null;
            } else if ((Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? Activator.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher") : Activator.class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName().equals(string)) {
                ServiceManager.eventDispatcher = null;
            } else if ((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget") : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
                LinkedList linkedList = this.queue;
                synchronized (linkedList) {
                    ServiceManager.aslThreadSwitch = null;
                }
            } else if ((Activator.class$de$vw$mib$timer$TimerManager == null ? Activator.class$("de.vw.mib.timer.TimerManager") : Activator.class$de$vw$mib$timer$TimerManager).getName().equals(string)) {
                ServiceManager.timerManager = null;
            } else {
                bl = false;
            }
            if (!bl) continue;
            this.context.ungetService(serviceReference);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void invoke(Runnable runnable) {
        LinkedList linkedList = this.queue;
        synchronized (linkedList) {
            ThreadSwitchingTarget threadSwitchingTarget = ServiceManager.aslThreadSwitch;
            if (null != threadSwitchingTarget) {
                threadSwitchingTarget.enqueue(runnable);
            } else {
                this.queue.add(runnable);
            }
        }
    }
}

