/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.Queue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.util.Collection;

public interface BlockingQueue
extends Queue {
    @Override
    default public boolean add(Object object) {
    }

    @Override
    default public boolean offer(Object object) {
    }

    default public void put(Object object) {
    }

    default public boolean offer(Object object, long l, TimeUnit timeUnit) {
    }

    default public Object take() {
    }

    default public Object poll(long l, TimeUnit timeUnit) {
    }

    default public int remainingCapacity() {
    }

    @Override
    default public boolean remove(Object object) {
    }

    @Override
    default public boolean contains(Object object) {
    }

    default public int drainTo(Collection collection) {
    }

    default public int drainTo(Collection collection, int n) {
    }
}

