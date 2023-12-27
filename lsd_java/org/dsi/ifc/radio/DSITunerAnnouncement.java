/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSITunerAnnouncement
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_FILTER;
    public static final int ATTR_AVAILABILITY;
    public static final int ATTR_STATUS;
    public static final int ATTR_STATIONNAME;
    public static final int ANNOUNCEMENTTYPE_UNDEFINED;
    public static final int ANNOUNCEMENTTYPE_FM_TA;
    public static final int ANNOUNCEMENTTYPE_FM_PTY31;
    public static final int ANNOUNCEMENTTYPE_FM_EON_TA;
    public static final int ANNOUNCEMENTTYPE_DAB_ALARM;
    public static final int ANNOUNCEMENTTYPE_DAB_TRAFFIC;
    public static final int ANNOUNCEMENTTYPE_DAB_TRANSPORT;
    public static final int ANNOUNCEMENTTYPE_DAB_WARNING;
    public static final int ANNOUNCEMENTTYPE_DAB_NEWS;
    public static final int ANNOUNCEMENTTYPE_DAB_AREA_WEATHER;
    public static final int ANNOUNCEMENTTYPE_DAB_EVENT_ANNOUNCEMENT;
    public static final int ANNOUNCEMENTTYPE_DAB_SPECIAL_EVENT;
    public static final int ANNOUNCEMENTTYPE_DAB_PROGRAM_INFORMATION;
    public static final int ANNOUNCEMENTTYPE_DAB_SPORT_REPORT;
    public static final int ANNOUNCEMENTTYPE_DAB_FINANCIAL_REPORT;
    public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_1;
    public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_2;
    public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_3;
    public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_4;
    public static final int ANNOUNCEMENTTYPE_DAB_RESERVED_5;
    public static final int ANNOUNCEMENTTYPE_NONE;
    public static final int ANNOUNCEMENTTYPE_ALL;
    public static final int ANNOUNCEMENTTYPE_DAB_SEAMLESS_FM_TA;
    public static final int RT_SETFILTER;
    public static final int RT_ABORT;

    default public void setFilter(int n) {
    }

    default public void abort(int n) {
    }
}

