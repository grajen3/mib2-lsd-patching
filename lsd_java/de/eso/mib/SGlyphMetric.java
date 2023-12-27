/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.SGlyphMetric32;
import de.eso.mib.SGlyphMetric64;
import java.nio.ByteBuffer;

public abstract class SGlyphMetric {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return SGlyphMetric32.size();
        }
        return SGlyphMetric64.size();
    }

    public static SGlyphMetric create() {
        return SGlyphMetric.create(BufferFactory.newDirectByteBuffer(SGlyphMetric.size()));
    }

    public static SGlyphMetric create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new SGlyphMetric32(byteBuffer);
        }
        return new SGlyphMetric64(byteBuffer);
    }

    SGlyphMetric(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract SGlyphMetric glyphid(int n) {
    }

    public abstract int glyphid() {
    }

    public abstract SGlyphMetric sourceindex(int n) {
    }

    public abstract int sourceindex() {
    }

    public abstract SGlyphMetric x(int n) {
    }

    public abstract int x() {
    }

    public abstract SGlyphMetric y(int n) {
    }

    public abstract int y() {
    }

    public abstract SGlyphMetric width(int n) {
    }

    public abstract int width() {
    }

    public abstract SGlyphMetric height(int n) {
    }

    public abstract int height() {
    }

    public abstract SGlyphMetric caretX(int n) {
    }

    public abstract int caretX() {
    }

    public abstract SGlyphMetric isRightToLeft(int n) {
    }

    public abstract int isRightToLeft() {
    }
}

