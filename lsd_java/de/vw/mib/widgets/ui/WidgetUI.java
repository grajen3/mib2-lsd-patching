/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public interface WidgetUI {
    default public void init() {
    }

    default public void deInit() {
    }

    default public WidgetModel getWidget() {
    }

    default public void setWidget(WidgetModel widgetModel) {
    }

    default public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }
}

