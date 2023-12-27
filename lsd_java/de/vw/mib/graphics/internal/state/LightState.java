/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.light.Light;

public final class LightState
extends AbstractState {
    private static final Light DEFAULT_LIGHT = new Light();
    public boolean enabled;
    public Light light = new Light(DEFAULT_LIGHT);

    @Override
    public Object clone() {
        LightState lightState = (LightState)super.clone();
        lightState.light = (Light)this.light.clone();
        return lightState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        this.light.set(DEFAULT_LIGHT);
    }
}

