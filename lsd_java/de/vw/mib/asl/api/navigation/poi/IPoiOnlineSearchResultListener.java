/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi;

import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public interface IPoiOnlineSearchResultListener {
    default public void onlinePoiSearchResult(int n, int n2) {
    }

    default public void valueListBlock(IOnlinePoiListElement[] iOnlinePoiListElementArray, int n) {
    }

    default public void resolveEntryResult(NavLocation navLocation) {
    }

    default public void updateOnboardPoiStatus(ValueListStatus valueListStatus) {
    }

    default public void liValueListBlock(LIValueList lIValueList, int n) {
    }
}

