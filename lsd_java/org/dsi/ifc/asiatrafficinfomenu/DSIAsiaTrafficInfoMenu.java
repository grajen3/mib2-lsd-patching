/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

import org.dsi.ifc.base.DSIBase;

public interface DSIAsiaTrafficInfoMenu
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ACTIVEINTERRUPTS;
    public static final int ATTR_TRAFFICTYPE;
    public static final int ATTR_PREFECTURE;
    public static final int ATTR_PROBEDATASETTING;
    public static final int ATTR_FREQUENCY;
    public static final int ATTR_RECEPTIONSTATUS;
    public static final int ATTR_RECEIVABLESTATIONS;
    public static final int ATTR_RECEPTIONDATE;
    public static final int RT_REQUESTRESOURCEINFORMATION;
    public static final int RT_REQUESTTRAFFICINFORMATIONDETAILS;
    public static final int RT_SETPREFECTURESETTING;
    public static final int RT_SETPROBEDATASETTING;
    public static final int RT_SETLANGUAGE;
    public static final int RP_REQUESTRESOURCEINFORMATIONRESPONSE;
    public static final int RP_REQUESTTRAFFICINFORMATIONDETAILSRESPONSE;
    public static final int RP_SETLANGUAGERESPONSE;
    public static final int TRAFFICTYPE_UNKNOWN;
    public static final int TRAFFICTYPE_DSRC_TRAFFIC_VOICE_MESSAGE;
    public static final int TRAFFICTYPE_DSRC_VICS_TRAFFIC_MESSAGE;
    public static final int TRAFFICTYPE_FM_PICTOGRAM;
    public static final int TRAFFICTYPE_FM_TEXT;
    public static final int TRAFFICTYPE_EMERGENCYEVENT;
    public static final int TRAFFICTYPE_TRAFFICMINIMAP;
    public static final int INTERRUPTTYPE_UNKNOWN;
    public static final int INTERRUPTTYPE_BEACONLV1_EMERGENCY;
    public static final int INTERRUPTTYPE_BEACONLV1_WARNING;
    public static final int INTERRUPTTYPE_BEACONLV1_TEXT;
    public static final int INTERRUPTTYPE_BEACONLV1_FIGURE;
    public static final int INTERRUPTTYPE_FM_VICSLV1_EMERGENCY;
    public static final int INTERRUPTTYPE_FM_VICSLV1_TEXT;
    public static final int INTERRUPTTYPE_FM_VICSLV1_FIGURE;
    public static final int INTERRUPTTYPE_DSRC_EMERGENCY_ID20;
    public static final int INTERRUPTTYPE_DSRC_SAFE_DRIVING_SUPPORT_ID36;
    public static final int INTERRUPTTYPE_DSRC_WARNING_INFORMATION_ID37;
    public static final int INTERRUPTTYPE_DSRC_SIMPLE_FIGURE_INFORMATION_ID23;
    public static final int INTERRUPTTYPE_DSRC_GENERAL_INFORMATION_ID38;
    public static final int INTERRUPTTYPE_DSRC_WIDE_RANGE_INFORMATION_ID22;
    public static final int INTERRUPTTYPE_DSRC_NEW_EMERGENCY_INFORMATION_ID49;
    public static final int INTERRUPTTYPE_DSRC_LOCAL_SAFE_DRIVING_SUPPORT_INFORMATION_ID52;
    public static final int INTERRUPTTYPE_DSRC_LOCAL_WARNING_INFORMATION_ID53;
    public static final int INTERRUPTTYPE_DSRC_LOCAL_GENERAL_INFORMATION_ID54;
    public static final int INTERRUPTTYPE_DSRC_ELECTRONIC_TRAFFIC_SIGN_INFORMATION_ID56;
    public static final int INTERRUPTTYPE_DSRC_OTHER_GENERAL_INFORMATION_ID59;
    public static final int INTERRUPTTYPE_DSRC_LONG_SENTENCE_READ_OUT_INFORMATION_ID39;
    public static final int INTERRUPTTYPE_TRAFFIC_MINI_MAP;
    public static final int RECEPTIONSTATUS_UNKNOWN;
    public static final int RECEPTIONSTATUS_DETECTING;
    public static final int RECEPTIONSTATUS_RECEIVED;

    default public void requestResourceInformation(int n) {
    }

    default public void requestTrafficInformationDetails(int n) {
    }

    default public void setPrefectureSetting(String string, boolean bl) {
    }

    default public void setProbeDataSetting(boolean bl) {
    }

    default public void setLanguage(String string) {
    }
}

