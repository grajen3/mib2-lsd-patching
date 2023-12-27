/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.StateInfo;
import java.nio.ByteBuffer;

class StateInfo32
extends StateInfo {
    public static int size() {
        return 4;
    }

    StateInfo32(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public StateInfo state(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(0);
    }
}

