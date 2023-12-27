/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshPerformanceMetrics;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import java.util.List;

public interface MeshManager
extends ResourceManager {
    default public MeshPerformanceMetrics getPerformanceMetrics() {
    }

    default public CachePerformanceMetrics getMeshCacheUsage() {
    }

    default public VertexBuffer createVertexBuffer(int n, VertexFormat vertexFormat, int n2) {
    }

    default public IndexBuffer createIndexBuffer(int n, int n2, int n3) {
    }

    default public Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping) {
    }

    default public Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, BoundingVolume boundingVolume) {
    }

    default public Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, int n2, IndexBuffer indexBuffer) {
    }

    default public Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, int n2, IndexBuffer indexBuffer, BoundingVolume boundingVolume) {
    }

    default public Mesh getReferenceCoordinatesMesh() {
    }

    default public Mesh createRectangleMesh(float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public Mesh getNormalizedSquareMesh() {
    }

    default public Mesh createWireBoxMesh(float f2, float f3, float f4, boolean bl) {
    }

    default public Mesh getNormalizedWireBoxMesh() {
    }

    default public Mesh createSolidCubeMesh(float f2, float f3, float f4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public Mesh getNormalizedSolidCubeMesh() {
    }

    default public Mesh createPointMesh(Point3f[] point3fArray, boolean bl) {
    }

    default public Mesh createLineMesh(Point2f[] point2fArray, boolean bl) {
    }

    default public Mesh createLineMesh(Point3f[] point3fArray, boolean bl) {
    }

    default public Mesh createUniformSolidGridMesh(float f2, float f3, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
    }

    default public Mesh createUniformPointGridMesh(float f2, float f3, int n, int n2, boolean bl) {
    }

    default public Mesh createCircularSectorMesh(float f2, float f3, float f4, int n, boolean bl, boolean bl2) {
    }

    default public Mesh createSolidCircleMesh(float f2, int n, boolean bl, boolean bl2) {
    }

    default public Mesh createCircleGraphMesh(float[] fArray, float f2, int n, boolean bl, boolean bl2) {
    }

    default public Mesh createSolidSphereMesh(float f2, int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public Mesh createPointSphereMesh(float f2, int n, boolean bl) {
    }
}

