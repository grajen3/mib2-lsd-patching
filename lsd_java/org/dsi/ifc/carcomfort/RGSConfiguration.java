/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RGSConfiguration {
    public int driverSide;

    public RGSConfiguration() {
        this.driverSide = 0;
    }

    public RGSConfiguration(int n) {
        this.driverSide = n;
    }

    public int getDriverSide() {
        return this.driverSide;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("RGSConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("driverSide");
        stringBuffer.append('=');
        stringBuffer.append(this.driverSide);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

