/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class ClockSummerTimeData {
    public boolean validity;
    public short yearFrom;
    public byte monthFrom;
    public byte dayFrom;
    public byte hourFrom;
    public short yearTo;
    public byte monthTo;
    public byte dayTo;
    public byte hourTo;

    public ClockSummerTimeData() {
        this.validity = false;
        this.yearFrom = 0;
        this.monthFrom = 0;
        this.dayFrom = 0;
        this.hourFrom = 0;
        this.yearTo = 0;
        this.monthTo = 0;
        this.dayTo = 0;
        this.hourTo = 0;
    }

    public ClockSummerTimeData(boolean bl, short s, byte by, byte by2, byte by3, short s2, byte by4, byte by5, byte by6) {
        this.validity = bl;
        this.yearFrom = s;
        this.monthFrom = by;
        this.dayFrom = by2;
        this.hourFrom = by3;
        this.yearTo = s2;
        this.monthTo = by4;
        this.dayTo = by5;
        this.hourTo = by6;
    }

    public boolean isValidity() {
        return this.validity;
    }

    public short getYearFrom() {
        return this.yearFrom;
    }

    public byte getMonthFrom() {
        return this.monthFrom;
    }

    public byte getDayFrom() {
        return this.dayFrom;
    }

    public byte getHourFrom() {
        return this.hourFrom;
    }

    public short getYearTo() {
        return this.yearTo;
    }

    public byte getMonthTo() {
        return this.monthTo;
    }

    public byte getDayTo() {
        return this.dayTo;
    }

    public byte getHourTo() {
        return this.hourTo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("ClockSummerTimeData");
        stringBuffer.append('(');
        stringBuffer.append("validity");
        stringBuffer.append('=');
        stringBuffer.append(this.validity);
        stringBuffer.append(',');
        stringBuffer.append("yearFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.yearFrom);
        stringBuffer.append(',');
        stringBuffer.append("monthFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.monthFrom);
        stringBuffer.append(',');
        stringBuffer.append("dayFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.dayFrom);
        stringBuffer.append(',');
        stringBuffer.append("hourFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.hourFrom);
        stringBuffer.append(',');
        stringBuffer.append("yearTo");
        stringBuffer.append('=');
        stringBuffer.append(this.yearTo);
        stringBuffer.append(',');
        stringBuffer.append("monthTo");
        stringBuffer.append('=');
        stringBuffer.append(this.monthTo);
        stringBuffer.append(',');
        stringBuffer.append("dayTo");
        stringBuffer.append('=');
        stringBuffer.append(this.dayTo);
        stringBuffer.append(',');
        stringBuffer.append("hourTo");
        stringBuffer.append('=');
        stringBuffer.append(this.hourTo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

