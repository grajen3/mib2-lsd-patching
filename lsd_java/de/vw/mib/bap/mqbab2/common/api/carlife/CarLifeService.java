/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carlife;

import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeServiceListener;

public interface CarLifeService {
    default public void addCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
    }

    default public void removeCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
    }

    default public boolean isCarLifeRouteGuidanceActive() {
    }
}

