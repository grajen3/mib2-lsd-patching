/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.HWRAwareState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.AbstractChinaHWRCommonState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AddUserDefinedEntryHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerRegistry;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerUtilizingState;
import de.vw.mib.widgets.speller.asia.handler.BuildCandidatesHandler;
import de.vw.mib.widgets.speller.asia.handler.ClearHandler;
import de.vw.mib.widgets.speller.asia.handler.GetSegmentationHandler;
import de.vw.mib.widgets.speller.asia.handler.InitHandler;
import de.vw.mib.widgets.speller.asia.handler.OkHandler;
import de.vw.mib.widgets.speller.asia.handler.SetPredictionContextHandler;
import de.vw.mib.widgets.speller.asia.handler.UpdatePredictionHandler;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;

public abstract class AbstractHWRFreetextPredictionState
extends AbstractChinaHWRCommonState
implements AsiaStateHandlerUtilizingState {
    private AddUserDefinedEntryHandler addUserDefinedEntryHandler;
    private final AsiaStateHandlerRegistry asiaStateHandlerRegistry = new AsiaStateHandlerRegistry(this);
    private ClearHandler clearHandler;
    private AbstractAsiaStateHandler getPredictionHandlerChain;
    private GetSegmentationHandler getSegmentationHandler;
    private InitHandler initHandler;
    private AbstractAsiaStateHandler okHandlerChain;
    private SetPredictionContextHandler setPredictionContextHandler;

    protected AbstractHWRFreetextPredictionState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("AbstractHWRFreetextPredictionState[").append(super.toString()).append("]").toString();
    }

    @Override
    public final void armAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.armAsiaStateHandlers();
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
    public boolean deleted() {
        super.deleted();
        String string = this.hwrPhraseBuffer.getPredictionContext();
        this.setPredictionContextHandler.setContext(string);
        this.getPredictionHandlerChain.doGetState();
        if (this.getSegmentationHandler != null) {
            String string2 = this.hwrPhraseBuffer.getPhrases();
            this.getSegmentationHandler.setPhrase(string2);
            this.getSegmentationHandler.doGetStateSingle();
        }
        return true;
    }

    @Override
    public final void deregisterAllAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.deregisterAllAsiaStateHandlers();
    }

    @Override
    public final void deregisterAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.deregisterAsiaStateHandler(abstractAsiaStateHandler);
    }

    @Override
    public final void disarmAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.disarmAsiaStateHandlers();
    }

    private void initOkHandlerChain() {
        boolean bl = this.speller.is_userDatabaseEnabled();
        boolean bl2 = this.speller.is_wordSegmentationEnabled();
        if (bl || bl2) {
            if (bl) {
                if (this.okHandlerChain == null && this.addUserDefinedEntryHandler != null) {
                    this.okHandlerChain = this.addUserDefinedEntryHandler;
                } else if (this.addUserDefinedEntryHandler != null) {
                    this.okHandlerChain.appendNextStateHandler(this.addUserDefinedEntryHandler);
                } else {
                    this.stateContext.warn(SpellerLogger.getLogger()).append("User defined entry enabled, but not handler defined!").log();
                }
            }
            if (bl2) {
                if (this.okHandlerChain == null && this.getSegmentationHandler != null) {
                    this.okHandlerChain = this.getSegmentationHandler;
                } else if (this.getSegmentationHandler != null) {
                    this.okHandlerChain.appendNextStateHandler(this.getSegmentationHandler);
                } else {
                    this.stateContext.warn(SpellerLogger.getLogger()).append("Word segmentation enabled, but not handler defined!").log();
                }
            }
        }
        if (this.okHandlerChain == null) {
            this.okHandlerChain = new OkHandler(false);
        } else {
            this.okHandlerChain.appendNextStateHandler(new OkHandler());
        }
        this.registerAsiaStateHandler(this.okHandlerChain);
    }

    private void initSpecialHandlers() {
        boolean bl = this.speller.is_userDatabaseEnabled();
        boolean bl2 = this.speller.is_wordSegmentationEnabled();
        if (bl) {
            this.addUserDefinedEntryHandler = new AddUserDefinedEntryHandler(0);
            this.registerAsiaStateHandler(this.addUserDefinedEntryHandler);
        }
        if (bl2) {
            this.getSegmentationHandler = new GetSegmentationHandler(0);
            this.registerAsiaStateHandler(this.getSegmentationHandler);
        }
    }

    @Override
    public boolean keyPressed() {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.isSelectionDefined();
        super.keyPressed();
        if (!bl || bl2 && bl) {
            String string = this.hwrPhraseBuffer.getPredictionContext();
            this.setPredictionContextHandler.setContext(string);
            this.getPredictionHandlerChain.doGetState();
            if (this.getSegmentationHandler != null) {
                String string2 = this.hwrPhraseBuffer.getPhrases();
                this.getSegmentationHandler.setPhrase(string2);
                this.getSegmentationHandler.doGetStateSingle();
            }
        }
        return true;
    }

    @Override
    public boolean okPressed() {
        String string;
        if (this.speller.isSelectionDefined()) {
            HWRWrapper.getHWR(this.speller).restartHwrEngine();
            this.enableHwrArea(true);
            this.speller.setRecognizedCharacters(null);
            string = this.speller.getEnteredText();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.confirmRecommendedRecognition(string, n, n2, n3);
        }
        if (this.addUserDefinedEntryHandler != null) {
            string = this.hwrPhraseBuffer.getPhrases();
            this.addUserDefinedEntryHandler.setPhrase(string);
        }
        if (this.getSegmentationHandler != null) {
            string = this.hwrPhraseBuffer.getPhrases();
            this.getSegmentationHandler.setPhrase(string);
        }
        this.okHandlerChain.doGetState();
        return true;
    }

    @Override
    public void onDeInitState() {
        this.disarmAsiaStateHandlers();
        this.deregisterAllAsiaStateHandlers();
        this.addUserDefinedEntryHandler = null;
        this.clearHandler = null;
        this.getPredictionHandlerChain = null;
        this.getSegmentationHandler = null;
        this.initHandler = null;
        this.setPredictionContextHandler = null;
        this.okHandlerChain = null;
        super.onDeInitState();
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.armAsiaStateHandlers();
        this.initHandler.doGetState();
        if (!this.speller.isSelectionDefined() && this.hwrPhraseBuffer.getNumberOfPhrases() > 0 && this.getSegmentationHandler != null) {
            String string = this.hwrPhraseBuffer.getPhrases();
            this.getSegmentationHandler.setPhrase(string);
            this.getSegmentationHandler.doGetStateSingle();
        }
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.initHandler = new InitHandler();
        this.registerAsiaStateHandler(this.initHandler);
        this.clearHandler = new ClearHandler();
        this.registerAsiaStateHandler(this.clearHandler);
        this.initSpecialHandlers();
        this.initOkHandlerChain();
        this.setPredictionContextHandler = new SetPredictionContextHandler(0);
        this.getPredictionHandlerChain = this.setPredictionContextHandler;
        this.getPredictionHandlerChain.setNextStateHandler(new BuildCandidatesHandler()).setNextStateHandler(new UpdatePredictionHandler(0));
        this.registerAsiaStateHandler(this.getPredictionHandlerChain);
    }

    @Override
    public void onLeaveState(State state) {
        if (!(state instanceof HWRAwareState)) {
            if (this.stateMachine.hwrConfirmationExpected && this.speller.isSelectionDefined()) {
                String string = this.speller.getEnteredText();
                int n = this.speller.getCursorPosition();
                int n2 = this.speller.getSelectionStart();
                int n3 = this.speller.getSelectionEnd();
                this.confirmRecommendedRecognition(string, n, n2, n3);
            }
            this.clearHandler.doGetState();
        }
        super.onLeaveState(state);
    }

    @Override
    public void onViewUncovered() {
        boolean bl = this.stateMachine.hwrConfirmationExpected;
        boolean bl2 = this.speller.isSelectionDefined();
        super.onViewUncovered();
        if (!this.stateMachine.hwrErrorConfirmed && bl && bl2) {
            this.speller.setRecognizedCharacters(null);
            if (this.getSegmentationHandler != null) {
                String string = this.hwrPhraseBuffer.getPhrases();
                this.getSegmentationHandler.setPhrase(string);
                this.getSegmentationHandler.doGetStateSingle();
            }
        }
    }

    @Override
    public boolean predictionSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!this.speller.isCharMaxReached() || this.speller.isSelectionDefined() && bl)) {
            this.hwrPhraseBuffer.addPhrase(string);
            String string2 = this.hwrPhraseBuffer.getPredictionContext();
            this.setPredictionContextHandler.setContext(string2);
            this.getPredictionHandlerChain.doGetState();
            int n2 = this.speller.getCursorPosition();
            this.fireSpellerEvent("keyPressed", string, n2, n2, n2);
            if (this.getSegmentationHandler != null) {
                String string3 = this.hwrPhraseBuffer.getPhrases();
                this.getSegmentationHandler.setPhrase(string3);
                this.getSegmentationHandler.doGetStateSingle();
            }
        }
        return true;
    }

    @Override
    public boolean previewLineCollapsed() {
        boolean bl = this.stateMachine.hwrConfirmationExpected;
        boolean bl2 = this.speller.isSelectionDefined();
        super.previewLineCollapsed();
        if (bl && bl2) {
            this.speller.setRecognizedCharacters(null);
            if (this.getSegmentationHandler != null) {
                String string = this.hwrPhraseBuffer.getPhrases();
                this.getSegmentationHandler.setPhrase(string);
                this.getSegmentationHandler.doGetStateSingle();
            }
        }
        return true;
    }

    protected void processCursorMovementWithoutSelection(int n) {
        if (this.speller.isCharMaxReached()) {
            HWRWrapper.getHWR(this.speller).startHwrEngine();
        }
        this.hwrPhraseBuffer.setCursorPosition(n);
        String string = this.hwrPhraseBuffer.getPredictionContext();
        this.setPredictionContextHandler.setContext(string);
        this.setPredictionContextHandler.doGetStateSingle();
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
        String string2 = this.hwrPhraseBuffer.getPredictionContext();
        this.setPredictionContextHandler.setContext(string2);
        this.setPredictionContextHandler.doGetStateSingle();
        if (this.getSegmentationHandler != null) {
            String string3 = this.hwrPhraseBuffer.getPhrases();
            this.getSegmentationHandler.setPhrase(string3);
            this.getSegmentationHandler.doGetStateSingle();
        }
    }

    @Override
    public boolean recognizedCharacterSelected(String string, int n) {
        boolean bl = this.speller.isCharMaxReached();
        boolean bl2 = this.speller.willCharMaxExceed(this.hwrPhraseBuffer.getPhrases(), string);
        if (!bl2 && (!bl || this.speller.isSelectionDefined() && bl)) {
            super.recognizedCharacterSelected(string, n);
            String string2 = this.hwrPhraseBuffer.getPredictionContext();
            this.setPredictionContextHandler.setContext(string2);
            this.getPredictionHandlerChain.doGetState();
            int n2 = this.speller.isSelectionDefined() ? this.speller.getSelectionStart() : this.speller.getCursorPosition();
            this.fireSpellerEvent("keyPressed", string, n2, 0, 0);
            if (this.getSegmentationHandler != null) {
                String string3 = this.hwrPhraseBuffer.getPhrases();
                this.getSegmentationHandler.setPhrase(string3);
                this.getSegmentationHandler.doGetStateSingle();
            }
        }
        return true;
    }

    @Override
    public final void registerAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.registerAsiaStateHandler(abstractAsiaStateHandler);
    }
}

