/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmFmAlternativeFrequencySwitch {
    private AmFmAlternativeFrequencySwitch() {
    }

    public static void notifyHMI() {
        AmFmFactory.getAslAmfmModelController().updateAfSetupOptionState(AmFmAlternativeFrequencySwitch.get());
    }

    public static void notifyDSI(boolean bl) {
        try {
            if (null != RadioData.getAmfmDatabase()) {
                DSIAMFMTuner dSIAMFMTuner;
                if (!RadioCodingAdapter.isPiActivated()) {
                    bl = false;
                }
                if (null != (dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner())) {
                    dSIAMFMTuner.switchAF(bl);
                    ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> .amfm.settings.AmFmAlternativeFrequencySwitch.notifyDSI - requsting DSI to set AF = ").append(bl).log();
                    if (bl) {
                        dSIAMFMTuner.switchME(false);
                    } else {
                        dSIAMFMTuner.switchME(RadioCodingAdapter.isMultipleEntrySwitchOn());
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "", exception);
        }
    }

    public static void set(boolean bl) {
        if (null != RadioData.getAmfmDatabase()) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAFOption(bl);
            AmFmAlternativeFrequencySwitch.log();
            AmFmAlternativeFrequencySwitch.notifyHMI();
            if (!bl && RadioData.getAmfmDatabase().getSettingsPersistable().getFmStationListSortOrder() == 3) {
                AmFmFactory.getInstanceEUStationListViewWalker().setFmStationListSortOrder(1);
            }
            if (AmfmRDSOption.get()) {
                AmFmAlternativeFrequencySwitch.setAFOnBeforeRDSOff(AmFmAlternativeFrequencySwitch.get());
            }
        }
    }

    public static boolean get() {
        if (null != RadioData.getAmfmDatabase()) {
            return RadioData.getAmfmDatabase().getSettingsPersistable().getAFOption();
        }
        ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> .amfm.settings.AmFmAlternativeFrequencySwitch.get() - no DB, fallback to AF=false").log();
        return false;
    }

    public static void setAFOnBeforeRDSOff(boolean bl) {
        if (null != RadioData.getAmfmDatabase()) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAFOnBeforeRDSOff(bl);
        }
    }

    public static boolean getAFOnBeforeRDSOff() {
        if (null != RadioData.getAmfmDatabase()) {
            return RadioData.getAmfmDatabase().getSettingsPersistable().getAFOnBeforeRDSOff();
        }
        return false;
    }

    private static void log() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AF switch setup option: ").append(AmFmAlternativeFrequencySwitch.get()).log();
        }
    }
}

