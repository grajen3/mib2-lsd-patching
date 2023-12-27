/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLIndexBuffer;
import de.vw.mib.graphics.internal.gl.GLMesh;
import de.vw.mib.graphics.internal.gl.GLVertexBuffer;
import de.vw.mib.graphics.internal.mesh.AbstractMeshManager;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;
import de.vw.mib.graphics.mesh.VertexFormat;
import java.util.List;

public final class GLMeshManager
extends AbstractMeshManager {
    public GLMeshManager(GLGraphics3D gLGraphics3D) {
        super(gLGraphics3D, gLGraphics3D.getLogger());
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    @Override
    public VertexBuffer createVertexBuffer(int n, VertexFormat vertexFormat, int n2) {
        return new GLVertexBuffer(this, n, vertexFormat, n2);
    }

    @Override
    public IndexBuffer createIndexBuffer(int n, int n2, int n3) {
        return new GLIndexBuffer(this, n, n2, n3);
    }

    @Override
    public Mesh createMesh(List list, int n, List list2, VertexBufferStreamMapping vertexBufferStreamMapping, int n2, IndexBuffer indexBuffer, BoundingVolume boundingVolume) {
        return new GLMesh(this, list, n, n2, list2, vertexBufferStreamMapping, indexBuffer, boundingVolume);
    }
}

