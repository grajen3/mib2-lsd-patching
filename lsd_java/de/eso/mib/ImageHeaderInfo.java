/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.ImageHeaderInfo32;
import de.eso.mib.ImageHeaderInfo64;
import java.nio.ByteBuffer;

public abstract class ImageHeaderInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return ImageHeaderInfo32.size();
        }
        return ImageHeaderInfo64.size();
    }

    public static ImageHeaderInfo create() {
        return ImageHeaderInfo.create(BufferFactory.newDirectByteBuffer(ImageHeaderInfo.size()));
    }

    public static ImageHeaderInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new ImageHeaderInfo32(byteBuffer);
        }
        return new ImageHeaderInfo64(byteBuffer);
    }

    ImageHeaderInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract ImageHeaderInfo type(int n) {
    }

    public abstract int type() {
    }

    public abstract ImageHeaderInfo width(int n) {
    }

    public abstract int width() {
    }

    public abstract ImageHeaderInfo height(int n) {
    }

    public abstract int height() {
    }

    public abstract ImageHeaderInfo depth(int n) {
    }

    public abstract int depth() {
    }

    public abstract ImageHeaderInfo bytesize(int n) {
    }

    public abstract int bytesize() {
    }

    public abstract ImageHeaderInfo attribs(int n) {
    }

    public abstract int attribs() {
    }

    public abstract ImageHeaderInfo state(int n) {
    }

    public abstract int state() {
    }
}

