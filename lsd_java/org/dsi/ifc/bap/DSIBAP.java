/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bap;

import org.dsi.ifc.base.DSIBase;

public interface DSIBAP
extends DSIBase {
    public static final String VERSION;
    public static final int RT_GETBAPSTATE;
    public static final int RT_SETHMISTATE;
    public static final int RT_REQUEST;
    public static final int RT_REQUESTVOID;
    public static final int RT_REQUESTBYTESEQUENCE;
    public static final int RT_REQUESTERROR;
    public static final int RP_ACKNOWLEDGE;
    public static final int IN_INDICATION;
    public static final int IN_INDICATIONVOID;
    public static final int IN_INDICATIONBYTESEQUENCE;
    public static final int IN_INDICATIONERROR;
    public static final int IN_BAPSTATESTATUS;
    public static final int BAPREQUESTTYPE_DATASETGET_REQ;
    public static final int BAPREQUESTTYPE_DATASET_REQ;
    public static final int BAPREQUESTTYPE_DATAGET_REQ;
    public static final int BAPREQUESTTYPE_START_REQ;
    public static final int BAPREQUESTTYPE_STARTRESULT_REQ;
    public static final int BAPREQUESTTYPE_ABORT_REQ;
    public static final int BAPREQUESTTYPE_DATAACK_REQ;
    public static final int BAPREQUESTTYPE_DATA_CNF;
    public static final int BAPREQUESTTYPE_PROCESSING_REQ;
    public static final int BAPREQUESTTYPE_RESULT_REQ;
    public static final int BAPREQUESTTYPE_CHANGED_REQ;
    public static final int BAPREQUESTTYPE_DATAACK_CNF;
    public static final int BAPDATATYPE_INT8_DATATYPE;
    public static final int BAPDATATYPE_INT16_DATATYPE;
    public static final int BAPDATATYPE_INT32_DATATYPE;
    public static final int BAPDATATYPE_BYTESEQUENCE_DATATYPE;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATA;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATAACK;
    public static final int ACKNOWLEDGETYPE_PROPERTY_ERROR;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATA;
    public static final int ACKNOWLEDGETYPE_ARRAY_CHANGED;
    public static final int ACKNOWLEDGETYPE_ARRAY_ERROR;
    public static final int ACKNOWLEDGETYPE_METHOD_PROCESSING;
    public static final int ACKNOWLEDGETYPE_METHOD_RESULT;
    public static final int ACKNOWLEDGETYPE_METHOD_ERROR;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATASETGET;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATASET;
    public static final int ACKNOWLEDGETYPE_PROPERTY_DATAGET;
    public static final int ACKNOWLEDGETYPE_PROPERTY_ACK;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATASETGET;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATASET;
    public static final int ACKNOWLEDGETYPE_ARRAY_DATAGET;
    public static final int ACKNOWLEDGETYPE_METHOD_START;
    public static final int ACKNOWLEDGETYPE_METHOD_STARTRESULT;
    public static final int ACKNOWLEDGETYPE_METHOD_ABORT;
    public static final int ACKNOWLEDGETYPE_CACHE_DATAGET;
    public static final int ACKNOWLEDGETYPE_SET_HMI_STATE;
    public static final int BAPINDICATIONTYPE_DATASETGET_IND;
    public static final int BAPINDICATIONTYPE_DATASET_IND;
    public static final int BAPINDICATIONTYPE_DATAGET_IND;
    public static final int BAPINDICATIONTYPE_START_IND;
    public static final int BAPINDICATIONTYPE_STARTRESULT_IND;
    public static final int BAPINDICATIONTYPE_ABORT_IND;
    public static final int BAPINDICATIONTYPE_PROCESSING_CNF;
    public static final int BAPINDICATIONTYPE_ACK_IND;
    public static final int BAPINDICATIONTYPE_DATAACK_RSP;
    public static final int BAPINDICATIONTYPE_DATA_RSP;
    public static final int BAPINDICATIONTYPE_PROCESSING_IND;
    public static final int BAPINDICATIONTYPE_RESULT_IND;
    public static final int BAPINDICATIONTYPE_CHANGED_IND;
    public static final int BAPINDICATIONTYPE_RESET_IND;
    public static final int ERRORCODE_TRANSPORTMEDIANOTACCESSIBLE;
    public static final int ERRORCODE_ILLEGALSEQUENCE;
    public static final int ERRORCODE_SEQUENCENUMBER;
    public static final int ERRORCODE_TIMEOUTSEGMENTATION;
    public static final int ERRORCODE_OVERSIZESEGMENTATION;
    public static final int ERRORCODE_BADDATALENGTH;
    public static final int ERRORCODE_RECEIVEDDATALOST;
    public static final int ERRORCODE_HEARTBEATTIMEOUT;
    public static final int ERRORCODE_RETRYNOTSUCCESSFUL;
    public static final int ERRORCODE_BUSY;
    public static final int ERRORCODE_REQUESTTIMEOUT;
    public static final int ERRORCODE_INCOMPATIBLEPROTOCOLVERSION;
    public static final int ERRORCODE_INCOMPATIBLEDATASPECIFICATION;
    public static final int ERRORCODE_CACHEINVALID_SENDBUFFERNOTINITIALIZED_GETALLMESSAGECORRUPTED;
    public static final int ERRORCODE_INVALIDSTATE;
    public static final int ERRORCODE_CACHENOTAVAILABLE;
    public static final int ERRORCODE_INVALIDARG;
    public static final int ERRORCODE_OUTOFRANGE;
    public static final int ERRORCODE_NOTIMPLEMENTED_TEMPORARYNOTAVAILABLE;
    public static final int ERRORCODE_MAXDATALENGTHEXCEEDED;
    public static final int ERRORCODE_UNITMISMATCH;
    public static final int ERRORCODE_METHODABORTED;
    public static final int BAPSTACKSTATE_NOT_READY;
    public static final int BAPSTACKSTATE_READY;
    public static final int HMISTATE_NOT_READY;
    public static final int HMISTATE_READY_INITIALIZING;
    public static final int HMISTATE_READY_RUNNING;

    default public void getBAPState(int n) {
    }

    default public void setHMIState(int n, int n2) {
    }

    default public void request(int n, int n2, int n3, int n4, int n5) {
    }

    default public void requestVoid(int n, int n2, int n3) {
    }

    default public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
    }

    default public void requestError(int n, int n2, int n3) {
    }
}

