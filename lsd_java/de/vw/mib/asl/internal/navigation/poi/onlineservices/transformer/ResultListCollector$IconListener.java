/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer;

import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;

class ResultListCollector$IconListener
implements ASLOnlineServiceCallback1 {
    private int listIndex;
    private ResultListCollector collector;
    private final /* synthetic */ ResultListCollector this$0;

    public ResultListCollector$IconListener(ResultListCollector resultListCollector, ResultListCollector resultListCollector2, int n) {
        this.this$0 = resultListCollector;
        this.collector = resultListCollector2;
        this.listIndex = n;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        if (ResultListCollector.access$000().isTraceEnabled(512)) {
            ResultListCollector.access$000().trace(512, new StringBuffer().append("updateImageInfo: lastServiceID: ").append(ASLNavigationPoiFactory.getNavigationPoiApi().getLastServiceIdString()).append("serviceIdForCategory: ").append(this.this$0.serviceIdForCategory).toString());
        }
        boolean bl = true;
        String string = ASLNavigationPoiFactory.getNavigationPoiApi().getLastServiceIdString();
        if (string != null && this.this$0.serviceIdForCategory != null && !string.equals(this.this$0.serviceIdForCategory)) {
            bl = false;
        }
        this.collector.setBrandIcon(resourceLocator);
        if (ResultListCollector.access$100(this.this$0) && bl) {
            ListManager.getGenericASLList(3748).updateListItem(this.listIndex, this.collector);
        }
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
        if (ResultListCollector.access$000().isTraceEnabled(512)) {
            ResultListCollector.access$000().trace(512, "updateImageInfo");
        }
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
        if (ResultListCollector.access$000().isTraceEnabled(512)) {
            ResultListCollector.access$000().trace(512, "getServiceURLResponse");
        }
    }
}

