/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.Canvas$1;
import de.vw.mib.widgets.Canvas$BasePropertyChangedHandler;
import de.vw.mib.widgets.Canvas$ViewChangedHandler;
import de.vw.mib.widgets.TouchArea;
import de.vw.mib.widgets.controller.CanvasController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.CanvasModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class Canvas
extends TouchArea
implements CanvasModel {
    private static final String SCREENSHOT_UPDATE_TIMER_NAME;
    private static final int SCREENSHOT_UPDATE_TIMER_DELAY;
    private static final int DISPLAYABLE_ALPHA_UNDEFINED;
    private int displayable;
    private int scalemode;
    private int screenshotmode;
    private int displayableWidth;
    private int displayableHeight;
    private float aspectratio;
    private final Canvas$ViewChangedHandler viewChangedHandler = new Canvas$ViewChangedHandler(this);
    private final Canvas$BasePropertyChangedHandler basePropertyChangedHandler = new Canvas$BasePropertyChangedHandler(this);
    private Timer screenshotTimer;
    private Dimension displayableDimension;
    private Rectangle absoluteWidgetBounds;
    private Rectangle absoluteClipArea;
    private Rectangle viewport;
    private Rectangle displayableSourceRect;
    private Rectangle displayableDestRect;
    private int displayableAlpha;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CanvasUI;

    @Override
    protected void reset() {
        this.screenshotTimer = null;
        this.displayableAlpha = -1;
        this.absoluteWidgetBounds = new Rectangle();
        this.absoluteClipArea = new Rectangle();
        this.displayableSourceRect = new Rectangle();
        this.displayableDestRect = new Rectangle();
        this.viewport = new Rectangle();
        super.reset();
    }

    public void init(boolean bl, boolean bl2, boolean bl3, int n, float f2, boolean bl4, boolean bl5, int n2, int n3, int n4, boolean bl6, int n5, int n6, int n7, EasingParams[] easingParamsArray, boolean bl7, int n8, boolean bl8, int n9, String string, int n10, int n11, boolean bl9, boolean bl10, int n12, int n13, Insets insets, Color color, Image image, int n14, int n15, int n16, int n17, int n18, boolean bl11, int n19, int n20, int n21) {
        super.init(bl, bl2, bl3, n, bl4, bl5, bl6, n5, n6, n7, easingParamsArray, bl7, n8, bl8, n9, string, bl10, n12, n13, insets, color, image, n14, n15, n16, n17, n18, bl11, n19, n20, n21);
        this.aspectratio = f2;
        this.displayable = n2;
        this.displayableHeight = n3;
        this.displayableWidth = n4;
        this.scalemode = n10;
        this.screenshotmode = n11;
        this.setInternalStateFlag(18, false);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (viewModel != null) {
            viewModel.addViewChangedListener(this.viewChangedHandler);
            viewModel.setRenderOffscreenReplace(true);
        }
        this.registerBasePropertyChangedHandler();
        this.validateDisplayableAlpha(this.getAbsAlpha());
        this.invalidateDisplayable();
    }

    @Override
    public void deInit() {
        ViewModel viewModel = this.getView();
        if (viewModel != null) {
            viewModel.removeViewChangedListener(this.viewChangedHandler);
        }
        if (this.isDisplayableEnabled()) {
            this.disableDisplayable();
        }
        if (this.screenshotTimer != null) {
            this.screenshotTimer.stop();
            this.screenshotTimer = null;
        }
        this.removeBasePropertyChangedHandler();
        this.setInternalStateFlag(20, false);
        this.setInternalStateFlag(21, false);
        this.setInternalStateFlag(22, false);
        this.setInternalStateFlag(19, false);
        this.setInternalStateFlag(17, false);
        this.resetDisplayableDimension();
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        this.requestScreenshotUpdate();
    }

    @Override
    public void deActivate() {
        super.deActivate();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$CanvasUI == null ? (class$de$vw$mib$widgets$ui$CanvasUI = Canvas.class$("de.vw.mib.widgets.ui.CanvasUI")) : class$de$vw$mib$widgets$ui$CanvasUI};
    }

    @Override
    public int get_displayable() {
        return this.displayable;
    }

    @Override
    public void set_displayable(int n) {
        int n2 = this.displayable;
        if (n2 != n) {
            this.displayable = n;
            this.displayableChanged(n2);
            this.propertyChanged(32);
        }
    }

    @Override
    public int get_scalemode() {
        return this.scalemode;
    }

    @Override
    public void set_scalemode(int n) {
        int n2 = this.scalemode;
        if (n2 != n) {
            this.scalemode = n;
            this.scalemodeChanged(n2);
            this.propertyChanged(33);
        }
    }

    @Override
    public int get_screenshotmode() {
        return this.screenshotmode;
    }

    @Override
    public void set_screenshotmode(int n) {
        int n2 = this.screenshotmode;
        if (n != n2) {
            this.screenshotmode = n;
            this.screenshotmodeChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public boolean is_screenshotVisible() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public void set_screenshotVisible(boolean bl) {
        boolean bl2 = this.is_screenshotVisible();
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.screenshotVisibleChanged(bl2);
            this.propertyChanged(35);
        }
    }

    @Override
    public float get_aspectratio() {
        return this.aspectratio;
    }

    @Override
    public void set_aspectratio(float f2) {
        float f3 = this.aspectratio;
        if (f3 != f2) {
            this.aspectratio = f2;
            this.aspectRatioChanged(f3);
            this.propertyChanged(36);
        }
    }

    @Override
    public int get_displayableWidth() {
        return this.displayableWidth;
    }

    @Override
    public void set_displayableWidth(int n) {
        int n2 = this.displayableWidth;
        if (n2 != n) {
            this.displayableWidth = n;
            this.displayableWidthChanged(n2);
            this.propertyChanged(37);
        }
    }

    @Override
    public int get_displayableHeight() {
        return this.displayableHeight;
    }

    @Override
    public void set_displayableHeight(int n) {
        int n2 = this.displayableHeight;
        if (n2 != n) {
            this.displayableHeight = n;
            this.displayableHeightChanged(n2);
            this.propertyChanged(38);
        }
    }

    @Override
    public Rectangle getSourceRectangle() {
        return this.displayableSourceRect;
    }

    @Override
    public Rectangle getDestinationRectangle() {
        return this.displayableDestRect;
    }

    @Override
    public boolean validateScreenshot() {
        if (this.isScreenshotRequested()) {
            this.performScreenshotUpdate();
        }
        return !this.isScreenshotBlocked() && this.isScreenshotPrepared();
    }

    private boolean isDisplayableEnabled() {
        return this.getInternalStateFlag(24);
    }

    private boolean isScreenshotRequested() {
        return this.getInternalStateFlag(20);
    }

    private boolean isViewActivated() {
        ViewModel viewModel = this.getView();
        return viewModel != null && viewModel.is_activated();
    }

    private boolean isScreenshotPrepared() {
        return this.getInternalStateFlag(21);
    }

    private boolean isScreenshotBlocked() {
        return this.getInternalStateFlag(19);
    }

    private boolean isScreenshotPreparation() {
        return this.getInternalStateFlag(22);
    }

    protected void displayableChanged(int n) {
        this.resetDisplayableDimension();
    }

    protected void scalemodeChanged(int n) {
        this.invalidateDisplayable();
        this.repaint();
    }

    protected void screenshotmodeChanged(int n) {
        this.validateVisibility();
    }

    protected void screenshotVisibleChanged(boolean bl) {
    }

    protected void aspectRatioChanged(float f2) {
        this.invalidateDisplayable();
        this.repaint();
    }

    protected void displayableWidthChanged(int n) {
        this.resetDisplayableDimension();
        this.invalidateDisplayable();
        this.repaint();
    }

    protected void displayableHeightChanged(int n) {
        this.resetDisplayableDimension();
        this.invalidateDisplayable();
        this.repaint();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        this.validateVisibility();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.invalidateDisplayable();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.invalidateDisplayable();
    }

    private void resetDisplayableDimension() {
        this.displayableDimension = null;
    }

    @Override
    public void requestScreenshotUpdate() {
        if (this.screenshotmode != 0) {
            if (!this.isScreenshotRequested()) {
                this.setInternalStateFlag(20, true);
                this.repaint();
            }
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append(this.getQualifiedName()).append(": Queued screenshot update request.").log();
            }
        }
    }

    @Override
    public void setScreenshotCreated() {
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(this.getQualifiedName()).append(": Screenshot created.").log();
        }
        this.set_screenshotVisible(true);
        this.setInternalStateFlag(19, true);
        this.setInternalStateFlag(21, false);
        this.setInternalStateFlag(20, false);
        if (this.screenshotTimer == null) {
            this.screenshotTimer = ServiceManager.timerManager.createTimer("Canvas.ScreenshotUpdateTimer", 0, false, new Canvas$1(this), ServiceManager.eventDispatcher);
        }
        this.screenshotTimer.start();
        ((CanvasController)this.getController()).fire_screenshotCreated();
    }

    @Override
    public void setScreenshotDisposed() {
        this.set_screenshotVisible(false);
    }

    @Override
    public void screenshotPreparationFinished() {
        if (this.isScreenshotPreparation()) {
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append(this.getQualifiedName()).append(": Screenshot preparation is complete. Ready to create screenshot.").log();
            }
            this.setInternalStateFlag(22, false);
            this.setInternalStateFlag(21, true);
            this.repaint();
        }
    }

    @Override
    public Rectangle validateDisplayableViewport(Rectangle rectangle, float f2) {
        this.setAbsoluteClipArea(rectangle);
        if (this.isDisplayableInvalid()) {
            this.validateDisplayable();
        }
        this.validateDisplayableAlpha((int)(f2 * 32579));
        return this.viewport;
    }

    protected void validateVisibility() {
        boolean bl = this.is_visible() && (this.areParentsVisible() || this.isParentVisibleRelevantAnimationRunning());
        boolean bl2 = this.getInternalStateFlag(17);
        if (bl && this.screenshotmode != 0) {
            if (this.isDisplayableEnabled()) {
                this.disableDisplayable();
            }
            if (!this.is_screenshotVisible()) {
                this.requestScreenshotUpdate();
            }
        } else if (bl && bl2) {
            if (!this.isDisplayableEnabled()) {
                this.enableDisplayable();
            }
        } else if (this.isDisplayableEnabled()) {
            this.disableDisplayable();
        }
    }

    protected void performScreenshotUpdate() {
        if (!this.isScreenshotBlocked() && this.isScreenshotRequested() && this.is_visible() && this.areParentsVisible()) {
            if (this.screenshotmode == 2) {
                this.setInternalStateFlag(20, false);
                this.setInternalStateFlag(21, true);
            } else if (this.screenshotmode == 1 && this.isViewActivated()) {
                if (LOGGER.isTraceEnabled(512)) {
                    LogMessage logMessage = LOGGER.trace(512);
                    logMessage.append(this.getQualifiedName()).append(": Request screanshot preparation.").log();
                }
                this.setInternalStateFlag(22, true);
                this.setInternalStateFlag(20, false);
                ((CanvasController)this.getController()).fire_prepareScreenshot();
            }
        }
    }

    private int getDisplayId() {
        int n = 0;
        if (this.getView() != null) {
            n = this.getView().getDisplayID();
        }
        return n;
    }

    private void enableDisplayable() {
        int n = this.getDisplayId();
        ServiceManager.displayManager.enableDisplayable(this.get_displayable(), n);
        this.setInternalStateFlag(24, true);
        this.invalidateDisplayable();
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(this.getQualifiedName()).append(".enableDisplayable(displayable=").append(this.get_displayable()).append(")");
            logMessage.log();
        }
    }

    private void disableDisplayable() {
        int n = this.getDisplayId();
        this.displayableAlpha = -1;
        ServiceManager.displayManager.disableDisplayable(this.get_displayable(), n);
        this.setInternalStateFlag(24, false);
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(this.getQualifiedName()).append(".disableDisplayable(displayable=").append(this.get_displayable()).append(")");
            logMessage.log();
        }
    }

    protected void invalidateDisplayable() {
        this.setInternalStateFlag(23, true);
    }

    private boolean isDisplayableInvalid() {
        return this.getInternalStateFlag(23);
    }

    private void setAbsoluteClipArea(Rectangle rectangle) {
        if (!this.absoluteClipArea.equals(rectangle)) {
            this.invalidateDisplayable();
            this.absoluteClipArea.setBounds(rectangle);
        }
    }

    private void validateDisplayable() {
        this.setInternalStateFlag(23, false);
        ViewModel viewModel = this.getView();
        if (viewModel != null) {
            LogMessage logMessage;
            int n = this.getDisplayId();
            float f2 = this.get_aspectratio();
            Dimension dimension = this.getDisplayableDimension(n);
            this.absoluteWidgetBounds.setBounds(this.getAbsX(), this.getAbsY(), this.get_width(), this.get_height());
            try {
                Canvas.updateCroppingRectangles(this.displayableSourceRect, this.displayableDestRect, this.absoluteWidgetBounds, this.absoluteClipArea, dimension, f2, this.get_scalemode());
                if (LOGGER.isTraceEnabled(512)) {
                    logMessage = LOGGER.trace(512);
                    logMessage.append(this.getQualifiedName()).append(".updateCroppingRectangles(out: displayableSourceRect=").append(this.displayableSourceRect);
                    logMessage.append(", out: displayableDestRect=").append(this.displayableDestRect);
                    logMessage.append(", in: absoluteWidgetBounds").append(this.absoluteWidgetBounds);
                    logMessage.append(", in: displayableDimension=").append(dimension);
                    logMessage.append(", in: foreAspectRatio=").append(f2);
                    logMessage.append(", in: scalemode").append(this.get_scalemode()).append(")");
                    logMessage.log();
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.displayableSourceRect.setBounds(0, 0, 0, 0);
                this.displayableDestRect.setBounds(this.getAbsX(), this.getAbsX(), this.get_width(), this.get_height());
                LogMessage logMessage2 = LOGGER.warn(512);
                logMessage2.append(this.getQualifiedName()).append(".updateCroppingRectangles invalid parameter for scale calculation.");
                logMessage2.append(", in: absoluteWidgetBounds").append(this.absoluteWidgetBounds);
                logMessage2.append(", in: displayableDimension=").append(dimension);
                logMessage2.append(", in: foreAspectRatio=").append(f2);
                logMessage2.append(", in: scalemode").append(this.get_scalemode()).append(")");
                logMessage2.append(" falling back to: ");
                logMessage2.append(" source Rectnagle: ").append(this.displayableSourceRect);
                logMessage2.append(" dest Rectangle: ").append(this.displayableDestRect);
                logMessage2.attachThrowable(illegalArgumentException);
                logMessage2.log();
            }
            this.viewport.setLocation(this.displayableDestRect.x - this.absoluteWidgetBounds.x, this.displayableDestRect.y - this.absoluteWidgetBounds.y);
            this.viewport.setSize(this.displayableDestRect.getWidth(), this.displayableDestRect.getHeight());
            if (LOGGER.isTraceEnabled(512)) {
                logMessage = LOGGER.trace(512);
                logMessage.append(this.getQualifiedName()).append(".updateViewport(").append(this.viewport).append(")");
                logMessage.log();
            }
            if (this.isDisplayableEnabled()) {
                ServiceManager.displayManager.setDisplayable(this.get_displayable(), n, this.displayableSourceRect, this.displayableDestRect);
                if (LOGGER.isTraceEnabled(512)) {
                    logMessage = LOGGER.trace(512);
                    logMessage.append(this.getQualifiedName()).append(".setDisplayable(displayable=").append(this.get_displayable()).append(",sourceRect=").append(this.displayableSourceRect).append(", destRect=").append(this.displayableDestRect).append(")");
                    logMessage.log();
                }
            }
        }
    }

    private Dimension getDisplayableDimension(int n) {
        if (this.displayableDimension == null) {
            this.displayableDimension = new Dimension();
            if (this.displayableWidth < 0 || this.displayableHeight < 0) {
                Dimension dimension = ServiceManager.displayManager.getDisplayableExtents(this.get_displayable(), n);
                this.displayableDimension.setSize(this.displayableWidth < 0 ? dimension.width : this.displayableWidth, this.displayableHeight < 0 ? dimension.height : this.displayableHeight);
            } else {
                this.displayableDimension.setSize(this.displayableWidth, this.displayableHeight);
            }
        }
        return this.displayableDimension;
    }

    private void validateDisplayableAlpha(int n) {
        if (this.isDisplayableEnabled() && this.displayableAlpha != n) {
            this.displayableAlpha = n;
            int n2 = this.getDisplayId();
            ServiceManager.displayManager.setDisplayableAlpha(this.get_displayable(), n2, n);
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append(this.getQualifiedName()).append(".updateDisplayableAlpha(displayable=").append(this.get_displayable()).append(",absAlpha=").append(n).append(")");
                logMessage.log();
            }
        }
    }

    private void registerBasePropertyChangedHandler() {
        for (WidgetModel widgetModel = this.getParent(); widgetModel != null; widgetModel = widgetModel.getParent()) {
            widgetModel.addPropertyChangedListener(this.basePropertyChangedHandler);
        }
    }

    private void removeBasePropertyChangedHandler() {
        for (WidgetModel widgetModel = this.getParent(); widgetModel != null; widgetModel = widgetModel.getParent()) {
            widgetModel.removePropertyChangedListener(this.basePropertyChangedHandler);
        }
    }

    private boolean isParentVisibleRelevantAnimationRunning() {
        boolean bl = false;
        for (WidgetModel widgetModel = this.getParent(); widgetModel != null; widgetModel = widgetModel.getParent()) {
            if (widgetModel.isVisibleRelevantAnimationRunning()) {
                bl = true;
                break;
            }
            if (!widgetModel.is_visible()) break;
        }
        return bl;
    }

    protected boolean isVisibleRelevant(WidgetModel widgetModel) {
        WidgetModel widgetModel2;
        for (widgetModel2 = this.getParent(); widgetModel2 != null && widgetModel2 != widgetModel && (widgetModel2.is_visible() || widgetModel2.isVisibleRelevantAnimationRunning()); widgetModel2 = widgetModel2.getParent()) {
        }
        return widgetModel2 == widgetModel;
    }

    private static void updateCroppingRectangles(Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, Rectangle rectangle4, Dimension dimension, float f2, int n) {
        float f3;
        float f4;
        if (n == 0 || f2 > 0.0f) {
            f4 = (float)rectangle3.width / (float)rectangle3.height;
            f3 = f2 > 0.0f ? f2 : Canvas.getDisplayableAspectRatio(dimension);
            if (f4 > f3) {
                rectangle2.height = rectangle3.height;
                rectangle2.width = (int)((float)rectangle3.height * f3);
            } else {
                rectangle2.width = rectangle3.width;
                rectangle2.height = (int)((float)rectangle3.width / f3);
            }
        } else {
            rectangle2.width = rectangle3.width;
            rectangle2.height = rectangle3.height;
        }
        switch (n) {
            case 1: 
            case 2: 
            case 5: {
                f3 = Canvas.getDisplayableAspectRatio(dimension);
                f4 = (float)rectangle2.width / (float)rectangle2.height;
                if (n == 2 || n == 5 && f3 > f4) {
                    rectangle.height = dimension.height;
                    if (f3 < f4) {
                        rectangle.width = dimension.width;
                        rectangle2.width = (int)((float)(rectangle2.width * dimension.width) / ((float)dimension.height * f4));
                    } else {
                        rectangle.width = (int)((float)dimension.height * f4);
                    }
                } else {
                    rectangle.width = dimension.width;
                    if (f3 > f4) {
                        rectangle.height = dimension.height;
                        rectangle2.height = (int)((float)(rectangle2.height * dimension.height) / ((float)dimension.width / f4));
                    } else {
                        rectangle.height = (int)((float)dimension.width / f4);
                    }
                }
                rectangle.setLocation(dimension.width - rectangle.width >> 1, dimension.height - rectangle.height >> 1);
                break;
            }
            case 0: 
            case 6: {
                rectangle.setLocation(0, 0);
                rectangle.setSize(dimension);
                break;
            }
            case 4: {
                rectangle.setBounds(dimension.width - rectangle2.width >> 1, dimension.height - rectangle2.height >> 1, rectangle2.width, rectangle2.height);
                break;
            }
            default: {
                rectangle.setBounds(0, 0, rectangle2.width, rectangle2.height);
            }
        }
        rectangle2.setLocation(rectangle3.x + (rectangle3.width - rectangle2.width >> 1), rectangle3.y + (rectangle3.height - rectangle2.height >> 1));
        Canvas.clampToScreenArea(rectangle4, rectangle, rectangle2);
    }

    private static void clampToScreenArea(Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
        Rectangle rectangle4 = rectangle.intersection(rectangle3);
        if (!rectangle4.equals(rectangle3)) {
            float f2 = rectangle2.width / rectangle3.width;
            float f3 = rectangle2.height / rectangle3.height;
            rectangle2.width = (int)((float)rectangle2.width + (float)(rectangle4.width - rectangle3.width) * f2);
            rectangle2.x = (int)((float)rectangle2.x + (float)(rectangle4.x - rectangle3.x) * f2);
            rectangle2.height = (int)((float)rectangle2.height + (float)(rectangle4.height - rectangle3.height) * f3);
            rectangle2.y = (int)((float)rectangle2.y + (float)(rectangle4.y - rectangle3.y) * f3);
            rectangle3.setBounds(rectangle4);
        }
    }

    private static float getDisplayableAspectRatio(Dimension dimension) {
        if (dimension.getWidth() == 0 || dimension.getHeight() == 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Given displayable dimension is invalid: ").append(dimension).toString());
        }
        return (float)dimension.getWidth() / (float)dimension.getHeight();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

