/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

public class VTimeZoneStandard {
    public String dtStart;
    public String rdate;
    public String rrule;
    public String tzName;
    public String entryTyp;
    public String tzOffsetFrom;
    public String tzOffsetTo;
    public String due;
    public String exdate;

    public VTimeZoneStandard() {
    }

    public VTimeZoneStandard(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        this.dtStart = string;
        this.rdate = string2;
        this.rrule = string3;
        this.tzName = string4;
        this.entryTyp = string5;
        this.tzOffsetFrom = string6;
        this.tzOffsetTo = string7;
        this.due = string8;
        this.exdate = string9;
    }

    public String getDtStart() {
        return this.dtStart;
    }

    public String getRdate() {
        return this.rdate;
    }

    public String getRrule() {
        return this.rrule;
    }

    public String getTzName() {
        return this.tzName;
    }

    public String getTzOffsetFrom() {
        return this.tzOffsetFrom;
    }

    public String getTzOffsetTo() {
        return this.tzOffsetTo;
    }

    public void setDtStart(String string) {
        this.dtStart = string;
    }

    public void setRdate(String string) {
        this.rdate = string;
    }

    public void setRrule(String string) {
        this.rrule = string;
    }

    public void setTzName(String string) {
        this.tzName = string;
    }

    public void setTzOffsetFrom(String string) {
        this.tzOffsetFrom = string;
    }

    public void setTzOffsetTo(String string) {
        this.tzOffsetTo = string;
    }

    public String getDue() {
        return this.due;
    }

    public void setDue(String string) {
        this.due = string;
    }

    public String getExdate() {
        return this.exdate;
    }

    public void setExdate(String string) {
        this.exdate = string;
    }

    public final String getEntryTyp() {
        return this.entryTyp;
    }

    public final void setEntryTyp(String string) {
        this.entryTyp = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(700);
        stringBuffer.append("VTimeZoneStandard");
        stringBuffer.append('(');
        stringBuffer.append("dtStart");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtStart);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("rdate");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.rdate);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("rrule");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.rrule);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tzName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.tzName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("entryTyp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entryTyp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tzOffsetFrom");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.tzOffsetFrom);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tzOffsetTo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.tzOffsetTo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("due");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.due);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exdate");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exdate);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

