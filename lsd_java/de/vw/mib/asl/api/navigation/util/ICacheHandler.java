/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public interface ICacheHandler {
    default public TextRenderingInfo getTextRenderingInfo(IconKey iconKey) {
    }

    default public ResourceLocator resourceIdForTMCEventIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForAdditionalIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForAdditionalTurnlistIcon(int n, int n2, int n3, int n4, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForCountryIcon(int n, int n2, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForPOIIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForRoadClassIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForTargetIcon(int n, int n2, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForTrafficRegulationIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public IconDescriptor resourceIdForRoadIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public IconDescriptor resourceIdForExitIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public void clearCache() {
    }

    default public ResourceLocator resourceIdForPOIIconFromRawData(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForAreaWarningIcon(int n, int n2, CacheClient cacheClient, Object object) {
    }
}

