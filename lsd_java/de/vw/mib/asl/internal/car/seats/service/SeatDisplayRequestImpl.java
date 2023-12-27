/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;

public class SeatDisplayRequestImpl
implements SeatDisplayRequest {
    int seatDisplayContentFrontLeft;
    int seatDisplayContentFrontRight;
    int seatDisplayContentRearLeft;
    int seatDisplayContentRearRight;
    int seatMemoryAdviceFrontLeft;
    int seatMemoryAdviceFrontRight;
    int seatMemoryAdviceRearLeft;
    int seatMemoryAdviceRearRight;

    public SeatDisplayRequestImpl(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.seatDisplayContentFrontLeft = n;
        this.seatDisplayContentFrontRight = n2;
        this.seatDisplayContentRearLeft = n3;
        this.seatDisplayContentRearRight = n4;
        this.seatMemoryAdviceFrontLeft = n5;
        this.seatMemoryAdviceFrontRight = n6;
        this.seatMemoryAdviceRearLeft = n7;
        this.seatMemoryAdviceRearRight = n8;
    }

    @Override
    public int getSeatDisplayRequestForSeatPosition(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = this.seatDisplayContentFrontLeft;
                break;
            }
            case 1: {
                n2 = this.seatDisplayContentFrontRight;
                break;
            }
            case 2: {
                n2 = this.seatDisplayContentRearLeft;
                break;
            }
            case 3: {
                n2 = this.seatDisplayContentRearRight;
                break;
            }
        }
        return n2;
    }

    @Override
    public int getSeatMemoryAdviceForSeatPosition(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = this.seatMemoryAdviceFrontLeft;
                break;
            }
            case 1: {
                n2 = this.seatMemoryAdviceFrontRight;
                break;
            }
            case 2: {
                n2 = this.seatMemoryAdviceRearLeft;
                break;
            }
            case 3: {
                n2 = this.seatMemoryAdviceRearRight;
                break;
            }
        }
        return n2;
    }

    @Override
    public SeatDisplayRequest modifiySeatDisplayContentForSeatPosition(int n, int n2) {
        SeatDisplayRequestImpl seatDisplayRequestImpl = null;
        switch (n) {
            case 0: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(n2, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
            case 1: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, n2, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
            case 2: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, n2, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
            case 3: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, n2, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
        }
        return seatDisplayRequestImpl;
    }

    @Override
    public SeatDisplayRequest modifiySeatMemoryAdviceForSeatPosition(int n, int n2) {
        SeatDisplayRequestImpl seatDisplayRequestImpl = null;
        switch (n) {
            case 0: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, n2, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
            case 1: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, n2, this.seatMemoryAdviceRearLeft, this.seatMemoryAdviceRearRight);
                break;
            }
            case 2: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, n2, this.seatMemoryAdviceRearRight);
                break;
            }
            case 3: {
                seatDisplayRequestImpl = new SeatDisplayRequestImpl(this.seatDisplayContentFrontLeft, this.seatDisplayContentFrontRight, this.seatDisplayContentRearLeft, this.seatDisplayContentRearRight, this.seatMemoryAdviceFrontLeft, this.seatMemoryAdviceFrontRight, this.seatMemoryAdviceRearLeft, n2);
                break;
            }
        }
        return seatDisplayRequestImpl;
    }
}

