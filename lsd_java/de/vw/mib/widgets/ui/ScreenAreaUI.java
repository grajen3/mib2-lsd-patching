/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleGradientDrawable;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TransformContainerUI;

public final class ScreenAreaUI
extends TransformContainerUI {
    private static final boolean CLIPPING_ENABLED;
    private static final Color4f[] DEBUG_GRADIENT_COLORS;
    private static final Gradient DEBUG_GRADIENT;
    private static final boolean DEBUG_BACKGROUND_ENABLED;
    private Rectangle clipArea;
    private RectangleGradientDrawable debugGradientDrawable;

    @Override
    public void deInit() {
        if (this.clipArea != null) {
            this.clipArea = null;
        }
        if (this.debugGradientDrawable != null) {
            this.debugGradientDrawable.dispose();
            this.debugGradientDrawable = null;
        }
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ScreenAreaModel screenAreaModel = (ScreenAreaModel)widgetModel;
        WidgetModel[] widgetModelArray = screenAreaModel.getChildren();
        if (widgetModelArray != null && widgetModelArray.length > 0 || DEBUG_BACKGROUND_ENABLED) {
            if (this.clipArea == null) {
                this.clipArea = new Rectangle();
            }
            this.clipArea.setWidth(screenAreaModel.get_width());
            this.clipArea.setHeight(screenAreaModel.get_height());
            this.enableClipping(graphics3D, rectangle, this.clipArea, rectangle2);
            super.paint(graphics3D, viewModel, widgetModel, this.clipArea, rectangle2, f2);
            this.disableClipping(graphics3D);
        }
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
        if (DEBUG_BACKGROUND_ENABLED) {
            boolean bl = containerModel.isInvalid();
            if (this.debugGradientDrawable == null) {
                bl = true;
                this.debugGradientDrawable = graphics3D.getDrawableManager().createRectangleGradientDrawable();
            }
            if (bl) {
                this.debugGradientDrawable.setGradientColors(DEBUG_GRADIENT_COLORS);
                this.debugGradientDrawable.setGradient(DEBUG_GRADIENT);
                this.debugGradientDrawable.set(0, 0, rectangle2.getWidth(), rectangle2.getHeight());
            }
            this.debugGradientDrawable.draw();
        }
    }

    static {
        DEBUG_GRADIENT_COLORS = new Color4f[]{new Color4f(0.0f, 0.0f, 1.0f, (float)63), new Color4f(0.0f, 1.0f, 0.0f, (float)63), new Color4f(1.0f, 0.0f, 0.0f, (float)63)};
        DEBUG_GRADIENT = new Gradient(2, 50, 50, 0.0f, new float[]{0.0f, 63, 1.0f}, new float[]{0x6666663F, 63});
        DEBUG_BACKGROUND_ENABLED = System.getProperty("de.vw.mib.widgets.highlightscreenarea") != null;
    }
}

