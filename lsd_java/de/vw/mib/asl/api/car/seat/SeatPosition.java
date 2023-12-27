/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public class SeatPosition {
    public static final int SEAT_POSITION_UNKNOWN;
    public static final int SEAT_POSITION_FRONT_LEFT;
    public static final int SEAT_POSITION_FRONT_RIGHT;
    public static final int SEAT_POSITION_REAR_LEFT;
    public static final int SEAT_POSITION_REAR_RIGHT;
    public static final int SEAT_POSITION_DRIVER_SIDE;
    public static final int SEAT_POSITION_PASSENGER_SIDE;

    public static String toString(int n) {
        String string = "";
        switch (n) {
            case 0: {
                string = "front left";
                break;
            }
            case 1: {
                string = "front right";
                break;
            }
            case 2: {
                string = "rear left";
                break;
            }
            case 3: {
                string = "rear right";
                break;
            }
            case 4: {
                string = "driver side";
                break;
            }
            case 5: {
                string = "passenger side";
                break;
            }
            default: {
                string = "unknown";
            }
        }
        return string;
    }
}

