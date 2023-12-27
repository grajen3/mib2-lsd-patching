/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.util.RangePacker;

final class MeshHeap$SubMeshCache
extends LRUCache {
    private final MeshHeap meshHeap;
    private final RangePacker vertexRP;
    private final RangePacker indexRP;

    public MeshHeap$SubMeshCache(MeshHeap meshHeap, RangePacker rangePacker, RangePacker rangePacker2) {
        super(new UnlimitedCachingPolicy(), true);
        this.meshHeap = meshHeap;
        this.vertexRP = rangePacker;
        this.indexRP = rangePacker2;
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return !this.meshHeap.isSubMeshLocked((MeshHeap$SubMesh)abstractCache$Entry.getValue());
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        MeshHeap$SubMesh meshHeap$SubMesh = (MeshHeap$SubMesh)abstractCache$Entry.getValue();
        this.vertexRP.remove(meshHeap$SubMesh.getMinVertex());
        if (meshHeap$SubMesh.isIndexed()) {
            this.indexRP.remove(meshHeap$SubMesh.getStartIndex());
        }
        this.meshHeap.fireSubMeshRemoved(meshHeap$SubMesh);
        meshHeap$SubMesh.dispose();
        super.evict(abstractCache$Entry);
    }
}

