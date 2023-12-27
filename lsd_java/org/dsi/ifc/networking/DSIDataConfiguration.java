/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.networking.CDataProfile;

public interface DSIDataConfiguration
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AVAILABLEPROFILES;
    public static final int ATTR_ACTIVEPROFILE;
    public static final int ATTR_ROAMINGSTATE;
    public static final int ATTR_CONNECTIONMODE;
    public static final int ATTR_DATAREQUEST;
    public static final int ATTR_REQUESTSETTING;
    public static final int ATTR_PACKETCOUNTER;
    public static final int RESULT_RESULT_OK;
    public static final int RESULT_RESULT_ABORTED;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_PROFILE_NOT_EXISTS;
    public static final int RESULT_ERROR_NOT_SUPPORTED;
    public static final int RESULT_ERROR_MAX_PROFILES;
    public static final int RESULT_ERROR_DENIED;
    public static final int RESULT_ERROR_CONNECTION_REFUSED;
    public static final int RESULT_ERROR_APPLICATION_NOT_EXISTS;
    public static final int CONNECTIONMODE_AUTOMATIC;
    public static final int CONNECTIONMODE_MANUAL;
    public static final int CONNECTIONMODE_NEVER;
    public static final int REQUEST_ON;
    public static final int REQUEST_OFF;
    public static final int ROAMINGSTATE_ROAMING_ACTIVE;
    public static final int ROAMINGSTATE_ROAMING_DEACTIVE;
    public static final int DATAAUTHENTICATION_NORMAL;
    public static final int DATAAUTHENTICATION_SECURED;
    public static final int RT_SETDATAPROFILE;
    public static final int RT_AUTOMATICPROFILE;
    public static final int RT_SETROAMINGSTATE;
    public static final int RT_SETCONNECTIONMODE;
    public static final int RT_SETREQUESTSETTING;
    public static final int RT_ACCEPTDATAREQUEST;
    public static final int RT_RESETPACKETCOUNTER;
    public static final int RT_RESTOREFACTORYSETTINGS;
    public static final int RP_SETDATAPROFILERESPONSE;
    public static final int RP_AUTOMATICPROFILERESPONSE;
    public static final int RP_SETROAMINGSTATERESPONSE;
    public static final int RP_SETCONNECTIONMODERESPONSE;
    public static final int RP_SETREQUESTSETTINGRESPONSE;
    public static final int RP_RESETPACKETCOUNTERRESPONSE;
    public static final int RP_RESTOREFACTORYSETTINGSRESPONSE;
    public static final int RP_ACCEPTDATAREQUESTRESPONSE;

    default public void setDataProfile(CDataProfile cDataProfile) {
    }

    default public void automaticProfile(int n) {
    }

    default public void setRoamingState(int n) {
    }

    default public void setConnectionMode(int n) {
    }

    default public void setRequestSetting(int n, int n2) {
    }

    default public void acceptDataRequest(int n, boolean bl) {
    }

    default public void resetPacketCounter() {
    }

    default public void restoreFactorySettings() {
    }
}

