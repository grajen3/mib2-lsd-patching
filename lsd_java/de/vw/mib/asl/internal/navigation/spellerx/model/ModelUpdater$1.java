/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.model;

import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

final class ModelUpdater$1
implements CacheClient {
    private final /* synthetic */ NavigationLocationInputLocationCollector val$locCol;

    ModelUpdater$1(NavigationLocationInputLocationCollector navigationLocationInputLocationCollector) {
        this.val$locCol = navigationLocationInputLocationCollector;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.val$locCol.navigation_locationinput_location_country_icon = resourceLocator;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

