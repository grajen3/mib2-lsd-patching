/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.NVViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.NVViewOptions;

public class NVViewOptionsWrapper
implements NVViewOptionsData {
    private NVViewOptions vo;

    public NVViewOptionsWrapper(NVViewOptions nVViewOptions) {
        this.vo = nVViewOptions;
    }

    @Override
    public CarFunctionState getObjectDetection() {
        return new CarViewOptionWrapper(this.vo.getObjectDetection());
    }

    @Override
    public CarFunctionState getContrast() {
        return new CarViewOptionWrapper(this.vo.getContrast());
    }
}

