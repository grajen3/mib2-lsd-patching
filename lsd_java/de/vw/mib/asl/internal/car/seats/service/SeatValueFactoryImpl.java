/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.asl.api.car.seat.SeatValueFactory;
import de.vw.mib.asl.internal.car.seats.service.SeatAdjustmentImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatDisplayRequestImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatMassageImpl;
import de.vw.mib.asl.internal.car.seats.service.SeatSettingsImpl;

public class SeatValueFactoryImpl
implements SeatValueFactory {
    @Override
    public SeatMassage createSeatMassage(int n, int n2, int n3, int n4) {
        SeatMassageImpl seatMassageImpl = new SeatMassageImpl(n, n2, n3, n4);
        return seatMassageImpl;
    }

    @Override
    public SeatDisplayRequest creatSeatDisplayRequest(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        SeatDisplayRequestImpl seatDisplayRequestImpl = new SeatDisplayRequestImpl(n, n2, n3, n4, n5, n6, n7, n8);
        return seatDisplayRequestImpl;
    }

    @Override
    public SeatSetupSetting creatSeatSettings(int n, int n2, boolean bl) {
        SeatSettingsImpl seatSettingsImpl = new SeatSettingsImpl(n, n2, bl);
        return seatSettingsImpl;
    }

    @Override
    public SeatAdjustment creatSeatAdjustment(int n, int n2, int n3, boolean bl) {
        SeatAdjustmentImpl seatAdjustmentImpl = new SeatAdjustmentImpl(n, n2, n3, bl);
        return seatAdjustmentImpl;
    }
}

