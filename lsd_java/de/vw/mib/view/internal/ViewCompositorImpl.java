/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsManager;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.DisplayManager;
import de.vw.mib.graphics.drawable.shape.EllipseDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;
import de.vw.mib.view.ViewCompositor;
import de.vw.mib.view.internal.ViewCompositorImpl$OverlayUpdater;
import de.vw.mib.view.internal.ViewCompositorImpl$SkinInformationHandler;
import de.vw.mib.view.internal.ViewRepaintPerformanceMetrics;
import de.vw.mib.view.internal.overlay.DebugOverlay;
import de.vw.mib.view.internal.overlay.ImageOverlay;
import de.vw.mib.view.internal.overlay.PanicOverlay;
import de.vw.mib.view.internal.overlay.Pointer;
import de.vw.mib.view.internal.overlay.SystemPerformanceOverlay;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class ViewCompositorImpl
implements ViewCompositor {
    private static final Color4f BACKGROUND_COLOR = System.getProperty("de.vw.mib.view.redclearcolor") != null ? Color4f.RED : Color4f.BLACK;
    private static final boolean SUPPORT_PIXMAP_SURFACES;
    private static final boolean DEPTH_BUFFER_ENABLED;
    private static final int DEPTH_BUFFER_DEPTH;
    private static final float DEPTH_NEAR;
    private static final float DEPTH_FAR;
    private static final float DEPTH_CLEAR;
    private static final boolean STENCIL_BUFFER_ENABLED;
    private static final int STENCIL_BUFFER_DEPTH;
    private static final int STENCIL_CLEAR;
    private static final int ANTIALIASING_SAMPLES;
    private static final boolean BACKFACE_CULLING_ENABLED;
    private static final boolean BLENDING_ENABLED;
    private static final boolean DRAW_POINTER;
    private static final boolean CENTER_POINTER;
    private static final boolean DRAW_TEST;
    private static final boolean DEBUG_OVERLAY_ALWAYS;
    private static final boolean DEBUG_OVERLAY_ENABLED;
    public static final long MS_PER_S;
    public static final long US_PER_S;
    public static final long NS_PER_S;
    private static final int DISPLAY_ID;
    private static final Logger LOGGER;
    private Configuration config;
    private Dimension displaySize;
    private Surface surface;
    private Graphics3D g3d;
    private ImageOverlay backgroundUnderlay;
    private BufferImage backgroundImage;
    private final boolean drmRenderingEnabled = AbstractWidget.DIRTY_REGION_MANAGEMENT;
    private FrameBufferTexture drmFrameBufferTexture;
    private RenderBufferSurface drmDepthBufferSurface;
    private RenderBufferSurface drmStencilBufferSurface;
    private FrameBuffer drmOffscreenFrameBuffer;
    private FrameBuffer drmOnscreenFrameBuffer;
    private List drmDirtyRegions;
    private List drmLastViews;
    private List viewNames;
    private Pointer pointer;
    private DebugOverlay debugOverlay;
    protected SystemPerformanceOverlay systemPerformanceOverlay;
    private Timer overlayUpdateTimer;
    private ViewCompositorImpl$SkinInformationHandler skinInformationHandler;
    private ViewRepaintPerformanceMetrics performanceMetrics = new ViewRepaintPerformanceMetrics();

    private void initialize() {
        LogMessage logMessage;
        Object object;
        Object object2;
        long l;
        boolean bl = LOGGER.isTraceEnabled(128);
        long l2 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        this.skinInformationHandler = new ViewCompositorImpl$SkinInformationHandler();
        DisplayManager displayManager = ServiceManager.displayManager;
        long l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        displayManager.enableDisplayable(16, 0);
        long l4 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            object2 = LOGGER.trace(16);
            object2.append("ViewCompositor enableDisplayable(): ").append(l - l3).append("\u00b5s").log();
        }
        object2 = ServiceManager.gfxManager;
        l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        Object object3 = displayManager.getNativeDisplayableHandle(16, 0);
        long l5 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            object = LOGGER.trace(16);
            object.append("ViewCompositor getNativeDisplayableHandle(): ").append(l - l3).append("\u00b5s").log();
        }
        object = new ConfigurationAttributes();
        ((ConfigurationAttributes)object).colorRedBits = 8;
        ((ConfigurationAttributes)object).colorGreenBits = 8;
        ((ConfigurationAttributes)object).colorBlueBits = 8;
        ((ConfigurationAttributes)object).colorAlphaBits = 8;
        ((ConfigurationAttributes)object).depthBits = DEPTH_BUFFER_DEPTH;
        ((ConfigurationAttributes)object).stencilBits = STENCIL_BUFFER_DEPTH;
        ((ConfigurationAttributes)object).samples = ANTIALIASING_SAMPLES;
        boolean bl2 = ((ConfigurationAttributes)object).windowSurface = object3 != null;
        if (object3 != null) {
            // empty if block
        }
        ((ConfigurationAttributes)object).imageSurface = false;
        ((ConfigurationAttributes)object).bufferSurface = object3 == null;
        this.config = object2.chooseConfiguration((ConfigurationAttributes)object);
        l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        this.displaySize = displayManager.getDisplayableExtents(16, 0);
        long l6 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            logMessage = LOGGER.trace(16);
            logMessage.append("ViewCompositor getDisplayableExtents(): ").append(l - l3).append("\u00b5s").log();
        }
        long l7 = l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (object3 == null) {
            this.surface = object2.createPBufferSurface(this.config, this.displaySize.getWidth(), this.displaySize.getHeight());
        } else {
            this.surface = object2.createWindowSurface(this.config, object3);
            if (this.surface.getWidth() == 0 || this.surface.getHeight() == 0) {
                this.surface.setSize(this.displaySize.getWidth(), this.displaySize.getHeight());
                LOGGER.warn(16, "Graphics surface returns zero dimension");
            }
        }
        long l8 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            logMessage = LOGGER.trace(16);
            logMessage.append("ViewCompositor createSurface(): ").append(l - l3).append("\u00b5s").log();
        }
        l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        this.g3d = object2.createGraphics(this.config, this.surface);
        long l9 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            logMessage = LOGGER.trace(16);
            logMessage.append("ViewCompositor createGraphics(): ").append(l - l3).append("\u00b5s").log();
        }
        long l10 = l3 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (!object2.isGraphicsBound(this.g3d, this.surface)) {
            object2.bindGraphics(this.g3d, this.surface);
        }
        long l11 = l = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (bl && LOGGER.isTraceEnabled(16)) {
            logMessage = LOGGER.trace(16);
            logMessage.append("ViewCompositor bindGraphics(): ").append(l - l3).append("\u00b5s").log();
        }
        long l12 = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        object3 = LOGGER.info(16);
        object3.append("ViewCompositor initialized");
        if (bl) {
            object3.append(": ").append(l12 - l2).append("\u00b5s");
        }
        object3.log();
    }

    protected static long getSystemTimeMicros() {
        return ServiceManager.timerManager.getSystemTimeMicros();
    }

    @Override
    public void getDisplaySize(Dimension dimension) {
        if (this.displaySize == null) {
            this.initialize();
        }
        dimension.setSize(this.displaySize);
    }

    @Override
    public BufferImage getBackgroundImage() {
        return this.backgroundImage;
    }

    @Override
    public void setBackgroundImage(BufferImage bufferImage) {
        this.backgroundImage = bufferImage;
    }

    @Override
    public void setViewNames(List list) {
        this.viewNames = list;
    }

    @Override
    public void getScreenshot(ByteBuffer byteBuffer) {
        if (this.g3d != null) {
            this.g3d.readPixels(0, 0, this.displaySize.width, this.displaySize.height, byteBuffer);
        }
    }

    @Override
    public void switchViews(List list, List list2) {
        ViewModel viewModel;
        int n;
        if (this.debugOverlay != null) {
            this.debugOverlay.resetFrameCounter();
        }
        if (list != null) {
            for (n = list.size() - 1; n >= 0; --n) {
                viewModel = (ViewModel)list.get(n);
                if (list2.contains(viewModel)) continue;
                viewModel.onLeave();
            }
        }
        for (n = list2.size() - 1; n >= 0; --n) {
            viewModel = (ViewModel)list2.get(n);
            viewModel.onEnter();
        }
    }

    public void beginFrame() {
        GraphicsManager graphicsManager = ServiceManager.gfxManager;
        boolean bl = this.debugOverlay != null;
        LOGGER.trace(16, "ViewCompositor.beginFrame()");
        if (bl) {
            this.performanceMetrics.lastFrameStartTime = this.performanceMetrics.setupStartTime;
            this.performanceMetrics.setupStartTime = ViewCompositorImpl.getSystemTimeMicros();
        }
        graphicsManager.beginFrame(this.g3d);
        if (this.drmRenderingEnabled) {
            if (this.drmOffscreenFrameBuffer == null) {
                FrameBufferManager frameBufferManager = this.g3d.getFrameBufferManager();
                this.drmFrameBufferTexture = frameBufferManager.createFrameBufferTexture(4356, this.surface.getWidth(), this.surface.getHeight());
                this.drmOffscreenFrameBuffer = frameBufferManager.createFrameBuffer();
                this.drmOffscreenFrameBuffer.setColorBuffer(this.drmFrameBufferTexture);
                this.drmOffscreenFrameBuffer.setDepthBuffer(this.drmDepthBufferSurface);
                this.drmOffscreenFrameBuffer.setStencilBuffer(this.drmStencilBufferSurface);
                this.drmOnscreenFrameBuffer = frameBufferManager.getDefaultFrameBuffer();
            }
            this.g3d.setFrameBuffer(this.drmOffscreenFrameBuffer);
        }
        this.g3d.setColorBufferEnabled(true, true, true, true);
        this.g3d.setDepthBufferEnabled(false);
        this.g3d.setStencilBufferEnabled(0);
        this.g3d.setViewport(0, 0, this.displaySize.width, this.displaySize.height);
        this.g3d.setScissor(0, 0, this.displaySize.width, this.displaySize.height);
        this.g3d.setScissorTestEnabled(false);
        this.g3d.setDepthTestEnabled(false);
        this.g3d.setStencilTestEnabled(false);
        this.g3d.setCullingEnabled(false);
        this.g3d.setBlendFactorsSeparate(6, 7, 1, 7);
        this.g3d.setBlendEquationSeparate(0, 0);
        this.g3d.setBlendingEnabled(true);
        if (!this.drmRenderingEnabled) {
            this.g3d.clearColorBuffer(BACKGROUND_COLOR);
        }
        if (bl) {
            this.g3d.flush();
            this.performanceMetrics.setupEndTime = ViewCompositorImpl.getSystemTimeMicros();
        }
    }

    public void endFrame() {
        GraphicsManager graphicsManager = ServiceManager.gfxManager;
        boolean bl = this.debugOverlay != null;
        LOGGER.trace(16, "ViewCompositor.endFrame()");
        if (bl) {
            this.performanceMetrics.flushStartTime = ViewCompositorImpl.getSystemTimeMicros();
            this.g3d.flush();
            this.performanceMetrics.flushEndTime = ViewCompositorImpl.getSystemTimeMicros();
        }
        long l = this.performanceMetrics.swapStartTime = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (!this.drmRenderingEnabled || this.drmRenderingEnabled && this.drmDirtyRegions.size() > 0) {
            graphicsManager.swapBuffers(this.g3d);
        }
        this.performanceMetrics.swapEndTime = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        graphicsManager.endFrame(this.g3d);
    }

    @Override
    public void repaintViews(List list) {
        int n;
        boolean bl;
        boolean bl2 = LOGGER.isTraceEnabled(128);
        boolean bl3 = bl = this.debugOverlay != null;
        if (this.g3d == null) {
            this.initialize();
        }
        if (bl) {
            this.debugOverlay.updateFrame(ViewCompositorImpl.getSystemTimeMicros(), this.performanceMetrics);
            this.g3d.setPerformanceMetricsEnabled(true);
        }
        int n2 = n = ServiceManager.performanceIndicatorService != null ? ServiceManager.performanceIndicatorService.getPerformanceIndicatorCount() : 0;
        if (n > 0 && this.systemPerformanceOverlay == null && ServiceManager.configurationManager.isFeatureFlagSet(400)) {
            this.systemPerformanceOverlay = new SystemPerformanceOverlay(LOGGER, this.g3d, this.displaySize);
        } else if (n == 0 && this.systemPerformanceOverlay != null) {
            this.systemPerformanceOverlay.dispose();
            this.systemPerformanceOverlay = null;
        }
        boolean bl4 = DEBUG_OVERLAY_ALWAYS;
        this.beginFrame();
        this.drawBackground();
        long l = this.performanceMetrics.repaintStartTime = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (this.drmRenderingEnabled) {
            this.drawViewsDRM(list);
        } else {
            ViewCompositorImpl.drawViews(this.g3d, list, null);
        }
        boolean bl5 = this.skinInformationHandler.validate();
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            ViewModel viewModel = (ViewModel)list.get(i2);
            if (bl5) {
                viewModel.invalidate();
            }
            bl4 |= viewModel.is_renderInfo();
            if (!DRAW_POINTER || viewModel.getPointerPosition() == null) continue;
            if (this.pointer == null) {
                this.pointer = new Pointer(LOGGER, this.g3d);
                this.pointer.setCenterImage(CENTER_POINTER);
            }
            this.pointer.setPosition(viewModel.getPointerPosition());
            viewModel.setPointerPosition(null);
        }
        long l2 = this.performanceMetrics.repaintEndTime = bl ? ViewCompositorImpl.getSystemTimeMicros() : 0L;
        if (this.debugOverlay == null && bl4) {
            this.debugOverlay = new DebugOverlay(LOGGER, this.g3d, this.displaySize);
        } else if (this.debugOverlay != null && !bl4) {
            this.debugOverlay.dispose();
            this.debugOverlay = null;
        }
        if (this.overlayUpdateTimer != null && this.debugOverlay == null && this.systemPerformanceOverlay == null) {
            if (this.overlayUpdateTimer.isStarted()) {
                this.overlayUpdateTimer.stop();
                this.overlayUpdateTimer = null;
            }
        } else if (this.overlayUpdateTimer == null && this.systemPerformanceOverlay != null) {
            this.overlayUpdateTimer = ServiceManager.timerManager.createTimer("ViewCompositor Overlay", 0, true, new ViewCompositorImpl$OverlayUpdater(this), ServiceManager.eventDispatcher);
            this.overlayUpdateTimer.start();
        }
        this.drawOverlays();
        this.endFrame();
        ServiceManager.displayManager.updateDisplay(0);
    }

    protected static void triggerRepaint() {
        ServiceManager.repaintManager.repaint();
    }

    /*
     * WARNING - void declaration
     */
    private void drawViewsDRM(List list) {
        Cloneable cloneable;
        int n;
        Object object;
        void var3_6;
        boolean bl2 = LOGGER.isTraceEnabled(16);
        if (this.drmDirtyRegions == null) {
            int bl = 20;
            this.drmDirtyRegions = new ArrayList(20);
        } else {
            this.drmDirtyRegions.clear();
        }
        if (this.drmLastViews == null || !((Object)list).equals(this.drmLastViews)) {
            if (this.drmLastViews == null) {
                int n2 = 5;
                this.drmLastViews = new ArrayList(5);
            } else {
                this.drmLastViews.clear();
            }
            this.drmDirtyRegions.add(new Rectangle(this.displaySize));
            this.drmLastViews.addAll(list);
        }
        int n3 = list.size() - 1;
        while (var3_6 >= 0) {
            object = (ViewModel)list.get((int)var3_6);
            this.drmDirtyRegions.addAll(((View)object).dirtyRegions);
            ((View)object).dirtyRegions.clear();
            --var3_6;
        }
        if (this.drmDirtyRegions.size() > 0) {
            boolean bl = false;
            object = new Rectangle();
            this.g3d.getScissor((Rectangle)object);
            n = this.g3d.isScissorTestEnabled();
            for (int i2 = this.drmDirtyRegions.size() - 1; i2 >= 0; --i2) {
                cloneable = (Rectangle)this.drmDirtyRegions.get(i2);
                this.g3d.setScissor((Rectangle)cloneable);
                this.g3d.setScissorTestEnabled(true);
                this.g3d.setColorBufferEnabled(true, true, true, true);
                this.g3d.clearColorBuffer(BACKGROUND_COLOR);
                ViewCompositorImpl.drawViews(this.g3d, list, cloneable);
            }
            this.g3d.setScissor((Rectangle)object);
            this.g3d.setScissorTestEnabled(n != 0);
            if (bl2) {
                LogMessage logMessage = LOGGER.trace(16);
                logMessage.append("ViewCompositor.DRM.repaintViews() updated ").append(this.drmDirtyRegions.size()).append(" rectangles ").append(this.drmDirtyRegions).log();
            }
        }
        if (this.drmDirtyRegions.size() > 0 || this.debugOverlay != null) {
            this.g3d.setFrameBuffer(this.drmOnscreenFrameBuffer);
            this.g3d.setColorBufferEnabled(true, true, true, true);
            boolean bl = this.g3d.isBlendingEnabled();
            this.g3d.setBlendingEnabled(false);
            this.g3d.setDepthTestEnabled(false);
            this.g3d.setStencilTestEnabled(false);
            this.g3d.setScissorTestEnabled(false);
            this.g3d.setViewport(0, 0, this.displaySize.width, this.displaySize.height);
            this.g3d.resetMatrix(0);
            object = new Transform();
            ((Transform)object).setScale((float)this.displaySize.width / (float)this.drmFrameBufferTexture.getSizePowerTwo().width, (float)this.displaySize.height / (float)this.drmFrameBufferTexture.getSizePowerTwo().height, 1.0f);
            if (ContainerUI.DEBUG_REPAINT) {
                object = this.g3d.getDrawableManager().createPolyLineDrawable();
                for (n = this.drmDirtyRegions.size() - 1; n >= 0; --n) {
                    Rectangle rectangle = (Rectangle)this.drmDirtyRegions.get(n);
                    cloneable = new Point2f(rectangle.x, rectangle.y);
                    Point2f point2f = new Point2f((float)(rectangle.x + rectangle.width) - 1.0f, rectangle.y);
                    Point2f point2f2 = new Point2f((float)(rectangle.x + rectangle.width) - 1.0f, (float)(rectangle.y + rectangle.height) - 1.0f);
                    Point2f point2f3 = new Point2f(rectangle.x, (float)(rectangle.y + rectangle.height) - 1.0f);
                    object.setClosed(true);
                    object.setCoordinates2D(new Point2f[]{cloneable, point2f, point2f2, point2f3});
                    object.setColor(Color4f.CYAN);
                    object.setAlpha(16447);
                    object.draw();
                }
                object.dispose();
            }
            this.g3d.setBlendingEnabled(bl);
        }
    }

    private static void drawViews(Graphics3D graphics3D, List list, Rectangle rectangle) {
        boolean bl = LOGGER.isTraceEnabled(16);
        Rectangle rectangle2 = new Rectangle();
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            ViewModel viewModel = (ViewModel)list.get(i2);
            viewModel.setRenderOffscreenReplaceEnabled(i2 == list.size() - 1);
            if (!viewModel.isPaintable()) continue;
            try {
                viewModel.getBounds(rectangle2);
                viewModel.paint(graphics3D, viewModel, rectangle != null ? rectangle : rectangle2, rectangle2, AbstractWidgetUI.normalizeAlpha(viewModel.get_alpha()));
                if (!bl) continue;
                LogMessage logMessage = LOGGER.trace(16);
                logMessage.append("ViewCompositor.repaintViews() performed on view '").append(viewModel.get_name()).append("'").log();
                continue;
            }
            catch (Throwable throwable) {
                graphics3D.reset();
                AbstractWidget.resetRepaintsEnabled();
                LogMessage logMessage = LOGGER.error(16);
                logMessage.append("Exception during repaintViews() - resetting graphics state: ");
                logMessage.attachThrowable(throwable);
                logMessage.log();
            }
        }
    }

    private void drawBackground() {
        if (this.backgroundImage != null) {
            if (this.backgroundUnderlay == null) {
                this.backgroundUnderlay = new ImageOverlay(LOGGER, this.g3d, "Background");
            }
            if (this.backgroundUnderlay.getImage() != this.backgroundImage) {
                this.backgroundUnderlay.setImage(this.backgroundImage);
            }
            this.backgroundUnderlay.draw();
        } else if (this.backgroundUnderlay != null) {
            this.backgroundUnderlay.dispose();
            this.backgroundUnderlay = null;
        }
    }

    private void drawOverlays() {
        this.g3d.resetMatrix(0);
        Matrix4f matrix4f = new Matrix4f();
        Camera.setOrtographicProjection(matrix4f, 0.0f, this.displaySize.width, this.displaySize.height, 0.0f, 0.0f, 1.0f);
        this.g3d.setProjectionTransformation(matrix4f);
        if (DRAW_POINTER && this.pointer != null) {
            this.pointer.draw();
        }
        if (DEBUG_OVERLAY_ENABLED && this.debugOverlay != null) {
            this.g3d.setPerformanceMetricsEnabled(false);
            this.debugOverlay.update(this.viewNames);
            this.debugOverlay.draw();
        }
        if (this.systemPerformanceOverlay != null && ServiceManager.configurationManager.isFeatureFlagSet(400)) {
            this.systemPerformanceOverlay.draw();
        }
    }

    @Override
    public void drawPanicMessage(Throwable throwable, Color4b color4b) {
        this.drawPanicMessage(throwable, new Color4f(255, 0, 0, 128));
    }

    @Override
    public void drawPanicMessage(Throwable throwable, Color4f color4f) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        this.drawPanicMessage(((Object)stringWriter).toString(), color4f);
    }

    @Override
    public void drawPanicMessage(String string, Color4b color4b) {
        this.drawPanicMessage(string, new Color4f(255, 0, 0, 128));
    }

    @Override
    public void drawPanicMessage(String string, Color4f color4f) {
        if (this.g3d == null) {
            this.initialize();
        }
        this.beginFrame();
        PanicOverlay panicOverlay = new PanicOverlay(LOGGER, this.g3d, this.displaySize, color4f);
        panicOverlay.draw(string);
        panicOverlay.dispose();
        this.endFrame();
    }

    private static void drawTest(Graphics3D graphics3D, Dimension dimension) {
        graphics3D.resetMatrix(0);
        int n = dimension.width / 2;
        int n2 = dimension.height / 2;
        int n3 = (dimension.width - n) / 2;
        int n4 = (dimension.height - n2) / 2;
        RectangleDrawable rectangleDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
        rectangleDrawable.setColor(Color4f.BLUE);
        rectangleDrawable.set(n3, n4, n, n2);
        rectangleDrawable.draw();
        rectangleDrawable.dispose();
        EllipseDrawable ellipseDrawable = graphics3D.getDrawableManager().createEllipseDrawable();
        ellipseDrawable.set(n3, n4, n, n2);
        ellipseDrawable.draw();
        ellipseDrawable.dispose();
    }

    static {
        DEPTH_BUFFER_DEPTH = Integer.getInteger("de.vw.mib.view.depth", 16);
        STENCIL_BUFFER_DEPTH = Integer.getInteger("de.vw.mib.view.stencil", 8);
        ANTIALIASING_SAMPLES = Integer.getInteger("de.vw.mib.view.antialiasing.samples", 0);
        DRAW_POINTER = System.getProperty("de.vw.mib.view.drawpointer") != null;
        CENTER_POINTER = System.getProperty("de.vw.mib.view.centerpointer") != null;
        DEBUG_OVERLAY_ALWAYS = System.getProperty("de.vw.mib.view.overlay.always") != null;
        DEBUG_OVERLAY_ENABLED = System.getProperty("de.vw.mib.view.overlay.disable") == null;
        LOGGER = ServiceManager.loggerFactory.getLogger(1024);
    }
}

