/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEConsumerListConsumptionRA0 {
    public int pos;
    public int consumer;
    public short consumptionRelative;

    public BCmEConsumerListConsumptionRA0() {
        this.pos = 0;
        this.consumer = 0;
        this.consumptionRelative = 0;
    }

    public BCmEConsumerListConsumptionRA0(int n, int n2, short s) {
        this.pos = n;
        this.consumer = n2;
        this.consumptionRelative = s;
    }

    public int getPos() {
        return this.pos;
    }

    public int getConsumer() {
        return this.consumer;
    }

    public short getConsumptionRelative() {
        return this.consumptionRelative;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCmEConsumerListConsumptionRA0");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("consumer");
        stringBuffer.append('=');
        stringBuffer.append(this.consumer);
        stringBuffer.append(',');
        stringBuffer.append("consumptionRelative");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionRelative);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

