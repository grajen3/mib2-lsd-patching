/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.operation.LoadPersistenceOperation$1;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.perf.service.PerfService;

public class LoadPersistenceOperation
extends AbstractStartupTask {
    private final int PERSISTENCE_LOAD_STATUS_REQUESTED;
    public final int PERSISTENCE_LOAD_STATUS_LOADED;
    private final int EV_TARGET_PERSISTENCE_HAS_LOADED_DATA_FROM_NAMESPACE;
    private final IntIntOptHashMap persistenciesLoadStatusMap = new IntIntOptHashMap(3);
    private final EventDispatcherHSM eventDispatcher;
    private final PerfService perfService;
    private final GenericEvents genericEvents;
    private final int[] namespaces;
    private Target target;

    public LoadPersistenceOperation(StartupServices startupServices, int[] nArray) {
        super(startupServices.getLogger());
        this.PERSISTENCE_LOAD_STATUS_REQUESTED = 1;
        this.PERSISTENCE_LOAD_STATUS_LOADED = 2;
        this.EV_TARGET_PERSISTENCE_HAS_LOADED_DATA_FROM_NAMESPACE = -1366949632;
        this.namespaces = nArray;
        this.genericEvents = startupServices.getGenericEvents();
        this.eventDispatcher = startupServices.getEventDispatcher();
        this.perfService = startupServices.getPerfService();
    }

    public IntIntOptHashMap getPersistenciesLoadStatusMap() {
        return this.persistenciesLoadStatusMap;
    }

    @Override
    protected void runTask() {
        this.target = this.createTarget();
        this.persistenciesLoadStatusMap.clear();
        for (int i2 = 0; i2 < this.namespaces.length; ++i2) {
            this.trace(new StringBuffer().append("Requesting persistence: ").append(this.namespaces[i2]).toString());
            this.perfService.performanceLogPersistence(this.namespaces[i2], 0);
            this.persistenciesLoadStatusMap.put(this.namespaces[i2], 1);
            this.requestPersistenceNamespace(this.namespaces[i2]);
        }
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        try {
            this.eventDispatcher.unregisterTarget(this.target.getTargetId());
        }
        catch (Exception exception) {
            this.error("Could not unregister load persistence operation target", exception);
        }
    }

    void persistenceCallback(EventGeneric eventGeneric) {
        int n = 0;
        try {
            n = eventGeneric.getInt(0);
        }
        catch (GenericEventException genericEventException) {
            this.error("Could not send load event", genericEventException);
        }
        this.trace(new StringBuffer().append(">>>Persistence callback: key:").append(n).toString());
        this.persistenciesLoadStatusMap.put(n, 2);
        this.perfService.performanceLogPersistence(n, 1);
        IntIterator intIterator = this.persistenciesLoadStatusMap.keySet().iterator();
        boolean bl = true;
        while (intIterator.hasNext()) {
            if (this.persistenciesLoadStatusMap.get(intIterator.next()) == 2) continue;
            bl = false;
        }
        if (bl) {
            this.trace("Persistence ready, sending info to current StartupWorkUnit");
            this.finish();
        } else {
            this.trace("Not all persistencies returned, waiting...");
        }
    }

    private void requestPersistenceNamespace(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-711131136);
        eventGeneric.setInt(0, n);
        eventGeneric.setSenderTargetId(this.target.getTargetId());
        eventGeneric.setSenderEventId(-1366949632);
        this.eventDispatcher.sendSafe(eventGeneric);
    }

    private Target createTarget() {
        return new LoadPersistenceOperation$1(this, this.genericEvents, this.getLogger());
    }
}

