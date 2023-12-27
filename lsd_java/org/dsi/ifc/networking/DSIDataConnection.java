/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;

public interface DSIDataConnection
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_STATEDATACONNECTION;
    public static final int ATTR_ERRORSTATE;
    public static final int ATTR_CONNECTIONSTATEINFORMATION;
    public static final int ATTR_ROAMINGSTATE;
    public static final int DATACONTEXTSTATE_ATTACHED_GPRS;
    public static final int DATACONTEXTSTATE_ATTACHED_EDGE;
    public static final int DATACONTEXTSTATE_ATTACHED_UMTS;
    public static final int DATACONTEXTSTATE_ATTACHED_HSDPA;
    public static final int DATACONTEXTSTATE_NOT_ATTACHED;
    public static final int DATACONTEXTSTATE_DATA_DIAGNOSE_NOT_ALLOWED;
    public static final int DATACONTEXTSTATE_DATA_NOT_FUNCTIONAL;
    public static final int RESULT_RESULT_OK;
    public static final int RESULT_RESULT_ABORTED;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_CONNECTION_REQUEST_RUNNING;
    public static final int RESULT_ERROR_PROFILE_NOT_EXISTS;
    public static final int RESULT_ERROR_SYSTEM_ERROR;
    public static final int RESULT_ERROR_TIME_OUT;
    public static final int RESULT_ERROR_NOT_SUPPORTED;
    public static final int RESULT_ERROR_DENIED;
    public static final int RESULT_ERROR_CONNECTION_REFUSED;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_UNKNOWN;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_FULL;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_LIMITED;
    public static final int CONNECTION_IDLE_ALLOWED;
    public static final int CONNECTION_CONNECTED_ALLOWED;
    public static final int CONNECTION_PENDING;
    public static final int CONNECTION_BLOCKED;
    public static final int CONNECTION_UNKNOWN;
    public static final int CONNECTION_LOCAL_NET;
    public static final int ROAMING_ACTIVE;
    public static final int ROAMING_NOT_ACTIVE;
    public static final int RP_FORCEDISCONNECTRESPONSE;
    public static final int RT_FORCEDISCONNECTREQUEST;

    default public void forceDisconnectRequest() {
    }
}

