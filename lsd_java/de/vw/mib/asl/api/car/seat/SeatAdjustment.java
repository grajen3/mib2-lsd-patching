/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public interface SeatAdjustment {
    public static final int ENUM_SEAT_SETTING_UNKNOWN;
    public static final int ENUM_SEAT_SETTING_CUSHION_DEPTH;
    public static final int ENUM_SEAT_SETTING_LATERAL_CUSHION;
    public static final int ENUM_SEAT_SETTING_LATERAL_BACK;
    public static final int ENUM_SEAT_SETTING_UPPER_BACK;
    public static final int ENUM_VALUE_OF_UNKNOWN;
    public static final int ENUM_VALUE_OF_SEAT_POS;
    public static final int ENUM_VALUE_OF_SEAT_DIRECTION;
    public static final int ENUM_VALUE_OF_SEAT_MOVEMENT_STARTSTOP;
    public static final int ENUM_VALUE_OF_SEAT_ADJUSTMENT;
    public static final int ENUM_SEAT_DIRECTION_UNKNOWN;
    public static final int ENUM_SEAT_DIRECTION_FORWARD;
    public static final int ENUM_SEAT_DIRECTION_BACKWARD;
    public static final int ENUM_SEAT_DIRECTION_UP;
    public static final int ENUM_SEAT_DIRECTION_DOWN;
    public static final boolean ENUM_SEAT_MOVEMENT_START;
    public static final boolean ENUM_SEAT_MOVEMENT_STOP;

    default public int getIntValue(int n) {
    }

    default public boolean getBooleanvalue(int n) {
    }
}

