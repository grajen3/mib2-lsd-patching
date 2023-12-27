/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard;

import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.NavigationOnboardPoiServiceImpl;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

final class NavigationOnboardPoiServiceImpl$1
implements IPoiOnboardSearchResultListener {
    NavigationOnboardPoiServiceImpl$1() {
    }

    @Override
    public void updateOnboardPoiStatus(ValueListStatus valueListStatus) {
        NavigationOnboardPoiServiceImpl.notifyPoiSearchStatus(valueListStatus);
    }

    @Override
    public void liValueListBlock(LIValueList lIValueList, int n) {
        NavigationOnboardPoiServiceImpl.notifyPoiValueList(lIValueList, n);
    }

    @Override
    public void resolvePoiResult(NavLocation navLocation) {
        NavigationOnboardPoiServiceImpl.notifyPoiResult(navLocation);
    }
}

