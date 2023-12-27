/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.performance;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class CachePerformanceMetrics
implements PerformanceMetrics {
    public final int cachedObjects;
    public final int cachedObjectsSizeBytes;
    public final int cacheLimitBytes;
    public final int hits;
    public final int misses;

    public CachePerformanceMetrics(int n, int n2, int n3, int n4, int n5) {
        this.cachedObjects = n;
        this.cachedObjectsSizeBytes = n2;
        this.cacheLimitBytes = n3;
        this.hits = n4;
        this.misses = n5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[cachedObjects=").append(this.cachedObjects);
        stringBuilder.append(",cachedObjectsSizeBytes=").append(this.cachedObjectsSizeBytes);
        stringBuilder.append(",cacheLimitBytes=").append(this.cacheLimitBytes);
        stringBuilder.append(",hits=").append(this.hits);
        stringBuilder.append(",misses=").append(this.misses);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

