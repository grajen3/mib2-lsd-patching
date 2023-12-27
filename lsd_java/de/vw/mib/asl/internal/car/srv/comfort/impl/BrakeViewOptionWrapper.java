/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.BrakeViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.BrakeViewOptions;

public class BrakeViewOptionWrapper
implements BrakeViewOptionsData {
    BrakeViewOptions brakeViewOptions;

    public BrakeViewOptionWrapper(BrakeViewOptions brakeViewOptions) {
        this.brakeViewOptions = brakeViewOptions;
    }

    @Override
    public CarFunctionState getBrakeEscMode() {
        return new CarViewOptionWrapper(this.brakeViewOptions.getBrakeEscMode());
    }

    @Override
    public CarFunctionState getBrakeAutoHold() {
        return new CarViewOptionWrapper(this.brakeViewOptions.getBrakeAutoHold());
    }

    @Override
    public CarFunctionState getBrakeElectricalParking() {
        return new CarViewOptionWrapper(this.brakeViewOptions.getBrakeElectricalParking());
    }

    @Override
    public boolean isSystemType() {
        return this.brakeViewOptions.getConfiguration().isSystemtype();
    }
}

