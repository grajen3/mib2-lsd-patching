/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractHandlerStrategy;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

final class TransferUnconvertedStrategy
extends AbstractHandlerStrategy {
    public TransferUnconvertedStrategy(AbstractStateStrategyUtilizingAsiaStateHandler abstractStateStrategyUtilizingAsiaStateHandler) {
        super(abstractStateStrategyUtilizingAsiaStateHandler);
    }

    @Override
    public void doGet(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(14, this.handler);
    }

    @Override
    public void doHandle(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = ((AbstractStateStrategyUtilizingAsiaStateHandler)this.handler).getState().getWidget();
        int n = asiaSpellerModel.get_charMax() - asiaDatabaseState.getNumberOfPhrases();
        if (n > 0 && asiaDatabaseState.hasSpelling()) {
            String string = asiaDatabaseState.getSpelling();
            if (n < asiaDatabaseState.getNumberOfSpelling()) {
                string = string.substring(0, Math.min(n, asiaDatabaseState.getNumberOfSpelling()));
            }
            asiaDatabase.addPhrase(string);
            asiaDatabase.removeAllSymbols();
            asiaSpellerModel.setCandidates(null);
            int n2 = asiaDatabaseState.getCursorPosition();
            String string2 = string;
            if (asiaDatabaseState.hasPhrases()) {
                string2 = new StringBuilder(asiaDatabaseState.getPhrases()).insert(n2, string).toString();
            }
            asiaSpellerModel.updateInputField(string2, "", n2 + asiaDatabaseState.getNumberOfSpelling(), 0, 0);
            ((AbstractStateStrategyUtilizingAsiaStateHandler)this.handler).getState().fireSpellerEvent("keyPressed", string, n2, 0, 0);
        }
    }
}

