/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;

public interface SeatValueFactory {
    default public SeatMassage createSeatMassage(int n, int n2, int n3, int n4) {
    }

    default public SeatDisplayRequest creatSeatDisplayRequest(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public SeatSetupSetting creatSeatSettings(int n, int n2, boolean bl) {
    }

    default public SeatAdjustment creatSeatAdjustment(int n, int n2, int n3, boolean bl) {
    }
}

