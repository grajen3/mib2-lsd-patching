/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.AbstractTemplateListController;
import de.vw.mib.widgets.event.ViewAdapter;

final class AbstractTemplateListController$ViewChangedHandler
extends ViewAdapter {
    private final /* synthetic */ AbstractTemplateListController this$0;

    public AbstractTemplateListController$ViewChangedHandler(AbstractTemplateListController abstractTemplateListController) {
        this.this$0 = abstractTemplateListController;
    }

    @Override
    public void viewCovered() {
        this.this$0.fire_release();
    }
}

