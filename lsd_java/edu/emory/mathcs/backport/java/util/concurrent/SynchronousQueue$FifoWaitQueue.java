/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$Node;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$WaitQueue;
import java.io.Serializable;

final class SynchronousQueue$FifoWaitQueue
extends SynchronousQueue$WaitQueue
implements Serializable {
    private static final long serialVersionUID;
    private transient SynchronousQueue$Node head;
    private transient SynchronousQueue$Node last;

    SynchronousQueue$FifoWaitQueue() {
    }

    @Override
    SynchronousQueue$Node enq(Object object) {
        SynchronousQueue$Node synchronousQueue$Node = new SynchronousQueue$Node(object);
        this.last = this.last == null ? (this.head = synchronousQueue$Node) : (this.last.next = synchronousQueue$Node);
        return synchronousQueue$Node;
    }

    @Override
    SynchronousQueue$Node deq() {
        SynchronousQueue$Node synchronousQueue$Node = this.head;
        if (synchronousQueue$Node != null) {
            this.head = synchronousQueue$Node.next;
            if (this.head == null) {
                this.last = null;
            }
            synchronousQueue$Node.next = null;
        }
        return synchronousQueue$Node;
    }

    @Override
    boolean shouldUnlink(SynchronousQueue$Node synchronousQueue$Node) {
        return synchronousQueue$Node == this.last || synchronousQueue$Node.next != null;
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
                } else {
                    synchronousQueue$Node3.next = synchronousQueue$Node4;
                }
                if (this.last != synchronousQueue$Node) break;
                this.last = synchronousQueue$Node3;
                break;
            }
            synchronousQueue$Node3 = synchronousQueue$Node2;
            synchronousQueue$Node2 = synchronousQueue$Node2.next;
        }
    }
}

