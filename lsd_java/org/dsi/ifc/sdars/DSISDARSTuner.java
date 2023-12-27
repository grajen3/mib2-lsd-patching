/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIBase;

public interface DSISDARSTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ELECTRONICSERIALCODE;
    public static final int ATTR_SERVICESTATUS3;
    public static final int ATTR_SIGNALQUALITY;
    public static final int ATTR_SELECTEDSTATION;
    public static final int ATTR_STATIONLIST;
    public static final int ATTR_CATEGORYLIST;
    public static final int ATTR_DETECTEDDEVICE;
    public static final int ATTR_STATICTAGGINGINFO;
    public static final int ATTR_AVAILABILITY;
    public static final int ATTR_STATIONDESCRIPTION;
    public static final int ATTR_SUBSCRIPTIONSTATUS;
    public static final int ATTR_PROFILESTATE;
    public static final int UNDEFINEDVALUES_SID;
    public static final int UNDEFINEDVALUES_STATION_NUMBER;
    public static final int UNDEFINEDVALUES_CATEGORY_NUMBER;
    public static final int UNDEFINEDVALUES_SIGNAL;
    public static final int STATIONSELECTIONMODE_SID;
    public static final int SELECTSTATIONSTATUS_UNDEFINED;
    public static final int SELECTSTATIONSTATUS_RUNNING;
    public static final int SELECTSTATIONSTATUS_ABORTED;
    public static final int SELECTSTATIONSTATUS_DONE;
    public static final int SELECTSTATIONSTATUS_INVALID;
    public static final int SELECTSTATIONSTATUS_NOT_SUBSCRIBED;
    public static final int SELECTSTATIONSTATUS_GCI_UPDATE_RUNNING;
    public static final int SUBSCRIPTION_UNDEFINED;
    public static final int SUBSCRIPTION_UNSUBSCRIBED;
    public static final int SUBSCRIPTION_SUBSCRIBED;
    public static final int SUBSCRIPTION_SUSPENDALERT;
    public static final int SUBSCRIPTION_SUSPENDED;
    public static final int EPGFLAG_UNDEFINED;
    public static final int EPGFLAG_FEATURED;
    public static final int EPGFLAG_HIGHLIGHTED;
    public static final int EPGFLAG_LIVE;
    public static final int EPGFLAG_NEW;
    public static final int AUDIOSTATUS_UNDEFINED;
    public static final int AUDIOSTATUS_MUTE_ON;
    public static final int AUDIOSTATUS_MUTE_OFF;
    public static final int LISTUPDATESTATUS_UNDEFINED;
    public static final int LISTUPDATESTATUS_RUNNING;
    public static final int LISTUPDATESTATUS_LIST_STABLE;
    public static final int UPDATESTATUS_UNDEFINED;
    public static final int UPDATESTATUS_RUNNING;
    public static final int UPDATESTATUS_STABLE;
    public static final int SIGNALQUALITY_UNDEFINED;
    public static final int SIGNALQUALITY_NO_SIGNAL;
    public static final int SIGNALQUALITY_WEAK;
    public static final int SIGNALQUALITY_GOOD;
    public static final int SIGNALQUALITY_EXCELLENT;
    public static final int SIGNALSTATUS_UNDEFINED;
    public static final int SIGNALSTATUS_NOT_PRESENT;
    public static final int SIGNALSTATUS_PRESENT;
    public static final int ANTENNASTATUS_UNDEFINED;
    public static final int ANTENNASTATUS_NOT_CONNECTED;
    public static final int ANTENNASTATUS_CONNECTED;
    public static final int DEVICETYPE_UNDEFINED;
    public static final int DEVICETYPE_NONE;
    public static final int DEVICETYPE_UNKNOWN;
    public static final int DEVICETYPE_RU;
    public static final int DEVICETYPE_UNAVAILABLE;
    public static final int RESETTYPE_UNDEFINED;
    public static final int RESETTYPE_TO_DEFAULT;
    public static final int AVAILABILITY_NOTAVAILABLE;
    public static final int AVAILABILITY_AVAILABLE;
    public static final int RESETTYPE_ANONYMIZE;
    public static final int INFORMATION_UNKNOWN;
    public static final int INFORMATION_EPGCHANNELLIST;
    public static final int INFORMATION_RADIOTEXT2;
    public static final int INFORMATION_CHANNELART;
    public static final int INFORMATION_BACKGROUNDART;
    public static final int INFORMATION_ALBUMART;
    public static final int INFORMATION_GENREART;
    public static final int INFORMATION_STUDIOART;
    public static final int RT_SELECTSTATION;
    public static final int RT_RESET;
    public static final int RT_GETTIME;
    public static final int RT_SETRADIOTEXT2CONFIG;
    public static final int RT_GETEPG24HOUR;
    public static final int RT_GETEPGDESCRIPTION;
    public static final int RT_NOTIFYHMIREADY;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_SELECTSTATIONSTATUS;
    public static final int RP_RESPONSETIME;
    public static final int RP_RESPONSEEPG24HOUR;
    public static final int RP_RESPONSEEPGDESCRIPTION;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int IN_INFORMATIONEPGCHANNELLIST;
    public static final int IN_INFORMATIONRADIOTEXT;
    public static final int IN_INFORMATIONCHANNELART;
    public static final int IN_INFORMATIONBACKGROUNDART;
    public static final int IN_INFORMATIONALBUMART;
    public static final int IN_INFORMATIONGENREART;
    public static final int IN_INFORMATIONSTUDIOART;
    public static final int IN_INFORMATIONRADIOTEXT2;

    default public void selectStation(int n, int n2) {
    }

    default public void getTime() {
    }

    default public void getEPG24Hour(int n) {
    }

    default public void getEPGDescription(int n, int n2) {
    }

    default public void notifyHMIReady(int n) {
    }

    default public void reset(int n) {
    }

    default public void setRadioText2Config(int n, int n2) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

