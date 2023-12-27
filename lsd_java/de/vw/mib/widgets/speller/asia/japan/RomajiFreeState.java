/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState$1;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState$2;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState$3;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeTextConverter;

final class RomajiFreeState
extends AbstractCommomHiraganaState {
    private final AbstractStateStrategyUtilizingAsiaStateHandler addSymbolHandler = new RomajiFreeState$1(this);
    private final AbstractAsiaStateHandler shiftSymbolHandler = new RomajiFreeState$2(this);
    private final AbstractStateStrategyUtilizingAsiaStateHandler updateSpellerButtonsHandler = new RomajiFreeState$3(this);
    private final String[] conversionResult = new String[2];

    public RomajiFreeState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    protected String getNextValidRomajis() {
        this.convertToHiragana(this.getCharacters());
        return this.conversionResult[0];
    }

    @Override
    public boolean cursorLeftPressed() {
        if (this.hasCharacters()) {
            return true;
        }
        return super.cursorLeftPressed();
    }

    @Override
    public boolean candidateSelected(String string, int n) {
        if (this.hasCharacters()) {
            this.clearCharacters();
        }
        return super.candidateSelected(string, n);
    }

    @Override
    public boolean cursorRightPressed() {
        if (this.hasCharacters()) {
            return true;
        }
        return super.cursorRightPressed();
    }

    protected String convertToHiragana(String string) {
        RomajiFreeTextConverter.convertRomajis(string, this.conversionResult);
        return this.conversionResult[1];
    }

    @Override
    public boolean deleted() {
        String string;
        String string2 = string = this.hasCharacters() ? this.getLastCharacter() : this.getLastCharacter(this.hiraganaBuffer);
        if (this.deleteLastCharacter()) {
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("deleted: Romaji: '").append(string).append("'").toString()).log();
            int n = this.getNumberOfCharacters(this.kanjiBuffer, this.hiraganaStartIndex);
            this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), new StringBuffer().append(this.getCharacters(this.hiraganaBuffer)).append(this.getCharacters()).toString(), n);
            String string3 = this.getNextValidRomajis();
            this.speller.updateSpellerButtons(string3, "");
        } else {
            this.removeSymbolPhraseHandler.doGetState();
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("deleted: Hiragana: '").append(string).append("'").toString()).log();
        }
        return true;
    }

    @Override
    public boolean longDeleted() {
        if (this.hasCharacters()) {
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("longDeleted: Romajis: '").append(this.getCharacters()).append("'").toString()).log();
            this.clearCharacters();
        }
        this.removeAllSymbolsPhrasesHandler.doGetState();
        return true;
    }

    @Override
    public boolean keyPressed() {
        char c2;
        if (this.speller.isCharMaxReached()) {
            return true;
        }
        String string = this.stateContext.getLastEnteredCharacter();
        if (string != null && string.length() > 0 && (Character.isSpaceChar(c2 = string.charAt(0)) || !Character.isLetter(c2) || Character.isDigit(c2))) {
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("keyPressed: '").append(c2).append("' SPACE, SYMBOL or DIGIT pressed, switch to INTERMEDIATE ROMAJI (FREE)").toString()).log();
            this.setStateId(5);
            this.stateContext.fire_keyPressed();
            return true;
        }
        this.addCharacter(string);
        this.addSymbolHandler.doGetState();
        return true;
    }

    @Override
    public boolean keyLongPressed() {
        return true;
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        this.updateSpellerButtonsHandler.doGetStateSingle();
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.addSymbolHandler.setNextStateHandler(this.updateCandidateHandler).setNextStateHandler(this.updateSpellerButtonsHandler);
        this.registerAsiaStateHandler(this.addSymbolHandler);
        this.shiftSymbolHandler.setNextStateHandler(this.updateSpellingHandler);
        this.registerAsiaStateHandler(this.shiftSymbolHandler);
        this.removeSymbolPhraseHandler.appendNextStateHandler(this.updateSpellerButtonsHandler);
        this.removeAllSymbolsPhrasesHandler.appendNextStateHandler(this.updateSpellerButtonsHandler);
    }

    @Override
    public void onLeaveState(State state) {
        if (this.hasCharacters()) {
            this.clearCharacters();
            int[] nArray = this.calculateSelection(this.getCharacters(this.kanjiBuffer, this.hiraganaStartIndex), this.getCharacters(new StringBuilder[]{this.kanjiBuffer, this.hiraganaBuffer}, this.hiraganaStartIndex, this.selectionEndIndex));
            this.speller.updateInputField(this.getCharacters(this.kanjiBuffer), this.getCharacters(this.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
        }
        super.onLeaveState(state);
    }

    @Override
    public boolean shiftPressed() {
        this.shiftSymbolHandler.doGetState();
        return true;
    }

    @Override
    public String toString() {
        return "Romaji (Free)";
    }
}

