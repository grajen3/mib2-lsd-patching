/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.commons.StringUtils;

public class ByteBufferSlice {
    private final byte[] buffer;
    private final int offset;
    private final int size;

    public ByteBufferSlice(byte[] byArray) {
        this.buffer = byArray;
        this.offset = 0;
        this.size = byArray.length;
    }

    public ByteBufferSlice(byte[] byArray, int n, int n2) {
        this.buffer = byArray;
        this.offset = n;
        this.size = n2;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        return StringUtils.toHexString(this.buffer, this.offset, this.size);
    }
}

