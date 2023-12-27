/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.framebuffer;

import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferManager;
import de.vw.mib.graphics.framebuffer.FrameBufferPerformanceMetrics;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;
import de.vw.mib.graphics.internal.surface.AbstractSurface;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractRenderBufferSurface
extends AbstractSurface
implements RenderBufferSurface {
    private final FrameBufferManager frameBufferManager;
    private final int width;
    private final int height;
    private FrameBuffer frameBuffer;
    private IntSet attachments;

    protected AbstractRenderBufferSurface(Graphics3D graphics3D, Logger logger, FrameBufferManager frameBufferManager, int n, int n2, int n3) {
        super(graphics3D, logger, n);
        this.frameBufferManager = frameBufferManager;
        this.width = n2;
        this.height = n3;
        this.frameBuffer = null;
        this.attachments = new IntOptHashSet();
        this.updateAllocationStatistics(this.frameBufferManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.frameBufferManager.getPerformanceMetrics(), false);
        if (this.isAttached()) {
            int[] nArray = this.attachments.toArray();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.detach(nArray[i2]);
            }
        }
        super.dispose();
    }

    protected final void updateAllocationStatistics(FrameBufferPerformanceMetrics frameBufferPerformanceMetrics, boolean bl) {
        int n = this.getByteSize();
        frameBufferPerformanceMetrics.allocatedRenderBuffers = frameBufferPerformanceMetrics.allocatedRenderBuffers + (bl ? 1 : -1);
        frameBufferPerformanceMetrics.allocatedRenderBuffersSizeBytes = frameBufferPerformanceMetrics.allocatedRenderBuffersSizeBytes + (bl ? n : -n);
    }

    protected final FrameBufferManager getFrameBufferManager() {
        return this.frameBufferManager;
    }

    @Override
    public final int getWidth() {
        return this.width;
    }

    @Override
    public final int getHeight() {
        return this.height;
    }

    @Override
    public final void setSize(int n, int n2) {
    }

    @Override
    public final FrameBuffer getFrameBuffer() {
        return this.frameBuffer;
    }

    @Override
    public final boolean isAttached() {
        return this.frameBuffer != null;
    }

    @Override
    public void attach(FrameBuffer frameBuffer, int n) {
        if (this.isAttached() && frameBuffer != this.frameBuffer) {
            throw new IllegalArgumentException("RenderBufferSurface already attached to another framebuffer");
        }
        this.frameBuffer = frameBuffer;
        this.attachments.add(n);
    }

    @Override
    public void detach(int n) {
        if (this.isAttached()) {
            if (!this.attachments.remove(n)) {
                throw new IllegalArgumentException("RenderBufferSurface not attached to this attachment");
            }
            if (this.attachments.size() == 0) {
                this.frameBuffer = null;
            }
        } else {
            throw new IllegalArgumentException("RenderBufferSurface not attached to any framebuffer");
        }
    }
}

