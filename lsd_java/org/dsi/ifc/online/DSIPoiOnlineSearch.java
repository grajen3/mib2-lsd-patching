/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface DSIPoiOnlineSearch
extends DSIBase {
    public static final String VERSION;
    public static final int TYPEOFREQUEST_FREETYPE;
    public static final int TYPEOFREQUEST_DYNAMICPOI;
    public static final int DYNAMICPOICATEGORY_GAS_STATIONS;
    public static final int DYNAMICPOICATEGORY_PARKINGLOTS;
    public static final int DYNAMICPOICATEGORY_NATURALGAS_STATIONS;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS_NORMAL;
    public static final int DYNAMICPOICATEGORY_ECHARGING_STATIONS_FAST;
    public static final int SORTKEY_DEFAULT;
    public static final int SORTKEY_DISTANCE;
    public static final int SORTKEY_CATEGORY_DATA;
    public static final int SOURCEID_AUDI;
    public static final int SOURCEID_GOOGLE;
    public static final int SOURCEID_YAHOO;
    public static final int SOURCEID_LYCOS;
    public static final int SOURCEID_MSN;
    public static final int SOURCEID_AOL;
    public static final int SOURCEID_TONLINE;
    public static final int SOURCEID_TINFO;
    public static final int SOURCEID_VW;
    public static final int STATUS_OK_INIT;
    public static final int STATUS_OK_SEARCH_COMPLETE;
    public static final int STATUS_OK_SEARCH_CANCELED;
    public static final int STATUS_ERROR_CAR_HARDWARE;
    public static final int STATUS_ERROR_CAR_DSI;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_SETUP;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_ERROR;
    public static final int STATUS_ERROR_POISTS_SSL_HANDSHAKE_FAILED;
    public static final int STATUS_ERROR_POISTS_TIMEOUT;
    public static final int STATUS_ERROR_POISTS_CONNECTION_CLOSED;
    public static final int STATUS_ERROR_POISTS_CONNECTION_REJECTED;
    public static final int STATUS_ERROR_POISTS_PARSE;
    public static final int STATUS_ERROR_POISTS_HOST_UNRESOLVABLE;
    public static final int STATUS_ERROR_POISTS_UNKNOWN_ERROR;
    public static final int STATUS_ERROR_POISTS_INVALID_INPUT;
    public static final int STATUS_ERROR_POISTS_URL_INVALID;
    public static final int STATUS_ERROR_POIDB_TIMEOUT;
    public static final int STATUS_ERROR_POIDB_CONNECTION_CLOSED;
    public static final int STATUS_ERROR_POIDB_CONNECTION_REJECTED;
    public static final int STATUS_ERROR_POIDB_PARSE;
    public static final int STATUS_ERROR_POIDB_HOST_UNRESOLVABLE;
    public static final int STATUS_ERROR_POIDB_UNKNOWN_ERROR;
    public static final int STATUS_ERROR_VOICE_LANGUAGE_NOT_SUPPORTED;
    public static final int STATUS_ERROR_VOICE_NOT_RECOGNIZED;
    public static final int STATUS_ERROR_VOICE_RECOGNIZED_NO_RESULTS;
    public static final int STATUS_ERROR_LANGUAGE_NOT_SUPPORTED;
    public static final int STATUS_ERROR_VOICE_RECOGNITION_FAILED;
    public static final int STATUS_ERROR_PROFANITY_DETECTED;
    public static final int RESULTSOURCE_POI;
    public static final int RESULTSOURCE_SDS;
    public static final int USEDPOI_UNKNOWN;
    public static final int USEDPOI_NAVIGATETO;
    public static final int USEDPOI_PHONECALL;
    public static final int USEDPOI_ADDEDTOADDRESSBOOK;
    public static final int TYPEOFPOI_UNKNOWN;
    public static final int TYPEOFPOI_REGULAR;
    public static final int TYPEOFPOI_AD;
    public static final int RT_POISTARTSELECTION;
    public static final int RT_POISTOPSELECTION;
    public static final int RT_POIREQUESTVALUELIST;
    public static final int RT_POIREQUESTSPELLINGSUGGESTION;
    public static final int RT_USEDPOI;
    public static final int RT_SETLANGUAGE;
    public static final int RT_SETFALLBACKLANGUAGE;
    public static final int RT_POIVOICESEARCHACTIVE;
    public static final int RT_POISTARTVOICESELECTION;
    public static final int RT_POIRAWVOICEDATAAVAILABLE;
    public static final int RT_POISTARTSELECTIONZOOM;
    public static final int RT_DYNAMICPOISTARTSELECTION;
    public static final int RT_DYNAMICPOISTARTSELECTIONZOOM;
    public static final int RT_PRECHECKDYNAMICPOICATEGORY;
    public static final int RP_POIRESULT;
    public static final int RP_POISPELLINGSUGGESTION;
    public static final int RP_POIVALUELIST;
    public static final int RP_PRECHECKDYNAMICPOICATEGORYRESPONSE;

    default public void poiStartSelectionZoom(String string, int n, int n2, int n3, int n4, int n5) {
    }

    default public void dynamicPoiStartSelectionZoom(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public void poiStartSelection(String string, int n, int n2, int n3, int n4) {
    }

    default public void dynamicPoiStartSelection(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void poiStopSelection() {
    }

    default public void poiRequestValueList(int n, int n2) {
    }

    default public void poiStartVoiceSelection(int n, int n2, int n3, int n4, boolean bl, int n5) {
    }

    default public void poiRawVoiceDataAvailable(String string, int n) {
    }

    default public void poiRequestSpellingSuggestion() {
    }

    default public void usedPoi(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void setFallbackLanguage(String string) {
    }

    default public void poiVoiceSearchActive() {
    }

    default public void precheckDynamicPOICategory(int n) {
    }
}

