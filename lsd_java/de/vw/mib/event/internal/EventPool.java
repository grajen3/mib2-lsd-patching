/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

public abstract class EventPool
extends AbstractSynchronizedObjectPool {
    public EventPool(int n) {
        super(n);
    }

    public int getMaxSize() {
        return this.stack.length;
    }
}

