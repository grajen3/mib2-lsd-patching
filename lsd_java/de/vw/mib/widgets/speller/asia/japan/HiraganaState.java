/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState;
import de.vw.mib.widgets.speller.asia.japan.Hiragana;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.HiraganaState$1;
import de.vw.mib.widgets.speller.asia.japan.JapanStateMachine;
import de.vw.mib.widgets.speller.asia.japan.Katakana;

final class HiraganaState
extends AbstractCommomHiraganaState {
    private AbstractStateStrategyUtilizingAsiaStateHandler addSymbolHandler = new HiraganaState$1(this);

    public HiraganaState(JapanStateMachine japanStateMachine) {
        super(japanStateMachine);
    }

    @Override
    public boolean deleted() {
        if (this.hasCharacters()) {
            this.deleteLastCharacter();
        }
        this.removeSymbolPhraseHandler.doGetState();
        return true;
    }

    @Override
    public boolean longDeleted() {
        if (this.hasCharacters()) {
            this.clearCharacters();
        }
        this.removeAllSymbolsPhrasesHandler.doGetState();
        return true;
    }

    @Override
    public boolean keyPressed() {
        if (this.speller.isCharMaxReached()) {
            return true;
        }
        String string = this.stateContext.getLastEnteredCharacter();
        if (string != null && string.length() > 0) {
            char c2 = string.charAt(0);
            if (Hiragana.isHiragana(c2) || Katakana.isKatakana(c2)) {
                this.addCharacter(c2);
                this.addSymbolHandler.doGetState();
                return true;
            }
            if (Character.isSpaceChar(c2)) {
                if (this.hasCharacters(this.hiraganaBuffer)) {
                    return true;
                }
                this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("keyPressed: '").append(c2).append("' SPACE pressed, switch to INTERMEDIATE HIRAGANA").toString()).log();
                this.setStateId(4);
                this.stateContext.fire_keyPressed();
                return true;
            }
            this.setStateId(2);
            this.stateContext.fire_keyPressed();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyLongPressed() {
        return true;
    }

    @Override
    public void onEnterState(State state) {
        super.onEnterState(state);
        if (this.hasCharacters(this.hiraganaBuffer)) {
            this.setCharacters(this.getLastCharacter(this.hiraganaBuffer));
        }
        this.updateDiacriticsAndSpace();
    }

    @Override
    public void onInitState() {
        super.onInitState();
        this.addSymbolHandler.setNextStateHandler(this.updateCandidateHandler);
        this.registerAsiaStateHandler(this.addSymbolHandler);
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        super.setSpellerData(spellerData);
        this.updateDiacriticsAndSpace();
    }

    @Override
    public boolean shiftPressed() {
        char c2 = this.hasCharacters(this.hiraganaBuffer) ? this.getLastCharacter(this.hiraganaBuffer).charAt(0) : (char)'\u0000';
        boolean bl = HiraganaFreeTextConverter.isSmallKanaAvailable(c2);
        if (bl) {
            this.clearCharacters();
            String string = this.getLastCharacter(this.hiraganaBuffer);
            char c3 = HiraganaFreeTextConverter.getSmallKanaForKana(c2);
            this.stateContext.trace(SpellerLogger.getLogger()).append(new StringBuffer().append("shiftPressed: Shifting Hiragana: '").append(string).append("'->'").append(c3).append("'").toString()).log();
            this.deleteLastCharacter(this.hiraganaBuffer);
            this.addCharacter(c3);
            this.addSymbolHandler.doGetState();
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hiragana";
    }
}

