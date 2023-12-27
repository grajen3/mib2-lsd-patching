/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolHandler;
import de.vw.mib.widgets.speller.asia.handler.AddSymbolStrategy;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;

public class AddSymbolHiraganaStrategy
extends AddSymbolStrategy {
    private String symbols;

    public AddSymbolHiraganaStrategy() {
        this(null);
    }

    public AddSymbolHiraganaStrategy(AddSymbolHandler addSymbolHandler) {
        super(addSymbolHandler);
    }

    @Override
    public void doGet(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        this.symbols = ((AddSymbolHandler)this.handler).getSymbols();
        if (this.symbols != null && this.symbols.length() == 1 && HiraganaFreeTextConverter.isPronunciationElement(this.symbols.charAt(0))) {
            asiaStateProxy.getState(2, this.handler);
        } else {
            this.symbols = null;
            super.doGet(asiaStateProxy, intObjectMap, asiaDatabase);
        }
    }

    @Override
    public void doHandle(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (asiaDatabaseState.hasSpelling()) {
            char c2 = asiaDatabaseState.getSpelling().charAt(asiaDatabaseState.getSpelling().length() - 1);
            char c3 = HiraganaFreeTextConverter.getKanaWithPronunciationElement(c2, this.symbols.charAt(0));
            this.symbols = null;
            asiaDatabase.removeSymbol();
            asiaDatabase.addSymbol(c3);
        }
    }
}

