/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

public class RingBuffer {
    private int begin;
    private int end;
    private int capacity;
    private int size;
    private Object[] data;

    public RingBuffer(int n) {
        this.capacity = n;
        this.data = new Object[n];
        this.begin = 0;
        this.end = 0;
        this.size = 0;
    }

    public boolean resize(int n) {
        if (this.size > n) {
            return false;
        }
        int n2 = this.capacity;
        Object[] objectArray = this.data;
        int n3 = this.begin;
        int n4 = this.size;
        this.capacity = n;
        this.data = new Object[n];
        this.size = 0;
        this.begin = 0;
        this.end = 0;
        if (n4 > 0) {
            for (int i2 = 0; i2 < n4; ++i2) {
                int n5 = (n3 + i2) % n2;
                this.put(objectArray[n5]);
                objectArray[n5] = null;
            }
        }
        return true;
    }

    public boolean drop(int n) {
        if (this.size < n) {
            return false;
        }
        this.begin = (this.begin + n) % this.capacity;
        this.size -= n;
        return true;
    }

    public void dropAll() {
        while (this.size >= 0) {
            this.data[this.begin] = null;
            ++this.begin;
            if (this.begin == this.capacity) {
                this.begin = 0;
            }
            --this.size;
        }
        this.size = 0;
    }

    public Object peekNext() {
        return this.data[this.end];
    }

    public boolean put(Object object) {
        boolean bl = this.size < this.capacity;
        this.data[this.end] = object;
        ++this.end;
        if (this.end == this.capacity) {
            this.end = 0;
        }
        if (!bl) {
            this.begin = this.end;
        } else {
            ++this.size;
        }
        return bl;
    }

    public Object getOldest() {
        if (this.size == 0) {
            return null;
        }
        Object object = this.data[this.begin];
        this.data[this.begin] = null;
        ++this.begin;
        if (this.begin == this.capacity) {
            this.begin = 0;
        }
        --this.size;
        return object;
    }

    public Object peekOldest() {
        if (this.size == 0) {
            return null;
        }
        return this.data[this.begin];
    }

    public Object peekAt(int n) {
        if (this.size == 0) {
            return null;
        }
        int n2 = (this.begin + n) % this.capacity;
        return this.data[n2];
    }

    public Object peekNewest() {
        if (this.size == 0) {
            return null;
        }
        int n = this.end == 0 ? this.capacity - 1 : (this.end - 1) % this.capacity;
        return this.data[n];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }
}

