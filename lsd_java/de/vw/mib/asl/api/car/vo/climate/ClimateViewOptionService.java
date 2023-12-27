/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.climate;

import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionListener;

public interface ClimateViewOptionService {
    default public void addListener(ClimateViewOptionListener climateViewOptionListener) {
    }

    default public void removeListener(ClimateViewOptionListener climateViewOptionListener) {
    }
}

