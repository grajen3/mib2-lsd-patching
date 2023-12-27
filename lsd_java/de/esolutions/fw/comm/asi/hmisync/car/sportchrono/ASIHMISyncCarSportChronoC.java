/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;

public interface ASIHMISyncCarSportChronoC {
    default public void requestRecordData(long l, long l2) {
    }

    default public void setRecord(int n) {
    }

    default public void requestTrackData(int n) {
    }

    default public void initTrackTransfer(SCHeader sCHeader, String string) {
    }

    default public void setTrackData(int n, SCData[] sCDataArray, int n2) {
    }

    default public void setReferenceLap(int n) {
    }

    default public void requestReferenceLapData(int n) {
    }

    default public void saveReferenceLap(int n, short s) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

