/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLGeometryBuffer;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLMeshManager;
import de.vw.mib.graphics.mesh.IndexBuffer;

public final class GLIndexBuffer
extends GLGeometryBuffer
implements IndexBuffer {
    private final int indexCount;
    private final int indexFormat;

    public GLIndexBuffer(GLMeshManager gLMeshManager, int n, int n2, int n3) {
        super(gLMeshManager, 1, n * GLIndexBuffer.getIndexSize(n2), n3);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        if (n2 == 2 && !gLGraphics3D.isIntegerIndicesSupported()) {
            throw new UnsupportedOperationException("Index format not supported");
        }
        this.indexCount = n;
        this.indexFormat = n2;
    }

    @Override
    public int getIndexCount() {
        return this.indexCount;
    }

    @Override
    public int getIndexFormat() {
        return this.indexFormat;
    }

    @Override
    public int getIndexSize() {
        return GLIndexBuffer.getIndexSize(this.indexFormat);
    }
}

