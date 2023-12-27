/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatServiceListener;

public interface ASLSeatAPI {
    default public void addSeatServiceListener(SeatServiceListener seatServiceListener) {
    }

    default public void removeSeatServiceListener(SeatServiceListener seatServiceListener) {
    }

    default public SeatService getSeatService() {
    }
}

