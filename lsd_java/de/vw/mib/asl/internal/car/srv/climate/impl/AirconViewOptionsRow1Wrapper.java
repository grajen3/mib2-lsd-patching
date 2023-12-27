/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.climate.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.climate.AirconRowViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;

public class AirconViewOptionsRow1Wrapper
implements AirconRowViewOptionsData {
    private AirconRowViewOptions vo;
    AirconMasterViewOptions storedVO;

    public AirconViewOptionsRow1Wrapper(AirconRowViewOptions airconRowViewOptions) {
        this.vo = airconRowViewOptions;
    }

    @Override
    public AirconRowViewOptions getAirconRowVO() {
        return this.vo;
    }

    @Override
    public void setStoredMasterViewOptions(AirconMasterViewOptions airconMasterViewOptions) {
        this.storedVO = airconMasterViewOptions;
    }

    @Override
    public AirconMasterViewOptions getStoredMasterViewOptions() {
        return this.storedVO;
    }

    @Override
    public CarFunctionState getSteeringWheelHeaterAdjustViaSeatHeating() {
        return new CarViewOptionWrapper(this.storedVO.airconSteeringWheelHeaterViewOptions.getAdjustViaSeatHeating());
    }

    @Override
    public CarFunctionState getSteeringWheelHeaterHeatingStep() {
        return new CarViewOptionWrapper(this.storedVO.airconSteeringWheelHeaterViewOptions.getHeatingStep());
    }

    @Override
    public CarFunctionState getSteeringWheelHeaterAutoHeating() {
        return new CarViewOptionWrapper(this.storedVO.airconSteeringWheelHeaterViewOptions.getAutoHeating());
    }

    @Override
    public CarFunctionState getAirconHeater() {
        return new CarViewOptionWrapper(this.storedVO.getAirconHeater());
    }

    @Override
    public CarFunctionState getFrontWindowHeaterAuto() {
        return new CarViewOptionWrapper(this.storedVO.getAirconFrontWindowHeaterAuto());
    }

    @Override
    public CarFunctionState getAirCirculationAuto() {
        return new CarViewOptionWrapper(this.storedVO.getAirconAirCirculationAuto());
    }

    @Override
    public boolean getIsKME() {
        return this.vo.zoneLeftViewOptions.airconTemp.getState() == 0 && this.vo.zoneRightViewOptions.airconTemp.getState() == 0;
    }
}

