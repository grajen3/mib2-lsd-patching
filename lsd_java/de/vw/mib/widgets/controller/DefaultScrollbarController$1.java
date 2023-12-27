/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultScrollbarController;
import de.vw.mib.widgets.models.ScrollbarModel;

class DefaultScrollbarController$1
implements Runnable {
    private final /* synthetic */ ScrollbarModel val$scrollbar;
    private final /* synthetic */ String val$eid;
    private final /* synthetic */ DefaultScrollbarController this$0;

    DefaultScrollbarController$1(DefaultScrollbarController defaultScrollbarController, ScrollbarModel scrollbarModel, String string) {
        this.this$0 = defaultScrollbarController;
        this.val$scrollbar = scrollbarModel;
        this.val$eid = string;
    }

    @Override
    public void run() {
        if (!this.val$scrollbar.isScrollbarIndicatorVisibile()) {
            this.this$0.fire_onlyOnePageAvailable();
        } else if (this.val$eid == "selectNextPage") {
            this.this$0.fire_selectNextPage();
        } else if (this.val$eid == "selectPreviousPage") {
            this.this$0.fire_selectPreviousPage();
        } else if (this.val$eid == "selectLastPage") {
            this.this$0.fire_selectLastPage();
        } else if (this.val$eid == "selectFirstPage") {
            this.this$0.fire_selectFirstPage();
        }
    }
}

