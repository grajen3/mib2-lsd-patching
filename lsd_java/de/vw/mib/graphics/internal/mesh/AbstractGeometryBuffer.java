/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.mesh.GeometryBuffer;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.MeshPerformanceMetrics;
import de.vw.mib.log4mib.Logger;
import java.nio.ByteBuffer;

public abstract class AbstractGeometryBuffer
extends AbstractResource
implements GeometryBuffer,
Cacheable {
    private final MeshManager meshManager;
    private final int type;
    private final int size;
    private final int usage;

    public AbstractGeometryBuffer(Graphics3D graphics3D, Logger logger, MeshManager meshManager, int n, int n2, int n3) {
        super(graphics3D, logger);
        this.meshManager = meshManager;
        this.type = n;
        this.size = n2;
        this.usage = n3;
        this.updateAllocationStatistics(this.meshManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.meshManager.getPerformanceMetrics(), false);
        super.dispose();
    }

    protected final void updateAllocationStatistics(MeshPerformanceMetrics meshPerformanceMetrics, boolean bl) {
        int n = this.getByteSize();
        switch (this.type) {
            case 0: {
                meshPerformanceMetrics.allocatedVertexBuffers = meshPerformanceMetrics.allocatedVertexBuffers + (bl ? 1 : -1);
                meshPerformanceMetrics.allocatedVertexBuffersSizeBytes = meshPerformanceMetrics.allocatedVertexBuffersSizeBytes + (bl ? n : -n);
                break;
            }
            case 1: {
                meshPerformanceMetrics.allocatedIndexBuffers = meshPerformanceMetrics.allocatedIndexBuffers + (bl ? 1 : -1);
                meshPerformanceMetrics.allocatedIndexBuffersSizeBytes = meshPerformanceMetrics.allocatedIndexBuffersSizeBytes + (bl ? n : -n);
                break;
            }
            case 2: {
                meshPerformanceMetrics.allocatedUniformBuffers = meshPerformanceMetrics.allocatedUniformBuffers + (bl ? 1 : -1);
                meshPerformanceMetrics.allocatedUniformBuffersSizeBytes = meshPerformanceMetrics.allocatedUniformBuffersSizeBytes + (bl ? n : -n);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid geometry buffer type");
            }
        }
    }

    @Override
    public final int getByteSize() {
        return this.getSize();
    }

    protected final MeshManager getMeshManager() {
        return this.meshManager;
    }

    public final int getType() {
        return this.type;
    }

    @Override
    public final int getSize() {
        return this.size;
    }

    @Override
    public final int getUsage() {
        return this.usage;
    }

    @Override
    public abstract boolean isReadable() {
    }

    @Override
    public abstract ByteBuffer getContent(int n, int n2) {
    }

    @Override
    public abstract ByteBuffer getContent() {
    }

    @Override
    public abstract void setContent(int n, int n2, ByteBuffer byteBuffer) {
    }

    @Override
    public final void setContent(int n, ByteBuffer byteBuffer) {
        this.setContent(n, byteBuffer.remaining(), byteBuffer);
    }

    @Override
    public final void setContent(ByteBuffer byteBuffer) {
        this.setContent(0, byteBuffer);
    }

    public static int getIndexSize(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid index format");
    }
}

