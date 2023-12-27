/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.light;

import de.vw.mib.asl.api.car.vo.CarFunctionState;

public interface ExtLightViewOptionsData {
    default public CarFunctionState getMaskedHighBeam() {
    }

    default public CarFunctionState getHeadlightSystem() {
    }

    default public CarFunctionState getAdaptiveLightSystem() {
    }

    default public CarFunctionState getSwitchOnSensitivity() {
    }

    default public CarFunctionState getHeadlightRange() {
    }

    default public CarFunctionState getAutomaticLight() {
    }

    default public CarFunctionState getDayLight() {
    }

    default public CarFunctionState getMotorwayBlinking() {
    }

    default public CarFunctionState getTouristLight() {
    }

    default public CarFunctionState getComingHome() {
    }

    default public CarFunctionState getLeavingHome() {
    }
}

