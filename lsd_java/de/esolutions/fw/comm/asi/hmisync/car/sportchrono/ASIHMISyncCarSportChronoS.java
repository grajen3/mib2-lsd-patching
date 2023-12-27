/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;

public interface ASIHMISyncCarSportChronoS {
    default public void requestRecordData(long l, long l2, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setRecord(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void requestTrackData(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void initTrackTransfer(SCHeader sCHeader, String string, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setTrackData(int n, SCData[] sCDataArray, int n2, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setReferenceLap(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void requestReferenceLapData(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void saveReferenceLap(int n, short s, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setNotification(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void clearNotification(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }
}

