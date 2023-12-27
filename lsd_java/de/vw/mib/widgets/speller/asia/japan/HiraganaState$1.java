/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.HiraganaState;

class HiraganaState$1
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ HiraganaState this$0;

    HiraganaState$1(HiraganaState hiraganaState) {
        this.this$0 = hiraganaState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        char c2 = this.this$0.hasCharacters() ? this.this$0.getLastCharacter().charAt(0) : (char)'\u0000';
        boolean bl = HiraganaFreeTextConverter.isPronunciationElement(c2);
        if (bl && this.this$0.getNumberOfCharacters() == 1 && this.this$0.hasCharacters(this.this$0.hiraganaBuffer)) {
            this.this$0.clearCharacters();
            this.this$0.addCharacter(this.this$0.getLastCharacter(this.this$0.hiraganaBuffer));
            this.this$0.addCharacter(c2);
        }
        if (bl && this.this$0.getNumberOfCharacters() > 1) {
            char c3 = HiraganaFreeTextConverter.getKanaWithPronunciationElement(this.this$0.getCharacters().charAt(0), c2);
            if (LOGGER.isTraceEnabled(64)) {
                LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": Building diacritic Hiragana: '").append(this.this$0.getCharacters().charAt(0)).append(c2).append("'->'").append(c3).append("'").toString()).log();
            }
            c2 = c3;
            this.this$0.clearCharacters();
            this.this$0.deleteLastCharacter(this.this$0.hiraganaBuffer);
        }
        if (this.this$0.getNumberOfCharacters() >= 2) {
            this.this$0.clearCharacters();
            this.this$0.addCharacter(c2);
        }
        if (!this.this$0.hasCharacters(this.this$0.hiraganaBuffer) && this.this$0.hasCharacters(this.this$0.kanjiBuffer) && this.getState().getWidget().isSelectionDefined()) {
            this.this$0.hideSelectedKanjis();
        }
        asiaDatabase.setSymbols(new StringBuffer().append(this.this$0.getCharacters(this.this$0.hiraganaBuffer)).append(c2).toString());
        if (LOGGER.isTraceEnabled(64)) {
            LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": Added Hiragana: '").append(c2).append("'").toString()).log();
        }
        asiaStateProxy.getState(2, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        this.this$0.setCharacters(this.this$0.hiraganaBuffer, asiaDatabaseState.getSpelling());
        int[] nArray = this.this$0.calculateSelection(this.this$0.getCharacters(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex), this.this$0.getCharacters(this.this$0.hiraganaBuffer));
        this.this$0.selectionEndIndex = nArray[1];
        this.getState().getWidget().updateInputField(this.this$0.getCharacters(this.this$0.kanjiBuffer), this.this$0.getCharacters(this.this$0.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
        this.this$0.updateDiacriticsAndSpace();
    }
}

