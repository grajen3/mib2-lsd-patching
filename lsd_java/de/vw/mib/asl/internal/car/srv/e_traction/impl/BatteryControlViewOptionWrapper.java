/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.e_traction.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.e_traction.BatteryControlViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class BatteryControlViewOptionWrapper
implements BatteryControlViewOptionsData {
    private BatteryControlViewOptions vo;

    public BatteryControlViewOptionWrapper(BatteryControlViewOptions batteryControlViewOptions) {
        this.vo = batteryControlViewOptions;
    }

    @Override
    public CarFunctionState getProfileList() {
        return new CarViewOptionWrapper(this.vo.getProfileList());
    }
}

