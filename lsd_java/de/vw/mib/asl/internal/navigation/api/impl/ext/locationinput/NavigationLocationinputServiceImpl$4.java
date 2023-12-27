/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;

class NavigationLocationinputServiceImpl$4
implements CacheClient {
    private final /* synthetic */ INavigationLocation val$loc;
    private final /* synthetic */ NavigationLocationinputServiceImpl this$0;

    NavigationLocationinputServiceImpl$4(NavigationLocationinputServiceImpl navigationLocationinputServiceImpl, INavigationLocation iNavigationLocation) {
        this.this$0 = navigationLocationinputServiceImpl;
        this.val$loc = iNavigationLocation;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.this$0.listener.updateCountryIcon(this.val$loc, resourceLocator);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

