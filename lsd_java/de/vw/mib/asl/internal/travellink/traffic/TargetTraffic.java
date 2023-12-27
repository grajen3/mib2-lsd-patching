/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.traffic;

import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.traffic.StateTopTraffic;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetTraffic
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopTraffic = new StateTopTraffic(this.getHsm(), "stateTopTraffic", null);

    public TargetTraffic(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void registerObservers() {
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopTraffic() {
        return this.stateTopTraffic;
    }
}

