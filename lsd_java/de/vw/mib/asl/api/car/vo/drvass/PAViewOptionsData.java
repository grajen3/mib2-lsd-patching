/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.drvass;

import de.vw.mib.asl.api.car.vo.CarFunctionState;

public interface PAViewOptionsData {
    default public CarFunctionState getPaSystemOnOff() {
    }

    default public CarFunctionState getPaConfigInformation() {
    }

    default public CarFunctionState getPaConfigWarning() {
    }

    default public CarFunctionState getPaWarningTimegap() {
    }
}

