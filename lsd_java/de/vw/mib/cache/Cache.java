/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.CacheListener;
import de.vw.mib.cache.Cacheable;

public interface Cache {
    default public int size() {
    }

    default public int getByteSize() {
    }

    default public void clear() {
    }

    default public Cacheable get(long l) {
    }

    default public void put(long l, Cacheable cacheable) {
    }

    default public void remove(long l) {
    }

    default public void remove(Cacheable cacheable) {
    }

    default public int hits() {
    }

    default public int misses() {
    }

    default public Cacheable[] elements() {
    }

    default public void addCacheListener(CacheListener cacheListener) {
    }

    default public void removeCacheListener(CacheListener cacheListener) {
    }
}

