/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlWeekdays {
    public boolean monday;
    public boolean tuesday;
    public boolean wednesday;
    public boolean thursday;
    public boolean friday;
    public boolean saturday;
    public boolean sunday;
    public boolean cyclic;

    public BatteryControlWeekdays() {
        this.monday = false;
        this.tuesday = false;
        this.wednesday = false;
        this.thursday = false;
        this.friday = false;
        this.saturday = false;
        this.sunday = false;
        this.cyclic = false;
    }

    public BatteryControlWeekdays(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.monday = bl;
        this.tuesday = bl2;
        this.wednesday = bl3;
        this.thursday = bl4;
        this.friday = bl5;
        this.saturday = bl6;
        this.sunday = bl7;
        this.cyclic = bl8;
    }

    public boolean isMonday() {
        return this.monday;
    }

    public boolean isTuesday() {
        return this.tuesday;
    }

    public boolean isWednesday() {
        return this.wednesday;
    }

    public boolean isThursday() {
        return this.thursday;
    }

    public boolean isFriday() {
        return this.friday;
    }

    public boolean isSaturday() {
        return this.saturday;
    }

    public boolean isSunday() {
        return this.sunday;
    }

    public boolean isCyclic() {
        return this.cyclic;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BatteryControlWeekdays");
        stringBuffer.append('(');
        stringBuffer.append("monday");
        stringBuffer.append('=');
        stringBuffer.append(this.monday);
        stringBuffer.append(',');
        stringBuffer.append("tuesday");
        stringBuffer.append('=');
        stringBuffer.append(this.tuesday);
        stringBuffer.append(',');
        stringBuffer.append("wednesday");
        stringBuffer.append('=');
        stringBuffer.append(this.wednesday);
        stringBuffer.append(',');
        stringBuffer.append("thursday");
        stringBuffer.append('=');
        stringBuffer.append(this.thursday);
        stringBuffer.append(',');
        stringBuffer.append("friday");
        stringBuffer.append('=');
        stringBuffer.append(this.friday);
        stringBuffer.append(',');
        stringBuffer.append("saturday");
        stringBuffer.append('=');
        stringBuffer.append(this.saturday);
        stringBuffer.append(',');
        stringBuffer.append("sunday");
        stringBuffer.append('=');
        stringBuffer.append(this.sunday);
        stringBuffer.append(',');
        stringBuffer.append("cyclic");
        stringBuffer.append('=');
        stringBuffer.append(this.cyclic);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

