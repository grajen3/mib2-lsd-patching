/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.car;

import de.vw.mib.bap.mqbab2.common.api.car.CarService;

public interface CarServiceListener {
    public static final int CAR_SERVICE__COMPASS_INFO;

    default public void updateCarData(CarService carService, int n) {
    }
}

