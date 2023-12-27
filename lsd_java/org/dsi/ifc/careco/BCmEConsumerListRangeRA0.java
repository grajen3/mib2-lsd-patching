/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEConsumerListRangeRA0 {
    public int pos;
    public int consumer;
    public int rangeGainPrimary;
    public int rangeGainSecondary;
    public int rangeUnit;

    public BCmEConsumerListRangeRA0() {
        this.pos = 0;
        this.consumer = 0;
        this.rangeGainPrimary = 0;
        this.rangeGainSecondary = 0;
        this.rangeUnit = 0;
    }

    public BCmEConsumerListRangeRA0(int n, int n2, int n3, int n4, int n5) {
        this.pos = n;
        this.consumer = n2;
        this.rangeGainPrimary = n3;
        this.rangeGainSecondary = n4;
        this.rangeUnit = n5;
    }

    public int getPos() {
        return this.pos;
    }

    public int getConsumer() {
        return this.consumer;
    }

    public int getRangeGainPrimary() {
        return this.rangeGainPrimary;
    }

    public int getRangeGainSecondary() {
        return this.rangeGainSecondary;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BCmEConsumerListRangeRA0");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("consumer");
        stringBuffer.append('=');
        stringBuffer.append(this.consumer);
        stringBuffer.append(',');
        stringBuffer.append("rangeGainPrimary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainPrimary);
        stringBuffer.append(',');
        stringBuffer.append("rangeGainSecondary");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainSecondary);
        stringBuffer.append(',');
        stringBuffer.append("rangeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

