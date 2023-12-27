/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sport;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.sport.RaceLapCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RaceStatistics {
    private static final int MAX_LAPS;
    private static final int ABORTED_LAP_INDICATOR;
    private int noOfLaps;
    List laps = new ArrayList();
    RaceLapCollector bestLap;
    RaceLapCollector worstLap;
    private int totalTime;
    private int avgTime;

    public void resetStatistics() {
        this.noOfLaps = 0;
        this.laps.clear();
        this.bestLap = null;
        this.worstLap = null;
        this.totalTime = 0;
        this.avgTime = 0;
        ListManager.getGenericASLList(10411).updateList(this.laps.toArray());
        AbstractASLTarget.writeIntegerToDatapool(10381, 0);
        AbstractASLTarget.writeIntegerToDatapool(10382, 0);
        AbstractASLTarget.writeIntegerToDatapool(10380, 0);
        AbstractASLTarget.writeIntegerToDatapool(10383, 0);
        AbstractASLTarget.writeIntegerToDatapool(10385, 0);
        AbstractASLTarget.writeIntegerToDatapool(10378, this.noOfLaps);
        AbstractASLTarget.writeIntegerToDatapool(10379, this.totalTime);
        AbstractASLTarget.writeIntegerToDatapool(10384, this.avgTime);
        AbstractASLTarget.writeIntegerToDatapool(10386, this.avgTime);
    }

    public boolean addLap(int n) {
        if (this.noOfLaps > 99) {
            return false;
        }
        RaceLapCollector raceLapCollector = new RaceLapCollector();
        ++this.noOfLaps;
        raceLapCollector.setLapTime(n);
        raceLapCollector.setLapNo(this.noOfLaps);
        this.laps.add(raceLapCollector);
        if (n > -1) {
            this.updateRaceStatistics(raceLapCollector);
        }
        AbstractASLTarget.writeIntegerToDatapool(10378, this.noOfLaps);
        ListManager.getGenericASLList(10411).updateList(this.laps.toArray());
        return true;
    }

    private void updateRaceStatistics(RaceLapCollector raceLapCollector) {
        int n = this.isBestLap(raceLapCollector);
        int n2 = this.isWorstLap(raceLapCollector);
        if (n == -1) {
            this.bestLap = raceLapCollector;
            this.worstLap = raceLapCollector;
            this.updateBestLap(raceLapCollector);
            this.updateWorstLap(raceLapCollector);
        } else if (n > 0) {
            this.bestLap = raceLapCollector;
            Iterator iterator = this.laps.iterator();
            while (iterator.hasNext()) {
                RaceLapCollector raceLapCollector2 = (RaceLapCollector)iterator.next();
                raceLapCollector2.setDeviationTime(raceLapCollector2.lapTime - this.bestLap.lapTime);
            }
            this.worstLap.setDeviationTime(this.worstLap.lapTime - this.bestLap.lapTime);
            this.updateWorstLap(this.worstLap);
            this.updateBestLap(raceLapCollector);
        } else if (n2 > 0) {
            this.worstLap = raceLapCollector;
            raceLapCollector.setDeviationTime(raceLapCollector.lapTime - this.bestLap.lapTime);
            this.updateWorstLap(raceLapCollector);
        } else {
            raceLapCollector.setDeviationTime(raceLapCollector.lapTime - this.bestLap.lapTime);
        }
        this.totalTime += raceLapCollector.lapTime;
        this.avgTime = this.totalTime / this.noOfLaps;
        AbstractASLTarget.writeIntegerToDatapool(10379, this.totalTime);
        AbstractASLTarget.writeIntegerToDatapool(10384, this.avgTime);
        AbstractASLTarget.writeIntegerToDatapool(10386, this.avgTime - this.bestLap.lapTime);
    }

    private void updateWorstLap(RaceLapCollector raceLapCollector) {
        AbstractASLTarget.writeIntegerToDatapool(10380, raceLapCollector.lapNo);
        AbstractASLTarget.writeIntegerToDatapool(10383, raceLapCollector.lapTime);
        AbstractASLTarget.writeIntegerToDatapool(10385, raceLapCollector.deviationTime);
    }

    private void updateBestLap(RaceLapCollector raceLapCollector) {
        AbstractASLTarget.writeIntegerToDatapool(10381, raceLapCollector.lapNo);
        AbstractASLTarget.writeIntegerToDatapool(10382, raceLapCollector.lapTime);
    }

    private int isBestLap(RaceLapCollector raceLapCollector) {
        int n = -2;
        if (this.bestLap == null) {
            n = -1;
        } else if (raceLapCollector.lapTime < this.bestLap.lapTime) {
            n = 1;
        } else if (raceLapCollector.lapTime == this.bestLap.lapTime) {
            n = 0;
        }
        return n;
    }

    private int isWorstLap(RaceLapCollector raceLapCollector) {
        int n = -1;
        if (this.worstLap == null || raceLapCollector.lapTime > this.worstLap.lapTime) {
            n = 1;
        } else if (raceLapCollector.lapTime == this.worstLap.lapTime) {
            n = 0;
        }
        return n;
    }

    public int getNoOfLaps() {
        return this.noOfLaps;
    }

    public int getTotalRaceTime() {
        return this.totalTime;
    }

    public int getBestLapNo() {
        return this.bestLap.lapNo;
    }

    public int getWorstLapNo() {
        return this.worstLap.lapNo;
    }

    public int getBestLapTime() {
        return this.bestLap == null ? 0 : this.bestLap.lapTime;
    }

    public int getWorstLapTime() {
        return this.worstLap == null ? 0 : this.worstLap.lapTime;
    }

    public int getAverageLapTime() {
        return this.avgTime;
    }

    public void addLap(boolean bl, int n, int n2, int n3, int n4) {
    }

    public RaceLapCollector getLapNo(int n) {
        RaceLapCollector raceLapCollector = null;
        Iterator iterator = this.laps.iterator();
        while (iterator.hasNext()) {
            RaceLapCollector raceLapCollector2 = (RaceLapCollector)iterator.next();
            if (raceLapCollector2.lapNo != n) continue;
            raceLapCollector = raceLapCollector2;
            break;
        }
        return raceLapCollector;
    }
}

