/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.STextMetric;
import java.nio.ByteBuffer;

class STextMetric32
extends STextMetric {
    public static int size() {
        return 16;
    }

    STextMetric32(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public STextMetric isTruncated(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int isTruncated() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public STextMetric width(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public STextMetric height(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public STextMetric lineCount(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int lineCount() {
        return this.accessor.getIntAt(3);
    }
}

