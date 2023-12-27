/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ReferenceWidgetModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI;

public final class ReferenceWidgetUI
extends ContainerUI {
    private Rectangle childBounds = new Rectangle();

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ReferenceWidgetModel referenceWidgetModel = (ReferenceWidgetModel)widgetModel;
        WidgetModel widgetModel2 = referenceWidgetModel.getReferencedWidget();
        if (widgetModel2 != null && widgetModel2.isPaintable()) {
            float f3 = f2 * AbstractWidgetUI.normalizeAlpha(widgetModel2.get_alpha());
            widgetModel2.paint(graphics3D, viewModel, rectangle, rectangle2, f3);
            if (viewModel.is_renderBoundingBoxes()) {
                this.childBounds.setBounds(rectangle2.x + widgetModel.get_x(), rectangle2.y + widgetModel.get_y(), widgetModel.get_width(), widgetModel.get_height());
                this.paintBoundingBox(graphics3D, this.childBounds);
            }
        } else {
            super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        }
    }
}

