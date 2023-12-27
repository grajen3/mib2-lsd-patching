/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.image.ImageMetaData;
import de.vw.mib.graphics.image.spi.NativeImageHeader;

public final class ImageInfo
extends ImageMetaData
implements Cacheable {
    public static final int IMAGE_TYPE_BMP;
    public static final int IMAGE_TYPE_GIF;
    public static final int IMAGE_TYPE_JPG;
    public static final int IMAGE_TYPE_PNG;
    public static final int IMAGE_TYPE_TIFF;
    private final int type;
    private final int width;
    private final int height;
    private final int depth;
    private final int size;
    private final boolean hasExif;
    private final boolean hasThumbnail;

    public ImageInfo(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
        this.type = n;
        this.width = n2;
        this.height = n3;
        this.depth = n4;
        this.size = n5;
        this.hasExif = bl;
        this.hasThumbnail = bl2;
    }

    public ImageInfo(NativeImageHeader nativeImageHeader) {
        this.type = nativeImageHeader.type;
        this.width = nativeImageHeader.width;
        this.height = nativeImageHeader.height;
        this.depth = nativeImageHeader.depth;
        this.size = nativeImageHeader.size;
        this.hasExif = nativeImageHeader.hasExif;
        this.hasThumbnail = nativeImageHeader.hasThumbnail;
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasExif() {
        return this.hasExif;
    }

    public boolean hasThumbnail() {
        return this.hasThumbnail;
    }
}

