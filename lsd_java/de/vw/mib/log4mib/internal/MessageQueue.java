/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.MessageQueue$1;

final class MessageQueue {
    final AbstractMessage EMPTY;
    private int size;
    private AbstractMessage head;
    private AbstractMessage tail;

    MessageQueue() {
        this.tail = this.head = (this.EMPTY = new MessageQueue$1(this));
    }

    synchronized void offer(AbstractMessage abstractMessage) {
        this.enqueue(abstractMessage);
        if (this.size == 1) {
            super.notify();
        }
    }

    synchronized AbstractMessage take() {
        if (this.isEmpty()) {
            try {
                super.wait();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        return this.dequeue();
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.head == this.EMPTY;
    }

    private AbstractMessage dequeue() {
        AbstractMessage abstractMessage = this.head;
        if (!this.isEmpty()) {
            --this.size;
            this.head = abstractMessage.next;
            abstractMessage.next = null;
        }
        return abstractMessage;
    }

    private void enqueue(AbstractMessage abstractMessage) {
        this.tail = this.tail.next = abstractMessage;
        abstractMessage.next = this.EMPTY;
        if (this.isEmpty()) {
            this.head = this.tail;
        }
        ++this.size;
    }
}

