/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;

public class ToggleSymbolHiraganaHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    public ToggleSymbolHiraganaHandler() {
    }

    public ToggleSymbolHiraganaHandler(State state) {
        super(state);
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(2, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (asiaDatabaseState.hasSpelling()) {
            String string = asiaDatabaseState.getSpelling();
            char c2 = string.charAt(string.length() - 1);
            if (HiraganaFreeTextConverter.isSmallKanaAvailable(c2)) {
                char c3 = HiraganaFreeTextConverter.getSmallKanaForKana(c2);
                asiaDatabase.removeSymbol();
                asiaDatabase.addSymbol(c3);
            } else if (HiraganaFreeTextConverter.isLargeKanaAvailable(c2)) {
                char c4 = HiraganaFreeTextConverter.getLargeKanaForKana(c2);
                asiaDatabase.removeSymbol();
                asiaDatabase.addSymbol(c4);
            } else {
                this.skipDoGetNextState();
            }
        }
    }
}

