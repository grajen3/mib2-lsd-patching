/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.state.AbstractState;

public final class ColorBufferState
extends AbstractState {
    public boolean writeRedEnable;
    public boolean writeGreenEnable;
    public boolean writeBlueEnable;
    public boolean writeAlphaEnable;
    public boolean ditheringEnable;
    public Color4f clearValue = new Color4f(Color4f.BLACK);
    public int alphaTestFunc;
    public float alphaTestReferenceValue;
    public boolean alphaTestEnable;

    @Override
    public Object clone() {
        ColorBufferState colorBufferState = (ColorBufferState)super.clone();
        colorBufferState.clearValue = (Color4f)this.clearValue.clone();
        return colorBufferState;
    }

    @Override
    public void reset() {
        this.writeRedEnable = true;
        this.writeGreenEnable = true;
        this.writeBlueEnable = true;
        this.writeAlphaEnable = true;
        this.ditheringEnable = true;
        this.clearValue.set(Color4f.BLACK);
        this.alphaTestFunc = 7;
        this.alphaTestReferenceValue = 0.0f;
        this.alphaTestEnable = false;
    }
}

