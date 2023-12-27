/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.RectanglePacker$Divider;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class RectanglePacker$DividerPool
extends AbstractUnsynchronizedObjectPool {
    public RectanglePacker$DividerPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new RectanglePacker$Divider(this);
    }
}

