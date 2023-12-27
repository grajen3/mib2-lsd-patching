/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.AsiaSpeller$AsiaOutEventListener;
import de.vw.mib.widgets.AsiaSpeller$PredictionListItemControl;
import de.vw.mib.widgets.controller.AsiaSpellerController;

final class AsiaSpeller$PredictionSelectedHandler
extends AsiaSpeller$AsiaOutEventListener {
    private final AsiaSpeller$PredictionListItemControl predictionListItemControl;
    private final /* synthetic */ AsiaSpeller this$0;

    public AsiaSpeller$PredictionSelectedHandler(AsiaSpeller asiaSpeller, AsiaSpeller$PredictionListItemControl asiaSpeller$PredictionListItemControl) {
        this.this$0 = asiaSpeller;
        super(asiaSpeller, asiaSpeller$PredictionListItemControl);
        this.predictionListItemControl = asiaSpeller$PredictionListItemControl;
    }

    @Override
    protected void onCharacterSelected(AsiaSpellerController asiaSpellerController, String string, int n) {
        switch (this.predictionListItemControl.getContentType()) {
            case 1: {
                asiaSpellerController.onPredictionSelected(string, n);
                break;
            }
            case 2: {
                asiaSpellerController.onRecognizedCharacterSelected(string, n);
                break;
            }
            case 3: {
                asiaSpellerController.onNextValidCharacterSelected(string, n);
                break;
            }
        }
    }
}

