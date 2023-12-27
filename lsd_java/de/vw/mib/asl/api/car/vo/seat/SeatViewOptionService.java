/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.seat;

import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionListener;

public interface SeatViewOptionService {
    default public void addListener(SeatViewOptionListener seatViewOptionListener) {
    }

    default public void removeListener(SeatViewOptionListener seatViewOptionListener) {
    }
}

