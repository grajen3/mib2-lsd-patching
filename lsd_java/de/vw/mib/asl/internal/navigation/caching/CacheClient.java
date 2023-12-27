/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.caching;

import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;

public interface CacheClient {
    default public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
    }

    default public ResourceLocator getDefaultIcon() {
    }
}

