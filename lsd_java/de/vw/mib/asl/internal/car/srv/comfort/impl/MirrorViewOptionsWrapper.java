/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.comfort.MirrorViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carcomfort.MirrorViewOptions;

public class MirrorViewOptionsWrapper
implements MirrorViewOptionsData {
    private MirrorViewOptions vo;

    public MirrorViewOptionsWrapper(MirrorViewOptions mirrorViewOptions) {
        this.vo = mirrorViewOptions;
    }

    @Override
    public CarFunctionState getMirrorSyncAdjust() {
        return new CarViewOptionWrapper(this.vo.getMirrorSyncAdjust());
    }

    @Override
    public CarFunctionState getMirrorLowering() {
        return new CarViewOptionWrapper(this.vo.getMirrorLowering());
    }

    @Override
    public CarFunctionState getMirrorFolding() {
        return new CarViewOptionWrapper(this.vo.getMirrorFolding());
    }

    @Override
    public CarFunctionState getMirrorHeating() {
        return new CarViewOptionWrapper(this.vo.getMirrorHeating());
    }

    @Override
    public CarFunctionState getMirrorDimming() {
        return new CarViewOptionWrapper(this.vo.getMirrorDimming());
    }
}

