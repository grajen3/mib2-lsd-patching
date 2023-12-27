/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.AbstractImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;

public abstract class AbstractImageUI
extends AbstractWidgetUI {
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractImageModel abstractImageModel = (AbstractImageModel)widgetModel;
        Color color = abstractImageModel.is_colorEnabled() ? abstractImageModel.get_color() : Color.WHITE;
        this.paintImage(graphics3D, viewModel, widgetModel, rectangle, rectangle2, color.getCurrentColor(), f2);
    }

    protected abstract void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
    }
}

