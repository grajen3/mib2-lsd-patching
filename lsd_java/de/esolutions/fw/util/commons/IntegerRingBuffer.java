/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

public class IntegerRingBuffer {
    private int[] buffer;
    private int size = 0;
    private int startIdx = 0;
    private int endIdx = 0;

    public IntegerRingBuffer(int n) {
        this.buffer = new int[n];
    }

    public int getCapacity() {
        return this.buffer.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void put(int n) {
        this.buffer[this.endIdx] = n;
        if (this.size == this.getCapacity()) {
            ++this.startIdx;
            ++this.endIdx;
        } else {
            ++this.endIdx;
            ++this.size;
        }
        this.startIdx %= this.getCapacity();
        this.endIdx %= this.getCapacity();
    }

    public int get(int n) {
        if (n < this.size) {
            int n2 = (this.startIdx + n) % this.getCapacity();
            return this.buffer[n2];
        }
        throw new IndexOutOfBoundsException(new StringBuffer().append("Index out of bounds (size=").append(this.size).append(", index=").append(n).append(")").toString());
    }
}

