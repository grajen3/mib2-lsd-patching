/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;

final class ConcurrentSkipListMap$Node {
    final Object key;
    volatile Object value;
    volatile ConcurrentSkipListMap$Node next;

    ConcurrentSkipListMap$Node(Object object, Object object2, ConcurrentSkipListMap$Node concurrentSkipListMap$Node) {
        this.key = object;
        this.value = object2;
        this.next = concurrentSkipListMap$Node;
    }

    ConcurrentSkipListMap$Node(ConcurrentSkipListMap$Node concurrentSkipListMap$Node) {
        this.key = null;
        this.value = this;
        this.next = concurrentSkipListMap$Node;
    }

    synchronized boolean casValue(Object object, Object object2) {
        if (this.value == object) {
            this.value = object2;
            return true;
        }
        return false;
    }

    synchronized boolean casNext(ConcurrentSkipListMap$Node concurrentSkipListMap$Node, ConcurrentSkipListMap$Node concurrentSkipListMap$Node2) {
        if (this.next == concurrentSkipListMap$Node) {
            this.next = concurrentSkipListMap$Node2;
            return true;
        }
        return false;
    }

    boolean isMarker() {
        return this.value == this;
    }

    boolean isBaseHeader() {
        return this.value == ConcurrentSkipListMap.access$000();
    }

    boolean appendMarker(ConcurrentSkipListMap$Node concurrentSkipListMap$Node) {
        return this.casNext(concurrentSkipListMap$Node, new ConcurrentSkipListMap$Node(concurrentSkipListMap$Node));
    }

    void helpDelete(ConcurrentSkipListMap$Node concurrentSkipListMap$Node, ConcurrentSkipListMap$Node concurrentSkipListMap$Node2) {
        if (concurrentSkipListMap$Node2 == this.next && this == concurrentSkipListMap$Node.next) {
            if (concurrentSkipListMap$Node2 == null || concurrentSkipListMap$Node2.value != concurrentSkipListMap$Node2) {
                this.appendMarker(concurrentSkipListMap$Node2);
            } else {
                concurrentSkipListMap$Node.casNext(this, concurrentSkipListMap$Node2.next);
            }
        }
    }

    Object getValidValue() {
        Object object = this.value;
        if (object == this || object == ConcurrentSkipListMap.access$000()) {
            return null;
        }
        return object;
    }

    AbstractMap$SimpleImmutableEntry createSnapshot() {
        Object object = this.getValidValue();
        if (object == null) {
            return null;
        }
        return new AbstractMap$SimpleImmutableEntry(this.key, object);
    }
}

