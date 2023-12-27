/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontMetricsInfo;
import java.nio.ByteBuffer;

class FontMetricsInfo32
extends FontMetricsInfo {
    public static int size() {
        return 44;
    }

    FontMetricsInfo32(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public FontMetricsInfo ascender(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int ascender() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public FontMetricsInfo descender(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int descender() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public FontMetricsInfo height(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(2);
    }

    @Override
    public FontMetricsInfo advanceWidth(int n) {
        this.accessor.setIntAt(3, n);
        return this;
    }

    @Override
    public int advanceWidth() {
        return this.accessor.getIntAt(3);
    }

    @Override
    public FontMetricsInfo underlinePosition(int n) {
        this.accessor.setIntAt(4, n);
        return this;
    }

    @Override
    public int underlinePosition() {
        return this.accessor.getIntAt(4);
    }

    @Override
    public FontMetricsInfo underlineThickness(int n) {
        this.accessor.setIntAt(5, n);
        return this;
    }

    @Override
    public int underlineThickness() {
        return this.accessor.getIntAt(5);
    }

    @Override
    public FontMetricsInfo strikeOutPosition(int n) {
        this.accessor.setIntAt(6, n);
        return this;
    }

    @Override
    public int strikeOutPosition() {
        return this.accessor.getIntAt(6);
    }

    @Override
    public FontMetricsInfo strikeOutThickness(int n) {
        this.accessor.setIntAt(7, n);
        return this;
    }

    @Override
    public int strikeOutThickness() {
        return this.accessor.getIntAt(7);
    }

    @Override
    public FontMetricsInfo overlinePosition(int n) {
        this.accessor.setIntAt(8, n);
        return this;
    }

    @Override
    public int overlinePosition() {
        return this.accessor.getIntAt(8);
    }

    @Override
    public FontMetricsInfo overlineThickness(int n) {
        this.accessor.setIntAt(9, n);
        return this;
    }

    @Override
    public int overlineThickness() {
        return this.accessor.getIntAt(9);
    }

    @Override
    public FontMetricsInfo state(int n) {
        this.accessor.setIntAt(10, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(10);
    }
}

