/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class MeshPerformanceMetrics
implements PerformanceMetrics {
    public int allocatedVertexBuffers;
    public int allocatedVertexBuffersSizeBytes;
    public int allocatedIndexBuffers;
    public int allocatedIndexBuffersSizeBytes;
    public int allocatedUniformBuffers;
    public int allocatedUniformBuffersSizeBytes;
    public int allocatedMeshes;
    public int meshBinds;
    public int drawnVertices;
    public int drawnPrimitives;
    public int drawnGeometries;
    public int drawnIndexedGeometries;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedVertexBuffers=").append(this.allocatedVertexBuffers);
        stringBuilder.append(",allocatedVertexBuffersSizeBytes=").append(this.allocatedVertexBuffersSizeBytes);
        stringBuilder.append(",allocatedIndexBuffers=").append(this.allocatedIndexBuffers);
        stringBuilder.append(",allocatedIndexBuffersSizeBytes=").append(this.allocatedIndexBuffersSizeBytes);
        stringBuilder.append(",allocatedUniformBuffers=").append(this.allocatedUniformBuffers);
        stringBuilder.append(",allocatedUniformBuffersSizeBytes=").append(this.allocatedUniformBuffersSizeBytes);
        stringBuilder.append(",allocatedMeshes=").append(this.allocatedMeshes);
        stringBuilder.append(",meshBinds=").append(this.meshBinds);
        stringBuilder.append(",drawnVertices=").append(this.drawnVertices);
        stringBuilder.append(",drawnPrimitives=").append(this.drawnPrimitives);
        stringBuilder.append(",drawnGeometries=").append(this.drawnGeometries);
        stringBuilder.append(",drawnIndexedGeometries=").append(this.drawnIndexedGeometries);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.meshBinds = 0;
        this.drawnVertices = 0;
        this.drawnPrimitives = 0;
        this.drawnGeometries = 0;
        this.drawnIndexedGeometries = 0;
    }
}

