/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.offscreen;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer$FBOffscreenDrawableCache;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer$FrameBufferOffscreenDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.util.RectanglePacker;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class OffscreenDrawableRenderer
extends AbstractPooledDrawableRenderer {
    private static final boolean ENABLE_COMBINED_DEPTH_STENCIL_ATTACHMENT;
    private final Dimension[] size;
    private final int count;
    protected final FrameBuffer[] frameBuffer;
    protected final FrameBufferTexture[] frameBufferTexture;
    protected final RenderBufferSurface[] depthBufferSurface;
    protected final RenderBufferSurface[] stencilBufferSurface;
    protected final RectanglePacker[] rectanglePacker;
    private final OffscreenDrawableRenderer$FBOffscreenDrawableCache frameBufferOffscreenDrawableCache;

    public OffscreenDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureFormat[] textureFormatArray) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics);
        this.count = textureFormatArray.length;
        this.size = new Dimension[this.count];
        this.frameBuffer = new FrameBuffer[this.count];
        this.frameBufferTexture = new FrameBufferTexture[this.count];
        this.depthBufferSurface = new RenderBufferSurface[this.count];
        this.stencilBufferSurface = new RenderBufferSurface[this.count];
        this.rectanglePacker = new RectanglePacker[this.count];
        this.frameBufferOffscreenDrawableCache = new OffscreenDrawableRenderer$FBOffscreenDrawableCache();
        for (int i2 = 0; i2 < this.count; ++i2) {
            this.createFrameBuffer(graphics3D, i2, textureFormatArray[i2]);
        }
    }

    @Override
    public void dispose() {
        for (int i2 = 0; i2 < this.count; ++i2) {
            this.frameBuffer[i2].dispose();
            this.frameBufferTexture[i2].dispose();
        }
        super.dispose();
    }

    public void reset() {
        this.frameBufferOffscreenDrawableCache.clear();
    }

    private void createFrameBuffer(Graphics3D graphics3D, int n, TextureFormat textureFormat) {
        FrameBufferManager frameBufferManager = graphics3D.getFrameBufferManager();
        this.size[n] = new Dimension(textureFormat.width, textureFormat.height);
        this.rectanglePacker[n] = new RectanglePacker(this.size[n]);
        this.frameBufferTexture[n] = frameBufferManager.createFrameBufferTexture(textureFormat.textureFormat, this.size[n].width, this.size[n].height);
        this.stencilBufferSurface[n] = frameBufferManager.createRenderBufferSurface(5122, this.size[n].width, this.size[n].height);
        this.frameBuffer[n] = frameBufferManager.createFrameBuffer();
        this.frameBuffer[n].setColorBuffer(this.frameBufferTexture[n]);
        this.frameBuffer[n].setDepthBuffer(this.depthBufferSurface[n]);
        this.frameBuffer[n].setStencilBuffer(this.stencilBufferSurface[n]);
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new OffscreenDrawableRenderer$FrameBufferOffscreenDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public OffscreenDrawable createOffscreenDrawable(int n, int n2, boolean bl) {
        OffscreenDrawableRenderer$FrameBufferOffscreenDrawable offscreenDrawableRenderer$FrameBufferOffscreenDrawable = (OffscreenDrawableRenderer$FrameBufferOffscreenDrawable)this.getPooledInstance();
        offscreenDrawableRenderer$FrameBufferOffscreenDrawable.set(n, n2, bl, this.frameBufferOffscreenDrawableCache);
        return offscreenDrawableRenderer$FrameBufferOffscreenDrawable;
    }

    protected FrameBuffer[] getFrameBuffer() {
        return this.frameBuffer;
    }

    protected RectanglePacker[] getRectanglePacker() {
        return this.rectanglePacker;
    }

    protected FrameBufferTexture[] getTexture() {
        return this.frameBufferTexture;
    }
}

