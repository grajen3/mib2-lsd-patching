/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleGradientDrawable;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.ColorChooserModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractButtonUI;
import java.io.IOException;

public class ColorChooserUI
extends AbstractButtonUI {
    private static final Gradient DEFAULT_LINEAR_GRADIENT = new Gradient(1, 0, 0, 0.0f, new float[]{0.0f, 1.0f}, new float[]{63});
    private ScaleImageDrawable backgroundDrawable;
    private ScaleImageDrawable foregroundDrawable;
    private RectangleGradientDrawable[] gradientDrawables;
    private RectangleDrawable[] rectangleDrawables;

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public void deInit() {
        this.disposeDrawableAndLog(this.backgroundDrawable, "background drawable");
        this.backgroundDrawable = null;
        this.disposeDrawableAndLog(this.foregroundDrawable, "foreground drawable");
        this.foregroundDrawable = null;
        this.disposeDrawablesAndLog(this.gradientDrawables, "color gradient drawable");
        this.gradientDrawables = null;
        this.disposeDrawablesAndLog(this.rectangleDrawables, "rectangle drawable");
        this.rectangleDrawables = null;
    }

    private void disposeDrawablesAndLog(Drawable[] drawableArray, String string) {
        if (drawableArray != null) {
            for (int i2 = drawableArray.length - 1; i2 >= 0; --i2) {
                this.disposeDrawableAndLog(drawableArray[i2], string);
            }
        }
    }

    private void disposeDrawableAndLog(Drawable drawable, String string) {
        if (drawable != null) {
            drawable.dispose();
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append("ColorChooser '").append(this.getWidget().getQualifiedName()).append("'': Disposed ").append(string).log();
            }
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ColorChooserModel colorChooserModel = (ColorChooserModel)widgetModel;
        if (colorChooserModel.is_visible()) {
            this.paintContent(graphics3D, viewModel, (ContainerModel)widgetModel, rectangle, rectangle2, f2);
        }
    }

    @Override
    public void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ColorChooserModel colorChooserModel = (ColorChooserModel)containerModel;
        this.drawColorArray(graphics3D, colorChooserModel, f2);
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
    }

    protected void drawBackground(Graphics3D graphics3D, ColorChooserModel colorChooserModel) {
        try {
            this.updateBackgroundDrawable(graphics3D, colorChooserModel);
        }
        catch (IOException iOException) {
            return;
        }
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.draw();
        }
    }

    protected void updateBackgroundDrawable(Graphics3D graphics3D, ColorChooserModel colorChooserModel) {
        if (colorChooserModel.get_imageBackgroundRef() != null) {
            this.backgroundDrawable = ColorChooserUI.updateScaleImageDrawable(graphics3D, colorChooserModel, this.backgroundDrawable, colorChooserModel.get_imageBackgroundRef().get_image());
        }
    }

    protected void drawColorArray(Graphics3D graphics3D, ColorChooserModel colorChooserModel, float f2) {
        switch (colorChooserModel.get_mode()) {
            case 1: {
                this.drawColorGradientsRadial(graphics3D, colorChooserModel, f2);
                break;
            }
            case 2: {
                this.drawColorRectangles(graphics3D, colorChooserModel, f2);
                break;
            }
            default: {
                this.drawColorGradientsLinear(graphics3D, colorChooserModel, f2);
            }
        }
    }

    protected void drawColorGradientsRadial(Graphics3D graphics3D, ColorChooserModel colorChooserModel, float f2) {
    }

    protected void drawColorRectangles(Graphics3D graphics3D, ColorChooserModel colorChooserModel, float f2) {
        if (this.gradientDrawables != null) {
            this.disposeDrawablesAndLog(this.gradientDrawables, "");
            this.gradientDrawables = null;
        }
        if (colorChooserModel.getHMIColors() != null && colorChooserModel.getHMIColors().length > 1) {
            int n = colorChooserModel.getHMIColors().length;
            if (this.rectangleDrawables == null || this.rectangleDrawables.length != n || colorChooserModel.isUpdateColorRepresentation()) {
                this.disposeDrawablesAndLog(this.rectangleDrawables, "color rectangle drawable");
                this.rectangleDrawables = null;
            }
            this.updateRectangleDrawables(graphics3D, colorChooserModel, n);
            this.drawRectangleDrawables(graphics3D, colorChooserModel, f2);
        }
    }

    private RectangleDrawable[] updateRectangleDrawables(Graphics3D graphics3D, ColorChooserModel colorChooserModel, int n) {
        if (this.rectangleDrawables == null) {
            int n2 = colorChooserModel.get_width() - colorChooserModel.get_paddings().getLeft() - colorChooserModel.get_paddings().getRight();
            int n3 = colorChooserModel.get_spacingHorizontal();
            float f2 = (float)n2 / (float)n;
            int n4 = colorChooserModel.get_height() - colorChooserModel.get_paddings().getTop() - colorChooserModel.get_paddings().getBottom();
            Rectangle rectangle = new Rectangle(0, 0, 0, 0);
            this.rectangleDrawables = new RectangleDrawable[n];
            for (int i2 = 0; i2 < this.rectangleDrawables.length; ++i2) {
                this.rectangleDrawables[i2] = graphics3D.getDrawableManager().createRectangleDrawable();
                rectangle.setX(colorChooserModel.getColorsCoordinate()[i2] - Math.round(f2 * 63) + Math.round((float)n3 * 63));
                rectangle.setY(colorChooserModel.get_paddings().getTop());
                rectangle.setWidth(Math.round(f2) - n3);
                rectangle.setHeight(n4);
                this.rectangleDrawables[i2].set(rectangle);
            }
            colorChooserModel.setUpdateColorRepresentation(false);
        }
        return this.rectangleDrawables;
    }

    protected void drawRectangleDrawables(Graphics3D graphics3D, ColorChooserModel colorChooserModel, float f2) {
        graphics3D.pushMatrix(0);
        for (int i2 = 0; i2 < this.rectangleDrawables.length; ++i2) {
            RectangleDrawable rectangleDrawable = this.rectangleDrawables[i2];
            if (rectangleDrawable == null) continue;
            int n = colorChooserModel.getHMIColorForIndex(i2);
            rectangleDrawable.setColor(new Color4f(n));
            rectangleDrawable.setAlpha(f2);
            rectangleDrawable.draw();
        }
        graphics3D.popMatrix(0);
    }

    protected void drawColorGradientsLinear(Graphics3D graphics3D, ColorChooserModel colorChooserModel, float f2) {
        if (this.rectangleDrawables != null) {
            this.disposeDrawablesAndLog(this.rectangleDrawables, "");
            this.rectangleDrawables = null;
        }
        if (colorChooserModel.getHMIColors() != null && colorChooserModel.getHMIColors().length > 1) {
            int n = colorChooserModel.getHMIColors().length - 1;
            if (this.gradientDrawables == null || this.gradientDrawables.length != n || colorChooserModel.isUpdateColorRepresentation()) {
                this.disposeDrawablesAndLog(this.gradientDrawables, "color gradient drawable");
                this.gradientDrawables = null;
            }
            this.updateGradientDrawables(graphics3D, colorChooserModel, n);
            this.drawGradientDrawables(graphics3D, f2);
        }
    }

    private RectangleGradientDrawable[] updateGradientDrawables(Graphics3D graphics3D, ColorChooserModel colorChooserModel, int n) {
        if (this.gradientDrawables == null) {
            int n2 = colorChooserModel.get_height() - colorChooserModel.get_paddings().getTop() - colorChooserModel.get_paddings().getBottom();
            Rectangle rectangle = new Rectangle(0, 0, 0, 0);
            this.gradientDrawables = new RectangleGradientDrawable[n];
            Gradient gradient = DEFAULT_LINEAR_GRADIENT;
            for (int i2 = 0; i2 < this.gradientDrawables.length; ++i2) {
                this.gradientDrawables[i2] = graphics3D.getDrawableManager().createRectangleGradientDrawable();
                rectangle.setX(colorChooserModel.getColorsCoordinate()[i2]);
                rectangle.setY(colorChooserModel.get_paddings().getTop());
                rectangle.setWidth(colorChooserModel.getColorsCoordinate()[i2 + 1] - colorChooserModel.getColorsCoordinate()[i2]);
                rectangle.setHeight(n2);
                this.gradientDrawables[i2].set(rectangle);
                this.gradientDrawables[i2].setGradient(gradient);
                int n3 = colorChooserModel.getHMIColorForIndex(i2);
                int n4 = colorChooserModel.getHMIColorForIndex(i2 + 1);
                this.gradientDrawables[i2].setGradientColors(new Color4f[]{new Color4f(n3), new Color4f(n4)});
            }
            colorChooserModel.setUpdateColorRepresentation(false);
        }
        return this.gradientDrawables;
    }

    private void drawGradientDrawables(Graphics3D graphics3D, float f2) {
        graphics3D.pushMatrix(0);
        for (int i2 = 0; i2 < this.gradientDrawables.length; ++i2) {
            if (this.gradientDrawables[i2] == null) continue;
            this.gradientDrawables[i2].setAlpha(f2);
            this.gradientDrawables[i2].draw();
        }
        graphics3D.popMatrix(0);
    }

    protected void drawForeground(Graphics3D graphics3D, ColorChooserModel colorChooserModel) {
        try {
            this.updateForegroundDrawable(graphics3D, colorChooserModel);
        }
        catch (IOException iOException) {
            return;
        }
        if (this.foregroundDrawable != null) {
            this.foregroundDrawable.draw();
        }
    }

    private void updateForegroundDrawable(Graphics3D graphics3D, ColorChooserModel colorChooserModel) {
        if (colorChooserModel.get_imageForegroundRef() != null) {
            this.foregroundDrawable = ColorChooserUI.updateScaleImageDrawable(graphics3D, colorChooserModel, this.foregroundDrawable, colorChooserModel.get_imageForegroundRef().get_image());
        }
    }
}

