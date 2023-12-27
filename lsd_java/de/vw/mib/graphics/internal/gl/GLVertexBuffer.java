/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLGeometryBuffer;
import de.vw.mib.graphics.internal.gl.GLMeshManager;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexFormat;

public final class GLVertexBuffer
extends GLGeometryBuffer
implements VertexBuffer {
    private final int vertexCount;
    private final VertexFormat vertexFormat;

    public GLVertexBuffer(GLMeshManager gLMeshManager, int n, VertexFormat vertexFormat, int n2) {
        super(gLMeshManager, 0, n * vertexFormat.getVertexSize(), n2);
        this.vertexCount = n;
        this.vertexFormat = vertexFormat;
    }

    @Override
    public int getVertexCount() {
        return this.vertexCount;
    }

    @Override
    public VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }

    @Override
    public int getVertexSize() {
        return this.vertexFormat.getVertexSize();
    }
}

