/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.global.DateTime;

public class CalendarEntry {
    public long eventID;
    public String organizer;
    public String summary;
    public String location;
    public String[] attendee;
    public String description;
    public DateTime start;
    public DateTime end;
    public String entryClass;
    public int priority;
    public String status;
    public String[] categories;
    public int sequence;
    public String prodID;
    public String icalUID;
    public String version;
    public DateTime created;
    public DateTime lastModified;

    public long getEventID() {
        return this.eventID;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public String getSummary() {
        return this.summary;
    }

    public String[] getAttendee() {
        return this.attendee;
    }

    public String getEntryClass() {
        return this.entryClass;
    }

    public String getDescription() {
        return this.description;
    }

    public DateTime getStart() {
        return this.start;
    }

    public DateTime getEnd() {
        return this.end;
    }

    public String getLocation() {
        return this.location;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    public String[] getCategories() {
        return this.categories;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String getProdID() {
        return this.prodID;
    }

    public String getIcalUID() {
        return this.icalUID;
    }

    public String getVersion() {
        return this.version;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public DateTime getLastModified() {
        return this.lastModified;
    }

    public CalendarEntry(long l, String string, String string2, String string3, String[] stringArray, String string4, DateTime dateTime, DateTime dateTime2, String string5, int n, String string6, String[] stringArray2, int n2, String string7, String string8, String string9, DateTime dateTime3, DateTime dateTime4) {
        this.eventID = l;
        this.organizer = string;
        this.summary = string2;
        this.location = string3;
        this.attendee = stringArray;
        this.description = string4;
        this.start = dateTime;
        this.end = dateTime2;
        this.entryClass = string5;
        this.priority = n;
        this.status = string6;
        this.categories = stringArray2;
        this.sequence = n2;
        this.prodID = string7;
        this.icalUID = string8;
        this.version = string9;
        this.created = dateTime3;
        this.lastModified = dateTime4;
    }

    public CalendarEntry() {
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(5050);
        stringBuffer.append("CalendarEntry");
        stringBuffer.append('(');
        stringBuffer.append("eventID");
        stringBuffer.append('=');
        stringBuffer.append(this.eventID);
        stringBuffer.append(',');
        stringBuffer.append("organizer");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.organizer);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("summary");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.summary);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.location);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("attendee");
        stringBuffer.append('[');
        if (this.attendee != null) {
            stringBuffer.append(this.attendee.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.attendee != null) {
            n3 = this.attendee.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.attendee[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.attendee);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("start");
        stringBuffer.append('=');
        stringBuffer.append(this.start);
        stringBuffer.append(',');
        stringBuffer.append("end");
        stringBuffer.append('=');
        stringBuffer.append(this.end);
        stringBuffer.append(',');
        stringBuffer.append("entryClass");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.entryClass);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.status);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("categories");
        stringBuffer.append('[');
        if (this.categories != null) {
            stringBuffer.append(this.categories.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.categories != null) {
            n3 = this.categories.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.categories[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.categories);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("sequence");
        stringBuffer.append('=');
        stringBuffer.append(this.sequence);
        stringBuffer.append(',');
        stringBuffer.append("prodID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.prodID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("icalUID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.icalUID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.version);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("created");
        stringBuffer.append('=');
        stringBuffer.append(this.created);
        stringBuffer.append(',');
        stringBuffer.append("lastModified");
        stringBuffer.append('=');
        stringBuffer.append(this.lastModified);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

