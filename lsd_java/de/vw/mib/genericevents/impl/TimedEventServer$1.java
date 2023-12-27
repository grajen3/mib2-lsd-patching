/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.impl.TimedEvent;
import de.vw.mib.genericevents.impl.TimedEventServer;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

class TimedEventServer$1
extends AbstractSynchronizedObjectPool {
    private final /* synthetic */ TimedEventServer this$0;

    TimedEventServer$1(TimedEventServer timedEventServer, int n) {
        this.this$0 = timedEventServer;
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new TimedEvent(this.this$0);
    }
}

