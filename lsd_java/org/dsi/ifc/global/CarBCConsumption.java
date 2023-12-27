/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarBCConsumption {
    public int state;
    public float consumptionValue;
    public int consumptionUnit;

    public CarBCConsumption() {
        this.state = 0;
        this.consumptionValue = 0.0f;
        this.consumptionUnit = 0;
    }

    public CarBCConsumption(int n, float f2, int n2) {
        this.state = n;
        this.consumptionValue = f2;
        this.consumptionUnit = n2;
    }

    public int getState() {
        return this.state;
    }

    public float getConsumptionValue() {
        return this.consumptionValue;
    }

    public int getConsumptionUnit() {
        return this.consumptionUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CarBCConsumption");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("consumptionValue");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionValue);
        stringBuffer.append(',');
        stringBuffer.append("consumptionUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

