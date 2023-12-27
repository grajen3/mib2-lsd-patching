/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistration
extends DSIBase {
    public static final String VERSION;
    public static final int PROFILELRU_OK;
    public static final int PROFILELRU_IOERROR;
    public static final int PROFILELRU_INVALIDUSER;
    public static final int PROFILELRU_INVALIDDOMAIN;
    public static final int UPDATECONTROL_ADD;
    public static final int UPDATECONTROL_REMOVE;
    public static final int UPDATECONTROL_CHANGED;
    public static final int UPDATECONTROL_ERROR;
    public static final int UPDATECONTROL_EMPTY;
    public static final int AUTOLOGIN_OK;
    public static final int AUTOLOGIN_GONE;
    public static final int AUTOLOGIN_ERROR;
    public static final int DEVICECONNECTIONSTATE_DISCONNECTED;
    public static final int DEVICECONNECTIONSTATE_INRANGE;
    public static final int DEVICECONNECTIONSTATE_CONNECTED;
    public static final int DEVICECONNECTIONSTATE_REMOVED;
    public static final int LOGINFLAG_SHOWUSER;
    public static final int LOGINFLAG_STOREPASSWORD;
    public static final int LOGINFLAG_SHOWUSERANDSTOREPASSWORD;
    public static final int LOGINFLAG_LOGIN;
    public static final int LOGINFLAG_MMICONNECTAPP;
    public static final int LOGINFLAG_AUTOCONNECT;
    public static final int LOGINFLAG_LOGOUT;
    public static final int LOGINFLAG_REMOVE;
    public static final int PTYPE_INTERN;
    public static final int PTYPE_BLUETOOTH;
    public static final int PTYPE_IMSI;
    public static final int PTYPE_ICC;
    public static final int PTYPE_WLAN;
    public static final int PTYPE_CARPROFILE;
    public static final int GROUPID_BACKEND;
    public static final int GROUPID_LOCAL;
    public static final int GROUPID_ENABLER;
    public static final int APPSTATE_DISABLED;
    public static final int APPSTATE_ENABLED;
    public static final int APPSTATE_ENABLED_ROAMING;
    public static final int APPSTATE_ENABLED_POPUP;
    public static final int LICENSE_STATE_ACTIVATED;
    public static final int LICENSE_STATE_NOT_ACTIVATED;
    public static final int LICENSE_STATE_NOT_LICENSED;
    public static final int LICENSE_STATE_EXPIRED;
    public static final int LICENSE_STATE_OFFERED;
    public static final int LICENSE_STATE_LICENSE_ERROR;
    public static final int LICENSE_STATE_LICENSE_REVOKED;
    public static final int LICENSE_STATE_LICENSE_FREE;
    public static final int LICENSETYPE_REGULAR;
    public static final int LICENSETYPE_TRIAL;
    public static final int LICENSETYPE_DEALER;
    public static final int LICENCERESPONSE_ACTIVATED_OK;
    public static final int LICENCERESPONSE_NETWORK_ERROR;
    public static final int LICENCERESPONSE_INVALID;
    public static final int LICENCERESPONSE_ERROR;
    public static final int GENERICVERFICATION_OK;
    public static final int GENERICVERFICATION_WRONG;
    public static final int GENERICVERFICATION_CONNECTIVITY;
    public static final int GENERICVERFICATION_ERROR;
    public static final int GENERICVERFICATION_NOTAVAILABLE;
    public static final int GENERICVERFICATION_AUTHSCHEME_NOT_SUPPORTED;
    public static final int GENERICVERFICATION_TIMEOUT;
    public static final int GENERICVERFICATION_CANCELED;
    public static final int REMOVEUSERRESULT_OK;
    public static final int REMOVEUSERRESULT_GENERICERROR;
    public static final int OWNERVERIFICATION_OK;
    public static final int OWNERVERIFICATION_WRONG;
    public static final int OWNERVERIFICATION_CONNECTIVITY;
    public static final int OWNERVERIFICATION_ERROR;
    public static final int OWNERVERIFICATION_NOTAVAILABLE;
    public static final int OWNERVERIFICATION_TIMEOUT;
    public static final int OWNERVERIFICATION_CANCELED;
    public static final int FILEDOWNLOAD_OK;
    public static final int FILEDOWNLOAD_NOSERVICE;
    public static final int FILEDOWNLOAD_SERVER;
    public static final int FILEDOWNLOAD_NOTAFILE;
    public static final int FILEDOWNLOAD_NOTWRITEABLE;
    public static final int FILEDOWNLOAD_TIMEOUT;
    public static final int FILEDOWNLOAD_IOERROR;
    public static final int FILEDOWNLOAD_URLCORRUPT;
    public static final int FILEDOWNLOAD_CANCELED;
    public static final int FILEDOWNLOAD_CREATEFAILED;
    public static final int FILEDOWNLOAD_GENERICERROR;
    public static final int ERRORCODE_OK;
    public static final int ERRORCODE_CORESERVICE_NOT_AVAILIBLE;
    public static final int ERRORCODE_CORESERVICE_NOT_AVAILABLE;
    public static final int ERRORCODE_CORESERVICE_CONFIGURATION;
    public static final int ERRORCODE_CORESERVICE_SERVICE_NOT_ALLOWED;
    public static final int ERRORCODE_CORESERVICE_SERVICELIST_URL_CORRUPT;
    public static final int ERRORCODE_HTTPSERVICE_NOT_AVAILIBLE;
    public static final int ERRORCODE_HTTPSERVICE_NOT_AVAILABLE;
    public static final int ERRORCODE_CONNECTIVITY_ERROR;
    public static final int ERRORCODE_AUTH_CONFIGURATION_ERROR;
    public static final int ERRORCODE_AUTHMETHOD_NOT_IMPLEMENTED;
    public static final int ERRORCODE_CREDENTIALS_NOT_AVAILIBLE;
    public static final int ERRORCODE_CREDENTIALS_NOT_AVAILABLE;
    public static final int ERRORCODE_AUTH_INTERNAL_ERROR;
    public static final int ERRORCODE_AUTH_BACKEND_ERROR;
    public static final int ERRORCODE_TRANSFER_CANCELED;
    public static final int ERRORCODE_BACKEND_NOT_AVAILIBLE;
    public static final int ERRORCODE_BACKEND_NOT_AVAILABLE;
    public static final int ERRORCODE_BACKEND_PROBLEM;
    public static final int ERRORCODE_BACKEND_PROBLEM_SERVICELIST_INVALID;
    public static final int ERRORCODE_COULDNOTREGISTER;
    public static final int ERRORCODE_COULDNOTGETSERVICELIST;
    public static final int ERRORCODE_CORESERVICE_SERVICELIST_URL_MISSING;
    public static final int ERRORCODE_PAIRING_CODE_INVALID;
    public static final int ERRORCODE_PAIRING_NO_ACCOUNT;
    public static final int ERRORCODE_COMPONENT_PROTECTION;
    public static final int ERRORCODE_URL_INVALID;
    public static final int ERRORCODE_AUTH_INCOMPLETE;
    public static final int ERRORCODE_ONLINESERVICE_DISABLED;
    public static final int ERRORCODE_NOT_INITALIZED_YET;
    public static final int ERRORCODE_INVALID_AUTHSCHEME;
    public static final int ERRORCODE_DIAGNOSE_NOT_AVAILABLE;
    public static final int ERRORCODE_APPLICATION_NOT_AVAILABLE;
    public static final int ERRORCODE_GENERIC_ERROR;
    public static final int ERRORCODE_INVALID_USER;
    public static final int ERRORCODE_PRIMARY_USER_REQUIRED;
    public static final int ERRORCODE_ESIM_NODATAVOLUME;
    public static final int ERRORCODE_COULDNOTRETRIEVEOAUTHTOKEN;
    public static final int ERRORCODE_OAUTHSERVERNOTAVAILABLE;
    public static final int ERRORCODE_SERVICEID_DISABLED;
    public static final int ERRORCODE_SPIN_WRONG;
    public static final int ERRORCODE_SPIN_LOCKED;
    public static final int REASONPRIO_SERVICE_CONFIGURATION;
    public static final int REASONPRIO_CONNECTION_STATE;
    public static final int REASONPRIO_LICENSE_STATE;
    public static final int REASONPRIO_UNKNOWNSERVICE;
    public static final int REASONPRIO_BACKEND;
    public static final int REASONUNKNOWNSERVICE_NOSERVICE;
    public static final int REASONCONFIG_DISABLE;
    public static final int REASONCONFIG_ROAMING;
    public static final int REASONCONFIG_ONDEMAND;
    public static final int REASONCONFIG_PRIVACY;
    public static final int REASONCONFIG_SERVICEID_DISABLED;
    public static final int REASONCONNECTIVITY_UNKNOWN;
    public static final int REASONCONNECTIVITY_BLOCKED;
    public static final int REASONCONNECTIVITY_ESIMLICENSENOTVALID;
    public static final int REASONCONNECTIVITY_NODATAVOLUME;
    public static final int REASONLICENSE_ACTIVATE;
    public static final int REASONLICENSE_EXPIRED;
    public static final int REASONLICENSE_NOTLICENSED;
    public static final int REASONOWNERVERIFICATION_NOVERIFICATION;
    public static final int USERTYPE_UNKNOWN;
    public static final int USERTYPE_MAINUSER;
    public static final int USERTYPE_SECONDARYUSER;
    public static final int SERVICESTATE_CONNECTIVITY_BIT;
    public static final int SERVICESTATE_SERVICELIST_OFFLINE_BIT;
    public static final int SERVICESTATE_SERVICELIST_ONLINE_BIT;
    public static final int SERVICESTATE_SERVICELIST_PENDING_BIT;
    public static final int SERVICESTATE_DEVICESEARCH_PENDING;
    public static final int SERVICESTATE_DEVICESEARCH_FOUNDDEVICES;
    public static final int SERVICESTATE_GPSSERVICESACTIVE;
    public static final int SERVICESTATE_OWNERVERIFICATION_OK;
    public static final int SERVICESTATE_GPSPOPUPVALID;
    public static final int SERVICESTATE_GPSPOPUPALLOWED;
    public static final int SERVICESTATE_WAITING_GPSPOPUP;
    public static final int SERVICESTATE_WAITING_INVENTORY;
    public static final int SERVICESTATE_OWNERVERIFICATION_AVAILABLE;
    public static final int PRIVACY_NONANONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_PSEUDONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_ANONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_PERSONALIZED_USERDATA;
    public static final int PRIVACY_PERSONALIZED_VEHICLEDATA;
    public static final int PRIVACY_FULL;
    public static final int APN_NOTALLOWED;
    public static final int APN_VENDOR;
    public static final int APN_CUSTOMER;
    public static final int REASONBACKEND_TERMS_AND_CONDITIONS_NOT_ACCEPTED;
    public static final int REASONBACKEND_PRIMARY_USER_NOT_VERIFIED;
    public static final int REASONBACKEND_NO_ACTIVE_LICENSE;
    public static final int REASONBACKEND_INITIALLY_DISABLED;
    public static final int REASONBACKEND_NOT_CONFIGURED;
    public static final int REASONBACKEND_SWITCHED_OFF;
    public static final int REASONBACKEND_DEACTIVATED;
    public static final int SERVICETYPE_MBBINTERNAL;
    public static final int SERVICETYPE_MBBESSENTIAL;
    public static final int SERVICETYPE_WEBAPP;
    public static final int SERVICETYPE_EXTERN;
    public static final int SERVICETYPE_APP;
    public static final int SERVICETYPE_VEHICLEONLY;
    public static final int SERVICETYPE_MBB;
    public static final int QOS_HIGH;
    public static final int QOS_MED;
    public static final int QOS_LOW;
    public static final int AUTHLEVEL_T0X;
    public static final int AUTHLEVEL_T1X;
    public static final int AUTHLEVEL_T2X;
    public static final int GPSUSEMODE_ACCEPT;
    public static final int GPSUSEMODE_DECLINE;
    public static final int GPSUSEMODE_NEVER;
    public static final int RT_GETONLINEAPPLICATIONLIST;
    public static final int RT_GETONLINEAPPLICATION;
    public static final int RT_SETDEMANDSTATE;
    public static final int RT_SETONLINEAPPLICATIONSTATE;
    public static final int RT_ACTIVATELICENSE;
    public static final int RT_SETAPPLICATIONPROPERTIES;
    public static final int RT_SETCREDENTIAL;
    public static final int RT_VALIDATEOWNER;
    public static final int RT_CHECKOWNERSVERIFICATION;
    public static final int RT_PERFORMPORTALREGISTRATION;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_DOWNLOAD;
    public static final int RT_CREATEUSERWITHUSERPASSWORD;
    public static final int RT_CHECKPASSWORD;
    public static final int RT_CHECKPAIRINGCODE;
    public static final int RT_SETPRIVACYFLAGS;
    public static final int RT_SETAUTOLOGIN;
    public static final int RT_LOGIN;
    public static final int RT_LOGOUT;
    public static final int RT_LOGOUTAUTHSCHEME;
    public static final int RT_GETUSERS;
    public static final int RT_REMOVEUSER;
    public static final int RT_CREATEUSERWITHPAIRINGCODE;
    public static final int RT_GETLICENSE;
    public static final int RT_GETLICENSES;
    public static final int RT_GETPROFILEFOLDER;
    public static final int RT_ADDORUPDATEAPPLICATIONPROPERTY;
    public static final int RT_GETCREDENTIALSFROMHEADER;
    public static final int RT_GETSERVICEURL;
    public static final int RT_GETCREDENTIALSFROMAUTHSCHEME;
    public static final int RT_SETLANGUAGE;
    public static final int RT_PRECHECKONLINESERVICE;
    public static final int RT_PRECHECKONLINESERVICESYMBOLICNAME;
    public static final int RT_PRECHECKONLINESERVICESERVICEID;
    public static final int RT_VALIDATEOWNERFORCE;
    public static final int RT_SETSERVICESTATE;
    public static final int RT_SETSERVICESTATESYMBOLICNAME;
    public static final int RT_SETACTIVEPRIVACYCATEGORYMASK;
    public static final int RT_SUBMITSERVICESTATECHANGESTOBACKEND;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RT_SETDEMANDSTATESERVICEID;
    public static final int RT_SETGPSUSEMODE;
    public static final int RT_SETINVENTORYFINISHED;
    public static final int RT_DOWNLOADRAW;
    public static final int RT_SETSPIN;
    public static final int RT_GETSPINHASH;
    public static final int RP_GETONLINEAPPLICATIONLISTRESPONSE;
    public static final int RP_GETONLINEAPPLICATIONRESPONSE;
    public static final int RP_ACTIVATELICENSERESPONSE;
    public static final int RP_SETCREDENTIALRESPONSE;
    public static final int RP_RESETTOFACTORYSETTINGSRESPONSE;
    public static final int RP_DOWNLOADRESPONSE;
    public static final int RP_VALIDATEOWNERRESPONSE;
    public static final int RP_CHECKOWNERSVERIFICATIONRESPONSE;
    public static final int RP_PERFORMPORTALREGISTRATIONRESPONSE;
    public static final int RP_CREATEUSERWITHPAIRINGCODERESPONSE;
    public static final int RP_CREATEUSERWITHUSERPASSWORDRESPONSE;
    public static final int RP_CHECKPASSWORDRESPONSE;
    public static final int RP_CHECKPAIRINGCODERESPONSE;
    public static final int RP_SETPRIVACYFLAGSRESPONSE;
    public static final int RP_SETAUTOLOGINRESPONSE;
    public static final int RP_LOGINRESPONSE;
    public static final int RP_LOGOUTRESPONSE;
    public static final int RP_LOGOUTAUTHSCHEMERESULT;
    public static final int RP_GETUSERSRESPONSE;
    public static final int RP_REMOVEUSERRESPONSE;
    public static final int RP_GETLICENSERESPONSE;
    public static final int RP_GETLICENSESRESPONSE;
    public static final int RP_GETPROFILEFOLDERRESPONSE;
    public static final int RP_GETCREDENTIALSFROMHEADERRESPONSE;
    public static final int RP_GETCREDENTIALSFROMAUTHSCHEMERESPONSE;
    public static final int RP_GETSERVICEURLRESPONSE;
    public static final int RP_PRECHECKONLINESERVICERESPONSE;
    public static final int RP_PRECHECKONLINESERVICESYMBOLICNAMERESPONSE;
    public static final int RP_PRECHECKONLINESERVICESERVICEIDRESPONSE;
    public static final int RP_SETSERVICESTATERESPONSE;
    public static final int RP_SETSERVICESTATESYMBOLICNAMERESPONSE;
    public static final int RP_SETACTIVEPRIVACYCATEGORYMASKRESPONSE;
    public static final int RP_SUBMITSERVICESTATECHANGESTOBACKENDRESPONSE;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int RP_SETDEMANDSTATESERVICEIDRESPONSE;
    public static final int RP_SETGPSUSEMODERESPONSE;
    public static final int RP_SETINVENTORYFINISHEDRESPONSE;
    public static final int RP_DOWNLOADRAWRESPONSE;
    public static final int RP_SETSPINRESPONSE;
    public static final int RP_GETSPINHASHRESULT;
    public static final int ATTR_APPLICATIONSTATE;
    public static final int ATTR_DEVICEENUMERATOR;
    public static final int ATTR_EXTERNALPROFILEINFO;
    public static final int ATTR_COREPROFILEINFO;
    public static final int ATTR_SERVICESTATE;
    public static final int ATTR_SERVICELIST;
    public static final int ATTR_PROFILESTATE;
    public static final int ATTR_SERVICES;
    public static final int ATTR_SERVICEREGISTRATION;
    public static final int ATTR_SPINREQUIRED;

    default public void getOnlineApplicationList() {
    }

    default public void getOnlineApplication(String string) {
    }

    default public void setOnlineApplicationState(String string, int n) {
    }

    default public void activateLicense(OSRLicense oSRLicense) {
    }

    default public void setDemandState(String string, boolean bl) {
    }

    default public void setDemandStateServiceID(String string, boolean bl) {
    }

    default public void setApplicationProperties(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
    }

    default public void addOrUpdateApplicationProperty(String string, OSRApplicationProperties oSRApplicationProperties) {
    }

    default public void setCredential(String string, String string2, String string3) {
    }

    default public void download(String string, String string2, String string3, long l, long l2) {
    }

    default public void downloadRaw(String string, String string2, String string3, long l, long l2) {
    }

    default public void validateOwner(String string) {
    }

    default public void validateOwnerForce(boolean bl) {
    }

    default public void checkOwnersVerification() {
    }

    default public void createUserWithPairingCode(String string, String string2) {
    }

    default public void createUserWithUserPassword(String string, String string2, String string3) {
    }

    default public void checkPassword(OSRUser oSRUser, String string, boolean bl) {
    }

    default public void checkPairingCode(OSRUser oSRUser, String string, boolean bl) {
    }

    default public void setPrivacyFlags(OSRUser oSRUser, int n) {
    }

    default public void setAutoLogin(OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
    }

    default public void login(OSRUser oSRUser) {
    }

    default public void logout(OSRUser oSRUser) {
    }

    default public void logoutAuthScheme(String string) {
    }

    default public void getUsers(String string) {
    }

    default public void removeUser(OSRUser oSRUser) {
    }

    default public void performPortalRegistration(String string) {
    }

    default public void getLicense(String string) {
    }

    default public void getLicenses(boolean bl, boolean bl2) {
    }

    default public void precheckOnlineServiceServiceID(String string, String string2) {
    }

    default public void precheckOnlineServiceSymbolicName(String string, String string2) {
    }

    default public void precheckOnlineService(String string) {
    }

    default public void getProfileFolder(OSRUser oSRUser, String string) {
    }

    default public void getCredentialsFromHeader(int n, String[] stringArray) {
    }

    default public void getCredentialsFromAuthScheme(int n) {
    }

    default public void getServiceURL(String string) {
    }

    default public void resetToFactorySettings(String string) {
    }

    default public void setLanguage(String string) {
    }

    default public void setServiceState(String string, int n) {
    }

    default public void setServiceStateSymbolicName(String string, int n) {
    }

    default public void setActivePrivacyCategoryMask(int n) {
    }

    default public void submitServiceStateChangesToBackend() {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }

    default public void setGPSUseMode(int n) {
    }

    default public void setInventoryFinished(boolean bl) {
    }

    default public void setSPIN(String string, String string2, String string3) {
    }

    default public void getSPINHash(String string, String string2, int n, String string3) {
    }
}

