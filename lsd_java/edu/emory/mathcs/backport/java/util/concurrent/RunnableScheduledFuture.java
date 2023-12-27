/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;

public interface RunnableScheduledFuture
extends RunnableFuture,
ScheduledFuture {
    default public boolean isPeriodic() {
    }
}

