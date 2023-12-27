/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;
import java.util.Collection;

public abstract class WaitQueue {
    public abstract void insert(WaitNode waitNode) {
    }

    public abstract WaitNode extract() {
    }

    public abstract void putBack(WaitNode waitNode) {
    }

    public abstract boolean hasNodes() {
    }

    public abstract int getLength() {
    }

    public abstract Collection getWaitingThreads() {
    }

    public abstract boolean isWaiting(Thread thread) {
    }
}

