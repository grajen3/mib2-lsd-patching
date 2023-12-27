/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.bordcomputer;

import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleInfoViewOptionsData;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerDevice;

public class BordComputerVehicleStatesViewOptionListenerImpl
extends VehicleStatesViewOptionAdapter {
    private BordComputerDevice viewOptionsDevice;

    public BordComputerVehicleStatesViewOptionListenerImpl(BordComputerDevice bordComputerDevice) {
        this.viewOptionsDevice = bordComputerDevice;
    }

    @Override
    public void updateVehicleInfoViewOption(VehicleInfoViewOptionsData vehicleInfoViewOptionsData, int n) {
        this.viewOptionsDevice.addMappingBordComputer(0, vehicleInfoViewOptionsData.getDrvSchoolSystem(), n);
        this.viewOptionsDevice.addMappingBordComputer(1, vehicleInfoViewOptionsData.getDrvSchoolSystem(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateVehicleInfoDevice(int n) {
        this.viewOptionsDevice.addMappingBordComputer(0, n);
        this.viewOptionsDevice.addMappingBordComputer(1, n);
        this.viewOptionsDevice.updateModel();
    }
}

