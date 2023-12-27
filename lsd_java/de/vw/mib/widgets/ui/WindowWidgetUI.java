/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ContainerUI;

public final class WindowWidgetUI
extends ContainerUI {
    private static Rectangle clippingAreaDefault = new Rectangle();

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        clippingAreaDefault.setBounds(0, 0, widgetModel.get_width(), widgetModel.get_height());
        this.enableClipping(graphics3D, rectangle, clippingAreaDefault, rectangle2);
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        this.disableClipping(graphics3D);
    }
}

