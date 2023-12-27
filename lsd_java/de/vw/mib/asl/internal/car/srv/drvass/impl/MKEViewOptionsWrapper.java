/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.MKEViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;

public class MKEViewOptionsWrapper
implements MKEViewOptionsData {
    private MKEViewOptions vo;

    public MKEViewOptionsWrapper(MKEViewOptions mKEViewOptions) {
        this.vo = mKEViewOptions;
    }

    @Override
    public CarFunctionState getSystemOnOff() {
        return new CarViewOptionWrapper(this.vo.getSystemOnOff());
    }
}

