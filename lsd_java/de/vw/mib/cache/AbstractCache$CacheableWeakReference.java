/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$CacheableReference;
import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.util.StringBuilder;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class AbstractCache$CacheableWeakReference
extends WeakReference
implements AbstractCache$CacheableReference {
    private AbstractCache$Entry entry;

    public AbstractCache$CacheableWeakReference(Cacheable cacheable, ReferenceQueue referenceQueue) {
        super(cacheable, referenceQueue);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[entry=").append(this.entry);
        stringBuilder.append("]");
        return stringBuilder.toString();
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
        return (Cacheable)this.get();
    }
}

