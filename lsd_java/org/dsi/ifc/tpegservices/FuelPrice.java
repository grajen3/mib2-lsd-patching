/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

public class FuelPrice {
    public int currency;
    public int gasoline;
    public int diesel;

    public FuelPrice() {
        this.currency = 0;
        this.gasoline = 0;
        this.diesel = 0;
    }

    public FuelPrice(int n, int n2, int n3) {
        this.currency = n;
        this.gasoline = n2;
        this.diesel = n3;
    }

    public int getCurrency() {
        return this.currency;
    }

    public int getGasoline() {
        return this.gasoline;
    }

    public int getDiesel() {
        return this.diesel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("FuelPrice");
        stringBuffer.append('(');
        stringBuffer.append("currency");
        stringBuffer.append('=');
        stringBuffer.append(this.currency);
        stringBuffer.append(',');
        stringBuffer.append("gasoline");
        stringBuffer.append('=');
        stringBuffer.append(this.gasoline);
        stringBuffer.append(',');
        stringBuffer.append("diesel");
        stringBuffer.append('=');
        stringBuffer.append(this.diesel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

