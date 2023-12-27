/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;
import de.vw.mib.timer.internal.TimerTask;

final class TimerTaskFactory
extends AbstractUnsynchronizedObjectPool {
    TimerTaskFactory(int n) {
        super(n);
    }

    TimerTask getTimerTask() {
        return (TimerTask)this.borrowObject();
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new TimerTask(this);
    }
}

