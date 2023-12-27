/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.eco.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.eco.StartStopViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class StartStopViewOptionsWrapper
implements StartStopViewOptionsData {
    private StartStopViewOptions vo;
    private CarViewOptionWrapper startStop;

    public StartStopViewOptionsWrapper(StartStopViewOptions startStopViewOptions) {
        this.vo = startStopViewOptions;
    }

    @Override
    public CarFunctionState getStartStopProhibitReasonList() {
        return new CarViewOptionWrapper(this.vo.getStartStopProhibitReasonList());
    }

    @Override
    public CarFunctionState getStartStopRestartProhibitReasonList() {
        return new CarViewOptionWrapper(this.vo.getStartStopRestartProhibitReasonList());
    }

    @Override
    public CarFunctionState getStartStopRestartReasonList() {
        return new CarViewOptionWrapper(this.vo.getStartStopRestartReasonList());
    }

    @Override
    public CarFunctionState getState() {
        return new CarViewOptionWrapper(this.vo.getState());
    }

    @Override
    public CarFunctionState getStartStop() {
        return this.startStop;
    }

    public void setStartStop(CarViewOption carViewOption) {
        this.startStop = new CarViewOptionWrapper(carViewOption);
    }
}

