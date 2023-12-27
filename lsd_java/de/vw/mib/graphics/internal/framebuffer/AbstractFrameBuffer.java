/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.framebuffer;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.framebuffer.FrameBufferPerformanceMetrics;
import de.vw.mib.graphics.framebuffer.RenderBuffer;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractFrameBuffer
extends AbstractResource
implements FrameBuffer,
Cacheable {
    private final FrameBufferManager frameBufferManager;
    private RenderBuffer colorBuffer;
    private RenderBuffer depthBuffer;
    private RenderBuffer stencilBuffer;

    public AbstractFrameBuffer(Graphics3D graphics3D, Logger logger, FrameBufferManager frameBufferManager) {
        super(graphics3D, logger);
        this.frameBufferManager = frameBufferManager;
        this.updateAllocationStatistics(this.frameBufferManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.frameBufferManager.getPerformanceMetrics(), false);
        if (this.colorBuffer != null) {
            this.colorBuffer.dispose();
            this.colorBuffer = null;
        }
        if (this.depthBuffer != null) {
            this.depthBuffer.dispose();
            this.depthBuffer = null;
        }
        if (this.stencilBuffer != null) {
            this.stencilBuffer.dispose();
            this.stencilBuffer = null;
        }
        super.dispose();
    }

    protected final void updateAllocationStatistics(FrameBufferPerformanceMetrics frameBufferPerformanceMetrics, boolean bl) {
        frameBufferPerformanceMetrics.allocatedFrameBuffers = frameBufferPerformanceMetrics.allocatedFrameBuffers + (bl ? 1 : -1);
    }

    @Override
    public int getByteSize() {
        throw new NotYetImplementedException();
    }

    protected final FrameBufferManager getFrameBufferManager() {
        return this.frameBufferManager;
    }

    @Override
    public final RenderBuffer getColorBuffer() {
        return this.colorBuffer;
    }

    @Override
    public final void setColorBuffer(RenderBuffer renderBuffer) {
        if (this.colorBuffer != renderBuffer) {
            this.colorBufferChanged(this.colorBuffer, renderBuffer);
            this.colorBuffer = renderBuffer;
        }
    }

    protected abstract void colorBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    @Override
    public final RenderBuffer getDepthBuffer() {
        return this.depthBuffer;
    }

    @Override
    public final void setDepthBuffer(RenderBuffer renderBuffer) {
        if (this.depthBuffer != renderBuffer) {
            this.depthBufferChanged(this.depthBuffer, renderBuffer);
            this.depthBuffer = renderBuffer;
        }
    }

    protected abstract void depthBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    @Override
    public final RenderBuffer getStencilBuffer() {
        return this.stencilBuffer;
    }

    @Override
    public final void setStencilBuffer(RenderBuffer renderBuffer) {
        if (this.stencilBuffer != renderBuffer) {
            this.stencilBufferChanged(this.stencilBuffer, renderBuffer);
            this.stencilBuffer = renderBuffer;
        }
    }

    protected abstract void stencilBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    public void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            FrameBufferPerformanceMetrics frameBufferPerformanceMetrics = this.getFrameBufferManager().getPerformanceMetrics();
            ++frameBufferPerformanceMetrics.frameBufferBinds;
        }
    }
}

