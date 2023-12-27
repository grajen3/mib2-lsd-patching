/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.AbstractChinaHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;

class HWRFreetextNoPredictionState
extends AbstractChinaHWRCommonState {
    public HWRFreetextNoPredictionState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRFreetextNoPrediction[").append(super.toString()).append("]").toString();
    }

    @Override
    public boolean cursorLeftPressed() {
        int n = this.speller.getCursorPosition();
        if (this.speller.isSelectionDefined()) {
            int n2 = this.speller.getSelectionStart();
            this.processCursorMovementWithSelection(n, n2);
        } else if (n > 0) {
            n = Math.max(0, n - 1);
            this.processCursorMovementWithoutSelection(n);
        }
        return true;
    }

    @Override
    public boolean cursorPositionChanged(int n) {
        if (this.speller.isSelectionDefined()) {
            int n2 = this.speller.getCursorPosition();
            if (n2 != n) {
                this.processCursorMovementWithSelection(n2, n);
            }
        } else {
            this.processCursorMovementWithoutSelection(n);
        }
        return true;
    }

    @Override
    public boolean cursorRightPressed() {
        String string = this.speller.getEnteredText();
        int n = this.speller.getCursorPosition();
        if (this.speller.isSelectionDefined()) {
            int n2 = this.speller.getSelectionEnd();
            this.processCursorMovementWithSelection(n, n2);
        } else if (n < string.length()) {
            n = Math.min(n + 1, string.length());
            this.processCursorMovementWithoutSelection(n);
        }
        return true;
    }

    @Override
    public boolean deleted() {
        super.deleted();
        this.speller.setRecognizedCharacters(null);
        return true;
    }

    @Override
    public boolean okPressed() {
        if (this.speller.isSelectionDefined()) {
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            this.enableHwrArea(true);
            this.speller.setRecognizedCharacters(null);
            String string = this.speller.getEnteredText();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.confirmRecommendedRecognition(string, n, n2, n3);
        }
        this.fireSpellerEvent("okPressed", "", 0, 0, 0);
        return true;
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof HWRAwareState) && this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
            String string = this.speller.getEnteredText();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.confirmRecommendedRecognition(string, n, n2, n3);
        }
        super.onLeaveState(state);
    }

    @Override
    public void onViewCovered() {
        boolean bl = this.stateMachine.hwrConfirmationExpected;
        boolean bl2 = this.speller.isSelectionDefined();
        super.onViewUncovered();
        if (!this.stateMachine.hwrErrorConfirmed && bl && bl2) {
            this.speller.setRecognizedCharacters(null);
        }
    }

    protected void processCursorMovementWithoutSelection(int n) {
        if (this.speller.isCharMaxReached()) {
            HWRWrapper.getHWR(this.speller).startHwrEngine();
        }
        this.hwrPhraseBuffer.setCursorPosition(n);
        this.fireSpellerEvent("cursorPositionChanged", "", n, 0, 0);
    }

    protected void processCursorMovementWithSelection(int n, int n2) {
        String string = this.speller.getEnteredText();
        HWRWrapper.getHWR(this.speller).restartHwrEngine();
        this.enableHwrArea(true);
        this.speller.setRecognizedCharacters(null);
        int n3 = this.speller.getSelectionStart();
        int n4 = this.speller.getSelectionEnd();
        this.confirmRecommendedRecognition(string, n, n3, n4);
        this.fireSpellerEvent("cursorPositionChanged", "", n2, 0, 0);
        this.hwrPhraseBuffer.setCursorPosition(n2);
    }

    @Override
    public boolean recognizedCharacterSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!bl || this.speller.isSelectionDefined() && bl)) {
            super.recognizedCharacterSelected(string, n);
            this.speller.setRecognizedCharacters(null);
            int n2 = this.speller.isSelectionDefined() ? this.speller.getSelectionStart() : this.speller.getCursorPosition();
            this.fireSpellerEvent("keyPressed", string, n2, 0, 0);
        }
        return true;
    }
}

