/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.PowerStateListener;

public interface PowerStateService {
    public static final int POWER_STATE_OFF;
    public static final int POWER_STATE_OFF_CLOCK;
    public static final int POWER_STATE_ON;
    public static final int POWER_STATE_DIAGNOSE;
    public static final int POWER_STATE_SWDL;
    public static final int POWER_STATE_NOT_INIT;
    public static final int POWER_STATE_LIMITED_PHONE_MODE;
    public static final int POWER_STATE_ON_RESTRICTED;
    public static final int POWER_STATE_ON_ERROR;

    default public int getPowerState() {
    }

    default public void addListener(PowerStateListener powerStateListener) {
    }

    default public void removeListener(PowerStateListener powerStateListener) {
    }
}

