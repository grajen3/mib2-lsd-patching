/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.internal.state.AbstractState;

public final class StencilBufferState
extends AbstractState {
    public int writeEnable;
    public int clearValue;
    public int stencilTestFunc;
    public int stencilTestReferenceValue;
    public int stencilTestMask;
    public boolean stencilTestEnable;
    public int failOp;
    public int zFailOp;
    public int zPassOp;

    @Override
    public Object clone() {
        StencilBufferState stencilBufferState = (StencilBufferState)super.clone();
        return stencilBufferState;
    }

    @Override
    public void reset() {
        this.writeEnable = 0;
        this.clearValue = 0;
        this.stencilTestFunc = 7;
        this.stencilTestReferenceValue = 0;
        this.stencilTestMask = -1;
        this.stencilTestEnable = false;
        this.failOp = 0;
        this.zFailOp = 0;
        this.zPassOp = 0;
    }
}

