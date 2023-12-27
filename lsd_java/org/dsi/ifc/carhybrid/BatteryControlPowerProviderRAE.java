/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlPowerProviderRAE {
    public int pos;
    public String provider;

    public BatteryControlPowerProviderRAE() {
        this.pos = 0;
        this.provider = "";
    }

    public BatteryControlPowerProviderRAE(int n, String string) {
        this.pos = n;
        this.provider = string;
    }

    public int getPos() {
        return this.pos;
    }

    public String getProvider() {
        return this.provider;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BatteryControlPowerProviderRAE");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("provider");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.provider);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

