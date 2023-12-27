/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.target;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentController;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore;
import de.vw.mib.asl.framework.internal.entertainmentmanager.participant.EntertainmentParticipants;
import de.vw.mib.asl.framework.internal.entertainmentmanager.target.IdleState;
import de.vw.mib.asl.framework.internal.entertainmentmanager.target.TopState;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class EntertainmentManagerTarget
extends AbstractASLHsmTarget {
    final HsmState stateLocalTop;
    final HsmState stateIdle;
    private EntertainmentController controller;
    private final EntertainmentCore core;
    private final EntertainmentParticipants participants;

    public EntertainmentController getController() {
        if (this.controller == null) {
            this.controller = new EntertainmentController(this.core, this.participants);
            this.participants.setController(this.controller);
        }
        return this.controller;
    }

    public EntertainmentManagerTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateLocalTop = new TopState(this, this.hsm, "EntManagerStateBasic", this.getWorkStateParent());
        this.stateIdle = new IdleState(this, this.hsm, "EntManagerStateIdle", this.stateLocalTop);
        this.core = new EntertainmentCore(ServiceManager.logger2, ASLFrameworkFactory.getASLFrameworkAPI().getServices());
        this.participants = new EntertainmentParticipants(ServiceManager.logger2, ASLFrameworkFactory.getASLFrameworkAPI().getServices(), this.core);
    }

    @Override
    public int getDefaultTargetId() {
        return 272503040;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateLocalTop;
    }

    @Override
    public int getSubClassifier() {
        return 16;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    final void traceEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            this.appendEvent(logMessage, eventGeneric).log();
        }
    }

    final String stateName() {
        return this.hsm.getState().getName();
    }

    final LogMessage appendEvent(LogMessage logMessage, EventGeneric eventGeneric) {
        return logMessage.append(this.stateName()).append(": Received ").append(EntertainmentManagerTarget.eventToString(eventGeneric)).append(" from context ").append(eventGeneric.getSenderTargetId());
    }

    private static String eventToString(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1400000: {
                return "ACTIVATED";
            }
            case 0x155CC1: {
                return "DEACTIVATED";
            }
            case 1400002: {
                return "CANCELLED";
            }
        }
        return "(unknown)";
    }
}

