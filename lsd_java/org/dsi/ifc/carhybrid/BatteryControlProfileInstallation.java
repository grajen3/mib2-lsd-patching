/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlProfileInstallation {
    public boolean leadingTime;
    public boolean acTempSetting;

    public BatteryControlProfileInstallation() {
        this.leadingTime = false;
        this.acTempSetting = false;
    }

    public BatteryControlProfileInstallation(boolean bl, boolean bl2) {
        this.leadingTime = bl;
        this.acTempSetting = bl2;
    }

    public boolean isLeadingTime() {
        return this.leadingTime;
    }

    public boolean isAcTempSetting() {
        return this.acTempSetting;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BatteryControlProfileInstallation");
        stringBuffer.append('(');
        stringBuffer.append("leadingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.leadingTime);
        stringBuffer.append(',');
        stringBuffer.append("acTempSetting");
        stringBuffer.append('=');
        stringBuffer.append(this.acTempSetting);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

