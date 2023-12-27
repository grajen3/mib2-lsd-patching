/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;

public interface ASIHMISyncCarSportChronoReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseRecordData(SCData[] sCDataArray, int n) {
    }

    default public void responseTrackData(int n, SCData[] sCDataArray, int n2) {
    }

    default public void responseInitTrackTransfer(int n, int n2) {
    }

    default public void responseSetTrackData(int n, int n2) {
    }

    default public void responseSetReferenceLap(int n, int n2) {
    }

    default public void responseReferenceLapData(int n, SCRefLapData[] sCRefLapDataArray, int n2) {
    }

    default public void responseSaveReferenceLap(int n) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateSCVisibilityState(int n, boolean bl) {
    }

    default public void updateActiveRecord(SCHeader sCHeader, boolean bl) {
    }

    default public void updateActiveRecordData(SCData sCData, boolean bl) {
    }

    default public void updateRecordMode(int n, boolean bl) {
    }

    default public void updateTrackList(SCHeader[] sCHeaderArray, boolean bl) {
    }

    default public void updateTransferState(TransferState transferState, boolean bl) {
    }

    default public void updateRecordingTime(long l, boolean bl) {
    }

    default public void updateRecordingRange(RecordingRange recordingRange, boolean bl) {
    }

    default public void updateSelectedReferenceLapUid(int n, boolean bl) {
    }

    default public void updateReferenceLapList(SCRefLapHeader[] sCRefLapHeaderArray, boolean bl) {
    }
}

