/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.parking;

import de.vw.mib.asl.api.car.vo.comfort.BrakeViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.parking.ParkingDevice;

class ParkingDevice$1
extends ComfortViewOptionAdapter {
    private final /* synthetic */ ParkingDevice this$0;

    ParkingDevice$1(ParkingDevice parkingDevice) {
        this.this$0 = parkingDevice;
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptionsData brakeViewOptionsData, int n) {
        this.this$0.mappingList.add(0, brakeViewOptionsData.getBrakeAutoHold(), n);
        this.this$0.mappingList.add(10, brakeViewOptionsData.getBrakeElectricalParking(), n);
        this.this$0.updateModel();
    }

    @Override
    public void updateBrakeDevice(int n) {
        this.this$0.mappingList.add(0, n);
        this.this$0.mappingList.add(10, n);
    }
}

