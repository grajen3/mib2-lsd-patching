/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.AbstractChinaHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.data.SpellerDataAdapter;

class HWRMatchState
extends AbstractChinaHWRCommonState {
    public HWRMatchState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRMatch[").append(super.toString()).append("]").toString();
    }

    @Override
    public boolean deleted() {
        this.setStateId(6);
        super.deleted();
        return true;
    }

    @Override
    public boolean keyPressed() {
        this.setStateId(6);
        super.keyPressed();
        return true;
    }

    @Override
    public boolean hwrErrorConfirmed() {
        boolean bl;
        boolean bl2 = this.speller.getEnteredText() != null ? this.speller.getEnteredText().length() > 0 : (bl = false);
        if (bl) {
            SpellerData spellerData = SpellerDataAdapter.removeAdapter(this.speller.get_spellerData());
            SpellerDataAdapter spellerDataAdapter = SpellerDataAdapter.getAdapter(spellerData);
            this.setStateId(6);
            this.stateMachine.getState().setSpellerData(spellerDataAdapter);
        }
        return super.hwrErrorConfirmed();
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        if (!(state instanceof HWRAwareState)) {
            boolean bl;
            boolean bl2 = this.speller.getEnteredText() != null ? this.speller.getEnteredText().length() > 0 : (bl = false);
            if (bl && !this.speller.isSelectionDefined()) {
                this.setStateId(6);
                this.stateMachine.getState().setSpellerData(this.speller.get_spellerData());
            }
        }
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof HWRAwareState)) {
            SpellerData spellerData = this.speller.get_spellerData();
            String string = spellerData != null ? spellerData.getEnteredText() : "";
            boolean bl = false;
            if (string != null) {
                boolean bl2 = bl = string.length() > 0;
            }
            if (bl) {
                int n = this.speller.getCursorPosition();
                this.speller.updateInputField(string, "", n, 0, 0);
            } else {
                this.speller.updateInputField("", "", 0, 0, 0);
            }
            this.hwrPhraseBuffer.removeAllPhrases();
        }
        super.onLeaveState(state);
    }

    @Override
    public void onViewUncovered() {
        if (!this.stateMachine.hwrErrorConfirmed && this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
            this.setStateId(6);
        }
        super.onViewUncovered();
    }

    @Override
    public boolean previewLineCollapsed() {
        if (this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
            this.setStateId(6);
        }
        super.previewLineCollapsed();
        return true;
    }

    @Override
    public boolean recognizedCharacterSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!bl || this.speller.isSelectionDefined() && bl)) {
            super.recognizedCharacterSelected(string, n);
            this.setStateId(6);
            int n2 = Math.max(this.speller.getCursorPosition() - 1, 0);
            this.fireSpellerEvent("keyPressed", string, n2, 0, 0);
        }
        return true;
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        String string;
        if (spellerData != null && (string = spellerData.getAvailableCharacters()) != null && string.length() > 0) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("Hide NVCs as long as recognized characters are not confirmed!").log();
            this.speller.updateSpellerButtons("", "");
        }
    }
}

