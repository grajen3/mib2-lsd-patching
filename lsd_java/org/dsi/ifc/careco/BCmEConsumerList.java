/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEConsumerList {
    public int listPosition;
    public int consumer;

    public BCmEConsumerList() {
        this.listPosition = 0;
        this.consumer = 0;
    }

    public BCmEConsumerList(int n, int n2) {
        this.listPosition = n;
        this.consumer = n2;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    public int getConsumer() {
        return this.consumer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCmEConsumerList");
        stringBuffer.append('(');
        stringBuffer.append("listPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.listPosition);
        stringBuffer.append(',');
        stringBuffer.append("consumer");
        stringBuffer.append('=');
        stringBuffer.append(this.consumer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

