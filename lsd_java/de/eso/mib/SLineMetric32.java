/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.SLineMetric;
import java.nio.ByteBuffer;

class SLineMetric32
extends SLineMetric {
    public static int size() {
        return 20;
    }

    SLineMetric32(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public SLineMetric left(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int left() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public SLineMetric top(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int top() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public SLineMetric bottom(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int bottom() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public SLineMetric baseline(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int baseline() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public SLineMetric glyphcount(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int glyphcount() {
        return this.accessor.getIntAt(4);
    }
}

