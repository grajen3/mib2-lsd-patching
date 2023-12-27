/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import javax.media.opengl.GLException;

public class GLContextLock {
    private Object lock = new Object();
    private Thread owner;
    private boolean failFastMode = true;
    private volatile int waiters;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void lock() {
        Object object = this.lock;
        synchronized (object) {
            Thread thread = Thread.currentThread();
            if (this.owner == null) {
                this.owner = thread;
            } else if (this.owner != thread) {
                while (this.owner != null) {
                    if (this.failFastMode) {
                        throw new GLException(new StringBuffer().append("Attempt to make context current on thread ").append(thread).append(" which is already current on thread ").append(this.owner).toString());
                    }
                    try {
                        ++this.waiters;
                        this.lock.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        throw new GLException(interruptedException);
                    }
                    finally {
                        --this.waiters;
                    }
                }
                this.owner = thread;
            } else {
                throw new GLException(new StringBuffer().append("Attempt to make the same context current twice on thread ").append(thread).toString());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unlock() {
        Object object = this.lock;
        synchronized (object) {
            Thread thread = Thread.currentThread();
            if (this.owner != thread) {
                if (this.owner != null) {
                    throw new GLException(new StringBuffer().append("Attempt by thread ").append(thread).append(" to release context owned by thread ").append(this.owner).toString());
                }
                throw new GLException(new StringBuffer().append("Attempt by thread ").append(thread).append(" to release unowned context").toString());
            }
            this.owner = null;
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isHeld() {
        Object object = this.lock;
        synchronized (object) {
            Thread thread = Thread.currentThread();
            return this.owner == thread;
        }
    }

    public void setFailFastMode(boolean bl) {
        this.failFastMode = bl;
    }

    public boolean getFailFastMode() {
        return this.failFastMode;
    }

    public boolean hasWaiters() {
        return this.waiters != 0;
    }
}

