/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTimerWidgetController;
import de.vw.mib.widgets.event.ViewAdapter;

public final class DefaultTimerWidgetController$ViewChangedHandler
extends ViewAdapter {
    private final /* synthetic */ DefaultTimerWidgetController this$0;

    public DefaultTimerWidgetController$ViewChangedHandler(DefaultTimerWidgetController defaultTimerWidgetController) {
        this.this$0 = defaultTimerWidgetController;
    }

    @Override
    public void viewCovered() {
        if (this.this$0.startTimerRunning || this.this$0.restartTimerRunning) {
            this.this$0.fire_stopTimer();
            this.this$0.timerSuspended = true;
        }
    }

    @Override
    public void viewUncovered() {
        if (this.this$0.timerSuspended) {
            this.this$0.fire_startTimer();
            this.this$0.timerSuspended = false;
        }
    }
}

