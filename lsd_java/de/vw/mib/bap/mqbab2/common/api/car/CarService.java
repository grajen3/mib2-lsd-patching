/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.car;

import de.vw.mib.bap.mqbab2.common.api.car.CarServiceListener;

public interface CarService {
    default public void addCarServiceListener(CarServiceListener carServiceListener, int[] nArray) {
    }

    default public void removeCarServiceListener(CarServiceListener carServiceListener, int[] nArray) {
    }

    default public int getCarCompassInfoAngle() {
    }
}

