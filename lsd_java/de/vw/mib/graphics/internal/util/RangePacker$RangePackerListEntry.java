/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.collections.AbstractLinkedList$ListEntry;
import de.vw.mib.graphics.internal.util.RangePacker$Chunk;
import de.vw.mib.pool.PooledObject;

class RangePacker$RangePackerListEntry
extends AbstractLinkedList$ListEntry
implements PooledObject {
    protected RangePacker$Chunk chunk;

    @Override
    public void backToPool() {
        this.chunk = null;
    }
}

