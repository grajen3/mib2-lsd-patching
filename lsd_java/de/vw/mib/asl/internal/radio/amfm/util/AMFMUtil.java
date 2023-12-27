/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.dsi.ifc.radio.Station;

public final class AMFMUtil {
    private AMFMUtil() {
    }

    public static String formatFrequency(Station station) {
        return AMFMUtil.formatFrequency(station.getFrequency(), station.getWaveband());
    }

    public static String formatFrequency(long l, int n) {
        StringBuffer stringBuffer = new StringBuffer(10);
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        decimalFormat.applyPattern("0.0");
        switch (n) {
            case 1: {
                float f2 = (float)l / 31300;
                stringBuffer.append(decimalFormat.format(f2));
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                long l2 = l;
                stringBuffer.append(l2);
                break;
            }
            default: {
                stringBuffer.append(l);
            }
        }
        return stringBuffer.toString();
    }

    public static FMStationInfoCollector[] searchForRegionals2ndNibble(FMStationInfoCollector[] fMStationInfoCollectorArray) {
        if (AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) {
            boolean bl = false;
            for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
                fMStationInfoCollectorArray[i2].station.setRegionalisation("");
                for (int i3 = 0; i3 < fMStationInfoCollectorArray.length; ++i3) {
                    if (i3 == i2 || !(bl = ProgramIdentification.checkForRegionalVariant(fMStationInfoCollectorArray[i2].station.getPi(), fMStationInfoCollectorArray[i3].station.getPi())) || !fMStationInfoCollectorArray[i2].station.getName().equals(fMStationInfoCollectorArray[i3].station.getName())) continue;
                    fMStationInfoCollectorArray[i2].station.calcRegionalisation();
                }
            }
        }
        return fMStationInfoCollectorArray;
    }

    public static int convertDSIBandConstantToHMIBandConstant(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 3: 
            case 4: {
                n2 = 0;
                break;
            }
        }
        return n2;
    }

    public static int getDSIAmBandRangeForCodingValue(int n) {
        int n2 = -1;
        switch (n) {
            case 5: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 2;
            }
        }
        return n2;
    }

    public static int getHMIFmBandRangeForCodingValue(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 8: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public static String getAmBandRangeCodingStringForCodingValue(int n) {
        switch (n) {
            case 5: {
                return "BAND_SETTINGS_AM_TUNER_OFF";
            }
            case 4: {
                return "BAND_SETTINGS_AM_TUNER_EU";
            }
            case 1: {
                return "BAND_SETTINGS_AM_TUNER_EU_RDW";
            }
            case 3: {
                return "BAND_SETTINGS_AM_TUNER_JP";
            }
            case 2: {
                return "BAND_SETTINGS_AM_TUNER_NAR";
            }
        }
        return "BAND_SETTINGS_AM_TUNER_NO_SETTING";
    }

    public static String getDsiAmBandRangeStringForDsiValue(int n) {
        switch (n) {
            case 5: {
                return "AMBANDRANGE_AUS";
            }
            case 2: {
                return "AMBANDRANGE_EU";
            }
            case 4: {
                return "AMBANDRANGE_EU_GER";
            }
            case 3: {
                return "AMBANDRANGE_JP";
            }
            case 1: {
                return "AMBANDRANGE_NAR";
            }
        }
        return "AMBANDRANGE_UNDEFINED";
    }

    public static String getFmBandRangeCodingStringForCodingValue(int n) {
        switch (n) {
            case 1: {
                return "BAND_SETTINGS_FM_TUNER_EU_RDW";
            }
            case 3: {
                return "BAND_SETTINGS_FM_TUNER_JP";
            }
            case 8: {
                return "BAND_SETTINGS_FM_TUNER_JP_2";
            }
            case 4: {
                return "BAND_SETTINGS_FM_TUNER_KOR";
            }
            case 2: {
                return "BAND_SETTINGS_FM_TUNER_NAR";
            }
            case 5: {
                return "BAND_SETTINGS_FM_TUNER_CHINA";
            }
        }
        return "BAND_SETTINGS_FM_TUNER_NO_SETTING";
    }

    public static String getDsiFmBandRangeStringForDsiValue(int n) {
        switch (n) {
            case 0: {
                return "FM_BANDRANGE_EU_RDW";
            }
            case 2: {
                return "FM_BANDRANGE_JP";
            }
            case 3: {
                return "FM_BANDRANGE_KOR";
            }
            case 1: {
                return "FM_BANDRANGE_NAR";
            }
            case 4: {
                return "FM_BANDRANGE_CHINA";
            }
        }
        return "FM_BANDRANGE_UNDEFINED";
    }

    public static boolean isStationChanged(AmFmStation amFmStation, AmFmStation amFmStation2) {
        return amFmStation2 != null && (amFmStation == null || amFmStation.getFrequency() != amFmStation2.getFrequency() || ServiceManager.configManagerDiag.isFeatureFlagSet(2) && amFmStation.getServiceId() != amFmStation2.getServiceId());
    }

    public static boolean isShortNameSameForStations(Station station, Station station2) {
        return station != null && station2 != null && station.isHd() && station2.isHd() && station.getShortNameHD().length() > 1 && station2.getShortNameHD().length() > 1 && station.getShortNameHD().equals(station2.getShortNameHD());
    }

    public static boolean isNARStationChanged(Station station, Station station2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" isNARStationChanged( )").log();
        }
        if (station == null) {
            return station2 != null;
        }
        if (station2 == null) {
            return true;
        }
        if (station.getFrequency() != station2.getFrequency()) {
            return true;
        }
        if (station.isHd() != station2.isHd()) {
            return true;
        }
        if (!station.isHd() && !station2.isHd()) {
            return false;
        }
        if (station.getServiceId() != station2.getServiceId()) {
            return true;
        }
        return station.getShortNameHD() != null && station2.getShortNameHD() != null && station.getShortNameHD().length() > 1 && station2.getShortNameHD().length() > 1 && !station.getShortNameHD().equals(station2.getShortNameHD());
    }

    public static boolean compareStations(AmFmStation amFmStation, AmFmStation amFmStation2) {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            int n = amFmStation.getFrequency();
            int n2 = amFmStation.getPi();
            int n3 = amFmStation2.getFrequency();
            int n4 = amFmStation2.getPi();
            boolean bl = amFmStation.isRds();
            boolean bl2 = amFmStation2.isRds();
            if (!RadioCodingAdapter.isPiActivated()) {
                return n == n3 && amFmStation.getServiceId() == amFmStation2.getServiceId();
            }
            if (AmfmRDSOption.get() && RadioCurrentWaveband.isFm()) {
                if (bl || bl2) {
                    if (ProgramIdentification.isLocalStation(n2) && ProgramIdentification.isLocalStation(n4) || !AmFmAlternativeFrequencySwitch.get()) {
                        return n == n3 && n2 == n4;
                    }
                    return n2 == n4;
                }
                if (!bl && !bl2) {
                    return n == n3;
                }
            } else if (!AmfmRDSOption.get() && RadioCurrentWaveband.isFm()) {
                return n == n3;
            }
        }
        return false;
    }

    public static AmFmStation[] convertCollectorToAmFmStationArray(AmFmStationInfoCollector[] amFmStationInfoCollectorArray) {
        try {
            int n = amFmStationInfoCollectorArray.length;
            AmFmStation[] amFmStationArray = new AmFmStation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                amFmStationArray[i2] = amFmStationInfoCollectorArray[i2].station;
            }
            return amFmStationArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return new AmFmStation[0];
        }
    }

    public static boolean isStationValidInBand(Station station) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" isStationValidInBand( ").append(station.toString()).append(" )").log();
        }
        int n = RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
        boolean bl = false;
        boolean bl2 = false;
        if (station.waveband == 1 && n == 1 || (station.waveband == 3 || station.waveband == 4) && n == 0) {
            bl = true;
        }
        if (n == 1 && station.frequency >= RadioData.getAmfmDatabase().getFmBandInfo().getLowerLimit() && station.frequency <= RadioData.getAmfmDatabase().getFmBandInfo().getUpperLimit()) {
            bl2 = true;
        } else if (n == 0 && station.frequency >= RadioData.getAmfmDatabase().getAmBandInfo().getLowerLimit() && station.frequency <= RadioData.getAmfmDatabase().getAmBandInfo().getUpperLimit()) {
            bl2 = true;
        }
        return bl && bl2;
    }
}

