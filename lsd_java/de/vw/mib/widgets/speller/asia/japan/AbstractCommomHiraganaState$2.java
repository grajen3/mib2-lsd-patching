/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState;

class AbstractCommomHiraganaState$2
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ AbstractCommomHiraganaState this$0;

    AbstractCommomHiraganaState$2(AbstractCommomHiraganaState abstractCommomHiraganaState) {
        this.this$0 = abstractCommomHiraganaState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaDatabase.setSymbols(this.this$0.getCharacters(this.this$0.hiraganaBuffer));
        asiaStateProxy.getState(2, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        String string = asiaDatabaseState.getSpelling();
        if (string != null && string.length() > 0) {
            asiaDatabase.removeSymbol();
            if (LOGGER.isTraceEnabled(64)) {
                LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": deleted: '").append(string.substring(string.length() - 1)).append("'").toString()).log();
            }
        } else if (this.this$0.hasCharacters(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex)) {
            String string2 = this.this$0.getLastCharacter(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex);
            this.this$0.deleteLastCharacter(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex);
            this.this$0.hiraganaStartIndex = Util.clamp(--this.this$0.hiraganaStartIndex, 0, this.this$0.getNumberOfCharacters(this.this$0.kanjiBuffer));
            if (LOGGER.isTraceEnabled(64)) {
                LOGGER.trace(64).append(super.getClass().getName()).append(new StringBuffer().append(": deleted: '").append(string2).append("'").toString()).log();
            }
            this.fireSpellerEvent("deleted", "", this.this$0.getNumberOfCharacters(this.this$0.kanjiBuffer, this.this$0.hiraganaStartIndex), 0, 0);
        }
    }
}

