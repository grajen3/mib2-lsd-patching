/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ColorGradientDrawable;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetUI;
import java.io.IOException;

public abstract class AbstractWidgetUI
implements WidgetUI,
PooledObject {
    private static final Color4f DEBUG_BACKGROUND_COLOR = Color4f.BLACK;
    private static final Color4f DEBUG_FOREGROUND_COLOR = Color4f.RED;
    protected static final int DEBUG_FONT_SIZE;
    private static final int DEBUG_FONT_STYLE;
    private static final boolean USE_STENCIL_CLIPPING;
    protected static final boolean IS_DEVELOPMENT_BUILD;
    private static final float ALPHA_NORMALIZE_FACTOR;
    protected static final Logger LOGGER;
    private WidgetModel widget;
    private boolean oldScissorTestEnable;
    private Rectangle oldScissorRect;
    private TextDrawable debugTextDrawable;
    private RectangleDrawable debugRectangleDrawable;
    private PolyLineDrawable debugLineDrawable;
    private RectangleDrawable stencilClippingDrawable;

    public AbstractWidgetUI() {
        this.reset();
    }

    protected void reset() {
        this.widget = null;
    }

    @Override
    public final void backToPool() {
        this.reset();
    }

    @Override
    public void init() {
    }

    @Override
    public void deInit() {
        if (this.debugTextDrawable != null) {
            this.debugTextDrawable.dispose();
            this.debugTextDrawable = null;
        }
        if (this.debugRectangleDrawable != null) {
            this.debugRectangleDrawable.dispose();
            this.debugRectangleDrawable = null;
        }
        if (this.debugLineDrawable != null) {
            this.debugLineDrawable.dispose();
            this.debugLineDrawable = null;
        }
        if (this.stencilClippingDrawable != null) {
            this.stencilClippingDrawable.dispose();
            this.stencilClippingDrawable = null;
        }
    }

    @Override
    public WidgetModel getWidget() {
        return this.widget;
    }

    @Override
    public void setWidget(WidgetModel widgetModel) {
        this.widget = widgetModel;
    }

    @Override
    public abstract void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
    }

    protected final void paintUnavailable(Graphics3D graphics3D, WidgetModel widgetModel) {
        this.drawDebugRectangle(graphics3D, 0, 0, widgetModel.get_width(), widgetModel.get_height(), DEBUG_BACKGROUND_COLOR);
        this.drawDebugLine(graphics3D, 0.0f, 0.0f, widgetModel.get_width(), widgetModel.get_height(), DEBUG_FOREGROUND_COLOR);
        this.drawDebugLine(graphics3D, 0.0f, widgetModel.get_height(), widgetModel.get_width(), 0.0f, DEBUG_FOREGROUND_COLOR);
    }

    protected final void paintUnavailable(Graphics3D graphics3D, WidgetModel widgetModel, String string) {
        this.paintUnavailable(graphics3D, widgetModel);
        if (string != null && string.length() > 0) {
            int n = widgetModel.get_x();
            int n2 = widgetModel.get_height() >> 1;
            this.drawDebugText(graphics3D, n, n2, string, DEBUG_FOREGROUND_COLOR);
        }
    }

    protected void enableClipping(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
        if (USE_STENCIL_CLIPPING) {
            boolean bl = true;
            boolean bl2 = false;
            boolean bl3 = true;
            graphics3D.setColorBufferEnabled(false, false, false, false);
            graphics3D.setStencilBufferEnabled(1);
            graphics3D.clearStencilBuffer(0);
            graphics3D.setStencilTestEnabled(true);
            graphics3D.setStencilTest(7, 1, 1);
            graphics3D.setStencilOperation(0, 0, 2);
            if (this.stencilClippingDrawable == null) {
                this.stencilClippingDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
            }
            Rectangle rectangle4 = AbstractWidget.DIRTY_REGION_MANAGEMENT ? rectangle.intersection(rectangle2) : rectangle2;
            this.stencilClippingDrawable.set(rectangle4);
            this.stencilClippingDrawable.draw();
            graphics3D.setColorBufferEnabled(true, true, true, true);
            graphics3D.setStencilTest(2, 1, 1);
            graphics3D.setStencilOperation(0, 0, 0);
        } else {
            this.oldScissorTestEnable = graphics3D.isScissorTestEnabled();
            if (this.oldScissorRect == null) {
                this.oldScissorRect = new Rectangle();
            }
            graphics3D.getScissor(this.oldScissorRect);
            if (AbstractWidget.DIRTY_REGION_MANAGEMENT) {
                graphics3D.setScissor(rectangle.intersection(new Rectangle(rectangle2.x + rectangle3.x, rectangle2.y + rectangle3.y, rectangle2.width, rectangle2.height)));
            } else {
                Rectangle rectangle5 = this.oldScissorRect.intersection(new Rectangle(rectangle2.x + rectangle3.x, rectangle2.y + rectangle3.y, rectangle2.width, rectangle2.height));
                graphics3D.setScissor(rectangle5);
            }
            graphics3D.setScissorTestEnabled(true);
        }
    }

    protected void disableClipping(Graphics3D graphics3D) {
        if (USE_STENCIL_CLIPPING) {
            graphics3D.setStencilBufferEnabled(0);
            graphics3D.setStencilTestEnabled(false);
        } else {
            graphics3D.setScissor(this.oldScissorRect);
            graphics3D.setScissorTestEnabled(this.oldScissorTestEnable);
        }
    }

    protected final void drawDebugText(Graphics3D graphics3D, int n, int n2, String string) {
        this.drawDebugText(graphics3D, n, n2, string, Color4f.WHITE);
    }

    protected final void drawDebugText(Graphics3D graphics3D, int n, int n2, String string, Color4f color4f) {
        if (this.debugTextDrawable == null) {
            try {
                Font font = ServiceManager.fontManager.getDefaultFont();
                this.debugTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
                this.debugTextDrawable.setFont(font);
                this.debugTextDrawable.setSize(12);
                this.debugTextDrawable.setStyle(0);
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.error(1);
                logMessage.append("AbstractWidgetUI.drawDebugText(): Unable to load default font ").append(iOException).log();
            }
        }
        if (this.debugTextDrawable != null) {
            this.debugTextDrawable.setText(string);
            this.debugTextDrawable.setColor(color4f);
            this.debugTextDrawable.draw(n, n2);
        }
    }

    protected final void drawDebugLine(Graphics3D graphics3D, float f2, float f3, float f4, float f5, Color4f color4f) {
        if (this.debugLineDrawable == null) {
            this.debugLineDrawable = graphics3D.getDrawableManager().createPolyLineDrawable();
            this.debugLineDrawable.setClosed(false);
            this.debugLineDrawable.setStrokeWidth(1.0f);
        }
        this.debugLineDrawable.setCoordinates2D(new Point2f[]{new Point2f(f2, f3), new Point2f(f4, f5)});
        this.debugLineDrawable.setColor(color4f);
        this.debugLineDrawable.draw();
    }

    protected final void drawDebugRectangle(Graphics3D graphics3D, int n, int n2, int n3, int n4, Color4f color4f) {
        if (this.debugRectangleDrawable == null) {
            this.debugRectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
        }
        this.debugRectangleDrawable.set(n, n2, n3, n4);
        this.debugRectangleDrawable.setColor(color4f);
        this.debugRectangleDrawable.draw();
    }

    protected static final ImageDrawable[] updateImageDrawables(Graphics3D graphics3D, WidgetModel widgetModel, ImageDrawable[] imageDrawableArray, BufferImage[] bufferImageArray) {
        if (widgetModel.isInvalid()) {
            if (bufferImageArray == null) {
                AbstractWidgetUI.disposeDrawables(imageDrawableArray);
                imageDrawableArray = new ImageDrawable[]{};
            } else {
                if (imageDrawableArray == null || bufferImageArray.length != imageDrawableArray.length) {
                    AbstractWidgetUI.disposeDrawables(imageDrawableArray);
                    imageDrawableArray = new ImageDrawable[bufferImageArray.length];
                }
                for (int i2 = imageDrawableArray.length - 1; i2 >= 0; --i2) {
                    imageDrawableArray[i2] = AbstractWidgetUI.updateImageDrawable(graphics3D, widgetModel, imageDrawableArray[i2], bufferImageArray[i2]);
                }
            }
        }
        return imageDrawableArray;
    }

    protected static final ImageDrawable updateImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ImageDrawable imageDrawable, BufferImage bufferImage) {
        if (widgetModel.isInvalid() || imageDrawable == null) {
            if (imageDrawable == null) {
                imageDrawable = graphics3D.getDrawableManager().createImageDrawable();
            }
            imageDrawable.setImage(bufferImage);
            imageDrawable.setSourceWidth(bufferImage.getWidth());
            imageDrawable.setSourceHeight(bufferImage.getHeight());
            imageDrawable.setDestinationWidth(bufferImage.getWidth());
            imageDrawable.setDestinationHeight(bufferImage.getHeight());
        }
        return imageDrawable;
    }

    protected static final ScaleImageDrawable[] updateScaleImageDrawables(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable[] scaleImageDrawableArray, Image[] imageArray) {
        return AbstractWidgetUI.updateScaleImageDrawables(graphics3D, widgetModel, scaleImageDrawableArray, imageArray, false);
    }

    protected static final ScaleImageDrawable[] updateScaleImageDrawables(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable[] scaleImageDrawableArray, Image[] imageArray, boolean bl) {
        if (widgetModel.isInvalid()) {
            if (imageArray == null) {
                AbstractWidgetUI.disposeDrawables(scaleImageDrawableArray);
                scaleImageDrawableArray = new ScaleImageDrawable[]{};
            } else {
                if (scaleImageDrawableArray == null || imageArray.length != scaleImageDrawableArray.length) {
                    AbstractWidgetUI.disposeDrawables(scaleImageDrawableArray);
                    scaleImageDrawableArray = new ScaleImageDrawable[imageArray.length];
                }
                for (int i2 = scaleImageDrawableArray.length - 1; i2 >= 0; --i2) {
                    scaleImageDrawableArray[i2] = AbstractWidgetUI.updateScaleImageDrawable(graphics3D, widgetModel, scaleImageDrawableArray[i2], imageArray[i2], bl);
                }
            }
        }
        return scaleImageDrawableArray;
    }

    protected static final ScaleImageDrawable updateScaleImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable scaleImageDrawable, Image image) {
        return AbstractWidgetUI.updateScaleImageDrawable(graphics3D, widgetModel, scaleImageDrawable, image, false);
    }

    protected static final ScaleImageDrawable updateScaleImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable scaleImageDrawable, Image image, boolean bl) {
        return AbstractWidgetUI.updateScaleImageDrawable(graphics3D, widgetModel, scaleImageDrawable, image, 0, 0, bl);
    }

    protected static final ScaleImageDrawable updateScaleImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable scaleImageDrawable, Image image, int n, int n2) {
        return AbstractWidgetUI.updateScaleImageDrawable(graphics3D, widgetModel, scaleImageDrawable, image, n, n2, false);
    }

    protected static final ScaleImageDrawable updateScaleImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ScaleImageDrawable scaleImageDrawable, Image image, int n, int n2, boolean bl) {
        if (widgetModel.isInvalid() || scaleImageDrawable == null) {
            ScaleImage scaleImage;
            ScaleImage scaleImage2 = scaleImage = image == null ? null : image.getCurrentImage();
            if (scaleImage != null && !scaleImage.isEmpty()) {
                if (scaleImageDrawable == null) {
                    scaleImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
                }
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                scaleImageDrawable.setImage(0, bufferImage);
                BufferImage bufferImage2 = null;
                if (scaleImage.hasSecondaryLayer()) {
                    bufferImage2 = ServiceManager.imageManager.getSecondaryImageFromCurrentSkin(scaleImage);
                    if (bufferImage.getWidth() != bufferImage2.getWidth() || bufferImage.getHeight() != bufferImage2.getHeight() || bufferImage.getImageFormat() != bufferImage2.getImageFormat()) {
                        bufferImage2 = null;
                        LogMessage logMessage = LOGGER.warn(4);
                        logMessage.append(widgetModel).append(": Secondary image layer has different image properties than the first layer. This is currently not supported. Only the first layer will be visible. ScaleImage: ").append(scaleImage).append(", first layer: ").append(bufferImage).append(", second layer:").append(bufferImage2).log();
                    }
                }
                scaleImageDrawable.setImage(1, bufferImage2);
                scaleImageDrawable.setImageFilter(bl ? 1 : 0);
                scaleImageDrawable.setScaleImage(scaleImage);
                scaleImageDrawable.setWidth(n > 0 ? n : bufferImage.getWidth());
                scaleImageDrawable.setHeight(n2 > 0 ? n2 : bufferImage.getHeight());
            } else if (scaleImageDrawable != null) {
                scaleImageDrawable.dispose();
                scaleImageDrawable = null;
            }
        }
        return scaleImageDrawable;
    }

    protected static final ColorGradientDrawable[] updateColorGradientDrawables(Graphics3D graphics3D, WidgetModel widgetModel, ColorGradientDrawable[] colorGradientDrawableArray, Image[] imageArray) {
        if (widgetModel.isInvalid()) {
            if (imageArray == null) {
                AbstractWidgetUI.disposeDrawables(colorGradientDrawableArray);
                colorGradientDrawableArray = new ColorGradientDrawable[]{};
            } else {
                if (colorGradientDrawableArray == null || imageArray.length != colorGradientDrawableArray.length) {
                    AbstractWidgetUI.disposeDrawables(colorGradientDrawableArray);
                    colorGradientDrawableArray = new ColorGradientDrawable[imageArray.length];
                }
                for (int i2 = colorGradientDrawableArray.length - 1; i2 >= 0; --i2) {
                    colorGradientDrawableArray[i2] = AbstractWidgetUI.updateColorGradientDrawable(graphics3D, widgetModel, colorGradientDrawableArray[i2], imageArray[i2]);
                }
            }
        }
        return colorGradientDrawableArray;
    }

    protected static CubicBezierCurveDrawable createBezierCurveDrawable(Graphics3D graphics3D, TouchAreaModel touchAreaModel, CubicBezierCurveDrawable cubicBezierCurveDrawable, Rectangle rectangle, Image image, int n, boolean bl) {
        if (touchAreaModel.isInvalid() || cubicBezierCurveDrawable == null) {
            if (cubicBezierCurveDrawable == null || image == null || image.getCurrentImage().isEmpty()) {
                AbstractWidgetUI.disposeDrawable(cubicBezierCurveDrawable);
                cubicBezierCurveDrawable = graphics3D.getDrawableManager().createCubicBezierCurveDrawable();
            }
            if (image != null && !image.getCurrentImage().isEmpty()) {
                try {
                    BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
                    cubicBezierCurveDrawable.setImage(bufferImage);
                    cubicBezierCurveDrawable.setImageFilter(bl ? 1 : 0);
                    cubicBezierCurveDrawable.setBounds(rectangle);
                    cubicBezierCurveDrawable.setStrokeWidth(n);
                }
                catch (IOException iOException) {
                    LogMessage logMessage = LOGGER.error(4);
                    logMessage.append("Widget '").append(touchAreaModel.getQualifiedName()).append("': Unable to load image (").append(image).append("): ").append(iOException).log();
                }
            }
        }
        return cubicBezierCurveDrawable;
    }

    protected static final RectangleDrawable updateRectangleDrawable(Graphics3D graphics3D, WidgetModel widgetModel, RectangleDrawable rectangleDrawable, Rectangle rectangle) {
        return AbstractWidgetUI.updateRectangleDrawable(graphics3D, widgetModel, rectangleDrawable, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    protected static final RectangleDrawable updateRectangleDrawable(Graphics3D graphics3D, WidgetModel widgetModel, RectangleDrawable rectangleDrawable, int n, int n2, int n3, int n4) {
        if (widgetModel.isInvalid() || rectangleDrawable == null) {
            if (rectangleDrawable == null) {
                rectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
            }
            rectangleDrawable.set(n, n2, n3, n4);
        }
        return rectangleDrawable;
    }

    protected static final ColorGradientDrawable updateColorGradientDrawable(Graphics3D graphics3D, WidgetModel widgetModel, ColorGradientDrawable colorGradientDrawable, Image image) {
        if (widgetModel.isInvalid() || colorGradientDrawable == null) {
            if (colorGradientDrawable == null || image == null || image.getCurrentImage().isEmpty()) {
                AbstractWidgetUI.disposeDrawable(colorGradientDrawable);
                colorGradientDrawable = graphics3D.getDrawableManager().createColorGradientDrawable();
            }
            if (image != null && !image.getCurrentImage().isEmpty()) {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
                colorGradientDrawable.setImage(bufferImage);
            }
        }
        return colorGradientDrawable;
    }

    protected static final ImageDrawable createImageDrawableFromSkin0(Graphics3D graphics3D, String string, int n, boolean bl) {
        BufferImage bufferImage = SkinHelper.getCarSpecificImageFromCommonSkin(string, n);
        ImageDrawable imageDrawable = graphics3D.getDrawableManager().createImageDrawable();
        imageDrawable.setImage(bufferImage);
        imageDrawable.setImageFilter(bl ? 1 : 0);
        imageDrawable.setSourceWidth(bufferImage.getWidth());
        imageDrawable.setSourceHeight(bufferImage.getHeight());
        imageDrawable.setDestinationWidth(bufferImage.getWidth());
        imageDrawable.setDestinationHeight(bufferImage.getHeight());
        return imageDrawable;
    }

    protected static final ImageDrawable createImageDrawableFromSkin0(Graphics3D graphics3D, String string, int n) {
        return AbstractWidgetUI.createImageDrawableFromSkin0(graphics3D, string, n, false);
    }

    protected static final CubicBezierCurveDrawable createBezierCurveDrawableFromSkin0(Graphics3D graphics3D, String string, int n, boolean bl) {
        BufferImage bufferImage = SkinHelper.getCarSpecificImageFromCommonSkin(string, n);
        CubicBezierCurveDrawable cubicBezierCurveDrawable = graphics3D.getDrawableManager().createCubicBezierCurveDrawable();
        cubicBezierCurveDrawable.setImage(bufferImage);
        cubicBezierCurveDrawable.setImageFilter(bl ? 1 : 0);
        return cubicBezierCurveDrawable;
    }

    protected static final void disposeDrawable(Drawable drawable) {
        AbstractWidgetUI.dispose(drawable);
    }

    protected static final void disposeDrawables(Drawable[] drawableArray) {
        if (drawableArray != null) {
            for (int i2 = drawableArray.length - 1; i2 >= 0; --i2) {
                AbstractWidgetUI.disposeDrawable(drawableArray[i2]);
            }
        }
    }

    protected static final void disposeDrawables(Drawable[][] drawableArray) {
        if (drawableArray != null) {
            for (int i2 = drawableArray.length - 1; i2 >= 0; --i2) {
                AbstractWidgetUI.disposeDrawables(drawableArray[i2]);
                drawableArray[i2] = null;
            }
        }
    }

    protected static final void dispose(Disposable disposable) {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static final float normalizeAlpha(int n) {
        return (float)n * -2122284997;
    }

    static {
        USE_STENCIL_CLIPPING = System.getProperty("de.vw.mib.widgets.stencilclipping") != null;
        IS_DEVELOPMENT_BUILD = ServiceManager.configurationManager.isDevelopmentBuild();
        LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    }
}

