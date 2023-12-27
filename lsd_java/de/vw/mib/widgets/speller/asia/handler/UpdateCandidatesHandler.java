/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class UpdateCandidatesHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(1, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        SpellerFrameworkFacade.getFacade(asiaSpellerModel).filter(asiaDatabaseState.getCandidates());
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (n) {
            case 0: {
                AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
                asiaSpellerModel.setCandidates(null);
                LOGGER.warn(64).append(super.getClass().getName()).append(": ERROR (").append(n).append(") ").append(AsiaStatusText.getText(n)).append(" -> Unable to determine candidates!").log();
                break;
            }
            default: {
                super.onStateFaultyReceived(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
            }
        }
    }
}

