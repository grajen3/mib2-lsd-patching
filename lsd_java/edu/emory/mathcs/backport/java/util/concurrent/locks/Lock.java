/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;

public interface Lock {
    default public void lock() {
    }

    default public void lockInterruptibly() {
    }

    default public boolean tryLock() {
    }

    default public boolean tryLock(long l, TimeUnit timeUnit) {
    }

    default public void unlock() {
    }

    default public Condition newCondition() {
    }
}

