/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.STextMetric32;
import de.eso.mib.STextMetric64;
import java.nio.ByteBuffer;

public abstract class STextMetric {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return STextMetric32.size();
        }
        return STextMetric64.size();
    }

    public static STextMetric create() {
        return STextMetric.create(BufferFactory.newDirectByteBuffer(STextMetric.size()));
    }

    public static STextMetric create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new STextMetric32(byteBuffer);
        }
        return new STextMetric64(byteBuffer);
    }

    STextMetric(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract STextMetric isTruncated(int n) {
    }

    public abstract int isTruncated() {
    }

    public abstract STextMetric width(int n) {
    }

    public abstract int width() {
    }

    public abstract STextMetric height(int n) {
    }

    public abstract int height() {
    }

    public abstract STextMetric lineCount(int n) {
    }

    public abstract int lineCount() {
    }
}

