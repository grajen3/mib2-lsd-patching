/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget$3;
import org.dsi.ifc.global.ResourceLocator;

class OnlinePoiTarget$3$1
implements ASLOnlineServiceCallback1 {
    private final /* synthetic */ OnlinePoiTarget$3 this$1;

    OnlinePoiTarget$3$1(OnlinePoiTarget$3 onlinePoiTarget$3) {
        this.this$1 = onlinePoiTarget$3;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            OnlinePoiTarget$3.access$000(this.this$1).printTrace(new StringBuffer().append("Updating model dynamic provider logo with icon: ").append(resourceLocator.toString()).toString());
        }
        OnlinePoiTarget$3.access$000((OnlinePoiTarget$3)this.this$1).model.setProviderLogoDynamicPOI(resourceLocator, OnlinePoiTarget$3.access$100(this.this$1));
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
    }
}

