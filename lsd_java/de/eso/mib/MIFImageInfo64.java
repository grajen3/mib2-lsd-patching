/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.MIFImageInfo;
import java.nio.ByteBuffer;

class MIFImageInfo64
extends MIFImageInfo {
    public static int size() {
        return 20;
    }

    MIFImageInfo64(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public MIFImageInfo width(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public MIFImageInfo height(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public MIFImageInfo format(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int format() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public MIFImageInfo opaque(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int opaque() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public MIFImageInfo state(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(4);
    }
}

