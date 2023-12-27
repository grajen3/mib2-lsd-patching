/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.IOnboardPoiListElementImpl;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;

final class NavigationOnboardPoiServiceImpl$2
implements CacheClient {
    private final /* synthetic */ NavigationOnboardPoiListener val$l;

    NavigationOnboardPoiServiceImpl$2(NavigationOnboardPoiListener navigationOnboardPoiListener) {
        this.val$l = navigationOnboardPoiListener;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        ((IOnboardPoiListElementImpl)object).image = resourceLocator;
        this.val$l.poiListEntryChanged((IOnboardPoiListElement)object);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

