/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;

public final class AmFmDefaultSettings {
    private AmFmDefaultSettings() {
    }

    public static long getFmDefaultFrequency() {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            int n = RadioCodingAdapter.getFmTunerBandSettings();
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerChina(n)) {
                return RadioConstants.FM_BANDRANGE_CHINA.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerEuRdw(n)) {
                return RadioConstants.FM_BANDRANGE_EU_RDW.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerJp(n)) {
                return RadioConstants.FM_BANDRANGE_JP.getLowerLimit();
            }
            if (n == 8) {
                return RadioConstants.FM_BANDRANGE_JP_EXTENDED.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerKor(n)) {
                return RadioConstants.FM_BANDRANGE_KOR.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsFmTunerNar(n)) {
                return RadioConstants.FM_BANDRANGE_NAR.getLowerLimit();
            }
            return RadioConstants.FM_BANDRANGE_EU_RDW.getLowerLimit();
        }
        return RadioConstants.FM_BANDRANGE_EU_RDW.getLowerLimit();
    }

    public static long getAmDefaultFrequency() {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            boolean bl = false;
            int n = RadioCodingAdapter.getAmTunerBandSettings();
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEu(n)) {
                return RadioConstants.AM_BANDRANGE_EU.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerEuRdw(n)) {
                return RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerJp(n)) {
                return RadioConstants.AM_BANDRANGE_JP.getLowerLimit();
            }
            if (RadioCodingAdapter.mAmFmCodingData.isBandSettingsAmTunerNar(n)) {
                return RadioConstants.AM_BANDRANGE_NAR.getLowerLimit();
            }
            return RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit();
        }
        return RadioConstants.AM_BANDRANGE_EU_RDW.getLowerLimit();
    }

    public static AmFmStation getAmFmDefaultStation() {
        if (RadioCurrentWaveband.isFm()) {
            return new AmFmStation(AmFmDefaultSettings.getFmDefaultFrequency());
        }
        return new AmFmStation(AmFmDefaultSettings.getAmDefaultFrequency());
    }
}

