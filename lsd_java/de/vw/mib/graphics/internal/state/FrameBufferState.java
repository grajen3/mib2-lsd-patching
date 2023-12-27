/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.BlendingState;
import de.vw.mib.graphics.internal.state.ColorBufferState;
import de.vw.mib.graphics.internal.state.DepthBufferState;
import de.vw.mib.graphics.internal.state.ScissorState;
import de.vw.mib.graphics.internal.state.StencilBufferState;

public final class FrameBufferState
extends AbstractState {
    private static final Rectangle DEFAULT_VIEWPORT = new Rectangle(0, 0, 0, 0);
    public FrameBuffer frameBuffer;
    public ColorBufferState colorBufferState = new ColorBufferState();
    public DepthBufferState depthBufferState = new DepthBufferState();
    public StencilBufferState stencilBufferState = new StencilBufferState();
    public BlendingState blendingState = new BlendingState();
    public ScissorState scissorState = new ScissorState();
    public Rectangle viewport = new Rectangle(DEFAULT_VIEWPORT);

    @Override
    public Object clone() {
        FrameBufferState frameBufferState = (FrameBufferState)super.clone();
        frameBufferState.colorBufferState = (ColorBufferState)this.colorBufferState.clone();
        frameBufferState.depthBufferState = (DepthBufferState)this.depthBufferState.clone();
        frameBufferState.stencilBufferState = (StencilBufferState)this.stencilBufferState.clone();
        frameBufferState.blendingState = (BlendingState)this.blendingState.clone();
        frameBufferState.scissorState = (ScissorState)this.scissorState.clone();
        frameBufferState.viewport = (Rectangle)this.viewport.clone();
        return frameBufferState;
    }

    @Override
    public void reset() {
        this.colorBufferState.reset();
        this.depthBufferState.reset();
        this.stencilBufferState.reset();
        this.blendingState.reset();
        this.scissorState.reset();
        this.viewport.setBounds(DEFAULT_VIEWPORT);
    }
}

