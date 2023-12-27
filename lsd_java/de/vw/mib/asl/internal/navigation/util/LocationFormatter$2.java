/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

final class LocationFormatter$2
implements CacheClient {
    LocationFormatter$2() {
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (object instanceof NavigationMemoryDestinationDetailsCollector) {
            NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)object;
            navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon = resourceLocator;
            ListManager.getGenericASLList(910).updateList(new Object[]{navigationMemoryDestinationDetailsCollector});
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

