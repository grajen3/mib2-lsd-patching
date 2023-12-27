/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;

public interface ASIHMISyncTVReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateStationInfo(StationInfo[] stationInfoArray, boolean bl) {
    }

    default public void updateActiveStationInfo(ActiveStationInfo activeStationInfo, boolean bl) {
    }

    default public void updateActiveTVStationState(long l, boolean bl) {
    }

    default public void updateTunerConfig(long l, boolean bl) {
    }

    default public void updatePanelKeySet(KeySet[] keySetArray, boolean bl) {
    }

    default public void updateSeekStatus(byte by, boolean bl) {
    }

    default public void updateTerminalMode(byte by, boolean bl) {
    }

    default public void updateParentalSettings(ParentalSettings parentalSettings, boolean bl) {
    }
}

