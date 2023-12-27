/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.SWAViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SWAViewOptionsWrapper
implements SWAViewOptionsData {
    private SWAViewOptions vo;
    private CarViewOption not_existent = new CarViewOption(0, 0);
    private CarViewOptionWrapper bsdSystem;
    private CarViewOptionWrapper swaSystem;
    private CarViewOptionWrapper gongState;
    private CarViewOptionWrapper brightness;

    public SWAViewOptionsWrapper(SWAViewOptions sWAViewOptions) {
        this.vo = sWAViewOptions;
    }

    @Override
    public CarFunctionState getBrightness() {
        return this.brightness;
    }

    public void setBrightness(CarViewOption carViewOption) {
        this.brightness = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getWarningTime() {
        return new CarViewOptionWrapper(this.vo.getWarningTime());
    }

    @Override
    public CarFunctionState getFrequence() {
        return new CarViewOptionWrapper(this.vo.getFrequence());
    }

    @Override
    public CarFunctionState getSwaSystem() {
        return this.swaSystem;
    }

    public void setSwaSystem(CarViewOption carViewOption) {
        this.swaSystem = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getGongState() {
        return this.gongState;
    }

    public void setGongState(CarViewOption carViewOption) {
        this.gongState = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getGongVolume() {
        return new CarViewOptionWrapper(this.vo.getGongVolume());
    }

    @Override
    public CarFunctionState getRcta() {
        return new CarViewOptionWrapper(this.vo.getRcta());
    }

    @Override
    public CarFunctionState getExitAssist() {
        return new CarViewOptionWrapper(this.vo.getExitAssist());
    }

    @Override
    public CarFunctionState getBsdSystem() {
        return this.bsdSystem;
    }

    public void setBsdSystem(CarViewOption carViewOption) {
        this.bsdSystem = new CarViewOptionWrapper(carViewOption);
    }
}

