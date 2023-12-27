/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.RGSViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.RGSViewOptions;

public class RGSViewOptionsWrapper
implements RGSViewOptionsData {
    private RGSViewOptions viewOptions;

    public RGSViewOptionsWrapper(RGSViewOptions rGSViewOptions) {
        this.viewOptions = rGSViewOptions;
    }

    @Override
    public CarFunctionState getBeltPretensionerFrontDataLeft() {
        return new CarViewOptionWrapper(this.viewOptions.getBeltPretensionerFrontDataLeft());
    }

    @Override
    public CarFunctionState getBeltPretensionerFrontDataRight() {
        return new CarViewOptionWrapper(this.viewOptions.getBeltPretensionerFrontDataRight());
    }

    @Override
    public CarFunctionState getPreCrashSystem() {
        return new CarViewOptionWrapper(this.viewOptions.getPreCrashSystem());
    }
}

