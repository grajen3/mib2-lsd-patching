/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.framebuffer;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferPerformanceMetrics;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;

public interface FrameBufferManager
extends ResourceManager {
    default public FrameBufferPerformanceMetrics getPerformanceMetrics() {
    }

    default public int getMaxRenderBufferSurfaceSize() {
    }

    default public RenderBufferSurface createRenderBufferSurface(int n, int n2, int n3) {
    }

    default public FrameBuffer getDefaultFrameBuffer() {
    }

    default public FrameBuffer createFrameBuffer() {
    }

    default public FrameBufferTexture createFrameBufferTexture(int n, int n2, int n3) {
    }
}

