/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.queue;

import de.esolutions.fw.util.commons.queue.MyQueue$Node;

public class MyQueue {
    private MyQueue$Node first;
    private MyQueue$Node last;
    private int size;
    private static int karpottCounter;

    public void dump() {
        System.out.println("----- MyQueue Dump -----");
        System.out.println(new StringBuffer().append("first=").append(this.first).append(", last=").append(this.last).append(", size=").append(this.size).toString());
        MyQueue$Node myQueue$Node = this.first;
        int n = 0;
        while (myQueue$Node != null) {
            System.out.println(new StringBuffer().append("[#").append(n).append(":data=").append(myQueue$Node.data).append(",").append(myQueue$Node.data.getClass().getName()).append("]").toString());
            myQueue$Node = myQueue$Node.next;
            ++n;
        }
        System.out.println("----- Done Dump -----");
    }

    public void push(Object object) {
        MyQueue$Node myQueue$Node = new MyQueue$Node(object);
        if (this.last == null) {
            this.first = myQueue$Node;
            this.last = myQueue$Node;
        } else {
            this.last.next = myQueue$Node;
            this.last = myQueue$Node;
        }
        ++this.size;
    }

    public Object pop() {
        if (this.first == null) {
            return null;
        }
        Object object = this.first.data;
        --this.size;
        if (this.first.next == null) {
            this.first = null;
            this.last = null;
            this.sanityCheck(true);
        } else {
            this.first = this.first.next;
        }
        return object;
    }

    public int size() {
        this.sanityCheck(false);
        return this.size;
    }

    public boolean isEmpty() {
        this.sanityCheck(false);
        return this.first == null;
    }

    private void sanityCheck(boolean bl) {
        if (this.size > 0 && this.first == null) {
            if (++karpottCounter <= 3) {
                System.out.println(new StringBuffer().append("#### MyQueue is karpott: size=").append(this.size).append(" but first==null. counter=").append(karpottCounter).toString());
            } else if (bl) {
                throw new RuntimeException("MyQueue is karpott");
            }
            this.size = 0;
        }
    }
}

