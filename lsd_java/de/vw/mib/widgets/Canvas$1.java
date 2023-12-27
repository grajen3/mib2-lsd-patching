/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.Canvas;

class Canvas$1
implements Runnable {
    private final /* synthetic */ Canvas this$0;

    Canvas$1(Canvas canvas) {
        this.this$0 = canvas;
    }

    @Override
    public void run() {
        this.this$0.setInternalStateFlag(19, false);
        this.this$0.performScreenshotUpdate();
    }
}

