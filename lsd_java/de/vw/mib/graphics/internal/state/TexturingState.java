/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.state.TextureUnitState;

public final class TexturingState
extends AbstractState {
    public TextureUnitState[] textureUnitStates;

    public TexturingState(int n) {
        this.textureUnitStates = new TextureUnitState[n];
        for (int i2 = 0; i2 < this.textureUnitStates.length; ++i2) {
            this.textureUnitStates[i2] = new TextureUnitState();
        }
    }

    @Override
    public Object clone() {
        TexturingState texturingState = (TexturingState)super.clone();
        texturingState.textureUnitStates = new TextureUnitState[this.textureUnitStates.length];
        for (int i2 = 0; i2 < this.textureUnitStates.length; ++i2) {
            texturingState.textureUnitStates[i2] = (TextureUnitState)this.textureUnitStates[i2].clone();
        }
        return texturingState;
    }

    @Override
    public void reset() {
        for (int i2 = 0; i2 < this.textureUnitStates.length; ++i2) {
            this.textureUnitStates[i2].reset();
        }
    }
}

