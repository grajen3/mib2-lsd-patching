/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import java.util.Arrays;

public abstract class AbstractSimpleIntMap {
    protected static final int DEFAULT_SIZE;
    protected static final int FREE_ENTRY_MARKER;
    private final Object mutex = new Object();
    private int capacity;
    private int mappings = 0;
    protected int[] keys;
    private int nextFreeIndex = 0;

    public AbstractSimpleIntMap(int n) {
        this.capacity = n;
        this.keys = new int[this.capacity];
        Arrays.fill(this.keys, 128);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void resize(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n != this.capacity) {
                this.resizeKeyArray(n);
                this.resizeValueArray(n);
                if (n < this.capacity) {
                    int n2 = 0;
                    int n3 = n;
                    for (int i2 = this.keys.length; i2 >= 0; --i2) {
                        if (this.keys[i2] != 128) {
                            ++n2;
                            continue;
                        }
                        n3 = i2;
                    }
                    this.mappings = n2;
                    this.nextFreeIndex = n3;
                } else if (this.nextFreeIndex > this.capacity) {
                    this.nextFreeIndex = this.capacity;
                }
                this.capacity = n;
            }
        }
    }

    private void resizeKeyArray(int n) {
        int[] nArray = new int[n];
        if (n > this.keys.length) {
            System.arraycopy((Object)this.keys, 0, (Object)nArray, 0, this.keys.length);
            Arrays.fill(nArray, this.keys.length, nArray.length, 128);
            this.keys = nArray;
        } else if (n < this.keys.length) {
            System.arraycopy((Object)this.keys, 0, (Object)nArray, 0, nArray.length);
            this.keys = nArray;
        }
    }

    protected abstract void resizeValueArray(int n) {
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int size() {
        return this.mappings;
    }

    public boolean isEmpty() {
        return this.mappings == 0;
    }

    public void clear() {
        this.clearKeys();
        this.clearValues();
        this.mappings = 0;
        this.nextFreeIndex = 0;
    }

    private void clearKeys() {
        Arrays.fill(this.keys, 128);
    }

    protected void clearKey(int n) {
        this.keys[n] = 128;
    }

    protected abstract void clearValues() {
    }

    protected abstract void clearValue(int n) {
    }

    public int[] getKeys() {
        int[] nArray = new int[this.mappings];
        int n = 0;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] == 128) continue;
            nArray[n] = this.keys[i2];
            ++n;
        }
        return nArray;
    }

    protected int getKeyIndex(int n) {
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    protected int addKey(int n) {
        int n2 = this.getKeyIndex(n);
        if (n2 == -1) {
            if (this.nextFreeIndex >= this.capacity) {
                if (this.capacity < 2) {
                    this.resize(2);
                } else {
                    this.resize(this.capacity + this.capacity / 2);
                }
            }
            n2 = this.nextFreeIndex;
            this.keys[n2] = n;
            ++this.mappings;
            this.nextFreeIndex = this.getKeyIndex(128);
            if (this.nextFreeIndex == -1) {
                this.nextFreeIndex = this.capacity;
            }
        }
        return n2;
    }

    public void remove(int n) {
        int n2 = this.getKeyIndex(n);
        if (n2 != -1) {
            this.clearKey(n2);
            this.clearValue(n2);
            --this.mappings;
            if (n2 < this.nextFreeIndex) {
                this.nextFreeIndex = n2;
            }
        }
    }

    protected final void checkFreeEntryMarker(int n) {
        if (n == 128) {
            throw new IllegalArgumentException("Free entry marker is used as key or value!");
        }
    }
}

