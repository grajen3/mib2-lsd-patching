/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.kombi.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.DCViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carkombi.DCViewOptions;

public class DCViewOptionsWrapper
implements DCViewOptionsData {
    private DCViewOptions vo;

    public DCViewOptionsWrapper(DCViewOptions dCViewOptions) {
        this.vo = dCViewOptions;
    }

    @Override
    public CarFunctionState getBrightness() {
        return new CarViewOptionWrapper(this.vo.getBrightness());
    }

    @Override
    public CarFunctionState getVolume() {
        return new CarViewOptionWrapper(this.vo.getVolume());
    }

    @Override
    public CarFunctionState getElementContentSelectionList() {
        return new CarViewOptionWrapper(this.vo.getElementContentSelectionList());
    }

    @Override
    public CarFunctionState getDisplay1Setup() {
        return new CarViewOptionWrapper(this.vo.getDisplay1Setup());
    }

    @Override
    public CarFunctionState getDisplay1MainSelection() {
        return new CarViewOptionWrapper(this.vo.getDisplay1MainSelection());
    }

    @Override
    public CarFunctionState getDisplay2Setup() {
        return new CarViewOptionWrapper(this.vo.getDisplay2Setup());
    }

    @Override
    public CarFunctionState getDisplay2MainSelection() {
        return new CarViewOptionWrapper(this.vo.getDisplay2MainSelection());
    }

    @Override
    public CarFunctionState getDisplay3Setup() {
        return new CarViewOptionWrapper(this.vo.getDisplay3Setup());
    }

    @Override
    public CarFunctionState getDisplay3MainSelection() {
        return new CarViewOptionWrapper(this.vo.getDisplay3MainSelection());
    }

    @Override
    public CarFunctionState setFactoryDefault() {
        return new CarViewOptionWrapper(this.vo.setFactoryDefault);
    }

    @Override
    public CarFunctionState getAdditionalInstrumentSetup() {
        return new CarViewOptionWrapper(this.vo.getAdditionalInstrumentSetup());
    }

    @Override
    public CarFunctionState getAdditionalInstrument2Setup() {
        return new CarViewOptionWrapper(this.vo.getAdditionalInstrument2Setup());
    }

    @Override
    public CarFunctionState getDisplayPresetsList() {
        return new CarViewOptionWrapper(this.vo.getDisplayPresetsList());
    }

    @Override
    public CarFunctionState getActiveDisplayPreset() {
        return new CarViewOptionWrapper(this.vo.getActiveDisplayPreset());
    }

    @Override
    public CarFunctionState getDisplayViewConfiguration() {
        return new CarViewOptionWrapper(this.vo.getDisplayViewConfiguration());
    }

    @Override
    public CarFunctionState getDisplayDependency() {
        return new CarViewOptionWrapper(this.vo.getDisplayDependency());
    }

    @Override
    public CarFunctionState getLedConfiguration() {
        return new CarViewOptionWrapper(this.vo.getLedConfiguration());
    }
}

