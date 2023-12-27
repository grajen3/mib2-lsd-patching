/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public interface Delayed
extends Comparable {
    default public long getDelay(TimeUnit timeUnit) {
    }
}

