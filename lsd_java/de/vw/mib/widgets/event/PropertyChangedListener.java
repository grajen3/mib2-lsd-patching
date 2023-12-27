/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.widgets.models.WidgetModel;

public interface PropertyChangedListener {
    default public void propertyChanged(WidgetModel widgetModel, int n) {
    }
}

