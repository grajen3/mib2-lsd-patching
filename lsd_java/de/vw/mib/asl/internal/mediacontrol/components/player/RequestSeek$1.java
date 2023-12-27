/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.components.player.RequestSeek;

class RequestSeek$1
implements Runnable {
    private final /* synthetic */ RequestSeek this$0;

    RequestSeek$1(RequestSeek requestSeek) {
        this.this$0 = requestSeek;
    }

    @Override
    public void run() {
        this.this$0.increaseSeekSpeed();
    }
}

