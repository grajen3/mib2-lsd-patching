/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.models.WidgetModel;

public interface ColorChooserController
extends WidgetController {
    public static final String IN_PREVIOUSCOLOR_NAME;
    public static final String IN_NEXTCOLOR_NAME;
    public static final String OUT_COLORCHANGED_NAME;

    default public void fire_drag() {
    }

    default public void fire_colorChanged() {
    }

    default public OutEventListener[] createButtonListeners(WidgetModel[] widgetModelArray) {
    }

    default public void deInitOutEventlisteners() {
    }
}

