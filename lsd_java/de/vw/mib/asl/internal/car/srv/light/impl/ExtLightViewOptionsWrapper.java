/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.light.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.light.ExtLightViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carlight.ExtLightViewOptions;

public class ExtLightViewOptionsWrapper
implements ExtLightViewOptionsData {
    private ExtLightViewOptions vo;

    public ExtLightViewOptionsWrapper(ExtLightViewOptions extLightViewOptions) {
        this.vo = extLightViewOptions;
    }

    public ExtLightViewOptions getExtLightVO() {
        return this.vo;
    }

    @Override
    public CarFunctionState getMaskedHighBeam() {
        return new CarViewOptionWrapper(this.vo.getMaskedHighBeam());
    }

    @Override
    public CarFunctionState getHeadlightSystem() {
        return new CarViewOptionWrapper(this.vo.getHeadlightSystem());
    }

    @Override
    public CarFunctionState getAdaptiveLightSystem() {
        return new CarViewOptionWrapper(this.vo.getAdaptiveLightSystem());
    }

    @Override
    public CarFunctionState getSwitchOnSensitivity() {
        return new CarViewOptionWrapper(this.vo.getSwitchOnSensitivity());
    }

    @Override
    public CarFunctionState getHeadlightRange() {
        return new CarViewOptionWrapper(this.vo.getHeadlightRange());
    }

    @Override
    public CarFunctionState getAutomaticLight() {
        return new CarViewOptionWrapper(this.vo.getAutomaticLight());
    }

    @Override
    public CarFunctionState getDayLight() {
        return new CarViewOptionWrapper(this.vo.getDayLight());
    }

    @Override
    public CarFunctionState getMotorwayBlinking() {
        return new CarViewOptionWrapper(this.vo.getMotorwayBlinking());
    }

    @Override
    public CarFunctionState getTouristLight() {
        return new CarViewOptionWrapper(this.vo.getTouristLight());
    }

    @Override
    public CarFunctionState getComingHome() {
        return new CarViewOptionWrapper(this.vo.getComingHome());
    }

    @Override
    public CarFunctionState getLeavingHome() {
        return new CarViewOptionWrapper(this.vo.getLeavingHome());
    }
}

