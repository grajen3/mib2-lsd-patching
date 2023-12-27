/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

import de.vw.mib.asl.internal.list.IndexIterator;
import de.vw.mib.asl.internal.list.buffer.ASLListCache;
import java.util.NoSuchElementException;

class ASLListCacheIterator
implements IndexIterator {
    static ASLListCacheIterator EMPTY_LIST_ITERATOR = new ASLListCacheIterator(null, 0, 0);
    private final ASLListCache cache;
    private final int end;
    private int index;
    private int nextIndex;
    private Object next;

    ASLListCacheIterator(ASLListCache aSLListCache, int n, int n2) {
        this.cache = aSLListCache;
        this.nextIndex = n - 1;
        this.end = n2;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object = this.next;
        this.next = null;
        this.index = this.nextIndex;
        return object;
    }

    @Override
    public boolean hasNext() {
        while (null == this.next && ++this.nextIndex < this.end) {
            this.next = this.cache.getItem(this.nextIndex);
        }
        return null != this.next;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

