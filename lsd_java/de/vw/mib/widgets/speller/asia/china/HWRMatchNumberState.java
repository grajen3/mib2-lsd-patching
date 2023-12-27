/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.AbstractChinaHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;

class HWRMatchNumberState
extends AbstractChinaHWRCommonState {
    public HWRMatchNumberState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRMatchNumber[").append(super.toString()).append("]").toString();
    }

    @Override
    public boolean hwrCharactersRecognized(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            String string;
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            if (!this.speller.isCharMaxReached() && (string = this.determineSuitableRecognizedChar(this.hwrPhraseBuffer.getPhrases(), stringArray)) != null) {
                int n = this.speller.getCursorPosition();
                this.fireSpellerEvent("keyPressed", string, n, 0, 0);
            }
        } else {
            this.stateContext.fire_hwrErrorOccurred();
        }
        return true;
    }

    @Override
    public void onLeaveState(State state) {
        if (state instanceof HWRAwareState) {
            this.speller.updateInputField("", "", 0);
            this.hwrPhraseBuffer.removeAllPhrases();
        }
        super.onLeaveState(state);
    }
}

