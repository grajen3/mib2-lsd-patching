/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;

public interface CarPersistenceService
extends ModulePersistenceService {
    default public Car loadCar() {
    }

    default public Car createCar() {
    }

    default public CarOffroad createCarOffroad() {
    }
}

