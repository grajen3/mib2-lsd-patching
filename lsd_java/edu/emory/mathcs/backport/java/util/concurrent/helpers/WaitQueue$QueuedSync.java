/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;

public interface WaitQueue$QueuedSync {
    default public boolean recheck(WaitQueue$WaitNode waitQueue$WaitNode) {
    }

    default public void takeOver(WaitQueue$WaitNode waitQueue$WaitNode) {
    }
}

