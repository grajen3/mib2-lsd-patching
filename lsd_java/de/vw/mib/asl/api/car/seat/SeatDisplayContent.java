/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.seat;

public interface SeatDisplayContent {
    public static final int SEATCONTENT_NONE;
    public static final int SEATCONTENT_GURTHOEHE;
    public static final int SEATCONTENT_LEHNENKOPF;
    public static final int SEATCONTENT_LORDOSE;
    public static final int SEATCONTENT_SEITENWANGEN;
    public static final int SEATCONTENT_SITZTIEFE;
    public static final int SEATCONTENT_MASSAGE;
    public static final int SEATCONTENT_MEMORY;
    public static final int SEATCONTENT_LEHNENWANGEN;
    public static final int SEATCONTENT_SITZWANGEN;
    public static final int SEATCONTENT_MENU;
    public static final int MEMORYDETAIL_MEMORY_NONE;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED;
    public static final int MEMORYDETAIL_SET_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_SET_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_SET;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_RADIOKEY_PRESS_PROGRAM;

    default public int getSeatDisplayContentFrontLeft() {
    }

    default public int getSeatDisplayContentFrontRight() {
    }

    default public int getSeatDisplayContentRearLeft() {
    }

    default public int getSeatDisplayContentRearRight() {
    }

    default public int getSeatMemoryAdviceFrontLeft() {
    }

    default public int getSeatMemoryAdviceFrontRight() {
    }

    default public int getSeatMemoryAdviceRearLeft() {
    }

    default public int getSeatMemoryAdviceRearRight() {
    }

    default public SeatDisplayContent modifiySeatDisplayContentFrontLeft(int n) {
    }

    default public SeatDisplayContent modifiySeatDisplayContentFrontRight(int n) {
    }

    default public SeatDisplayContent modifiySeatDisplayContentRearLeft(int n) {
    }

    default public SeatDisplayContent modifiySeatDisplayContentRearRight(int n) {
    }

    default public SeatDisplayContent modifiySeatMemoryAdviceFrontLeft(int n) {
    }

    default public SeatDisplayContent modifiySeatMemoryAdviceFrontRight(int n) {
    }

    default public SeatDisplayContent modifiySeatMemoryAdviceRearLeft(int n) {
    }

    default public SeatDisplayContent modifiySeatMemoryAdviceRearRight(int n) {
    }
}

