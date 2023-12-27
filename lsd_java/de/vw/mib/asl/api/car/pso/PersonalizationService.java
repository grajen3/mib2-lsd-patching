/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.pso;

import de.vw.mib.asl.api.car.pso.PersonalizationListener;

public interface PersonalizationService {
    public static final int RESET_STATE_UNKNOWN;
    public static final int RESET_STATE_NOT_EXISTING;
    public static final int RESET_STATE_NOT_AVAILABLE;
    public static final int RESET_STATE_AVAILABLE;

    default public int getResetState() {
    }

    default public void addListener(PersonalizationListener personalizationListener) {
    }

    default public void removeListener(PersonalizationListener personalizationListener) {
    }

    default public String getActiveProfileName() {
    }

    default public int getActiveDefaultProfileId() {
    }

    default public boolean getIsActive() {
    }
}

