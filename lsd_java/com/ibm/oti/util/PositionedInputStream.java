/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class PositionedInputStream
extends FilterInputStream {
    int currentPosition = 0;

    public PositionedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int currentPosition() {
        return this.currentPosition;
    }

    @Override
    public int read() {
        int n = this.in.read();
        if (n >= 0) {
            ++this.currentPosition;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = this.in.read(byArray, n, n2);
        if (n3 >= 0) {
            this.currentPosition += n3;
        }
        return n3;
    }

    public void resetCurrentPosition() {
        this.currentPosition = 0;
    }

    @Override
    public long skip(long l) {
        long l2 = this.in.skip(l);
        this.currentPosition = (int)((long)this.currentPosition + l2);
        return l2;
    }
}

