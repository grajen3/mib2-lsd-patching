/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;

public final class DepthBufferState
extends AbstractState {
    public boolean writeEnable;
    public float clearValue;
    public float rangeNear;
    public float rangeFar;
    public int depthTestFunc;
    public boolean depthTestEnable;

    @Override
    public Object clone() {
        DepthBufferState depthBufferState = (DepthBufferState)super.clone();
        return depthBufferState;
    }

    @Override
    public void reset() {
        this.writeEnable = false;
        this.clearValue = 1.0f;
        this.rangeNear = 0.0f;
        this.rangeFar = 1.0f;
        this.depthTestFunc = 1;
        this.depthTestEnable = false;
    }
}

