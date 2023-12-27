/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.RemoveSymbolPhraseHandler;

public final class MatchRemoveSymbolPhraseHandler
extends RemoveSymbolPhraseHandler {
    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        super.onStateSuccessfullyReceived(asiaDatabaseState, asiaDatabase);
        if (!asiaDatabaseState.hasSpelling()) {
            asiaSpellerModel.set_okEnabled(false);
            this.skipDoGetNextState();
        }
    }
}

