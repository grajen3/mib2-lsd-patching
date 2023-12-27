/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlPowerProviderRA2 {
    public int pos;
    public int nrStartHour;
    public int nrStartMinute;
    public int nrEndHour;
    public int nrEndMinute;

    public BatteryControlPowerProviderRA2() {
        this.pos = 0;
        this.nrStartHour = 0;
        this.nrStartMinute = 0;
        this.nrEndHour = 0;
        this.nrEndMinute = 0;
    }

    public BatteryControlPowerProviderRA2(int n, int n2, int n3, int n4, int n5) {
        this.pos = n;
        this.nrStartHour = n2;
        this.nrStartMinute = n3;
        this.nrEndHour = n4;
        this.nrEndMinute = n5;
    }

    public int getPos() {
        return this.pos;
    }

    public int getNrStartHour() {
        return this.nrStartHour;
    }

    public int getNrStartMinute() {
        return this.nrStartMinute;
    }

    public int getNrEndHour() {
        return this.nrEndHour;
    }

    public int getNrEndMinute() {
        return this.nrEndMinute;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BatteryControlPowerProviderRA2");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("nrStartHour");
        stringBuffer.append('=');
        stringBuffer.append(this.nrStartHour);
        stringBuffer.append(',');
        stringBuffer.append("nrStartMinute");
        stringBuffer.append('=');
        stringBuffer.append(this.nrStartMinute);
        stringBuffer.append(',');
        stringBuffer.append("nrEndHour");
        stringBuffer.append('=');
        stringBuffer.append(this.nrEndHour);
        stringBuffer.append(',');
        stringBuffer.append("nrEndMinute");
        stringBuffer.append('=');
        stringBuffer.append(this.nrEndMinute);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

