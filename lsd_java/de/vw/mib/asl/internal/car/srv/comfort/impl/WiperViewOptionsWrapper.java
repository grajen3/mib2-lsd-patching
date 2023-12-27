/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.WiperViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public class WiperViewOptionsWrapper
implements WiperViewOptionsData {
    private WiperViewOptions vo;

    public WiperViewOptionsWrapper(WiperViewOptions wiperViewOptions) {
        this.vo = wiperViewOptions;
    }

    @Override
    public CarFunctionState getWiperRainSensorOnOff() {
        return new CarViewOptionWrapper(this.vo.getWiperRainSensorOnOff());
    }

    @Override
    public CarFunctionState getWiperRearWiping() {
        return new CarViewOptionWrapper(this.vo.getWiperRearWiping());
    }

    @Override
    public CarFunctionState getEasyEntrySteeringColumn() {
        return new CarViewOptionWrapper(this.vo.getEasyEntrySteeringColumn());
    }
}

