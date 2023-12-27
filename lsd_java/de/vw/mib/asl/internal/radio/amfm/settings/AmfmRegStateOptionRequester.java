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

public final class AmfmRegStateOptionRequester {
    private AmfmRegStateOptionRequester() {
    }

    public static void reset() {
        int n = 3;
        if (RadioCodingAdapter.isHongKongVariant()) {
            n = 1;
        }
        AmfmRegStateOptionRequester.set(n);
        AmfmRegStateOptionRequester.setREGFixBeforeRDSOff(n);
    }

    public static void notifyHMI() {
        try {
            int n = AmfmRegStateOptionRequester.get();
            n = AmfmRegStateOptionRequester.dsiToHmi(n);
            AmFmFactory.getAslAmfmModelController().updateRdsRegionalizationOptionState(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyDsi(int n) {
        DSIAMFMTuner dSIAMFMTuner;
        if (RadioCodingAdapter.isHongKongVariant()) {
            n = 1;
        }
        if (null != (dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner())) {
            dSIAMFMTuner.switchREG(n);
        }
    }

    public static int dsiToHmi(int n) {
        if (n == 3) {
            return 0;
        }
        return 1;
    }

    public static int hmiToDsi(int n) {
        if (n == 0) {
            return 3;
        }
        return 1;
    }

    public static void set(int n) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setREGOption(n);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("REG state setup option: DSIAMFMTuner.").append(AmfmRegStateOptionRequester.getString()).log();
        }
        AmfmRegStateOptionRequester.notifyHMI();
        if (AmfmRDSOption.get()) {
            AmfmRegStateOptionRequester.setREGFixBeforeRDSOff(n);
        }
    }

    public static int get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getREGOption();
    }

    public static void setREGFixBeforeRDSOff(int n) {
        int n2 = AmfmRegStateOptionRequester.dsiToHmi(n);
        if (n2 == 1) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setREGFixBeforeRDSOff(true);
        } else if (n2 == 0) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setREGFixBeforeRDSOff(false);
        }
    }

    public static boolean getREGFixBeforeRDSOff() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getREGFixBeforeRDSOff();
    }

    public static String getString() {
        int n = AmfmRegStateOptionRequester.get();
        switch (n) {
            case 3: {
                return "REGSTATUS_AUTO";
            }
            case 2: {
                return "REGSTATUS_OFF";
            }
            case 1: {
                return "REGSTATUS_ON";
            }
            case 0: {
                return "REGSTATUS_UNDEFINED";
            }
        }
        return null;
    }
}

