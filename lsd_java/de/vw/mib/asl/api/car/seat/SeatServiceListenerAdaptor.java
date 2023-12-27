/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatServiceListener;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;

public class SeatServiceListenerAdaptor
implements SeatServiceListener {
    @Override
    public void updateSeatMassage(SeatMassage seatMassage) {
    }

    @Override
    public void updateSeatServiceExisting(boolean bl) {
    }

    @Override
    public void updateSeatServiceAvailable(boolean bl) {
    }

    @Override
    public void updateSeatDisplayContent(SeatDisplayRequest seatDisplayRequest) {
    }

    @Override
    public void requestSeatPopup(SeatDisplayRequest seatDisplayRequest) {
    }

    @Override
    public void updateSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
    }

    @Override
    public void updateSeatAdjustment(SeatAdjustment seatAdjustment) {
    }
}

