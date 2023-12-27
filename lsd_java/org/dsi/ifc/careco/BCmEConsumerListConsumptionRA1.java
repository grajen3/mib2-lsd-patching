/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEConsumerListConsumptionRA1 {
    public int pos;
    public int consumer;

    public BCmEConsumerListConsumptionRA1() {
        this.pos = 0;
        this.consumer = 0;
    }

    public BCmEConsumerListConsumptionRA1(int n, int n2) {
        this.pos = n;
        this.consumer = n2;
    }

    public int getPos() {
        return this.pos;
    }

    public int getConsumer() {
        return this.consumer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BCmEConsumerListConsumptionRA1");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("consumer");
        stringBuffer.append('=');
        stringBuffer.append(this.consumer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

