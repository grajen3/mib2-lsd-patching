/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.data;

import de.vw.mib.asl.api.vicsetc.ITunerData;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class StationNameFreqList {
    private static final int INITIAL_CAPACITY;
    private static final int MAXIMUM_CAPACITY;
    private IntObjectMap stationFreqTuple = new IntObjectOptHashMap(200);

    public void clear() {
        if (null != this.stationFreqTuple) {
            this.stationFreqTuple.clear();
        }
    }

    public void add(ITunerData[] iTunerDataArray) {
        int n;
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StationNameFreqList - add()").log();
            if (null != iTunerDataArray) {
                for (n = 0; n < iTunerDataArray.length; ++n) {
                    if (null != iTunerDataArray[n]) {
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StationNameFreqList - add: ").append(iTunerDataArray[n].getFrequency()).append(", ").append(iTunerDataArray[n].getStationName()).log();
                        continue;
                    }
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StationNameFreqList - add: receivableStations[").append(n).append("] = null").log();
                }
            }
        }
        if (null != iTunerDataArray && null != this.stationFreqTuple) {
            this.clear();
            for (n = 0; n < iTunerDataArray.length && this.stationFreqTuple.size() < 200; ++n) {
                if (null == iTunerDataArray[n]) continue;
                this.stationFreqTuple.put((int)iTunerDataArray[n].getFrequency(), iTunerDataArray[n].getStationName());
            }
        }
    }

    public String getStationName(int n) {
        if (null != this.stationFreqTuple) {
            Object object = this.stationFreqTuple.get(n);
            if (null == object) {
                return "";
            }
            return (String)object;
        }
        return "";
    }

    public void addCurrentStation(int n, String string) {
        if (null != this.stationFreqTuple && null != string && this.getStationName(n).length() <= 0) {
            this.stationFreqTuple.put(n, string);
        }
    }
}

