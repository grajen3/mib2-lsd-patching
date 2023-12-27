/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.offscreen;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.effect.image.filter.convolution.ConvolutionFilterEffect;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer$FBOffscreenDrawableCache;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.util.RectanglePacker;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

final class OffscreenDrawableRenderer$FrameBufferOffscreenDrawable
extends AbstractPooledDrawableRenderer$AbstractPooledDrawable
implements OffscreenDrawable,
Cacheable {
    private static final Color4f CLEAR_COLOR = Color4f.BLACK_TRANSPARENT;
    private static final int BORDER_VERTICAL_DEFAULT;
    private static final int BORDER_HORIZONTAL_DEFAULT;
    private static int nextPageOffset;
    private static int activeTexturePageIndex;
    private static Matrix4f tempMatrix;
    private final Mesh squareMesh;
    private boolean maintainPerspective;
    private int sourceWidth;
    private int sourceHeight;
    private int destinationX;
    private int destinationY;
    private int borderVertical = 1;
    private int borderHorizontal = 1;
    private Matrix4f oldProjectionMatrix;
    private Matrix4f newProjectionMatrix;
    private final Transform textureTransform;
    private final Rectangle oldAbsScissor;
    private final Rectangle oldViewport;
    private Rectangle bounds;
    private FrameBuffer oldFrameBuffer;
    private int frameBufferIndex;
    private int oldFrameBufferIndex;
    private boolean oldScissorTestEnabled;
    private int oldWidgetX;
    private int oldWidgetY;
    private boolean locked;
    private float[] convolutionFilterKernel;
    private int convolutionFilterWidth;
    private int convolutionFilterHeight;
    private boolean convolutionFilterGlowEnabled;
    private Color4f convolutionFilterGlowColor;
    private ConvolutionFilterEffect activeConvolutionFilterShaderEffect;
    private OffscreenDrawableRenderer$FBOffscreenDrawableCache frameBufferOffscreenDrawableCache;
    private static Color4f tempColor;

    public OffscreenDrawableRenderer$FrameBufferOffscreenDrawable(OffscreenDrawableRenderer offscreenDrawableRenderer, ObjectPool objectPool) {
        super(offscreenDrawableRenderer, objectPool);
        this.squareMesh = offscreenDrawableRenderer.getGraphics3D().getMeshManager().getNormalizedSquareMesh();
        this.frameBufferIndex = -1;
        this.locked = false;
        this.textureTransform = new Transform();
        this.oldAbsScissor = new Rectangle();
        this.oldViewport = new Rectangle();
        this.convolutionFilterKernel = null;
        this.convolutionFilterGlowColor = new Color4f(Color4f.BLACK_TRANSPARENT);
    }

    @Override
    public void dispose() {
        if (this.bounds != null) {
            this.frameBufferOffscreenDrawableCache.remove(this.calculateKey());
        }
        this.newProjectionMatrix = null;
        this.oldProjectionMatrix = null;
        this.destinationX = 0;
        this.destinationY = 0;
        this.sourceWidth = 0;
        this.sourceHeight = 0;
        this.borderHorizontal = 1;
        this.borderVertical = 1;
        this.maintainPerspective = false;
        this.convolutionFilterKernel = null;
        this.convolutionFilterWidth = 0;
        this.convolutionFilterHeight = 0;
        this.convolutionFilterGlowEnabled = false;
        this.convolutionFilterGlowColor.set(Color4f.BLACK_TRANSPARENT);
        this.oldFrameBuffer = null;
        this.frameBufferOffscreenDrawableCache = null;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedOffscreens = drawablePerformanceMetrics.allocatedOffscreens + (bl ? 1 : -1);
    }

    public void set(int n, int n2, boolean bl, OffscreenDrawableRenderer$FBOffscreenDrawableCache offscreenDrawableRenderer$FBOffscreenDrawableCache) {
        this.frameBufferOffscreenDrawableCache = offscreenDrawableRenderer$FBOffscreenDrawableCache;
        this.sourceWidth = n;
        this.sourceHeight = n2;
        this.maintainPerspective = bl;
        if (!this.maintainPerspective) {
            this.newProjectionMatrix = new Matrix4f();
            this.oldProjectionMatrix = new Matrix4f();
        }
    }

    private long calculateKey() {
        return (long)(this.bounds.x & 0xFFFF0000) << 32 | (long)((this.bounds.y & 0xFFFF0000) << 16) | (long)(this.frameBufferIndex & 0xFFFF0000);
    }

    @Override
    public void setX(int n) {
        this.destinationX = n;
    }

    @Override
    public void setY(int n) {
        this.destinationY = n;
    }

    @Override
    public int getWidth() {
        return this.sourceWidth;
    }

    @Override
    public int getHeight() {
        return this.sourceHeight;
    }

    @Override
    public boolean isMaintainPerspective() {
        return this.maintainPerspective;
    }

    @Override
    public int getByteSize() {
        return this.sourceWidth * this.sourceHeight;
    }

    @Override
    public void setFilterParams(float[] fArray, int n, int n2, boolean bl, Color4f color4f) {
        if (this.convolutionFilterWidth != n || this.convolutionFilterHeight != n2) {
            this.convolutionFilterWidth = n;
            this.convolutionFilterHeight = n2;
            int n3 = Math.max(this.convolutionFilterWidth + 1, this.convolutionFilterHeight + 1);
            this.setBorder(n3, n3);
            this.activeConvolutionFilterShaderEffect = null;
        }
        this.convolutionFilterKernel = fArray;
        this.convolutionFilterGlowColor.set(color4f);
        this.convolutionFilterGlowEnabled = bl;
    }

    private void setBorder(int n, int n2) {
        this.borderHorizontal = n;
        this.borderVertical = n2;
        if (this.bounds != null) {
            this.frameBufferOffscreenDrawableCache.remove(this.calculateKey());
        }
    }

    @Override
    public boolean isValid() {
        return this.bounds != null;
    }

    protected void invalidate() {
        if (this.bounds != null) {
            OffscreenDrawableRenderer offscreenDrawableRenderer = (OffscreenDrawableRenderer)this.getDrawableRenderer();
            RectanglePacker[] rectanglePackerArray = offscreenDrawableRenderer.getRectanglePacker();
            rectanglePackerArray[this.frameBufferIndex].removeRectangle(this.bounds);
            this.frameBufferIndex = -1;
            this.bounds = null;
        }
    }

    protected boolean isLocked() {
        return this.locked;
    }

    @Override
    public void prepareGraphics(Graphics3D graphics3D, Rectangle rectangle, int n) {
        this.prepareGraphics(graphics3D, rectangle, n, CLEAR_COLOR);
    }

    private void allocateDrawable() {
        Resource[] resourceArray;
        OffscreenDrawableRenderer offscreenDrawableRenderer = (OffscreenDrawableRenderer)this.getDrawableRenderer();
        int n = this.sourceWidth + 2 * this.borderHorizontal;
        int n2 = this.sourceHeight + 2 * this.borderVertical;
        if (this.bounds == null) {
            int n3;
            resourceArray = offscreenDrawableRenderer.getFrameBuffer();
            if (activeTexturePageIndex == -1) {
                n3 = nextPageOffset;
                nextPageOffset = (nextPageOffset + 1) % resourceArray.length;
            } else {
                n3 = activeTexturePageIndex;
            }
            RectanglePacker[] rectanglePackerArray = offscreenDrawableRenderer.getRectanglePacker();
            while (this.bounds == null) {
                int n4;
                for (int i2 = n4 = activeTexturePageIndex == -1 || resourceArray.length == 1 ? 0 : 1; i2 < resourceArray.length && this.bounds == null; ++i2) {
                    int n5 = (n3 + i2) % resourceArray.length;
                    this.bounds = rectanglePackerArray[n5].insert(n, n2);
                    if (this.bounds == null) continue;
                    this.frameBufferIndex = n5;
                    this.frameBufferOffscreenDrawableCache.put(this.calculateKey(), this);
                }
                if (this.bounds != null || this.frameBufferOffscreenDrawableCache.evict()) continue;
                if (activeTexturePageIndex != -1) {
                    this.bounds = rectanglePackerArray[activeTexturePageIndex].insert(n, n2);
                }
                if (this.bounds != null) {
                    Logger logger = this.getLogger();
                    if (logger.isTraceEnabled(512)) {
                        LogMessage logMessage = logger.trace(512);
                        logMessage.append(super.getClass().getName());
                        logMessage.append(".allocateDrawable(): Nested offscreen rendering. Using the same render-target nested whithin another FBO drawable. This could lead to graphical artifacts on some systems.").log();
                    }
                    this.frameBufferIndex = activeTexturePageIndex;
                    this.frameBufferOffscreenDrawableCache.put(this.calculateKey(), this);
                    continue;
                }
                throw new IllegalStateException(new StringBuffer().append(super.getClass().getName()).append(": Cache empty or all elements locked - must not happen! Cache size: ").append(this.frameBufferOffscreenDrawableCache.size()).toString());
            }
        }
        this.textureTransform.setIdentity();
        this.textureTransform.scale(1.0f, 32959, 1.0f);
        resourceArray = offscreenDrawableRenderer.getTexture();
        this.textureTransform.translate((float)(this.bounds.x + this.borderHorizontal) / (float)resourceArray[this.frameBufferIndex].getSizePowerTwo().width, (float)(this.bounds.y + this.borderVertical) / (float)resourceArray[this.frameBufferIndex].getSizePowerTwo().height - 1.0f, 0.0f);
        this.textureTransform.scale((float)(this.bounds.width - 2 * this.borderHorizontal) / (float)resourceArray[this.frameBufferIndex].getSizePowerTwo().width, (float)(this.bounds.height - 2 * this.borderVertical) / (float)resourceArray[this.frameBufferIndex].getSizePowerTwo().height, 1.0f);
    }

    @Override
    public void prepareGraphics(Graphics3D graphics3D, Rectangle rectangle, int n, Color4f color4f) {
        OffscreenDrawableRenderer offscreenDrawableRenderer = (OffscreenDrawableRenderer)this.getDrawableRenderer();
        FrameBuffer[] frameBufferArray = offscreenDrawableRenderer.getFrameBuffer();
        if (this.isValid() && this.frameBufferIndex == activeTexturePageIndex && frameBufferArray.length > 1) {
            this.frameBufferOffscreenDrawableCache.remove(this.calculateKey());
        }
        if (this.bounds == null) {
            this.allocateDrawable();
        } else {
            this.frameBufferOffscreenDrawableCache.get(this.calculateKey());
        }
        FrameBufferTexture[] frameBufferTextureArray = offscreenDrawableRenderer.getTexture();
        this.oldFrameBuffer = graphics3D.getFrameBuffer();
        this.oldScissorTestEnabled = graphics3D.isScissorTestEnabled();
        graphics3D.getAbsScissor(this.oldAbsScissor);
        graphics3D.getViewport(this.oldViewport);
        graphics3D.pushMatrix(0);
        graphics3D.setFrameBuffer(frameBufferArray[this.frameBufferIndex]);
        this.oldWidgetX = rectangle.x;
        this.oldWidgetY = rectangle.y;
        graphics3D.setViewport(0, 0, frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().width, frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().height);
        graphics3D.setScissorTestEnabled(true);
        graphics3D.setScissor(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
        if (color4f != null) {
            graphics3D.clearColorBuffer(color4f);
        }
        if (this.maintainPerspective) {
            int n2 = Math.max(0, Math.min(this.oldViewport.width - this.bounds.width, rectangle.x));
            int n3 = Math.max(0, Math.min(this.oldViewport.height - this.bounds.height, rectangle.y));
            graphics3D.setViewport(this.bounds.x + this.borderHorizontal - n2, n3 - this.borderVertical - this.bounds.y + frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().height - this.oldViewport.height, this.oldViewport.width, this.oldViewport.height);
            graphics3D.setScissor(n2, n3, this.bounds.width - 2 * this.borderHorizontal, this.bounds.height - 2 * this.borderVertical);
            graphics3D.translateMatrix(0, n2 - rectangle.x, n3 - rectangle.y, -n);
            rectangle.translate(n2 - rectangle.x, n3 - rectangle.y);
        } else {
            float f2 = 0.0f;
            int n4 = 4201542;
            Camera.setOrtographicProjection(this.newProjectionMatrix, 0.0f, frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().width, 0.0f, frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().height, 0.0f, 4201542);
            graphics3D.getProjectionTransformation(this.oldProjectionMatrix);
            graphics3D.setProjectionTransformation(this.newProjectionMatrix);
            graphics3D.setScissor(this.bounds.x + this.borderHorizontal, this.bounds.y + this.borderVertical, this.bounds.width - 2 * this.borderHorizontal, this.bounds.height - 2 * this.borderVertical);
            graphics3D.resetMatrix(0);
            graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
            graphics3D.translateMatrix(0, this.bounds.x + this.borderHorizontal, this.bounds.y + this.borderVertical - frameBufferTextureArray[this.frameBufferIndex].getSizePowerTwo().height, 4234437);
            rectangle.setLocation(this.bounds.x + this.borderHorizontal, this.bounds.y + this.borderVertical);
        }
        this.oldFrameBufferIndex = activeTexturePageIndex;
        activeTexturePageIndex = this.frameBufferIndex;
        this.locked = true;
    }

    @Override
    public void restoreGraphics(Graphics3D graphics3D, Rectangle rectangle) {
        if (this.locked) {
            this.locked = false;
            if (!this.maintainPerspective) {
                graphics3D.setProjectionTransformation(this.oldProjectionMatrix);
            }
            rectangle.setLocation(this.oldWidgetX, this.oldWidgetY);
            graphics3D.popMatrix(0);
            graphics3D.setViewport(this.oldViewport);
            graphics3D.setFrameBuffer(this.oldFrameBuffer);
            this.oldFrameBuffer = null;
            graphics3D.setAbsScissor(this.oldAbsScissor);
            graphics3D.setScissorTestEnabled(this.oldScissorTestEnabled);
            activeTexturePageIndex = this.oldFrameBufferIndex;
        }
    }

    @Override
    public void draw() {
        if (!this.isValid()) {
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.warn(512);
            logMessage.append("Can't draw offscreenDrawable because it is no longer valid. ");
            logMessage.append("This is a sign for insufficient space within the offscreen texture atlas.");
            logMessage.log();
        } else {
            Graphics3D graphics3D = this.getGraphics3D();
            OffscreenDrawableRenderer offscreenDrawableRenderer = (OffscreenDrawableRenderer)this.getDrawableRenderer();
            this.frameBufferOffscreenDrawableCache.get(this.calculateKey());
            graphics3D.pushMatrix(0);
            try {
                Cloneable cloneable;
                boolean bl = false;
                FrameBufferTexture[] frameBufferTextureArray = offscreenDrawableRenderer.getTexture();
                FrameBufferTexture frameBufferTexture = frameBufferTextureArray[this.frameBufferIndex];
                if (this.destinationX != 0 || this.destinationY != 0) {
                    graphics3D.translateMatrix(0, this.destinationX, this.destinationY, 0.0f);
                }
                graphics3D.scaleMatrix(0, this.sourceWidth, this.sourceHeight, 1.0f);
                boolean bl2 = true;
                int n = 2;
                frameBufferTexture.setFilter(2, 2, 0);
                graphics3D.setTexture(0, frameBufferTexture);
                for (int i2 = graphics3D.getTextureManager().getMaxTextureUnits() - 1; i2 > 0; --i2) {
                    graphics3D.setTexture(i2, null);
                }
                EffectManager effectManager = graphics3D.getEffectManager();
                ImageTransformationEffect imageTransformationEffect = null;
                if (this.convolutionFilterKernel != null && this.convolutionFilterWidth * this.convolutionFilterHeight <= this.convolutionFilterKernel.length) {
                    if (this.activeConvolutionFilterShaderEffect == null) {
                        this.activeConvolutionFilterShaderEffect = effectManager.getConvolutionFilterEffect(this.convolutionFilterWidth, this.convolutionFilterHeight);
                    }
                    cloneable = frameBufferTexture.getSize();
                    this.activeConvolutionFilterShaderEffect.setKernel(this.convolutionFilterKernel);
                    this.activeConvolutionFilterShaderEffect.setAlphaOnly(this.convolutionFilterGlowEnabled);
                    this.activeConvolutionFilterShaderEffect.setTexelSize(1.0f / (float)((Dimension)cloneable).width, 1.0f / (float)((Dimension)cloneable).height);
                    imageTransformationEffect = this.activeConvolutionFilterShaderEffect;
                    tempColor.set(this.convolutionFilterGlowColor);
                } else {
                    imageTransformationEffect = effectManager.getImageTransformationEffect();
                    tempColor.set(this.getColor());
                }
                cloneable = offscreenDrawableRenderer.getGraphicsState();
                Matrix4f matrix4f = cloneable.vertexState.viewTransform.peek();
                Matrix4f matrix4f2 = cloneable.projectionState.projectionTransform.peek();
                imageTransformationEffect.setModelViewMatrix(matrix4f);
                if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
                    matrix4f2.mul(matrix4f, tempMatrix);
                    imageTransformationEffect.setModelViewProjectionMatrix(tempMatrix);
                } else {
                    imageTransformationEffect.setProjectionMatrix(matrix4f2);
                }
                tempColor.modulateAlpha(this.getAlpha());
                imageTransformationEffect.setColor(tempColor);
                imageTransformationEffect.setImageSampler(0);
                imageTransformationEffect.setImageTransformation(this.textureTransform.getAsMatrix());
                imageTransformationEffect.bind();
                graphics3D.setMesh(this.squareMesh);
                graphics3D.draw();
                super.draw();
            }
            catch (EffectException effectException) {
                Logger logger = this.getLogger();
                LogMessage logMessage = logger.error(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".draw() unrecoverable effect error:");
                logMessage.attachThrowable(effectException);
                logMessage.log();
            }
            graphics3D.popMatrix(0);
        }
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnOffscreens;
    }

    static {
        nextPageOffset = 0;
        activeTexturePageIndex = -1;
        tempMatrix = new Matrix4f();
        tempColor = new Color4f(Color4f.BLACK_TRANSPARENT);
    }
}

