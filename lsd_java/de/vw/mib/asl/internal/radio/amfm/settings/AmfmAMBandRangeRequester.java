/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import org.dsi.ifc.radio.DSIAMFMTuner;

public final class AmfmAMBandRangeRequester {
    private AmfmAMBandRangeRequester() {
    }

    public static void notifyDSI(int n) {
        DSIAMFMTuner dSIAMFMTuner = RadioData.getAmfmDatabase().getDsiAMFMTuner();
        if (null != dSIAMFMTuner) {
            dSIAMFMTuner.setAMBandRange(n);
        }
    }

    public static void notifyDSI() {
        AmfmAMBandRangeRequester.notifyDSI(AmfmAMBandRangeRequester.get());
    }

    public static void set(int n) {
        RadioData.getAmfmDatabase().getSettingsPersistable().setAmRangeOption(n);
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("AM band range: DSIAMFMTuner.AMBANDRANGE_").append(AmfmAMBandRangeRequester.getBandRangeString()).log();
        }
        AmfmAMBandRangeRequester.notifyDSI(AmfmAMBandRangeRequester.get());
    }

    public static int get() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getAmRangeOption();
    }

    private static String getBandRangeString() {
        int n = AmfmAMBandRangeRequester.get();
        switch (n) {
            case 2: {
                return "EU";
            }
            case 5: {
                return "AUS";
            }
            case 4: {
                return "EU_GER";
            }
            case 3: {
                return "JP";
            }
            case 1: {
                return "NAR";
            }
            case 0: {
                return "UNDEFINED";
            }
        }
        return null;
    }

    public String toString() {
        return AmfmAMBandRangeRequester.getBandRangeString();
    }
}

