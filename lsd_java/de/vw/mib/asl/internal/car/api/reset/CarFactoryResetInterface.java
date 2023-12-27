/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.reset;

import de.vw.mib.asl.internal.car.api.reset.CarFactoryResetListener;

public interface CarFactoryResetInterface {
    default public void addListener(CarFactoryResetListener carFactoryResetListener) {
    }

    default public void removeListener(CarFactoryResetListener carFactoryResetListener) {
    }
}

