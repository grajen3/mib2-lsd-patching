/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface DSICombinedRouteListListener
extends DSIListener {
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
}

