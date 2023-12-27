/*
 * Decompiled with CFR 0.152.
 */
package java.lang.ref;

import java.lang.ref.Reference;

public class ReferenceQueue {
    private Reference[] references = new Reference[128];
    private int head = 0;
    private int tail = 0;
    private boolean empty = true;
    private static final int DEFAULT_QUEUE_SIZE;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Reference poll() {
        Reference reference;
        ReferenceQueue referenceQueue = this;
        synchronized (referenceQueue) {
            if (this.empty) {
                return null;
            }
            reference = this.references[this.head];
            this.references[this.head++] = null;
            reference.dequeue();
            if (this.head == this.references.length) {
                this.head = 0;
            }
            if (this.head == this.tail) {
                this.empty = true;
            }
        }
        return reference;
    }

    public Reference remove() {
        return this.remove(0L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Reference remove(long l) {
        Reference reference;
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        ReferenceQueue referenceQueue = this;
        synchronized (referenceQueue) {
            if (this.empty) {
                super.wait(l);
                if (this.empty) {
                    return null;
                }
            }
            reference = this.references[this.head];
            this.references[this.head++] = null;
            reference.dequeue();
            if (this.head == this.references.length) {
                this.head = 0;
            }
            if (this.head == this.tail) {
                this.empty = true;
            } else {
                super.notifyAll();
            }
        }
        return reference;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean enqueue(Reference reference) {
        ReferenceQueue referenceQueue = this;
        synchronized (referenceQueue) {
            if (!this.empty && this.head == this.tail) {
                int n = (int)((double)this.references.length * 1.1);
                Reference[] referenceArray = new Reference[n];
                System.arraycopy((Object)this.references, this.head, (Object)referenceArray, 0, this.references.length - this.head);
                if (this.tail > 0) {
                    System.arraycopy((Object)this.references, 0, (Object)referenceArray, this.references.length - this.head, this.tail);
                }
                this.head = 0;
                this.tail = this.references.length;
                this.references = referenceArray;
            }
            this.references[this.tail++] = reference;
            if (this.tail == this.references.length) {
                this.tail = 0;
            }
            this.empty = false;
            super.notifyAll();
        }
        return true;
    }
}

