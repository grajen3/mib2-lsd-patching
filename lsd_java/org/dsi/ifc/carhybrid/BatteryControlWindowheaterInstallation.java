/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlWindowheaterInstallation {
    public boolean front;
    public boolean rear;

    public BatteryControlWindowheaterInstallation() {
        this.front = false;
        this.rear = false;
    }

    public BatteryControlWindowheaterInstallation(boolean bl, boolean bl2) {
        this.front = bl;
        this.rear = bl2;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isRear() {
        return this.rear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BatteryControlWindowheaterInstallation");
        stringBuffer.append('(');
        stringBuffer.append("front");
        stringBuffer.append('=');
        stringBuffer.append(this.front);
        stringBuffer.append(',');
        stringBuffer.append("rear");
        stringBuffer.append('=');
        stringBuffer.append(this.rear);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

