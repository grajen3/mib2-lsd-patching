/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.drvass.PAViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.cardriverassistance.PAViewOptions;

public class PAViewOptionsWrapper
implements PAViewOptionsData {
    private PAViewOptions vo;

    public PAViewOptionsWrapper(PAViewOptions pAViewOptions) {
        this.vo = pAViewOptions;
    }

    @Override
    public CarFunctionState getPaSystemOnOff() {
        return new CarViewOptionWrapper(this.vo.getPaSystemOnOff());
    }

    @Override
    public CarFunctionState getPaConfigInformation() {
        return new CarViewOptionWrapper(this.vo.getPaConfigInformation());
    }

    @Override
    public CarFunctionState getPaConfigWarning() {
        return new CarViewOptionWrapper(this.vo.getPaConfigWarning());
    }

    @Override
    public CarFunctionState getPaWarningTimegap() {
        return new CarViewOptionWrapper(this.vo.getPaWarningTimegap());
    }
}

