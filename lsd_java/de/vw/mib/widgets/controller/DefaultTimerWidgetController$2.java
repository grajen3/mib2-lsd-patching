/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTimerWidgetController;

class DefaultTimerWidgetController$2
implements Runnable {
    private final /* synthetic */ DefaultTimerWidgetController this$0;

    DefaultTimerWidgetController$2(DefaultTimerWidgetController defaultTimerWidgetController) {
        this.this$0 = defaultTimerWidgetController;
    }

    @Override
    public void run() {
        this.this$0.fire_timerElapsed();
        this.this$0.restartTimerRunning = false;
    }
}

