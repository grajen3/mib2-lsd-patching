/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.vehiclestates.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleInfoViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;

public class VehicleInfoViewOptionsWrapper
implements VehicleInfoViewOptionsData {
    private VehicleInfoViewOptions vo;

    public VehicleInfoViewOptionsWrapper(VehicleInfoViewOptions vehicleInfoViewOptions) {
        this.vo = vehicleInfoViewOptions;
    }

    @Override
    public CarFunctionState getDrvSchoolSystem() {
        return new CarViewOptionWrapper(this.vo.drvSchoolSystem);
    }
}

