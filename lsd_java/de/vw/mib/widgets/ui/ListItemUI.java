/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TransformContainerUI;

public final class ListItemUI
extends TransformContainerUI {
    public static final boolean LIST_DEBUG = System.getProperty("de.vw.mib.widgets.listdebug") != null;

    @Override
    protected void paintChild(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, float f2, boolean bl) {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        if (listItemModel.isDummy()) {
            if (widgetModel == listItemModel.get_dummyContentRef()) {
                super.paintChild(graphics3D, viewModel, widgetModel, rectangle, rectangle2, rectangle3, f2, bl);
            }
        } else if (widgetModel != listItemModel.get_dummyContentRef()) {
            super.paintChild(graphics3D, viewModel, widgetModel, rectangle, rectangle2, rectangle3, f2, bl);
        }
        if (LIST_DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("A: ").append(listItemModel.getAbsoluteIndex()).append(" | D: ").append(listItemModel.get_dynamicIndex()).append(" | ").append(listItemModel.get_name());
            this.drawDebugText(graphics3D, 20, 20, stringBuilder.toString(), Color4f.RED);
            this.paintBoundingBox(graphics3D, rectangle2);
        }
    }
}

