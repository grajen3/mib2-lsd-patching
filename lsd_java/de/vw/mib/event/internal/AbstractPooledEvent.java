/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.pool.PooledObject;

public abstract class AbstractPooledEvent
extends AbstractEvent
implements PooledObject {
    EventPool pool;

    AbstractPooledEvent(EventPool eventPool) {
        this.pool = eventPool;
    }

    @Override
    public final void releaseEvent() {
        super.releaseEvent();
        this.pool.releaseObject(this);
    }
}

