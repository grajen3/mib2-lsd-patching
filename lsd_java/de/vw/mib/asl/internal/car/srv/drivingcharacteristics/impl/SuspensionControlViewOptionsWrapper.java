/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drivingcharacteristics.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.SuspensionControlViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;

public class SuspensionControlViewOptionsWrapper
implements SuspensionControlViewOptionsData {
    private SuspensionControlViewOptions vo;

    public SuspensionControlViewOptionsWrapper(SuspensionControlViewOptions suspensionControlViewOptions) {
        this.vo = suspensionControlViewOptions;
    }

    @Override
    public CarFunctionState getCarJackMode() {
        return new CarViewOptionWrapper(this.vo.getCarJackMode());
    }
}

