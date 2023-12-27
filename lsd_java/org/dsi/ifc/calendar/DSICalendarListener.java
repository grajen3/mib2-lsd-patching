/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;

public interface DSICalendarListener
extends DSIListener {
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
}

