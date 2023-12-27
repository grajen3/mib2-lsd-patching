/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTimerWidgetController;

class DefaultTimerWidgetController$1
implements Runnable {
    private final /* synthetic */ DefaultTimerWidgetController this$0;

    DefaultTimerWidgetController$1(DefaultTimerWidgetController defaultTimerWidgetController) {
        this.this$0 = defaultTimerWidgetController;
    }

    @Override
    public void run() {
        this.this$0.fire_timerElapsed();
        this.this$0.startTimerRunning = false;
    }
}

