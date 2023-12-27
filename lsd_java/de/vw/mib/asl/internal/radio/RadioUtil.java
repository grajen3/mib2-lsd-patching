/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;

public final class RadioUtil {
    static final int LEN_FREQ;
    static final int MAX_FREQ_IN_ROW;
    public static String LOG_PREFIX_AMFM;
    public static String LOG_PREFIX_AMFM_MAIN;
    public static String LOG_PREFIX_AMFM_ANNOUNCEMENT;
    public static String LOG_PREFIX_AMFM_AUTOSTORE;
    public static String LOG_PREFIX_AMFM_DSI;
    public static String LOG_PREFIX_AMFM_MANAGER;
    public static String LOG_PREFIX_AMFM_PRESETS;
    public static String LOG_PREFIX_AMFM_RADIOTEXT;
    public static String LOG_PREFIX_AMFM_STATIONLIST;
    public static String LOG_PREFIX_AMFM_TUNER;
    public static String LOG_PREFIX_DAB_AUTOSTORE;
    public static String LOG_PREFIX_DAB_PRESETS;
    public static String LOG_PREFIX_AMFM_LIST_UPDATE;
    public static String LOG_PREFIX_AMFM_CODING;
    public static String LOG_PREFIX_RADIODATA;
    public static String LOG_PREFIX_AMFM_COUNTRY_CALCULATION;
    public static String LOG_PREFIX_RADIO_SPEECH;
    public static String LOG_PREFIX_RADIO_BAP;
    private static final long STATION_ID_PI_FILTER_MASK;

    private RadioUtil() {
    }

    public static int setDabHmiState(ServiceInfo serviceInfo, int n) {
        String string;
        switch (n) {
            case 3: {
                string = "linking to FM";
                break;
            }
            case 0: {
                string = "default";
                break;
            }
            case 1: {
                string = "not available";
                break;
            }
            default: {
                string = null;
            }
        }
        if (string != null) {
            RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("--- SyncStatus (").append(serviceInfo.fullName).append("): ").append(string).toString());
        }
        return n;
    }

    public static void traceSdars(String string) {
        if (RadioUtil.isSdarsTraceEnabled()) {
            ServiceManager.logger.trace(512).append("SDARS: ").append(string).log();
        }
    }

    public static boolean isDabTraceEnabled() {
        return ServiceManager.logger.isTraceEnabled(256);
    }

    public static boolean isSdarsTraceEnabled() {
        return ServiceManager.logger.isTraceEnabled(512);
    }

    public static String dabRadioTextPlusToString(int[] nArray, String[] stringArray) {
        if (RadioUtil.isDabTraceEnabled()) {
            String string = "{";
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                switch (nArray[i2]) {
                    case 1: {
                        string = new StringBuffer().append(string).append("TITLE=").toString();
                        break;
                    }
                    case 4: {
                        string = new StringBuffer().append(string).append("ARTIST=").toString();
                        break;
                    }
                    case 11: {
                        string = new StringBuffer().append(string).append("GENRE=").toString();
                        break;
                    }
                    case 2: {
                        string = new StringBuffer().append(string).append("ALBUM=").toString();
                        break;
                    }
                }
                string = new StringBuffer().append(string).append(stringArray[i2]).toString();
                if (i2 >= nArray.length - 1) continue;
                string = new StringBuffer().append(string).append(",").toString();
            }
            return string;
        }
        return "";
    }

    public static void line(int n) {
        ServiceManager.logger.trace(n, "--- -------------------------------------");
    }

    public static FMStationInfoCollector[] getSubChannels(FMStationInfoCollector[] fMStationInfoCollectorArray, int n) {
        ArrayList arrayList = new ArrayList(0);
        if (fMStationInfoCollectorArray != null && fMStationInfoCollectorArray.length > 0 && n < fMStationInfoCollectorArray.length && n >= 0) {
            int n2 = fMStationInfoCollectorArray[n].station.getFrequency();
            for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
                if (fMStationInfoCollectorArray[i2].station.getFrequency() != n2 || fMStationInfoCollectorArray[i2].station.getSubChannel() <= 1) continue;
                arrayList.add(fMStationInfoCollectorArray[i2]);
            }
        }
        return (FMStationInfoCollector[])arrayList.toArray(new FMStationInfoCollector[arrayList.size()]);
    }

    public static FMStationInfoCollector[] getMainChannels(FMStationInfoCollector[] fMStationInfoCollectorArray) {
        ArrayList arrayList = new ArrayList(0);
        for (int i2 = 0; i2 < fMStationInfoCollectorArray.length; ++i2) {
            if (fMStationInfoCollectorArray[i2].station.getSubChannel() > 1) continue;
            arrayList.add(fMStationInfoCollectorArray[i2]);
        }
        return (FMStationInfoCollector[])arrayList.toArray(new FMStationInfoCollector[arrayList.size()]);
    }

    public static Object[] removeNull(Object[] objectArray) {
        int n = 0;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] == null) continue;
            ++n;
        }
        if (n != objectArray.length) {
            Object[] objectArray2 = new Object[n];
            int n2 = 0;
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                if (objectArray[i3] == null) continue;
                objectArray2[n2++] = objectArray[i3];
            }
            return objectArray2;
        }
        return objectArray;
    }

    public static long computeUniqueID(AmFmStation amFmStation) {
        long l = -1L;
        if (null != amFmStation) {
            if (amFmStation.getFrequency() > 0) {
                int n = amFmStation.getServiceId();
                int n2 = amFmStation.getPi();
                int n3 = amFmStation.getFrequency();
                l = amFmStation.getWaveband();
                l = l << 16 | (long)(n2 >= 0 ? n2 : 0);
                l = l << 32 | (long)(n3 > 0 ? n3 : 0);
                l = l << 8 | (long)(n > 0 ? n : 0);
                l <<= 1;
            }
        } else {
            ServiceManager.logger.warn(128).append("RadioUtil computeUniqueID - aslStation == null").log();
        }
        return l;
    }

    public static long filterOutPIFromUniqueID(long l) {
        return l & 0xFF0000FFFFFFFFFFL;
    }

    public static AmFmStation cumputeStationFromUniqueID(long l) {
        int n = (int)(l >>> 57);
        int n2 = (int)(l >>> 41 & 0);
        int n3 = (int)(l >>> 9 & 0xFFFFFFFFFFFFFFFFL);
        int n4 = (int)(l >>> 1 & 0);
        return new AmFmStation(n, n3, n2, n4);
    }

    public static boolean isIdADatabaseStationId(long l) {
        long l2 = l & 1L;
        return l2 == 1L;
    }

    public static String getWavebandNameForDSIIdentifier(int n) {
        switch (n) {
            case 1: {
                return "FM";
            }
            case 2: 
            case 3: 
            case 4: {
                return "AM";
            }
            case 0: {
                return "undefined waveband";
            }
        }
        throw new IllegalArgumentException("not a DSIAMFMTuner wave band indentifier constant");
    }

    public static boolean equals(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        if (resourceLocator == null) {
            return resourceLocator2 == null;
        }
        if (resourceLocator2 == null) {
            return false;
        }
        if (resourceLocator.isIntResource()) {
            return resourceLocator.getId() == resourceLocator2.getId();
        }
        return StringUtil.equals(resourceLocator.getUrl(), resourceLocator2.getUrl());
    }

    public static boolean isStationChanged(Station station, Station station2) {
        if (station == null && station2 != null) {
            return true;
        }
        return station != null && (station2 == null || station2.getFrequency() != station.getFrequency() || station2.getServiceId() != station.getServiceId());
    }

    public static boolean isValid(ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            if (resourceLocator.isIntResource()) {
                return resourceLocator.id != -1 && resourceLocator.id != 0;
            }
            return !Util.isNullOrEmpty(resourceLocator.url);
        }
        return false;
    }

    static {
        LOG_PREFIX_AMFM = "AMFM  ";
        LOG_PREFIX_AMFM_MAIN = "AMFM <MAIN>  ";
        LOG_PREFIX_AMFM_ANNOUNCEMENT = "AMFM <ANNOUNCEMENT>  ";
        LOG_PREFIX_AMFM_AUTOSTORE = "AMFM <AUTOSTORE>  ";
        LOG_PREFIX_AMFM_DSI = "AMFM <DSI>  ";
        LOG_PREFIX_AMFM_MANAGER = "AMFM <MANAGER>  ";
        LOG_PREFIX_AMFM_PRESETS = "AMFM <PRESETS>  ";
        LOG_PREFIX_AMFM_RADIOTEXT = "AMFM <RADIOTEXT>  ";
        LOG_PREFIX_AMFM_STATIONLIST = "AMFM <STATION LIST>  ";
        LOG_PREFIX_AMFM_TUNER = "AMFM [TUNER]  ";
        LOG_PREFIX_DAB_AUTOSTORE = "DAB <AUTOSTORE>  ";
        LOG_PREFIX_DAB_PRESETS = "DAB <PRESETS>  ";
        LOG_PREFIX_AMFM_LIST_UPDATE = "AMFM <LIST_UPDATE>  ";
        LOG_PREFIX_AMFM_CODING = "AMFM  <CODING>";
        LOG_PREFIX_RADIODATA = "RadioData - ";
        LOG_PREFIX_AMFM_COUNTRY_CALCULATION = "AMFM [COUNTRY_CALCULATION]  ";
        LOG_PREFIX_RADIO_SPEECH = "RADIO <SPEECH> ";
        LOG_PREFIX_RADIO_BAP = "RADIO <BAP> ";
    }
}

