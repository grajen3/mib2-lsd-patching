/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.calendar.VEvent;
import org.dsi.ifc.calendar.VTimeZone;

public class VCalendar {
    public String categories;
    public String classType;
    public String description;
    public String dtEnd;
    public String dtStamp;
    public String dtStart;
    public String method;
    public String summary;
    public VTimeZone[] timeZone;
    public String tzID;
    public String uid;
    public String version;
    public VEvent[] vevent;

    public VCalendar() {
        this.vevent = null;
        this.timeZone = null;
    }

    public VCalendar(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, VTimeZone[] vTimeZoneArray, String string9, String string10, String string11, VEvent[] vEventArray) {
        this.categories = string;
        this.classType = string2;
        this.description = string3;
        this.dtEnd = string4;
        this.dtStamp = string5;
        this.dtStart = string6;
        this.method = string7;
        this.summary = string8;
        this.timeZone = vTimeZoneArray;
        this.tzID = string9;
        this.uid = string10;
        this.version = string11;
        this.vevent = vEventArray;
    }

    public String getCategories() {
        return this.categories;
    }

    public String getClassType() {
        return this.classType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDtEnd() {
        return this.dtEnd;
    }

    public String getDtStamp() {
        return this.dtStamp;
    }

    public String getDtStart() {
        return this.dtStart;
    }

    public String getMethod() {
        return this.method;
    }

    public String getSummary() {
        return this.summary;
    }

    public VTimeZone[] getTimeZone() {
        return this.timeZone;
    }

    public String getTzID() {
        return this.tzID;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersion() {
        return this.version;
    }

    public VEvent[] getVevent() {
        return this.vevent;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(950);
        stringBuffer.append("VCalendar");
        stringBuffer.append('(');
        stringBuffer.append("categories");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.categories);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("classType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.classType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dtEnd");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtEnd);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dtStamp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtStamp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dtStart");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtStart);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("method");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.method);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("summary");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.summary);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("timeZone");
        stringBuffer.append('[');
        if (this.timeZone != null) {
            stringBuffer.append(this.timeZone.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.timeZone != null) {
            n3 = this.timeZone.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.timeZone[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.timeZone);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("tzID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.tzID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.uid);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.version);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("vevent");
        stringBuffer.append('[');
        if (this.vevent != null) {
            stringBuffer.append(this.vevent.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.vevent != null) {
            n3 = this.vevent.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.vevent[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.vevent);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

