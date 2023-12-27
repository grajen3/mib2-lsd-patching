/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.INavigationLocation;

public interface IGuidanceInfo {
    default public INavigationLocation getLocation() {
    }

    default public int getEtaDays() {
    }

    default public int getEtaHours() {
    }

    default public int getEtaMinutes() {
    }

    default public long getDistance() {
    }

    default public long getEtaMilliseconds() {
    }

    default public long getRttMilliseconds() {
    }

    default public int getRttDays() {
    }

    default public int getRttHours() {
    }

    default public int getRttMinutes() {
    }
}

