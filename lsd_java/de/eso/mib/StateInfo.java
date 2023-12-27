/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.StateInfo32;
import de.eso.mib.StateInfo64;
import java.nio.ByteBuffer;

public abstract class StateInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return StateInfo32.size();
        }
        return StateInfo64.size();
    }

    public static StateInfo create() {
        return StateInfo.create(BufferFactory.newDirectByteBuffer(StateInfo.size()));
    }

    public static StateInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new StateInfo32(byteBuffer);
        }
        return new StateInfo64(byteBuffer);
    }

    StateInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract StateInfo state(int n) {
    }

    public abstract int state() {
    }
}

