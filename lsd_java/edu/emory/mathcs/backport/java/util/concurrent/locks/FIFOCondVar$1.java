/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$QueuedSync;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;

class FIFOCondVar$1
implements WaitQueue$QueuedSync {
    FIFOCondVar$1() {
    }

    @Override
    public boolean recheck(WaitQueue$WaitNode waitQueue$WaitNode) {
        return false;
    }

    @Override
    public void takeOver(WaitQueue$WaitNode waitQueue$WaitNode) {
    }
}

