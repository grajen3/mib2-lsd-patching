/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.seat.impl;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionsData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carseat.SeatViewOptions;

public class SeatViewOptionsWrapper
implements SeatViewOptionsData {
    private SeatViewOptions vo;

    public SeatViewOptionsWrapper(SeatViewOptions seatViewOptions) {
        this.vo = seatViewOptions;
    }

    @Override
    public CarFunctionState getSeatRadioKeyAutomatic() {
        return new CarViewOptionWrapper(this.vo.getSeatRadioKeyAutomatic());
    }

    @Override
    public CarFunctionState getSeatEasyEntryDriverSeat() {
        if (this.vo.seatmemoryConfig.driversideLeft) {
            return new CarViewOptionWrapper(this.vo.getSeatEasyEntryFrontLeft());
        }
        return new CarViewOptionWrapper(this.vo.getSeatEasyEntryFrontRight());
    }

    @Override
    public CarFunctionState getSeatEasyEntryPassengerSeat() {
        if (this.vo.seatmemoryConfig.driversideLeft) {
            return new CarViewOptionWrapper(this.vo.getSeatEasyEntryFrontRight());
        }
        return new CarViewOptionWrapper(this.vo.getSeatEasyEntryFrontLeft());
    }
}

