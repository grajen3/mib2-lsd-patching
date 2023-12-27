/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;

public final class HWRAreaHandler
extends OutEventAdapter {
    private final AbstractStateMachine stateMachine;

    public HWRAreaHandler(AbstractStateMachine abstractStateMachine) {
        this.stateMachine = abstractStateMachine;
    }

    @Override
    public void outPointEventFired(String string, int n, int n2, int n3, int n4) {
        if (this.stateMachine != null) {
            if (string.equals("pressed")) {
                this.stateMachine.getState().hwrAreaPressed();
            } else if (string.equals("released") || string.equals("clicked")) {
                this.stateMachine.getState().hwrAreaReleased();
            }
        }
    }
}

