/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.SLineMetric32;
import de.eso.mib.SLineMetric64;
import java.nio.ByteBuffer;

public abstract class SLineMetric {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return SLineMetric32.size();
        }
        return SLineMetric64.size();
    }

    public static SLineMetric create() {
        return SLineMetric.create(BufferFactory.newDirectByteBuffer(SLineMetric.size()));
    }

    public static SLineMetric create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new SLineMetric32(byteBuffer);
        }
        return new SLineMetric64(byteBuffer);
    }

    SLineMetric(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract SLineMetric left(int n) {
    }

    public abstract int left() {
    }

    public abstract SLineMetric top(int n) {
    }

    public abstract int top() {
    }

    public abstract SLineMetric bottom(int n) {
    }

    public abstract int bottom() {
    }

    public abstract SLineMetric baseline(int n) {
    }

    public abstract int baseline() {
    }

    public abstract SLineMetric glyphcount(int n) {
    }

    public abstract int glyphcount() {
    }
}

