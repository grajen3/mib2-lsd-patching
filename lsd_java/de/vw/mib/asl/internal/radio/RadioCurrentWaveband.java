/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmConstants;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioCurrentWaveband {
    private static Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    private RadioCurrentWaveband() {
    }

    public static void reset() {
        RadioCurrentWaveband.set(1);
    }

    public static void set(int n) {
        int n2 = RadioCurrentWaveband.get();
        if (n2 != n) {
            RadioData.getAmfmDatabase().setCurrentHDStation(AmFmConstants.EMPTY_HDSTATIONINFO);
            RadioServiceManager.getServiceManager().getGuiBapApi().invalidateWavebandLogo(n2);
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setWaveband(n);
        if (n == 1 && ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(1);
            AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(1);
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentFMStation();
            ResourceLocator resourceLocator = AmFmFactory.getAslAmfmModelController().getAmFmStationArt(amFmStation);
            AmFmFactory.getAslAmfmModelController().updateLogoInStationView(resourceLocator);
            AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(amFmStation), AmFmPresetApi.getCurrentIndex());
        }
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("waveband: ").append(RadioCurrentWaveband.getWavebandString()).log();
        }
        GuiApiTunerCommon.updateCurrentBand(n);
    }

    public static int get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
    }

    public static String getWavebandString() {
        return RadioCurrentWaveband.getWavebandString(RadioCurrentWaveband.get());
    }

    public static String getWavebandString(int n) {
        switch (n) {
            case 0: {
                return "AM";
            }
            case 1: {
                return "FM";
            }
            case 2: {
                return "DAB";
            }
            case 3: {
                return "SDARS";
            }
        }
        return String.valueOf(n);
    }

    public String toString() {
        return RadioCurrentWaveband.getWavebandString();
    }

    public static boolean isAm() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 0;
    }

    public static boolean isFm() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 1;
    }

    public static boolean isDab() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 2;
    }

    public static boolean isSdars() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband() == 3;
    }

    public static boolean isAm(int n) {
        return n == 0;
    }

    public static boolean isFm(int n) {
        return n == 1;
    }

    public static boolean isDab(int n) {
        return n == 2;
    }

    public static boolean isSdars(int n) {
        return n == 3;
    }
}

