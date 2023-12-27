/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.framebuffer;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.framebuffer.FrameBufferPerformanceMetrics;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractFrameBufferManager
extends AbstractResource
implements FrameBufferManager,
GraphicsListener {
    private final FrameBufferPerformanceMetrics performanceMetrics = new FrameBufferPerformanceMetrics();

    public AbstractFrameBufferManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        super.dispose();
    }

    @Override
    public final FrameBufferPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract int getMaxRenderBufferSurfaceSize() {
    }

    @Override
    public abstract RenderBufferSurface createRenderBufferSurface(int n, int n2, int n3) {
    }

    @Override
    public abstract FrameBuffer createFrameBuffer() {
    }

    @Override
    public final FrameBufferTexture createFrameBufferTexture(int n, int n2, int n3) {
        Graphics3D graphics3D = this.getGraphics3D();
        TextureManager textureManager = graphics3D.getTextureManager();
        return textureManager.createFrameBufferTexture(n, n2, n3);
    }

    @Override
    public abstract FrameBuffer getDefaultFrameBuffer() {
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}

