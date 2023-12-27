/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;

public interface DSICalendarC {
    default public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
    }

    default public void getCalendarEntry(long l) {
    }

    default public void setCalendarConfig(CalendarConfig calendarConfig) {
    }

    default public void getCalendarConfig(long l) {
    }

    default public void setAlarm(long l, long l2) {
    }

    default public void getAlarm(long l) {
    }

    default public void getEmailAddresses(long l) {
    }

    default public void getTelephoneNumbers(long l) {
    }

    default public void insertProfile(ProfileInfo profileInfo) {
    }

    default public void deleteProfile(long l) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

