/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.RangePacker$RangePackerListEntry;
import de.vw.mib.pool.PooledObject;

final class RangePacker$Chunk
implements PooledObject {
    protected int position;
    protected int range;
    protected RangePacker$RangePackerListEntry binEntry;
    protected RangePacker$RangePackerListEntry chunkEntry;

    @Override
    public void backToPool() {
        this.binEntry = null;
        this.chunkEntry = null;
    }
}

