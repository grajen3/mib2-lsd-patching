/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultTouchAreaController;

class DefaultTouchAreaController$1
implements Runnable {
    private final /* synthetic */ DefaultTouchAreaController this$0;

    DefaultTouchAreaController$1(DefaultTouchAreaController defaultTouchAreaController) {
        this.this$0 = defaultTouchAreaController;
    }

    @Override
    public void run() {
        this.this$0.fireEvent("longPressed", this.this$0.initialTouchPoint.getX(), this.this$0.initialTouchPoint.getY(), 0, 0);
    }
}

