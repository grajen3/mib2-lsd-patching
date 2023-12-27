/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.microdoc.j9.xip.XIPClassLoader;

public final class JxeDataUnloader {
    private final long fPointer;
    private final boolean fAllocated;

    public JxeDataUnloader(long l, boolean bl) {
        this.fPointer = l;
        this.fAllocated = bl;
    }

    public boolean isAllocated() {
        return this.fAllocated;
    }

    public long getPointer() {
        return this.fPointer;
    }

    protected void finalize() {
        System.out.println(new StringBuffer("JxeDataUnloader.finalize() ").append(this.fAllocated).append(" ").append(this.fPointer).toString());
        if (this.fAllocated) {
            XIPClassLoader.unloadJXEDataimpl(this.fPointer);
        }
    }
}

