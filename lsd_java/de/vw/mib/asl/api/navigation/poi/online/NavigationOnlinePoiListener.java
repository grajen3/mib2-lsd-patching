/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.poi.online;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;

public interface NavigationOnlinePoiListener {
    default public void updateLock(boolean bl) {
    }

    default public void onlinePoiSearchResult(int n, int n2) {
    }

    default public void valueListBlock(IOnlinePoiListElement[] iOnlinePoiListElementArray, int n) {
    }

    default public void resolveEntryResult(INavigationLocation iNavigationLocation) {
    }

    default public void updateDynPoi2ServiceID(int n, String string) {
    }
}

