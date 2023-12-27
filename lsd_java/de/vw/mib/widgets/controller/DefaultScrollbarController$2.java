/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultScrollbarController;

class DefaultScrollbarController$2
implements Runnable {
    private final /* synthetic */ DefaultScrollbarController this$0;

    DefaultScrollbarController$2(DefaultScrollbarController defaultScrollbarController) {
        this.this$0 = defaultScrollbarController;
    }

    @Override
    public void run() {
        if (this.this$0.startTimerRunning && !this.this$0.repeatTimerRunning) {
            this.this$0.startTimer.stop();
            this.this$0.startTimerRunning = false;
            this.this$0.repeatTimer.start();
            this.this$0.repeatTimerRunning = true;
            this.this$0.fire_pressed();
        }
    }
}

