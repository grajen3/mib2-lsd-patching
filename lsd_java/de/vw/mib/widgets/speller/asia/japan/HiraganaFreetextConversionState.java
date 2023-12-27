/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.speller.asia.AbstractCommonFreetextConversionState;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.ConversionAwareState;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolHiraganaStrategy;
import de.vw.mib.widgets.speller.asia.handler.BuildCandidatesPhrasesCursorPositionHandler;
import de.vw.mib.widgets.speller.asia.handler.GetSegmentationHandler;
import de.vw.mib.widgets.speller.asia.handler.HiraganaAddUserDefinedEntryHandler;
import de.vw.mib.widgets.speller.asia.handler.OkHandler;
import de.vw.mib.widgets.speller.asia.handler.ToggleSymbolHiraganaHandler;
import de.vw.mib.widgets.speller.asia.handler.TransferSymbolsUnconvertedHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateCandidatesHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateDiacriticMarksHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdateSpellingPhrasesCursorPositionHandler;

class HiraganaFreetextConversionState
extends AbstractCommonFreetextConversionState {
    protected AbstractAsiaStateHandler toggleSymbolHandlerChain;
    private HiraganaAddUserDefinedEntryHandler userDefinedEntryHandler;

    public HiraganaFreetextConversionState(AbstractStateMachine abstractStateMachine) {
        super(abstractStateMachine);
    }

    @Override
    public boolean equalConversionType(ConversionAwareState conversionAwareState) {
        if (this == conversionAwareState) {
            return true;
        }
        return conversionAwareState instanceof HiraganaFreetextConversionState;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HiraganaFreetextConversion[").append(super.toString()).append("]").toString();
    }

    @Override
    protected void initAddSymbolHandlerChain() {
        super.initAddSymbolHandlerChain();
        this.addSymbolHandler.setStrategy(new AddSymbolHiraganaStrategy());
        this.addSymbolHandlerChain.insertNextStateHandler(3, new UpdateDiacriticMarksHandler());
    }

    @Override
    protected void initCandidateSelectionHandlerChain() {
        super.initCandidateSelectionHandlerChain();
        this.candidateSelectionHandlerChain.insertNextStateHandler(2, new UpdateDiacriticMarksHandler());
        this.userDefinedEntryHandler = new HiraganaAddUserDefinedEntryHandler();
        this.candidateSelectionHandlerChain.appendNextStateHandler(this.userDefinedEntryHandler);
    }

    @Override
    protected void initInitHandlerChain() {
        super.initInitHandlerChain();
        this.initHandlerChain.appendNextStateHandler(new UpdateDiacriticMarksHandler());
    }

    @Override
    protected void initRemoveSymbolPhraseHandlerChain() {
        super.initRemoveSymbolPhraseHandlerChain();
        this.removeSymbolPhraseHandlerChain.insertNextStateHandler(4, new UpdateDiacriticMarksHandler());
    }

    @Override
    protected void initSyncPhrasesHandlerChain() {
        super.initSyncPhrasesHandlerChain();
        this.syncPhrasesHandlerChain.appendNextStateHandler(new UpdateDiacriticMarksHandler());
    }

    protected void initToggleSymbolHandlerChain() {
        this.toggleSymbolHandlerChain = new ToggleSymbolHiraganaHandler();
        this.toggleSymbolHandlerChain.appendNextStateHandler(new BuildCandidatesPhrasesCursorPositionHandler()).appendNextStateHandler(new UpdateSpellingPhrasesCursorPositionHandler()).appendNextStateHandler(new UpdateDiacriticMarksHandler()).appendNextStateHandler(new UpdateCandidatesHandler());
        this.registerAsiaStateHandler(this.toggleSymbolHandlerChain);
    }

    @Override
    protected void initOkHandlerChain() {
        boolean bl = this.speller.is_wordSegmentationEnabled();
        if (bl) {
            this.okHandlerChain = new TransferSymbolsUnconvertedHandler();
            this.okHandlerChain.appendNextStateHandler(new GetSegmentationHandler(1));
            this.okHandlerChain.appendNextStateHandler(new OkHandler());
        } else {
            this.okHandlerChain = new OkHandler(true);
        }
        this.registerAsiaStateHandler(this.okHandlerChain);
    }

    @Override
    public void onDeInitState() {
        this.toggleSymbolHandlerChain = null;
        super.onDeInitState();
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.initToggleSymbolHandlerChain();
    }

    @Override
    public boolean shiftPressed() {
        AsiaSpeller asiaSpeller = (AsiaSpeller)this.stateContext.getWidget();
        if (asiaSpeller.isInLatinAlphabet()) {
            this.stateContext.toggleLowerUpperCase();
        }
        this.toggleSymbolHandlerChain.doGetState();
        return true;
    }

    @Override
    public boolean candidateSelected(String string, int n) {
        this.userDefinedEntryHandler.setSelectedCandidate(string);
        this.userDefinedEntryHandler.setPreCandidateSelectionSpelling(this.speller.getSpelling());
        this.userDefinedEntryHandler.setSpeller(this.speller);
        return super.candidateSelected(string, n);
    }
}

