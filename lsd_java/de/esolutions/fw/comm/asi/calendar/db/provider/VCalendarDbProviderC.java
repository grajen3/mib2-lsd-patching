/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public interface VCalendarDbProviderC {
    default public void beginTransaction() {
    }

    default public void commitTransaction() {
    }

    default public void addEntries(int n, int n2, VCalendar[] vCalendarArray) {
    }

    default public void removeEntries(int n, int n2, long[] lArray) {
    }

    default public void removeProfile(int n) {
    }

    default public void removeAll() {
    }

    default public void getVersion() {
    }

    default public void setActiveProfiles(int[] nArray) {
    }

    default public void forceGetDataResult(int n) {
    }

    default public void setCalendarConfig(CalendarConfig calendarConfig) {
    }

    default public void getCalendarConfig(long l) {
    }

    default public void insertProfile(ProfileInfo profileInfo) {
    }

    default public void getCalendarEntry(long l) {
    }

    default public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2) {
    }

    default public void deleteProfile(long l) {
    }
}

