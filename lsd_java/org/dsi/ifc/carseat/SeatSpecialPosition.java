/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SeatSpecialPosition {
    public int position;
    public boolean seat1RL;
    public boolean seat1RR;
    public boolean seat2RL;
    public boolean seat2RR;
    public boolean seat3RL;
    public boolean seat3RR;

    public SeatSpecialPosition() {
        this.position = 0;
        this.seat1RL = false;
        this.seat1RR = false;
        this.seat2RL = false;
        this.seat2RR = false;
        this.seat3RL = false;
        this.seat3RR = false;
    }

    public SeatSpecialPosition(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.position = n;
        this.seat1RL = bl;
        this.seat1RR = bl2;
        this.seat2RL = bl3;
        this.seat2RR = bl4;
        this.seat3RL = bl5;
        this.seat3RR = bl6;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isSeat1RL() {
        return this.seat1RL;
    }

    public boolean isSeat1RR() {
        return this.seat1RR;
    }

    public boolean isSeat2RL() {
        return this.seat2RL;
    }

    public boolean isSeat2RR() {
        return this.seat2RR;
    }

    public boolean isSeat3RL() {
        return this.seat3RL;
    }

    public boolean isSeat3RR() {
        return this.seat3RR;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SeatSpecialPosition");
        stringBuffer.append('(');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("seat1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seat1RL);
        stringBuffer.append(',');
        stringBuffer.append("seat1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seat1RR);
        stringBuffer.append(',');
        stringBuffer.append("seat2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seat2RL);
        stringBuffer.append(',');
        stringBuffer.append("seat2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seat2RR);
        stringBuffer.append(',');
        stringBuffer.append("seat3RL");
        stringBuffer.append('=');
        stringBuffer.append(this.seat3RL);
        stringBuffer.append(',');
        stringBuffer.append("seat3RR");
        stringBuffer.append('=');
        stringBuffer.append(this.seat3RR);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

