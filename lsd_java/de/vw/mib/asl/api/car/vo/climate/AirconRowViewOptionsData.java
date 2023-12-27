/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.climate;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;

public interface AirconRowViewOptionsData {
    default public AirconRowViewOptions getAirconRowVO() {
    }

    default public void setStoredMasterViewOptions(AirconMasterViewOptions airconMasterViewOptions) {
    }

    default public AirconMasterViewOptions getStoredMasterViewOptions() {
    }

    default public CarFunctionState getSteeringWheelHeaterAdjustViaSeatHeating() {
    }

    default public CarFunctionState getSteeringWheelHeaterHeatingStep() {
    }

    default public CarFunctionState getSteeringWheelHeaterAutoHeating() {
    }

    default public CarFunctionState getAirconHeater() {
    }

    default public CarFunctionState getFrontWindowHeaterAuto() {
    }

    default public CarFunctionState getAirCirculationAuto() {
    }

    default public boolean getIsKME() {
    }
}

