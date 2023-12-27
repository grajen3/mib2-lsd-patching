/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.tesselation.MeshTesselator;
import de.vw.mib.graphics.mesh.VertexFormat;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class AbstractMeshTesselator
implements MeshTesselator {
    private final boolean interleaveVertices;
    private final int maxVertices;
    private final int maxIndices;
    private MeshBuilder meshBuilder;

    public AbstractMeshTesselator(boolean bl, int n) {
        this(bl, n, 0);
    }

    public AbstractMeshTesselator(boolean bl, int n, int n2) {
        this.interleaveVertices = bl;
        this.maxVertices = n;
        this.maxIndices = n2;
    }

    public void initialize() {
        this.meshBuilder = this.maxIndices > 0 ? new MeshBuilder(this.createVertexFormat(this.interleaveVertices), this.maxVertices, this.createIndexFormat(), this.maxIndices) : new MeshBuilder(this.createVertexFormat(this.interleaveVertices), this.maxVertices);
    }

    protected abstract List createVertexFormat(boolean bl) {
    }

    protected abstract int createIndexFormat() {
    }

    protected final MeshBuilder getMeshBuilder() {
        return this.meshBuilder;
    }

    @Override
    public final int getVertexArrayCount() {
        return this.meshBuilder.getVertexArrayCount();
    }

    @Override
    public final int getVertexSize() {
        return this.meshBuilder.getVertexSize();
    }

    @Override
    public final VertexFormat getVertexFormat(int n) {
        return this.meshBuilder.getVertexFormat(n);
    }

    @Override
    public final ByteBuffer getVertexArray(int n) {
        return this.meshBuilder.getVertexArray(n);
    }

    @Override
    public final int getVertexCount() {
        return this.meshBuilder.getVertexCount();
    }

    @Override
    public final int getMaxVertexCount() {
        return this.meshBuilder.getMaxVertices();
    }

    @Override
    public final boolean hasIndices() {
        return this.meshBuilder.hasIndices();
    }

    @Override
    public final int getIndexFormat() {
        return this.meshBuilder.getIndexFormat();
    }

    @Override
    public final int getIndexCount() {
        return this.meshBuilder.getIndexCount();
    }

    @Override
    public final int getMaxIndexCount() {
        return this.meshBuilder.getMaxIndices();
    }

    @Override
    public final ByteBuffer getIndexArray() {
        return this.meshBuilder.getIndexArray();
    }

    @Override
    public final int getPrimitiveType() {
        return this.meshBuilder.getPrimitiveType();
    }
}

