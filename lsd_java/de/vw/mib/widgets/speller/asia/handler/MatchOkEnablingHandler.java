/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class MatchOkEnablingHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(64, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        int n = asiaSpellerModel.get_matchCount();
        String string = asiaSpellerModel.getEnteredText();
        asiaSpellerModel.set_okEnabled(n > 0 && string.length() > 0);
    }
}

