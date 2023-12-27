/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.LdwhcaViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;

public class LdwhcaViewOptionWrapper
implements LdwhcaViewOptionsData {
    private LDWHCAViewOptions vo;

    public LdwhcaViewOptionWrapper(LDWHCAViewOptions lDWHCAViewOptions) {
        this.vo = lDWHCAViewOptions;
    }

    @Override
    public CarFunctionState getLdwhcaSystemOnOff() {
        return new CarViewOptionWrapper(this.vo.getLdwhcaSystemOnOff());
    }

    @Override
    public CarFunctionState getHCAToleranceLevel() {
        return new CarViewOptionWrapper(this.vo.getHCAToleranceLevel());
    }

    @Override
    public CarFunctionState getLDWSteeringWheelVibration() {
        return new CarViewOptionWrapper(this.vo.getLDWSteeringWheelVibration());
    }

    @Override
    public CarFunctionState getHCAInterventionStyle() {
        return new CarViewOptionWrapper(this.vo.getHCAInterventionStyle());
    }
}

