/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultScrollbarController;
import de.vw.mib.widgets.models.ScrollbarModel;

class DefaultScrollbarController$3
implements Runnable {
    private final /* synthetic */ ScrollbarModel val$scrollbar;
    private final /* synthetic */ DefaultScrollbarController this$0;

    DefaultScrollbarController$3(DefaultScrollbarController defaultScrollbarController, ScrollbarModel scrollbarModel) {
        this.this$0 = defaultScrollbarController;
        this.val$scrollbar = scrollbarModel;
    }

    @Override
    public void run() {
        if (this.this$0.repeatTimerRunning) {
            boolean bl = this.val$scrollbar.isPressed();
            if (!bl) {
                this.this$0.stopTimer();
            } else {
                this.this$0.fire_press();
            }
        }
    }
}

