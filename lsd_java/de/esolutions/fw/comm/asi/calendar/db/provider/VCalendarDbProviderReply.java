/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VEvent;

public interface VCalendarDbProviderReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void beginTransactionResult(int n) {
    }

    default public void commitTransactionResult(int n) {
    }

    default public void addEntriesResult(int n) {
    }

    default public void removeEntriesResult(int n) {
    }

    default public void removeProfileResult(int n) {
    }

    default public void removeAllResult(int n) {
    }

    default public void getVersionResult(VersionInfo[] versionInfoArray) {
    }

    default public void setActiveProfilesResult(int n) {
    }

    default public void forceGetData() {
    }

    default public void setCalendarConfigResult(int n) {
    }

    default public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
    }

    default public void insertProfileResult(int n) {
    }

    default public void getCalendarEntryResult(int n, VEvent vEvent) {
    }

    default public void getCalendarSummariesResult(int n, VEvent[] vEventArray) {
    }

    default public void deleteProfileResult(int n) {
    }
}

