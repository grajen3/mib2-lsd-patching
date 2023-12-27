/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;

public final class ClipPlaneState
extends AbstractState {
    private static final float[] DEFAULT_PLANE_EQUATION = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    public boolean enabled;
    public float[] planeEquation = new float[4];

    @Override
    public Object clone() {
        ClipPlaneState clipPlaneState = (ClipPlaneState)super.clone();
        clipPlaneState.planeEquation = (float[])this.planeEquation.clone();
        return clipPlaneState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        System.arraycopy((Object)DEFAULT_PLANE_EQUATION, 0, (Object)this.planeEquation, 0, this.planeEquation.length);
    }
}

