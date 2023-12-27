/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataCombinedNumbers {
    public int pos;
    public String pbName;
    public int numberType;
    public int callMode;
    public String telNumber;
    public int day;
    public int month;
    public int year;
    public int hour;
    public int minute;
    public int second;

    public DataCombinedNumbers() {
        this.pos = 0;
        this.pbName = "";
        this.numberType = 0;
        this.callMode = 0;
        this.telNumber = "";
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public DataCombinedNumbers(int n, String string, int n2, int n3, String string2, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.pos = n;
        this.pbName = string;
        this.numberType = n2;
        this.callMode = n3;
        this.telNumber = string2;
        this.day = n4;
        this.month = n5;
        this.year = n6;
        this.hour = n7;
        this.minute = n8;
        this.second = n9;
    }

    public int getPos() {
        return this.pos;
    }

    public String getPbName() {
        return this.pbName;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public int getCallMode() {
        return this.callMode;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("DataCombinedNumbers");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("pbName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pbName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("numberType");
        stringBuffer.append('=');
        stringBuffer.append(this.numberType);
        stringBuffer.append(',');
        stringBuffer.append("callMode");
        stringBuffer.append('=');
        stringBuffer.append(this.callMode);
        stringBuffer.append(',');
        stringBuffer.append("telNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append(this.year);
        stringBuffer.append(',');
        stringBuffer.append("hour");
        stringBuffer.append('=');
        stringBuffer.append(this.hour);
        stringBuffer.append(',');
        stringBuffer.append("minute");
        stringBuffer.append('=');
        stringBuffer.append(this.minute);
        stringBuffer.append(',');
        stringBuffer.append("second");
        stringBuffer.append('=');
        stringBuffer.append(this.second);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

