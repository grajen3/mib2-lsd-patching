/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.AbstractGraphics3D;
import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.util.Matrix4fStack;
import de.vw.mib.graphics.internal.util.MatrixStack;
import de.vw.mib.graphics.internal.util.TransformStack;
import de.vw.mib.graphics.mesh.Mesh;

public final class VertexState
extends AbstractState {
    private static final int DEFAULT_VIEW_TRANSFORM_STACK_DEPTH;
    public MatrixStack viewTransform = AbstractGraphics3D.OPTIMIZE_TRANSFORM ? new TransformStack(16) : new Matrix4fStack(16);
    public Mesh currentMesh;

    @Override
    public Object clone() {
        VertexState vertexState = (VertexState)super.clone();
        vertexState.viewTransform = (MatrixStack)this.viewTransform.clone();
        return vertexState;
    }

    @Override
    public void reset() {
        this.viewTransform.reset();
        this.currentMesh = null;
    }
}

