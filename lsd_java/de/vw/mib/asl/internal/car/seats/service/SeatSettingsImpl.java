/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatSetupSetting;

public class SeatSettingsImpl
implements SeatSetupSetting {
    int seatSettingsType = 0;
    int seatPosition = 0;
    boolean seatSettingValue = false;

    public SeatSettingsImpl(int n, int n2, boolean bl) {
        this.seatSettingsType = n;
        this.seatPosition = n2;
        this.seatSettingValue = bl;
    }

    @Override
    public int getSeatSettingType() {
        return this.seatSettingsType;
    }

    @Override
    public int getSeatPosition() {
        return this.seatPosition;
    }

    @Override
    public boolean getSeatSettingValue() {
        return this.seatSettingValue;
    }

    @Override
    public SeatSetupSetting modifySeatSetupSettingValue(boolean bl) {
        return new SeatSettingsImpl(this.seatSettingsType, this.seatPosition, bl);
    }
}

