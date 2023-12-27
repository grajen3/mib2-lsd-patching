/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$CacheEntryPool;
import de.vw.mib.cache.AbstractCache$CacheableReference;
import de.vw.mib.cache.AbstractCache$CacheableSoftReference;
import de.vw.mib.cache.AbstractCache$CacheableStrongReference;
import de.vw.mib.cache.AbstractCache$CacheableStrongReferencePool;
import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.AbstractCache$SortedCacheEntryList;
import de.vw.mib.cache.Cache;
import de.vw.mib.cache.CacheListener;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.cache.CachingPolicy;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.ref.ReferenceQueue;

public abstract class AbstractCache
implements Cache {
    private final CachingPolicy cachingPolicy;
    private final boolean strongReferences;
    private static final int MAP_INITIAL_CAPACITY;
    private final LongObjectMap map;
    private final AbstractCache$SortedCacheEntryList entryList;
    private static final int ENTRY_POOL_MAXIMUM_CAPACITY;
    private final AbstractCache$CacheEntryPool entryPool;
    private final AbstractCache$CacheableStrongReferencePool strongReferencePool;
    private ReferenceQueue referenceQueue;
    private int byteSize;
    private int hits;
    private int misses;
    private CowList listeners;

    public AbstractCache(CachingPolicy cachingPolicy, boolean bl) {
        this.cachingPolicy = cachingPolicy;
        this.strongReferences = bl;
        this.entryPool = new AbstractCache$CacheEntryPool(100);
        this.map = new LongObjectOptHashMap(100);
        this.entryList = new AbstractCache$SortedCacheEntryList();
        if (bl) {
            this.strongReferencePool = new AbstractCache$CacheableStrongReferencePool(100);
        } else {
            this.strongReferencePool = null;
            this.referenceQueue = new ReferenceQueue();
        }
        this.byteSize = 0;
        this.hits = 0;
        this.misses = 0;
        this.listeners = CowList.EMPTY;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[cachingPolicy=").append(this.cachingPolicy);
        stringBuilder.append(",strongReferences=").append(this.strongReferences);
        stringBuilder.append(",map=").append(this.map);
        stringBuilder.append(",entryList=").append(this.entryList);
        stringBuilder.append(",byteSize=").append(this.byteSize);
        stringBuilder.append(",hits=").append(this.hits);
        stringBuilder.append(",misses=").append(this.misses);
        stringBuilder.append(",listeners=").append(this.listeners);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final int size() {
        return this.map.size();
    }

    @Override
    public final int getByteSize() {
        return this.byteSize;
    }

    @Override
    public void clear() {
        Cacheable[] cacheableArray = this.elements();
        for (int i2 = 0; i2 < cacheableArray.length; ++i2) {
            this.remove(cacheableArray[i2]);
        }
        this.fireClear();
    }

    @Override
    public final Cacheable get(long l) {
        AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.map.get(l);
        if (abstractCache$Entry != null) {
            Cacheable cacheable = abstractCache$Entry.getValue();
            if (cacheable == null) {
                this.checkReferenceQueue();
            } else {
                int n = abstractCache$Entry.getCost();
                this.touch(abstractCache$Entry);
                if (abstractCache$Entry.getCost() != n) {
                    this.entryList.remove(abstractCache$Entry);
                    this.entryList.add(abstractCache$Entry);
                }
                ++this.hits;
                this.fireHit(l, cacheable);
            }
            return cacheable;
        }
        ++this.misses;
        this.fireMiss(l);
        return null;
    }

    @Override
    public final void put(long l, Cacheable cacheable) {
        while (this.cachingPolicy.isEvictionRequired(this, cacheable) && this.evict()) {
        }
        AbstractCache$CacheableReference abstractCache$CacheableReference = null;
        if (this.strongReferences) {
            abstractCache$CacheableReference = (AbstractCache$CacheableStrongReference)this.strongReferencePool.borrowObject();
            ((AbstractCache$CacheableStrongReference)abstractCache$CacheableReference).setCacheable(cacheable);
        } else {
            abstractCache$CacheableReference = new AbstractCache$CacheableSoftReference(cacheable, this.referenceQueue);
        }
        AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.entryPool.borrowObject();
        abstractCache$Entry.setKey(l);
        abstractCache$Entry.setReference(abstractCache$CacheableReference);
        abstractCache$Entry.setByteSize(cacheable.getByteSize());
        abstractCache$CacheableReference.setEntry(abstractCache$Entry);
        this.touch(abstractCache$Entry);
        if (this.map.put(l, abstractCache$Entry) != null) {
            // empty if block
        }
        this.entryList.add(abstractCache$Entry);
        this.byteSize += abstractCache$Entry.getByteSize();
        this.fireAdd(l, cacheable);
    }

    @Override
    public final void remove(long l) {
        AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.map.get(l);
        if (abstractCache$Entry != null) {
            this.evict(abstractCache$Entry);
        }
    }

    protected void touch(AbstractCache$Entry abstractCache$Entry) {
        abstractCache$Entry.touch();
    }

    @Override
    public final void remove(Cacheable cacheable) {
        AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.entryList.getFirst();
        while (abstractCache$Entry != null) {
            if (abstractCache$Entry.getValue() == cacheable) {
                this.evict(abstractCache$Entry);
                break;
            }
            abstractCache$Entry = (AbstractCache$Entry)abstractCache$Entry.next;
        }
    }

    public boolean evict() {
        if (this.size() > 0) {
            AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.entryList.getLast();
            while (abstractCache$Entry != null) {
                if (this.canEvict(abstractCache$Entry)) {
                    this.evict(abstractCache$Entry);
                    return true;
                }
                abstractCache$Entry = (AbstractCache$Entry)abstractCache$Entry.previous;
            }
        }
        return false;
    }

    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return true;
    }

    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        this.map.remove(abstractCache$Entry.getKey());
        this.entryList.remove(abstractCache$Entry);
        this.byteSize -= abstractCache$Entry.getByteSize();
        this.fireRemove(abstractCache$Entry.getValue());
        if (this.strongReferences) {
            this.strongReferencePool.releaseObject((AbstractCache$CacheableStrongReference)abstractCache$Entry.getReference());
        }
        this.entryPool.releaseObject(abstractCache$Entry);
    }

    private void checkReferenceQueue() {
        if (!this.strongReferences) {
            AbstractCache$CacheableReference abstractCache$CacheableReference = null;
            while ((abstractCache$CacheableReference = (AbstractCache$CacheableReference)((Object)this.referenceQueue.poll())) != null) {
                AbstractCache$Entry abstractCache$Entry = abstractCache$CacheableReference.getEntry();
                this.evict(abstractCache$Entry);
            }
        }
    }

    @Override
    public final int hits() {
        return this.hits;
    }

    @Override
    public final int misses() {
        return this.misses;
    }

    @Override
    public final Cacheable[] elements() {
        this.checkReferenceQueue();
        Cacheable[] cacheableArray = new Cacheable[this.map.size()];
        int n = 0;
        AbstractCache$Entry abstractCache$Entry = (AbstractCache$Entry)this.entryList.getFirst();
        while (abstractCache$Entry != null) {
            cacheableArray[n++] = abstractCache$Entry.getValue();
            abstractCache$Entry = (AbstractCache$Entry)abstractCache$Entry.next;
        }
        return cacheableArray;
    }

    @Override
    public final void addCacheListener(CacheListener cacheListener) {
        this.listeners = this.listeners.addIfAbsent(cacheListener);
    }

    @Override
    public final void removeCacheListener(CacheListener cacheListener) {
        this.listeners = this.listeners.remove(cacheListener);
    }

    protected final void fireClear() {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            CacheListener cacheListener = (CacheListener)cowList.head();
            cacheListener.clear();
        }
    }

    protected final void fireHit(long l, Cacheable cacheable) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            CacheListener cacheListener = (CacheListener)cowList.head();
            cacheListener.hit(l, cacheable);
        }
    }

    protected final void fireMiss(long l) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            CacheListener cacheListener = (CacheListener)cowList.head();
            cacheListener.miss(l);
        }
    }

    protected final void fireAdd(long l, Cacheable cacheable) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            CacheListener cacheListener = (CacheListener)cowList.head();
            cacheListener.add(l, cacheable);
        }
    }

    protected final void fireRemove(Cacheable cacheable) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            CacheListener cacheListener = (CacheListener)cowList.head();
            cacheListener.remove(cacheable);
        }
    }
}

