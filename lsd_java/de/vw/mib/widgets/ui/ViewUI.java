/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TransformContainerUI;

public class ViewUI
extends TransformContainerUI {
    private RectangleDrawable backgroundDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.dispose();
            this.backgroundDrawable = null;
        }
        super.deInit();
    }

    @Override
    public final void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        boolean bl;
        super.paint(graphics3D, (ViewModel)widgetModel, widgetModel, rectangle, rectangle2, f2);
        boolean bl2 = bl = viewModel != null && viewModel.is_renderBoundingBoxes();
        if (!AbstractWidget.DIRTY_REGION_MANAGEMENT && (bl && !DEBUG_REPAINT || DEBUG_REPAINT && viewModel.isDirty())) {
            this.paintBoundingBox(graphics3D, rectangle2);
        }
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        Color4b color4b;
        ViewModel viewModel2 = (ViewModel)containerModel;
        if (viewModel2.isInvalid() && !(color4b = viewModel2.get_colorBackground().getCurrentColor()).isFullyTransparent()) {
            if (this.backgroundDrawable == null) {
                this.backgroundDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
            }
            this.backgroundDrawable.set(0, 0, rectangle2.getWidth(), rectangle2.getHeight());
        }
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.setAlpha(f2);
            this.backgroundDrawable.setColor(viewModel2.get_colorBackground().getCurrentColor());
            this.backgroundDrawable.draw();
        }
        super.paintContent(graphics3D, viewModel2, containerModel, rectangle, rectangle2, f2);
    }
}

