/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.networking.Profile;

public interface DSIWLAN
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ROLE;
    public static final int ATTR_RFACTIVE;
    public static final int ATTR_NODELIST;
    public static final int ATTR_WLANENABLED;
    public static final int ATTR_STARTUPSTATE;
    public static final int ATTR_DISCOVEREDNETWORK;
    public static final int ATTR_CONNECTEDNETWORK;
    public static final int ATTR_TRUSTEDNETWORKS;
    public static final int ATTR_PROFILE;
    public static final int ATTR_WPSRUNNING;
    public static final int ATTR_WPSSTOPPEDANDCONNECTING;
    public static final int CRYPTOMODELS_CM_PLAINTEXT;
    public static final int CRYPTOMODELS_CM_WEP64;
    public static final int CRYPTOMODELS_CM_WEP128;
    public static final int CRYPTOMODELS_CM_TKIP;
    public static final int CRYPTOMODELS_CM_AES_CCMP;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP;
    public static final int CRYPTOMODELS_CM_WPA2_AES_CCMP;
    public static final int CRYPTOMODELS_CM_WPA_TKIP_CCMP;
    public static final int CRYPTOMODELS_CM_WPA2_TKIP_CCMP;
    public static final int CRYPTOMODELS_CM_WAPI;
    public static final int AUTHENTICATIONMODELS_AM_NONE;
    public static final int AUTHENTICATIONMODELS_AM_PSK;
    public static final int AUTHENTICATIONMODELS_AM_EAP_802_1X;
    public static final int ROLES_ROLE_AP;
    public static final int ROLES_ROLE_CLIENT;
    public static final int ROLES_ROLE_ADHOC;
    public static final int ROLES_ROLE_AP_CLIENT_COMBINED;
    public static final int RESULT_RESULT_OK;
    public static final int RESULT_ERROR_NOT_SUPPORTED;
    public static final int RESULT_ERROR_INVALID_PARAMETER;
    public static final int RESULT_ERROR_REQUEST_TOO_EARLY;
    public static final int RESULT_ERROR_INVALID_PASSWORD;
    public static final int RESULT_RESULT_ABORTED;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_RESULT_PASSWORD_REQUIRED;
    public static final int RESULT_RESULT_TIMEOUT;
    public static final int RESULT_ERROR_SECURITYISSUE;
    public static final int ERRORS_OK;
    public static final int ERRORS_ERROR_NOT_SUPPORTED;
    public static final int ERRORS_ERROR_INVALID_PARAMETER;
    public static final int ERRORS_ERROR_REQUEST_TOO_EARLY;
    public static final int RFSTATES_RF_OFF;
    public static final int RFSTATES_RF_ON;
    public static final int RFSTATES_RF_NOT_OPERATIONAL;
    public static final int RFSTATES_RF_NOT_OPERATIONAL_TEMPERATURE;
    public static final int RFSTATES_RF_NOT_ALLOWED;
    public static final int STARTUPSTATES_SUS_BOOTING;
    public static final int STARTUPSTATES_SUS_READY;
    public static final int STARTUPSTATES_SUS_FAILED;
    public static final int WPSMODE_PUSHBUTTON;
    public static final int WPSMODE_PIN;
    public static final int RT_FACTORYRESET;
    public static final int RT_SETRFACTIVE;
    public static final int RT_SETPROFILE;
    public static final int RT_REQUESTNETWORKSEARCH;
    public static final int RT_REQUESTABORTSEARCH;
    public static final int RT_REQUESTCONNECTNETWORK;
    public static final int RT_REQUESTDISCONNECTNETWORK;
    public static final int RT_REQUESTDELETETRUSTEDNETWORK;
    public static final int RT_SETROLE;
    public static final int RT_REQUESTACTIVATEWPS;
    public static final int RT_REQUESTCANCELWPS;
    public static final int RP_RESPONSENETWORKSEARCH;
    public static final int RP_RESPONSEABORTSEARCH;
    public static final int RP_RESPONSECONNECTNETWORK;
    public static final int RP_RESPONSEDISCONNECTNETWORK;
    public static final int RP_RESPONSEDELETETRUSTEDNETWORK;
    public static final int RP_RESPONSEFACTORYRESET;
    public static final int RP_RESPONSESETROLE;
    public static final int RP_RESPONSESETRFACTIVE;
    public static final int RP_RESPONSESETPROFILE;
    public static final int RP_RESPONSEACTIVATEWPS;

    default public void factoryReset() {
    }

    default public void setRole(int n) {
    }

    default public void setRFActive(boolean bl) {
    }

    default public void setProfile(Profile profile) {
    }

    default public void requestNetworkSearch(int n, int n2) {
    }

    default public void requestAbortSearch() {
    }

    default public void requestConnectNetwork(String string, String string2, String string3, int n) {
    }

    default public void requestDisconnectNetwork(String string, String string2) {
    }

    default public void requestDeleteTrustedNetwork(String string, String string2) {
    }

    default public void requestActivateWps(int n, int n2, int n3) {
    }

    default public void requestCancelWPS() {
    }
}

