/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.mesh;

import de.vw.mib.graphics.Resource;
import java.nio.ByteBuffer;

public interface GeometryBuffer
extends Resource {
    public static final int GEOMETRYBUFFER_TYPE_VERTEX;
    public static final int GEOMETRYBUFFER_TYPE_INDEX;
    public static final int GEOMETRYBUFFER_TYPE_UNIFORM;
    public static final int GEOMETRYBUFFER_TYPE_COUNT;
    public static final int USAGE_STATIC;
    public static final int USAGE_DYNAMIC;
    public static final int USAGE_STREAM;
    public static final int ACCESS_DRAW;

    default public int getSize() {
    }

    default public int getUsage() {
    }

    default public boolean isReadable() {
    }

    default public ByteBuffer getContent(int n, int n2) {
    }

    default public ByteBuffer getContent() {
    }

    default public void setContent(int n, int n2, ByteBuffer byteBuffer) {
    }

    default public void setContent(int n, ByteBuffer byteBuffer) {
    }

    default public void setContent(ByteBuffer byteBuffer) {
    }
}

