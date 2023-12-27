/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.Canvas;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.event.ViewAdapter;

final class Canvas$ViewChangedHandler
extends ViewAdapter {
    private final /* synthetic */ Canvas this$0;

    public Canvas$ViewChangedHandler(Canvas canvas) {
        this.this$0 = canvas;
    }

    @Override
    public void viewEntered(View view) {
        this.this$0.setInternalStateFlag(17, true);
        this.this$0.validateVisibility();
    }

    @Override
    public void viewLeft(View view) {
        this.this$0.setInternalStateFlag(17, false);
        this.this$0.validateVisibility();
    }
}

