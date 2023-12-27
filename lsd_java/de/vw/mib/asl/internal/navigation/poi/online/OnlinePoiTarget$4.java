/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

class OnlinePoiTarget$4
implements NavigationOnlinePoiListener {
    private final /* synthetic */ PoiOnlineSearchValuelist val$currentPoiValueList;
    private final /* synthetic */ int val$currentIndexOfFirstItem;
    private final /* synthetic */ int val$currentTotalItems;
    private final /* synthetic */ OnlinePoiTarget this$0;

    OnlinePoiTarget$4(OnlinePoiTarget onlinePoiTarget, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n, int n2) {
        this.this$0 = onlinePoiTarget;
        this.val$currentPoiValueList = poiOnlineSearchValuelist;
        this.val$currentIndexOfFirstItem = n;
        this.val$currentTotalItems = n2;
    }

    @Override
    public void updateLock(boolean bl) {
    }

    @Override
    public void onlinePoiSearchResult(int n, int n2) {
    }

    @Override
    public void valueListBlock(IOnlinePoiListElement[] iOnlinePoiListElementArray, int n) {
    }

    @Override
    public void resolveEntryResult(INavigationLocation iNavigationLocation) {
    }

    @Override
    public void updateDynPoi2ServiceID(int n, String string) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace(new StringBuffer().append("updateDynPoi2ServiceID(serviceId = ").append(n).append(", serviceIdString = ").append(string).append(")").toString());
        }
        this.this$0.notifyModelAndSlde(this.val$currentPoiValueList, this.val$currentIndexOfFirstItem, this.val$currentTotalItems, string);
    }
}

