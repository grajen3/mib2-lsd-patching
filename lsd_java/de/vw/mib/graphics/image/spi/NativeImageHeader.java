/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.spi;

public final class NativeImageHeader {
    public static final int TYPE_BMP;
    public static final int TYPE_GIF;
    public static final int TYPE_JPG;
    public static final int TYPE_PNG;
    public static final int TYPE_TIFF;
    public final int type;
    public final int width;
    public final int height;
    public final int depth;
    public final int size;
    public final boolean hasExif;
    public final boolean hasThumbnail;

    public NativeImageHeader(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
        this.type = n;
        this.width = n2;
        this.height = n3;
        this.depth = n4;
        this.size = n5;
        this.hasExif = bl;
        this.hasThumbnail = bl2;
    }
}

