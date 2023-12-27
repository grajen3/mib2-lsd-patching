/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.light;

import de.vw.mib.asl.api.car.light.LightService;
import de.vw.mib.asl.api.car.light.LightServiceListener;

public interface ASLLightAPI {
    default public LightService getLightService() {
    }

    default public void addLightServiceListener(LightServiceListener lightServiceListener) {
    }

    default public void removeLightServiceListener(LightServiceListener lightServiceListener) {
    }
}

