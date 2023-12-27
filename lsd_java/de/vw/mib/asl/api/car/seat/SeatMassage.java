/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public interface SeatMassage {
    public static final int SEAT_MASSAGE_PROGRAM_OFF;
    public static final int SEAT_MASSAGE_PROGRAM_1;
    public static final int SEAT_MASSAGE_PROGRAM_2;
    public static final int SEAT_MASSAGE_PROGRAM_3;
    public static final int SEAT_MASSAGE_PROGRAM_4;
    public static final int SEAT_MASSAGE_PROGRAM_5;
    public static final int SEAT_MASSAGE_PROGRAM_6;
    public static final int SEAT_MASSAGE_PROGRAM_7;
    public static final int SEAT_MASSAGE_PROGRAM_8;
    public static final int SEAT_MASSAGE_INTENSITY_MIN;
    public static final int SEAT_MASSAGE_INTENSITY_MAX;
    public static final int SEAT_MASSAGE_INTENSITY_STEP;
    public static final int SEAT_MASSAGE_SPEED_MIN;
    public static final int SEAT_MASSAGE_SPEED_MAX;
    public static final int SEAT_MASSAGE_SPEED_STEP;

    default public int getSeatMassageZone() {
    }

    default public int getSeatMassageProgram() {
    }

    default public int getSeatMassageIntensity() {
    }

    default public int getSeatMassageSpeed() {
    }

    default public SeatMassage increaseMassageIntensity() {
    }

    default public SeatMassage decreaseMassageIntensity() {
    }

    default public SeatMassage increaseMassageSpeed() {
    }

    default public SeatMassage decreaseMassageSpeed() {
    }

    default public SeatMassage modifySeatMassageProgram(int n) {
    }

    default public SeatMassage modifySeatMassageIntensity(int n) {
    }

    default public SeatMassage modifySeatMassageSpeed(int n) {
    }
}

