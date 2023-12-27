/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractDistinguishableStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class SetPredictionContextHandler
extends AbstractDistinguishableStateHandler {
    private String context = "";

    public SetPredictionContextHandler(int n) {
        super(n);
    }

    public void setContext(String string) {
        this.context = string;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        switch (this.getCaseToHandle()) {
            case 0: {
                asiaStateProxy.getState(64, this);
                break;
            }
            default: {
                asiaStateProxy.getState(2050, this);
            }
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setContext(null);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        switch (this.getCaseToHandle()) {
            case 0: {
                if (this.context == null || this.context.length() == 0) {
                    asiaSpellerModel.setPrediction(null);
                }
                this.handleSetPredictionContext(this.context, asiaDatabase);
                break;
            }
            default: {
                if (asiaDatabaseState.hasSpelling()) break;
                String string = asiaDatabaseState.getPredictionContext();
                this.handleSetPredictionContext(string, asiaDatabase);
            }
        }
    }

    private void handleSetPredictionContext(String string, AsiaDatabase asiaDatabase) {
        if (string == null || string.length() == 0) {
            asiaDatabase.clearPredictionContext();
        } else {
            asiaDatabase.setPredictionContext(string);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[context='").append(this.context).append("']").toString();
    }
}

