/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.graphics.internal.scene.renderer.queue.RenderQueue$PooledGeometry;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class RenderQueue$GeometryPool
extends AbstractUnsynchronizedObjectPool {
    public RenderQueue$GeometryPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new RenderQueue$PooledGeometry(this);
    }
}

