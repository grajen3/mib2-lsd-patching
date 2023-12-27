/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class PriceInfo {
    public int currency;
    public int amount;

    public PriceInfo() {
        this.currency = 0;
        this.amount = 0;
    }

    public PriceInfo(int n, int n2) {
        this.currency = n;
        this.amount = n2;
    }

    public int getCurrency() {
        return this.currency;
    }

    public int getAmount() {
        return this.amount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PriceInfo");
        stringBuffer.append('(');
        stringBuffer.append("currency");
        stringBuffer.append('=');
        stringBuffer.append(this.currency);
        stringBuffer.append(',');
        stringBuffer.append("amount");
        stringBuffer.append('=');
        stringBuffer.append(this.amount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

