/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.service;

import de.vw.mib.asl.api.car.seat.SeatAdjustment;

public class SeatAdjustmentImpl
implements SeatAdjustment {
    int seatPosition = -1;
    int seatAdjustmentSetting = 0;
    int seatAdjustmentDirection = 0;
    boolean startStop = false;

    public SeatAdjustmentImpl() {
        this.seatPosition = -1;
        this.seatAdjustmentSetting = 0;
        this.startStop = false;
        this.seatAdjustmentDirection = 0;
    }

    public SeatAdjustmentImpl(int n, int n2, int n3, boolean bl) {
        this.seatPosition = n;
        this.seatAdjustmentSetting = n2;
        this.startStop = bl;
        this.seatAdjustmentDirection = 0;
    }

    @Override
    public int getIntValue(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = this.seatPosition;
                break;
            }
            case 2: {
                n2 = this.seatAdjustmentDirection;
                break;
            }
            case 4: {
                n2 = this.seatAdjustmentSetting;
                break;
            }
        }
        return n2;
    }

    @Override
    public boolean getBooleanvalue(int n) {
        return this.startStop;
    }
}

