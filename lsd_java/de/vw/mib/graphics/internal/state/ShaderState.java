/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.shader.ShaderProgram;

public final class ShaderState
extends AbstractState {
    public ShaderProgram shaderProgram;

    @Override
    public Object clone() {
        ShaderState shaderState = (ShaderState)super.clone();
        return shaderState;
    }

    @Override
    public void reset() {
        this.shaderProgram = null;
    }
}

