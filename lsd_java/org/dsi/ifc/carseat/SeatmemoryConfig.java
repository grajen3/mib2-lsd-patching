/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SeatmemoryConfig {
    public boolean seatmemory1RL;
    public boolean seatmemory1RR;
    public boolean seatmemory2RL;
    public boolean seatmemory2RR;
    public boolean driversideLeft;
    public boolean comfortview;
    public boolean normalPosition;
    public boolean seatsymmetry;
    public boolean relaxPosition;
    public boolean businessPosition;
    public boolean multiFunctionSwitcher;

    public SeatmemoryConfig() {
        this.seatmemory1RL = false;
        this.seatmemory1RR = false;
        this.seatmemory2RL = false;
        this.seatmemory2RR = false;
        this.driversideLeft = false;
        this.comfortview = false;
        this.normalPosition = false;
        this.seatsymmetry = false;
        this.relaxPosition = false;
        this.businessPosition = false;
        this.multiFunctionSwitcher = false;
    }

    public SeatmemoryConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.seatmemory1RL = bl;
        this.seatmemory1RR = bl2;
        this.seatmemory2RL = bl3;
        this.seatmemory2RR = bl4;
        this.driversideLeft = bl5;
        this.comfortview = bl6;
        this.normalPosition = bl7;
        this.seatsymmetry = bl8;
        this.relaxPosition = false;
        this.businessPosition = false;
        this.multiFunctionSwitcher = false;
    }

    public SeatmemoryConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11) {
        this.seatmemory1RL = bl;
        this.seatmemory1RR = bl2;
        this.seatmemory2RL = bl3;
        this.seatmemory2RR = bl4;
        this.driversideLeft = bl5;
        this.comfortview = bl6;
        this.normalPosition = bl7;
        this.seatsymmetry = bl8;
        this.relaxPosition = bl9;
        this.businessPosition = bl10;
        this.multiFunctionSwitcher = bl11;
    }

    public boolean isSeatmemory1RL() {
        return this.seatmemory1RL;
    }

    public boolean isSeatmemory1RR() {
        return this.seatmemory1RR;
    }

    public boolean isSeatmemory2RL() {
        return this.seatmemory2RL;
    }

    public boolean isSeatmemory2RR() {
        return this.seatmemory2RR;
    }

    public boolean isDriversideLeft() {
        return this.driversideLeft;
    }

    public boolean isComfortview() {
        return this.comfortview;
    }

    public boolean isNormalPosition() {
        return this.normalPosition;
    }

    public boolean isSeatsymmetry() {
        return this.seatsymmetry;
    }

    public boolean isRelaxPosition() {
        return this.relaxPosition;
    }

    public boolean isBusinessPosition() {
        return this.businessPosition;
    }

    public boolean isMultiFunctionSwitcher() {
        return this.multiFunctionSwitcher;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("SeatmemoryConfig");
        stringBuffer.append('(');
        stringBuffer.append("seatmemory1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seatmemory1RL);
        stringBuffer.append(',');
        stringBuffer.append("seatmemory1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seatmemory1RR);
        stringBuffer.append(',');
        stringBuffer.append("seatmemory2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seatmemory2RL);
        stringBuffer.append(',');
        stringBuffer.append("seatmemory2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seatmemory2RR);
        stringBuffer.append(',');
        stringBuffer.append("driversideLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.driversideLeft);
        stringBuffer.append(',');
        stringBuffer.append("comfortview");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortview);
        stringBuffer.append(',');
        stringBuffer.append("normalPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.normalPosition);
        stringBuffer.append(',');
        stringBuffer.append("seatsymmetry");
        stringBuffer.append('=');
        stringBuffer.append(this.seatsymmetry);
        stringBuffer.append(',');
        stringBuffer.append("relaxPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.relaxPosition);
        stringBuffer.append(',');
        stringBuffer.append("businessPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.businessPosition);
        stringBuffer.append(',');
        stringBuffer.append("multiFunctionSwitcher");
        stringBuffer.append('=');
        stringBuffer.append(this.multiFunctionSwitcher);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

