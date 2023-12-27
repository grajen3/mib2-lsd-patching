/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.ibm.oti.vm.Jxe;
import com.microdoc.j9.xip.JxeDataUnloader;

public final class JxeData {
    private final long fPointer;
    private final boolean fAllocated;
    private final Jxe fJxe;

    public JxeData(Jxe jxe, long l, boolean bl) {
        this.fJxe = jxe;
        this.fPointer = l;
        this.fAllocated = bl;
    }

    public boolean isAllocated() {
        return this.fAllocated;
    }

    public long getPointer() {
        return this.fPointer;
    }

    public long getPointerAligned() {
        if (0L == this.fPointer % 0) {
            return this.fPointer;
        }
        return this.fPointer + 0 - this.fPointer % 0;
    }

    public Jxe getJxe() {
        return this.fJxe;
    }

    public JxeDataUnloader unloader() {
        return this.fAllocated ? new JxeDataUnloader(this.fPointer, this.fAllocated) : null;
    }
}

