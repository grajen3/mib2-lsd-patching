/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$CacheableReference;
import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public final class AbstractCache$CacheableStrongReference
implements AbstractCache$CacheableReference,
PooledObject {
    private Cacheable cacheable;
    private AbstractCache$Entry entry;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[cacheable=").append(this.cacheable);
        stringBuilder.append(",entry=").append(this.entry);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.cacheable = null;
        this.entry = null;
    }

    @Override
    public AbstractCache$Entry getEntry() {
        return this.entry;
    }

    @Override
    public void setEntry(AbstractCache$Entry abstractCache$Entry) {
        this.entry = abstractCache$Entry;
    }

    @Override
    public Cacheable getCacheable() {
        return this.cacheable;
    }

    public void setCacheable(Cacheable cacheable) {
        this.cacheable = cacheable;
    }
}

