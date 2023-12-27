/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.drvass;

import de.vw.mib.asl.api.car.vo.CarFunctionState;

public interface AWVViewOptionsData {
    default public CarFunctionState getSystem() {
    }

    default public CarFunctionState getWarning() {
    }

    default public CarFunctionState getGong() {
    }

    default public CarFunctionState getGongVolume() {
    }

    default public CarFunctionState getBrakeJerk() {
    }

    default public CarFunctionState getEmergencyBrake() {
    }

    default public CarFunctionState getDistanceWarning() {
    }

    default public CarFunctionState getWarningTimegap() {
    }

    default public CarFunctionState getSetFactoryDefault() {
    }

    default public CarFunctionState getCityBrakeSystem() {
    }
}

