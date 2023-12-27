/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.behavior.cache;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.RadioInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.collections.longs.LongLongMap;
import de.vw.mib.collections.longs.LongLongOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import java.util.ArrayList;

public class StationListCache {
    private static final String LOGGER_PREFIX;
    private final SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    private final boolean useGrowStrategy;
    private final String bandText;
    protected static long STATIONLIST_CACHE_REMOVAL_TIME;
    protected static long STATIONLIST_CACHE_CLEANUP_TIME;
    private long lastClear;
    private boolean stationlistEmpty;
    protected LongObjectMap content = new LongObjectOptHashMap(100);
    protected LongLongMap lastUpdate = new LongLongOptHashMap(100);

    public StationListCache(SpeechTunerServiceManager speechTunerServiceManager, boolean bl, String string) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[StationListCache] ");
        this.useGrowStrategy = bl;
        this.bandText = string;
        this.stationlistEmpty = true;
    }

    public void add(Station[] stationArray, RadioInterfaceHandler radioInterfaceHandler) {
        if (this.useGrowStrategy) {
            this.addGrow(stationArray, radioInterfaceHandler);
        } else {
            this.addReplace(stationArray, radioInterfaceHandler);
        }
    }

    private void addGrow(Station[] stationArray, RadioInterfaceHandler radioInterfaceHandler) {
        long l;
        long l2 = this.serviceManager.getASLServices().getCurrentTimeMillis();
        this.stationlistEmpty = true;
        if (stationArray != null) {
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                if (stationArray[i2] != null) {
                    l = this.serviceManager.getRadioUtils().getObjectId(stationArray[i2]);
                    if (radioInterfaceHandler.addingStationAllowed(stationArray[i2])) {
                        this.stationlistEmpty = false;
                        this.content.put(l, stationArray[i2]);
                        this.lastUpdate.put(l, l2);
                        if (!this.logger.isTraceEnabled()) continue;
                        this.logger.trace(new StringBuffer().append("added or updated station with id ").append(l).append(" to ").append(this.bandText).append(" cache").toString());
                        continue;
                    }
                    this.logger.warn(new StringBuffer().append("skipped station with id ").append(l).append(" while adding stations to ").append(this.bandText).append(" cache").toString());
                    continue;
                }
                this.logger.warn("received null as stationlist entry for grow strategy");
            }
        } else {
            this.logger.warn("received null as stationlist for grow strategy");
        }
        if (l2 > this.lastClear + STATIONLIST_CACHE_CLEANUP_TIME) {
            int n;
            this.lastClear = l2;
            ArrayList arrayList = new ArrayList();
            long[] lArray = this.lastUpdate.keysToArray();
            for (n = 0; n < lArray.length; ++n) {
                l = lArray[n];
                if (l2 <= this.lastUpdate.get(l) + STATIONLIST_CACHE_REMOVAL_TIME) continue;
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("cleared id ").append(l).append(" from ").append(this.bandText).append(" cache after at least 5 minutes without update").toString());
                }
                arrayList.add(new Long(l));
            }
            for (n = 0; n < arrayList.size(); ++n) {
                l = (Long)arrayList.get(n);
                this.lastUpdate.remove(l);
                this.content.remove(l);
            }
            if (this.logger.isTraceEnabled() && arrayList.size() == 0) {
                this.logger.trace(new StringBuffer().append("did cleanup on ").append(this.bandText).append(" cache but found nothing to clear").toString());
            }
        }
    }

    private void addReplace(Station[] stationArray, RadioInterfaceHandler radioInterfaceHandler) {
        this.stationlistEmpty = true;
        this.content.clear();
        if (stationArray != null) {
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                if (stationArray[i2] != null) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(stationArray[i2]);
                    if (radioInterfaceHandler.addingStationAllowed(stationArray[i2])) {
                        this.stationlistEmpty = false;
                        this.content.put(l, stationArray[i2]);
                        if (!this.logger.isTraceEnabled()) continue;
                        this.logger.trace(new StringBuffer().append("added or updated station with id ").append(l).append(" to ").append(this.bandText).append(" cache").toString());
                        continue;
                    }
                    this.logger.warn(new StringBuffer().append("skipped station with id ").append(l).append(" while adding stations to ").append(this.bandText).append(" cache").toString());
                    continue;
                }
                this.logger.warn("received null as stationlist entry for replace strategy");
            }
        } else {
            this.logger.warn("received null as stationlist for replace strategy");
        }
    }

    public Object[] getStationList() {
        return this.content.values().toArray();
    }

    public Object getStation(long l) {
        return this.content.get(l);
    }

    public boolean isStationlistEmpty() {
        return this.stationlistEmpty;
    }

    public void initCleanUpTime() {
        this.lastClear = this.serviceManager.getASLServices().getCurrentTimeMillis();
    }

    static {
        STATIONLIST_CACHE_REMOVAL_TIME = 0;
        STATIONLIST_CACHE_CLEANUP_TIME = 0;
    }
}

