/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.RangePacker$Chunk;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class RangePacker$ChunkPool
extends AbstractUnsynchronizedObjectPool {
    protected RangePacker$ChunkPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new RangePacker$Chunk();
    }

    protected RangePacker$Chunk borrowChunk(int n, int n2) {
        RangePacker$Chunk rangePacker$Chunk = (RangePacker$Chunk)this.borrowObject();
        rangePacker$Chunk.position = n;
        rangePacker$Chunk.range = n2;
        return rangePacker$Chunk;
    }
}

