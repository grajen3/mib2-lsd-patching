/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreetextConversionState;
import de.vw.mib.widgets.speller.asia.japan.RomajiMatchState;

public final class JapanStateMachine
extends AbstractStateMachine {
    private static final int STATE_BASE;
    static final int STATE_HIRAGANA;
    static final int STATE_ROMAJI_MATCH;
    static final int STATE_LATIN;
    static final int STATE_ROMAJI_FREE;
    static final int STATE_INTERMEDIATE_HIRAGANA;
    static final int STATE_INTERMEDIATE_ROMAJI_FREE;
    private static final int STATE_COUNT_JAPANSTATEMACHINE;

    public JapanStateMachine(AsiaSpellerController asiaSpellerController, AsiaSpellerModel asiaSpellerModel) {
        super(asiaSpellerController, asiaSpellerModel);
    }

    @Override
    protected State[] defineStates() {
        State[] stateArray = new State[]{new HiraganaFreetextConversionState(this), new RomajiMatchState(this)};
        return stateArray;
    }

    @Override
    protected void resolveState(AsiaSpellerModel asiaSpellerModel) {
        if (asiaSpellerModel.isMode(1)) {
            if (asiaSpellerModel.is_asiaConversionEnabled() && (asiaSpellerModel.isInHiraganaAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && asiaSpellerModel.isInLatinAlphabet() && asiaSpellerModel.isSpellerLanguage("ja_JP"))) {
                this.setStateId(0);
                return;
            }
        } else if (asiaSpellerModel.isMode(0) && asiaSpellerModel.isInRomajiAlphabet()) {
            this.setStateId(1);
            return;
        }
        super.resolveState(asiaSpellerModel);
    }
}

