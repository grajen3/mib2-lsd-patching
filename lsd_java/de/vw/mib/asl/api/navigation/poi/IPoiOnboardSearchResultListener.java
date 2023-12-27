/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public interface IPoiOnboardSearchResultListener {
    default public void updateOnboardPoiStatus(ValueListStatus valueListStatus) {
    }

    default public void liValueListBlock(LIValueList lIValueList, int n) {
    }

    default public void resolvePoiResult(NavLocation navLocation) {
    }
}

