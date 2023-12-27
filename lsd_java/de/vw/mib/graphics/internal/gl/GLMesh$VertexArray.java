/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.mesh.VertexBufferStreamMapping$VertexStream;

final class GLMesh$VertexArray {
    public final int index;
    public boolean enabled;
    public VertexBufferStreamMapping$VertexStream vertexStream;

    public GLMesh$VertexArray(int n) {
        this.index = n;
    }
}

