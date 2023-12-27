/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SeatPneumaticContent {
    public int content1RL;
    public int content1RR;

    public SeatPneumaticContent() {
        this.content1RL = 0;
        this.content1RR = 0;
    }

    public SeatPneumaticContent(int n, int n2) {
        this.content1RL = n;
        this.content1RR = n2;
    }

    public int getContent1RL() {
        return this.content1RL;
    }

    public int getContent1RR() {
        return this.content1RR;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SeatPneumaticContent");
        stringBuffer.append('(');
        stringBuffer.append("content1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.content1RL);
        stringBuffer.append(',');
        stringBuffer.append("content1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.content1RR);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

