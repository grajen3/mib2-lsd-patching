/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.mesh.MeshCache;
import de.vw.mib.graphics.internal.mesh.MeshFactory;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.MeshPerformanceMetrics;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public abstract class AbstractMeshManager
extends AbstractResource
implements MeshManager,
GraphicsListener {
    private final MeshPerformanceMetrics performanceMetrics = new MeshPerformanceMetrics();
    private final MeshFactory meshFactory = new MeshFactory(this);
    private final MeshCache meshCache = new MeshCache();
    private Mesh axisMesh;
    private Mesh squareMesh;
    private Mesh boxMesh;
    private Mesh cubeMesh;

    public AbstractMeshManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        if (this.axisMesh != null) {
            this.axisMesh.dispose();
            this.axisMesh = null;
        }
        if (this.squareMesh != null) {
            this.squareMesh.dispose();
            this.squareMesh = null;
        }
        if (this.boxMesh != null) {
            this.boxMesh.dispose();
            this.boxMesh = null;
        }
        if (this.cubeMesh != null) {
            this.cubeMesh.dispose();
            this.cubeMesh = null;
        }
        super.dispose();
    }

    @Override
    public final MeshPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public final CachePerformanceMetrics getMeshCacheUsage() {
        return new CachePerformanceMetrics(this.meshCache.size(), this.meshCache.getByteSize(), this.meshCache.getMaximumCacheSizeBytes(), this.meshCache.hits(), this.meshCache.misses());
    }

    @Override
    public abstract VertexBuffer createVertexBuffer(int n, VertexFormat vertexFormat, int n2) {
    }

    @Override
    public abstract IndexBuffer createIndexBuffer(int n, int n2, int n3) {
    }

    @Override
    public final Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping) {
        return this.createMesh(list, n, list2, vertexBufferStreamMapping, 0, null);
    }

    @Override
    public final Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, BoundingVolume boundingVolume) {
        return this.createMesh(list, n, list2, vertexBufferStreamMapping, 0, null, boundingVolume);
    }

    @Override
    public final Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, int n2, IndexBuffer indexBuffer) {
        return this.createMesh(list, n, list2, vertexBufferStreamMapping, n2, indexBuffer, null);
    }

    @Override
    public abstract Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, int n2, IndexBuffer indexBuffer, BoundingVolume boundingVolume) {
    }

    @Override
    public final Mesh getReferenceCoordinatesMesh() {
        if (this.axisMesh == null) {
            this.axisMesh = this.meshFactory.createReferenceCoordinatesMesh(true, true);
        }
        return this.axisMesh;
    }

    @Override
    public final Mesh createRectangleMesh(float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.meshFactory.createRectangleMesh(f2, f3, bl, bl2, bl4, bl3);
    }

    @Override
    public final Mesh getNormalizedSquareMesh() {
        if (this.squareMesh == null) {
            this.squareMesh = this.createRectangleMesh(1.0f, 1.0f, true, false, false, true);
        }
        return this.squareMesh;
    }

    @Override
    public final Mesh createWireBoxMesh(float f2, float f3, float f4, boolean bl) {
        return this.meshFactory.createWireBoxMesh(f2, f3, f4, bl);
    }

    @Override
    public final Mesh getNormalizedWireBoxMesh() {
        if (this.boxMesh == null) {
            this.boxMesh = this.createWireBoxMesh(1.0f, 1.0f, 1.0f, false);
        }
        return this.boxMesh;
    }

    @Override
    public final Mesh createSolidCubeMesh(float f2, float f3, float f4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return this.meshFactory.createSolidCubeMesh(f2, f3, f4, bl, bl2, bl4, bl3);
    }

    @Override
    public final Mesh getNormalizedSolidCubeMesh() {
        if (this.cubeMesh == null) {
            this.cubeMesh = this.createSolidCubeMesh(1.0f, 1.0f, 1.0f, true, true, true, true);
        }
        return this.cubeMesh;
    }

    @Override
    public final Mesh createPointMesh(Point3f[] point3fArray, boolean bl) {
        return this.meshFactory.createPointMesh(point3fArray, bl);
    }

    @Override
    public final Mesh createLineMesh(Point2f[] point2fArray, boolean bl) {
        return this.meshFactory.createLineMesh(point2fArray, bl);
    }

    @Override
    public final Mesh createLineMesh(Point3f[] point3fArray, boolean bl) {
        return this.meshFactory.createLineMesh(point3fArray, bl);
    }

    @Override
    public final Mesh createUniformSolidGridMesh(float f2, float f3, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        return this.meshFactory.createUniformSolidGridMesh(f2, f3, n, n2, bl, bl2, bl3);
    }

    @Override
    public final Mesh createUniformPointGridMesh(float f2, float f3, int n, int n2, boolean bl) {
        return this.meshFactory.createUniformPointGridMesh(f2, f3, n, n2, bl);
    }

    @Override
    public final Mesh createSolidSphereMesh(float f2, int n, boolean bl, boolean bl2, boolean bl3) {
        return this.meshFactory.createSolidSphereMesh(f2, n, bl, bl2, bl3);
    }

    @Override
    public final Mesh createPointSphereMesh(float f2, int n, boolean bl) {
        return this.meshFactory.createPointSphereMesh(f2, n, bl);
    }

    @Override
    public final Mesh createCircularSectorMesh(float f2, float f3, float f4, int n, boolean bl, boolean bl2) {
        return this.meshFactory.createCircularSectorMesh(f2, f3, f4, n, bl, bl2);
    }

    @Override
    public final Mesh createSolidCircleMesh(float f2, int n, boolean bl, boolean bl2) {
        return this.createCircularSectorMesh(f2, 0.0f, 46147, n, bl, bl2);
    }

    @Override
    public final Mesh createCircleGraphMesh(float[] fArray, float f2, int n, boolean bl, boolean bl2) {
        return this.meshFactory.createCircleGraphMesh(fArray, f2, n, bl, bl2);
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}

