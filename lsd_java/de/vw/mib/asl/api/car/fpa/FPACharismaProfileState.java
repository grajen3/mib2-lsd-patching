/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

public interface FPACharismaProfileState {
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__DEFAULT_VALUE;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C0_NORMAL;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C1_ERROR;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C2_IGNITION;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C3_SPEED;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C4_ENGINE;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C5_TRAILER;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C6_SOC_1;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C7_SOC_2;

    default public boolean isFunctionExistent() {
    }

    default public boolean getProfileFunctionState() {
    }

    default public int getProfileFunctionAvailabilityReason() {
    }
}

