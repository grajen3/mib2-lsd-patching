/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.ASLListLogImpl;
import de.vw.mib.asl.internal.list.impl.Activator;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl$1;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl$2;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl$3;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;

class Activator$ServicesImpl
implements Services {
    private final ServiceTracker trackerLoggerFactory;
    private final ServiceTracker trackerTimerManager;
    private final ServiceTracker trackerThreadSwitch;
    private final ClassifiedLogger listLog = new ASLListLogImpl(this);
    Logger logger;
    ThreadSwitchingTarget threadSwitch;
    TimerManager timerManager;
    private final /* synthetic */ Activator this$0;

    Activator$ServicesImpl(Activator activator, BundleContext bundleContext) {
        this.this$0 = activator;
        this.trackerLoggerFactory = new Activator$ServicesImpl$1(this, bundleContext, (Activator.class$de$vw$mib$log4mib$LoggerFactory == null ? (Activator.class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : Activator.class$de$vw$mib$log4mib$LoggerFactory).getName(), null, activator);
        this.trackerTimerManager = new Activator$ServicesImpl$2(this, bundleContext, (Activator.class$de$vw$mib$timer$TimerManager == null ? (Activator.class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : Activator.class$de$vw$mib$timer$TimerManager).getName(), null, activator);
        Filter filter = bundleContext.createFilter(new StringBuffer().append("(&(objectClass=").append((Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : Activator.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName()).append(")").append("(").append("genericEvents.task").append("=hsmtask))").toString());
        this.trackerThreadSwitch = new Activator$ServicesImpl$3(this, bundleContext, filter, null, activator);
    }

    void open() {
        this.trackerLoggerFactory.open();
        this.trackerTimerManager.open();
        this.trackerThreadSwitch.open();
    }

    void close() {
        this.trackerThreadSwitch.close();
        this.trackerTimerManager.close();
        this.trackerLoggerFactory.close();
    }

    @Override
    public Logger getASLFWLogger() {
        return this.logger;
    }

    @Override
    public ClassifiedLogger getASLListLog() {
        return this.listLog;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitch() {
        return this.threadSwitch;
    }
}

