/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.bordcomputer;

import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerDevice;

public class BordComputerKombiViewOptionListnerImpl
extends KombiViewOptionAdapter {
    private final BordComputerDevice viewOptionsDevice;

    public BordComputerKombiViewOptionListnerImpl(BordComputerDevice bordComputerDevice) {
        this.viewOptionsDevice = bordComputerDevice;
    }

    @Override
    public void updateBCViewOptions(BCViewOptionsData bCViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingBordComputer(2, bCViewOptionsData.getShortTermGeneral(), n);
        this.viewOptionsDevice.addMappingBordComputer(3, bCViewOptionsData.getShortTermAverageConsumption1(), n);
        this.viewOptionsDevice.addMappingBordComputer(4, bCViewOptionsData.getCurrentRange1(), n);
        this.viewOptionsDevice.addMappingBordComputer(5, bCViewOptionsData.getCurrentRange1(), n);
        this.viewOptionsDevice.addMappingBordComputer(6, bCViewOptionsData.getCurrentRange2(), n);
        this.viewOptionsDevice.addMappingBordComputer(7, bCViewOptionsData.getLongTermGeneral(), n);
        this.viewOptionsDevice.addMappingBordComputer(8, bCViewOptionsData.getLongTermAverageConsumption1(), n);
        this.viewOptionsDevice.addMappingBordComputer(9, bCViewOptionsData.getLongTermAverageConsumption2(), n);
        this.viewOptionsDevice.addMappingBordComputer(10, bCViewOptionsData.getCycleGeneral(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateBCDevice(int n) {
        this.viewOptionsDevice.addMappingBordComputer(2, n);
        this.viewOptionsDevice.addMappingBordComputer(3, n);
        this.viewOptionsDevice.addMappingBordComputer(4, n);
        this.viewOptionsDevice.addMappingBordComputer(5, n);
        this.viewOptionsDevice.addMappingBordComputer(6, n);
        this.viewOptionsDevice.addMappingBordComputer(7, n);
        this.viewOptionsDevice.addMappingBordComputer(8, n);
        this.viewOptionsDevice.addMappingBordComputer(9, n);
        this.viewOptionsDevice.addMappingBordComputer(10, n);
        this.viewOptionsDevice.updateModel();
    }
}

