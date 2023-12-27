/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.ImageInfo;
import java.nio.ByteBuffer;

class ImageInfo32
extends ImageInfo {
    public static int size() {
        return 24;
    }

    ImageInfo32(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public ImageInfo width(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public ImageInfo height(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public ImageInfo format(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int format() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public ImageInfo state(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public ImageInfo bytesize(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int bytesize() {
        return this.accessor.getIntAt(4);
    }

    @Override
    public ImageInfo opaque(int n) {
        this.accessor.setIntAt(5, n);
        return this;
    }

    @Override
    public int opaque() {
        return this.accessor.getIntAt(5);
    }
}

