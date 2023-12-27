/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AbstractFreetextConversionState;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolHandler;
import de.vw.mib.widgets.speller.asia.handler.AddUserDefinedEntryHandler;
import de.vw.mib.widgets.speller.asia.handler.BuildCandidatesHandler;
import de.vw.mib.widgets.speller.asia.handler.BuildCandidatesPhrasesCursorPositionHandler;
import de.vw.mib.widgets.speller.asia.handler.GetSegmentationHandler;
import de.vw.mib.widgets.speller.asia.handler.OkHandler;
import de.vw.mib.widgets.speller.asia.handler.RemoveSymbolPhraseHandler;
import de.vw.mib.widgets.speller.asia.handler.SetPredictionContextHandler;
import de.vw.mib.widgets.speller.asia.handler.SpaceHandler;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateCandidatesHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdatePredictionHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateSpellingPhrasesCursorPositionHandler;

public abstract class AbstractCommonFreetextConversionState
extends AbstractFreetextConversionState {
    protected AddSymbolHandler addSymbolHandler;
    protected AbstractAsiaStateHandler addSymbolHandlerChain;
    protected AbstractAsiaStateHandler okHandlerChain;
    protected AbstractAsiaStateHandler removeSymbolPhraseHandlerChain;
    protected AbstractAsiaStateHandler resumeHandlerChain;
    protected AbstractAsiaStateHandler spaceHandlerChain;

    protected AbstractCommonFreetextConversionState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public boolean candidateSelected(String string, int n) {
        super.candidateSelected(string, n);
        return true;
    }

    @Override
    public boolean deleted() {
        return this.handleDeletedLongDeleted();
    }

    private boolean handleDeletedLongDeleted() {
        boolean bl = false;
        if (this.isCharMinReached()) {
            this.removeSymbolPhraseHandlerChain.doGetState();
            bl = true;
        }
        return bl;
    }

    private boolean handleKeyPressedKeyLongPressed() {
        boolean bl = false;
        if (!this.speller.isCharMaxReached()) {
            if (this.isTransferUnconvertedTriggered()) {
                this.spaceHandlerChain.doGetState();
            } else {
                this.addSymbolHandler.setSymbols(this.stateContext.getLastEnteredCharacter());
                this.addSymbolHandlerChain.doGetState();
            }
            bl = true;
        }
        return bl;
    }

    protected void initAddSymbolHandlerChain() {
        this.addSymbolHandler = new AddSymbolHandler();
        this.addSymbolHandlerChain = this.addSymbolHandler;
        this.addSymbolHandlerChain.appendNextStateHandler(new BuildCandidatesPhrasesCursorPositionHandler()).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler()).appendNextStateHandler(new UpdateCandidatesHandler());
        this.registerAsiaStateHandler(this.addSymbolHandlerChain);
    }

    @Override
    protected void initCandidateSelectionHandlerChain() {
        boolean bl = this.speller.is_syllablewiseInput();
        boolean bl2 = this.speller.is_wordSegmentationEnabled();
        super.initCandidateSelectionHandlerChain();
        if (bl) {
            this.selectCanidateHandler.setImmediateSelection(bl);
        }
        this.candidateSelectionHandlerChain.appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1)).appendNextStateHandler(new BuildCandidatesHandler()).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler());
        if (bl2) {
            this.candidateSelectionHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
        }
    }

    @Override
    protected void initCursorPositionHandlerChain() {
        boolean bl = this.speller.is_wordSegmentationEnabled();
        super.initCursorPositionHandlerChain();
        this.cursorPositionHandlerChain.appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1));
        if (bl) {
            this.cursorPositionHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
        }
    }

    protected void initOkHandlerChain() {
        boolean bl = this.speller.is_userDatabaseEnabled();
        boolean bl2 = this.speller.is_wordSegmentationEnabled();
        if (bl || bl2) {
            this.okHandlerChain = new TransferSymbolsUnconvertedHandler();
            if (bl) {
                this.okHandlerChain.appendNextStateHandler(new AddUserDefinedEntryHandler(1));
            }
            if (bl2) {
                this.okHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
            }
            this.okHandlerChain.appendNextStateHandler(new OkHandler());
        } else {
            this.okHandlerChain = new OkHandler(true);
        }
        this.registerAsiaStateHandler(this.okHandlerChain);
    }

    protected void initRemoveSymbolPhraseHandlerChain() {
        boolean bl = this.speller.is_wordSegmentationEnabled();
        this.removeSymbolPhraseHandlerChain = new BuildCandidatesHandler();
        this.removeSymbolPhraseHandlerChain.appendNextStateHandler(new RemoveSymbolPhraseHandler()).appendNextStateHandler(new BuildCandidatesHandler()).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler()).appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1));
        if (bl) {
            this.removeSymbolPhraseHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
        }
        this.registerAsiaStateHandler(this.removeSymbolPhraseHandlerChain);
    }

    protected void initResumeHandlerChain() {
        this.resumeHandlerChain = new UpdateSpellingPhrasesCursorPositionHandler().disableUpdateBlankValues();
        this.registerAsiaStateHandler(this.resumeHandlerChain);
    }

    protected void initSpaceHandlerChain() {
        boolean bl = this.speller.is_wordSegmentationEnabled();
        this.spaceHandlerChain = new BuildCandidatesHandler();
        this.spaceHandlerChain.appendNextStateHandler(new SpaceHandler()).appendNextStateHandler(new BuildCandidatesHandler()).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler()).appendNextStateHandler(new SetPredictionContextHandler(1)).appendNextStateHandler(new UpdatePredictionHandler(1));
        if (bl) {
            this.spaceHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
        }
        this.registerAsiaStateHandler(this.spaceHandlerChain);
    }

    @Override
    protected void initSyncPhrasesHandlerChain() {
        super.initSyncPhrasesHandlerChain();
        this.syncPhrasesHandlerChain.appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler().disableUpdateSelectionIndices());
    }

    @Override
    public boolean keyLongPressed() {
        return this.handleKeyPressedKeyLongPressed();
    }

    @Override
    public boolean keyPressed() {
        return this.handleKeyPressedKeyLongPressed();
    }

    @Override
    public boolean longDeleted() {
        return this.handleDeletedLongDeleted();
    }

    @Override
    public void onDeInitState() {
        this.addSymbolHandler = null;
        this.addSymbolHandlerChain = null;
        this.okHandlerChain = null;
        this.removeSymbolPhraseHandlerChain = null;
        this.resumeHandlerChain = null;
        this.spaceHandlerChain = null;
        super.onDeInitState();
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.initAddSymbolHandlerChain();
        this.initOkHandlerChain();
        this.initRemoveSymbolPhraseHandlerChain();
        this.initSpaceHandlerChain();
        this.initResumeHandlerChain();
    }

    @Override
    public boolean okPressed() {
        this.okHandlerChain.doGetState();
        return true;
    }

    @Override
    public void onResumeState() {
        super.onResumeState();
        this.resumeHandlerChain.doGetState();
    }

    @Override
    public String toString() {
        return new StringBuffer().append("AbstractCommonFreetextConversion[").append(super.toString()).append("]").toString();
    }
}

