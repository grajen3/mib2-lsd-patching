/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageGradientDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.interfaces.Glowable$GlowDecoratonConfigurator;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import de.vw.mib.widgets.ui.util.EffectDecorator;
import java.io.IOException;

public final class StaticImageUI
extends AbstractImageUI
implements DecoratableUI {
    private ScaleImageDrawable imageDrawable;
    private ScaleImageDrawable previousImageDrawable;
    private EffectDecorator effectDecorator;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.imageDrawable != null) {
            this.imageDrawable.dispose();
            this.imageDrawable = null;
        }
        if (this.previousImageDrawable != null) {
            this.previousImageDrawable.dispose();
            this.previousImageDrawable = null;
        }
        if (this.effectDecorator != null) {
            this.effectDecorator.dispose();
            this.effectDecorator = null;
        }
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        StaticImageModel staticImageModel = (StaticImageModel)widgetModel;
        Image image = staticImageModel.get_image();
        Image image2 = staticImageModel.getPreviousImage();
        if (staticImageModel.isDirty() && this.effectDecorator != null) {
            this.effectDecorator.invalidate();
        }
        if (image != null && !image.getCurrentImage().isEmpty() || image2 != null && !image2.getCurrentImage().isEmpty()) {
            if (staticImageModel.get_glowType() != 0 && staticImageModel.getGlowAlpha() > 0.0f) {
                if (this.effectDecorator == null) {
                    this.effectDecorator = new EffectDecorator(this);
                    Glowable$GlowDecoratonConfigurator.configureGlowEffect(staticImageModel.get_glowType(), this.effectDecorator, staticImageModel.get_glowColor().getCurrentColor());
                }
                this.effectDecorator.draw(graphics3D, rectangle, rectangle2, f2 * staticImageModel.getGlowAlpha());
            }
            super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        }
    }

    protected void paintStaticImageContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
    }

    public void paintDecoratableWidgetContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
    }

    @Override
    public void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        StaticImageModel staticImageModel = (StaticImageModel)widgetModel;
        Image image = staticImageModel.get_image();
        if (image == null) {
            this.paintUnavailable(graphics3D, widgetModel);
        } else {
            boolean bl = staticImageModel.isInvalid();
            float f3 = 1.0f;
            Image image2 = staticImageModel.getPreviousImage();
            if (image2 != null && !image2.getCurrentImage().isEmpty()) {
                f3 = staticImageModel.getBlendAlpha();
                if (bl || this.previousImageDrawable == null || this.previousImageDrawable.getImage() == null) {
                    this.previousImageDrawable = StaticImageUI.updateDrawable(graphics3D, staticImageModel, rectangle2, image2, staticImageModel.get_width(), staticImageModel.get_height(), this.previousImageDrawable);
                }
                this.previousImageDrawable.setColor(color4b);
                this.previousImageDrawable.setAlpha(f2 * (1.0f - f3));
                this.previousImageDrawable.draw();
            } else if (this.previousImageDrawable != null) {
                this.previousImageDrawable.dispose();
                this.previousImageDrawable = null;
            }
            if (!image.getCurrentImage().isEmpty()) {
                if (bl || this.imageDrawable == null || this.imageDrawable.getImage() == null) {
                    this.imageDrawable = StaticImageUI.updateDrawable(graphics3D, staticImageModel, rectangle2, image, staticImageModel.get_width(), staticImageModel.get_height(), this.imageDrawable);
                }
                if (this.imageDrawable != null) {
                    this.imageDrawable.setColor(color4b);
                    this.imageDrawable.setAlpha(f2 * f3);
                    this.imageDrawable.draw();
                }
            }
        }
    }

    private static Color4f[] getCurrentColors(Color[] colorArray) {
        Color4f[] color4fArray = new Color4f[colorArray.length];
        for (int i2 = 0; i2 < colorArray.length; ++i2) {
            Color4b color4b = colorArray[i2].getCurrentColor();
            color4fArray[i2] = new Color4f(color4b.getRed(), color4b.getGreen(), color4b.getBlue(), color4b.getAlpha());
        }
        return color4fArray;
    }

    private static void updateGradient(WidgetModel widgetModel, Rectangle rectangle, ScaleImageGradientDrawable scaleImageGradientDrawable, Gradient gradient, Color[] colorArray) {
        scaleImageGradientDrawable.setAbsolutePosition(rectangle.getX(), rectangle.getY());
        scaleImageGradientDrawable.setReferenceAreaSize(widgetModel.getView().get_width(), widgetModel.getView().get_height());
        scaleImageGradientDrawable.setGradientColors(StaticImageUI.getCurrentColors(colorArray));
        scaleImageGradientDrawable.setGradient(gradient);
    }

    private static ScaleImageDrawable updateDrawable(Graphics3D graphics3D, StaticImageModel staticImageModel, Rectangle rectangle, Image image, int n, int n2, ScaleImageDrawable scaleImageDrawable) {
        Gradient gradient = staticImageModel.get_gradient();
        Color[] colorArray = staticImageModel.get_gradientColors();
        if (gradient != null && gradient.getGradientType() != 0 && colorArray.length > 0 && gradient.getColorPositions().length == colorArray.length && gradient.getColorTransitions().length == colorArray.length - 1) {
            ScaleImageGradientDrawable scaleImageGradientDrawable = graphics3D.getDrawableManager().createScaleImageGradientDrawable();
            StaticImageUI.updateGradient(staticImageModel, rectangle, scaleImageGradientDrawable, gradient, colorArray);
            scaleImageDrawable = scaleImageGradientDrawable;
        }
        try {
            scaleImageDrawable = StaticImageUI.updateScaleImageDrawable(graphics3D, staticImageModel, scaleImageDrawable, image, n, n2);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(4);
            logMessage.append("Widget '").append(staticImageModel.getQualifiedName()).append("': Unable to load image (").append(image).append("): ").append(iOException).log();
        }
        return scaleImageDrawable;
    }

    @Override
    public void drawDecoratableContent(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2) {
        WidgetModel widgetModel = this.getWidget();
        ViewModel viewModel = widgetModel.getView();
        this.paintStaticImageContent(graphics3D, viewModel, widgetModel, rectangle, rectangle2, 1.0f);
    }
}

