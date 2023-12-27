/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.mesh.IndexBuffer;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.mesh.VertexBuffer;
import de.vw.mib.graphics.mesh.VertexBufferStreamMapping;

public interface Mesh
extends Resource {
    default public int getPrimitivesCount() {
    }

    default public Primitives getPrimitives(int n) {
    }

    default public int getVertexCount() {
    }

    default public int getVertexBufferCount() {
    }

    default public VertexBuffer getVertexBuffer(int n) {
    }

    default public VertexBufferStreamMapping getVertexBufferStreamMapping() {
    }

    default public boolean isIndexed() {
    }

    default public int getIndexCount() {
    }

    default public IndexBuffer getIndexBuffer() {
    }

    default public BoundingVolume getBoundingVolume() {
    }
}

