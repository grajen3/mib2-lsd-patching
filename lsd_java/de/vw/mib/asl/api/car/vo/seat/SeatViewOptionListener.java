/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.seat;

import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionsData;

public interface SeatViewOptionListener {
    default public void updateSeatViewOptions(SeatViewOptionsData seatViewOptionsData, int n) {
    }

    default public void updateSeatDevice(int n) {
    }
}

