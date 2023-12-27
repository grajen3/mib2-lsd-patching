/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState;

class AbstractCommomHiraganaState$4
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ AbstractCommomHiraganaState this$0;

    AbstractCommomHiraganaState$4(AbstractCommomHiraganaState abstractCommomHiraganaState) {
        this.this$0 = abstractCommomHiraganaState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
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

