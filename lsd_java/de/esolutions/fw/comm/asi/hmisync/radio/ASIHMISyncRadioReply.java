/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;

public interface ASIHMISyncRadioReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void stationDetailsUpdated(CurrentStation[] currentStationArray) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateBandList(int[] nArray, boolean bl) {
    }

    default public void updateActiveBand(int n, boolean bl) {
    }

    default public void updateRadioStationList(StationInfo[] stationInfoArray, boolean bl) {
    }

    default public void updateActiveStation(CurrentStation currentStation, boolean bl) {
    }

    default public void updateSeekStatus(int n, boolean bl) {
    }

    default public void updateWavebands(WavebandInfo[] wavebandInfoArray, boolean bl) {
    }
}

