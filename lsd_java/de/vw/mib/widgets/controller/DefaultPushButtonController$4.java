/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.DefaultPushButtonController;
import de.vw.mib.widgets.models.ButtonModel;

class DefaultPushButtonController$4
implements Runnable {
    private final /* synthetic */ Timer val$primaryRepeat;
    private final /* synthetic */ ButtonModel val$buttonModel;
    private final /* synthetic */ DefaultPushButtonController this$0;

    DefaultPushButtonController$4(DefaultPushButtonController defaultPushButtonController, Timer timer, ButtonModel buttonModel) {
        this.this$0 = defaultPushButtonController;
        this.val$primaryRepeat = timer;
        this.val$buttonModel = buttonModel;
    }

    @Override
    public void run() {
        if (this.val$primaryRepeat.isStarted()) {
            if (this.val$buttonModel.isPressed()) {
                this.this$0.fire_pressed();
            } else {
                this.this$0.fire_cancelled();
            }
        }
    }
}

