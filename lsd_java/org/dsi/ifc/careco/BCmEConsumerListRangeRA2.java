/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEConsumerListRangeRA2 {
    public int pos;
    public int consumer;
    public int rangeGainSecondary;
    public int rangeUnit;

    public BCmEConsumerListRangeRA2() {
        this.pos = 0;
        this.consumer = 0;
        this.rangeGainSecondary = 0;
        this.rangeUnit = 0;
    }

    public BCmEConsumerListRangeRA2(int n, int n2, int n3, int n4) {
        this.pos = n;
        this.consumer = n2;
        this.rangeGainSecondary = n3;
        this.rangeUnit = n4;
    }

    public int getPos() {
        return this.pos;
    }

    public int getConsumer() {
        return this.consumer;
    }

    public int getRangeGainSecondary() {
        return this.rangeGainSecondary;
    }

    public int getRangeUnit() {
        return this.rangeUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("BCmEConsumerListRangeRA2");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("consumer");
        stringBuffer.append('=');
        stringBuffer.append(this.consumer);
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

