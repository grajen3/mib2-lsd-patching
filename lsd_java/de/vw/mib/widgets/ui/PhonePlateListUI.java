/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.ui.WidgetListUI;

public final class PhonePlateListUI
extends WidgetListUI {
    @Override
    public void paintListContent(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        this.paintRegularChildren(graphics3D, viewModel, templateListModel, true, rectangle, rectangle2, f2);
        this.viewport.setBounds(widgetListModel.getViewport());
        this.paintItems(graphics3D, viewModel, templateListModel, rectangle, rectangle2, f2);
        this.paintRegularChildren(graphics3D, viewModel, templateListModel, false, rectangle, rectangle2, f2);
    }

    @Override
    protected void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        int n = widgetListModel.getFirstVisibleIndex();
        int n2 = widgetListModel.getLastVisibleIndex();
        if (n != -1 && n2 != -1) {
            boolean bl = viewModel.is_renderBoundingBoxes();
            for (int i2 = n; i2 <= n2; ++i2) {
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, i2);
            }
        }
    }
}

