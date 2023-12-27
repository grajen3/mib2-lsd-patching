/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.eco;

import de.vw.mib.asl.api.car.vo.CarFunctionState;

public interface StartStopViewOptionsData {
    default public CarFunctionState getStartStopProhibitReasonList() {
    }

    default public CarFunctionState getStartStopRestartProhibitReasonList() {
    }

    default public CarFunctionState getStartStopRestartReasonList() {
    }

    default public CarFunctionState getState() {
    }

    default public CarFunctionState getStartStop() {
    }
}

