/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.bordcomputer;

import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.eco.StartStopViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerDevice;

public class BordComputerEcoViewOptionServiceImpl
extends EcoViewOptionAdapter {
    private BordComputerDevice viewOptionsDevice;

    public BordComputerEcoViewOptionServiceImpl(BordComputerDevice bordComputerDevice) {
        this.viewOptionsDevice = bordComputerDevice;
    }

    @Override
    public void updateStartStopViewOptions(StartStopViewOptionsData startStopViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingMain(0, startStopViewOptionsData.getStartStop(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateStartStopDevice(int n) {
        this.viewOptionsDevice.addMappingMain(0, n);
        this.viewOptionsDevice.updateModel();
    }
}

