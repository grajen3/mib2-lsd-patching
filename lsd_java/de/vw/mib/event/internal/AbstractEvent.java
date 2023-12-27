/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.Event;
import de.vw.mib.log4mib.InvocationContext;

public abstract class AbstractEvent
implements Event {
    static final int INITIAL_STRINGBUFFER_SIZE;
    InvocationContext invocationContext;

    public void backToPool() {
    }

    public abstract void dispatchEvent() {
    }

    public final InvocationContext getInvocationContext() {
        return this.invocationContext;
    }

    public void releaseEvent() {
        this.invocationContext = null;
    }

    public void traceBypass() {
        this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
        InvocationContext invocationContext = this.invocationContext.createSpecificBranch(this.invocationContext.getForkBranchId());
        this.traceEvent((byte)0, (byte)-1);
        this.invocationContext = invocationContext;
        InvocationContext.startInvocationBranch(this.invocationContext, null);
        this.traceEvent((byte)2, (byte)-1);
    }

    public void traceDequeue(byte by) {
        InvocationContext.startInvocationBranch(this.invocationContext, null);
        this.traceEvent((byte)1, by);
    }

    public void traceEnqueue(byte by) {
        this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
        InvocationContext invocationContext = this.invocationContext.createBranch();
        if (InvocationContext.isActive()) {
            this.traceEvent((byte)0, by);
        }
        this.invocationContext = invocationContext;
    }

    abstract void traceEvent(byte by, byte by2) {
    }
}

