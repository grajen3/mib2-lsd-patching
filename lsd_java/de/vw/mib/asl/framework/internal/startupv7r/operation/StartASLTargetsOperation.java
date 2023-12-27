/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.StartupConfiguration;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupServicesProvider;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartASLTargetsOperation$1;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.perf.service.PerfService;
import java.util.List;

public class StartASLTargetsOperation
extends AbstractTimedStartupTask {
    private static final long TIMEOUT;
    private final PersistableEarlyData persistableData = StartupServicesProvider.getStartupServices().getPersistableEarlyData();
    private final EventDispatcherHSM eventDispatcher;
    private final PerfService perfService;
    private final GenericEvents genericEvents;
    private final int[] aslTargetsForStart;
    private final List failedDSIs;
    private Target target;
    private IntIntOptHashMap aslTargetLoadStatus;

    public StartASLTargetsOperation(StartupServices startupServices, int[] nArray, List list) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
        this.aslTargetsForStart = nArray;
        this.failedDSIs = list;
        this.eventDispatcher = startupServices.getEventDispatcher();
        this.perfService = startupServices.getPerfService();
        this.genericEvents = startupServices.getGenericEvents();
    }

    @Override
    protected void runTask() {
        int n;
        this.target = this.createTarget(this.genericEvents);
        this.aslTargetLoadStatus = new IntIntOptHashMap(this.aslTargetsForStart.length);
        for (n = 0; n < this.aslTargetsForStart.length; ++n) {
            if (!StartupConfiguration.isAslTargetAllowedForStart(this.aslTargetsForStart[n])) continue;
            this.aslTargetLoadStatus.put(this.aslTargetsForStart[n], 1);
        }
        for (n = 0; n < this.aslTargetsForStart.length; ++n) {
            if (!StartupConfiguration.isAslTargetAllowedForStart(this.aslTargetsForStart[n])) {
                this.info(new StringBuffer().append("Skipping ASLTarget: ").append(this.aslTargetsForStart[n]).append(" because FeatureFlag was not set").toString());
                continue;
            }
            this.trace(new StringBuffer().append("Starting ASLTarget: ").append(this.aslTargetsForStart[n]).toString());
            if (this.perfService != null) {
                this.perfService.performanceLogASLTarget(this.aslTargetsForStart[n], 3);
            }
            ASLBasicActivator.startTargetByTID(this.aslTargetsForStart[n]);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.aslTargetsForStart[n], -1551499008, 106);
            eventGeneric.setBoolean(1, this.persistableData.isLastConnRadio());
            eventGeneric.setObject(2, this.failedDSIs);
            if (this.sendSafe(eventGeneric)) continue;
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setSenderTargetId(this.aslTargetsForStart[n]);
            try {
                this.aslTargetCallback(eventGeneric2);
                continue;
            }
            catch (Exception exception) {
                this.error("Could not mock the failed ASL target, startup is halting now");
            }
        }
        if (this.aslTargetLoadStatus != null && this.aslTargetLoadStatus.size() == 0) {
            this.aslTargetLoadStatus = null;
            this.finish();
        }
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        try {
            this.eventDispatcher.unregisterTarget(this.target.getTargetId());
        }
        catch (Exception exception) {
            this.error("Error while unregistering the target form StartASLTargetsOperation", exception);
        }
    }

    @Override
    protected long getTimeout() {
        return 0;
    }

    void aslTargetCallback(EventGeneric eventGeneric) {
        int n = eventGeneric.getSenderTargetId();
        this.trace(new StringBuffer().append(">>>aslCallback|Target ").append(n).toString());
        if (this.perfService != null) {
            this.perfService.performanceLogASLTarget(n, 4);
        }
        this.aslTargetLoadStatus.put(n, 2);
        boolean bl = true;
        IntIterator intIterator = this.aslTargetLoadStatus.keySet().iterator();
        while (intIterator.hasNext()) {
            if (this.aslTargetLoadStatus.get(intIterator.next()) == 2) continue;
            bl = false;
        }
        if (bl) {
            this.aslTargetLoadStatus = null;
            this.finish();
        }
    }

    private boolean sendSafe(EventGeneric eventGeneric) {
        try {
            this.eventDispatcher.send(eventGeneric);
            return true;
        }
        catch (GenericEventException genericEventException) {
            this.error("Error!", genericEventException);
            return false;
        }
    }

    private Target createTarget(GenericEvents genericEvents) {
        return new StartASLTargetsOperation$1(this, genericEvents, this.getLogger());
    }
}

