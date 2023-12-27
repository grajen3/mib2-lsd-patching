/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.util.StringBuilder;
import java.util.NoSuchElementException;

public final class ArrayDeque {
    private static final int MIN_INITIAL_CAPACITY;
    private transient Object[] elements;
    private transient int head;
    private transient int tail;
    private int nrOfPollFirstEntries = 0;
    private int nrOfPollFirstExits = 0;

    public ArrayDeque(int n) {
        this.allocateElements(n);
    }

    public void offerLast(Object object) {
        if (object == null) {
            throw new NullPointerException(this.toString());
        }
        this.elements[this.tail] = object;
        this.tail = this.tail + 1 & this.elements.length - 1;
        if (this.tail == this.head) {
            this.doubleCapacity();
        }
    }

    public Object pollFirst() {
        ++this.nrOfPollFirstEntries;
        int n = this.head;
        Object object = this.elements[n];
        if (object == null) {
            throw new NoSuchElementException(this.toString());
        }
        this.elements[n] = null;
        this.head = n + 1 & this.elements.length - 1;
        ++this.nrOfPollFirstExits;
        return object;
    }

    public int size() {
        return this.tail - this.head & this.elements.length - 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ArrayDeque - ");
        stringBuilder.append("head: ").append(this.head);
        stringBuilder.append(", tail: ").append(this.tail);
        stringBuilder.append(", size: ").append(this.size());
        stringBuilder.append(", elements.length: ").append(this.elements.length);
        stringBuilder.append(" -X: ");
        boolean bl = true;
        int n = 0;
        for (int i2 = 0; i2 < this.elements.length; ++i2) {
            if (bl) {
                if (this.elements[i2] != null) {
                    stringBuilder.append(' ').append(n);
                    n = 1;
                    bl = false;
                    continue;
                }
                ++n;
                continue;
            }
            if (this.elements[i2] == null) {
                stringBuilder.append(' ').append(n);
                n = 1;
                bl = true;
                continue;
            }
            ++n;
        }
        stringBuilder.append(' ').append(n);
        stringBuilder.append(" pfIn: ").append(this.nrOfPollFirstEntries);
        stringBuilder.append(" pfOut: ").append(this.nrOfPollFirstExits);
        return stringBuilder.toString();
    }

    private void allocateElements(int n) {
        int n2 = 8;
        if (n >= n2) {
            n2 = n;
            n2 |= n2 >>> 1;
            n2 |= n2 >>> 2;
            n2 |= n2 >>> 4;
            n2 |= n2 >>> 8;
            n2 |= n2 >>> 16;
            if (++n2 < 0) {
                n2 >>>= 1;
            }
        }
        this.elements = new Object[n2];
    }

    private void doubleCapacity() {
        throw new UnsupportedOperationException("Won't double capacity!");
    }
}

