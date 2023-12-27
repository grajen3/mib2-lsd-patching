/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class KeyData {
    public int targetValue;
    public int actualValue;
    public int activeKey;

    public KeyData() {
        this.targetValue = 0;
        this.actualValue = 0;
        this.activeKey = 0;
    }

    public KeyData(int n, int n2, int n3) {
        this.targetValue = n;
        this.actualValue = n2;
        this.activeKey = n3;
    }

    public int getTargetValue() {
        return this.targetValue;
    }

    public int getActualValue() {
        return this.actualValue;
    }

    public int getActiveKey() {
        return this.activeKey;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("KeyData");
        stringBuffer.append('(');
        stringBuffer.append("targetValue");
        stringBuffer.append('=');
        stringBuffer.append(this.targetValue);
        stringBuffer.append(',');
        stringBuffer.append("actualValue");
        stringBuffer.append('=');
        stringBuffer.append(this.actualValue);
        stringBuffer.append(',');
        stringBuffer.append("activeKey");
        stringBuffer.append('=');
        stringBuffer.append(this.activeKey);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

