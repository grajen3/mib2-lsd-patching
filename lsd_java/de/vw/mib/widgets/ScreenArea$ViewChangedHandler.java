/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.ScreenArea;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.event.ViewAdapter;

final class ScreenArea$ViewChangedHandler
extends ViewAdapter {
    private final /* synthetic */ ScreenArea this$0;

    public ScreenArea$ViewChangedHandler(ScreenArea screenArea) {
        this.this$0 = screenArea;
    }

    @Override
    public void viewInited(View view) {
        if (view.get_width() < this.this$0.get_width()) {
            switch (this.this$0.get_viewAlignment()) {
                case 1: {
                    this.this$0.startMoveInViewAnimation(-view.get_width(), 0, view);
                    view.set_x(0);
                    break;
                }
                case 2: {
                    this.this$0.startMoveInViewAnimation(this.this$0.get_width(), this.this$0.get_width() - view.get_width(), view);
                    view.set_x(this.this$0.get_width() - view.get_width());
                    break;
                }
            }
        }
    }

    @Override
    public void viewLeft(View view) {
        if (view.get_width() < this.this$0.get_width()) {
            switch (this.this$0.get_viewAlignment()) {
                case 1: {
                    this.this$0.startMoveOutViewAnimation(0, -view.get_width(), view);
                    break;
                }
                case 2: {
                    this.this$0.startMoveOutViewAnimation(this.this$0.get_width() - view.get_width(), this.this$0.get_width(), view);
                    break;
                }
            }
        }
    }
}

