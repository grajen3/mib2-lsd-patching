/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.RangePacker$RangePackerListEntry;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class RangePacker$ListEntryPool
extends AbstractUnsynchronizedObjectPool {
    protected RangePacker$ListEntryPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new RangePacker$RangePackerListEntry();
    }
}

