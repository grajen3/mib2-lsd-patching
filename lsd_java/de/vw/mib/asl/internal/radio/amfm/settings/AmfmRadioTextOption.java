/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmfmRadioTextOption {
    private AmfmRadioTextOption() {
    }

    public static boolean get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption();
    }

    public static boolean getRadioTextOnBeforeRDSOff() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOnBeforeRDSOff();
    }

    public static void notifyHMI() {
        AmFmFactory.getAslAmfmModelController().updateRadioTextSetupState(RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption());
    }

    public static void set(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("radio text setup option: ").append(bl).log();
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setRadioTextOption(bl);
        AmfmRadioTextOption.notifyHMI();
        if (AmfmRDSOption.get()) {
            AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(AmfmRadioTextOption.get());
        }
    }

    public static void setupOptionByUser(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("radio text setup view option: ").append(bl).log();
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setRadioTextOption(bl);
        AmFmFactory.getAslAmfmModelController().setPropertyBoolean(1409, bl);
        RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioTextGetters("");
        if (bl) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioTextGetters(RadioServiceManager.getServiceManager().getApiGuiRadioTiles().getTileRadioText());
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileRadioTextNar();
        }
        if (AmfmRDSOption.get()) {
            AmfmRadioTextOption.setRadioTextOnBeforeRDSOff(bl);
        }
    }

    public static void setRadioTextOnBeforeRDSOff(boolean bl) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setRadioTextOnBeforeRDSOff(bl);
    }

    public static void setEnhancedRadioTextOption(boolean bl) {
        AmFmFactory.getAslAmfmModelController().updateEnhancedRadioTextSetupOptionState(bl);
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.setERTDisplayable(bl);
            dSIAMFMTuner.setERTPrefered(bl);
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setEnhancedRadioTextOption(bl);
    }

    public String toString() {
        return new StringBuffer().append("FMRadiotext Setup Option = ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getRadioTextOption()).toString();
    }
}

