/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlExpiredTimer {
    public boolean timer1;
    public boolean timer2;
    public boolean timer3;
    public boolean timer4;

    public BatteryControlExpiredTimer() {
        this.timer1 = false;
        this.timer2 = false;
        this.timer3 = false;
        this.timer4 = false;
    }

    public BatteryControlExpiredTimer(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.timer1 = bl;
        this.timer2 = bl2;
        this.timer3 = bl3;
        this.timer4 = bl4;
    }

    public boolean isTimer1() {
        return this.timer1;
    }

    public boolean isTimer2() {
        return this.timer2;
    }

    public boolean isTimer3() {
        return this.timer3;
    }

    public boolean isTimer4() {
        return this.timer4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BatteryControlExpiredTimer");
        stringBuffer.append('(');
        stringBuffer.append("timer1");
        stringBuffer.append('=');
        stringBuffer.append(this.timer1);
        stringBuffer.append(',');
        stringBuffer.append("timer2");
        stringBuffer.append('=');
        stringBuffer.append(this.timer2);
        stringBuffer.append(',');
        stringBuffer.append("timer3");
        stringBuffer.append('=');
        stringBuffer.append(this.timer3);
        stringBuffer.append(',');
        stringBuffer.append("timer4");
        stringBuffer.append('=');
        stringBuffer.append(this.timer4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

