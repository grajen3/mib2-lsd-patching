/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.mesh.AbstractGeometryBuffer;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.mesh.GeometryBuffer;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.MeshPerformanceMetrics;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public abstract class AbstractMesh
extends AbstractResource
implements Mesh,
Cacheable {
    private final MeshManager meshManager;
    private final List primitives;
    private final int vertexCount;
    private final int indexCount;
    private final List vertexBuffers;
    private final VertexBufferStreamMapping vertexBufferStreamMapping;
    private final IndexBuffer indexBuffer;
    private final BoundingVolume boundingVolume;

    public AbstractMesh(Graphics3D graphics3D, Logger logger, MeshManager meshManager, List list, int n, int n2, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, IndexBuffer indexBuffer, BoundingVolume boundingVolume) {
        super(graphics3D, logger);
        this.meshManager = meshManager;
        this.primitives = list;
        this.vertexCount = n;
        this.indexCount = n2;
        this.vertexBuffers = list2;
        this.vertexBufferStreamMapping = vertexBufferStreamMapping;
        this.indexBuffer = indexBuffer;
        this.boundingVolume = boundingVolume;
        this.updateAllocationStatistics(this.meshManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.meshManager.getPerformanceMetrics(), false);
        for (int i2 = this.getVertexBufferCount() - 1; i2 >= 0; --i2) {
            ((GeometryBuffer)this.vertexBuffers.get(i2)).dispose();
        }
        if (this.getIndexBuffer() != null) {
            this.getIndexBuffer().dispose();
        }
        super.dispose();
    }

    protected final void updateAllocationStatistics(MeshPerformanceMetrics meshPerformanceMetrics, boolean bl) {
        meshPerformanceMetrics.allocatedMeshes = meshPerformanceMetrics.allocatedMeshes + (bl ? 1 : -1);
    }

    @Override
    public int getByteSize() {
        int n = 0;
        for (int i2 = this.getVertexBufferCount() - 1; i2 >= 0; --i2) {
            n += ((AbstractGeometryBuffer)this.vertexBuffers.get(i2)).getByteSize();
        }
        if (this.getIndexBuffer() != null) {
            n += ((AbstractGeometryBuffer)((Object)this.getIndexBuffer())).getByteSize();
        }
        return n;
    }

    protected final MeshManager getMeshManager() {
        return this.meshManager;
    }

    @Override
    public final int getPrimitivesCount() {
        return this.primitives.size();
    }

    @Override
    public final Primitives getPrimitives(int n) {
        return (Primitives)this.primitives.get(n);
    }

    @Override
    public final int getVertexCount() {
        return this.vertexCount;
    }

    @Override
    public final int getVertexBufferCount() {
        return this.vertexBuffers.size();
    }

    @Override
    public final VertexBuffer getVertexBuffer(int n) {
        return (VertexBuffer)this.vertexBuffers.get(n);
    }

    @Override
    public final VertexBufferStreamMapping getVertexBufferStreamMapping() {
        return this.vertexBufferStreamMapping;
    }

    @Override
    public final boolean isIndexed() {
        return this.indexCount > 0;
    }

    @Override
    public final int getIndexCount() {
        return this.indexCount;
    }

    @Override
    public final IndexBuffer getIndexBuffer() {
        return this.indexBuffer;
    }

    @Override
    public final BoundingVolume getBoundingVolume() {
        return this.boundingVolume;
    }

    protected final void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            MeshPerformanceMetrics meshPerformanceMetrics = this.getMeshManager().getPerformanceMetrics();
            ++meshPerformanceMetrics.meshBinds;
        }
    }

    public void draw(Primitives primitives) {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            MeshPerformanceMetrics meshPerformanceMetrics = this.getMeshManager().getPerformanceMetrics();
            meshPerformanceMetrics.drawnVertices += primitives.getVertexCount();
            meshPerformanceMetrics.drawnPrimitives += primitives.getCount();
            if (primitives.isIndexed()) {
                ++meshPerformanceMetrics.drawnIndexedGeometries;
            } else {
                ++meshPerformanceMetrics.drawnGeometries;
            }
        }
    }
}

