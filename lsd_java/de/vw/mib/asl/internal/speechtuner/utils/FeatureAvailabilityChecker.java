/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;

public interface FeatureAvailabilityChecker {
    default public void setEntertainmentSourceHandler(EntertainmentSourceHandler entertainmentSourceHandler) {
    }

    default public boolean isAmFrequencyActive() {
    }

    default public boolean isAmHDFrequencyActive() {
    }

    default public boolean isFmFrequencyActive() {
    }

    default public boolean isFmHDFrequencyActive() {
    }

    default public boolean isFmByNameActive() {
    }

    default public boolean isDabByNameActive() {
    }

    default public boolean isSiriusByNameActive() {
    }

    default public boolean isFmByNameCoded() {
    }

    default public boolean isDabByNameCoded() {
    }

    default public boolean isSiriusByNameCoded() {
    }

    default public boolean hasOnlyOneBand() {
    }
}

