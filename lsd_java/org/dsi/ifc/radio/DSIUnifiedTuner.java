/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIUnifiedTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DETECTEDDEVICE;
    public static final int ATTR_AUDIOSTATUS;
    public static final int ATTR_SELECTEDSTATION;
    public static final int ATTR_STATIONLIST;
    public static final int ATTR_RADIOTEXT;
    public static final int ATTR_ENHANCEDRADIOTEXT;
    public static final int ATTR_RADIOTEXTPLUS;
    public static final int ATTR_ENHANCEDRADIOTEXTPLUS;
    public static final int ATTR_SLIDESHOWINFO;
    public static final int ATTR_SOFTLINKSWITCHSTATUS;
    public static final int ATTR_REGMODESTATUS;
    public static final int ATTR_DEVICEUSAGESTATUS;
    public static final int ATTR_PROFILESTATE;
    public static final int RT_SELECTSTATION;
    public static final int RT_SETSTATIONFOLLOWINGMODE;
    public static final int RT_SETLISTMODE;
    public static final int RT_ENABLERADIOTEXTPLUS;
    public static final int RT_SETSOFTLINKSWITCH;
    public static final int RT_SETREGMODE;
    public static final int RT_SWITCHDEVICEUSAGE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_SELECTSTATIONSTATUS;
    public static final int RP_LISTMODE;
    public static final int RP_STATIONFOLLOWINGMODE;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int DEVICETYPE_NONE;
    public static final int DEVICETYPE_RU;
    public static final int STATIONFOLLOWINGMODE_AUTO;
    public static final int STATIONFOLLOWINGMODE_STAYANALOG;
    public static final int STATIONFOLLOWINGMODE_STAYDIGITAL;
    public static final int STATIONFOLLOWINGMODE_OFF;
    public static final int SOFTLINKSWITCH_OFF;
    public static final int SOFTLINKSWITCH_ON;
    public static final int REGMODE_OFF;
    public static final int REGMODE_ON;
    public static final int REGMODE_AUTO;
    public static final int AUDIOSTATUS_ANALOG;
    public static final int AUDIOSTATUS_DIGITAL;
    public static final int AUDIOSTATUS_MUTE;
    public static final int LISTMODE_AUTO;
    public static final int LISTMODE_SHOWALTERNATIVES;
    public static final int TPAVAILABILITY_UNKNOWN;
    public static final int TPAVAILABILITY_NO;
    public static final int TPAVAILABILITY_DIRECT;
    public static final int TPAVAILABILITY_LINKED;
    public static final int SELECTSTATIONMODE_FM;
    public static final int SELECTSTATIONMODE_DAB;
    public static final int RADIOTEXTSOURCE_FM;
    public static final int RADIOTEXTSOURCE_DAB;
    public static final int SCROLLINGPS_UNKNOWN;
    public static final int SCROLLINGPS_FALSE;
    public static final int SCROLLINGPS_TRUE;
    public static final int SELECTSTATIONSTATUS_UNDEFINED;
    public static final int SELECTSTATIONSTATUS_RUNNING;
    public static final int SELECTSTATIONSTATUS_DONE;
    public static final int SELECTSTATIONSTATUS_ABORTED;
    public static final int SELECTSTATIONSTATUS_FAILURE;
    public static final int DEVICEUSAGE_AVAILABLE;
    public static final int DEVICEUSAGE_USED;

    default public void selectStation(int n, long l, int n2, int n3, int n4, int n5) {
    }

    default public void setStationFollowingMode(int n) {
    }

    default public void setListMode(int n) {
    }

    default public void enableRadioTextPlus(int[] nArray) {
    }

    default public void setSoftLinkSwitch(int n) {
    }

    default public void setRegMode(int n) {
    }

    default public void switchDeviceUsage(int n) {
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

