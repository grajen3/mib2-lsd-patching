/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public interface DSITPEGServicesReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateTPEGContentAvailability(int[] nArray, int n) {
    }

    default public void updateSimpleMapsBookmarks(SimpleMapData[] simpleMapDataArray, int n) {
    }

    default public void requestLocationDetailsResponse(NavLocation navLocation) {
    }

    default public void requestFuelPriceInformationResponse(FuelPriceInformation[] fuelPriceInformationArray) {
    }

    default public void requestNewsInformationResponse(NewsCategory newsCategory) {
    }

    default public void requestSimpleMapListResponse(int n, int n2, SimpleMapData[] simpleMapDataArray) {
    }

    default public void addSimpleMapBookmarkResult(int n, int n2) {
    }

    default public void deleteSimpleMapBookmarkResult(int n, int n2) {
    }

    default public void deleteAllSimpleMapBookmarksResult(int n) {
    }

    default public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
    }

    default public void setLanguageResponse(boolean bl) {
    }

    default public void requestWeatherInfoResult(WeatherInfo weatherInfo, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

