/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public class RemoveSymbolPhraseHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(14, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        if (asiaDatabaseState.hasSpelling()) {
            asiaDatabase.removeSymbol();
        } else if (asiaDatabaseState.hasPhrases()) {
            asiaDatabase.removePhrase();
            int n = asiaDatabaseState.getCursorPosition();
            this.fireSpellerEvent("deleted", "", n, 0, 0);
        } else {
            int n = asiaDatabaseState.getCursorPosition();
            this.fireSpellerEvent("deleted", "", n, 0, 0);
            this.skipDoGetNextState();
        }
    }
}

