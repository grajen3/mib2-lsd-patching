/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.RotationEventImpl;
import de.vw.mib.pool.PooledObject;

class EventFactory$18
extends EventPool {
    private final /* synthetic */ EventFactory this$0;

    EventFactory$18(EventFactory eventFactory, int n) {
        this.this$0 = eventFactory;
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new RotationEventImpl(this);
    }
}

