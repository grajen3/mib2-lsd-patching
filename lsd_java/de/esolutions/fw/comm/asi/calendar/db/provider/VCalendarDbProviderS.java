/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public interface VCalendarDbProviderS {
    default public void beginTransaction(VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void commitTransaction(VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void addEntries(int n, int n2, VCalendar[] vCalendarArray, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void removeEntries(int n, int n2, long[] lArray, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void removeProfile(int n, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void removeAll(VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void getVersion(VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void setActiveProfiles(int[] nArray, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void forceGetDataResult(int n, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void setCalendarConfig(CalendarConfig calendarConfig, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void getCalendarConfig(long l, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void insertProfile(ProfileInfo profileInfo, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void getCalendarEntry(long l, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void getCalendarSummaries(DateTime dateTime, DateTime dateTime2, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }

    default public void deleteProfile(long l, VCalendarDbProviderReply vCalendarDbProviderReply) {
    }
}

