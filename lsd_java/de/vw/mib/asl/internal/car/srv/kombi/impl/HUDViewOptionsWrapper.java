/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.kombi.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.HUDViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HUDViewOptionsWrapper
implements HUDViewOptionsData {
    private static final CarFunctionState NOT_EXISTING = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private HUDViewOptions vo;
    private CarFunctionState contentViewOptions;
    private HUDConfiguration configuration;

    public HUDViewOptionsWrapper(HUDViewOptions hUDViewOptions) {
        this.vo = hUDViewOptions;
        this.contentViewOptions = new CarViewOptionWrapper(hUDViewOptions.getContent());
        this.configuration = hUDViewOptions.getConfiguration();
    }

    @Override
    public CarFunctionState getBrightness() {
        return new CarViewOptionWrapper(this.vo.getBrightness());
    }

    @Override
    public CarFunctionState getColour() {
        return new CarViewOptionWrapper(this.vo.getColour());
    }

    @Override
    public CarFunctionState getSpeed() {
        return this.configuration.isSpeed() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getWarning() {
        return this.configuration.isWarning() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getAcc() {
        return this.configuration.isAcc() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getNightvision() {
        return this.configuration.isNightvision() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getRoadsign() {
        return this.configuration.isRoadsign() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getRgi() {
        return this.configuration.isRgi() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getNavInfo() {
        return this.configuration.isNavInfo() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getInfoList() {
        return this.configuration.isInfoList() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getHca() {
        return this.configuration.isHca() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getGra() {
        return this.configuration.isGra() ? this.contentViewOptions : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getTelephone() {
        return this.configuration.isTelephone() ? this.contentViewOptions : NOT_EXISTING;
    }
}

