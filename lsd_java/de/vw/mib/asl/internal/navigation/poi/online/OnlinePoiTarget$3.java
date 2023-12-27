/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$3$1;
import org.dsi.ifc.global.ResourceLocator;

class OnlinePoiTarget$3
implements NavigationOnlinePoiListener {
    private final /* synthetic */ String val$url;
    private final /* synthetic */ String val$checksum;
    private final /* synthetic */ int val$category;
    private final /* synthetic */ OnlinePoiTarget this$0;

    OnlinePoiTarget$3(OnlinePoiTarget onlinePoiTarget, String string, String string2, int n) {
        this.this$0 = onlinePoiTarget;
        this.val$url = string;
        this.val$checksum = string2;
        this.val$category = n;
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
        this.this$0.dynamicPoiServiceId = string;
        this.this$0.printTrace(new StringBuffer().append("Requesting dynamic provider logo for online POI url=").append(this.val$url).append(" checksum=").append(this.val$checksum).toString());
        ResourceLocator resourceLocator = this.this$0.coreServices.getOnlineImage(0, this.this$0.coreServices.getServiceIDWithNumericServiceID(4), 0, this.val$url, this.val$checksum, new OnlinePoiTarget$3$1(this));
        if (resourceLocator != null) {
            this.this$0.printTrace(new StringBuffer().append("Updating model dynamic provider logo with icon: ").append(resourceLocator.toString()).toString());
            this.this$0.model.setProviderLogoDynamicPOI(resourceLocator, this.val$category);
        }
    }

    static /* synthetic */ OnlinePoiTarget access$000(OnlinePoiTarget$3 onlinePoiTarget$3) {
        return onlinePoiTarget$3.this$0;
    }

    static /* synthetic */ int access$100(OnlinePoiTarget$3 onlinePoiTarget$3) {
        return onlinePoiTarget$3.val$category;
    }
}

