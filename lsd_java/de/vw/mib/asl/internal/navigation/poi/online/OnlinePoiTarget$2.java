/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import org.dsi.ifc.global.ResourceLocator;

class OnlinePoiTarget$2
implements ASLOnlineServiceCallback1 {
    private final /* synthetic */ OnlinePoiTarget this$0;

    OnlinePoiTarget$2(OnlinePoiTarget onlinePoiTarget) {
        this.this$0 = onlinePoiTarget;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            this.this$0.printTrace(new StringBuffer().append("Updating model provider logo with icon: ").append(resourceLocator.toString()).toString());
        }
        this.this$0.model.setProviderLogoOnlinePOI(resourceLocator);
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
    }
}

