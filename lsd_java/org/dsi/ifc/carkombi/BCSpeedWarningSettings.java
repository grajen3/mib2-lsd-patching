/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCSpeedWarningSettings {
    public boolean state;
    public int speedValue;
    public int speedUnit;

    public BCSpeedWarningSettings() {
        this.state = false;
        this.speedValue = 0;
        this.speedUnit = 0;
    }

    public BCSpeedWarningSettings(boolean bl, int n, int n2) {
        this.state = bl;
        this.speedValue = n;
        this.speedUnit = n2;
    }

    public boolean isState() {
        return this.state;
    }

    public int getSpeedValue() {
        return this.speedValue;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCSpeedWarningSettings");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("speedValue");
        stringBuffer.append('=');
        stringBuffer.append(this.speedValue);
        stringBuffer.append(',');
        stringBuffer.append("speedUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

