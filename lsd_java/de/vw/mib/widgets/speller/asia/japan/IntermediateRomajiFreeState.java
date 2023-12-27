/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.japan.LatinState;

final class IntermediateRomajiFreeState
extends LatinState {
    public IntermediateRomajiFreeState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    @Override
    public boolean keyPressed() {
        char c2;
        String string = this.stateContext.getLastEnteredCharacter();
        if (string != null && string.length() > 0 && Character.isLetter(c2 = string.charAt(0))) {
            this.setStateId(3);
            this.stateContext.fire_keyPressed();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Intermediate Romaji (Free)";
    }
}

