/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontControlBox;
import java.nio.ByteBuffer;

class FontControlBox64
extends FontControlBox {
    public static int size() {
        return 12;
    }

    FontControlBox64(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public FontControlBox width(int n) {
        this.accessor.setIntAt(0, n);
        return this;
    }

    @Override
    public int width() {
        return this.accessor.getIntAt(0);
    }

    @Override
    public FontControlBox height(int n) {
        this.accessor.setIntAt(1, n);
        return this;
    }

    @Override
    public int height() {
        return this.accessor.getIntAt(1);
    }

    @Override
    public FontControlBox state(int n) {
        this.accessor.setIntAt(2, n);
        return this;
    }

    @Override
    public int state() {
        return this.accessor.getIntAt(2);
    }
}

