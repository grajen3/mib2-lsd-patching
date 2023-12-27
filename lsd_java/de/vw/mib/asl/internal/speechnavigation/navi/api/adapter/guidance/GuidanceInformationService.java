/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;

public interface GuidanceInformationService {
    default public int getEtaDays() {
    }

    default public int getEtaHours() {
    }

    default public int getEtaMinutes() {
    }

    default public long getRttMiliseconds() {
    }

    default public long getDistance() {
    }

    default public IGuidanceInfo getGuidanceInfo() {
    }

    default public int getSetupOption() {
    }
}

