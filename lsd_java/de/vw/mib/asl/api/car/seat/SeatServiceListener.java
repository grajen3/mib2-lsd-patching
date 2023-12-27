/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;

public interface SeatServiceListener {
    default public void updateSeatServiceExisting(boolean bl) {
    }

    default public void updateSeatServiceAvailable(boolean bl) {
    }

    default public void updateSeatMassage(SeatMassage seatMassage) {
    }

    default public void updateSeatDisplayContent(SeatDisplayRequest seatDisplayRequest) {
    }

    default public void requestSeatPopup(SeatDisplayRequest seatDisplayRequest) {
    }

    default public void updateSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
    }

    default public void updateSeatAdjustment(SeatAdjustment seatAdjustment) {
    }
}

