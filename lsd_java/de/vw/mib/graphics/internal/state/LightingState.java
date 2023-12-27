/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.LightState;
import de.vw.mib.graphics.material.Material;

public final class LightingState
extends AbstractState {
    private static final Color4f DEFAULT_AMBIENT_COLOR = new Color4f((float)-842249154, (float)-842249154, (float)-842249154, 1.0f);
    private static final Material DEFAULT_MATERIAL = new Material();
    public boolean enabled;
    public Material material = new Material(DEFAULT_MATERIAL);
    public Color4f ambientColor = new Color4f(DEFAULT_AMBIENT_COLOR);
    public LightState[] lightStates;

    public LightingState(int n) {
        this.lightStates = new LightState[n];
        for (int i2 = 0; i2 < this.lightStates.length; ++i2) {
            this.lightStates[i2] = new LightState();
        }
    }

    @Override
    public Object clone() {
        LightingState lightingState = (LightingState)super.clone();
        lightingState.material = (Material)this.material.clone();
        lightingState.ambientColor = (Color4f)this.ambientColor.clone();
        lightingState.lightStates = new LightState[this.lightStates.length];
        for (int i2 = 0; i2 < this.lightStates.length; ++i2) {
            lightingState.lightStates[i2] = (LightState)this.lightStates[i2].clone();
        }
        return lightingState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        this.material.set(DEFAULT_MATERIAL);
        this.ambientColor.set(DEFAULT_AMBIENT_COLOR);
        for (int i2 = 0; i2 < this.lightStates.length; ++i2) {
            this.lightStates[i2].reset();
        }
    }
}

