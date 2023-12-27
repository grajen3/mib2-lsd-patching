/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;

interface CondVar$ExclusiveLock
extends Lock {
    default public boolean isHeldByCurrentThread() {
    }

    default public int getHoldCount() {
    }
}

