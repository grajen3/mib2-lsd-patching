/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultPreviewLineController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.models.PreviewLineModel;

class DefaultPreviewLineController$InactiveAreaClosedHandler
extends OutEventAdapter {
    private int previewLineContent = -1;
    private final /* synthetic */ DefaultPreviewLineController this$0;

    public DefaultPreviewLineController$InactiveAreaClosedHandler(DefaultPreviewLineController defaultPreviewLineController) {
        this.this$0 = defaultPreviewLineController;
    }

    public void setPreviewLineContent(int n) {
        this.previewLineContent = n;
    }

    @Override
    public void outHMIEventFired(String string) {
        PreviewLineModel previewLineModel = (PreviewLineModel)this.this$0.getWidget();
        previewLineModel.showContent(this.previewLineContent);
        this.this$0.hideInactiveArea();
    }
}

