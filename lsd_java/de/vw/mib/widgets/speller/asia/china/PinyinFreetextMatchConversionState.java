/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.asia.china.PinyinFreetextConversionState;
import de.vw.mib.widgets.speller.asia.handler.BuildCandidatesHandler;
import de.vw.mib.widgets.speller.asia.handler.MatchCandidateSelectedHandler;
import de.vw.mib.widgets.speller.asia.handler.MatchOkEnablingHandler;
import de.vw.mib.widgets.speller.asia.handler.MatchRemoveSymbolPhraseHandler;
import de.vw.mib.widgets.speller.asia.handler.MatchSpaceHandler;
import de.vw.mib.widgets.speller.asia.handler.SelectCandidateHandler;
import de.vw.mib.widgets.speller.asia.handler.SetPredictionContextHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdatePredictionHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateSpellingPhrasesCursorPositionHandler;

class PinyinFreetextMatchConversionState
extends PinyinFreetextConversionState {
    private boolean oldOkEnabled = false;

    protected PinyinFreetextMatchConversionState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("PinyinFreetextMatchConversion[").append(super.toString()).append("]").toString();
    }

    @Override
    protected void initCandidateSelectionHandlerChain() {
        boolean bl = this.speller.is_syllablewiseInput();
        this.selectCanidateHandler = new SelectCandidateHandler();
        if (bl) {
            this.selectCanidateHandler.setImmediateSelection(bl);
        }
        this.candidateSelectedHandler = new MatchCandidateSelectedHandler();
        this.candidateSelectionHandlerChain = this.selectCanidateHandler;
        this.candidateSelectionHandlerChain.appendNextStateHandler(this.candidateSelectedHandler).appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1));
        this.registerAsiaStateHandler(this.candidateSelectionHandlerChain);
    }

    @Override
    protected void initRemoveSymbolPhraseHandlerChain() {
        this.removeSymbolPhraseHandlerChain = new BuildCandidatesHandler();
        this.removeSymbolPhraseHandlerChain.appendNextStateHandler(new MatchRemoveSymbolPhraseHandler()).appendNextStateHandler(new BuildCandidatesHandler()).appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1)).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler());
        this.registerAsiaStateHandler(this.removeSymbolPhraseHandlerChain);
    }

    @Override
    protected void initSpaceHandlerChain() {
        this.spaceHandlerChain = new BuildCandidatesHandler();
        this.spaceHandlerChain.appendNextStateHandler(new MatchSpaceHandler()).appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1));
        this.registerAsiaStateHandler(this.spaceHandlerChain);
    }

    @Override
    protected void initSyncPhrasesHandlerChain() {
        super.initSyncPhrasesHandlerChain();
        this.syncPhrasesHandlerChain.appendNextStateHandler(new MatchOkEnablingHandler());
    }

    @Override
    public boolean okPressed() {
        return false;
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.oldOkEnabled = this.speller.is_okEnabled();
        this.speller.set_okEnabled(false);
    }

    @Override
    public void onLeaveState(State state) {
        this.speller.set_okEnabled(this.oldOkEnabled);
        super.onLeaveState(state);
    }
}

