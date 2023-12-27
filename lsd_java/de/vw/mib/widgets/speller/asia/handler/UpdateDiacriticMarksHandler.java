/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;

public final class UpdateDiacriticMarksHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(2, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        String string = HiraganaFreeTextConverter.PRONUNCIATION_ELEMENTS;
        if (asiaDatabaseState.hasSpelling()) {
            String string2 = asiaDatabaseState.getSpelling();
            char c2 = string2.charAt(string2.length() - 1);
            string = HiraganaFreeTextConverter.getUnavailablePronunciationElementsForKana(c2);
        }
        asiaSpellerModel.updateSpellerButtons("", string);
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (n) {
            case 0: {
                LOGGER.warn(64).append(super.getClass().getName()).append(": ERROR (").append(n).append(") ").append(AsiaStatusText.getText(n)).append(" -> Unable to update diacritic marks!").log();
                this.getState().getWidget().updateSpellerButtons("", HiraganaFreeTextConverter.PRONUNCIATION_ELEMENTS);
                this.doGetNextState();
                break;
            }
            default: {
                super.onStateFaultyReceived(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
            }
        }
    }
}

