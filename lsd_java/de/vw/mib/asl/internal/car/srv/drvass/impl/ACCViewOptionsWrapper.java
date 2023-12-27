/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.ACCViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;

public class ACCViewOptionsWrapper
implements ACCViewOptionsData {
    private ACCViewOptions vo;

    public ACCViewOptionsWrapper(ACCViewOptions aCCViewOptions) {
        this.vo = aCCViewOptions;
    }

    @Override
    public CarFunctionState getGongState() {
        return new CarViewOptionWrapper(this.vo.getGongState());
    }

    @Override
    public CarFunctionState getGongVolume() {
        return new CarViewOptionWrapper(this.vo.getGongVolume());
    }

    @Override
    public CarFunctionState getTimegap() {
        return new CarViewOptionWrapper(this.vo.getTimegap());
    }

    @Override
    public CarFunctionState getDrivingProgram() {
        return new CarViewOptionWrapper(this.vo.getDrivingProgram());
    }

    @Override
    public CarFunctionState getDefaultMode() {
        return new CarViewOptionWrapper(this.vo.getDefaultMode());
    }

    @Override
    public CarFunctionState getCurveAssist() {
        return new CarViewOptionWrapper(this.vo.getCurveAssist());
    }

    @Override
    public CarFunctionState getSpeedLimitAdoption() {
        return new CarViewOptionWrapper(this.vo.getSpeedLimitAdoption());
    }

    @Override
    public CarFunctionState getSpeedLimitOffset() {
        return new CarViewOptionWrapper(this.vo.getSpeedLimitOffset());
    }

    @Override
    public CarFunctionState getTrafficJamAssist() {
        return new CarViewOptionWrapper(this.vo.getTrafficJamAssist());
    }

    @Override
    public CarFunctionState getDistanceWarning() {
        return new CarViewOptionWrapper(this.vo.getDistanceWarning());
    }

    @Override
    public CarFunctionState getPaccSensibility() {
        return new CarViewOptionWrapper(this.vo.getPaccSensibility());
    }

    @Override
    public CarFunctionState getPaccMaxSpeed() {
        return new CarViewOptionWrapper(this.vo.getPaccMaxSpeed());
    }

    @Override
    public CarFunctionState getPaccMeanVelocity() {
        return new CarViewOptionWrapper(this.vo.getPaccMeanVelocity());
    }

    @Override
    public CarFunctionState getPaccMeanConsumption() {
        return new CarViewOptionWrapper(this.vo.getPaccMeanConsumption());
    }

    @Override
    public CarFunctionState getPaccCoastingPercentage() {
        return new CarViewOptionWrapper(this.vo.getPaccCoastingPercentage());
    }

    @Override
    public CarFunctionState getPaccDrivingProgram() {
        return new CarViewOptionWrapper(this.vo.getPaccDrivingProgram());
    }

    @Override
    public CarFunctionState getPaccSystemState() {
        return new CarViewOptionWrapper(this.vo.getPaccSystemState());
    }

    @Override
    public CarFunctionState getSetFactoryDefault() {
        return new CarViewOptionWrapper(this.vo.setFactoryDefault);
    }
}

