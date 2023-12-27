/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.AbstractHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;

public abstract class AbstractChinaHWRCommonState
extends AbstractHWRCommonState {
    protected AbstractChinaHWRCommonState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("ChinaHWRCommon[").append(super.toString()).append("]").toString();
    }
}

