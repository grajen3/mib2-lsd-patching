/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.RomajiFreeState;

class RomajiFreeState$2
extends AbstractAsiaStateHandler {
    private final /* synthetic */ RomajiFreeState this$0;

    RomajiFreeState$2(RomajiFreeState romajiFreeState) {
        this.this$0 = romajiFreeState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        char c2;
        boolean bl;
        if (!this.this$0.hasCharacters() && (bl = HiraganaFreeTextConverter.isSmallKanaAvailable(c2 = this.this$0.hasCharacters(this.this$0.hiraganaBuffer) ? this.this$0.getLastCharacter(this.this$0.hiraganaBuffer).charAt(0) : (char)'\u0000'))) {
            this.this$0.deleteLastCharacter(this.this$0.hiraganaBuffer);
            this.this$0.addCharacter(this.this$0.hiraganaBuffer, HiraganaFreeTextConverter.getSmallKanaForKana(c2));
            asiaDatabase.setSymbols(this.this$0.getCharacters(this.this$0.hiraganaBuffer));
            this.doGetNextState();
        }
    }
}

