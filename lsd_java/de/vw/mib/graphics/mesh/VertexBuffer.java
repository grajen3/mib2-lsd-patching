/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.mesh.GeometryBuffer;
import de.vw.mib.graphics.mesh.VertexFormat;

public interface VertexBuffer
extends GeometryBuffer {
    default public VertexFormat getVertexFormat() {
    }

    default public int getVertexSize() {
    }

    default public int getVertexCount() {
    }
}

