/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.MessageQueue;

class MessageQueue$1
extends AbstractMessage {
    private final /* synthetic */ MessageQueue this$0;

    MessageQueue$1(MessageQueue messageQueue) {
        this.this$0 = messageQueue;
    }

    @Override
    public short getType() {
        return -1;
    }

    @Override
    long getTime() {
        return -1L;
    }

    @Override
    void dispatchMessage() {
    }

    public String toString() {
        return "EMPTY QUEUE";
    }
}

