/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;

final class LocationFormatter$1
implements CacheClient {
    LocationFormatter$1() {
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(-1326444544, resourceLocator);
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }
}

