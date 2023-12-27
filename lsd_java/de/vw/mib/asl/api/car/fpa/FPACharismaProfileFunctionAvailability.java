/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileState;

public interface FPACharismaProfileFunctionAvailability {
    public static final int PROFILE_NONE;
    public static final int PROFILE_COMFORT;
    public static final int PROFILE_NORMAL;
    public static final int PROFILE_SPORT;
    public static final int PROFILE_OFFROAD;
    public static final int PROFILE_ECO;
    public static final int PROFILE_RACE;
    public static final int PROFILE_INDIVIDUAL;
    public static final int PROFILE_RANGE;
    public static final int PROFILE_SNOW;
    public static final int PROFILE_OFFROAD_AUTO;
    public static final int PROFILE_OFFROAD_INDIVIDUAL;

    default public boolean[] getProfilesAvailable() {
    }

    default public FPACharismaProfileState[] getFunctionStates() {
    }

    default public void setFunctionStateAt(FPACharismaProfileState fPACharismaProfileState, int n) {
    }
}

