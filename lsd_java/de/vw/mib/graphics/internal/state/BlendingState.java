/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.state.AbstractState;

public final class BlendingState
extends AbstractState {
    private static final Color4f DEFAULT_BLEND_COLOR = Color4f.BLACK_TRANSPARENT;
    public boolean enabled;
    public int blendFactorSourceRGB;
    public int blendFactorDestRGB;
    public int blendFactorSourceAlpha;
    public int blendFactorDestAlpha;
    public Color4f blendColor = new Color4f(DEFAULT_BLEND_COLOR);
    public int blendEquationRGB;
    public int blendEquationAlpha;

    @Override
    public Object clone() {
        BlendingState blendingState = (BlendingState)super.clone();
        blendingState.blendColor = (Color4f)this.blendColor.clone();
        return blendingState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        this.blendFactorSourceRGB = 1;
        this.blendFactorDestRGB = 0;
        this.blendFactorSourceAlpha = 1;
        this.blendFactorDestAlpha = 0;
        this.blendColor.set(DEFAULT_BLEND_COLOR);
        this.blendEquationRGB = 0;
        this.blendEquationAlpha = 0;
    }
}

