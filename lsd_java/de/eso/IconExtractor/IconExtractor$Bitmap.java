/*
 * Decompiled with CFR 0.152.
 */
package de.eso.IconExtractor;

import java.nio.ByteBuffer;

public class IconExtractor$Bitmap {
    public static final int FORMAT_GRAYSCALE;
    public static final int FORMAT_RGBA;
    int mWidth;
    int mHeight;
    ByteBuffer mData;

    public IconExtractor$Bitmap(int n, int n2, ByteBuffer byteBuffer) {
        this.mWidth = n;
        this.mHeight = n2;
        this.mData = byteBuffer;
    }

    public ByteBuffer getData() {
        return this.mData;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getFormat() {
        return 4;
    }
}

