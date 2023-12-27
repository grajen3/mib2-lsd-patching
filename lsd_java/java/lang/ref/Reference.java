/*
 * Decompiled with CFR 0.152.
 */
package java.lang.ref;

import java.lang.ref.ReferenceQueue;

public abstract class Reference {
    private Object referent;
    private ReferenceQueue queue;
    private boolean enqueued;

    public void clear() {
        this.referent = null;
    }

    public boolean enqueue() {
        return this.enqueueImpl();
    }

    public Object get() {
        return this.referent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isEnqueued() {
        Reference reference = this;
        synchronized (reference) {
            return this.enqueued;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean enqueueImpl() {
        Reference reference = this;
        synchronized (reference) {
            ReferenceQueue referenceQueue;
            block5: {
                referenceQueue = this.queue;
                this.queue = null;
                if (!this.enqueued && referenceQueue != null) break block5;
                return false;
            }
            boolean bl = referenceQueue.enqueue(this);
            if (bl) {
                this.enqueued = true;
            }
            return bl;
        }
    }

    Reference() {
    }

    void initReference(Object object) {
        this.initReferenceImpl(object);
    }

    void initReference(Object object, ReferenceQueue referenceQueue) {
        this.queue = referenceQueue;
        this.enqueued = false;
        this.initReferenceImpl(object);
    }

    private final native void initReferenceImpl(Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void dequeue() {
        Reference reference = this;
        synchronized (reference) {
            this.enqueued = false;
        }
    }
}

