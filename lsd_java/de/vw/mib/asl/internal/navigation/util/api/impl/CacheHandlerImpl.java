/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.api.impl;

import de.vw.mib.asl.api.navigation.util.ICacheHandler;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class CacheHandlerImpl
implements ICacheHandler {
    @Override
    public TextRenderingInfo getTextRenderingInfo(IconKey iconKey) {
        return HsmCacheHandler.getTextRenderingInfo(iconKey);
    }

    @Override
    public ResourceLocator resourceIdForTMCEventIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForTMCEventIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForAdditionalIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForAdditionalIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForAdditionalTurnlistIcon(int n, int n2, int n3, int n4, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForAdditionalTurnlistIcon(n, n2, n3, n4, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForCountryIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForCountryIcon(n, n2, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForPOIIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForPOIIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForRoadClassIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForRoadClassIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForTargetIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForTargetIcon(n, n2, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForTrafficRegulationIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForTrafficRegulationIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public IconDescriptor resourceIdForRoadIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForRoadIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public IconDescriptor resourceIdForExitIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForExitIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public void clearCache() {
        HsmCacheHandler.clearCache();
    }

    @Override
    public ResourceLocator resourceIdForPOIIconFromRawData(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForPOIIconFromRawData(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForAreaWarningIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForAreaWarningIcon(n, n2, cacheClient, object);
    }
}

