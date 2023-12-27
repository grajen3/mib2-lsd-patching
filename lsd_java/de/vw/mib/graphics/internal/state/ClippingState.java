/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.ClipPlaneState;

public final class ClippingState
extends AbstractState {
    public ClipPlaneState[] clipPlaneStates;

    public ClippingState(int n) {
        this.clipPlaneStates = new ClipPlaneState[n];
        for (int i2 = 0; i2 < this.clipPlaneStates.length; ++i2) {
            this.clipPlaneStates[i2] = new ClipPlaneState();
        }
    }

    @Override
    public Object clone() {
        ClippingState clippingState = (ClippingState)super.clone();
        clippingState.clipPlaneStates = new ClipPlaneState[this.clipPlaneStates.length];
        for (int i2 = 0; i2 < this.clipPlaneStates.length; ++i2) {
            clippingState.clipPlaneStates[i2] = (ClipPlaneState)this.clipPlaneStates[i2].clone();
        }
        return clippingState;
    }

    @Override
    public void reset() {
        for (int i2 = 0; i2 < this.clipPlaneStates.length; ++i2) {
            this.clipPlaneStates[i2].reset();
        }
    }
}

