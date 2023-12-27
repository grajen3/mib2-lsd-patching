/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.ClippingState;
import de.vw.mib.graphics.internal.state.CullingState;
import de.vw.mib.graphics.internal.state.FrameBufferState;
import de.vw.mib.graphics.internal.state.LightingState;
import de.vw.mib.graphics.internal.state.ProjectionState;
import de.vw.mib.graphics.internal.state.RasterizerState;
import de.vw.mib.graphics.internal.state.ShaderState;
import de.vw.mib.graphics.internal.state.TexturingState;
import de.vw.mib.graphics.internal.state.VertexState;

public final class GraphicsState
extends AbstractState {
    public FrameBufferState frameBufferState = new FrameBufferState();
    public CullingState cullingState = new CullingState();
    public LightingState lightingState;
    public ClippingState clippingState;
    public RasterizerState rasterizerState;
    public TexturingState texturingState;
    public ShaderState shaderState;
    public ProjectionState projectionState;
    public VertexState vertexState;

    public GraphicsState() {
        this(1, 1, 1);
    }

    public GraphicsState(int n, int n2, int n3) {
        this.lightingState = new LightingState(n);
        this.clippingState = new ClippingState(n2);
        this.rasterizerState = new RasterizerState();
        this.texturingState = new TexturingState(n3);
        this.shaderState = new ShaderState();
        this.projectionState = new ProjectionState();
        this.vertexState = new VertexState();
    }

    @Override
    public Object clone() {
        GraphicsState graphicsState = (GraphicsState)super.clone();
        graphicsState.cullingState = (CullingState)this.cullingState.clone();
        graphicsState.lightingState = (LightingState)this.lightingState.clone();
        graphicsState.clippingState = (ClippingState)this.clippingState.clone();
        graphicsState.rasterizerState = (RasterizerState)this.rasterizerState.clone();
        graphicsState.texturingState = (TexturingState)this.texturingState.clone();
        graphicsState.shaderState = (ShaderState)this.shaderState.clone();
        graphicsState.projectionState = (ProjectionState)this.projectionState.clone();
        graphicsState.vertexState = (VertexState)this.vertexState.clone();
        return graphicsState;
    }

    @Override
    public void reset() {
        this.frameBufferState.reset();
        this.cullingState.reset();
        this.lightingState.reset();
        this.clippingState.reset();
        this.rasterizerState.reset();
        this.texturingState.reset();
        this.shaderState.reset();
        this.projectionState.reset();
        this.vertexState.reset();
    }
}

