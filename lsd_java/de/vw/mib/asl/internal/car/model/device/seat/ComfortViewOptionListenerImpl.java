/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.seat;

import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.RGSViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.seat.SeatDevice;

public class ComfortViewOptionListenerImpl
extends ComfortViewOptionAdapter {
    private SeatDevice seatDevice;

    public ComfortViewOptionListenerImpl(SeatDevice seatDevice) {
        this.seatDevice = seatDevice;
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptionsData rGSViewOptionsData, int n) {
        this.seatDevice.addMapping(1, rGSViewOptionsData.getBeltPretensionerFrontDataLeft(), n);
        this.seatDevice.addMapping(2, rGSViewOptionsData.getBeltPretensionerFrontDataRight(), n);
        this.seatDevice.updateModel();
    }

    @Override
    public void updateRGSDevice(int n) {
        this.seatDevice.addMapping(1, n);
        this.seatDevice.addMapping(2, n);
        this.seatDevice.updateModel();
    }
}

