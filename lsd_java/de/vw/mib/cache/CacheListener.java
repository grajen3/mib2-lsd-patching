/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.Cacheable;

public interface CacheListener {
    default public void clear() {
    }

    default public void hit(long l, Cacheable cacheable) {
    }

    default public void miss(long l) {
    }

    default public void add(long l, Cacheable cacheable) {
    }

    default public void remove(Cacheable cacheable) {
    }
}

