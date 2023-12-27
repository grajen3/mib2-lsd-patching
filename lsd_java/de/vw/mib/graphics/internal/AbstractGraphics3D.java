/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.GraphicsPerformanceMetrics;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawableManager;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.internal.drawable.DrawableRendererManager;
import de.vw.mib.graphics.internal.effect.fixedfunction.FixedFunctionEffectManager;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.material.UncachedMaterialManager;
import de.vw.mib.graphics.internal.model.MeshModel;
import de.vw.mib.graphics.internal.scene.CachingSceneManager;
import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.BlendingState;
import de.vw.mib.graphics.internal.state.ClipPlaneState;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.state.TextureUnitState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.util.MatrixStack;
import de.vw.mib.graphics.light.Light;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.material.MaterialManager;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.nio.Buffer;
import java.util.Arrays;

public abstract class AbstractGraphics3D
implements Graphics3D {
    public static final boolean OPTIMIZE_TRANSFORM;
    public static final int MATRIX_TEXTURE_0;
    public static final int MATRIX_TEXTURE_1;
    public static final int MATRIX_TEXTURE_2;
    public static final int MATRIX_TEXTURE_3;
    protected static final boolean DEFER_BINDS;
    private static final boolean DEBUG_TEXTURE_ATLAS;
    private static final int DEBUG_TEXTURE_ATLAS_TEXTUREFORMAT;
    private CowList listeners;
    private Surface surface;
    private boolean statisticsEnabled = false;
    private GraphicsPerformanceMetrics statistics;
    protected GraphicsState state;
    private EffectManager effectManager;
    private DrawableRendererManager drawableManager;
    private MaterialManager materialManager;
    private SceneManager sceneManager;
    private Color4f tempColor = new Color4f(Color4f.BLACK);
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$AbstractGraphics3D;

    public AbstractGraphics3D() {
        this.listeners = CowList.EMPTY;
        this.statistics = new GraphicsPerformanceMetrics();
    }

    public AbstractGraphics3D(AbstractGraphics3D abstractGraphics3D) {
        this();
        this.effectManager = abstractGraphics3D.effectManager;
        this.drawableManager = abstractGraphics3D.drawableManager;
    }

    @Override
    public void dispose() {
        this.listeners = CowList.EMPTY;
        if (this.drawableManager != null) {
            this.drawableManager.dispose();
            this.drawableManager = null;
        }
        if (this.effectManager != null) {
            this.effectManager.dispose();
            this.effectManager = null;
        }
        this.getTextureManager().dispose();
        if (this.areShadersSupported()) {
            this.getShaderManager().dispose();
        }
        this.getMeshManager().dispose();
        if (this.sceneManager != null) {
            this.sceneManager.dispose();
        }
    }

    protected abstract Logger getLogger() {
    }

    @Override
    public final void addListener(GraphicsListener graphicsListener) {
        this.listeners = this.listeners.addIfAbsent(graphicsListener);
    }

    @Override
    public final void removeListener(GraphicsListener graphicsListener) {
        this.listeners = this.listeners.remove(graphicsListener);
    }

    public final GraphicsState getState() {
        return this.state;
    }

    public void beginFrame() {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            GraphicsListener graphicsListener = (GraphicsListener)cowList.head();
            graphicsListener.beginFrame(this);
        }
    }

    public void endFrame() {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            GraphicsListener graphicsListener = (GraphicsListener)cowList.head();
            graphicsListener.endFrame(this);
        }
        if (this.statistics != null) {
            ++this.statistics.drawnFrames;
        }
        this.debug();
    }

    public void bind(Surface surface) {
        this.surface = surface;
        this.reset();
    }

    public void unbind() {
        this.surface = null;
    }

    @Override
    public final Surface getSurface() {
        return this.surface;
    }

    private void debug() {
        if (DEBUG_TEXTURE_ATLAS && this.drawableManager != null) {
            boolean bl = true;
            TextureAtlas textureAtlas = this.drawableManager.getImageTextureAtlas();
            this.drawTextureAtlas(textureAtlas, DEBUG_TEXTURE_ATLAS_TEXTUREFORMAT);
        }
    }

    private void drawTextureAtlas(TextureAtlas textureAtlas, int n) {
        Color4f color4f = new Color4f(0, 0, 255, 159);
        Rectangle rectangle = new Rectangle();
        this.getViewport(rectangle);
        Matrix4f matrix4f = new Matrix4f();
        Camera.setOrtographicProjection(matrix4f, rectangle.x, rectangle.width, rectangle.height, rectangle.y, 0.0f, 1.0f);
        this.setProjectionTransformation(matrix4f);
        this.resetMatrix(0);
        RectangleDrawable rectangleDrawable = this.getDrawableManager().createRectangleDrawable();
        rectangleDrawable.set(rectangle);
        rectangleDrawable.setColor(color4f);
        rectangleDrawable.draw();
        int n2 = (int)Math.ceil(Util.sqrt(textureAtlas.getNumPages(n)));
        int n3 = rectangle.width / n2;
        int n4 = rectangle.height / n2;
        boolean bl = false;
        int n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                Texture2D texture2D = textureAtlas.getTexture(n, n5);
                if (texture2D != null) {
                    this.setTexture(0, texture2D);
                    this.pushMatrix(0);
                    this.translateMatrix(0, 0.0f, 0.0f, 31428);
                    int n6 = i3 * n3;
                    int n7 = i2 * n4;
                    Point2f point2f = new Point2f(n6, n7);
                    Point2f point2f2 = new Point2f((float)(n6 + n3) - 1.0f, n7);
                    Point2f point2f3 = new Point2f((float)(n6 + n3) - 1.0f, (float)(n7 + n4) - 1.0f);
                    Point2f point2f4 = new Point2f(n6, (float)(n7 + n4) - 1.0f);
                    Point2f point2f5 = new Point2f(n6, n7);
                    if (DEBUG_TEXTURE_ATLAS) {
                        LogMessage logMessage = this.getLogger().trace(256);
                        logMessage.append("PF: 0x").append(Integer.toHexString(n)).append(" #").append(n5).append(": ").append(textureAtlas.getCoverage(n, n5)).log();
                    }
                    this.popMatrix(0);
                }
                ++n5;
            }
        }
        if (DEBUG_TEXTURE_ATLAS) {
            this.getLogger().info(256, "-----------------------------------------");
        }
    }

    @Override
    public abstract void flush() {
    }

    @Override
    public abstract void finish() {
    }

    @Override
    public abstract void readPixels(int n, int n2, int n3, int n4, Buffer buffer) {
    }

    @Override
    public final boolean arePerformanceMetricsEnabled() {
        return this.statisticsEnabled;
    }

    @Override
    public final void setPerformanceMetricsEnabled(boolean bl) {
        this.statisticsEnabled = bl;
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            GraphicsListener graphicsListener = (GraphicsListener)cowList.head();
            graphicsListener.performanceMetricsEnabledChanged(this, bl);
        }
        if (bl) {
            this.statistics.clear();
        }
    }

    @Override
    public final GraphicsPerformanceMetrics getPerformanceMetrics() {
        return this.statistics;
    }

    @Override
    public void reset() {
        AbstractState abstractState;
        int n;
        if (this.state == null || this.state.lightingState.lightStates.length != this.getMaxLights() || this.state.clippingState.clipPlaneStates.length != this.getMaxClipPlanes() || this.state.texturingState.textureUnitStates.length != this.getTextureManager().getMaxTextureUnits()) {
            this.state = new GraphicsState(this.getMaxLights(), this.getMaxClipPlanes(), this.getTextureManager().getMaxTextureUnits());
        }
        this.state.reset();
        this.state.frameBufferState.frameBuffer = this.getFrameBufferManager().getDefaultFrameBuffer();
        this.colorBufferEnabledChanged(this.state.frameBufferState.colorBufferState.writeRedEnable, this.state.frameBufferState.colorBufferState.writeGreenEnable, this.state.frameBufferState.colorBufferState.writeBlueEnable, this.state.frameBufferState.colorBufferState.writeAlphaEnable);
        this.depthBufferEnabledChanged(this.state.frameBufferState.depthBufferState.writeEnable);
        this.stencilBufferEnabledChanged(this.state.frameBufferState.stencilBufferState.writeEnable);
        this.viewportChanged(this.state.frameBufferState.viewport.x, this.state.frameBufferState.viewport.y, this.state.frameBufferState.viewport.width, this.state.frameBufferState.viewport.height);
        this.depthRangeChanged(this.getDepthRangeNear(), this.getDepthRangeFar());
        this.scissorChanged(this.state.frameBufferState.scissorState.scissor.x, this.state.frameBufferState.scissorState.scissor.y, this.state.frameBufferState.scissorState.scissor.width, this.state.frameBufferState.scissorState.scissor.height);
        this.scissorTestEnabledChanged(this.isScissorTestEnabled());
        this.alphaTestChanged(this.getAlphaTestFunction(), this.getAlphaTestReferenceValue());
        this.alphaTestEnableChanged(this.isAlphaTestEnabled());
        this.depthTestFunctionChanged(this.getDepthTestFunction());
        this.depthTestEnableChanged(this.isDepthTestEnabled());
        this.stencilTestChanged(this.getStencilTestFunction(), this.getStencilTestReferenceValue(), this.getStencilTestMask());
        this.stencilTestEnableChanged(this.isStencilTestEnabled());
        this.stencilOperationChanged(this.getStencilFailOperation(), this.getStencilZFailOperation(), this.getStencilZPassOperation());
        this.blendFactorsChanged(this.getBlendFactorSource(), this.getBlendFactorDestination());
        this.blendColorChanged(this.state.frameBufferState.blendingState.blendColor);
        if (this.isBlendEquationAvailable()) {
            this.blendEquationChanged(this.getBlendEquation());
        }
        this.blendingEnabledChanged(this.isBlendingEnabled());
        this.colorChanged(this.state.rasterizerState.color);
        this.alphaChanged(this.state.rasterizerState.alpha);
        this.materialChanged(this.state.lightingState.material);
        this.lightingEnabledChanged(this.isLightingEnabled());
        this.lightingAmbientColorChanged(this.state.lightingState.ambientColor);
        for (n = 0; n < this.state.lightingState.lightStates.length; ++n) {
            abstractState = this.state.lightingState.lightStates[n];
            this.lightEnabledChanged(n, abstractState.enabled);
            this.lightChanged(n, abstractState.light);
        }
        for (n = 0; n < this.state.clippingState.clipPlaneStates.length; ++n) {
            abstractState = this.state.clippingState.clipPlaneStates[n];
            this.clipPlaneEnabledChanged(n, ((ClipPlaneState)abstractState).enabled);
            this.clipPlaneChanged(n, ((ClipPlaneState)abstractState).planeEquation);
        }
        this.viewTransformationChanged(this.state.vertexState.viewTransform.peek());
        this.projectionTransformationChanged(this.state.projectionState.projectionTransform.peek());
        for (n = 0; n < this.state.texturingState.textureUnitStates.length; ++n) {
            abstractState = this.state.texturingState.textureUnitStates[n];
            this.textureChanged(n, ((TextureUnitState)abstractState).texture);
            this.textureWrappingChanged(n, ((TextureUnitState)abstractState).wrapS, ((TextureUnitState)abstractState).wrapT);
            this.textureFilteringChanged(n, ((TextureUnitState)abstractState).filterMin, ((TextureUnitState)abstractState).filterMag, ((TextureUnitState)abstractState).filterMip);
            this.textureBlendingChanged(n, ((TextureUnitState)abstractState).blendMode);
            this.textureBlendColorChanged(n, ((TextureUnitState)abstractState).blendColor);
            this.textureAddressGenerationModeChanged(n, ((TextureUnitState)abstractState).textureAddressGenerationMode);
            this.textureAddressGenerationEnabledChanged(n, ((TextureUnitState)abstractState).textureAddressGenerationEnable);
            this.textureTransformationChanged(n, ((TextureUnitState)abstractState).textureTransform.peek());
        }
    }

    @Override
    public abstract boolean areFrameBuffersSupported() {
    }

    @Override
    public abstract FrameBufferManager getFrameBufferManager() {
    }

    @Override
    public final FrameBuffer getFrameBuffer() {
        return this.state.frameBufferState.frameBuffer;
    }

    @Override
    public final void setFrameBuffer(FrameBuffer frameBuffer) {
        if (this.state.frameBufferState.frameBuffer != frameBuffer) {
            this.frameBufferChanged(frameBuffer);
            this.state.frameBufferState.frameBuffer = frameBuffer;
        }
    }

    protected abstract void frameBufferChanged(FrameBuffer frameBuffer) {
    }

    @Override
    public final boolean isColorBufferRedChannelEnabled() {
        return this.state.frameBufferState.colorBufferState.writeRedEnable;
    }

    @Override
    public final boolean isColorBufferGreenChannelEnabled() {
        return this.state.frameBufferState.colorBufferState.writeGreenEnable;
    }

    @Override
    public final boolean isColorBufferBlueChannelEnabled() {
        return this.state.frameBufferState.colorBufferState.writeBlueEnable;
    }

    @Override
    public final boolean isColorBufferAlphaChannelEnabled() {
        return this.state.frameBufferState.colorBufferState.writeAlphaEnable;
    }

    @Override
    public final void setColorBufferEnabled(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.colorBufferEnabledChanged(bl, bl2, bl3, bl4);
        this.state.frameBufferState.colorBufferState.writeRedEnable = bl;
        this.state.frameBufferState.colorBufferState.writeGreenEnable = bl2;
        this.state.frameBufferState.colorBufferState.writeBlueEnable = bl3;
        this.state.frameBufferState.colorBufferState.writeAlphaEnable = bl4;
    }

    protected abstract void colorBufferEnabledChanged(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    @Override
    public final boolean isDepthBufferEnabled() {
        return this.state.frameBufferState.depthBufferState.writeEnable;
    }

    @Override
    public final void setDepthBufferEnabled(boolean bl) {
        this.depthBufferEnabledChanged(bl);
        this.state.frameBufferState.depthBufferState.writeEnable = bl;
    }

    protected abstract void depthBufferEnabledChanged(boolean bl) {
    }

    @Override
    public final int isStencilBufferEnabled() {
        return this.state.frameBufferState.stencilBufferState.writeEnable;
    }

    @Override
    public final void setStencilBufferEnabled(int n) {
        this.stencilBufferEnabledChanged(n);
        this.state.frameBufferState.stencilBufferState.writeEnable = n;
    }

    protected abstract void stencilBufferEnabledChanged(int n) {
    }

    @Override
    public final boolean isDitheringEnabled() {
        return this.state.frameBufferState.colorBufferState.ditheringEnable;
    }

    @Override
    public final void setDitheringEnabled(boolean bl) {
        if (this.state.frameBufferState.colorBufferState.ditheringEnable != bl) {
            this.ditheringEnabledChanged(bl);
            this.state.frameBufferState.colorBufferState.ditheringEnable = bl;
        }
    }

    protected abstract void ditheringEnabledChanged(boolean bl) {
    }

    @Override
    public final void getViewport(Rectangle rectangle) {
        rectangle.setBounds(this.state.frameBufferState.viewport);
    }

    @Override
    public final void setViewport(Rectangle rectangle) {
        if (!this.state.frameBufferState.viewport.equals(rectangle)) {
            this.viewportChanged(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            this.state.frameBufferState.viewport.setBounds(rectangle);
        }
    }

    @Override
    public final void setViewport(int n, int n2, int n3, int n4) {
        if (this.state.frameBufferState.viewport.x != n || this.state.frameBufferState.viewport.y != n2 || this.state.frameBufferState.viewport.width != n3 || this.state.frameBufferState.viewport.height != n4) {
            this.viewportChanged(n, n2, n3, n4);
            this.state.frameBufferState.viewport.setBounds(n, n2, n3, n4);
        }
    }

    protected abstract void viewportChanged(int n, int n2, int n3, int n4) {
    }

    @Override
    public final float getDepthRangeNear() {
        return this.state.frameBufferState.depthBufferState.rangeNear;
    }

    @Override
    public final float getDepthRangeFar() {
        return this.state.frameBufferState.depthBufferState.rangeFar;
    }

    @Override
    public final void setDepthRange(float f2, float f3) {
        this.depthRangeChanged(f2, f3);
        this.state.frameBufferState.depthBufferState.rangeNear = f2;
        this.state.frameBufferState.depthBufferState.rangeFar = f3;
    }

    protected abstract void depthRangeChanged(float f2, float f3) {
    }

    @Override
    public void clearColorBuffer(Color4f color4f) {
        this.state.frameBufferState.colorBufferState.clearValue.set(color4f);
    }

    @Override
    public void clearDepthBuffer(float f2) {
        this.state.frameBufferState.depthBufferState.clearValue = f2;
    }

    @Override
    public void clearStencilBuffer(int n) {
        this.state.frameBufferState.stencilBufferState.clearValue = n;
    }

    @Override
    public void clearColorDepthBuffer(Color4f color4f, float f2) {
        this.state.frameBufferState.colorBufferState.clearValue.set(color4f);
        this.state.frameBufferState.depthBufferState.clearValue = f2;
    }

    @Override
    public void clearColorDepthStencilBuffer(Color4f color4f, float f2, int n) {
        this.state.frameBufferState.colorBufferState.clearValue.set(color4f);
        this.state.frameBufferState.depthBufferState.clearValue = f2;
        this.state.frameBufferState.stencilBufferState.clearValue = n;
    }

    @Override
    public final void getScissor(Rectangle rectangle) {
        Rectangle rectangle2 = this.state.frameBufferState.viewport;
        Rectangle rectangle3 = this.state.frameBufferState.scissorState.scissor;
        rectangle.setBounds(rectangle3.x - rectangle2.x, -rectangle3.y + rectangle2.y + rectangle2.height - rectangle3.height, rectangle3.width, rectangle3.height);
    }

    @Override
    public final void setScissor(Rectangle rectangle) {
        Rectangle rectangle2 = this.state.frameBufferState.viewport;
        this.setAbsScissor(rectangle2.x + rectangle.x, rectangle2.y + rectangle2.height - rectangle.y - rectangle.height, rectangle.width, rectangle.height);
    }

    @Override
    public final void setScissor(int n, int n2, int n3, int n4) {
        Rectangle rectangle = this.state.frameBufferState.viewport;
        this.setAbsScissor(rectangle.x + n, rectangle.y + rectangle.height - n2 - n4, n3, n4);
    }

    @Override
    public final void getAbsScissor(Rectangle rectangle) {
        rectangle.setBounds(this.state.frameBufferState.scissorState.scissor);
    }

    @Override
    public final void setAbsScissor(Rectangle rectangle) {
        if (!this.state.frameBufferState.scissorState.scissor.equals(rectangle)) {
            this.scissorChanged(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            this.state.frameBufferState.scissorState.scissor.setBounds(rectangle);
        }
    }

    @Override
    public final void setAbsScissor(int n, int n2, int n3, int n4) {
        if (this.state.frameBufferState.scissorState.scissor.x != n || this.state.frameBufferState.scissorState.scissor.y != n2 || this.state.frameBufferState.scissorState.scissor.width != n3 || this.state.frameBufferState.scissorState.scissor.height != n4) {
            this.scissorChanged(n, n2, n3, n4);
            this.state.frameBufferState.scissorState.scissor.setBounds(n, n2, n3, n4);
        }
    }

    protected abstract void scissorChanged(int n, int n2, int n3, int n4) {
    }

    @Override
    public final boolean isScissorTestEnabled() {
        return this.state.frameBufferState.scissorState.enabled;
    }

    @Override
    public final void setScissorTestEnabled(boolean bl) {
        if (this.state.frameBufferState.scissorState.enabled != bl) {
            this.scissorTestEnabledChanged(bl);
            this.state.frameBufferState.scissorState.enabled = bl;
        }
    }

    protected abstract void scissorTestEnabledChanged(boolean bl) {
    }

    @Override
    public final int getAlphaTestFunction() {
        return this.state.frameBufferState.colorBufferState.alphaTestFunc;
    }

    @Override
    public final float getAlphaTestReferenceValue() {
        return this.state.frameBufferState.colorBufferState.alphaTestReferenceValue;
    }

    @Override
    public final void setAlphaTest(int n, float f2) {
        if (this.state.frameBufferState.colorBufferState.alphaTestFunc != n || this.state.frameBufferState.colorBufferState.alphaTestReferenceValue != f2) {
            this.alphaTestChanged(n, f2);
            this.state.frameBufferState.colorBufferState.alphaTestFunc = n;
            this.state.frameBufferState.colorBufferState.alphaTestReferenceValue = f2;
        }
    }

    protected abstract void alphaTestChanged(int n, float f2) {
    }

    @Override
    public final boolean isAlphaTestEnabled() {
        return this.state.frameBufferState.colorBufferState.alphaTestEnable;
    }

    @Override
    public final void setAlphaTestEnabled(boolean bl) {
        if (this.state.frameBufferState.colorBufferState.alphaTestEnable != bl) {
            this.alphaTestEnableChanged(bl);
            this.state.frameBufferState.colorBufferState.alphaTestEnable = bl;
        }
    }

    protected abstract void alphaTestEnableChanged(boolean bl) {
    }

    @Override
    public final int getDepthTestFunction() {
        return this.state.frameBufferState.depthBufferState.depthTestFunc;
    }

    @Override
    public final void setDepthTestFunction(int n) {
        if (this.state.frameBufferState.depthBufferState.depthTestFunc != n) {
            this.depthTestFunctionChanged(n);
            this.state.frameBufferState.depthBufferState.depthTestFunc = n;
        }
    }

    protected abstract void depthTestFunctionChanged(int n) {
    }

    @Override
    public final boolean isDepthTestEnabled() {
        return this.state.frameBufferState.depthBufferState.depthTestEnable;
    }

    @Override
    public final void setDepthTestEnabled(boolean bl) {
        if (this.state.frameBufferState.depthBufferState.depthTestEnable != bl) {
            this.depthTestEnableChanged(bl);
            this.state.frameBufferState.depthBufferState.depthTestEnable = bl;
        }
    }

    protected abstract void depthTestEnableChanged(boolean bl) {
    }

    @Override
    public final int getStencilTestFunction() {
        return this.state.frameBufferState.stencilBufferState.stencilTestFunc;
    }

    @Override
    public final int getStencilTestReferenceValue() {
        return this.state.frameBufferState.stencilBufferState.stencilTestReferenceValue;
    }

    @Override
    public final int getStencilTestMask() {
        return this.state.frameBufferState.stencilBufferState.stencilTestMask;
    }

    @Override
    public final void setStencilTest(int n, int n2, int n3) {
        if (this.state.frameBufferState.stencilBufferState.stencilTestFunc != n || this.state.frameBufferState.stencilBufferState.stencilTestReferenceValue != n2 || this.state.frameBufferState.stencilBufferState.stencilTestMask != n3) {
            this.stencilTestChanged(n, n2, n3);
            this.state.frameBufferState.stencilBufferState.stencilTestFunc = n;
            this.state.frameBufferState.stencilBufferState.stencilTestReferenceValue = n2;
            this.state.frameBufferState.stencilBufferState.stencilTestMask = n3;
        }
    }

    protected abstract void stencilTestChanged(int n, int n2, int n3) {
    }

    @Override
    public final boolean isStencilTestEnabled() {
        return this.state.frameBufferState.stencilBufferState.stencilTestEnable;
    }

    @Override
    public final void setStencilTestEnabled(boolean bl) {
        if (this.state.frameBufferState.stencilBufferState.stencilTestEnable != bl) {
            this.stencilTestEnableChanged(bl);
            this.state.frameBufferState.stencilBufferState.stencilTestEnable = bl;
        }
    }

    protected abstract void stencilTestEnableChanged(boolean bl) {
    }

    @Override
    public final int getStencilFailOperation() {
        return this.state.frameBufferState.stencilBufferState.failOp;
    }

    @Override
    public final int getStencilZFailOperation() {
        return this.state.frameBufferState.stencilBufferState.zFailOp;
    }

    @Override
    public final int getStencilZPassOperation() {
        return this.state.frameBufferState.stencilBufferState.zPassOp;
    }

    @Override
    public final void setStencilOperation(int n, int n2, int n3) {
        if (this.state.frameBufferState.stencilBufferState.failOp != n || this.state.frameBufferState.stencilBufferState.zFailOp != n2 || this.state.frameBufferState.stencilBufferState.zPassOp != n3) {
            this.stencilOperationChanged(n, n2, n3);
            this.state.frameBufferState.stencilBufferState.failOp = n;
            this.state.frameBufferState.stencilBufferState.zFailOp = n2;
            this.state.frameBufferState.stencilBufferState.zPassOp = n3;
        }
    }

    protected abstract void stencilOperationChanged(int n, int n2, int n3) {
    }

    public final int getBlendFactorSource() {
        return this.getBlendFactorSourceRGB();
    }

    public final int getBlendFactorDestination() {
        return this.getBlendFactorDestinationRGB();
    }

    public final void setBlendFactors(int n, int n2) {
        BlendingState blendingState = this.state.frameBufferState.blendingState;
        if (blendingState.blendFactorSourceRGB != n || blendingState.blendFactorSourceRGB != blendingState.blendFactorSourceAlpha || blendingState.blendFactorDestRGB != n2 || blendingState.blendFactorDestRGB != blendingState.blendFactorDestAlpha) {
            this.blendFactorsChanged(n, n2);
            blendingState.blendFactorSourceRGB = n;
            blendingState.blendFactorSourceAlpha = n;
            blendingState.blendFactorDestRGB = n2;
            blendingState.blendFactorDestAlpha = n2;
        }
    }

    protected abstract void blendFactorsChanged(int n, int n2) {
    }

    @Override
    public final int getBlendFactorSourceRGB() {
        return this.state.frameBufferState.blendingState.blendFactorSourceRGB;
    }

    @Override
    public final int getBlendFactorDestinationRGB() {
        return this.state.frameBufferState.blendingState.blendFactorDestRGB;
    }

    @Override
    public final int getBlendFactorSourceAlpha() {
        return this.state.frameBufferState.blendingState.blendFactorSourceAlpha;
    }

    @Override
    public final int getBlendFactorDestinationAlpha() {
        return this.state.frameBufferState.blendingState.blendFactorDestAlpha;
    }

    protected abstract boolean isBlendFuncSeparateAvailable() {
    }

    @Override
    public final void setBlendFactorsSeparate(int n, int n2, int n3, int n4) {
        if (this.isBlendFuncSeparateAvailable()) {
            BlendingState blendingState = this.state.frameBufferState.blendingState;
            if (blendingState.blendFactorSourceRGB != n || blendingState.blendFactorDestRGB != n2 || blendingState.blendFactorSourceAlpha != n3 || blendingState.blendFactorDestAlpha != n4) {
                this.blendFactorsSeparateChanged(n, n2, n3, n4);
                blendingState.blendFactorSourceRGB = n;
                blendingState.blendFactorDestRGB = n2;
                blendingState.blendFactorSourceAlpha = n3;
                blendingState.blendFactorDestAlpha = n4;
            }
        } else {
            this.setBlendFactors(n, n2);
            this.getLogger().trace(256, "AbstractGraphics3D.setBlendFactorsSeparate(): Missing BlendFuncSeparate extension. Using setBlendFactors() instead. This may lead to blending errors");
        }
    }

    protected abstract void blendFactorsSeparateChanged(int n, int n2, int n3, int n4) {
    }

    @Override
    public abstract boolean isBlendColorAvailable() {
    }

    @Override
    public final void getBlendColor(Color4f color4f) {
        color4f.set(this.state.frameBufferState.blendingState.blendColor);
    }

    @Override
    public final void setBlendColor(Color4f color4f) {
        if (this.isBlendColorAvailable()) {
            if (!this.state.frameBufferState.blendingState.blendColor.equals(color4f)) {
                this.blendColorChanged(color4f);
                this.state.frameBufferState.blendingState.blendColor.set(color4f);
            }
        } else {
            this.getLogger().trace(256, "AbstractGraphics3D.setBlendColor(): Missing BlendColor extension. Ignoring constant blend color. This may lead to blending errors");
        }
    }

    protected abstract void blendColorChanged(Color4f color4f) {
    }

    @Override
    public final int getBlendEquation() {
        return this.getBlendEquationRGB();
    }

    protected abstract boolean isBlendEquationAvailable() {
    }

    @Override
    public final void setBlendEquation(int n) {
        if (this.state.frameBufferState.blendingState.blendEquationRGB != n || this.state.frameBufferState.blendingState.blendEquationRGB != this.state.frameBufferState.blendingState.blendEquationAlpha) {
            this.blendEquationChanged(n);
            this.state.frameBufferState.blendingState.blendEquationRGB = n;
            this.state.frameBufferState.blendingState.blendEquationAlpha = n;
        }
    }

    protected abstract void blendEquationChanged(int n) {
    }

    @Override
    public final int getBlendEquationRGB() {
        return this.state.frameBufferState.blendingState.blendEquationRGB;
    }

    @Override
    public final int getBlendEquationAlpha() {
        return this.state.frameBufferState.blendingState.blendEquationAlpha;
    }

    protected abstract boolean isBlendEquationSeparateAvailable() {
    }

    @Override
    public final void setBlendEquationSeparate(int n, int n2) {
        if (this.isBlendEquationSeparateAvailable()) {
            BlendingState blendingState = this.state.frameBufferState.blendingState;
            if (blendingState.blendEquationRGB != n || blendingState.blendEquationAlpha != n2) {
                this.blendEquationSeparateChanged(n, n2);
                blendingState.blendEquationRGB = n;
                blendingState.blendEquationAlpha = n2;
            }
        } else {
            this.setBlendEquation(n);
            this.getLogger().trace(256, "AbstractGraphics3D.setBlendEquationSeparate(): Missing BlendEquationSeparate extension. Using setBlendEquation() instead. This may lead to blending errors");
        }
    }

    protected abstract void blendEquationSeparateChanged(int n, int n2) {
    }

    @Override
    public final boolean isBlendingEnabled() {
        return this.state.frameBufferState.blendingState.enabled;
    }

    @Override
    public final void setBlendingEnabled(boolean bl) {
        if (this.state.frameBufferState.blendingState.enabled != bl) {
            this.blendingEnabledChanged(bl);
            this.state.frameBufferState.blendingState.enabled = bl;
        }
    }

    protected abstract void blendingEnabledChanged(boolean bl) {
    }

    @Override
    public final int getFrontFaceWinding() {
        return this.state.cullingState.frontFaceWinding;
    }

    @Override
    public final void setFrontFaceWinding(int n) {
        if (this.state.cullingState.frontFaceWinding != n) {
            this.frontFaceWindingChanged(n);
            this.state.cullingState.frontFaceWinding = n;
        }
    }

    protected abstract void frontFaceWindingChanged(int n) {
    }

    @Override
    public final int getCullFace() {
        return this.state.cullingState.cullFace;
    }

    @Override
    public final void setCullFace(int n) {
        if (this.state.cullingState.cullFace != n) {
            this.cullFaceChanged(n);
            this.state.cullingState.cullFace = n;
        }
    }

    protected abstract void cullFaceChanged(int n) {
    }

    @Override
    public final boolean isCullingEnabled() {
        return this.state.cullingState.enabled;
    }

    @Override
    public final void setCullingEnabled(boolean bl) {
        if (this.state.cullingState.enabled != bl) {
            this.cullingEnabledChanged(bl);
            this.state.cullingState.enabled = bl;
        }
    }

    protected abstract void cullingEnabledChanged(boolean bl) {
    }

    public final void getColor(Color4f color4f) {
        color4f.set(this.state.rasterizerState.color);
    }

    public final void setColor(Color4f color4f) {
        if (!this.state.rasterizerState.color.equals(color4f)) {
            this.colorChanged(color4f);
            this.state.rasterizerState.color.set(color4f);
        }
    }

    public final void setColor(Color4b color4b) {
        this.tempColor.set(color4b);
        if (!this.state.rasterizerState.color.equals(this.tempColor)) {
            this.colorChanged(this.tempColor);
            this.state.rasterizerState.color.set(this.tempColor);
        }
    }

    protected abstract void colorChanged(Color4f color4f) {
    }

    public final float getAlpha() {
        return this.state.rasterizerState.alpha;
    }

    public final void setAlpha(float f2) {
        if (this.state.rasterizerState.alpha != f2) {
            this.alphaChanged(f2);
            this.state.rasterizerState.alpha = f2;
        }
    }

    protected abstract void alphaChanged(float f2) {
    }

    @Override
    public abstract float getMinimumLineWidth() {
    }

    @Override
    public abstract float getMaximumLineWidth() {
    }

    @Override
    public final float getLineWidth() {
        return this.state.rasterizerState.lineWidth;
    }

    @Override
    public final void setLineWidth(float f2) {
        if (this.state.rasterizerState.lineWidth != f2) {
            this.lineWidthChanged(f2);
            this.state.rasterizerState.lineWidth = f2;
        }
    }

    protected abstract void lineWidthChanged(float f2) {
    }

    @Override
    public abstract float getMinimumPointSize() {
    }

    @Override
    public abstract float getMaximumPointSize() {
    }

    @Override
    public final float getPointSize() {
        return this.state.rasterizerState.pointSize;
    }

    @Override
    public final void setPointSize(float f2) {
        if (this.state.rasterizerState.pointSize != f2) {
            this.pointSizeChanged(f2);
            this.state.rasterizerState.pointSize = f2;
        }
    }

    protected abstract void pointSizeChanged(float f2) {
    }

    public abstract int getMaxLights() {
    }

    public final boolean isLightingEnabled() {
        return this.state.lightingState.enabled;
    }

    public final void setLightingEnabled(boolean bl) {
        if (this.state.lightingState.enabled != bl) {
            this.lightingEnabledChanged(bl);
            this.state.lightingState.enabled = bl;
        }
    }

    protected abstract void lightingEnabledChanged(boolean bl) {
    }

    public final void getLightingAmbientColor(Color4f color4f) {
        color4f.set(this.state.lightingState.ambientColor);
    }

    public final void setLightingAmbientColor(Color4f color4f) {
        if (!this.state.lightingState.ambientColor.equals(color4f)) {
            this.lightingAmbientColorChanged(color4f);
            this.state.lightingState.ambientColor.set(color4f);
        }
    }

    protected abstract void lightingAmbientColorChanged(Color4f color4f) {
    }

    public final Light createLight() {
        return new Light();
    }

    public final void getLight(int n, Light light) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxLights())) {
            throw new AssertionError((Object)"Invalid light index");
        }
        light.set(this.state.lightingState.lightStates[n].light);
    }

    public final void setLight(int n, Light light) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxLights())) {
            throw new AssertionError((Object)"Invalid light index");
        }
        if (!this.state.lightingState.lightStates[n].light.equals(light)) {
            this.lightChanged(n, light);
            this.state.lightingState.lightStates[n].light.set(light);
        }
    }

    protected abstract void lightChanged(int n, Light light) {
    }

    public final boolean isLightEnabled(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxLights())) {
            throw new AssertionError((Object)"Invalid light index");
        }
        return this.state.lightingState.lightStates[n].enabled;
    }

    public final void setLightEnabled(int n, boolean bl) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxLights())) {
            throw new AssertionError((Object)"Invalid light index");
        }
        if (this.state.lightingState.lightStates[n].enabled != bl) {
            this.lightEnabledChanged(n, bl);
            this.state.lightingState.lightStates[n].enabled = bl;
        }
    }

    protected abstract void lightEnabledChanged(int n, boolean bl) {
    }

    public final void getMaterial(Material material) {
        material.set(this.state.lightingState.material);
    }

    public final void setMaterial(Material material) {
        if (!this.state.lightingState.material.equals(material)) {
            this.materialChanged(material);
            this.state.lightingState.material.set(material);
        }
    }

    protected abstract void materialChanged(Material material) {
    }

    public abstract int getMaxClipPlanes() {
    }

    public final float[] getClipPlane(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxClipPlanes())) {
            throw new AssertionError((Object)"Invalid clipping plane");
        }
        return this.state.clippingState.clipPlaneStates[n].planeEquation;
    }

    public final void setClipPlane(int n, float[] fArray) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxClipPlanes())) {
            throw new AssertionError((Object)"Invalid clipping plane");
        }
        if (!($assertionsDisabled || fArray != null && fArray.length == 4)) {
            throw new AssertionError((Object)"Invalid clip plane equation");
        }
        ClipPlaneState clipPlaneState = this.state.clippingState.clipPlaneStates[n];
        if (!Arrays.equals(clipPlaneState.planeEquation, fArray)) {
            this.clipPlaneChanged(n, fArray);
            System.arraycopy((Object)fArray, 0, (Object)clipPlaneState.planeEquation, 0, clipPlaneState.planeEquation.length);
        }
    }

    protected abstract void clipPlaneChanged(int n, float[] fArray) {
    }

    public final boolean isClipPlaneEnabled(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxClipPlanes())) {
            throw new AssertionError((Object)"Invalid clipping plane");
        }
        return this.state.clippingState.clipPlaneStates[n].enabled;
    }

    public final void setClipPlaneEnabled(int n, boolean bl) {
        if (!($assertionsDisabled || n >= 0 && n < this.getMaxClipPlanes())) {
            throw new AssertionError((Object)"Invalid clipping plane");
        }
        ClipPlaneState clipPlaneState = this.state.clippingState.clipPlaneStates[n];
        if (clipPlaneState.enabled != bl) {
            this.clipPlaneEnabledChanged(n, bl);
            clipPlaneState.enabled = bl;
        }
    }

    protected abstract void clipPlaneEnabledChanged(int n, boolean bl) {
    }

    protected final MatrixStack getTransformStack(int n) {
        switch (n) {
            case 0: {
                return this.state.vertexState.viewTransform;
            }
            case 1: {
                return this.state.projectionState.projectionTransform;
            }
            case 2: {
                return this.state.texturingState.textureUnitStates[0].textureTransform;
            }
            case 3: {
                return this.state.texturingState.textureUnitStates[1].textureTransform;
            }
            case 4: {
                return this.state.texturingState.textureUnitStates[2].textureTransform;
            }
            case 5: {
                return this.state.texturingState.textureUnitStates[3].textureTransform;
            }
        }
        throw new IllegalArgumentException("Invalid matrix mode");
    }

    public Graphics3D getMatrix(int n, Matrix4f matrix4f) {
        matrix4f.set(this.getTransformStack(n).peek());
        return this;
    }

    public Graphics3D setMatrix(int n, Matrix4f matrix4f) {
        this.getTransformStack(n).set(matrix4f);
        return this;
    }

    @Override
    public Graphics3D resetMatrix(int n) {
        this.getTransformStack(n).setIdentity();
        return this;
    }

    public Graphics3D multiplyMatrix(int n, Matrix4f matrix4f) {
        this.getTransformStack(n).mul(matrix4f);
        if (this.statistics != null) {
            ++this.statistics.matrixMults;
        }
        return this;
    }

    @Override
    public Graphics3D multiplyMatrix(int n, Transform transform) {
        this.getTransformStack(n).mul(transform);
        if (this.statistics != null) {
            ++this.statistics.matrixMults;
        }
        return this;
    }

    @Override
    public Graphics3D translateMatrix(int n, float f2, float f3, float f4) {
        this.getTransformStack(n).translate(f2, f3, f4);
        if (this.statistics != null) {
            ++this.statistics.matrixMults;
        }
        return this;
    }

    @Override
    public Graphics3D rotateMatrix(int n, float f2, float f3, float f4, float f5) {
        this.getTransformStack(n).rotate(f2, f3, f4, f5);
        if (this.statistics != null) {
            ++this.statistics.matrixMults;
        }
        return this;
    }

    @Override
    public Graphics3D scaleMatrix(int n, float f2, float f3, float f4) {
        this.getTransformStack(n).scale(f2, f3, f4);
        if (this.statistics != null) {
            ++this.statistics.matrixMults;
        }
        return this;
    }

    @Override
    public Graphics3D pushMatrix(int n) {
        this.getTransformStack(n).push();
        return this;
    }

    @Override
    public Graphics3D popMatrix(int n) {
        this.getTransformStack(n).pop();
        return this;
    }

    @Override
    public abstract TextureManager getTextureManager() {
    }

    public final Texture getTexture(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].texture;
    }

    @Override
    public final void setTexture(int n, Texture texture) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.texture != texture) {
            this.textureChanged(n, texture);
            textureUnitState.texture = texture;
        }
    }

    protected abstract void textureChanged(int n, Texture texture) {
    }

    public final void getTextureTransformation(int n, Matrix4f matrix4f) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        matrix4f.set(this.state.texturingState.textureUnitStates[n].textureTransform.peek());
    }

    public final void setTextureTransformation(int n, Matrix4f matrix4f) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        Matrix4f matrix4f2 = this.state.texturingState.textureUnitStates[n].textureTransform.peek();
        if (!matrix4f2.equals(matrix4f)) {
            this.textureTransformationChanged(n, matrix4f);
            matrix4f2.set(matrix4f);
        }
    }

    public final void setTextureTransformation(int n, Transform transform) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        Transform transform2 = this.state.texturingState.textureUnitStates[n].textureTransform.peekTransform();
        if (!transform2.equals(transform)) {
            this.textureTransformationChanged(n, transform.getAsMatrix());
            textureUnitState.textureTransform.set(transform);
        }
    }

    protected abstract void textureTransformationChanged(int n, Matrix4f matrix4f) {
    }

    public final int getTextureWrappingS(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].wrapS;
    }

    public final int getTextureWrappingT(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].wrapT;
    }

    public final void setTextureWrapping(int n, int n2, int n3) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.wrapS != n2 || textureUnitState.wrapT != n3) {
            this.textureWrappingChanged(n, n2, n3);
            textureUnitState.wrapS = n2;
            textureUnitState.wrapT = n3;
        }
    }

    protected abstract void textureWrappingChanged(int n, int n2, int n3) {
    }

    public final int getTextureFilteringMin(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].filterMin;
    }

    public final int getTextureFilteringMag(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].filterMag;
    }

    public final int getTextureFilteringMip(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].filterMip;
    }

    public final void setTextureFiltering(int n, int n2, int n3, int n4) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.filterMin != n2 || textureUnitState.filterMag != n3 || textureUnitState.filterMip != n4) {
            this.textureFilteringChanged(n, n2, n3, n4);
            textureUnitState.filterMin = n2;
            textureUnitState.filterMag = n3;
            textureUnitState.filterMip = n4;
        }
    }

    protected abstract void textureFilteringChanged(int n, int n2, int n3, int n4) {
    }

    public final int getTextureBlending(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].blendMode;
    }

    public final void setTextureBlending(int n, int n2) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.blendMode != n2) {
            this.textureBlendingChanged(n, n2);
            textureUnitState.blendMode = n2;
        }
    }

    protected abstract void textureBlendingChanged(int n, int n2) {
    }

    public final Color4f getTextureBlendColor(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return new Color4f(this.state.texturingState.textureUnitStates[n].blendColor);
    }

    public final void setTextureBlendColor(int n, Color4f color4f) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        Color4f color4f2 = textureUnitState.blendColor;
        if (!color4f2.equals(color4f)) {
            this.textureBlendColorChanged(n, color4f);
            color4f2.set(color4f);
        }
    }

    public final void setTextureBlendColor(int n, Color4b color4b) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        Color4f color4f = textureUnitState.blendColor;
        this.tempColor.set(color4b);
        if (!color4f.equals(this.tempColor)) {
            this.textureBlendColorChanged(n, this.tempColor);
            color4f.set(this.tempColor);
        }
    }

    protected abstract void textureBlendColorChanged(int n, Color4f color4f) {
    }

    public final int getTextureAddressGenerationMode(int n) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        return this.state.texturingState.textureUnitStates[n].textureAddressGenerationMode;
    }

    public final void setTextureAddressGenerationMode(int n, int n2) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.textureAddressGenerationMode != n2) {
            this.textureAddressGenerationModeChanged(n, n2);
            textureUnitState.textureAddressGenerationMode = n2;
        }
    }

    protected abstract void textureAddressGenerationModeChanged(int n, int n2) {
    }

    public final void setTextureAddressGenerationEnabled(int n, boolean bl) {
        if (!($assertionsDisabled || n >= 0 && n < this.getTextureManager().getMaxTextureUnits())) {
            throw new AssertionError((Object)"Invalid texture unit");
        }
        TextureUnitState textureUnitState = this.state.texturingState.textureUnitStates[n];
        if (textureUnitState.textureAddressGenerationEnable != bl) {
            this.textureAddressGenerationEnabledChanged(n, bl);
            textureUnitState.textureAddressGenerationEnable = bl;
        }
    }

    protected abstract void textureAddressGenerationEnabledChanged(int n, boolean bl) {
    }

    @Override
    public abstract boolean areShadersSupported() {
    }

    @Override
    public abstract ShaderManager getShaderManager() {
    }

    @Override
    public final void setShaderProgram(ShaderProgram shaderProgram) {
        if (this.state.shaderState.shaderProgram != shaderProgram) {
            this.shaderProgramChanged(shaderProgram);
            this.state.shaderState.shaderProgram = shaderProgram;
        }
    }

    protected abstract void shaderProgramChanged(ShaderProgram shaderProgram) {
    }

    @Override
    public abstract MeshManager getMeshManager() {
    }

    @Override
    public final Mesh getMesh() {
        return this.state.vertexState.currentMesh;
    }

    @Override
    public final void setMesh(Mesh mesh) {
        if (this.state.vertexState.currentMesh != mesh) {
            this.meshChanged(mesh);
            this.state.vertexState.currentMesh = mesh;
        }
    }

    protected abstract void meshChanged(Mesh mesh) {
    }

    public final void getViewTransformation(Matrix4f matrix4f) {
        matrix4f.set(this.state.vertexState.viewTransform.peek());
    }

    public final void setViewTransformation(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = this.state.vertexState.viewTransform.peek();
        if (!matrix4f2.equals(matrix4f)) {
            this.viewTransformationChanged(matrix4f);
            matrix4f2.set(matrix4f);
        }
    }

    @Override
    public final void getViewTransformation(Transform transform) {
        transform.setFromMatrix(this.state.vertexState.viewTransform.peek());
    }

    @Override
    public final void setViewTransformation(Transform transform) {
        Transform transform2 = this.state.vertexState.viewTransform.peekTransform();
        if (!transform2.equals(transform)) {
            this.viewTransformationChanged(transform.getAsMatrix());
            this.state.vertexState.viewTransform.set(transform);
        }
    }

    protected abstract void viewTransformationChanged(Matrix4f matrix4f) {
    }

    @Override
    public final void getProjectionTransformation(Matrix4f matrix4f) {
        matrix4f.set(this.state.projectionState.projectionTransform.peek());
    }

    @Override
    public final void setProjectionTransformation(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = this.state.projectionState.projectionTransform.peek();
        if (!matrix4f2.equals(matrix4f)) {
            this.projectionTransformationChanged(matrix4f);
            matrix4f2.set(matrix4f);
        }
    }

    public void setOrthographicProjection(float f2, float f3, float f4, float f5, float f6, float f7) {
        Matrix4f matrix4f = new Matrix4f();
        Camera.setOrtographicProjection(matrix4f, f2, f3, f4, f5, f6, f7);
        this.setProjectionTransformation(matrix4f);
    }

    public void setPerspectiveProjection(float f2, float f3, float f4, float f5) {
        Matrix4f matrix4f = new Matrix4f();
        Camera.setPerspectiveProjection(matrix4f, f2, f3, f4, f5);
        this.setProjectionTransformation(matrix4f);
    }

    protected abstract void projectionTransformationChanged(Matrix4f matrix4f) {
    }

    @Override
    public final void draw() {
        Mesh mesh = this.getMesh();
        if (mesh != null) {
            int n = mesh.getPrimitivesCount();
            for (int i2 = 0; i2 < n; ++i2) {
                Primitives primitives = mesh.getPrimitives(i2);
                this.draw(primitives);
            }
        } else {
            LogMessage logMessage = this.getLogger().warn(256);
            logMessage.append("draw(): No mesh set").log();
        }
    }

    @Override
    public abstract void draw(Primitives primitives) {
    }

    @Override
    public final EffectManager getEffectManager() {
        if (this.effectManager == null) {
            this.effectManager = this.areShadersSupported() ? new ShaderEffectManager(this, this.getLogger(), this.getState()) : new FixedFunctionEffectManager(this, this.getLogger());
        }
        return this.effectManager;
    }

    @Override
    public final DrawableManager getDrawableManager() {
        if (this.drawableManager == null) {
            this.drawableManager = new DrawableRendererManager(this, this.getLogger(), this.getState());
        }
        return this.drawableManager;
    }

    @Override
    public final MaterialManager getMaterialManager() {
        if (this.materialManager == null) {
            this.materialManager = new UncachedMaterialManager(this, this.getLogger());
        }
        return this.materialManager;
    }

    @Override
    public final Model createModel() {
        return new MeshModel(this, this.getLogger());
    }

    @Override
    public final SceneManager getSceneManager() {
        if (this.sceneManager == null) {
            this.sceneManager = new CachingSceneManager(this, this.getLogger());
        }
        return this.sceneManager;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$AbstractGraphics3D == null ? (class$de$vw$mib$graphics$internal$AbstractGraphics3D = AbstractGraphics3D.class$("de.vw.mib.graphics.internal.AbstractGraphics3D")) : class$de$vw$mib$graphics$internal$AbstractGraphics3D).desiredAssertionStatus();
        OPTIMIZE_TRANSFORM = System.getProperty("de.vw.mib.graphics.optimizetransform") != null;
        DEBUG_TEXTURE_ATLAS = System.getProperty("de.vw.mib.graphics.debugtextureatlas") != null;
        DEBUG_TEXTURE_ATLAS_TEXTUREFORMAT = Integer.getInteger("de.vw.mib.graphics.debugtextureatlas.format", 4356);
    }
}

