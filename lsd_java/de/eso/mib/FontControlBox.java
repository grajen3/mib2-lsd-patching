/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.FontControlBox32;
import de.eso.mib.FontControlBox64;
import java.nio.ByteBuffer;

public abstract class FontControlBox {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return FontControlBox32.size();
        }
        return FontControlBox64.size();
    }

    public static FontControlBox create() {
        return FontControlBox.create(BufferFactory.newDirectByteBuffer(FontControlBox.size()));
    }

    public static FontControlBox create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new FontControlBox32(byteBuffer);
        }
        return new FontControlBox64(byteBuffer);
    }

    FontControlBox(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract FontControlBox width(int n) {
    }

    public abstract int width() {
    }

    public abstract FontControlBox height(int n) {
    }

    public abstract int height() {
    }

    public abstract FontControlBox state(int n) {
    }

    public abstract int state() {
    }
}

