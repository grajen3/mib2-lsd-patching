/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;

public final class CullingState
extends AbstractState {
    public boolean enabled;
    public int frontFaceWinding;
    public int cullFace;

    @Override
    public Object clone() {
        CullingState cullingState = (CullingState)super.clone();
        return cullingState;
    }

    @Override
    public void reset() {
        this.enabled = false;
        this.frontFaceWinding = 1;
        this.cullFace = 1;
    }
}

