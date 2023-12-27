/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector;
import org.dsi.ifc.global.NavLocation;

class OnlinePoiTarget$1
extends AbstractDualListViewHandler {
    private final /* synthetic */ OnlinePoiTarget this$0;

    OnlinePoiTarget$1(OnlinePoiTarget onlinePoiTarget) {
        this.this$0 = onlinePoiTarget;
    }

    @Override
    public NavLocation navLocationFromListItem(Object object) {
        int n = ((ResultListCollector)object).getLatitude();
        int n2 = ((ResultListCollector)object).getLongitude();
        return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
    }
}

