/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

public class TLOInfoElement {
    public int counter;
    public int time1CF;
    public float time1Pred;
    public int time1State;
    public int time2CF;
    public float time2Pred;
    public int time2State;
    public int psdSegId;
    public int psdSegOffset;

    public TLOInfoElement() {
        this.counter = 0;
        this.time1CF = 0;
        this.time1Pred = 0.0f;
        this.time1State = 0;
        this.time2CF = 0;
        this.time2Pred = 0.0f;
        this.time2State = 0;
        this.psdSegId = 0;
        this.psdSegOffset = 0;
    }

    public TLOInfoElement(int n, int n2, float f2, int n3, int n4, float f3, int n5, int n6, int n7) {
        this.counter = n;
        this.time1CF = n2;
        this.time1Pred = f2;
        this.time1State = n3;
        this.time1CF = n2;
        this.time1Pred = f2;
        this.time1State = n3;
        this.psdSegId = n6;
        this.psdSegOffset = n7;
    }

    public int getCounter() {
        return this.counter;
    }

    public int getTime1CF() {
        return this.time1CF;
    }

    public float getTime1Pred() {
        return this.time1Pred;
    }

    public int getTime1State() {
        return this.time1State;
    }

    public int getTime2CF() {
        return this.time2CF;
    }

    public float getTime2Pred() {
        return this.time2Pred;
    }

    public int getTime2State() {
        return this.time2State;
    }

    public int getPsdSegId() {
        return this.psdSegId;
    }

    public int getPsdSegOffset() {
        return this.psdSegOffset;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("TLOInfoElement");
        stringBuffer.append('(');
        stringBuffer.append("counter");
        stringBuffer.append('=');
        stringBuffer.append(this.counter);
        stringBuffer.append(',');
        stringBuffer.append("time1CF");
        stringBuffer.append('=');
        stringBuffer.append(this.time1CF);
        stringBuffer.append(',');
        stringBuffer.append("time1Pred");
        stringBuffer.append('=');
        stringBuffer.append(this.time1Pred);
        stringBuffer.append(',');
        stringBuffer.append("time1State");
        stringBuffer.append('=');
        stringBuffer.append(this.time1State);
        stringBuffer.append(',');
        stringBuffer.append("time2CF");
        stringBuffer.append('=');
        stringBuffer.append(this.time2CF);
        stringBuffer.append(',');
        stringBuffer.append("time2Pred");
        stringBuffer.append('=');
        stringBuffer.append(this.time2Pred);
        stringBuffer.append(',');
        stringBuffer.append("time2State");
        stringBuffer.append('=');
        stringBuffer.append(this.time2State);
        stringBuffer.append(',');
        stringBuffer.append("psdSegId");
        stringBuffer.append('=');
        stringBuffer.append(this.psdSegId);
        stringBuffer.append(',');
        stringBuffer.append("psdSegOffset");
        stringBuffer.append('=');
        stringBuffer.append(this.psdSegOffset);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

