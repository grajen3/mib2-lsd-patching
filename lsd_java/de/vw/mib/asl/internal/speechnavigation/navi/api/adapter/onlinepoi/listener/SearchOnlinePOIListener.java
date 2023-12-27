/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.listener;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.OnlinePOISearchServiceAdapter;

public interface SearchOnlinePOIListener {
    default public void onRegistered(OnlinePOISearchServiceAdapter onlinePOISearchServiceAdapter) {
    }

    default public void onErrorDuringSearch(int n) {
    }

    default public void onGetNextListPart(IOnlinePoiListElement[] iOnlinePoiListElementArray) {
    }

    default public void onResolvedResult(INavigationLocation iNavigationLocation) {
    }
}

