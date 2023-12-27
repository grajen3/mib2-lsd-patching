/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.tracing;

public class SubBuffer {
    public final byte[] data;
    public final int size;
    public final int offset;

    public SubBuffer(byte[] byArray, int n, int n2) {
        this.data = byArray;
        this.size = n;
        this.offset = n2;
    }

    public SubBuffer(byte[] byArray, int n) {
        this(byArray, n, 0);
    }

    public SubBuffer(byte[] byArray) {
        this(byArray, byArray != null ? byArray.length : 0, 0);
    }

    public static byte[] concat(SubBuffer subBuffer, SubBuffer subBuffer2) {
        int n = 0;
        int n2 = 0;
        if (subBuffer != null) {
            n += subBuffer.size;
            n2 = subBuffer.size;
        }
        if (subBuffer2 != null) {
            n += subBuffer2.size;
        }
        byte[] byArray = new byte[n];
        if (subBuffer != null && subBuffer.data != null && subBuffer.size > 0) {
            System.arraycopy((Object)subBuffer.data, subBuffer.offset, (Object)byArray, 0, subBuffer.size);
        }
        if (subBuffer2 != null && subBuffer2.data != null && subBuffer2.size > 0) {
            System.arraycopy((Object)subBuffer2.data, subBuffer2.offset, (Object)byArray, n2, subBuffer2.size);
        }
        return byArray;
    }
}

