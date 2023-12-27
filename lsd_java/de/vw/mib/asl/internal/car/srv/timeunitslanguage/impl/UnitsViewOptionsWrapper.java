/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.UnitsViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class UnitsViewOptionsWrapper
implements UnitsViewOptionsData {
    private UnitmasterViewOptions vo;
    private CarViewOptionWrapper units;

    public UnitsViewOptionsWrapper(UnitmasterViewOptions unitmasterViewOptions) {
        this.vo = unitmasterViewOptions;
    }

    @Override
    public CarFunctionState getUnits() {
        return this.units;
    }

    public void setUnits(CarViewOption carViewOption) {
        this.units = new CarViewOptionWrapper(carViewOption);
    }
}

