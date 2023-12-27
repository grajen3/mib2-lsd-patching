/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;

public interface DSITPEGServices
extends DSIBase {
    public static final String VERSION;
    public static final int RP_REQUESTLOCATIONDETAILSRESPONSE;
    public static final int RP_REQUESTFUELPRICEINFORMATIONRESPONSE;
    public static final int RP_REQUESTNEWSINFORMATIONRESPONSE;
    public static final int RP_REQUESTSIMPLEMAPLISTRESPONSE;
    public static final int RP_ADDSIMPLEMAPBOOKMARKRESULT;
    public static final int RP_DELETESIMPLEMAPBOOKMARKRESULT;
    public static final int RP_DELETEALLSIMPLEMAPBOOKMARKSRESULT;
    public static final int RP_REQUESTRESOURCEINFORMATIONRESPONSE;
    public static final int RP_SETLANGUAGERESPONSE;
    public static final int RP_REQUESTWEATHERINFORESULT;
    public static final int ATTR_TPEGCONTENTAVAILABILITY;
    public static final int ATTR_SIMPLEMAPSBOOKMARKS;
    public static final int RT_REQUESTSIMPLEMAPLIST;
    public static final int RT_ADDSIMPLEMAPBOOKMARK;
    public static final int RT_DELETESIMPLEMAPBOOKMARK;
    public static final int RT_DELETEALLSIMPLEMAPBOOKMARKS;
    public static final int RT_REQUESTLOCATIONDETAILS;
    public static final int RT_REQUESTFUELPRICEINFORMATION;
    public static final int RT_REQUESTNEWSINFORMATION;
    public static final int RT_REQUESTRESOURCEINFORMATION;
    public static final int RT_SETLANGUAGE;
    public static final int RT_REQUESTSORTEDFUELPRICEINFORMATION;
    public static final int RT_REQUESTWEATHERINFO;
    public static final int TPEGSERVICE_UNKNOWN;
    public static final int TPEGSERVICE_OILPRICE;
    public static final int TPEGSERVICE_NEWS;
    public static final int TPEGSERVICE_WEATHER;
    public static final int SIMPLEMAP_CONTENTTYPE_UNKNOWN;
    public static final int SIMPLEMAP_CONTENTTYPE_TOPLIST;
    public static final int SIMPLEMAP_CONTENTTYPE_SUBLIST;
    public static final int SIMPLEMAP_CONTENTTYPE_MAPLIST;
    public static final int SIMPLEMAP_CONTENTTYPE_COMPLETELIST;
    public static final int TPEGNEWSCATEGORY_UNKNOWN;
    public static final int TPEGNEWSCATEGORY_SOCIALAFFAIRS;
    public static final int TPEGNEWSCATEGORY_POLITICS;
    public static final int TPEGNEWSCATEGORY_ENTERTAINMENT;
    public static final int TPEGNEWSCATEGORY_SPORTS;
    public static final int TPEGNEWSCATEGORY_BUSINESS;
    public static final int TPEGNEWSCATEGORY_NATIONAL;
    public static final int TPEGNEWSCATEGORY_TECHNOLOGY;
    public static final int TPEGNEWSCATEGORY_WEATHER;
    public static final int RESULT_UNKNOWN;
    public static final int RESULT_OK;
    public static final int RESULT_BOOKMARK_FULL_WARNING;
    public static final int RESULT_ERROR;
    public static final int SORTORDER_DEFAULT;
    public static final int SORTORDER_PRICE;
    public static final int SORTORDER_DISTANCE;
    public static final int WEATHERREQUESTMODE_CCP;
    public static final int WEATHERREQUESTMODE_SELECTEDLOCATION;
    public static final int WEATHERINFOTYPE_UNKNOWN;
    public static final int WEATHERINFOTYPE_PERIOD_1;
    public static final int WEATHERINFOTYPE_PERIOD_2;
    public static final int WEATHERINFOTYPE_PERIOD_3;
    public static final int WEATHERINFOTYPE_PERIOD_4;
    public static final int WEATHERINFOTYPE_PERIOD_5;
    public static final int WEATHERINFOTYPE_PERIOD_6;
    public static final int WEATHERINFOTYPE_PERIOD_7;
    public static final int WEATHERINFOTYPE_PERIOD_8;
    public static final int WEATHERINFOTYPE_PERIOD_9;
    public static final int WEATHERINFOINTERVAL_UNKNOWN;
    public static final int WEATHERINFOINTERVAL_1HOUR;
    public static final int WEATHERINFOINTERVAL_3HOURS;
    public static final int WEATHERINFOINTERVAL_1DAY;
    public static final int WEATHERTYPE_UNKNOWN;
    public static final int WEATHERTYPE_CLEAR;
    public static final int WEATHERTYPE_SLIGHTLY_CLOUDY;
    public static final int WEATHERTYPE_PARTLY_CLOUDY;
    public static final int WEATHERTYPE_CLOUDY;
    public static final int WEATHERTYPE_RAIN;
    public static final int WEATHERTYPE_SNOW;
    public static final int WEATHERTYPE_RAIN_OR_SNOW;
    public static final int REQUESTWEATHERRESULT_OK;
    public static final int REQUESTWEATHERRESULT_ERROR;
    public static final int REQUESTWEATHERRESULT_NODATA;
    public static final int REQUESTWEATHERRESULT_CACHED_DATA;

    default public void requestSimpleMapList(int n, int n2) {
    }

    default public void addSimpleMapBookmark(int n) {
    }

    default public void deleteSimpleMapBookmark(int n) {
    }

    default public void deleteAllSimpleMapBookmarks() {
    }

    default public void requestLocationDetails(int n) {
    }

    default public void requestFuelPriceInformation(int n, int n2) {
    }

    default public void requestSortedFuelPriceInformation(int n, int n2, int n3) {
    }

    default public void requestNewsInformation(int n) {
    }

    default public void requestResourceInformation(int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void requestWeatherInfo(NavLocation navLocation, int n, int n2) {
    }
}

