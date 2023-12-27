/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.DefaultPushButtonController;

class DefaultPushButtonController$5
implements Runnable {
    private final /* synthetic */ Timer val$primary;
    private final /* synthetic */ Timer val$primaryRepeat;
    private final /* synthetic */ Timer val$secondaryRepeat;
    private final /* synthetic */ DefaultPushButtonController this$0;

    DefaultPushButtonController$5(DefaultPushButtonController defaultPushButtonController, Timer timer, Timer timer2, Timer timer3) {
        this.this$0 = defaultPushButtonController;
        this.val$primary = timer;
        this.val$primaryRepeat = timer2;
        this.val$secondaryRepeat = timer3;
    }

    @Override
    public void run() {
        if (!this.val$primary.isStarted() && this.val$primaryRepeat.isStarted()) {
            this.val$primaryRepeat.stop();
            this.val$secondaryRepeat.start();
        }
    }
}

