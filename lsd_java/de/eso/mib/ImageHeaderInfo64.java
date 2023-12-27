/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.ImageHeaderInfo;
import java.nio.ByteBuffer;

class ImageHeaderInfo64
extends ImageHeaderInfo {
    public static int size() {
        return 28;
    }

    ImageHeaderInfo64(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public ImageHeaderInfo type(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int type() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public ImageHeaderInfo width(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public ImageHeaderInfo height(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public ImageHeaderInfo depth(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int depth() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public ImageHeaderInfo bytesize(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int bytesize() {
        return this.accessor.getIntAt(4);
    }

    @Override
    public ImageHeaderInfo attribs(int n) {
        this.accessor.setIntAt(5, n);
        return this;
    }

    @Override
    public int attribs() {
        return this.accessor.getIntAt(5);
    }

    @Override
    public ImageHeaderInfo state(int n) {
        this.accessor.setIntAt(6, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(6);
    }
}

