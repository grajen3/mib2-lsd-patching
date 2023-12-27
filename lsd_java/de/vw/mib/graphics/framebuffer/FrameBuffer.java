/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.framebuffer;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.framebuffer.RenderBuffer;

public interface FrameBuffer
extends Resource {
    default public RenderBuffer getColorBuffer() {
    }

    default public void setColorBuffer(RenderBuffer renderBuffer) {
    }

    default public RenderBuffer getDepthBuffer() {
    }

    default public void setDepthBuffer(RenderBuffer renderBuffer) {
    }

    default public RenderBuffer getStencilBuffer() {
    }

    default public void setStencilBuffer(RenderBuffer renderBuffer) {
    }
}

