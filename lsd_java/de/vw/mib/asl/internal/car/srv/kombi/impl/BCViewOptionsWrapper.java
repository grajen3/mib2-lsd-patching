/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.kombi.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class BCViewOptionsWrapper
implements BCViewOptionsData {
    private BCViewOptions vo;
    private static final CarFunctionState NOT_EXISTING = new CarViewOptionWrapper(new CarViewOption(0, 1));
    private BCFISAdditionalConfiguration fisAdditionalConfiguration;
    private CarFunctionState menue1Config;
    private CarFunctionState menue2Config;
    private CarFunctionState menue3Config;
    private CarFunctionState commonMFAFunctions;

    public BCViewOptionsWrapper(BCViewOptions bCViewOptions) {
        this.vo = bCViewOptions;
        this.fisAdditionalConfiguration = bCViewOptions.getConfiguration().getFisAdditionalConfiguration();
        this.menue1Config = new CarViewOptionWrapper(bCViewOptions.getMenue1Config());
        this.menue2Config = new CarViewOptionWrapper(bCViewOptions.getMenue2Config());
        this.menue3Config = new CarViewOptionWrapper(bCViewOptions.getMenue3Config());
        this.commonMFAFunctions = bCViewOptions.getMenue1Config().getState() == 0 && bCViewOptions.getMenue2Config().getState() == 0 && bCViewOptions.getMenue3Config().getState() == 0 ? NOT_EXISTING : (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() == 2 && bCViewOptions.getMenue3Config().getState() == 2 ? this.menue1Config : (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() == 2 && bCViewOptions.getMenue3Config().getState() != 2 ? this.menue3Config : (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() != 2 ? this.menue2Config : this.menue1Config)));
    }

    @Override
    public CarFunctionState getSpeedWarning() {
        return new CarViewOptionWrapper(this.vo.getSpeedWarning());
    }

    @Override
    public CarFunctionState getDigitalSpeed() {
        return new CarViewOptionWrapper(this.vo.getDigitalSpeed());
    }

    @Override
    public CarFunctionState getConsumerDisplay() {
        return new CarViewOptionWrapper(this.vo.getConsumerDisplay());
    }

    @Override
    public CarFunctionState getLifeTipsDisplay() {
        return new CarViewOptionWrapper(this.vo.getLifeTipsDisplay());
    }

    @Override
    public CarFunctionState getOilTemperature() {
        return new CarViewOptionWrapper(this.vo.getOilTemperature());
    }

    @Override
    public CarFunctionState getVzaMFA() {
        return new CarViewOptionWrapper(this.vo.getVzaMFA());
    }

    @Override
    public CarFunctionState getAstaMFA() {
        return this.vo.getAstaMFA() == null ? NOT_EXISTING : new CarViewOptionWrapper(this.vo.getAstaMFA());
    }

    @Override
    public CarFunctionState getRefuelVolume() {
        return this.fisAdditionalConfiguration.isRefuelVolume() ? this.menue1Config : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getCoolantTemp() {
        return this.fisAdditionalConfiguration.isCoolantTemp() ? this.menue1Config : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getMFASpeedWarning() {
        return this.fisAdditionalConfiguration.isSpeedWarning() ? this.menue1Config : NOT_EXISTING;
    }

    @Override
    public CarFunctionState getCurrentConsumption() {
        return this.commonMFAFunctions;
    }

    @Override
    public CarFunctionState getAverageConsumption() {
        return this.commonMFAFunctions;
    }

    @Override
    public CarFunctionState getDrivingTime() {
        return this.commonMFAFunctions;
    }

    @Override
    public CarFunctionState getDrivingDistance() {
        return this.commonMFAFunctions;
    }

    @Override
    public CarFunctionState getAverageSpeed() {
        return this.commonMFAFunctions;
    }

    @Override
    public CarFunctionState getResetMenue1() {
        return new CarViewOptionWrapper(this.vo.getResetMenue1());
    }

    @Override
    public CarFunctionState getResetMenue2() {
        return new CarViewOptionWrapper(this.vo.getResetMenue2());
    }

    @Override
    public CarFunctionState getResetTrip() {
        return new CarViewOptionWrapper(this.vo.getResetTrip());
    }

    @Override
    public CarFunctionState getVZADisplay() {
        return new CarViewOptionWrapper(this.vo.getVZADisplay());
    }

    @Override
    public CarFunctionState getShortTermGeneral() {
        return new CarViewOptionWrapper(this.vo.getShortTermGeneral());
    }

    @Override
    public CarFunctionState getShortTermAverageConsumption1() {
        return new CarViewOptionWrapper(this.vo.getShortTermAverageConsumption1());
    }

    @Override
    public CarFunctionState getCurrentRange1() {
        return new CarViewOptionWrapper(this.vo.getCurrentRange1());
    }

    @Override
    public CarFunctionState getCurrentRange2() {
        return new CarViewOptionWrapper(this.vo.getCurrentRange2());
    }

    @Override
    public CarFunctionState getLongTermGeneral() {
        return new CarViewOptionWrapper(this.vo.getLongTermGeneral());
    }

    @Override
    public CarFunctionState getLongTermAverageConsumption1() {
        return new CarViewOptionWrapper(this.vo.getLongTermAverageConsumption1());
    }

    @Override
    public CarFunctionState getLongTermAverageConsumption2() {
        return new CarViewOptionWrapper(this.vo.getLongTermAverageConsumption2());
    }

    @Override
    public CarFunctionState getCycleGeneral() {
        return new CarViewOptionWrapper(this.vo.getCycleGeneral());
    }
}

