/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.data;

import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;
import de.vw.mib.widgets.speller.data.SpellerDataAdapter;

final class SpellerDataAdapter$SpellerDataAdapterPool
extends AbstractUnsynchronizedObjectPool {
    private static final int POOL_SIZE;

    public SpellerDataAdapter$SpellerDataAdapterPool() {
        super(4);
    }

    @Override
    protected PooledObject createObjectInternal() {
        SpellerDataAdapter spellerDataAdapter = new SpellerDataAdapter();
        return spellerDataAdapter;
    }
}

