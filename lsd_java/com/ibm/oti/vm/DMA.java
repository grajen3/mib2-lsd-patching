/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.VM;

public class DMA {
    public DMA() {
        if (VM.callerClassLoader() != null) {
            throw new SecurityException();
        }
    }

    public native byte readByte(long l) {
    }

    public native void writeByte(long l, byte by) {
    }

    public native short readShort(long l) {
    }

    public native void writeShort(long l, short s) {
    }

    public native int readInt(long l) {
    }

    public native void writeInt(long l, int n) {
    }

    public native long readLong(long l) {
    }

    public native void writeLong(long l, long l2) {
    }
}

