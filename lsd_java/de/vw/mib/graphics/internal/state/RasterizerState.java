/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.state.AbstractState;

public final class RasterizerState
extends AbstractState {
    private static final Color4f DEFAULT_COLOR = Color4f.WHITE;
    private static final float DEFAULT_ALPHA;
    private static final float DEFAULT_LINE_WIDTH;
    private static final float DEFAULT_POINT_SIZE;
    public Color4f color = new Color4f(DEFAULT_COLOR);
    public float alpha;
    public float lineWidth;
    public float pointSize;

    @Override
    public Object clone() {
        RasterizerState rasterizerState = (RasterizerState)super.clone();
        rasterizerState.color = (Color4f)this.color.clone();
        return rasterizerState;
    }

    @Override
    public void reset() {
        this.color.set(DEFAULT_COLOR);
        this.alpha = 1.0f;
        this.lineWidth = 1.0f;
        this.pointSize = 1.0f;
    }
}

