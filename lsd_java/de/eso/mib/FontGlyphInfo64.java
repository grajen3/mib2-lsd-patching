/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontGlyphInfo;
import java.nio.ByteBuffer;

class FontGlyphInfo64
extends FontGlyphInfo {
    public static int size() {
        return 28;
    }

    FontGlyphInfo64(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public FontGlyphInfo left_offset(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int left_offset() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public FontGlyphInfo top_offset(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int top_offset() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public FontGlyphInfo horizontal_advance(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int horizontal_advance() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public FontGlyphInfo state(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public FontGlyphInfo width(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(4);
    }

    @Override
    public FontGlyphInfo height(int n) {
        this.accessor.setIntAt(5, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(5);
    }

    @Override
    public FontGlyphInfo bytesize(int n) {
        this.accessor.setIntAt(6, n);
        return this;
    }

    @Override
    public int bytesize() {
        return this.accessor.getIntAt(6);
    }
}

