/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.global.DateTime;

public class CalendarEntrySerializer {
    public static void putOptionalCalendarEntry(ISerializer iSerializer, CalendarEntry calendarEntry) {
        boolean bl = calendarEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = calendarEntry.getEventID();
            iSerializer.putInt64(l);
            String string = calendarEntry.getOrganizer();
            iSerializer.putOptionalString(string);
            String string2 = calendarEntry.getSummary();
            iSerializer.putOptionalString(string2);
            String string3 = calendarEntry.getLocation();
            iSerializer.putOptionalString(string3);
            String[] stringArray = calendarEntry.getAttendee();
            iSerializer.putOptionalStringVarArray(stringArray);
            String string4 = calendarEntry.getDescription();
            iSerializer.putOptionalString(string4);
            DateTime dateTime = calendarEntry.getStart();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = calendarEntry.getEnd();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
            String string5 = calendarEntry.getEntryClass();
            iSerializer.putOptionalString(string5);
            int n = calendarEntry.getPriority();
            iSerializer.putInt32(n);
            String string6 = calendarEntry.getStatus();
            iSerializer.putOptionalString(string6);
            String[] stringArray2 = calendarEntry.getCategories();
            iSerializer.putOptionalStringVarArray(stringArray2);
            int n2 = calendarEntry.getSequence();
            iSerializer.putInt32(n2);
            String string7 = calendarEntry.getProdID();
            iSerializer.putOptionalString(string7);
            String string8 = calendarEntry.getIcalUID();
            iSerializer.putOptionalString(string8);
            String string9 = calendarEntry.getVersion();
            iSerializer.putOptionalString(string9);
            DateTime dateTime3 = calendarEntry.getCreated();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime3);
            DateTime dateTime4 = calendarEntry.getLastModified();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime4);
        }
    }

    public static void putOptionalCalendarEntryVarArray(ISerializer iSerializer, CalendarEntry[] calendarEntryArray) {
        boolean bl = calendarEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(calendarEntryArray.length);
            for (int i2 = 0; i2 < calendarEntryArray.length; ++i2) {
                CalendarEntrySerializer.putOptionalCalendarEntry(iSerializer, calendarEntryArray[i2]);
            }
        }
    }

    public static CalendarEntry getOptionalCalendarEntry(IDeserializer iDeserializer) {
        CalendarEntry calendarEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            DateTime dateTime2;
            String string;
            String string2;
            String string3;
            int n;
            String string4;
            int n2;
            String string5;
            DateTime dateTime3;
            DateTime dateTime4;
            String string6;
            String string7;
            String string8;
            String string9;
            long l;
            calendarEntry = new CalendarEntry();
            calendarEntry.eventID = l = iDeserializer.getInt64();
            calendarEntry.organizer = string9 = iDeserializer.getOptionalString();
            calendarEntry.summary = string8 = iDeserializer.getOptionalString();
            calendarEntry.location = string7 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            calendarEntry.attendee = stringArray;
            calendarEntry.description = string6 = iDeserializer.getOptionalString();
            calendarEntry.start = dateTime4 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarEntry.end = dateTime3 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarEntry.entryClass = string5 = iDeserializer.getOptionalString();
            calendarEntry.priority = n2 = iDeserializer.getInt32();
            calendarEntry.status = string4 = iDeserializer.getOptionalString();
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            calendarEntry.categories = stringArray2;
            calendarEntry.sequence = n = iDeserializer.getInt32();
            calendarEntry.prodID = string3 = iDeserializer.getOptionalString();
            calendarEntry.icalUID = string2 = iDeserializer.getOptionalString();
            calendarEntry.version = string = iDeserializer.getOptionalString();
            calendarEntry.created = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarEntry.lastModified = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return calendarEntry;
    }

    public static CalendarEntry[] getOptionalCalendarEntryVarArray(IDeserializer iDeserializer) {
        CalendarEntry[] calendarEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            calendarEntryArray = new CalendarEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                calendarEntryArray[i2] = CalendarEntrySerializer.getOptionalCalendarEntry(iDeserializer);
            }
        }
        return calendarEntryArray;
    }
}

