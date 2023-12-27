/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.util;

import de.vw.mib.threads.MIBThread;
import edu.emory.mathcs.backport.java.util.ArrayDeque;

public final class Queue
extends ArrayDeque {
    private static final long serialVersionUID;
    private transient MIBThread thread;

    public Queue(int n) {
        super(n);
    }

    @Override
    public synchronized boolean add(Object object) {
        super.add(object);
        this.thread.resume();
        return true;
    }

    @Override
    public synchronized Object poll() {
        return super.poll();
    }

    public synchronized void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
    }
}

