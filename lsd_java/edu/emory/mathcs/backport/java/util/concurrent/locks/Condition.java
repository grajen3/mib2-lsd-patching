/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Date;

public interface Condition {
    default public void await() {
    }

    default public void awaitUninterruptibly() {
    }

    default public boolean await(long l, TimeUnit timeUnit) {
    }

    default public boolean awaitUntil(Date date) {
    }

    default public void signal() {
    }

    default public void signalAll() {
    }
}

