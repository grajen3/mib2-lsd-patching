/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.china.AbstractHWRFreetextPredictionState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;

class HWRFreetextState
extends AbstractHWRFreetextPredictionState {
    protected HWRFreetextState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRFreetext[").append(super.toString()).append("]").toString();
    }
}

