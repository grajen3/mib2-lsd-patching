/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.online;

import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.online.NavigationOnlinePoiServiceImpl;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

final class NavigationOnlinePoiServiceImpl$1
implements IPoiOnlineSearchResultListener {
    NavigationOnlinePoiServiceImpl$1() {
    }

    @Override
    public void valueListBlock(IOnlinePoiListElement[] iOnlinePoiListElementArray, int n) {
        Iterator iterator = NavigationOnlinePoiServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationOnlinePoiServiceImpl navigationOnlinePoiServiceImpl = (NavigationOnlinePoiServiceImpl)iterator.next();
            if (navigationOnlinePoiServiceImpl.listener == null) continue;
            navigationOnlinePoiServiceImpl.listener.valueListBlock(iOnlinePoiListElementArray, n);
        }
    }

    @Override
    public void resolveEntryResult(NavLocation navLocation) {
        Iterator iterator = NavigationOnlinePoiServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationOnlinePoiServiceImpl navigationOnlinePoiServiceImpl = (NavigationOnlinePoiServiceImpl)iterator.next();
            if (navigationOnlinePoiServiceImpl.listener == null) continue;
            INavigationLocationImpl iNavigationLocationImpl = new INavigationLocationImpl(navLocation);
            navigationOnlinePoiServiceImpl.listener.resolveEntryResult(iNavigationLocationImpl);
        }
    }

    @Override
    public void onlinePoiSearchResult(int n, int n2) {
        Iterator iterator = NavigationOnlinePoiServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationOnlinePoiServiceImpl navigationOnlinePoiServiceImpl = (NavigationOnlinePoiServiceImpl)iterator.next();
            if (navigationOnlinePoiServiceImpl.listener == null) continue;
            navigationOnlinePoiServiceImpl.listener.onlinePoiSearchResult(n, n2);
        }
    }

    @Override
    public void updateOnboardPoiStatus(ValueListStatus valueListStatus) {
    }

    @Override
    public void liValueListBlock(LIValueList lIValueList, int n) {
    }
}

