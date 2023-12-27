/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;
import de.vw.mib.asl.internal.impl.system.ddp.DriverDistractionPreventionServiceImpl$1;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DriverDistractionPreventionServiceImpl
implements DriverDistractionPreventionService,
DriverDistractionPreventionThresholdListener {
    private final Logger logger;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final Set listeners;
    private final DdpInfoCollector ddpInfoCollector;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$impl$system$ddp$DdpInfoCollector;

    public DriverDistractionPreventionServiceImpl(Logger logger, ThreadSwitchingTarget threadSwitchingTarget, DdpInfoCollector ddpInfoCollector) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append("Incoming ").append((class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = DriverDistractionPreventionServiceImpl.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(threadSwitchingTarget, new StringBuffer().append("Incoming ").append((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = DriverDistractionPreventionServiceImpl.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(ddpInfoCollector, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$internal$impl$system$ddp$DdpInfoCollector == null ? (class$de$vw$mib$asl$internal$impl$system$ddp$DdpInfoCollector = DriverDistractionPreventionServiceImpl.class$("de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector")) : class$de$vw$mib$asl$internal$impl$system$ddp$DdpInfoCollector).getName()).append(" must not be null!").toString());
        this.logger = logger;
        this.threadSwitchingTarget = threadSwitchingTarget;
        this.listeners = new HashSet();
        this.ddpInfoCollector = ddpInfoCollector;
        this.ddpInfoCollector.setDriverDistractionPreventionThresholdListener(this);
    }

    @Override
    public void addDriverDistractionPreventionListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener) {
        if (driverDistractionPreventionThresholdListener == null) {
            throw new IllegalArgumentException("Incoming DriverDistractionPreventionThresholdListener must not be null!");
        }
        if (this.listeners.contains(driverDistractionPreventionThresholdListener)) {
            throw new IllegalArgumentException("Incoming DriverDistractionPreventionThresholdListener instance is already registered!");
        }
        this.listeners.add(driverDistractionPreventionThresholdListener);
        this.notifyListener(driverDistractionPreventionThresholdListener, this.isDriverDistractionPreventionRequired());
    }

    @Override
    public void removeDriverDistractionPreventionListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener) {
        this.listeners.remove(driverDistractionPreventionThresholdListener);
    }

    @Override
    public boolean isDriverDistractionPreventionRequired() {
        return this.ddpInfoCollector.isDdpRequired();
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        if (this.listeners.isEmpty()) {
            this.warn("No instances of DriverDistractionPreventionThresholdListener registered.");
            return;
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener = (DriverDistractionPreventionThresholdListener)iterator.next();
            this.notifyListener(driverDistractionPreventionThresholdListener, bl);
        }
    }

    private void notifyListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener, boolean bl) {
        this.threadSwitchingTarget.enqueue(new DriverDistractionPreventionServiceImpl$1(this, driverDistractionPreventionThresholdListener, bl));
    }

    private void warn(String string) {
        this.logger.warn(2048, string);
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

