/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.DefaultPushButtonController;

class DefaultPushButtonController$3
implements Runnable {
    private final /* synthetic */ Timer val$primary;
    private final /* synthetic */ Timer val$primaryRepeat;
    private final /* synthetic */ DefaultPushButtonController this$0;

    DefaultPushButtonController$3(DefaultPushButtonController defaultPushButtonController, Timer timer, Timer timer2) {
        this.this$0 = defaultPushButtonController;
        this.val$primary = timer;
        this.val$primaryRepeat = timer2;
    }

    @Override
    public void run() {
        if (this.val$primary.isStarted() && !this.val$primaryRepeat.isStarted()) {
            this.val$primary.stop();
            this.val$primaryRepeat.start();
            this.this$0.fire_pressed();
        }
    }
}

