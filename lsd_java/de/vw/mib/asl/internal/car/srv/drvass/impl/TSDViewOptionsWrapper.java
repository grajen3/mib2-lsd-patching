/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.TSDViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;

public class TSDViewOptionsWrapper
implements TSDViewOptionsData {
    private TSDViewOptions vo;

    public TSDViewOptionsWrapper(TSDViewOptions tSDViewOptions) {
        this.vo = tSDViewOptions;
    }

    @Override
    public CarFunctionState getRoadSignFilter() {
        return new CarViewOptionWrapper(this.vo.getRoadSignFilter());
    }

    @Override
    public CarFunctionState getTrailerSpeedLimit() {
        return new CarViewOptionWrapper(this.vo.getTrailerSpeedLimit());
    }

    @Override
    public CarFunctionState getSpeedWarningThreshold() {
        return new CarViewOptionWrapper(this.vo.getSpeedWarningThreshold());
    }

    @Override
    public CarFunctionState getSpeedWarnAcoustics() {
        return new CarViewOptionWrapper(this.vo.getSpeedWarnAcoustics());
    }
}

