/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh.tesselation;

import de.vw.mib.graphics.mesh.VertexFormat;
import java.nio.ByteBuffer;

public interface MeshTesselator {
    default public int getVertexCount() {
    }

    default public int getMaxVertexCount() {
    }

    default public int getVertexArrayCount() {
    }

    default public int getVertexSize() {
    }

    default public VertexFormat getVertexFormat(int n) {
    }

    default public ByteBuffer getVertexArray(int n) {
    }

    default public boolean hasIndices() {
    }

    default public int getIndexFormat() {
    }

    default public int getIndexCount() {
    }

    default public int getMaxIndexCount() {
    }

    default public ByteBuffer getIndexArray() {
    }

    default public int getPrimitiveType() {
    }
}

