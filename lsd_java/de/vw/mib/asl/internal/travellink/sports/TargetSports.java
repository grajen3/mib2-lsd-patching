/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.sports;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.sports.StateTopSports;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetSports
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopSports = new StateTopSports(this.getHsm(), "stateTopSports", null);

    public TargetSports(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append(" StateTopMain - HSM_ENTRY event received").log();
                }
                this.registerObservers();
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 1076041854: {
                if (!ServiceManager.logger2.isTraceEnabled(2)) break;
                ServiceManager.logger2.trace(2).append(" SET_VIEW_ENTERED event received ").log();
                break;
            }
        }
        super.gotEvent(eventGeneric);
    }

    @Override
    public void registerObservers() {
        this.addObserver(2115511104);
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopSports() {
        return this.stateTopSports;
    }
}

