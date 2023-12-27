/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.ImageInfo32;
import de.eso.mib.ImageInfo64;
import java.nio.ByteBuffer;

public abstract class ImageInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return ImageInfo32.size();
        }
        return ImageInfo64.size();
    }

    public static ImageInfo create() {
        return ImageInfo.create(BufferFactory.newDirectByteBuffer(ImageInfo.size()));
    }

    public static ImageInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new ImageInfo32(byteBuffer);
        }
        return new ImageInfo64(byteBuffer);
    }

    ImageInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract ImageInfo width(int n) {
    }

    public abstract int width() {
    }

    public abstract ImageInfo height(int n) {
    }

    public abstract int height() {
    }

    public abstract ImageInfo format(int n) {
    }

    public abstract int format() {
    }

    public abstract ImageInfo state(int n) {
    }

    public abstract int state() {
    }

    public abstract ImageInfo bytesize(int n) {
    }

    public abstract int bytesize() {
    }

    public abstract ImageInfo opaque(int n) {
    }

    public abstract int opaque() {
    }
}

