/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class FIFOWaitQueue
extends WaitQueue
implements Serializable {
    private static final long serialVersionUID;
    protected transient WaitQueue$WaitNode head_ = null;
    protected transient WaitQueue$WaitNode tail_ = null;

    @Override
    public void insert(WaitQueue$WaitNode waitQueue$WaitNode) {
        if (this.tail_ == null) {
            this.head_ = this.tail_ = waitQueue$WaitNode;
        } else {
            this.tail_.next = waitQueue$WaitNode;
            this.tail_ = waitQueue$WaitNode;
        }
    }

    @Override
    public WaitQueue$WaitNode extract() {
        if (this.head_ == null) {
            return null;
        }
        WaitQueue$WaitNode waitQueue$WaitNode = this.head_;
        this.head_ = waitQueue$WaitNode.next;
        if (this.head_ == null) {
            this.tail_ = null;
        }
        waitQueue$WaitNode.next = null;
        return waitQueue$WaitNode;
    }

    @Override
    public void putBack(WaitQueue$WaitNode waitQueue$WaitNode) {
        waitQueue$WaitNode.next = this.head_;
        this.head_ = waitQueue$WaitNode;
        if (this.tail_ == null) {
            this.tail_ = waitQueue$WaitNode;
        }
    }

    @Override
    public boolean hasNodes() {
        return this.head_ != null;
    }

    @Override
    public int getLength() {
        int n = 0;
        WaitQueue$WaitNode waitQueue$WaitNode = this.head_;
        while (waitQueue$WaitNode != null) {
            if (waitQueue$WaitNode.waiting) {
                ++n;
            }
            waitQueue$WaitNode = waitQueue$WaitNode.next;
        }
        return n;
    }

    @Override
    public Collection getWaitingThreads() {
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        WaitQueue$WaitNode waitQueue$WaitNode = this.head_;
        while (waitQueue$WaitNode != null) {
            if (waitQueue$WaitNode.waiting) {
                arrayList.add(waitQueue$WaitNode.owner);
            }
            waitQueue$WaitNode = waitQueue$WaitNode.next;
        }
        return arrayList;
    }

    @Override
    public boolean isWaiting(Thread thread) {
        if (thread == null) {
            throw new NullPointerException();
        }
        WaitQueue$WaitNode waitQueue$WaitNode = this.head_;
        while (waitQueue$WaitNode != null) {
            if (waitQueue$WaitNode.waiting && waitQueue$WaitNode.owner == thread) {
                return true;
            }
            waitQueue$WaitNode = waitQueue$WaitNode.next;
        }
        return false;
    }
}

