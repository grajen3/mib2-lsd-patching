/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface TouchDelegatable {
    default public void findActiveWidgets(List list, TouchEvent touchEvent) {
    }

    default public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
    }

    default public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
    }
}

