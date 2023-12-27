/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AbstractStateMachine;
import de.vw.mib.widgets.speller.asia.State;
import de.vw.mib.widgets.speller.asia.china.HWRFreetextNoPredictionState;
import de.vw.mib.widgets.speller.asia.china.HWRFreetextNumberState;
import de.vw.mib.widgets.speller.asia.china.HWRFreetextState;
import de.vw.mib.widgets.speller.asia.china.HWRFreetextWithPreviewLineState;
import de.vw.mib.widgets.speller.asia.china.HWRMatchNVCState;
import de.vw.mib.widgets.speller.asia.china.HWRMatchNumberState;
import de.vw.mib.widgets.speller.asia.china.HWRMatchState;
import de.vw.mib.widgets.speller.asia.china.PinyinFreetextConversionState;
import de.vw.mib.widgets.speller.asia.china.PinyinFreetextMatchConversionState;
import de.vw.mib.widgets.speller.asia.china.UserDefinedEntryAndWordSegmentationOnlyState;
import de.vw.mib.widgets.speller.asia.china.ZhuyinFreetextConversionState;

public final class ChinaStateMachine
extends AbstractStateMachine {
    private static final int STATE_BASE;
    static final int STATE_HWR_FREETEXT;
    static final int STATE_HWR_FREETEXT_NO_PREDICTION;
    static final int STATE_HWR_FREETEXT_NUMBER;
    static final int STATE_HWR_FREETEXT_WITH_PREVIEW_LINE;
    static final int STATE_HWR_MATCH;
    static final int STATE_HWR_MATCH_NUMBER;
    static final int STATE_HWR_MATCH_NVC;
    static final int STATE_PINYIN_FREETEXT_CONVERSION;
    static final int STATE_PINYIN_FREETEXT_MATCH_CONVERSION;
    static final int STATE_ZHUYIN_FREETEXT_CONVERSION;
    static final int STATE_USERDEFINEDENTRY_AND_WORDSEGMENTATION_ONLY;
    private static final int STATE_COUNT_CHINASTATEMACHINE;

    public ChinaStateMachine(AsiaSpellerController asiaSpellerController, AsiaSpellerModel asiaSpellerModel) {
        super(asiaSpellerController, asiaSpellerModel);
    }

    @Override
    protected State[] defineStates() {
        State[] stateArray = new State[]{new HWRFreetextState(this), new HWRFreetextNoPredictionState(this), new HWRFreetextNumberState(this), new HWRFreetextWithPreviewLineState(this), new HWRMatchState(this), new HWRMatchNumberState(this), new HWRMatchNVCState(this), new PinyinFreetextConversionState(this), new PinyinFreetextMatchConversionState(this), new ZhuyinFreetextConversionState(this), new UserDefinedEntryAndWordSegmentationOnlyState(this)};
        return stateArray;
    }

    private boolean isHWRNumberMode(int n) {
        switch (n) {
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void resolveState(AsiaSpellerModel asiaSpellerModel) {
        block19: {
            if (asiaSpellerModel.isMode(1)) {
                if (asiaSpellerModel.is_asiaConversionEnabled()) {
                    if (asiaSpellerModel.is_hwrEnabled() && asiaSpellerModel.isInHwrAlphabet()) {
                        if (this.resolveStateHWR(asiaSpellerModel)) {
                            return;
                        }
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                    if (asiaSpellerModel.isInPinyinAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && asiaSpellerModel.isInLatinAlphabet() && asiaSpellerModel.isSpellerLanguage("zh_CN")) {
                        this.setStateId(7);
                        return;
                    }
                    if (asiaSpellerModel.isInZhuyinAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && asiaSpellerModel.isInLatinAlphabet() && asiaSpellerModel.isSpellerLanguage("zh_TW")) {
                        this.setStateId(9);
                        return;
                    }
                    if (asiaSpellerModel.is_userDatabaseEnabled() || asiaSpellerModel.is_wordSegmentationEnabled()) {
                        this.setStateId(10);
                        return;
                    }
                    break block19;
                } else {
                    if (!asiaSpellerModel.is_hwrEnabled()) {
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                    if (!asiaSpellerModel.isInHwrAlphabet()) {
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                    if (this.resolveStateHWR(asiaSpellerModel)) {
                        return;
                    }
                    super.resolveState(asiaSpellerModel);
                    return;
                }
            }
            if (asiaSpellerModel.isMode(0)) {
                if (asiaSpellerModel.is_asiaConversionEnabled()) {
                    if (asiaSpellerModel.is_hwrEnabled() && asiaSpellerModel.isInHwrAlphabet()) {
                        if (this.resolveStateHWR(asiaSpellerModel)) {
                            return;
                        }
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                } else {
                    if (!asiaSpellerModel.is_hwrEnabled()) {
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                    if (!asiaSpellerModel.isInHwrAlphabet()) {
                        super.resolveState(asiaSpellerModel);
                        return;
                    }
                    if (this.resolveStateHWR(asiaSpellerModel)) {
                        return;
                    }
                    super.resolveState(asiaSpellerModel);
                    return;
                }
            }
        }
        super.resolveState(asiaSpellerModel);
    }

    private boolean resolveStateHWR(AsiaSpellerModel asiaSpellerModel) {
        if (this.isHWRNumberMode(asiaSpellerModel.get_hwrMode())) {
            if (asiaSpellerModel.isMode(4)) {
                this.setStateId(5);
                return true;
            }
            if (asiaSpellerModel.isMode(8)) {
                this.setStateId(2);
                return true;
            }
        } else {
            if (asiaSpellerModel.isMode(4)) {
                this.setStateId(4);
                return true;
            }
            if (asiaSpellerModel.isMode(8)) {
                if (asiaSpellerModel.is_asiaConversionEnabled()) {
                    if (asiaSpellerModel.isMode(16)) {
                        this.setStateId(3);
                        return true;
                    }
                    this.setStateId(0);
                    return true;
                }
                this.setStateId(1);
                return true;
            }
        }
        return false;
    }
}

