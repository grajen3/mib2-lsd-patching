/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.StringValueEventImpl;
import de.vw.mib.pool.PooledObject;

class EventFactory$23
extends EventPool {
    private final /* synthetic */ EventFactory this$0;

    EventFactory$23(EventFactory eventFactory, int n) {
        this.this$0 = eventFactory;
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new StringValueEventImpl(this);
    }
}

