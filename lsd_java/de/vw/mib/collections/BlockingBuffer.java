/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.Buffer;
import de.vw.mib.collections.RingBuffer;
import java.util.Collection;
import java.util.Iterator;

public final class BlockingBuffer
implements Collection,
Buffer {
    private final RingBuffer buffer;
    private int waitingNumber;

    public BlockingBuffer(int n) {
        this.buffer = new RingBuffer(n);
        this.waitingNumber = 0;
    }

    @Override
    public synchronized boolean add(Object object) {
        this.waitUntilBufferIsNotFull();
        return this.push(object);
    }

    public synchronized boolean add(Object object, long l) {
        if (this.waitIfBufferIsFull(l)) {
            return this.push(object);
        }
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    public synchronized boolean push(Object object) {
        boolean bl = this.buffer.add(object);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    public synchronized boolean pushAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.push(iterator.next());
        }
        return true;
    }

    @Override
    public synchronized boolean offer(Object object) {
        boolean bl = this.buffer.offer(object);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    @Override
    public synchronized boolean offerAll(Collection collection) {
        boolean bl = this.buffer.offerAll(collection);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    @Override
    public synchronized void clear() {
        if (!this.buffer.isEmpty()) {
            this.buffer.clear();
            this.notifyWaiting();
        }
    }

    @Override
    public synchronized boolean contains(Object object) {
        return this.buffer.contains(object);
    }

    @Override
    public synchronized boolean containsAll(Collection collection) {
        return this.buffer.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.buffer.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return this.buffer.iterator();
    }

    @Override
    public synchronized boolean remove(Object object) {
        boolean bl = this.buffer.remove(object);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    public synchronized boolean removePos(int n) {
        boolean bl = this.buffer.removePos(n);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    @Override
    public synchronized boolean removeAll(Collection collection) {
        boolean bl = this.buffer.removeAll(collection);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    public synchronized boolean removeAllOccurrences(Object object) {
        boolean bl = this.buffer.removeAllOccurrences(object);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    @Override
    public synchronized boolean retainAll(Collection collection) {
        boolean bl = this.buffer.retainAll(collection);
        if (bl) {
            this.notifyWaiting();
        }
        return bl;
    }

    @Override
    public int size() {
        return this.buffer.size();
    }

    @Override
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override
    public synchronized Object[] toArray() {
        return this.buffer.toArray();
    }

    @Override
    public synchronized Object[] toArray(Object[] objectArray) {
        return this.buffer.toArray(objectArray);
    }

    public synchronized Object get(int n) {
        return this.buffer.get(n);
    }

    @Override
    public synchronized Object getNewest() {
        this.waitUntilBufferIsNotEmpty();
        return this.buffer.getNewest();
    }

    public synchronized Object getNewest(long l) {
        if (this.waitIfBufferIsEmpty(l)) {
            return this.buffer.getNewest();
        }
        return null;
    }

    @Override
    public synchronized Object getOldest() {
        this.waitUntilBufferIsNotEmpty();
        return this.buffer.getOldest();
    }

    public synchronized Object getOldest(long l) {
        if (this.waitIfBufferIsEmpty(l)) {
            return this.buffer.getOldest();
        }
        return null;
    }

    @Override
    public synchronized Object popNewest() {
        this.waitUntilBufferIsNotEmpty();
        return this.popNewestInternal();
    }

    public synchronized Object popNewest(long l) {
        if (this.waitIfBufferIsEmpty(l)) {
            return this.popNewestInternal();
        }
        return null;
    }

    private Object popNewestInternal() {
        Object object = this.buffer.popNewest();
        this.notifyWaiting();
        return object;
    }

    @Override
    public synchronized Object popOldest() {
        this.waitUntilBufferIsNotEmpty();
        return this.popOldestInternal();
    }

    public synchronized Object popOldest(long l) {
        if (this.waitIfBufferIsEmpty(l)) {
            return this.popOldestInternal();
        }
        return null;
    }

    private Object popOldestInternal() {
        Object object = this.buffer.popOldest();
        this.notifyWaiting();
        return object;
    }

    public synchronized String toString() {
        return this.buffer.toString();
    }

    private void notifyWaiting() {
        if (this.waitingNumber > 0) {
            super.notifyAll();
        }
    }

    private void waitUntilBufferIsNotFull() {
        this.waitUntilBufferSizeIsNotEqualsTo(this.buffer.capacity());
    }

    private void waitUntilBufferIsNotEmpty() {
        this.waitUntilBufferSizeIsNotEqualsTo(0);
    }

    private void waitUntilBufferSizeIsNotEqualsTo(int n) {
        while (!this.waitIfBufferSizeEquals(n, 0L)) {
        }
    }

    private boolean waitIfBufferIsFull(long l) {
        return this.waitIfBufferSizeEquals(this.buffer.capacity(), l);
    }

    private boolean waitIfBufferIsEmpty(long l) {
        return this.waitIfBufferSizeEquals(0, l);
    }

    private boolean waitIfBufferSizeEquals(int n, long l) {
        if (this.buffer.size() == n) {
            ++this.waitingNumber;
            this.waitIgnoreInterruptedException(l);
            --this.waitingNumber;
        }
        return this.buffer.size() != n;
    }

    private void waitIgnoreInterruptedException(long l) {
        try {
            super.wait(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

