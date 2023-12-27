/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.MIFImageInfo32;
import de.eso.mib.MIFImageInfo64;
import java.nio.ByteBuffer;

public abstract class MIFImageInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return MIFImageInfo32.size();
        }
        return MIFImageInfo64.size();
    }

    public static MIFImageInfo create() {
        return MIFImageInfo.create(BufferFactory.newDirectByteBuffer(MIFImageInfo.size()));
    }

    public static MIFImageInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new MIFImageInfo32(byteBuffer);
        }
        return new MIFImageInfo64(byteBuffer);
    }

    MIFImageInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract MIFImageInfo width(int n) {
    }

    public abstract int width() {
    }

    public abstract MIFImageInfo height(int n) {
    }

    public abstract int height() {
    }

    public abstract MIFImageInfo format(int n) {
    }

    public abstract int format() {
    }

    public abstract MIFImageInfo opaque(int n) {
    }

    public abstract int opaque() {
    }

    public abstract MIFImageInfo state(int n) {
    }

    public abstract int state() {
    }
}

