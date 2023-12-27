/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.drvass;

import de.vw.mib.asl.api.car.vo.CarFunctionState;

public interface TSDViewOptionsData {
    default public CarFunctionState getRoadSignFilter() {
    }

    default public CarFunctionState getTrailerSpeedLimit() {
    }

    default public CarFunctionState getSpeedWarningThreshold() {
    }

    default public CarFunctionState getSpeedWarnAcoustics() {
    }
}

