/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateService;
import de.vw.mib.asl.api.car.climate.ClimateServiceListener;

public interface ASLClimateAPI {
    default public void addClimateServiceListener(ClimateServiceListener climateServiceListener) {
    }

    default public void removeClimateServiceListener(ClimateServiceListener climateServiceListener) {
    }

    default public ClimateService getClimateService() {
    }
}

