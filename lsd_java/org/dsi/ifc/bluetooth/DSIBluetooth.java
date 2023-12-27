/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIBluetooth
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ACCESSIBLEMODE;
    public static final int ATTR_BTSTATE;
    public static final int ATTR_DISCOVEREDDEVICES;
    public static final int ATTR_TRUSTEDDEVICES;
    public static final int ATTR_PASSKEYSTATE;
    public static final int ATTR_SERVICEREQUESTSTATE;
    public static final int ATTR_USERFRIENDLYNAME;
    public static final int ATTR_RECONNECTINDICATOR;
    public static final int ATTR_INCOMINGSERVICEREQUEST;
    public static final int ATTR_SUPPORTEDBTPROFILES;
    public static final int ATTR_MASTERROLEREQUESTERROR;
    public static final int ATTR_HUCANDBTHSSTATE;
    public static final int ATTR_A2DPUSERSETTING;
    public static final int ATTR_PRIORIZEDDEVICERECONNECT;
    public static final int RT_SETACCESSIBLEMODE;
    public static final int RT_REQUESTCONNECTSERVICE;
    public static final int RT_REQUESTCONNECTSERVICETOINSTANCE;
    public static final int RT_ABORTCONNECTSERVICE;
    public static final int RT_REQUESTDISCONNECTSERVICE;
    public static final int RT_REQUESTGETSERVICES;
    public static final int RT_REQUESTINQUIRY;
    public static final int RT_ABORTINQUIRY;
    public static final int RT_REQUESTRECONNECTSUSPEND;
    public static final int RT_REQUESTPASSKEYRESPONSE;
    public static final int RT_REQUESTREMOVEAUTHENTICATION;
    public static final int RT_SETUSERFRIENDLYNAME;
    public static final int RT_REQUESTSWITCHBTSTATE;
    public static final int RT_REQUESTRESTOREFACTORYSETTINGS;
    public static final int RT_REQUESTACCEPTINCOMINGSERVICEREQUEST;
    public static final int RT_REQUESTSETA2DPUSERSETTING;
    public static final int RT_REQUESTSETPRIORIZEDDEVICERECONNECT;
    public static final int RP_RESPONSECONNECTSERVICE;
    public static final int RP_RESPONSECONNECTSERVICETOINSTANCE;
    public static final int RP_RESPONSEABORTCONNECTSERVICE;
    public static final int RP_RESPONSEDISCONNECTSERVICE;
    public static final int RP_RESPONSEGETSERVICES;
    public static final int RP_RESPONSEINQUIRY;
    public static final int RP_RESPONSEABORTINQUIRY;
    public static final int RP_RESPONSERECONNECTSUSPEND;
    public static final int RP_RESPONSEPASSKEYRESPONSE;
    public static final int RP_RESPONSEREMOVEAUTHENTICATION;
    public static final int RP_RESPONSESWITCHBTSTATE;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS;
    public static final int RP_RESPONSEACCEPTINCOMINGSERVICEREQUEST;
    public static final int RP_RESPONSESETA2DPUSERSETTING;
    public static final int RP_RESPONSESETPRIORIZEDDEVICERECONNECT;
    public static final int RP_RESPONSESETACCESSIBLEMODE;
    public static final int IN_REMOVEAUTHENTICATIONNOSUPPORT;
    public static final int IN_DEVICEDISONNECTIONINFO;
    public static final int IN_SERVICEREJECTNOSUPPORT;
    public static final int AM_UNSPECIFIED;
    public static final int AM_NOT_ACCESSIBLE;
    public static final int AM_DISCOVERABLE_ONLY;
    public static final int AM_CONNECTABLE_ONLY;
    public static final int AM_GENERAL_ACCESSIBLE;
    public static final int AM_AUTO_DISCOVERABLE_FULL_ACCESSIBLE;
    public static final int AM_LIMITED_DISCOVERABLE;
    public static final int AUTHENTICATION_REJECT;
    public static final int AUTHENTICATION_ACCEPT;
    public static final int BTSTATE_ON;
    public static final int BTSTATE_OFF;
    public static final int BTSTATE_NOT_FUNCTIONAL;
    public static final int BTSTATE_SWITCHING_ON;
    public static final int BTSTATE_SWITCHING_OFF;
    public static final int BTSTATE_DIAGNOSE_NOT_ON_ALLOWED;
    public static final int CONNECTION_REJECT;
    public static final int CONNECTION_ACCEPT;
    public static final int DEVICEROLE_NONE;
    public static final int DEVICEROLE_PRIO;
    public static final int DEVICEROLE_ASSOCIATED;
    public static final int DEVICEROLE_PIM;
    public static final int RESULT_OK;
    public static final int RESULT_INTERMEDIATE;
    public static final int RESULT_ABORTED;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_PAIRING_GENERAL;
    public static final int RESULT_ERROR_PAIRING_TIMEOUT;
    public static final int RESULT_ERROR_PAIRING_WRONG_PASSKEY;
    public static final int RESULT_ERROR_SERVICE_NOT_SUPPORTED;
    public static final int RESULT_ERROR_PAGE_TIMEOUT;
    public static final int RESULT_ERROR_INSTANCE_NOT_EXIST;
    public static final int RESULT_ERROR_INSTANCE_ALREADY_CONNECTED;
    public static final int RESULT_ERROR_DEVICE_NOT_TRUSTED;
    public static final int RESULT_ERROR_HW_FAILURE;
    public static final int RESULT_ERROR_CONNECTION_LIMIT_EXCEEDED;
    public static final int RESULT_ERROR_CONNECTION_REJECTED_SECURITY_REASONS;
    public static final int RESULT_ERROR_REMOTE_USER_TERMINATED_CONNECTION_LOW_RESOURCES;
    public static final int RESULT_ERROR_REMOTE_USER_TERMINATED_CONNECTION_POWER_OFF;
    public static final int RESULT_ERROR_NOT_APPLICABLE;
    public static final int RESULT_ERROR_SERVICE_REJECTED;
    public static final int RESULT_ERROR_SERVICE_CONNECT_TIMEOUT;
    public static final int RESULT_ERROR_SIM_INSERTED;
    public static final int RESULT_ERROR_2ND_PHONE_NOT_POSSIBLE_WITH_SAP;
    public static final int RESULT_ERROR_CARPLAY_ACTIVE;
    public static final int RESULT_ERROR_ANDROID_AUTO_ACTIVE;
    public static final int HUCANDBTHSSTATE_HBSTATE_0_HUC_0_BTHS;
    public static final int HUCANDBTHSSTATE_HBSTATE_1_HUC_0_BTHS;
    public static final int HUCANDBTHSSTATE_HBSTATE_1_HUC_1_BTHS;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_0_BTHS;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_1_BTHS;
    public static final int HUCANDBTHSSTATE_HBSTATE_2_HUC_2_BTHS;
    public static final int IM_UNSPECIFIED;
    public static final int IM_DEVICE_DISCOVERY_ONLY;
    public static final int IM_INCL_NAME_DISCOVERY;
    public static final int IM_INCL_SERVICE_DISCOVERY;
    public static final int IM_INCL_NAME_AND_SERVICE_DISCOVERY;
    public static final int INSTANCENUMBER_NOT_AVAILABLE;
    public static final int INSTANCENUMBER_1;
    public static final int INSTANCENUMBER_2;
    public static final int INSTANCENUMBER_3;
    public static final int LINKMODE_UNSPECIFIED;
    public static final int LINKMODE_ACTIVE;
    public static final int LINKMODE_HOLD;
    public static final int LINKMODE_SNIFF;
    public static final int LINKMODE_PARK;
    public static final int LS_UNDEFINED;
    public static final int LS_WEAK_KEY;
    public static final int LS_STRONG_KEY;
    public static final int LS_SIMPLE_PAIRING_UNAUTHENTICATED;
    public static final int LS_SIMPLE_PAIRING_AUTHENTICATED;
    public static final int PS_NO_PASSKEY_REQUIRED;
    public static final int PS_WAITING_FOR_PASSKEY;
    public static final int PS_DISPLAY_PASSKEY;
    public static final int PS_PASSKEY_ERROR;
    public static final int PS_PASSKEY_ERROR_WRONG_PIN;
    public static final int PS_PASSKEY_ERROR_TIMEOUT;
    public static final int PS_SSP_SHOW_ONLY;
    public static final int PS_SSP_SHOW_AND_CONFIRM;
    public static final int PS_SSP_JUST_WORKS;
    public static final int SERVICEREQUESTSTATE_NOT_ACTIVE;
    public static final int SERVICEREQUESTSTATE_ACTIVE;
    public static final int SERVICETYPE_NONE;
    public static final int SERVICETYPE_UNSPECIFIED;
    public static final int SERVICETYPE_TELEPHONY_HFP;
    public static final int SERVICETYPE_TELEPHONY_SIMAP;
    public static final int SERVICETYPE_TELEPHONY_HEADSET;
    public static final int SERVICETYPE_TELEPHONY_HANDSET;
    public static final int SERVICETYPE_ADRDL;
    public static final int SERVICETYPE_OBJECTPUSH_CLIENT;
    public static final int SERVICETYPE_SYNCML;
    public static final int SERVICETYPE_DUN_CLIENT;
    public static final int SERVICETYPE_DUN_SERVER;
    public static final int SERVICETYPE_HID;
    public static final int SERVICETYPE_BIP;
    public static final int SERVICETYPE_FTP;
    public static final int SERVICETYPE_OBJECTPUSH_SERVER;
    public static final int SERVICETYPE_SPP;
    public static final int SERVICETYPE_A2DP_AVRCP_SINK;
    public static final int SERVICETYPE_A2DP_AVRCP_SOURCE;
    public static final int SERVICETYPE_TELEPHONY_HFP_HF;
    public static final int SERVICETYPE_PAN_NAP;
    public static final int SERVICETYPE_PAN_GN;
    public static final int SERVICETYPE_PAN_USER;
    public static final int SERVICETYPE_MAP;
    public static final int SERVICETYPE_MAP2;
    public static final int SERVICETYPE_ALL;
    public static final int DEVICESECURITY_PAIRED;
    public static final int DEVICESECURITY_TRUSTED;
    public static final int DEVICESECURITY_ENCRYPTED;
    public static final int DEVICESECURITY_STRONG_PASSKEY;
    public static final int DISCONNECTINFORMATION_OTHER_REASON;
    public static final int DISCONNECTINFORMATION_LINK_LOSS;
    public static final int DISCONNECTINFORMATION_USER_INIT_VIA_EXT_DEVICE;

    default public void abortConnectService(String string) {
    }

    default public void abortInquiry() {
    }

    default public void requestAcceptIncomingServiceRequest(String string, int n, boolean bl) {
    }

    default public void requestConnectService(String string, int n, int n2) {
    }

    default public void requestConnectServiceToInstance(String string, int n, int n2) {
    }

    default public void requestDisconnectService(String string, int n) {
    }

    default public void requestGetServices(String string) {
    }

    default public void requestInquiry(int n, int n2, int n3) {
    }

    default public void requestPasskeyResponse(String string, String string2, int n) {
    }

    default public void requestReconnectSuspend(boolean bl) {
    }

    default public void requestRemoveAuthentication(String string) {
    }

    default public void requestRestoreFactorySettings() {
    }

    default public void requestSetA2DPUserSetting(boolean bl) {
    }

    default public void requestSwitchBTState(int n) {
    }

    default public void setAccessibleMode(int n) {
    }

    default public void setUserFriendlyName(String string) {
    }

    default public void requestSetPriorizedDeviceReconnect(boolean bl, String string) {
    }
}

