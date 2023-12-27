/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$CacheableReference;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.AbstractLinkedList$ListEntry;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public final class AbstractCache$Entry
extends AbstractLinkedList$ListEntry
implements PooledObject,
Comparable {
    private AbstractCache$CacheableReference reference;
    private long key;
    private int byteSize;
    private int use;
    private int cost;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[reference=").append(this.reference);
        stringBuilder.append(",key=").append(this.key);
        stringBuilder.append(",byteSize=").append(this.byteSize);
        stringBuilder.append(",use=").append(this.use);
        stringBuilder.append(",cost=").append(this.cost);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void backToPool() {
        this.reference = null;
        this.byteSize = 0;
        this.use = 0;
        this.cost = 0;
    }

    public AbstractCache$CacheableReference getReference() {
        return this.reference;
    }

    public void setReference(AbstractCache$CacheableReference abstractCache$CacheableReference) {
        this.reference = abstractCache$CacheableReference;
    }

    public long getKey() {
        return this.key;
    }

    public void setKey(long l) {
        this.key = l;
    }

    public Cacheable getValue() {
        return this.reference.getCacheable();
    }

    public int getByteSize() {
        return this.byteSize;
    }

    public void setByteSize(int n) {
        this.byteSize = n;
    }

    @Override
    public int compareTo(Object object) {
        int n;
        int n2 = this.getCost();
        return n2 > (n = ((AbstractCache$Entry)object).getCost()) ? 1 : (n2 < n ? -1 : 0);
    }

    public int getCost() {
        return this.cost;
    }

    protected void setCost(int n) {
        this.cost = n;
    }

    public int getUse() {
        return this.use;
    }

    public void touch() {
        ++this.use;
    }
}

