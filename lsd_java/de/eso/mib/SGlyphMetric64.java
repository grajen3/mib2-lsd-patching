/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.SGlyphMetric;
import java.nio.ByteBuffer;

class SGlyphMetric64
extends SGlyphMetric {
    public static int size() {
        return 32;
    }

    SGlyphMetric64(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public SGlyphMetric glyphid(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int glyphid() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public SGlyphMetric sourceindex(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int sourceindex() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public SGlyphMetric x(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int x() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public SGlyphMetric y(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int y() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public SGlyphMetric width(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(4);
    }

    @Override
    public SGlyphMetric height(int n) {
        this.accessor.setIntAt(5, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(5);
    }

    @Override
    public SGlyphMetric caretX(int n) {
        this.accessor.setIntAt(6, n);
        return this;
    }

    @Override
    public int caretX() {
        return this.accessor.getIntAt(6);
    }

    @Override
    public SGlyphMetric isRightToLeft(int n) {
        this.accessor.setIntAt(7, n);
        return this;
    }

    @Override
    public int isRightToLeft() {
        return this.accessor.getIntAt(7);
    }
}

