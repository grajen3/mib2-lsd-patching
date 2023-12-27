/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.framebuffer;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.framebuffer.FrameBuffer;

public interface RenderBuffer
extends Resource {
    public static final int ATTACHMENT_COLOR_BUFFER;
    public static final int ATTACHMENT_DEPTH_BUFFER;
    public static final int ATTACHMENT_STENCIL_BUFFER;

    default public FrameBuffer getFrameBuffer() {
    }

    default public boolean isAttached() {
    }

    default public void attach(FrameBuffer frameBuffer, int n) {
    }

    default public void detach(int n) {
    }
}

