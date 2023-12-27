/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public interface SeatDisplayRequest {
    public static final int SEAT_DISPLAY_REQUEST_NONE;
    public static final int SEAT_DISPLAY_REQUEST_GURTHOEHE;
    public static final int SEAT_DISPLAY_REQUEST_LEHNENKOPF;
    public static final int SEAT_DISPLAY_REQUEST_LORDOSE;
    public static final int SEAT_DISPLAY_REQUEST_SEITENWANGEN;
    public static final int SEAT_DISPLAY_REQUEST_SITZTIEFE;
    public static final int SEAT_DISPLAY_REQUEST_MASSAGE;
    public static final int SEAT_DISPLAY_REQUEST_MEMORY;
    public static final int SEAT_DISPLAY_REQUEST_LEHNENWANGEN;
    public static final int SEAT_DISPLAY_REQUEST_SITZWANGEN;
    public static final int SEAT_DISPLAY_REQUEST_MENU;
    public static final int MEMORYDETAIL_MEMORY_NONE;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED;
    public static final int MEMORYDETAIL_SET_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_SET_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_SET;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_RADIOKEY_PRESS_PROGRAM;
    public static final int SEAT_POP_REQUEST_CHANGE_REASON_CANCEL_POPUP_HMI;
    public static final int SEAT_POP_REQUEST_CHANGE_REASON_CANCEL_POPUP_DEVICE;
    public static final int SEAT_POP_REQUEST_CHANGE_REASON_ACK_SEAT_POPUP;

    default public int getSeatDisplayRequestForSeatPosition(int n) {
    }

    default public int getSeatMemoryAdviceForSeatPosition(int n) {
    }

    default public SeatDisplayRequest modifiySeatDisplayContentForSeatPosition(int n, int n2) {
    }

    default public SeatDisplayRequest modifiySeatMemoryAdviceForSeatPosition(int n, int n2) {
    }
}

