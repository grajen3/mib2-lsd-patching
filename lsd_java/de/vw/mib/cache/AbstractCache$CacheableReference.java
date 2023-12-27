/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.Cacheable;

public interface AbstractCache$CacheableReference {
    default public AbstractCache$Entry getEntry() {
    }

    default public void setEntry(AbstractCache$Entry abstractCache$Entry) {
    }

    default public Cacheable getCacheable() {
    }
}

