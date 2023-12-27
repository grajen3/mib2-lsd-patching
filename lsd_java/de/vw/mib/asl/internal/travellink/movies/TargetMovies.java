/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.internal.travellink.TravelLinkTarget;
import de.vw.mib.asl.internal.travellink.movies.StateTopMovies;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

public final class TargetMovies
extends TargetHsmImpl
implements TravelLinkTarget {
    private final HsmState stateTopMovies = new StateTopMovies(this.getHsm(), "stateTopMovies", null);

    public TargetMovies(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void registerObservers() {
    }

    @Override
    public void registerDsiListeners() {
    }

    public HsmState getStateTopMovies() {
        return this.stateTopMovies;
    }
}

