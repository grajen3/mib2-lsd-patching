/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.WeakHashMap$Entry;
import java.util.WeakHashMap$Entry$Type;

class WeakHashMap$HashIterator
implements Iterator {
    private int position = 0;
    private int expectedModCount;
    private WeakHashMap$Entry currentEntry;
    private WeakHashMap$Entry nextEntry;
    private Object nextKey;
    final WeakHashMap$Entry$Type type;
    final /* synthetic */ WeakHashMap this$0;

    WeakHashMap$HashIterator(WeakHashMap weakHashMap, WeakHashMap$Entry$Type weakHashMap$Entry$Type) {
        this.this$0 = weakHashMap;
        this.type = weakHashMap$Entry$Type;
        this.expectedModCount = weakHashMap.modCount;
    }

    @Override
    public boolean hasNext() {
        if (this.nextEntry != null) {
            return true;
        }
        while (true) {
            if (this.nextEntry == null) {
                while (this.position < this.this$0.elementData.length) {
                    if ((this.nextEntry = this.this$0.elementData[this.position++]) != null) break;
                }
                if (this.nextEntry == null) {
                    return false;
                }
            }
            this.nextKey = this.nextEntry.get();
            if (this.nextKey != null || this.nextEntry.isNull) {
                return true;
            }
            this.nextEntry = this.nextEntry.next;
        }
    }

    @Override
    public Object next() {
        if (this.expectedModCount == this.this$0.modCount) {
            if (this.hasNext()) {
                this.currentEntry = this.nextEntry;
                this.nextEntry = this.currentEntry.next;
                Object object = this.type.get(this.currentEntry);
                this.nextKey = null;
                return object;
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void remove() {
        if (this.expectedModCount != this.this$0.modCount) throw new ConcurrentModificationException();
        if (this.currentEntry == null) throw new IllegalStateException();
        this.this$0.removeEntry(this.currentEntry);
        this.currentEntry = null;
        ++this.expectedModCount;
    }
}

