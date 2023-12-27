/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;

public final class RadioCodingAdapter {
    public static Coding mAmFmCodingData = null;
    public static final int INVALID_CODING_VALUE;

    private RadioCodingAdapter() {
    }

    public static boolean isAmDisabled() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(60)) {
            return mAmFmCodingData.getBoolean(60);
        }
        return false;
    }

    public static boolean isPiActivated() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(56)) {
            return !mAmFmCodingData.getBoolean(56);
        }
        return false;
    }

    public static boolean isRdsButtonVisible() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(52)) {
            return mAmFmCodingData.getBoolean(52);
        }
        return false;
    }

    public static boolean isRadioTextPlusActivated() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(55)) {
            return mAmFmCodingData.getBoolean(55);
        }
        return false;
    }

    public static boolean isFmPty31AlarmOn() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(59)) {
            return mAmFmCodingData.getBoolean(59);
        }
        return false;
    }

    public static boolean isRdsActivated() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(63)) {
            return !mAmFmCodingData.getBoolean(63);
        }
        return false;
    }

    public static boolean isAfActivated() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(64)) {
            return !mAmFmCodingData.getBoolean(64);
        }
        return false;
    }

    public static boolean isMultipleEntrySwitchOn() {
        if (mAmFmCodingData == null) {
            return false;
        }
        if (mAmFmCodingData.contains(62)) {
            return mAmFmCodingData.getBoolean(62);
        }
        return false;
    }

    public static int getAmTunerBandSettings() {
        if (mAmFmCodingData == null) {
            return -1;
        }
        if (mAmFmCodingData.contains(46)) {
            int n = mAmFmCodingData.getValue(46);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("RadioCodingAdapter - getAmTunerBandSettings() - amTunerBandSettings = ").append(n).log();
            }
            return n;
        }
        return -1;
    }

    public static int getFmTunerBandSettings() {
        if (mAmFmCodingData == null) {
            return -1;
        }
        if (mAmFmCodingData.contains(45)) {
            int n = mAmFmCodingData.getValue(45);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("RadioCodingAdapter - getFmTunerBandSettings() - fmTunerBandSettings = ").append(n).log();
            }
            return n;
        }
        return -1;
    }

    public static int getCarBrand() {
        if (mAmFmCodingData == null) {
            return -1;
        }
        if (mAmFmCodingData.contains(0)) {
            int n = mAmFmCodingData.getValue(0);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("RadioCodingAdapter - getCarBrand() - carBrand = ").append(n).log();
            }
            return n;
        }
        return -1;
    }

    public static boolean isHongKongVariant() {
        if (mAmFmCodingData == null) {
            return false;
        }
        int n = RadioCodingAdapter.getFmTunerBandSettings();
        return RadioCodingAdapter.isPiActivated() && mAmFmCodingData.isBandSettingsFmTunerChina(n);
    }

    public static boolean isRadioTileFeatureActivated() {
        return true;
    }

    public static boolean isFMBandJapan() {
        return null != mAmFmCodingData && (mAmFmCodingData.getValue(45) == 3 || mAmFmCodingData.getValue(45) == 8);
    }
}

