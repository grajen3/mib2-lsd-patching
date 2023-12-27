/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.FontGlyphInfo32;
import de.eso.mib.FontGlyphInfo64;
import java.nio.ByteBuffer;

public abstract class FontGlyphInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return FontGlyphInfo32.size();
        }
        return FontGlyphInfo64.size();
    }

    public static FontGlyphInfo create() {
        return FontGlyphInfo.create(BufferFactory.newDirectByteBuffer(FontGlyphInfo.size()));
    }

    public static FontGlyphInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new FontGlyphInfo32(byteBuffer);
        }
        return new FontGlyphInfo64(byteBuffer);
    }

    FontGlyphInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract FontGlyphInfo left_offset(int n) {
    }

    public abstract int left_offset() {
    }

    public abstract FontGlyphInfo top_offset(int n) {
    }

    public abstract int top_offset() {
    }

    public abstract FontGlyphInfo horizontal_advance(int n) {
    }

    public abstract int horizontal_advance() {
    }

    public abstract FontGlyphInfo state(int n) {
    }

    public abstract int state() {
    }

    public abstract FontGlyphInfo width(int n) {
    }

    public abstract int width() {
    }

    public abstract FontGlyphInfo height(int n) {
    }

    public abstract int height() {
    }

    public abstract FontGlyphInfo bytesize(int n) {
    }

    public abstract int bytesize() {
    }
}

