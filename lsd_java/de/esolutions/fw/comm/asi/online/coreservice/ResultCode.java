/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.core.IEnum;

public interface ResultCode
extends IEnum {
    public static final int ERRORCODE_OK;
    public static final int ERRORCODE_CORESERVICE_NOT_AVAILIBLE;
    public static final int ERRORCODE_CORESERVICE_CONFIGURATION;
    public static final int ERRORCODE_CORESERVICE_SERVICE_NOT_ALLOWED;
    public static final int ERRORCODE_CORESERVICE_SERVICELIST_URL_CORRUPT;
    public static final int ERRORCODE_HTTPSERVICE_NOT_AVAILIBLE;
    public static final int ERRORCODE_CONNECTIVITY_ERROR;
    public static final int ERRORCODE_AUTH_CONFIGURATION_ERROR;
    public static final int ERRORCODE_AUTHMETHOD_NOT_IMPLEMENTED;
    public static final int ERRORCODE_CREDENTIALS_NOT_AVAILIBLE;
    public static final int ERRORCODE_AUTH_INTERNAL_ERROR;
    public static final int ERRORCODE_AUTH_BACKEND_ERROR;
    public static final int ERRORCODE_TRANSFER_CANCELED;
    public static final int ERRORCODE_BACKEND_NOT_AVAILIBLE;
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
}

