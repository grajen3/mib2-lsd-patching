/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultColorChooserController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventAdapter;

class DefaultColorChooserController$ButtonListener
extends OutEventAdapter {
    private int buttonIndex = -1;
    private WidgetController outEventChanger;
    private final /* synthetic */ DefaultColorChooserController this$0;

    public DefaultColorChooserController$ButtonListener(DefaultColorChooserController defaultColorChooserController, int n, WidgetController widgetController) {
        this.this$0 = defaultColorChooserController;
        this.buttonIndex = n;
        this.outEventChanger = widgetController;
    }

    public void deInit() {
        if (this.outEventChanger != null) {
            this.outEventChanger.removeOutEventListener(this);
        }
    }

    @Override
    public void outHMIEventFired(String string) {
        if ("released".equals(string)) {
            this.this$0.updatedColorIndex = this.buttonIndex;
            this.this$0.fire_colorChanged();
        }
    }
}

