/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.seats;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.asl.api.car.seat.SeatValueFactory;

public class NotAvailableSeatService
implements SeatService {
    @Override
    public void changeSeatMassage(SeatMassage seatMassage) {
    }

    @Override
    public SeatMassage getSeatMassageForZone(int n) {
        return null;
    }

    @Override
    public SeatMassage[] getSeatMassageForAllZones() {
        return null;
    }

    public void changeSeatDisplayContent(SeatDisplayRequest seatDisplayRequest) {
    }

    @Override
    public void changeSeatDisplayRequest(SeatDisplayRequest seatDisplayRequest, int n) {
    }

    @Override
    public int getSeatDriverPosition() {
        return 0;
    }

    @Override
    public int getSeatFrontPassengerPosition() {
        return 0;
    }

    @Override
    public SeatSetupSetting getSeatSetupSetting(int n, int n2) {
        return null;
    }

    @Override
    public void changeSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
    }

    @Override
    public void resetRestingAndWorkingPosition() {
    }

    @Override
    public void changeSeatAdjustment(SeatAdjustment seatAdjustment) {
    }

    @Override
    public SeatAdjustment getSeatAdjustment(int n, int n2, int n3) {
        return null;
    }

    @Override
    public void changeSeatExtra(int n, int n2, boolean bl) {
    }

    @Override
    public SeatValueFactory getSeatValueFactory() {
        return null;
    }
}

