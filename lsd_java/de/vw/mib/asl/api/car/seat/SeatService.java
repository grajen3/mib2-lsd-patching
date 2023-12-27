/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.asl.api.car.seat.SeatValueFactory;

public interface SeatService {
    default public SeatValueFactory getSeatValueFactory() {
    }

    default public void changeSeatMassage(SeatMassage seatMassage) {
    }

    default public void changeSeatDisplayRequest(SeatDisplayRequest seatDisplayRequest, int n) {
    }

    default public SeatMassage getSeatMassageForZone(int n) {
    }

    default public SeatMassage[] getSeatMassageForAllZones() {
    }

    default public int getSeatDriverPosition() {
    }

    default public int getSeatFrontPassengerPosition() {
    }

    default public SeatSetupSetting getSeatSetupSetting(int n, int n2) {
    }

    default public void changeSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
    }

    default public void resetRestingAndWorkingPosition() {
    }

    default public SeatAdjustment getSeatAdjustment(int n, int n2, int n3) {
    }

    default public void changeSeatAdjustment(SeatAdjustment seatAdjustment) {
    }

    default public void changeSeatExtra(int n, int n2, boolean bl) {
    }
}

