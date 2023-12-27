/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.fuel.StateTopFuel;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetFuel
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopFuel = new StateTopFuel(this.getHsm(), "stateTopFuel", null);

    public TargetFuel(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void registerObservers() {
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopFuel() {
        return this.stateTopFuel;
    }
}

