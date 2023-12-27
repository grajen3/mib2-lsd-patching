/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.state.AbstractState;

public final class ScissorState
extends AbstractState {
    private static final Rectangle DEFAULT_SCISSOR = new Rectangle(0, 0, 0, 0);
    public boolean enabled;
    public Rectangle scissor = new Rectangle(DEFAULT_SCISSOR);

    @Override
    public Object clone() {
        ScissorState scissorState = (ScissorState)super.clone();
        scissorState.scissor = (Rectangle)this.scissor.clone();
        return scissorState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        this.scissor.setBounds(DEFAULT_SCISSOR);
    }
}

