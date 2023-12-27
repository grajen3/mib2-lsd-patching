/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.util.Matrix4fStack;

public final class ProjectionState
extends AbstractState {
    private static final int DEFAULT_PROJECTION_TRANSFORM_STACK_DEPTH;
    public Matrix4fStack projectionTransform = new Matrix4fStack(4);

    @Override
    public Object clone() {
        ProjectionState projectionState = (ProjectionState)super.clone();
        projectionState.projectionTransform = (Matrix4fStack)this.projectionTransform.clone();
        return projectionState;
    }

    @Override
    public void reset() {
        this.projectionTransform.reset();
    }
}

