/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;
import de.vw.mib.widgets.speller.asia.handler.AbstractDistinguishableStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class UpdatePredictionHandler
extends AbstractDistinguishableStateHandler {
    public UpdatePredictionHandler(int n) {
        super(n);
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(1, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        String[] stringArray = asiaDatabaseState.getCandidates();
        block0 : switch (this.getCaseToHandle()) {
            case 0: {
                asiaSpellerModel.setPrediction(stringArray);
                break;
            }
            case 1: {
                switch (asiaSpellerModel.get_filterId()) {
                    case -1: {
                        asiaSpellerModel.setCandidates(stringArray);
                        break block0;
                    }
                }
                SpellerFrameworkFacade.getFacade(asiaSpellerModel).filter(stringArray);
                break;
            }
        }
    }

    @Override
    protected void onStateFaultyReceived(int n, AsiaDatabaseState asiaDatabaseState, AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (n) {
            case 0: {
                AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
                switch (this.getCaseToHandle()) {
                    case 0: {
                        asiaSpellerModel.setPrediction(null);
                        break;
                    }
                    case 1: {
                        asiaSpellerModel.setCandidates(null);
                        break;
                    }
                }
                LOGGER.warn(64).append(super.getClass().getName()).append(": ERROR (").append(n).append(") ").append(AsiaStatusText.getText(n)).append(" -> Unable to determine prediction!").log();
                break;
            }
            default: {
                super.onStateFaultyReceived(n, asiaDatabaseState, asiaStateProxy, asiaDatabase);
            }
        }
    }
}

