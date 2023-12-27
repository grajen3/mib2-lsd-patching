/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public class CandidateSelectedHandler
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private String selectedCandidate;

    public final void setSelectedCandidate(String string) {
        this.selectedCandidate = string;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(14, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        AsiaSpellerModel asiaSpellerModel = this.getState().getWidget();
        String string = asiaDatabaseState.getPhrases() != null ? asiaDatabaseState.getPhrases() : "";
        String string2 = this.selectedCandidate != null ? this.selectedCandidate : "";
        int n = string.length();
        int n2 = string2.length();
        int n3 = asiaDatabaseState.getCursorPosition();
        while (!asiaSpellerModel.isInCharBounds(string, asiaSpellerModel.get_charMax())) {
            asiaDatabase.removePhrase();
            string = string.substring(0, --n);
            --n3;
            if (--n2 != 0) continue;
        }
        int n4 = asiaDatabaseState.hasSpelling() ? n3 : 0;
        int n5 = asiaDatabaseState.hasSpelling() ? n4 + asiaDatabaseState.getNumberOfSpelling() : 0;
        asiaSpellerModel.updateInputField(string, asiaDatabaseState.getSpelling(), n3, n4, n5);
        if (n2 > 0) {
            if (n2 < string2.length()) {
                string2 = string2.substring(0, n2);
            }
            this.fireSpellerEvent("keyPressed", string2, n3 -= n2, 0, 0);
        }
    }
}

