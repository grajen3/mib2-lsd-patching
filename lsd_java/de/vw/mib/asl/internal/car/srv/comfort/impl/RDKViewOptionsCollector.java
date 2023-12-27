/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.RDKViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.global.CarViewOption;

public class RDKViewOptionsCollector
implements RDKViewOptionsData {
    private CarFunctionState tirePressureDisplay = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState tirePressureLevel = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState rkaSetCalibrate = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private CarFunctionState tireType = new CarViewOptionWrapper(new CarViewOption(0, 1));

    @Override
    public CarFunctionState getTirePressureDisplay() {
        return this.tirePressureDisplay;
    }

    public void setTirePressureDisplay(CarViewOption carViewOption) {
        this.tirePressureDisplay = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getTirePressureLevel() {
        return this.tirePressureLevel;
    }

    public void setTirePressureLevel(CarViewOption carViewOption) {
        this.tirePressureLevel = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getRKASetCalibrate() {
        return this.rkaSetCalibrate;
    }

    public void setRKASetCalibrate(CarViewOption carViewOption) {
        this.rkaSetCalibrate = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getTireType() {
        return this.tireType;
    }

    public void setTireType(CarViewOption carViewOption) {
        this.tireType = new CarViewOptionWrapper(carViewOption);
    }
}

