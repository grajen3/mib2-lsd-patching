/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.kombi.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.SIAViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carkombi.SIAViewOptions;

public class SIAViewOptionsWrapper
implements SIAViewOptionsData {
    private SIAViewOptions vo;

    public SIAViewOptionsWrapper(SIAViewOptions sIAViewOptions) {
        this.vo = sIAViewOptions;
    }

    @Override
    public CarFunctionState getServiceData() {
        return new CarViewOptionWrapper(this.vo.getServiceData());
    }

    @Override
    public CarFunctionState getOilInspection() {
        return new CarViewOptionWrapper(this.vo.getOilInspection());
    }

    @Override
    public CarFunctionState getReset() {
        return new CarViewOptionWrapper(this.vo.getReset());
    }
}

