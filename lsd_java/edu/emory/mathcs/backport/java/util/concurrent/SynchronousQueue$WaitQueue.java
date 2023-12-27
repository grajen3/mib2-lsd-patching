/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$Node;
import java.io.Serializable;

abstract class SynchronousQueue$WaitQueue
implements Serializable {
    SynchronousQueue$WaitQueue() {
    }

    abstract SynchronousQueue$Node enq(Object object) {
    }

    abstract SynchronousQueue$Node deq() {
    }

    abstract void unlink(SynchronousQueue$Node synchronousQueue$Node) {
    }

    abstract boolean shouldUnlink(SynchronousQueue$Node synchronousQueue$Node) {
    }
}

