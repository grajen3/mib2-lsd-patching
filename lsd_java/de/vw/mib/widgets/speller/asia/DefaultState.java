/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.State;

public final class DefaultState
extends State {
    public DefaultState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public String toString() {
        return "DefaultState";
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        if (state == null) {
            this.fireHMIEvent("hwrDisabled");
        }
    }
}

