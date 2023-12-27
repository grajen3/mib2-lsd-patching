/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmFmHDOptionRequester {
    private static boolean isFmSetUp;

    public static boolean isFmSetup() {
        return isFmSetUp;
    }

    public static void fmSetup(boolean bl) {
        isFmSetUp = bl;
    }

    private AmFmHDOptionRequester() {
    }

    public static void reset() {
        RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDSetupOption(true);
        RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDSetupOption(true);
        AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
        AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
    }

    public static void notifyHMI() {
        if (AmFmHDOptionRequester.isFmSetup()) {
            AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
        } else {
            AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
        }
    }

    public static void notifyHMIAmFm() {
        AmFmFactory.getAslAmfmModelController().updateFMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption());
        AmFmFactory.getAslAmfmModelController().updateAMHDRadioEnabled(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption());
    }

    public static void notifyDSI(boolean bl, int n) {
        try {
            if (AmFmHDOptionRequester.isFmSetup()) {
                if (bl && RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                    AmFmHDOptionRequester.setModeHD(1);
                } else if (bl && !RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                    AmFmHDOptionRequester.setModeHD(5);
                } else if (!bl && RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                    AmFmHDOptionRequester.setModeHD(6);
                } else {
                    AmFmHDOptionRequester.setModeHD(2);
                }
            } else if (bl && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(1);
            } else if (bl && !RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(6);
            } else if (!bl && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(5);
            } else {
                AmFmHDOptionRequester.setModeHD(2);
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "", exception);
        }
    }

    public static void notifyDSIFM(boolean bl, int n) {
        try {
            if (bl && RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(1);
            } else if (bl && !RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(5);
            } else if (!bl && RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(6);
            } else {
                AmFmHDOptionRequester.setModeHD(2);
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "", exception);
        }
    }

    public static void notifyDSIHDMode(boolean bl, int n) {
        try {
            if (bl && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(1);
            } else if (bl && !RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(6);
            } else if (!bl && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()) {
                AmFmHDOptionRequester.setModeHD(5);
            } else {
                AmFmHDOptionRequester.setModeHD(2);
            }
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "", exception);
        }
    }

    public static void setModeHD(int n) {
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AmFmHDOptionRequester - setModeHD( ").append(n).append(" )").log();
            dSIAMFMTuner.setModeHD(n);
        }
    }

    public static void set(boolean bl) {
        if (AmFmHDOptionRequester.isFmSetup()) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDSetupOption(bl);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("HD switch setup option: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption()).log();
            }
            AmFmHDOptionRequester.notifyHMI();
        } else {
            RadioData.getAmfmDatabase().getSettingsPersistable().setAMHDSetupOption(bl);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("HD switch setup option: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption()).log();
            }
            AmFmHDOptionRequester.notifyHMI();
        }
    }

    public static boolean getAm() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDSetupOption();
    }

    public static boolean getFm() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDSetupOption();
    }
}

