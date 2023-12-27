/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces;

public interface CoreServiceConstants {
    public static final int INVALID;
    public static final int DEFAULT_VALUE;
    public static final int PRIORITY_HIGHEST;
    public static final int PRIORITY_HIGH;
    public static final int PRIORITY_BELOW_HIGH;
    public static final int PRIORITY_ABOVE_MEDIUM;
    public static final int PRIORITY_MEDIUM;
    public static final int PRIORITY_BELOW_MEDIUM;
    public static final int PRIORITY_ABOVE_LOW;
    public static final int PRIORITY_LOW;
    public static final int PRIORITY_BELOW_LOW;
    public static final int DEVICE_OCU;
    public static final int DEVICE_MOD;
    public static final int DEVICE_OCU_PRIORITY;
    public static final int DEVICE_MOD_PRIORITY;
    public static final int RESULT_INVALID;
    public static final int RESULT_OK;
    public static final int RESULT_CORESERVICE_NOT_AVAILABLE;
    public static final int RESULT_CORESERVICE_CONFIGURATION;
    public static final int RESULT_CORESERVICE_SERVICE_NOT_ALLOWED;
    public static final int RESULT_CORESERVICE_SERVICELIST_URL_CORRUPT;
    public static final int RESULT_HTTPSERVICE_NOT_AVAILABLE;
    public static final int RESULT_CONNECTIVITY_ERROR;
    public static final int RESULT_AUTH_CONFIGURATION_ERROR;
    public static final int RESULT_AUTHMETHOD_NOT_IMPLEMENTED;
    public static final int RESULT_CREDENTIALS_NOT_AVAILABLE;
    public static final int RESULT_AUTH_INTERNAL_ERROR;
    public static final int RESULT_AUTH_BACKEND_ERROR;
    public static final int RESULT_TRANSFER_CANCELED;
    public static final int RESULT_BACKEND_NOT_AVAILABLE;
    public static final int RESULT_BACKEND_PROBLEM;
    public static final int RESULT_BACKEND_PROBLEM_SERVICELIST_INVALID;
    public static final int RESULT_COULDNOTREGISTER;
    public static final int RESULT_COULDNOTGETSERVICELIST;
    public static final int RESULT_CORESERVICE_SERVICELIST_URL_MISSING;
    public static final int RESULT_PAIRING_CODE_INVALID;
    public static final int RESULT_PAIRING_NO_ACCOUNT;
    public static final int RESULT_COMPONENT_PROTECTION;
    public static final int RESULT_URL_INVALID;
    public static final int RESULT_AUTH_INCOMPLETE;
    public static final int RESULT_ONLINESERVICE_DISABLED;
    public static final int RESULT_NOT_INITALIZED_YET;
    public static final int RESULT_INVALID_AUTHSCHEME;
    public static final int RESULT_DIAGNOSE_NOT_AVAILABLE;
    public static final int RESULT_APPLICATION_NOT_AVAILABLE;
    public static final int RESULT_ERROR;
    public static final int RESULT_INVALID_USER;
    public static final int RESULT_SERVICE_BUSY;
    public static final int RESULT_TERMINATED_BY_USER;
    public static final int RESULT_OWNERVERIFICATION_WRONG;
    public static final int RESULT_OWNERVERIFICATION_CONNECTIVITY;
    public static final int RESULT_OWNERVERIFICATION_ERROR;
    public static final int RESULT_OWNERVERIFICATION_NOTAVAILABLE;
    public static final int RESULT_OWNERVERIFICATION_TIMEOUT;
    public static final int RESULT_OWNERVERIFICATION_CANCELED;
    public static final int RESULT_FILEDOWNLOAD_OK;
    public static final int RESULT_FILEDOWNLOAD_NOSERVICE;
    public static final int RESULT_FILEDOWNLOAD_SERVER;
    public static final int RESULT_FILEDOWNLOAD_NOTAFILE;
    public static final int RESULT_FILEDOWNLOAD_NOTWRITEABLE;
    public static final int RESULT_FILEDOWNLOAD_TIMEOUT;
    public static final int RESULT_FILEDOWNLOAD_IOERROR;
    public static final int RESULT_FILEDOWNLOAD_URLCORRUPT;
    public static final int RESULT_FILEDOWNLOAD_CANCELED;
    public static final int RESULT_FILEDOWNLOAD_CREATEFAILED;
    public static final int RESULT_FILEDOWNLOAD_GENERICERROR;
    public static final int RESULT_CORESERVICE_SERVICE_NOT_ALLOWED_WITH_LICENSE;
    public static final int RESULT_PRIMARY_USER_REQUIRED;
    public static final int RESULT_ESIM_NODATAVOLUME;
    public static final int RESULT_COULDNOTRETRIEVEOAUTHTOKEN;
    public static final int RESULT_OAUTHSERVERNOTAVAILABLE;
    public static final int RESULT_SERVICEID_DISABLED;
    public static final int RESULT_SPIN_WRONG;
    public static final int RESULT_SPIN_LOCKED;
    public static final int RESULT_CORESERVICE_CONFIGURATION_ROAMING;
    public static final int RESULT_PRECHECK_SERVICE_NOT_AVAILABLE;
    public static final String DSI_INVALID;
    public static final int SERVICE_STATE_UNKNOWN;
    public static final int SERVICE_STATE_AVAILABLE;
    public static final int SERVICE_STATE_AVAILABLE_TRACKING_SERVICE;
    public static final int SERVICE_STATE_NO_CONNECTION;
    public static final int SERVICE_STATE_NOT_REGISTERED;
    public static final int SERVICE_STATE_ROAMING;
    public static final int SERVICE_STATE_LICENSE_EXPIRED;
    public static final int SERVICE_STATE_LOCALLY_DEACTIVATED;
    public static final int SERVICE_STATE_BACKEND_PROBLEM;
    public static final int SERVICE_STATE_NO_LICENSE;
    public static final int SERVICE_STATE_ENABLED;
    public static final int SERVICE_STATE_DISABLED;
    public static final int SERVICE_STATE_ENABLED_ROAMING;
    public static final int REGISTRATION_UNKNOWN;
    public static final int REGISTRATION_DONE;
    public static final int REGISTRATION_PENDING;
    public static final int REGISTRATION_NOT_REQUIRED;
    public static final int LICENSE_STATE_UNKNOWN;
    public static final int LICENSE_STATE_ACTIVATED;
    public static final int LICENSE_STATE_NOT_ACTIVATED;
    public static final int LICENSE_STATE_NOT_LICENSED;
    public static final int LICENSE_STATE_EXPIRED;
    public static final int LICENSE_STATE_OFFERED;
    public static final int LICENSE_STATE_LICENSE_ERROR;
    public static final int LICENSE_STATE_LICENSE_REVOKED;
    public static final int LICENSE_STATE_LICENSE_FREE;
    public static final int LICENSE_TYPE_REGULAR;
    public static final int LICENSE_TYPE_TRAIL;
    public static final int LICENSE_TYPE_DEALER;
    public static final int USER_TYPE_UNKNOWN;
    public static final int USER_TYPE_MAIN_USER;
    public static final int USER_TYPE_NOT_MAIN_USER;
    public static final int DEVICE_TYPE_UNKNOWN;
    public static final int DEVICE_TYPE_MAIN;
    public static final int DEVICE_TYPE_NOT_MAIN;
    public static final int DEVICE_STATUS_UNKNOWN;
    public static final int DEVICE_STATUS_AVAILABLE;
    public static final int DEVICE_STATUS_NOT_AVAILABLE;
    public static final int DEVICE_STATUS_STARTED;
    public static final int DEVICE_AVAILABLE_UNKNOWN;
    public static final int DEVICE_AVAILABLE_ACCESSIBLE;
    public static final int DEVICE_AVAILABLE_COMMUNICATION;
    public static final int DEVICE_MOD_AVAILABLE_ONLY;
    public static final int LIST_TYPE_DEVICE;
    public static final int LIST_TYPE_APPLICATION;
    public static final int LIST_TYPE_SERVICE;
    public static final int LIST_TYPE_USER;
    public static final int LIST_TYPE_LICENSE;
    public static final int LIST_TYPE_REGISTRATION;
    public static final int REQUEST_TYPE_UNKNOWN;
    public static final int REQUEST_TYPE_FACTORY_RESET;
    public static final int REQUEST_TYPE_VALIDATE_USER;
    public static final int REQUEST_TYPE_VALIDATE_PIN;
    public static final int REQUEST_TYPE_USER_LIST;
    public static final int REQUEST_TYPE_AUTHENTICATION;
    public static final int REQUEST_TYPE_SET_ACTIVE_USER;
    public static final int REQUEST_TYPE_GET_ACTIVE_USER;
    public static final int REQUEST_TYPE_APPLICATION_LIST;
    public static final int REQUEST_TYPE_GET_APPLICATION;
    public static final int REQUEST_TYPE_SERVICE_LIST;
    public static final int REQUEST_TYPE_STATE_CHANGE;
    public static final int REQUEST_TYPE_SERVICE_URL;
    public static final int REQUEST_TYPE_VALIDATE_PIN_FORCE;
    public static final int REQUEST_TYPE_DOWNLOAD_IMAGE;
    public static final int REQUEST_TYPE_PRIVACY_MODE;
    public static final int REQUEST_TYPE_SPIN_HASH;
    public static final int REQUEST_TYPE_SET_SPIN;
    public static final String ONLINE_IMAGES_FOLDER;
    public static final String ONLINE_IMAGES_FILE_EXTENSION;
    public static final String MOD_PROPERTY_APPID;
    public static final String MOD_PROPERTY_KEY;
    public static final String MOD_PROPERTY_VALUE_OCU;
    public static final String MOD_PROPERTY_VALUE_MOD;
    public static final int PRIVACY_GROUP_UNKNOWN;
    public static final int PRIVACY_GROUP_NONANONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_GROUP_PSEUDONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_GROUP_ANONYMOUS_LOCATIONTRACKING;
    public static final int PRIVACY_GROUP_PERSONALIZED_USERDATA;
    public static final int PRIVACY_GROUP_PERSONALIZED_VEHICLEDATA;
    public static final int GROUP_UNKNOWN;
    public static final int GROUP_GUIDE_INFORM;
    public static final int GROUP_SECURITY_SERVICE;
    public static final int GROUP_TRACKING_DATA;
    public static final int GROUP_PLACE_DATA;
    public static final int GROUP_USER_DATA;
    public static final int GROUP_VEHICLE_DATA;
    public static final int GROUP_SCHWARM_DATA;
    public static final int CATEGORY_UNKNOWN;
    public static final int CATEGORY_SALES;
    public static final int CATEGORY_PRIVACY;
    public static final int APN_USER_SIM;
    public static final int APN_ESIM;
    public static final int TRACKING_SERVICES_NOT_AVAILABLE;
    public static final int TRACKING_SERVICES_AVAILABLE_ACTIVE;
    public static final int TRACKING_SERVICES_AVAILABLE_NOT_ACTIVE;
    public static final int SERVICELIST_STATE_NOTAVAILABLE;
    public static final int SERVICELIST_STATE_UNKNOWN;
    public static final int SERVICELIST_STATE_OFFLINE;
    public static final int SERVICELIST_STATE_ONLINE;
    public static final int SERVICELIST_STATUS_NOTAVAILABLE;
    public static final int SERVICELIST_STATUS_OFFLINE;
    public static final int SERVICELIST_STATUS_OFFLINE_WITH_DATACONNECTION;
    public static final int SERVICELIST_STATUS_OFFLINE_WITH_REGISTRATION;
    public static final int SERVICELIST_STATUS_ONLINE_WITH_DATACONNECTION;
    public static final int SERVICELIST_STATUS_ONLINE_WITH_REGISTRATION;
    public static final int SERVICELIST_STATE_ENABLED;
    public static final int SERVICELIST_STATE_DISABLED;
    public static final int SERVICELIST_STATE_PARTIALLY_ENABLED;
    public static final int FACTORYRESET_RESULT_SUCCESSFUL;
    public static final int FACTORYRESET_RESULT_PARTIALLY_SUCCESSFUL;
    public static final int FACTORYRESET_RESULT_NOT_SUCCESSFUL;
}
