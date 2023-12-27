/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRadioTextOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRegStateOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmTPOption;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmfmRDSOption {
    private AmfmRDSOption() {
    }

    public static boolean loadOnly() {
        return AmfmRDSOption.get();
    }

    public static void notifyHMI() {
        AmFmFactory.getAslAmfmModelController().updateRdsSetupOptionState(AmfmRDSOption.get());
    }

    public static void notifyDSI() {
        boolean bl = false;
        boolean bl2 = false;
        int n = 0;
        if (AmfmRDSOption.get()) {
            bl = AmFmAlternativeFrequencySwitch.getAFOnBeforeRDSOff();
            bl2 = AmfmRadioTextOption.getRadioTextOnBeforeRDSOff();
            n = AmfmRegStateOptionRequester.getREGFixBeforeRDSOff() ? 1 : 3;
        } else {
            n = 2;
            bl = false;
            bl2 = false;
        }
        if (!RadioServiceManager.getServiceManager().isFactoryResetInProgress()) {
            AmfmRegStateOptionRequester.notifyDsi(n);
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Switch AF called in RDS Option : ").append(bl).log();
        }
        AmFmAlternativeFrequencySwitch.notifyDSI(bl);
        AmfmRadioTextOption.set(bl2);
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.switchRDSIgnore(!AmfmRDSOption.get());
        }
    }

    public static void notifyFriends() {
        boolean bl = AmfmRDSOption.get();
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1285750784, eventGeneric);
    }

    public static void set(boolean bl, boolean bl2) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setRDSOption(bl);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("RDS setup option:").append(RadioData.getAmfmDatabase().getSettingsPersistable().getRDSOption());
        }
        if (bl) {
            if (bl2) {
                AmfmTPOption.set(AmfmTPOption.getTpOnBeforeRdsOff());
            }
            boolean bl3 = RadioData.getAmfmDatabase().getSettingsPersistable().getAutoStoreStationLogoOnBeforeRdsOff();
            AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(bl3);
            RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(bl3);
            boolean bl4 = RadioData.getAmfmDatabase().getSettingsPersistable().getEnhancedRadioTextActiveBeforeRdsOff();
            AmfmRadioTextOption.setEnhancedRadioTextOption(bl4);
        } else {
            AmfmTPOption.set(false);
            AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(false);
            RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(false);
            AmfmRadioTextOption.setEnhancedRadioTextOption(false);
        }
        AmfmRDSOption.notifyDSI();
        AmfmRDSOption.notifyHMI();
        AmfmRDSOption.notifyFriends();
        AmFmPresetApi.forceHmiUpdate();
        AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo(RadioData.getAmfmDatabase().getCurrentStation());
    }

    public static boolean get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getRDSOption();
    }

    public String toString() {
        return new StringBuffer().append("RDS Setup Option = ").append(AmfmRDSOption.get()).toString();
    }
}

