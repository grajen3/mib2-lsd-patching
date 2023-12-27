/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public final class UpdateSpellingPhrasesCursorPositionHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private boolean updateBlankValues = true;
    private boolean updateSelectionIndices = true;

    public UpdateSpellingPhrasesCursorPositionHandler disableUpdateBlankValues() {
        this.updateBlankValues = false;
        return this;
    }

    public UpdateSpellingPhrasesCursorPositionHandler disableUpdateSelectionIndices() {
        this.updateSelectionIndices = false;
        return this;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(14, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        String string = asiaDatabaseState.getSpelling();
        String string2 = asiaDatabaseState.getPhrases();
        int n = asiaDatabaseState.getCursorPosition();
        if (this.updateSelectionIndices && (this.updateBlankValues || string.length() > 0 || string2.length() > 0 || n > 0)) {
            int n2 = n;
            int n3 = n2 + string.length();
            asiaSpellerModel.updateInputField(string2, string, n, n2, n3);
        } else if (this.updateBlankValues || string.length() > 0 || string2.length() > 0 || n > 0) {
            asiaSpellerModel.updateInputField(string2, string, n);
        }
        this.fireStringEvent("syllablesAvailable", string);
    }
}

