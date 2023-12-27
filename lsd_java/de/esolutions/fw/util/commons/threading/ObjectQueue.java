/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class ObjectQueue {
    private Object[] queue;
    private int capacity;
    private int size;
    private int head;
    private int tail;
    private final ITimeSource monoTime;

    public ObjectQueue(int n) {
        this.capacity = n > 0 ? n : 1;
        this.queue = new Object[n];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.monoTime = TimeSourceProvider.getMonotonicTimeSource();
    }

    public synchronized int getCapacity() {
        return this.capacity;
    }

    public synchronized int getSize() {
        return this.size;
    }

    public synchronized boolean isEmpty() {
        return this.size == 0;
    }

    public synchronized boolean isFull() {
        return this.size == this.capacity;
    }

    public synchronized void add(Object object) {
        this.waitWhileFull();
        this.queue[this.head] = object;
        this.head = (this.head + 1) % this.capacity;
        ++this.size;
        super.notifyAll();
    }

    public synchronized void addEach(Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            this.add(objectArray[i2]);
        }
    }

    public synchronized Object remove() {
        this.waitWhileEmpty();
        Object object = this.queue[this.tail];
        this.queue[this.tail] = null;
        this.tail = (this.tail + 1) % this.capacity;
        --this.size;
        super.notifyAll();
        return object;
    }

    public synchronized Object[] removeAll() {
        Object[] objectArray = new Object[this.size];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = this.remove();
        }
        return objectArray;
    }

    public synchronized Object[] removeAtLeastOne() {
        this.waitWhileEmpty();
        return this.removeAll();
    }

    public synchronized boolean waitUntilEmpty(long l) {
        if (l == 0L) {
            this.waitUntilEmpty();
            return true;
        }
        long l2 = this.monoTime.getCurrentTime() + l;
        long l3 = l;
        while (!this.isEmpty() && l3 > 0L) {
            super.wait(l3);
            l3 = l2 - this.monoTime.getCurrentTime();
        }
        return this.isEmpty();
    }

    public synchronized void waitUntilEmpty() {
        while (!this.isEmpty()) {
            super.wait();
        }
    }

    public synchronized void waitWhileEmpty() {
        while (this.isEmpty()) {
            super.wait();
        }
    }

    public synchronized void waitUntilFull() {
        while (!this.isFull()) {
            super.wait();
        }
    }

    public synchronized void waitWhileFull() {
        while (this.isFull()) {
            super.wait();
        }
    }
}

