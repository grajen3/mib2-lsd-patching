/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.Activator$ServiceListenerImpl;

class Activator$ServiceListenerImpl$ClockTimerCallback
implements Runnable {
    private final /* synthetic */ Activator$ServiceListenerImpl this$0;

    Activator$ServiceListenerImpl$ClockTimerCallback(Activator$ServiceListenerImpl activator$ServiceListenerImpl) {
        this.this$0 = activator$ServiceListenerImpl;
    }

    @Override
    public void run() {
        this.this$0.onClockTimer();
    }
}

