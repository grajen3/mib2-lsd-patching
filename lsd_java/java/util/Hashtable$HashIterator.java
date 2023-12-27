/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ConcurrentModificationException;
import java.util.Hashtable;
import java.util.Hashtable$Entry;
import java.util.Iterator;
import java.util.MapEntry$Type;
import java.util.NoSuchElementException;

final class Hashtable$HashIterator
implements Iterator {
    private int position;
    private int expectedModCount;
    private MapEntry$Type type;
    private Hashtable$Entry lastEntry;
    private int lastPosition;
    private boolean canRemove = false;
    final /* synthetic */ Hashtable this$0;

    Hashtable$HashIterator(Hashtable hashtable, MapEntry$Type mapEntry$Type) {
        this.this$0 = hashtable;
        this.type = mapEntry$Type;
        this.position = hashtable.lastSlot;
        this.expectedModCount = hashtable.modCount;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean hasNext() {
        if (this.lastEntry == null || this.lastEntry.next == null) ** GOTO lbl7
        return true;
lbl-1000:
        // 1 sources

        {
            if (this.this$0.elementData[this.position] == null) {
                --this.position;
                continue;
            }
            return true;
lbl7:
            // 2 sources

            ** while (this.position >= this.this$0.firstSlot)
        }
lbl8:
        // 1 sources

        return false;
    }

    @Override
    public Object next() {
        if (this.expectedModCount == this.this$0.modCount) {
            if (this.lastEntry != null) {
                this.lastEntry = this.lastEntry.next;
            }
            if (this.lastEntry == null) {
                while (this.position >= this.this$0.firstSlot && (this.lastEntry = this.this$0.elementData[this.position]) == null) {
                    --this.position;
                }
                if (this.lastEntry != null) {
                    this.lastPosition = this.position--;
                }
            }
            if (this.lastEntry != null) {
                this.canRemove = true;
                return this.type.get(this.lastEntry);
            }
            throw new NoSuchElementException();
        }
        throw new ConcurrentModificationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void remove() {
        if (this.expectedModCount != this.this$0.modCount) throw new ConcurrentModificationException();
        if (!this.canRemove) throw new IllegalStateException();
        this.canRemove = false;
        Hashtable hashtable = this.this$0;
        synchronized (hashtable) {
            boolean bl = false;
            Hashtable$Entry hashtable$Entry = this.this$0.elementData[this.lastPosition];
            if (hashtable$Entry == this.lastEntry) {
                this.this$0.elementData[this.lastPosition] = hashtable$Entry.next;
                bl = true;
            } else {
                while (true) {
                    if (hashtable$Entry == null || hashtable$Entry.next == this.lastEntry) {
                        if (hashtable$Entry == null) break;
                        hashtable$Entry.next = this.lastEntry.next;
                        bl = true;
                        break;
                    }
                    hashtable$Entry = hashtable$Entry.next;
                }
            }
            if (!bl) throw new ConcurrentModificationException();
            ++this.this$0.modCount;
            --this.this$0.elementCount;
            ++this.expectedModCount;
            return;
        }
    }
}

