/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.CalendarSummary;
import org.dsi.ifc.global.DateTime;

public class CalendarSummarySerializer {
    public static void putOptionalCalendarSummary(ISerializer iSerializer, CalendarSummary calendarSummary) {
        boolean bl = calendarSummary == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DateTime dateTime = calendarSummary.getStart();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = calendarSummary.getEnd();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
            String string = calendarSummary.getLocation();
            iSerializer.putOptionalString(string);
            String string2 = calendarSummary.getSummary();
            iSerializer.putOptionalString(string2);
            long l = calendarSummary.getEventID();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalCalendarSummaryVarArray(ISerializer iSerializer, CalendarSummary[] calendarSummaryArray) {
        boolean bl = calendarSummaryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(calendarSummaryArray.length);
            for (int i2 = 0; i2 < calendarSummaryArray.length; ++i2) {
                CalendarSummarySerializer.putOptionalCalendarSummary(iSerializer, calendarSummaryArray[i2]);
            }
        }
    }

    public static CalendarSummary getOptionalCalendarSummary(IDeserializer iDeserializer) {
        CalendarSummary calendarSummary = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            String string;
            String string2;
            DateTime dateTime;
            DateTime dateTime2;
            calendarSummary = new CalendarSummary();
            calendarSummary.start = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarSummary.end = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            calendarSummary.location = string2 = iDeserializer.getOptionalString();
            calendarSummary.summary = string = iDeserializer.getOptionalString();
            calendarSummary.eventID = l = iDeserializer.getInt64();
        }
        return calendarSummary;
    }

    public static CalendarSummary[] getOptionalCalendarSummaryVarArray(IDeserializer iDeserializer) {
        CalendarSummary[] calendarSummaryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            calendarSummaryArray = new CalendarSummary[n];
            for (int i2 = 0; i2 < n; ++i2) {
                calendarSummaryArray[i2] = CalendarSummarySerializer.getOptionalCalendarSummary(iDeserializer);
            }
        }
        return calendarSummaryArray;
    }
}

