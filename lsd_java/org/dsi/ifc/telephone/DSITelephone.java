/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;

public interface DSITelephone
extends DSIBase {
    public static final String VERSION;
    public static final int RT_ACCEPTCALL;
    public static final int RT_HANGUPCALL;
    public static final int RT_SWAPCALLS;
    public static final int RT_SPLITCALL;
    public static final int RT_JOINCALLS;
    public static final int RT_DIALNUMBER;
    public static final int RT_DIALNUMBERFROMDBENTRY;
    public static final int RT_SENDDTMF;
    public static final int RT_REQUESTNETWORKREGISTRATION;
    public static final int RT_REQUESTABORTNETWORKREGISTRATION;
    public static final int RT_REQUESTNETWORKSEARCH;
    public static final int RT_REQUESTABORTNETWORKSEARCH;
    public static final int RT_REQUESTCALLFORWARD;
    public static final int RT_REQUESTCALLWAITING;
    public static final int RT_REQUESTCLIR;
    public static final int RT_REQUESTSERVICECODEABORT;
    public static final int RT_REQUESTSETAUTOMATICPINENTRYACTIVE;
    public static final int RT_REQUESTSETAUTOMATICREDIALACTIVE;
    public static final int RT_REQUESTSETCDMATHREEWAYCALLINGSETTING;
    public static final int RT_REQUESTSETAUTOMATICEMERGENCYCALLACTIVE;
    public static final int RT_REQUESTSETENHANCEDPRIVACYMODE;
    public static final int RT_REQUESTSETMAILBOXCONTENT;
    public static final int RT_REQUESTSETPRIVACYMODE;
    public static final int RT_REQUESTTELPOWER;
    public static final int RT_REQUESTUNLOCKSIM;
    public static final int RT_REQUESTCHECKSIMPINCODE;
    public static final int RT_REQUESTCHANGESIMCODE;
    public static final int RT_REQUESTSETHANDSFREEMODE;
    public static final int RT_REQUESTSETMICMUTESTATE;
    public static final int RT_REQUESTSETLANGUAGE;
    public static final int RT_REQUESTSIMPINREQUIRED;
    public static final int RT_RESTOREFACTORYSETTINGS;
    public static final int RT_REQUESTUNLOCKOTHERSIM;
    public static final int RT_REQUESTSETSIMALIASES;
    public static final int RT_REQUESTSETMICGAINLEVEL;
    public static final int RT_REQUESTDECREASEMICGAINLEVEL;
    public static final int RT_REQUESTINCREASEMICGAINLEVEL;
    public static final int RT_REQUESTSETOPTIMIZATIONMODE;
    public static final int RT_REQUESTSETNADMODE;
    public static final int RT_REQUESTREMOVEOTHERSIM;
    public static final int RT_DIALOPERATOR;
    public static final int RT_REQUESTABORTALTERNATEPHONEACTIVITY;
    public static final int RT_REQUESTTOGGLEPRIORITIZEDPHONEDEVICE;
    public static final int RT_REQUESTSETPREFIXCONTENT;
    public static final int RT_REQUESTSETPHONEREMINDERSETTING;
    public static final int RT_REQUESTSETPREFIXACTIVATED;
    public static final int RT_REQUESTSETPHONERINGTONE;
    public static final int RT_REQUESTSETFAVORITES;
    public static final int RT_REQUESTSETSIMNAME;
    public static final int RT_REQUESTSETESIMACTIVE;
    public static final int ATTR_DTMFTONEPLAYING;
    public static final int ATTR_EMERGENCYNUMBERS;
    public static final int ATTR_SIMPINREQUIRED;
    public static final int ATTR_ACTIVATIONSTATE;
    public static final int ATTR_AUTOMATICPINENTRYACTIVE;
    public static final int ATTR_AUTOMATICREDIALACTIVE;
    public static final int ATTR_BATTERYCHARGELEVEL;
    public static final int ATTR_CALLDURATIONLIST;
    public static final int ATTR_CALLLIST;
    public static final int ATTR_CDMATHREEWAYCALLINGSETTING;
    public static final int ATTR_CRADLEPLUGINSTATE;
    public static final int ATTR_DISCONNECTREASON;
    public static final int ATTR_EMERGENCYCALLACTIVE;
    public static final int ATTR_ENHANCEDPRIVACYMODE;
    public static final int ATTR_HANDSFREEMODE;
    public static final int ATTR_LOCKSTATE;
    public static final int ATTR_MAILBOXCONTENT;
    public static final int ATTR_MICMUTESTATE;
    public static final int ATTR_NADTEMPERATURE;
    public static final int ATTR_PHONEINFORMATION;
    public static final int ATTR_NETWORKPROVIDER;
    public static final int ATTR_NETWORKTYPE;
    public static final int ATTR_PRIVACYMODE;
    public static final int ATTR_REGISTERSTATE;
    public static final int ATTR_SERVICECODETYPE;
    public static final int ATTR_SERVICENUMBERS;
    public static final int ATTR_SIGNALQUALITY;
    public static final int ATTR_SUPPSERVICERESPONSE;
    public static final int ATTR_SERVICEPROVIDER;
    public static final int ATTR_SIMALIASINFORMATION;
    public static final int ATTR_MICGAINLEVEL;
    public static final int ATTR_OPTIMIZATIONMODE;
    public static final int ATTR_NADMODE;
    public static final int ATTR_OTHERSIMAVAILABLE;
    public static final int ATTR_ALTERNATEPHONEACTIVITY;
    public static final int ATTR_PREFIXCONTENT;
    public static final int ATTR_PHONEREMINDERSETTING;
    public static final int ATTR_ACTIVATIONSTATEASSOCIATED;
    public static final int ATTR_PREFIXACTIVATED;
    public static final int ATTR_WIDEBANDSPEECH;
    public static final int ATTR_PHONERINGTONE;
    public static final int ATTR_FAVORITES;
    public static final int ATTR_SAPUPGRADEACTIVE;
    public static final int ATTR_EUICCID;
    public static final int ATTR_ESIMMSISDN;
    public static final int ATTR_ESIMACTIVE;
    public static final int ATTR_ESIMB2BMODE;
    public static final int RP_RESPONSEABORTNETWORKREGISTRATION;
    public static final int RP_RESPONSEABORTNETWORKSEARCH;
    public static final int RP_RESPONSEACCEPTCALL;
    public static final int RP_RESPONSECALLFORWARD;
    public static final int RP_RESPONSECALLWAITING;
    public static final int RP_RESPONSECHANGESIMCODE;
    public static final int RP_RESPONSECLIR;
    public static final int RP_RESPONSEDIALNUMBER;
    public static final int RP_RESPONSESENDDTMF;
    public static final int RP_RESPONSESIMPINREQUIRED;
    public static final int RP_RESPONSEHANGUPCALL;
    public static final int RP_RESPONSEJOINCALLS;
    public static final int RP_RESPONSENETWORKREGISTRATION;
    public static final int RP_RESPONSENETWORKSEARCH;
    public static final int RP_RESPONSEUNLOCKSIM;
    public static final int RP_RESPONSECHECKSIMPINCODE;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS;
    public static final int RP_RESPONSESETHANDSFREEMODE;
    public static final int RP_RESPONSESETAUTOMATICPINENTRYACTIVE;
    public static final int RP_RESPONSESETAUTOMATICREDIALACTIVE;
    public static final int RP_RESPONSESERVICECODEABORT;
    public static final int RP_RESPONSESPLITCALL;
    public static final int RP_RESPONSESWAPCALLS;
    public static final int RP_RESPONSETELPOWER;
    public static final int RP_RESPONSESETCDMATHREEWAYCALLINGSETTING;
    public static final int RP_RESPONSESETAUTOMATICEMERGENCYCALLACTIVE;
    public static final int RP_RESPONSESETMAILBOXCONTENT;
    public static final int RP_RESPONSESETPRIVACYMODE;
    public static final int RP_RESPONSESETMICMUTESTATE;
    public static final int RP_RESPONSESETOPTIMIZATIONMODE;
    public static final int RP_RESPONSESETNADMODE;
    public static final int RP_RESPONSEUNLOCKOTHERSIM;
    public static final int RP_RESPONSESETSIMALIASES;
    public static final int RP_RESPONSEREMOVEOTHERSIM;
    public static final int RP_RESPONSEDIALOPERATOR;
    public static final int RP_RESPONSEABORTALTERNATEPHONEACTIVITY;
    public static final int RP_RESPONSETOGGLEPRIORITIZEDPHONEDEVICE;
    public static final int RP_RESPONSESETPREFIXCONTENT;
    public static final int RP_RESPONSESETPHONEREMINDERSETTING;
    public static final int RP_RESPONSESETPREFIXACTIVATED;
    public static final int RP_RESPONSESETPHONERINGTONE;
    public static final int RP_RESPONSESETFAVORITES;
    public static final int RP_RESPONSESETSIMNAME;
    public static final int RP_RESPONSESETESIMACTIVE;
    public static final int MEBATTERYCHARGELEVEL_UNKNOWN;
    public static final int MEBATTERYCHARGELEVEL_0;
    public static final int MEBATTERYCHARGELEVEL_0_19;
    public static final int MEBATTERYCHARGELEVEL_20_39;
    public static final int MEBATTERYCHARGELEVEL_40_59;
    public static final int MEBATTERYCHARGELEVEL_60_79;
    public static final int MEBATTERYCHARGELEVEL_80_100;
    public static final int ACTIVATIONSTATE_INIT;
    public static final int ACTIVATIONSTATE_NOT_ATTACHED;
    public static final int ACTIVATIONSTATE_TEL_ACTIVE_CALL;
    public static final int ACTIVATIONSTATE_PHONE_OFF;
    public static final int ACTIVATIONSTATE_PHONE_ON;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_READY;
    public static final int ACTIVATIONSTATE_ATTACHED_NOT_FUNC;
    public static final int ACTIVATIONSTATE_ME_RECONNECT;
    public static final int TELMODE_INTERNAL_SIM;
    public static final int TELMODE_SIMAP_BTHS;
    public static final int TELMODE_EXTERNAL_SIMAP;
    public static final int TELMODE_HFP;
    public static final int TELMODE_NO_SIM_AVAILABLE;
    public static final int TELFEAT_UNKNOWN;
    public static final int TELFEAT_INBAND;
    public static final int TELFEAT_REJECTCALL;
    public static final int TELFEAT_RESPHOLD;
    public static final int TELFEAT_THREEWAY;
    public static final int TELFEAT_ENHCALL;
    public static final int TELFEAT_ENHSTAT;
    public static final int TELFEAT_ADD_TO_CONFERENCE;
    public static final int TELFEAT_ENHCONFERENCE_TRANSFER;
    public static final int TELFEAT_REJECTMOBILE;
    public static final int TELDEVICE_HMI;
    public static final int TELDEVICE_BTHS1;
    public static final int TELDEVICE_BTHS2;
    public static final int PHONEMODULESTATE_N_A;
    public static final int PHONEMODULESTATE_OFF_TEMP;
    public static final int PHONEMODULESTATE_ON;
    public static final int PHONEMODULESTATE_OFF;
    public static final int PHONEMODULESTATE_OFF_DIAG;
    public static final int PHONEMODULESTATE_NOT_FUNCTION;
    public static final int PHONEMODULESTATE_INIT;
    public static final int PHONEMODULESTATE_SWITCHING_ON;
    public static final int PHONEMODULESTATE_SWITCHING_OFF;
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
    public static final int NUMTYPE_NOINT;
    public static final int NUMTYPE_INT;
    public static final int ACCEPTMODE_SINGLE;
    public static final int ACCEPTMODE_REPLACE;
    public static final int ACCEPTMODE_HOLD;
    public static final int ACCEPTMODE_RESPONSE_HOLD;
    public static final int HANGUPMODE_REJECT;
    public static final int HANGUPMODE_CONFERENCE;
    public static final int HANGUPMODE_ALLCALLS;
    public static final int DISCREASON_NORMAL;
    public static final int DISCREASON_NOLINE;
    public static final int DISCREASON_SYSTEM_BUSY;
    public static final int DISCREASON_NUMBER_BUSY;
    public static final int DISCREASON_NUMBER_NOT_ASSIGNED;
    public static final int DISCREASON_NUMBER_NOT_REACHABLE;
    public static final int DISCREASON_NETWORK_FAILURE;
    public static final int DISCREASON_CALL_BARRING_ACTIVE;
    public static final int DISCREASON_USER_NOT_RESPONDING;
    public static final int DISCREASON_CALL_REJECTED;
    public static final int DISCREASON_NUMBER_CHANGED;
    public static final int DISCREASON_NUMBER_INVALID_INCOMPLETE;
    public static final int DISCREASON_SERVICE_NOT_AVAILABLE;
    public static final int DISCREASON_NO_INFO_AVAILABLE;
    public static final int DISCREASON_NUMBER_TEMP_FORBIDDEN;
    public static final int HANDSFREEMODE_HANDSFREE;
    public static final int HANDSFREEMODE_PRIVATE_BTHS1;
    public static final int HANDSFREEMODE_PRIVATE_BTHS2;
    public static final int HANDSFREEMODE_PRIVATE_HS;
    public static final int HANDSFREEMODE_PRIVATE_HFP;
    public static final int MICMUTESTATE_ON;
    public static final int MICMUTESTATE_OFF;
    public static final int LOCKCODE_PIN;
    public static final int LOCKCODE_PIN2;
    public static final int LOCKCODE_PUK;
    public static final int LOCKCODE_PUK2;
    public static final int LOCKCODE_SECCO;
    public static final int COMMCLASS_VOICE;
    public static final int COMMCLASS_DATA;
    public static final int COMMCLASS_FAX;
    public static final int COMMCLASS_SMS;
    public static final int COMMCLASS_DCS;
    public static final int COMMCLASS_DCA;
    public static final int COMMCLASS_DDPA;
    public static final int COMMCLASS_DDPADA;
    public static final int COMMCLASS_UNCONDITIONAL;
    public static final int CWMODE_DISABLE;
    public static final int CWMODE_ENABLE;
    public static final int CWMODE_QUERY;
    public static final int CLIRSTATE_PRESENTATION;
    public static final int CLIRSTATE_INVOCATION;
    public static final int CLIRSTATE_SUPPRESSION;
    public static final int CLIRSTATE_QUERY;
    public static final int CLIRNWSTATE_OFF;
    public static final int CLIRNWSTATE_ON;
    public static final int CLIRNWSTATE_UNKNOWN;
    public static final int CLIRNWSTATE_RESTRICTED;
    public static final int CLIRNWSTATE_ALLOWED;
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
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_CARPLAY_ACTIVE;
    public static final int RESULT_ERROR_VOICE_NOT_POSSIBLE_ANDROID_AUTO_ACTIVE;
    public static final int CALLSTATE_DIALING;
    public static final int CALLSTATE_ALERTING;
    public static final int CALLSTATE_RINGING;
    public static final int CALLSTATE_ACTIVE;
    public static final int CALLSTATE_DISCONNECTING;
    public static final int CALLSTATE_HOLD;
    public static final int CALLSTATE_AUTOREDIAL;
    public static final int CALLSTATE_RESP_HOLD;
    public static final int MPTY_SINGLE;
    public static final int MPTY_CONFERENCE;
    public static final int CALLCARRIER_NONE;
    public static final int CALLCARRIER_PRIO;
    public static final int CALLCARRIER_ASSOCIATED;
    public static final int CALLTYPE_VOICE;
    public static final int CALLTYPE_DATA;
    public static final int CALLTYPE_FAX;
    public static final int CALLTYPE_EMERGENCY;
    public static final int CALLTYPE_CONFERENCE;
    public static final int CALLTYPE_INFO;
    public static final int CALLTYPE_BREAKDOWN;
    public static final int CALLTYPE_OPERATOR;
    public static final int CALLTYPE_MAILBOX;
    public static final int CALLTYPE_NO_NUMBER;
    public static final int PROVIDERSTATE_UNKNOWN;
    public static final int PROVIDERSTATE_SELECTED;
    public static final int PROVIDERSTATE_FORBIDDEN;
    public static final int PROVIDERSTATE_AVAILABLE;
    public static final int CWSTATE_NOT_ACTIVE;
    public static final int CWSTATE_ACTIVE;
    public static final int CFMODE_DISABLE;
    public static final int CFMODE_ENABLE;
    public static final int CFMODE_QUERY;
    public static final int CFMODE_REGISTRATION;
    public static final int CFMODE_ERASURE;
    public static final int CFMODE_UNKNOWN;
    public static final int CFCONDITION_UNCONDITIONAL;
    public static final int CFCONDITION_MOBILE_BUSY;
    public static final int CFCONDITION_NO_REPLY;
    public static final int CFCONDITION_NOT_REACHABLE;
    public static final int CFCONDITION_ALL_CFWD;
    public static final int CFCONDITION_ALL_CCFWD;
    public static final int CFSTATE_NOT_ACTIVE;
    public static final int CFSTATE_ACTIVE;
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
    public static final int DIALNUMTYPE_NORMALCALL;
    public static final int DIALNUMTYPE_USSD;
    public static final int DIALNUMTYPE_SSD;
    public static final int SERVICECODEREQTYPE_UNKNOWN;
    public static final int SERVICECODEREQTYPE_ACTIVATION;
    public static final int SERVICECODEREQTYPE_DEACTIVATION;
    public static final int SERVICECODEREQTYPE_INTERROGATION;
    public static final int SERVICECODEREQTYPE_REGISTRATION;
    public static final int SERVICECODEREQTYPE_ERASURE;
    public static final int CRADLEPLUGINSTATE_NOTBUILTIN;
    public static final int CRADLEPLUGINSTATE_UNPLUGGED;
    public static final int CRADLEPLUGINSTATE_PLUGGED;
    public static final int CALLLISTNAMENUMBERSTATUS_VALID;
    public static final int CALLLISTNAMENUMBERSTATUS_TEMPINVALID;
    public static final int MBIDENTIFIERS_VOICE;
    public static final int MBIDENTIFIERS_FAX;
    public static final int MBIDENTIFIERS_EMAIL;
    public static final int MBIDENTIFIERS_OTHERS;
    public static final int OPTIMIZATIONMODE_INVALID;
    public static final int OPTIMIZATIONMODE_AUTO;
    public static final int OPTIMIZATIONMODE_TELEPHONE;
    public static final int OPTIMIZATIONMODE_DATA;
    public static final int NADMODE_INVALID;
    public static final int NADMODE_VOICE_DATA;
    public static final int NADMODE_DATA;
    public static final int NADMODE_VOICE;

    default public void acceptCall(int n) {
    }

    default public void hangupCall(int n) {
    }

    default public void swapCalls() {
    }

    default public void splitCall(short s) {
    }

    default public void joinCalls() {
    }

    default public void dialNumber(String string) {
    }

    default public void dialOperator(int n, String string) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void sendDTMF(String string) {
    }

    default public void requestNetworkRegistration(String string, int n) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestNetworkSearch() {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestCallForward(CFRequestData[] cFRequestDataArray) {
    }

    default public void requestCallWaiting(int n) {
    }

    default public void requestCLIR(int n) {
    }

    default public void requestServiceCodeAbort() {
    }

    default public void requestSetAutomaticPinEntryActive(boolean bl) {
    }

    default public void requestSetAutomaticRedialActive(boolean bl) {
    }

    default public void requestSetCDMAThreeWayCallingSetting(boolean bl) {
    }

    default public void requestSetAutomaticEmergencyCallActive(boolean bl) {
    }

    default public void requestSetEnhancedPrivacyMode(boolean bl) {
    }

    default public void requestSetMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray) {
    }

    default public void requestSetPrivacyMode(boolean bl) {
    }

    default public void requestTelPower(int n) {
    }

    default public void requestUnlockSIM(int n, String string, String string2) {
    }

    default public void requestCheckSIMPINCode(String string) {
    }

    default public void requestChangeSIMCode(int n, String string, String string2) {
    }

    default public void requestSetHandsFreeMode(int n) {
    }

    default public void requestSetMICMuteState(int n) {
    }

    default public void requestSetLanguage(String string) {
    }

    default public void requestSIMPINRequired(String string, boolean bl) {
    }

    default public void restoreFactorySettings() {
    }

    default public void requestSetMicGainLevel(int n) {
    }

    default public void requestDecreaseMicGainLevel(short s) {
    }

    default public void requestIncreaseMicGainLevel(short s) {
    }

    default public void requestSetOptimizationMode(int n) {
    }

    default public void requestUnlockOtherSIM(int n, String string) {
    }

    default public void requestSetSIMAliases(String string, String string2) {
    }

    default public void requestSetNADMode(int n) {
    }

    default public void requestRemoveOtherSIM() {
    }

    default public void requestAbortAlternatePhoneActivity() {
    }

    default public void requestTogglePrioritizedPhoneDevice() {
    }

    default public void requestSetPhoneReminderSetting(boolean bl) {
    }

    default public void requestSetPrefixActivated(boolean bl) {
    }

    default public void requestSetPrefixContent(String string) {
    }

    default public void requestSetPhoneRingtone(int n, String string) {
    }

    default public void requestSetFavorites(Favorite[] favoriteArray) {
    }

    default public void requestSetSIMName(String string) {
    }

    default public void requestSetESIMActive(boolean bl) {
    }
}

