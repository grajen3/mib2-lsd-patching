/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.e_traction.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.e_traction.HybridViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class HybridViewOptionsWrapper
implements HybridViewOptionsData {
    private HybridViewOptions vo;

    public HybridViewOptionsWrapper(HybridViewOptions hybridViewOptions) {
        this.vo = hybridViewOptions;
    }

    @Override
    public CarFunctionState getHybridTargetRange() {
        return new CarViewOptionWrapper(this.vo.getHybridTargetRange());
    }

    @Override
    public CarFunctionState getHybridActivePedal() {
        return new CarViewOptionWrapper(this.vo.getHybridActivePedal());
    }
}

