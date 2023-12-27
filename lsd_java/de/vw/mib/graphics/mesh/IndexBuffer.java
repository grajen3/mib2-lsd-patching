/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.mesh.GeometryBuffer;

public interface IndexBuffer
extends GeometryBuffer {
    public static final int INDEX_FORMAT_UNSIGNED_BYTE;
    public static final int INDEX_FORMAT_UNSIGNED_SHORT;
    public static final int INDEX_FORMAT_UNSIGNED_INTEGER;

    default public int getIndexFormat() {
    }

    default public int getIndexSize() {
    }

    default public int getIndexCount() {
    }
}

