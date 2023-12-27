/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;

public interface DSICalendarReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void getCalendarSummariesResult(int n, CalendarSummary[] calendarSummaryArray) {
    }

    default public void getCalendarEntryResult(int n, CalendarEntry calendarEntry) {
    }

    default public void indicateAlarm(long l) {
    }

    default public void setCalendarConfigResult(int n) {
    }

    default public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
    }

    default public void setAlarmRepeatResult(int n) {
    }

    default public void getAlarmRepeatResult(int n, long l) {
    }

    default public void getEmailAddressesResult(int n, String[] stringArray) {
    }

    default public void getTelephoneNumbersResult(int n, String[] stringArray) {
    }

    default public void insertProfileResult(int n) {
    }

    default public void deleteProfileResult(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

