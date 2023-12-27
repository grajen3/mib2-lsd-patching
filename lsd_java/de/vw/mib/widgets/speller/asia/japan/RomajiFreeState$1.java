/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState;

class RomajiFreeState$1
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ RomajiFreeState this$0;

    RomajiFreeState$1(RomajiFreeState romajiFreeState) {
        this.this$0 = romajiFreeState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        String string = this.this$0.convertToHiragana(this.this$0.getCharacters());
        if (LOGGER.isTraceEnabled(64)) {
            LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": Adding Romaji: '").append(this.this$0.getLastCharacter()).append("'").toString()).log();
        }
        if (string != null) {
            if (LOGGER.isTraceEnabled(64)) {
                LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": Converted Romajis: '").append(this.this$0.getCharacters()).append("'->'").append(string).append("'").toString()).log();
            }
            if (!this.this$0.hasCharacters(this.this$0.hiraganaBuffer) && this.this$0.hasCharacters(this.this$0.kanjiBuffer) && asiaSpellerModel.isSelectionDefined()) {
                this.this$0.hideSelectedKanjis();
            }
            asiaDatabase.setSymbols(new StringBuffer().append(this.this$0.getCharacters(this.this$0.hiraganaBuffer)).append(string).toString());
            this.this$0.clearCharacters();
            asiaStateProxy.getState(2, this);
        } else {
            if (!this.this$0.hasCharacters(this.this$0.hiraganaBuffer) && this.this$0.hasCharacters(this.this$0.kanjiBuffer) && asiaSpellerModel.isSelectionDefined()) {
                this.this$0.hideSelectedKanjis();
            }
            int[] nArray = this.this$0.calculateSelection(this.this$0.getCharacters(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex), this.this$0.getCharacters(this.this$0.hiraganaBuffer));
            asiaSpellerModel.updateInputField(this.this$0.getCharacters(this.this$0.kanjiBuffer), new StringBuffer().append(this.this$0.getCharacters(this.this$0.hiraganaBuffer)).append(this.this$0.getCharacters()).toString(), nArray[0], nArray[0], nArray[1]);
            this.doGetNextState();
        }
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        this.this$0.setCharacters(this.this$0.hiraganaBuffer, asiaDatabaseState.getSpelling());
        int[] nArray = this.this$0.calculateSelection(this.this$0.getCharacters(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex), this.this$0.getCharacters(this.this$0.hiraganaBuffer));
        this.this$0.selectionEndIndex = nArray[1];
        this.getState().getWidget().updateInputField(this.this$0.getCharacters(this.this$0.kanjiBuffer), this.this$0.getCharacters(this.this$0.hiraganaBuffer), nArray[0], nArray[0], nArray[1]);
    }
}

