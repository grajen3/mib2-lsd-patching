/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSINAD
extends DSIBase {
    public static final String VERSION;
    public static final int RT_REQUESTNETWORKREGISTRATION;
    public static final int RT_REQUESTABORTNETWORKREGISTRATION;
    public static final int RT_REQUESTNETWORKSEARCH;
    public static final int RT_REQUESTABORTNETWORKSEARCH;
    public static final int RT_REQUESTSETAUTOMATICPINENTRYACTIVE;
    public static final int RT_REQUESTTELPOWER;
    public static final int RT_REQUESTUNLOCKSIM;
    public static final int RT_REQUESTCHECKSIMPINCODE;
    public static final int RT_REQUESTCHANGESIMCODE;
    public static final int RT_REQUESTSIMPINREQUIRED;
    public static final int RT_RESTOREFACTORYSETTINGS;
    public static final int ATTR_SIMPINREQUIRED;
    public static final int ATTR_ACTIVATIONSTATE;
    public static final int ATTR_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_LOCKSTATE;
    public static final int ATTR_NADTEMPERATURE;
    public static final int ATTR_PHONEINFORMATION;
    public static final int ATTR_NETWORKPROVIDER;
    public static final int ATTR_NETWORKTYPE;
    public static final int ATTR_REGISTERSTATE;
    public static final int ATTR_SIGNALQUALITY;
    public static final int ATTR_SERVICEPROVIDER;
    public static final int RP_RESPONSEABORTNETWORKREGISTRATION;
    public static final int RP_RESPONSEABORTNETWORKSEARCH;
    public static final int RP_RESPONSECHANGESIMCODE;
    public static final int RP_RESPONSESIMPINREQUIRED;
    public static final int RP_RESPONSENETWORKREGISTRATION;
    public static final int RP_RESPONSENETWORKSEARCH;
    public static final int RP_RESPONSEUNLOCKSIM;
    public static final int RP_RESPONSECHECKSIMPINCODE;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS;
    public static final int RP_RESPONSETELPOWER;
    public static final int RP_RESPONSESETAUTOMATICPINENTRYACTIVE;
    public static final int ACTIVATIONSTATE_INIT;
    public static final int ACTIVATIONSTATE_NOT_ATTACHED;
    public static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL;
    public static final int ACTIVATIONSTATE_PHONE_OFF;
    public static final int ACTIVATIONSTATE_PHONE_ON;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_READY;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC;
    public static final int ACTIVATIONSTATE_ME_RECONNECT;
    public static final int PHONEMODULESTATE_N_A;
    public static final int PHONEMODULESTATE_OFF_TEMP;
    public static final int PHONEMODULESTATE_ON;
    public static final int PHONEMODULESTATE_OFF;
    public static final int PHONEMODULESTATE_OFF_DIAG;
    public static final int PHONEMODULESTATE_NOT_FUNCTION;
    public static final int PHONEMODULESTATE_INIT;
    public static final int NADTEMPLEVEL_NORMAL;
    public static final int NADTEMPLEVEL_UNDER;
    public static final int NADTEMPLEVEL_WARNING;
    public static final int NADTEMPLEVEL_HIGH;
    public static final int NADTEMPLEVEL_UNKNOWN;
    public static final int POWER_OFF_PERS;
    public static final int POWER_ON_PERS;
    public static final int LOCKSTATE_UNKNOWN;
    public static final int LOCKSTATE_UNLOCK_INPR;
    public static final int LOCKSTATE_NO_LOCK;
    public static final int LOCKSTATE_PIN_REQUIRED;
    public static final int LOCKSTATE_PIN2_REQUIRED;
    public static final int LOCKSTATE_PUK_REQUIRED;
    public static final int LOCKSTATE_PUK2_REQUIRED;
    public static final int LOCKSTATE_PUK_BLOCKED;
    public static final int LOCKSTATE_PUK2_BLOCKED;
    public static final int LOCKSTATE_SECCO_REQUIRED;
    public static final int LOCKSTATE_SECCO_BLOCKED;
    public static final int LOCKSTATE_SIMNOTFUNC;
    public static final int REGISTERSTATE_UNKNOWN;
    public static final int REGISTERSTATE_REGISTERED;
    public static final int REGISTERSTATE_ROAMING;
    public static final int REGISTERSTATE_SEARCHING;
    public static final int REGISTERSTATE_NOT_SEARCHING;
    public static final int REGISTERSTATE_DENIED;
    public static final int REGMODE_MANUAL;
    public static final int REGMODE_AUTOMATIC;
    public static final int NETTYPE_UNKNOWN;
    public static final int NETTYPE_GSM;
    public static final int NETTYPE_CDMA;
    public static final int NETTYPE_PDC;
    public static final int NETTYPE_UMTS;
    public static final int NETTYPE_LTE;
    public static final int LOCKCODE_PIN;
    public static final int LOCKCODE_PIN2;
    public static final int LOCKCODE_PUK;
    public static final int LOCKCODE_PUK2;
    public static final int LOCKCODE_SECCO;
    public static final int SERVICESTATE_IDLE;
    public static final int SERVICESTATE_SESSION;
    public static final int SERVICESTATE_TERMINATED;
    public static final int SERVICESTATE_RESPONDED;
    public static final int SERVICESTATE_NOSUP;
    public static final int SERVICESTATE_ERROR;
    public static final int RESULT_OK;
    public static final int RESULT_ABORTED;
    public static final int RESULT_ERROR_NOSUP_PHONE;
    public static final int RESULT_ERROR_NOSUP_NW;
    public static final int RESULT_ERROR_UNSPECIFIED;
    public static final int RESULT_ERROR_CODE_WRONG;
    public static final int RESULT_ERROR_SERV_BUSY;
    public static final int RESULT_ERROR_NOT_ALLOWED;
    public static final int RESULT_ERROR_SIM_FAILURE;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT;
    public static final int RESULT_ERROR_STRING_TOO_LONG;
    public static final int RESULT_ERROR_NO_NW_REPLY;
    public static final int RESULT_ERROR_NO_NW_ACCESS;
    public static final int RESULT_ERROR_INVALID_CALL_ID;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_CARPLAY_ACTIVE;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_ANDROID_AUTO_ACTIVE;
    public static final int PROVIDERSTATE_UNKNOWN;
    public static final int PROVIDERSTATE_SELECTED;
    public static final int PROVIDERSTATE_FORBIDDEN;
    public static final int PROVIDERSTATE_AVAILABLE;
    public static final int FACMODE_LOCK;
    public static final int FACMODE_UNLOCK;
    public static final int FACMODE_QUERY;
    public static final int FACILITY_UNKNOWN;
    public static final int FACILITY_SC;
    public static final int FACSTATE_NOT_ACTIVE;
    public static final int FACSTATE_ACTIVE;
    public static final int NETIDAVAIL_TEMP_NOT_AVAIL;
    public static final int NETIDAVAIL_NOT_AVAIL;
    public static final int NETIDAVAIL_AVAIL;
    public static final int SERVICECODEREQTYPE_UNKNOWN;
    public static final int SERVICECODEREQTYPE_ACTIVATION;
    public static final int SERVICECODEREQTYPE_DEACTIVATION;
    public static final int SERVICECODEREQTYPE_INTERROGATION;
    public static final int SERVICECODEREQTYPE_REGISTRATION;
    public static final int SERVICECODEREQTYPE_ERASURE;

    default public void requestNetworkRegistration(String string, int n) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestNetworkSearch() {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestSetAutomaticPinEntryActive(boolean bl) {
    }

    default public void requestTelPower(int n) {
    }

    default public void requestUnlockSIM(int n, String string, String string2) {
    }

    default public void requestCheckSIMPINCode(String string) {
    }

    default public void requestChangeSIMCode(int n, String string, String string2) {
    }

    default public void requestSIMPINRequired(String string, boolean bl) {
    }

    default public void restoreFactorySettings() {
    }
}

