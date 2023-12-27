/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class TimeViewOptionsWrapper
implements TimeViewOptionsData {
    private ClockViewOptions vo;
    private CarViewOptionWrapper time;

    public TimeViewOptionsWrapper(ClockViewOptions clockViewOptions) {
        this.vo = clockViewOptions;
    }

    @Override
    public CarFunctionState getTime() {
        return this.time;
    }

    public void setTime(CarViewOption carViewOption) {
        this.time = new CarViewOptionWrapper(carViewOption);
    }
}

