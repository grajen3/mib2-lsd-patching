/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.UGDOViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public class UGDOViewOptionsWrapper
implements UGDOViewOptionsData {
    UGDOViewOptions vo;

    public UGDOViewOptionsWrapper(UGDOViewOptions uGDOViewOptions) {
        this.vo = uGDOViewOptions;
    }

    @Override
    public CarFunctionState getButtonList() {
        return new CarViewOptionWrapper(this.vo.getButtonList());
    }

    @Override
    public CarFunctionState getDeleteButton() {
        return new CarViewOptionWrapper(this.vo.getDeleteButton());
    }

    @Override
    public CarFunctionState getVersionData() {
        return new CarViewOptionWrapper(this.vo.getVersionData());
    }
}

