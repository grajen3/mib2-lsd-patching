/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.CanvasModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TouchAreaUI;

public final class CanvasUI
extends TouchAreaUI {
    private static final Color4f FILL_COLOR = System.getProperty("de.vw.mib.widgets.canvas.colorize") != null ? Color4f.CYAN : Color4f.BLACK_TRANSPARENT;
    private BufferImage screenshotImage;
    private ImageDrawable screenshotDrawable;
    private RectangleDrawable rectangleDrawable;
    private Rectangle absoluteClippingArea;
    private boolean v2vScreenshotCreated;

    @Override
    public void init() {
        super.init();
        this.absoluteClippingArea = new Rectangle();
    }

    @Override
    public void deInit() {
        this.disposeScreenshotDrawable();
        if (this.screenshotImage != null) {
            ServiceManager.displayManager.releaseContent(this.screenshotImage);
            this.screenshotImage.dispose();
            this.screenshotImage = null;
        }
        if (this.screenshotDrawable != null) {
            this.disposeScreenshotDrawable();
        }
        if (this.rectangleDrawable != null) {
            this.rectangleDrawable.dispose();
            this.rectangleDrawable = null;
        }
        this.v2vScreenshotCreated = false;
        this.absoluteClippingArea = null;
    }

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        boolean bl;
        CanvasModel canvasModel = (CanvasModel)widgetModel;
        int n = canvasModel.get_displayable();
        boolean bl2 = canvasModel.get_screenshotmode() != 0;
        boolean bl3 = viewModel.isRenderOffscreen() || !viewModel.is_activated();
        boolean bl4 = bl = ServiceManager.displayManager.isGetDisplayableContentSupported(n) && (bl2 && canvasModel.validateScreenshot() || !bl2 && bl3 && !this.v2vScreenshotCreated);
        if (bl3) {
            this.absoluteClippingArea.setBounds(widgetModel.getAbsX(), widgetModel.getAbsY(), widgetModel.get_width(), widgetModel.get_height());
        } else {
            this.absoluteClippingArea.setBounds(widgetModel.getAbsX() - rectangle2.x + rectangle.x, widgetModel.getAbsY() - rectangle2.y + rectangle.y, rectangle.width, rectangle.height);
        }
        Rectangle rectangle3 = canvasModel.validateDisplayableViewport(this.absoluteClippingArea, f2);
        if (bl) {
            this.updateScreenshot(graphics3D, canvasModel, n, rectangle3);
        }
        this.v2vScreenshotCreated = bl3;
        if (bl2 || bl3 && this.screenshotDrawable != null) {
            if (this.screenshotDrawable != null) {
                this.drawScreenshot(canvasModel, rectangle3, f2);
            }
        } else {
            if (this.screenshotDrawable != null) {
                this.disposeScreenshotDrawable();
                this.disposeScreenshot(canvasModel);
            }
            if (rectangle3 != null) {
                if (this.rectangleDrawable == null) {
                    this.rectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
                    this.rectangleDrawable.setColor(FILL_COLOR);
                }
                this.rectangleDrawable.set(rectangle3);
                boolean bl5 = graphics3D.isBlendingEnabled();
                graphics3D.setBlendingEnabled(false);
                this.rectangleDrawable.draw();
                graphics3D.setBlendingEnabled(bl5);
            }
        }
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
    }

    private void drawScreenshot(CanvasModel canvasModel, Rectangle rectangle, float f2) {
        Rectangle rectangle2 = canvasModel.getSourceRectangle();
        Rectangle rectangle3 = canvasModel.getDestinationRectangle();
        BufferImage bufferImage = this.screenshotDrawable.getImage();
        int n = Math.min(bufferImage.getWidth() - rectangle2.x, rectangle2.width);
        int n2 = Math.min(bufferImage.getHeight() - rectangle2.y, rectangle2.height);
        this.screenshotDrawable.setSourceX(rectangle2.x);
        this.screenshotDrawable.setSourceY(rectangle2.y);
        this.screenshotDrawable.setSourceWidth(n);
        this.screenshotDrawable.setSourceHeight(n2);
        this.screenshotDrawable.setDestinationX(rectangle.x);
        this.screenshotDrawable.setDestinationY(rectangle.y);
        this.screenshotDrawable.setDestinationWidth(rectangle3.width);
        this.screenshotDrawable.setDestinationHeight(rectangle3.height);
        this.screenshotDrawable.setAlpha(f2);
        this.screenshotDrawable.draw();
    }

    private void updateScreenshot(Graphics3D graphics3D, CanvasModel canvasModel, int n, Rectangle rectangle) {
        this.disposeScreenshot(canvasModel);
        int n2 = canvasModel.getView().getDisplayID();
        Dimension dimension = ServiceManager.displayManager.getDisplayableExtents(n, n2);
        if (dimension.width > 0 && dimension.height > 0) {
            LogMessage logMessage;
            if (LOGGER.isTraceEnabled(512)) {
                logMessage = LOGGER.trace(512);
                logMessage.append(canvasModel);
                logMessage.append(": updating displayable screenshot - Area: ");
                logMessage.append("x, y, width, height: ").append(0).append(", ").append(0).append(", ").append(dimension.width).append(", ").append(dimension.height);
                logMessage.append(", Displayable: ");
                logMessage.append(canvasModel.get_displayable());
                logMessage.log();
            }
            try {
                this.screenshotImage = ServiceManager.displayManager.getDisplayableContent(n2, n, 0, 0, dimension.width, dimension.height);
                if (this.screenshotImage != null) {
                    if (this.screenshotDrawable == null) {
                        this.screenshotDrawable = graphics3D.getDrawableManager().createImageDrawable();
                    }
                    this.screenshotDrawable.setImage(this.screenshotImage);
                } else if (LOGGER.isTraceEnabled(512)) {
                    logMessage = LOGGER.trace(512);
                    logMessage.append(canvasModel);
                    logMessage.append(": screenshot creation unsucessful. getDisplayableContent() returned null.");
                    logMessage.append(" Displayable: ");
                    logMessage.append(canvasModel.get_displayable());
                    logMessage.log();
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                LogMessage logMessage2 = LOGGER.warn(512);
                logMessage2.append(canvasModel);
                logMessage2.append(": Exception caught during screenshot creation: ").append(illegalArgumentException);
                if (LOGGER.isTraceEnabled(512)) {
                    logMessage2.attachThrowable(illegalArgumentException);
                }
                logMessage2.log();
            }
        } else if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(canvasModel);
            logMessage.append(": screenshot creation skipped because of invalid dimensions: ");
            logMessage.append(" Displayable size (width, height): ").append(dimension.width).append(", ").append(dimension.height);
            logMessage.append(" Canvas Widget size(width, height):").append(canvasModel.get_width()).append(", ").append(canvasModel.get_height());
            logMessage.log();
        }
        canvasModel.setScreenshotCreated();
    }

    private void disposeScreenshot(CanvasModel canvasModel) {
        if (this.screenshotImage != null) {
            ServiceManager.displayManager.releaseContent(this.screenshotImage);
            this.screenshotImage.dispose();
            this.screenshotImage = null;
            canvasModel.setScreenshotDisposed();
        }
    }

    private void disposeScreenshotDrawable() {
        if (this.screenshotDrawable != null) {
            this.screenshotDrawable.dispose();
            this.screenshotDrawable = null;
        }
    }
}

