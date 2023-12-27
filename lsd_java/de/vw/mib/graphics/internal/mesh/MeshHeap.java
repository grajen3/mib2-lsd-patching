/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.mesh.MeshHeap$MeshHeapListener;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMeshCache;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMeshPool;
import de.vw.mib.graphics.internal.util.RangePacker;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;

public final class MeshHeap
extends AbstractResource {
    private static final int SUBMESH_POOL_MAXIMUM_CAPACITY;
    protected static final MeshHeap$SubMeshPool SUBMESH_POOL;
    private final VertexBuffer vertexBuffer;
    private final RangePacker vertexRangePacker;
    private final IndexBuffer indexBuffer;
    private final RangePacker indexRangePacker;
    private final Mesh mesh;
    private final MeshHeap$SubMeshCache subMeshCache;
    private static final int LOCKED_SUBMESHES_MAP_INITIAL_CAPACITY;
    private final LongObjectMap lockedSubMeshes;
    private CowList listeners;

    public MeshHeap(Graphics3D graphics3D, Logger logger, VertexFormat vertexFormat, int n) {
        this(graphics3D, logger, vertexFormat, n, 0, 0);
    }

    public MeshHeap(Graphics3D graphics3D, Logger logger, VertexFormat vertexFormat, int n, int n2, int n3) {
        super(graphics3D, logger);
        this.vertexBuffer = this.createVertexBuffer(vertexFormat, n);
        this.vertexRangePacker = new RangePacker(n);
        this.indexBuffer = n3 > 0 ? this.createIndexBuffer(n2, n3) : null;
        this.indexRangePacker = n3 > 0 ? new RangePacker(n3) : null;
        this.mesh = this.createMesh(this.vertexBuffer.getVertexCount(), this.vertexBuffer, n3, this.indexBuffer);
        this.subMeshCache = new MeshHeap$SubMeshCache(this, this.vertexRangePacker, this.indexRangePacker);
        this.lockedSubMeshes = new LongObjectOptHashMap(100);
        this.listeners = CowList.EMPTY;
    }

    @Override
    public void dispose() {
        this.mesh.dispose();
        this.vertexBuffer.dispose();
        this.indexBuffer.dispose();
        super.dispose();
    }

    public Mesh getMesh() {
        return this.mesh;
    }

    private VertexBuffer createVertexBuffer(VertexFormat vertexFormat, int n) {
        Graphics3D graphics3D = this.getGraphics3D();
        MeshManager meshManager = graphics3D.getMeshManager();
        return meshManager.createVertexBuffer(n, vertexFormat, 2);
    }

    private IndexBuffer createIndexBuffer(int n, int n2) {
        Graphics3D graphics3D = this.getGraphics3D();
        MeshManager meshManager = graphics3D.getMeshManager();
        return meshManager.createIndexBuffer(n2, n, 2);
    }

    private Mesh createMesh(int n, VertexBuffer vertexBuffer, int n2, IndexBuffer indexBuffer) {
        Graphics3D graphics3D = this.getGraphics3D();
        MeshManager meshManager = graphics3D.getMeshManager();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(vertexBuffer);
        ArrayList arrayList2 = new ArrayList(100);
        VertexBufferStreamMapping vertexBufferStreamMapping = new VertexBufferStreamMapping(this.vertexBuffer);
        if (n2 > 0) {
            return meshManager.createMesh(arrayList2, n, arrayList, vertexBufferStreamMapping, n2, indexBuffer);
        }
        return meshManager.createMesh(arrayList2, n, arrayList, vertexBufferStreamMapping);
    }

    public MeshHeap$SubMesh getSubMesh(long l) {
        return (MeshHeap$SubMesh)this.subMeshCache.get(l);
    }

    public MeshHeap$SubMesh insertSubMesh(long l, int n, int n2) {
        return this.insertSubMesh(l, n, n2, 0);
    }

    public MeshHeap$SubMesh insertSubMesh(long l, int n, int n2, int n3) {
        LogMessage logMessage;
        Object object;
        Logger logger = this.getLogger();
        int n4 = -1;
        do {
            if ((n4 = this.vertexRangePacker.insert(n2)) != -1) continue;
            if (this.subMeshCache.evict()) {
                if (!logger.isTraceEnabled(4096)) continue;
                LogMessage logMessage2 = logger.trace(4096);
                logMessage2.append("Evicting from SubMeshCache during insertion of vertices").log();
                continue;
            }
            throw new InsufficientSpaceException(n2, this.vertexBuffer.getVertexSize());
        } while (n4 < 0);
        int n5 = -1;
        if (n3 > 0) {
            try {
                do {
                    if ((n5 = this.indexRangePacker.insert(n3)) != -1) continue;
                    if (this.subMeshCache.evict()) {
                        if (!logger.isTraceEnabled(4096)) continue;
                        object = logger.trace(4096);
                        object.append("Evicting from SubMeshCache during insertion of indices").log();
                        continue;
                    }
                    throw new InsufficientSpaceException(n2, this.vertexBuffer.getVertexSize());
                } while (n5 < 0);
            }
            catch (InsufficientSpaceException insufficientSpaceException) {
                this.vertexRangePacker.remove(n4);
                throw insufficientSpaceException;
            }
        }
        object = (MeshHeap$SubMesh)SUBMESH_POOL.borrowObject();
        if (logger.isTraceEnabled(4096)) {
            logMessage = logger.trace(4096);
            logMessage.append("Current SubMeshPool.size(): ").append(SUBMESH_POOL.size()).log();
        }
        ((MeshHeap$SubMesh)object).setMesh(this.mesh);
        ((Primitives)object).setType(n);
        ((Primitives)object).setMinVertex(n4);
        ((Primitives)object).setMaxVertex(n4 + n2 - 1);
        ((Primitives)object).setStartIndex(n5);
        ((Primitives)object).setIndexCount(n3);
        ((MeshHeap$SubMesh)object).setId(l);
        this.subMeshCache.put(l, (Cacheable)object);
        if (logger.isTraceEnabled(4096)) {
            logMessage = logger.trace(4096);
            logMessage.append("Inserted submesh ").append(object).log();
        }
        return object;
    }

    public boolean removeSubMesh(MeshHeap$SubMesh meshHeap$SubMesh) {
        if (!this.isSubMeshLocked(meshHeap$SubMesh)) {
            this.subMeshCache.remove(meshHeap$SubMesh.getId());
            return true;
        }
        return false;
    }

    public void clear() {
        Cacheable[] cacheableArray = this.subMeshCache.elements();
        for (int i2 = cacheableArray.length - 1; i2 >= 0; --i2) {
            this.subMeshCache.remove(cacheableArray[i2]);
        }
    }

    public void lockSubMesh(MeshHeap$SubMesh meshHeap$SubMesh) {
        this.lockedSubMeshes.put(meshHeap$SubMesh.getId(), meshHeap$SubMesh);
    }

    public void unlockSubMesh(MeshHeap$SubMesh meshHeap$SubMesh) {
        this.lockedSubMeshes.remove(meshHeap$SubMesh.getId());
    }

    public void unlockAllSubMeshes() {
        this.lockedSubMeshes.clear();
    }

    public boolean isSubMeshLocked(MeshHeap$SubMesh meshHeap$SubMesh) {
        return this.lockedSubMeshes.containsKey(meshHeap$SubMesh.getId());
    }

    public void addMeshHeapListener(MeshHeap$MeshHeapListener meshHeap$MeshHeapListener) {
        this.listeners = this.listeners.addIfAbsent(meshHeap$MeshHeapListener);
    }

    public void removeMeshHeapListener(MeshHeap$MeshHeapListener meshHeap$MeshHeapListener) {
        this.listeners = this.listeners.remove(meshHeap$MeshHeapListener);
    }

    protected void fireSubMeshRemoved(MeshHeap$SubMesh meshHeap$SubMesh) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            MeshHeap$MeshHeapListener meshHeap$MeshHeapListener = (MeshHeap$MeshHeapListener)cowList.head();
            meshHeap$MeshHeapListener.subMeshRemoved(meshHeap$SubMesh);
        }
    }

    static {
        SUBMESH_POOL = new MeshHeap$SubMeshPool(100);
    }
}

