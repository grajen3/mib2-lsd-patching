/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.eco;

import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionListener;

public interface EcoViewOptionService {
    default public void addListener(EcoViewOptionListener ecoViewOptionListener) {
    }

    default public void removeListener(EcoViewOptionListener ecoViewOptionListener) {
    }
}

