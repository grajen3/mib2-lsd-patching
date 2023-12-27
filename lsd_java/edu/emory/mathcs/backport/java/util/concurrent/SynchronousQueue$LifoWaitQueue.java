/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$Node;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$WaitQueue;
import java.io.Serializable;

final class SynchronousQueue$LifoWaitQueue
extends SynchronousQueue$WaitQueue
implements Serializable {
    private static final long serialVersionUID;
    private transient SynchronousQueue$Node head;

    SynchronousQueue$LifoWaitQueue() {
    }

    @Override
    SynchronousQueue$Node enq(Object object) {
        this.head = new SynchronousQueue$Node(object, this.head);
        return this.head;
    }

    @Override
    SynchronousQueue$Node deq() {
        SynchronousQueue$Node synchronousQueue$Node = this.head;
        if (synchronousQueue$Node != null) {
            this.head = synchronousQueue$Node.next;
            synchronousQueue$Node.next = null;
        }
        return synchronousQueue$Node;
    }

    @Override
    boolean shouldUnlink(SynchronousQueue$Node synchronousQueue$Node) {
        return synchronousQueue$Node == this.head || synchronousQueue$Node.next != null;
    }

    @Override
    void unlink(SynchronousQueue$Node synchronousQueue$Node) {
        SynchronousQueue$Node synchronousQueue$Node2 = this.head;
        SynchronousQueue$Node synchronousQueue$Node3 = null;
        while (synchronousQueue$Node2 != null) {
            if (synchronousQueue$Node2 == synchronousQueue$Node) {
                SynchronousQueue$Node synchronousQueue$Node4 = synchronousQueue$Node2.next;
                if (synchronousQueue$Node3 == null) {
                    this.head = synchronousQueue$Node4;
                    break;
                }
                synchronousQueue$Node3.next = synchronousQueue$Node4;
                break;
            }
            synchronousQueue$Node3 = synchronousQueue$Node2;
            synchronousQueue$Node2 = synchronousQueue$Node2.next;
        }
    }
}

