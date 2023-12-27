/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.china.AbstractHWRFreetextPredictionState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;

class HWRFreetextWithPreviewLineState
extends AbstractHWRFreetextPredictionState {
    protected HWRFreetextWithPreviewLineState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRFreetextWithPreviewLine[").append(super.toString()).append("]").toString();
    }
}

