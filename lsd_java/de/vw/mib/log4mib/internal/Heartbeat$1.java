/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.internal.AbstractMessage;
import de.vw.mib.log4mib.internal.Heartbeat;

class Heartbeat$1
extends AbstractMessage {
    private final /* synthetic */ Heartbeat this$0;

    Heartbeat$1(Heartbeat heartbeat) {
        this.this$0 = heartbeat;
    }

    @Override
    public short getType() {
        return 0;
    }

    @Override
    long getTime() {
        return 0L;
    }

    @Override
    void dispatchMessage() {
        this.this$0.loggingThreadWorks();
    }
}

