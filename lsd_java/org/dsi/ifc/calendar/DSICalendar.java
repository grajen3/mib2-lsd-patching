/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;

public interface DSICalendar
extends DSIBase {
    public static final String VERSION;
    public static final int RT_GETCALENDARSUMMARIES;
    public static final int RT_GETCALENDARENTRY;
    public static final int RT_SETCALENDARCONFIG;
    public static final int RT_GETCALENDARCONFIG;
    public static final int RT_SETALARM;
    public static final int RT_GETALARM;
    public static final int RT_GETEMAILADDRESSES;
    public static final int RT_GETTELEPHONENUMBERS;
    public static final int RT_INSERTPROFILE;
    public static final int RT_DELETEPROFILE;
    public static final int RP_GETCALENDARSUMMARIESRESULT;
    public static final int RP_GETCALENDARENTRYRESULT;
    public static final int RP_SETCALENDARCONFIGRESULT;
    public static final int RP_GETCALENDARCONFIGRESULT;
    public static final int RP_SETALARMREPEATRESULT;
    public static final int RP_GETALARMREPEATRESULT;
    public static final int RP_GETEMAILADDRESSESRESULT;
    public static final int RP_GETTELEPHONENUMBERSRESULT;
    public static final int RP_INSERTPROFILERESULT;
    public static final int RP_DELETEPROFILERESULT;
    public static final int IN_INDICATEALARM;
    public static final int RESULTTYPE_OK;
    public static final int RESULTTYPE_ERROR;
    public static final int WEEKVIEW_5DAYS;
    public static final int WEEKVIEW_7DAYS;

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
}

