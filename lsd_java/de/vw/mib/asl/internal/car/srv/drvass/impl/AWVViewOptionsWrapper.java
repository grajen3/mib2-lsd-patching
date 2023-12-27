/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.AWVViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AWVViewOptionsWrapper
implements AWVViewOptionsData {
    private AWVViewOptions vo;
    private CarViewOptionWrapper cityBrakeSystem;
    private CarViewOptionWrapper awvSystem;

    public AWVViewOptionsWrapper(AWVViewOptions aWVViewOptions) {
        this.vo = aWVViewOptions;
    }

    public void setAwvSystem(CarViewOption carViewOption) {
        this.awvSystem = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getSystem() {
        return this.awvSystem;
    }

    public void setCityBrakeSystem(CarViewOption carViewOption) {
        this.cityBrakeSystem = new CarViewOptionWrapper(carViewOption);
    }

    @Override
    public CarFunctionState getCityBrakeSystem() {
        return this.cityBrakeSystem;
    }

    @Override
    public CarFunctionState getWarning() {
        return new CarViewOptionWrapper(this.vo.getWarning());
    }

    @Override
    public CarFunctionState getGong() {
        return new CarViewOptionWrapper(this.vo.getGong());
    }

    @Override
    public CarFunctionState getGongVolume() {
        return new CarViewOptionWrapper(this.vo.getGongVolume());
    }

    @Override
    public CarFunctionState getBrakeJerk() {
        return new CarViewOptionWrapper(this.vo.getBrakeJerk());
    }

    @Override
    public CarFunctionState getEmergencyBrake() {
        return new CarViewOptionWrapper(this.vo.getEmergencyBrake());
    }

    @Override
    public CarFunctionState getDistanceWarning() {
        return new CarViewOptionWrapper(this.vo.getDistanceWarning());
    }

    @Override
    public CarFunctionState getWarningTimegap() {
        return new CarViewOptionWrapper(this.vo.getWarningTimegap());
    }

    @Override
    public CarFunctionState getSetFactoryDefault() {
        return new CarViewOptionWrapper(this.vo.getSetFactoryDefault());
    }
}

