/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$HashEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$Segment;
import java.util.NoSuchElementException;

abstract class ConcurrentHashMap$HashIterator {
    int nextSegmentIndex;
    int nextTableIndex;
    ConcurrentHashMap$HashEntry[] currentTable;
    ConcurrentHashMap$HashEntry nextEntry;
    ConcurrentHashMap$HashEntry lastReturned;
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$HashIterator(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
        this.nextSegmentIndex = concurrentHashMap.segments.length - 1;
        this.nextTableIndex = -1;
        this.advance();
    }

    public boolean hasMoreElements() {
        return this.hasNext();
    }

    final void advance() {
        if (this.nextEntry != null && (this.nextEntry = this.nextEntry.next) != null) {
            return;
        }
        while (this.nextTableIndex >= 0) {
            if ((this.nextEntry = this.currentTable[this.nextTableIndex--]) == null) continue;
            return;
        }
        while (this.nextSegmentIndex >= 0) {
            ConcurrentHashMap$Segment concurrentHashMap$Segment = this.this$0.segments[this.nextSegmentIndex--];
            if (concurrentHashMap$Segment.count == 0) continue;
            this.currentTable = concurrentHashMap$Segment.table;
            for (int i2 = this.currentTable.length - 1; i2 >= 0; --i2) {
                this.nextEntry = this.currentTable[i2];
                if (this.nextEntry == null) continue;
                this.nextTableIndex = i2 - 1;
                return;
            }
        }
    }

    public boolean hasNext() {
        return this.nextEntry != null;
    }

    ConcurrentHashMap$HashEntry nextEntry() {
        if (this.nextEntry == null) {
            throw new NoSuchElementException();
        }
        this.lastReturned = this.nextEntry;
        this.advance();
        return this.lastReturned;
    }

    public void remove() {
        if (this.lastReturned == null) {
            throw new IllegalStateException();
        }
        this.this$0.remove(this.lastReturned.key);
        this.lastReturned = null;
    }
}

