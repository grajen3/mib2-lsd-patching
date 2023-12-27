/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.korea.JamoFreetextState;
import de.vw.mib.widgets.speller.asia.korea.JamoMatchState;

public final class KoreaStateMachine
extends AbstractStateMachine {
    private static final int STATE_BASE;
    static final int STATE_JAMO_FREETEXT;
    static final int STATE_JAMO_MATCH;
    private static final int STATE_COUNT_KOREASTATEMACHINE;

    public KoreaStateMachine(AsiaSpellerController asiaSpellerController, AsiaSpellerModel asiaSpellerModel) {
        super(asiaSpellerController, asiaSpellerModel);
    }

    @Override
    protected State[] defineStates() {
        State[] stateArray = new State[]{new JamoFreetextState(this), new JamoMatchState(this)};
        return stateArray;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            default: 
        }
        super.propertyChanged(widgetModel, n);
    }

    @Override
    protected void resolveState(AsiaSpellerModel asiaSpellerModel) {
        if (asiaSpellerModel.isMode(1)) {
            if (asiaSpellerModel.isInJamoAlphabet()) {
                this.setStateId(0);
                return;
            }
        } else if (asiaSpellerModel.isMode(0) && asiaSpellerModel.isInJamoAlphabet()) {
            this.setStateId(1);
            return;
        }
        super.resolveState(asiaSpellerModel);
    }
}

