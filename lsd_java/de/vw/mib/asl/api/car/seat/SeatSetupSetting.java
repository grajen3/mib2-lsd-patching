/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public interface SeatSetupSetting {
    public static final int SEAT_SETTINGS_TYPE_UNKNOWN;
    public static final int SEAT_SETTINGS_TYPE_EASY_ENTRY_EXIT;
    public static final int SEAT_SETTINGS_TYPE_SEAT_MEMORY;
    public static final int SEAT_SETTINGS_TYPE_SEAT_BELT_PRETENSION;

    default public int getSeatSettingType() {
    }

    default public int getSeatPosition() {
    }

    default public boolean getSeatSettingValue() {
    }

    default public SeatSetupSetting modifySeatSetupSettingValue(boolean bl) {
    }
}

