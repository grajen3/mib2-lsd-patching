/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class PosTimeInfo {
    public int timeZoneOffset;
    public boolean summerTimeValidity;
    public short summerTimeMonthFrom;
    public short summerTimeDayFrom;
    public short summerTimeHourFrom;
    public short summerTimeMonthTo;
    public short summerTimeDayTo;
    public short summerTimeHourTo;
    public short summerTimeYearFrom;
    public short summerTimeYearTo;

    public PosTimeInfo() {
        this.timeZoneOffset = 0;
        this.summerTimeValidity = false;
        this.summerTimeMonthFrom = 0;
        this.summerTimeDayFrom = 0;
        this.summerTimeHourFrom = 0;
        this.summerTimeMonthTo = 0;
        this.summerTimeDayTo = 0;
        this.summerTimeHourTo = 0;
        this.summerTimeYearFrom = 0;
        this.summerTimeYearTo = 0;
    }

    public PosTimeInfo(int n, boolean bl, short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8) {
        this.timeZoneOffset = n;
        this.summerTimeValidity = bl;
        this.summerTimeMonthFrom = s;
        this.summerTimeDayFrom = s2;
        this.summerTimeHourFrom = s3;
        this.summerTimeMonthTo = s4;
        this.summerTimeDayTo = s5;
        this.summerTimeHourTo = s6;
        this.summerTimeYearFrom = s7;
        this.summerTimeYearTo = s8;
    }

    public int getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public boolean isSummerTimeValidity() {
        return this.summerTimeValidity;
    }

    public short getSummerTimeMonthFrom() {
        return this.summerTimeMonthFrom;
    }

    public short getSummerTimeDayFrom() {
        return this.summerTimeDayFrom;
    }

    public short getSummerTimeHourFrom() {
        return this.summerTimeHourFrom;
    }

    public short getSummerTimeMonthTo() {
        return this.summerTimeMonthTo;
    }

    public short getSummerTimeDayTo() {
        return this.summerTimeDayTo;
    }

    public short getSummerTimeHourTo() {
        return this.summerTimeHourTo;
    }

    public short getSummerTimeYearFrom() {
        return this.summerTimeYearFrom;
    }

    public short getSummerTimeYearTo() {
        return this.summerTimeYearTo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("PosTimeInfo");
        stringBuffer.append('(');
        stringBuffer.append("timeZoneOffset");
        stringBuffer.append('=');
        stringBuffer.append(this.timeZoneOffset);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeValidity");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeValidity);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeMonthFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeMonthFrom);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeDayFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeDayFrom);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeHourFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeHourFrom);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeMonthTo");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeMonthTo);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeDayTo");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeDayTo);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeHourTo");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeHourTo);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeYearFrom");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeYearFrom);
        stringBuffer.append(',');
        stringBuffer.append("summerTimeYearTo");
        stringBuffer.append('=');
        stringBuffer.append(this.summerTimeYearTo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

