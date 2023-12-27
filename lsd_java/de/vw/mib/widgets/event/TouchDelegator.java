/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.models.WidgetModel;

public interface TouchDelegator {
    default public boolean forwardTouchEvent(TouchEvent touchEvent) {
    }

    default public WidgetModel getUtilizedWidget() {
    }
}

