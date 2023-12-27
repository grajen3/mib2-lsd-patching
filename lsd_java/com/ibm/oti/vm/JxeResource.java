/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

class JxeResource {
    private long pointer;
    private int size;
    private int method;

    JxeResource(long l, int n, int n2) {
        if (l == 0L || n < 0) {
            throw new IllegalArgumentException();
        }
        this.pointer = l;
        this.size = n;
        this.method = n2;
    }

    public long getPointer() {
        return this.pointer;
    }

    public int getSize() {
        return this.size;
    }

    public int getMethod() {
        return this.method;
    }
}

