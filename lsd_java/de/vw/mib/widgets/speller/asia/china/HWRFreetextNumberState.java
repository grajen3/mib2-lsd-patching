/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.china.AbstractChinaHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;

class HWRFreetextNumberState
extends AbstractChinaHWRCommonState {
    public HWRFreetextNumberState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRFreetextNumber[").append(super.toString()).append("]").toString();
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
    public boolean cursorPositionChanged(int n) {
        return false;
    }
}

