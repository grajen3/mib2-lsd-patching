/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.queues;

import de.vw.mib.debug.common.probes.queues.QueuesProbeConfiguration;
import de.vw.mib.debug.service.probes.queues.EventQueueMonitorHelper;
import de.vw.mib.debug.service.probes.queues.QueuesCodec;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.event.internal.diag.EventDispatcherDiag;
import de.vw.mib.event.internal.diag.EventQueueMonitor;

public class QueuesProbe
extends AbstractDebugProbe {
    private EventDispatcherDiag eventDispatcherDiag;
    private EventQueueMonitor statemachineEventQueueMonitor;
    private EventQueueMonitor systemEventQueueMonitor;
    private EventQueueMonitor viewEventQueueMonitor;
    static /* synthetic */ Class class$de$vw$mib$event$internal$diag$EventDispatcherDiag;

    public QueuesProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    protected AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new QueuesCodec(probeSystemServices);
    }

    @Override
    protected boolean deactivateProbe() {
        this.eventDispatcherDiag.registerStatemachineEventQueueMonitor(null);
        this.eventDispatcherDiag.registerSystemEventQueueMonitor(null);
        this.eventDispatcherDiag.registerViewEventQueueMonitor(null);
        return true;
    }

    @Override
    protected boolean initProbe() {
        this.eventDispatcherDiag = (EventDispatcherDiag)this.probeSystemServices.getService((class$de$vw$mib$event$internal$diag$EventDispatcherDiag == null ? (class$de$vw$mib$event$internal$diag$EventDispatcherDiag = QueuesProbe.class$("de.vw.mib.event.internal.diag.EventDispatcherDiag")) : class$de$vw$mib$event$internal$diag$EventDispatcherDiag).getName());
        return true;
    }

    @Override
    protected boolean configureProbe() {
        QueuesProbeConfiguration queuesProbeConfiguration = (QueuesProbeConfiguration)this.probeSystemServices.getConfiguration();
        if (queuesProbeConfiguration.isMonitorStatemachineEventQueueEnabled()) {
            if (this.statemachineEventQueueMonitor == null) {
                this.statemachineEventQueueMonitor = new EventQueueMonitorHelper(0, this.probeSystemServices);
                this.eventDispatcherDiag.registerStatemachineEventQueueMonitor(this.statemachineEventQueueMonitor);
            }
        } else if (this.statemachineEventQueueMonitor != null) {
            this.statemachineEventQueueMonitor = null;
            this.eventDispatcherDiag.registerStatemachineEventQueueMonitor(this.statemachineEventQueueMonitor);
        }
        if (queuesProbeConfiguration.isMonitorSystemEventQueueEnabled()) {
            if (this.systemEventQueueMonitor == null) {
                this.systemEventQueueMonitor = new EventQueueMonitorHelper(1, this.probeSystemServices);
                this.eventDispatcherDiag.registerSystemEventQueueMonitor(this.systemEventQueueMonitor);
            }
        } else if (this.systemEventQueueMonitor != null) {
            this.systemEventQueueMonitor = null;
            this.eventDispatcherDiag.registerSystemEventQueueMonitor(this.systemEventQueueMonitor);
        }
        if (queuesProbeConfiguration.isMonitorViewEventQueueEnabled()) {
            if (this.viewEventQueueMonitor == null) {
                this.viewEventQueueMonitor = new EventQueueMonitorHelper(2, this.probeSystemServices);
                this.eventDispatcherDiag.registerViewEventQueueMonitor(this.viewEventQueueMonitor);
            }
        } else if (this.viewEventQueueMonitor != null) {
            this.viewEventQueueMonitor = null;
            this.eventDispatcherDiag.registerViewEventQueueMonitor(this.viewEventQueueMonitor);
        }
        return true;
    }

    @Override
    protected boolean activateProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
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

