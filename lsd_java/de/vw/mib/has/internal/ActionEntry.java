/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASInvocationHandler;
import de.vw.mib.has.internal.HASInvocationImpl;
import de.vw.mib.pool.PoorMansPool;

final class ActionEntry {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static int nextUniqueId;
    private int uniqueId;
    private HASInvocationHandler resultHandler;
    private HASInvocationImpl invocation;
    private int ttl;

    private ActionEntry() {
    }

    private static synchronized ActionEntry borrow() {
        ActionEntry actionEntry = (ActionEntry)POOL.borrow();
        if (null == actionEntry) {
            actionEntry = new ActionEntry();
        }
        actionEntry.uniqueId = nextUniqueId++;
        actionEntry.ttl = 0;
        return actionEntry;
    }

    private static synchronized void release(ActionEntry actionEntry) {
        actionEntry.invocation = null;
        actionEntry.resultHandler = null;
        POOL.release(actionEntry);
    }

    static ActionEntry create(HASInvocationImpl hASInvocationImpl, HASInvocationHandler hASInvocationHandler) {
        ActionEntry actionEntry = ActionEntry.borrow();
        actionEntry.invocation = hASInvocationImpl;
        actionEntry.resultHandler = hASInvocationHandler;
        return actionEntry;
    }

    HASInvocationHandler getResultHandler() {
        return this.resultHandler;
    }

    HASInvocationImpl getInvocation() {
        return this.invocation;
    }

    boolean decreaseTTL(int n) {
        this.ttl = Math.max(0, this.ttl - n);
        return 0 >= this.ttl;
    }

    void setTTL(int n) {
        this.ttl = n;
    }

    int getUniqueId() {
        return this.uniqueId;
    }

    void release() {
        ActionEntry.release(this);
    }

    static {
        POOL = new PoorMansPool("HASActionEntry", 3);
    }
}

