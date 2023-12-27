/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.ski;

import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.ski.StateTopSki;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetSki
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopSki = new StateTopSki(this.getHsm(), "stateTopSki", null);

    public TargetSki(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void registerObservers() {
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopSki() {
        return this.stateTopSki;
    }
}

