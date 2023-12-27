/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.StringUtil;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerRegistry;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateHandlerUtilizingState;
import de.vw.mib.widgets.speller.asia.japan.AbstractCharacterBufferState;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState$1;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState$2;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState$3;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState$4;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;

abstract class AbstractCommomHiraganaState
extends AbstractCharacterBufferState
implements AsiaStateHandlerUtilizingState {
    private static final int INITIAL_HIRAGANA_BUFFER_SIZE;
    private static final int INITIAL_KANJI_BUFFER_SIZE;
    protected static final int TYPE_BUFFER_HIRAGANA;
    protected static final int TYPE_BUFFER_KANJI;
    protected static final int SELECTION_START_INDEX;
    protected static final int SELECTION_END_INDEX;
    protected static final char SPACE;
    protected final AbstractStateStrategyUtilizingAsiaStateHandler removeAllSymbolsPhrasesHandler = new AbstractCommomHiraganaState$1(this);
    protected final AbstractStateStrategyUtilizingAsiaStateHandler removeSymbolPhraseHandler = new AbstractCommomHiraganaState$2(this);
    protected final AbstractStateStrategyUtilizingAsiaStateHandler updateCandidateHandler = new AbstractCommomHiraganaState$3(this);
    protected final AbstractStateStrategyUtilizingAsiaStateHandler updateSpellingHandler = new AbstractCommomHiraganaState$4(this);
    private final AsiaStateHandlerRegistry asiaStateHandlerRegistry;
    protected final StringBuilder hiraganaBuffer = new StringBuilder(64);
    protected final StringBuilder kanjiBuffer = new StringBuilder(64);
    protected int hiraganaStartIndex = 0;
    protected int selectionEndIndex = 0;

    protected AbstractCommomHiraganaState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
        this.asiaStateHandlerRegistry = new AsiaStateHandlerRegistry(this);
    }

    protected final boolean isSelectedCandidateTooLong(String string) {
        if (string == null) {
            return false;
        }
        switch (this.speller.get_charEncoding()) {
            case 1: 
            case 2: {
                int n = StringUtil.getUtf8ByteLength(this.kanjiBuffer.toString());
                int n2 = StringUtil.getUtf8ByteLength(string);
                return n + n2 > this.speller.get_charMax();
            }
        }
        return this.getNumberOfCharacters(this.kanjiBuffer) + string.length() > this.speller.get_charMax();
    }

    protected final boolean isSelectionDecreasable() {
        String string = new StringBuffer().append(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex)).append(this.getCharacters(this.hiraganaBuffer)).toString();
        return string.substring(this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), Util.clamp(this.selectionEndIndex, this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex) + this.getNumberOfCharacters(this.hiraganaBuffer))).length() > 0;
    }

    protected final boolean isSelectionIncreasable() {
        String string = new StringBuffer().append(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex)).append(this.getCharacters(this.hiraganaBuffer)).toString();
        return string.substring(this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), Util.clamp(this.selectionEndIndex, this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex) + this.getNumberOfCharacters(this.hiraganaBuffer))).length() < this.getNumberOfCharacters(this.hiraganaBuffer);
    }

    protected final String adjustHiraganaSpelling(String string) {
        String string2 = this.getCharacters(this.hiraganaBuffer);
        String string3 = this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex).concat(string2);
        String string4 = null;
        try {
            string4 = string3.substring(this.selectionEndIndex);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            string4 = "";
        }
        if (string4.length() > 0) {
            string2 = string2.substring(0, string2.length() - string4.length());
        }
        this.setCharacters(this.hiraganaBuffer, string4);
        return string2;
    }

    @Override
    public final void armAsiaStateHandlers() {
        this.asiaStateHandlerRegistry.armAsiaStateHandlers();
    }

    protected final int[] calculateSelection(String string, String string2) {
        if (string == null || string2 == null) {
            return new int[]{0, 0};
        }
        int n = string.length();
        int n2 = Util.clamp(n + string2.length(), n, string.length() + string2.length());
        return new int[]{n, n2};
    }

    @Override
    public boolean candidateSelected(String string, int n) {
        String string2 = this.adjustHiraganaSpelling(string);
        this.insertCharacters(this.kanjiBuffer, this.hiraganaStartIndex, string);
        this.hiraganaStartIndex = this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex + string.length());
        int[] nArray = this.calculateSelection(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getCharacters(this.hiraganaBuffer));
        this.selectionEndIndex = nArray[1];
        this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("candidateSelected: Kanji: '").append(string).append("' Hiraganas replaced: '").append(string2).append("' Hiraganas left: '").append(this.getCharacters(this.hiraganaBuffer)).append("'").toString()).log();
        this.traceSelection(nArray, "candidateSelected");
        this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), this.getCharacters(this.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
        AsiaDatabase asiaDatabase = AsiaDatabase.getAsiaInputWrapper(this.speller.getAsiaInputInitializer());
        if (this.hasCharacters(this.hiraganaBuffer)) {
            asiaDatabase.setSymbols(this.getCharacters(this.hiraganaBuffer));
            this.updateCandidateHandler.doGetState();
        } else {
            asiaDatabase.removeAllSymbols();
            this.speller.setCandidates(null);
        }
        if (string.length() > 0) {
            this.fireSpellerEvent("keyPressed", string, 0, 0, 0);
            this.fireStringEvent("syllablesAvailable", string2);
        }
        return true;
    }

    @Override
    public boolean cursorLeftPressed() {
        if (!this.isSelectionDecreasable() && this.hasCharacters(this.hiraganaBuffer)) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("cursorLeftPressed: Min. Hiraganas selected").log();
            return true;
        }
        if (!this.hasCharacters(this.hiraganaBuffer)) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("cursorLeftPressed: None Hiragans to decrease selection").log();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.hiraganaStartIndex = this.speller.isSelectionDefined() && n == n3 ? Util.clamp(n2, 0, this.getNumberOfCharacters(this.kanjiBuffer)) : Util.clamp(--this.hiraganaStartIndex, 0, this.getNumberOfCharacters(this.kanjiBuffer));
            this.fireSpellerEvent("cursorPositionChanged", "", this.hiraganaStartIndex, n2, n3);
            return true;
        }
        this.decreaseSelectionEndIndex();
        AsiaDatabase asiaDatabase = AsiaDatabase.getAsiaInputWrapper(this.speller.getAsiaInputInitializer());
        asiaDatabase.removeSymbol();
        this.updateCandidateHandler.doGetState();
        int[] nArray = this.calculateSelection(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getCharacters(new StringBuilder[]{this.kanjiBuffer, this.hiraganaBuffer}, this.hiraganaStartIndex, this.selectionEndIndex));
        this.traceSelection(nArray, "cursorLeftPressed");
        this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), this.getCharacters(this.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
        return true;
    }

    @Override
    public boolean cursorPositionChanged(int n) {
        this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("cursorPositionChanged: '").append(n).append("'").toString()).log();
        return true;
    }

    @Override
    public boolean cursorRightPressed() {
        if (!this.isSelectionIncreasable() && this.hasCharacters(this.hiraganaBuffer)) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("cursorRightPressed: Max. Hiraganas selected").log();
            return true;
        }
        if (!this.hasCharacters(this.hiraganaBuffer)) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("cursorRightPressed: None Hiragans to increase selection").log();
            int n = this.speller.getCursorPosition();
            int n2 = this.speller.getSelectionStart();
            int n3 = this.speller.getSelectionEnd();
            this.hiraganaStartIndex = this.speller.isSelectionDefined() && n == n3 ? Util.clamp(n3, 0, this.getNumberOfCharacters(this.kanjiBuffer)) : Util.clamp(++this.hiraganaStartIndex, 0, this.getNumberOfCharacters(this.kanjiBuffer));
            this.fireSpellerEvent("cursorPositionChanged", "", this.hiraganaStartIndex, n2, n3);
            return true;
        }
        this.increaseSelectionEndIndex();
        AsiaDatabase asiaDatabase = AsiaDatabase.getAsiaInputWrapper(this.speller.getAsiaInputInitializer());
        String string = new StringBuffer().append(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex)).append(this.getCharacters(this.hiraganaBuffer)).toString();
        asiaDatabase.setSymbols(string.substring(this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.selectionEndIndex));
        this.updateCandidateHandler.doGetState();
        int[] nArray = this.calculateSelection(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getCharacters(new StringBuilder[]{this.kanjiBuffer, this.hiraganaBuffer}, this.hiraganaStartIndex, this.selectionEndIndex));
        this.traceSelection(nArray, "cursorRightPressed");
        this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), this.getCharacters(this.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
        return true;
    }

    protected final void decreaseSelectionEndIndex() {
        this.selectionEndIndex = Util.clamp(this.selectionEndIndex - 1, this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex) + this.getNumberOfCharacters(this.hiraganaBuffer));
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

    protected final void hideSelectedKanjis() {
        boolean bl;
        boolean bl2 = bl = this.speller.getSelectionEnd() <= this.getNumberOfCharacters(this.kanjiBuffer);
        if (bl) {
            String string = this.getCharacters(this.kanjiBuffer, this.speller.getSelectionStart());
            this.clearCharacters(this.kanjiBuffer);
            this.setCharacters(this.kanjiBuffer, string);
            this.hiraganaStartIndex = this.getNumberOfCharacters(this.kanjiBuffer);
        }
    }

    protected final void increaseSelectionEndIndex() {
        this.selectionEndIndex = Util.clamp(this.selectionEndIndex + 1, this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex) + this.getNumberOfCharacters(this.hiraganaBuffer));
    }

    @Override
    public void onDeInitState() {
        this.disarmAsiaStateHandlers();
        this.deregisterAllAsiaStateHandlers();
        super.onDeInitState();
    }

    @Override
    public void onEnterState(State state) {
        this.armAsiaStateHandlers();
        if (this.speller.get_lowerUpper() == 0) {
            this.stateContext.trace(SpellerLogger.getLogger()).append("Switching to upper case alphabet.").log();
            this.speller.set_lowerUpper(1);
        }
        if (this.isState(state, -1) || this.isState(state, 2) || this.isState(state, 4) || this.isState(state, 5)) {
            this.setCharacters(this.kanjiBuffer, this.speller.getEnteredText());
            this.setHiraganaStartIndex(this.speller.getCursorPosition());
        }
        this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("onEnterState: [characterBuffer: '").append(this.getCharacters()).append("', hiraganaBuffer: '").append(this.getCharacters(this.hiraganaBuffer)).append("', kanjiBuffer: '").append(this.getCharacters(this.kanjiBuffer)).append("', hiraganaStartIndex: '").append(this.hiraganaStartIndex).append("', selectionEndIndex: '").append(this.selectionEndIndex).append("']").toString()).log();
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.removeSymbolPhraseHandler.setNextStateHandler(this.updateSpellingHandler).setNextStateHandler(this.updateCandidateHandler);
        this.registerAsiaStateHandler(this.removeSymbolPhraseHandler);
        this.removeAllSymbolsPhrasesHandler.setNextStateHandler(this.updateSpellingHandler).setNextStateHandler(this.updateCandidateHandler);
        this.registerAsiaStateHandler(this.removeAllSymbolsPhrasesHandler);
    }

    @Override
    public void onLeaveState(State state) {
        if (this.hasCharacters()) {
            this.clearCharacters();
        }
        this.speller.updateSpellerButtons("", "");
        if (state instanceof AbstractCommomHiraganaState) {
            AbstractCommomHiraganaState abstractCommomHiraganaState = (AbstractCommomHiraganaState)state;
            if (this.hasCharacters(this.hiraganaBuffer)) {
                abstractCommomHiraganaState.transferBuffer(1, this.hiraganaBuffer);
                this.clearCharacters(this.hiraganaBuffer);
            }
            if (this.hasCharacters(this.kanjiBuffer)) {
                abstractCommomHiraganaState.transferBuffer(2, this.kanjiBuffer);
                this.clearCharacters(this.kanjiBuffer);
            }
            if (this.selectionEndIndex > 0) {
                abstractCommomHiraganaState.setSelectionEndIndex(this.selectionEndIndex);
                this.selectionEndIndex = 0;
            }
            if (this.hiraganaStartIndex > 0) {
                abstractCommomHiraganaState.setHiraganaStartIndex(this.hiraganaStartIndex);
                this.hiraganaStartIndex = 0;
            }
        } else if (this.hasCharacters(this.hiraganaBuffer)) {
            String string = this.getCharacters(this.hiraganaBuffer);
            this.clearCharacters(this.hiraganaBuffer);
            if (this.isSelectedCandidateTooLong(string)) {
                string = this.shortenSelectedCandidate(string);
            }
            this.insertCharacters(this.kanjiBuffer, this.hiraganaStartIndex, string);
            this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), "", this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex + string.length()), 0, 0);
            this.clearCharacters(this.kanjiBuffer);
            if (this.selectionEndIndex > 0) {
                this.selectionEndIndex = 0;
            }
            if (this.hiraganaStartIndex > 0) {
                this.hiraganaStartIndex = 0;
            }
            AsiaDatabase asiaDatabase = AsiaDatabase.getAsiaInputWrapper(this.speller.getAsiaInputInitializer());
            asiaDatabase.removeAllSymbols();
            this.speller.setCandidates(null);
            if (string.length() > 0) {
                this.fireSpellerEvent("keyPressed", string, 0, 0, 0);
            }
        } else {
            boolean bl;
            if (this.selectionEndIndex > 0) {
                this.selectionEndIndex = 0;
            }
            int n = this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex);
            if (this.hiraganaStartIndex > 0) {
                this.hiraganaStartIndex = 0;
            }
            boolean bl2 = bl = this.getNumberOfCharacters(this.kanjiBuffer) != n;
            if (this.hasCharacters(this.kanjiBuffer)) {
                this.clearCharacters(this.kanjiBuffer);
            }
            if (bl) {
                this.fireSpellerEvent("cursorPositionChanged", "", n, 0, 0);
            }
        }
        this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("onLeaveState: [characterBuffer: '").append(this.getCharacters()).append("', hiraganaBuffer: '").append(this.getCharacters(this.hiraganaBuffer)).append("', kanjiBuffer: '").append(this.getCharacters(this.kanjiBuffer)).append("', hiraganaStartIndex: '").append(this.hiraganaStartIndex).append("', selectionEndIndex: '").append(this.selectionEndIndex).append("']").toString()).log();
    }

    @Override
    public final void registerAsiaStateHandler(AbstractAsiaStateHandler abstractAsiaStateHandler) {
        this.asiaStateHandlerRegistry.registerAsiaStateHandler(abstractAsiaStateHandler);
    }

    protected final void setHiraganaStartIndex(int n) {
        this.hiraganaStartIndex = n;
    }

    protected final void setSelectionEndIndex(int n) {
        this.selectionEndIndex = n;
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        String string = spellerData.getEnteredText();
        int n = spellerData.getCursorPosition();
        this.setCharacters(this.kanjiBuffer, string);
        this.hiraganaStartIndex = n;
        int[] nArray = this.calculateSelection(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getCharacters(this.hiraganaBuffer));
        this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), this.getCharacters(this.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
    }

    protected final String shortenSelectedCandidate(String string) {
        String string2 = string;
        switch (this.speller.get_charEncoding()) {
            case 1: 
            case 2: {
                int n = this.speller.get_charMax() - StringUtil.getUtf8ByteLength(this.kanjiBuffer.toString());
                boolean bl = false;
                for (int i2 = string.length(); i2 > 0; --i2) {
                    String string3 = string.substring(0, i2);
                    int n2 = StringUtil.getUtf8ByteLength(string3);
                    if (n2 > n) continue;
                    string2 = string3;
                    bl = true;
                    break;
                }
                if (bl) break;
                string2 = "";
                break;
            }
            default: {
                int n = this.speller.get_charMax() - this.getNumberOfCharacters(this.kanjiBuffer);
                if (string == null || n < 0) break;
                string2 = string.substring(0, n);
                this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("shortenSelectedCandidate: Shortened Kanji '").append(string).append("' -> '").append(string2).append("'").toString()).log();
            }
        }
        return string2 != null ? string2 : "";
    }

    private void traceSelection(int[] nArray, String string) {
        StringBuilder stringBuilder = new StringBuilder(this.getCharacters(this.kanjiBuffer));
        stringBuilder.insert(this.hiraganaStartIndex, this.getCharacters(this.hiraganaBuffer));
        stringBuilder.insert(nArray[1], "}");
        stringBuilder.insert(nArray[0], "{");
        StringBuilder stringBuilder2 = new StringBuilder(string).append(": selection ");
        stringBuilder2.append("[start='").append(nArray[0]).append("', ");
        stringBuilder2.append("end='").append(nArray[1]).append("']: ");
        stringBuilder2.append("'").append(stringBuilder).append("'");
        this.stateContext.trace(SpellerLogger.getLogger()).append(stringBuilder2.toString()).log();
    }

    final void transferBuffer(int n, StringBuilder stringBuilder) {
        switch (n) {
            case 1: {
                this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("transferBuffer: hiraganaBuffer[").append(stringBuilder).append("]").toString()).log();
                this.setCharacters(this.hiraganaBuffer, stringBuilder.toString());
                break;
            }
            case 2: {
                this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("transferBuffer: kanjiBuffer [").append(stringBuilder).append("]").toString()).log();
                this.setCharacters(this.kanjiBuffer, stringBuilder.toString());
                break;
            }
        }
    }

    protected final void updateDiacriticsAndSpace() {
        String string = HiraganaFreeTextConverter.PRONUNCIATION_ELEMENTS;
        if (this.hasCharacters(this.hiraganaBuffer)) {
            string = HiraganaFreeTextConverter.getUnavailablePronunciationElementsForKana(this.getLastCharacter(this.hiraganaBuffer).charAt(0));
            string = new StringBuffer().append(string).append(' ').toString();
        }
        if (string != null && string.length() != 0) {
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("updateDiacriticsAndSpace: Disabling characters: '").append(string).append("'").toString()).log();
        }
        this.speller.updateSpellerButtons("", string);
    }
}

