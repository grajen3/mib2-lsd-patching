/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.proxy;

public final class InvocationItem {
    InvocationItem next;
    int syncReqIdx = -1;
    Object[] args;
    int targetId = -1;
    int syncRespIdx;
    public long reqTs = 0L;

    void reset() {
        this.next = null;
        this.syncReqIdx = -1;
        this.args = null;
        this.targetId = -1;
        this.syncRespIdx = -1;
        this.reqTs = 0L;
    }
}

