/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.queues;

import de.vw.mib.debug.service.probes.queues.QueuesCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.event.internal.diag.EventQueueMonitor;

class EventQueueMonitorHelper
implements EventQueueMonitor {
    private final ProbeSystemServices probeSystemServices;
    private final byte eventQueueId;

    EventQueueMonitorHelper(byte by, ProbeSystemServices probeSystemServices) {
        this.eventQueueId = by;
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void updateQueue(int n) {
        QueuesCodec queuesCodec = (QueuesCodec)this.probeSystemServices.borrowCodec();
        queuesCodec.encodeQueueSize(this.eventQueueId, n);
        this.probeSystemServices.releaseCodec(queuesCodec);
    }
}

