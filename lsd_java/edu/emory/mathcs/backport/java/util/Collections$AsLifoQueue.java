/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.Queue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

class Collections$AsLifoQueue
extends AbstractQueue
implements Queue,
Serializable {
    final Deque deque;

    Collections$AsLifoQueue(Deque deque) {
        this.deque = deque;
    }

    @Override
    public boolean add(Object object) {
        return this.deque.offerFirst(object);
    }

    @Override
    public boolean offer(Object object) {
        return this.deque.offerFirst(object);
    }

    @Override
    public Object remove() {
        return this.deque.removeFirst();
    }

    @Override
    public Object poll() {
        return this.deque.pollFirst();
    }

    @Override
    public Object element() {
        return this.deque.getFirst();
    }

    @Override
    public Object peek() {
        return this.deque.peekFirst();
    }

    @Override
    public int size() {
        return this.deque.size();
    }

    @Override
    public void clear() {
        this.deque.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.deque.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return this.deque.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.deque.toArray(objectArray);
    }

    @Override
    public boolean contains(Object object) {
        return this.deque.contains(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.deque.remove(object);
    }

    @Override
    public Iterator iterator() {
        return this.deque.iterator();
    }

    @Override
    public String toString() {
        return this.deque.toString();
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.deque.containsAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.deque.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.deque.retainAll(collection);
    }
}

