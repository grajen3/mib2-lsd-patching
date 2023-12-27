/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.spi;

import java.nio.ByteBuffer;

public final class NativeImage {
    public static final int FORMAT_GRAYSCALE8;
    public static final int FORMAT_GRAYSCALE8_ALPHA8;
    public static final int FORMAT_GRAYSCALE16;
    public static final int FORMAT_RGB565;
    public static final int FORMAT_RGBA5551;
    public static final int FORMAT_RGBA4;
    public static final int FORMAT_RGB8;
    public static final int FORMAT_RGBA8;
    public final ByteBuffer buffer;
    public final int width;
    public final int height;
    public final boolean opaque;
    public final int format;

    public NativeImage(ByteBuffer byteBuffer, int n, int n2, int n3) {
        this(byteBuffer, n, n2, n3, false);
    }

    public NativeImage(ByteBuffer byteBuffer, int n, int n2, int n3, boolean bl) {
        this.buffer = byteBuffer;
        this.width = n;
        this.height = n2;
        this.format = n3;
        this.opaque = bl;
    }

    public ByteBuffer getBuffer() {
        return this.buffer;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFormat() {
        return this.format;
    }

    public boolean isOpaque() {
        return this.opaque;
    }
}

