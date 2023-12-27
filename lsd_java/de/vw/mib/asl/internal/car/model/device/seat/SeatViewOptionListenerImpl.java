/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.seat;

import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionListener;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.seat.SeatDevice;

public class SeatViewOptionListenerImpl
implements SeatViewOptionListener {
    private SeatDevice seatDevice;

    public SeatViewOptionListenerImpl(SeatDevice seatDevice) {
        this.seatDevice = seatDevice;
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptionsData seatViewOptionsData, int n) {
        this.seatDevice.addMapping(0, seatViewOptionsData.getSeatRadioKeyAutomatic(), n);
        this.seatDevice.addMapping(3, seatViewOptionsData.getSeatEasyEntryDriverSeat(), n);
        this.seatDevice.addMapping(4, seatViewOptionsData.getSeatEasyEntryPassengerSeat(), n);
        this.seatDevice.updateModel();
    }

    @Override
    public void updateSeatDevice(int n) {
        this.seatDevice.addMapping(0, n);
        this.seatDevice.addMapping(3, n);
        this.seatDevice.addMapping(4, n);
        this.seatDevice.updateModel();
    }
}

