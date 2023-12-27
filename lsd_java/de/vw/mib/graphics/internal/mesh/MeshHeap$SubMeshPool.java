/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class MeshHeap$SubMeshPool
extends AbstractUnsynchronizedObjectPool {
    public MeshHeap$SubMeshPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new MeshHeap$SubMesh(this);
    }
}

