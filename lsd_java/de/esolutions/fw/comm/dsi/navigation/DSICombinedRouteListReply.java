/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSICombinedRouteListReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void windowChanged(int n) {
    }

    default public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
    }

    default public void trafficInformationResult(TmcMessage tmcMessage, int n) {
    }

    default public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
    }

    default public void updateElementsTotal(long l, long l2, int n) {
    }

    default public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
    }

    default public void requestPriceInfoResult(NavPriceInfo navPriceInfo, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

