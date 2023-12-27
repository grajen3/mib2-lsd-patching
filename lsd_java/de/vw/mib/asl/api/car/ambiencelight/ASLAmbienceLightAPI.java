/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.ambiencelight;

import de.vw.mib.asl.api.car.ambiencelight.AmbienceLightService;
import de.vw.mib.asl.api.car.ambiencelight.AmbienceLightServiceListener;

public interface ASLAmbienceLightAPI {
    default public void addAmbienceLightServiceListener(AmbienceLightServiceListener ambienceLightServiceListener) {
    }

    default public void removeAmbienceLightServiceListener(AmbienceLightServiceListener ambienceLightServiceListener) {
    }

    default public AmbienceLightService getAmbienceLightService() {
    }
}

