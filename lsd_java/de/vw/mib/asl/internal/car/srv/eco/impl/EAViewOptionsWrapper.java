/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.eco.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.eco.EAViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.careco.EAViewOptions;

public class EAViewOptionsWrapper
implements EAViewOptionsData {
    private EAViewOptions vo;

    public EAViewOptionsWrapper(EAViewOptions eAViewOptions) {
        this.vo = eAViewOptions;
    }

    @Override
    public CarFunctionState getSystem() {
        return new CarViewOptionWrapper(this.vo.getSystem());
    }
}

