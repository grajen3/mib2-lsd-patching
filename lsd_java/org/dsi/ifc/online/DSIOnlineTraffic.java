/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineTraffic
extends DSIBase {
    public static final String VERSION;
    public static final int IN_GETDOWNLOADFILERESULT;
    public static final int ATTR_CONSUMERREADY;
    public static final int ATTR_WANTONLINETRAFFICDATA;
    public static final int REQUEST_CONSUMER_READY;
    public static final int REQUEST_WANTONLINETRAFFICDATA;
    public static final int TRAFFICDATASTATUS_IDLE;
    public static final int TRAFFICDATASTATUS_NO_DATA_AVAILABLE;
    public static final int TRAFFICDATASTATUS_PREPARING_DATA;
    public static final int TRAFFICDATASTATUS_DATA_AVAILABLE;
    public static final int TRAFFICDATASTATUS_NO_DATA_FOR_THIS_AREA;
    public static final int TRAFFICDATASTATUS_DISABLED;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_OK;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_BUSY;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_NOT_AVAILABLE;
    public static final int ONLINETRAFFICCONSUMERSTATE_DATA_ERROR;
    public static final int UPDATERATE_DATA_WANTED_STD_INTERVAL;
    public static final int UPDATERATE_DATA_WANTED_SHORT_INTERVAL;
    public static final int UPDATERATE_DATA_WANTED_IMMEDIATELY;
    public static final int UPDATERATE_NOT_INTERESTED_IN_DATA;
    public static final long FCDVALID_TIME;
    public static final long FCDVALID_POSITION;
    public static final long FCDVALID_FORMOFWAY;
    public static final long FCDVALID_FUNCTIONALROADCLASS;
    public static final long FCDVALID_ROADNUMBER;
    public static final long FCDVALID_HEADING;
    public static final long FCDVALID_SPEED;
    public static final long FCDVALID_TEMPERATURE;
    public static final long FCDVALID_RAIN;
    public static final int RT_SETONLINETRAFFICDATASTATUS;
    public static final int RT_GETNEWDATA;
    public static final int RT_SETNEWDATA;
    public static final int RT_SETTIMEOUTFORFALLBACK;
    public static final int RT_SETNEWSESSION;
    public static final int RT_GETNEWFCDINFORMATION;
    public static final int RT_GETINVENTORY;
    public static final int RP_GETNEWDATARESULT;
    public static final int RP_SETNEWDATARESULT;
    public static final int RP_GETNEWSESSION;
    public static final int RP_SETTIMEOUTFORFALLBACKRESULT;
    public static final int RP_GETNEWFCDINFORMATIONRESULT;
    public static final int RP_GETINVENTORYRESULT;

    default public void setOnlineTrafficDataStatus(int n) {
    }

    default public void getNewData() {
    }

    default public void setNewData(String string) {
    }

    default public void setTimeoutForFallback(long l) {
    }

    default public void setNewSession() {
    }

    default public void getNewFCDInformation() {
    }

    default public void getInventory() {
    }
}

