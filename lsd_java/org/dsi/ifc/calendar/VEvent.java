/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.calendar.VAlarm;
import org.dsi.ifc.calendar.VAttendee;

public class VEvent {
    public VAlarm alarm;
    public VAttendee[] attendeeList;
    public String categories;
    public String classTyp;
    public String created;
    public String description;
    public String dtEnd;
    public String dtStart;
    public String dtStamp;
    public String duration;
    public String lastModified;
    public String location;
    public String priority;
    public VAttendee organizer;
    public String summary;
    public String uid;
    public String rrule;
    public String sequence;
    public String transp;
    public String url;
    public String entryType;

    public VEvent() {
    }

    public VEvent(VAlarm vAlarm, VAttendee[] vAttendeeArray, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, VAttendee vAttendee, String string12, String string13, String string14, String string15, String string16, String string17, String string18) {
        this.alarm = vAlarm;
        this.attendeeList = vAttendeeArray;
        this.categories = string;
        this.classTyp = string2;
        this.created = string3;
        this.description = string4;
        this.dtEnd = string5;
        this.dtStart = string6;
        this.dtStamp = string7;
        this.duration = string8;
        this.lastModified = string9;
        this.location = string10;
        this.priority = string11;
        this.organizer = vAttendee;
        this.summary = string12;
        this.uid = string13;
        this.rrule = string14;
        this.sequence = string15;
        this.transp = string16;
        this.url = string17;
        this.entryType = string18;
    }

    public String getSequence() {
        return this.sequence;
    }

    public void setSequence(String string) {
        this.sequence = string;
    }

    public String getTransp() {
        return this.transp;
    }

    public void setTransp(String string) {
        this.transp = string;
    }

    public String getRrule() {
        return this.rrule;
    }

    public void setRrule(String string) {
        this.rrule = string;
    }

    public VAlarm getAlarm() {
        return this.alarm;
    }

    public VAttendee[] getAttendeeList() {
        return this.attendeeList;
    }

    public String getClassTyp() {
        return this.classTyp;
    }

    public String getCreated() {
        return this.created;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDtEnd() {
        return this.dtEnd;
    }

    public String getDtStart() {
        return this.dtStart;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getLocation() {
        return this.location;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAlarm(VAlarm vAlarm) {
        this.alarm = vAlarm;
    }

    public void setAttendeeList(VAttendee[] vAttendeeArray) {
        this.attendeeList = (VAttendee[])vAttendeeArray.clone();
    }

    public void setClassTyp(String string) {
        this.classTyp = string;
    }

    public void setCreated(String string) {
        this.created = string;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public void setDtEnd(String string) {
        this.dtEnd = string;
    }

    public void setDtStart(String string) {
        this.dtStart = string;
    }

    public void setDuration(String string) {
        this.duration = string;
    }

    public void setLastModified(String string) {
        this.lastModified = string;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public void setPriority(String string) {
        this.priority = string;
    }

    public void setSummary(String string) {
        this.summary = string;
    }

    public void setUid(String string) {
        this.uid = string;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String string) {
        this.categories = string;
    }

    public String getDtStamp() {
        return this.dtStamp;
    }

    public void setDtStamp(String string) {
        this.dtStamp = string;
    }

    public VAttendee getOrganizer() {
        return this.organizer;
    }

    public void setOrganizer(VAttendee vAttendee) {
        this.organizer = vAttendee;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setEntryType(String string) {
        this.entryType = string;
    }

    public String getEntryType() {
        return this.entryType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3450);
        stringBuffer.append("VEvent");
        stringBuffer.append('(');
        stringBuffer.append("alarm");
        stringBuffer.append('=');
        stringBuffer.append(this.alarm);
        stringBuffer.append(',');
        stringBuffer.append("attendeeList");
        stringBuffer.append('[');
        if (this.attendeeList != null) {
            stringBuffer.append(this.attendeeList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.attendeeList != null) {
            int n = this.attendeeList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.attendeeList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.attendeeList);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("categories");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.categories);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("classTyp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.classTyp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("created");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.created);
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
        stringBuffer.append("dtStart");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtStart);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dtStamp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dtStamp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("duration");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.duration);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("lastModified");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastModified);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.location);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.priority);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("organizer");
        stringBuffer.append('=');
        stringBuffer.append(this.organizer);
        stringBuffer.append(',');
        stringBuffer.append("summary");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.summary);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.uid);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("rrule");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.rrule);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sequence");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sequence);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("transp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.transp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entryType);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

