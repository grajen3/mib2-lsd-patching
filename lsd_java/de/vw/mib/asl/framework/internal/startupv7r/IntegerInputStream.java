/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import edu.emory.mathcs.backport.java.util.Arrays;

public class IntegerInputStream {
    protected int[] buffer;
    protected int position;

    public IntegerInputStream(int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException("buffer is null");
        }
        this.buffer = nArray;
        this.position = 0;
    }

    public int read() {
        if (this.position >= this.buffer.length) {
            throw new IndexOutOfBoundsException("Try to read an integer more as available.");
        }
        return this.buffer[this.position++];
    }

    public boolean readBoolean() {
        return this.read() == 1;
    }

    public int available() {
        return this.buffer.length - this.position;
    }

    public void skip(int n) {
        if (n > this.available()) {
            throw new IllegalArgumentException("skip more as available");
        }
        this.position += n;
    }

    public int[] readArray(int n) {
        if (n == 0) {
            return new int[0];
        }
        if (n > this.available()) {
            throw new IllegalArgumentException("Try to read an integer more as available.");
        }
        int[] nArray = Arrays.copyOfRange(this.buffer, this.position, this.position + n);
        this.position += n;
        return nArray;
    }
}

