/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.DefaultPushButtonController;

class DefaultPushButtonController$2
implements Runnable {
    private final /* synthetic */ Timer val$primary;
    private final /* synthetic */ DefaultPushButtonController this$0;

    DefaultPushButtonController$2(DefaultPushButtonController defaultPushButtonController, Timer timer) {
        this.this$0 = defaultPushButtonController;
        this.val$primary = timer;
    }

    @Override
    public void run() {
        if (this.val$primary.isStarted()) {
            this.this$0.fire_longPressed();
        }
    }
}

