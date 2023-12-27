/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;

final class RadioListScalingUI$PaintData {
    Graphics3D g;
    ViewModel view;
    Rectangle parentBounds;
    float parentAlpha;
    WidgetListModel widgetList;

    void set(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, float f2, WidgetListModel widgetListModel) {
        this.g = graphics3D;
        this.view = viewModel;
        this.parentBounds = rectangle;
        this.parentAlpha = f2;
        this.widgetList = widgetListModel;
    }
}

