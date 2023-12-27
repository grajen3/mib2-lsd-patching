/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.vw.mib.asi.ASIListener;

public interface ASITVListener
extends ASIListener {
    default public void updateActiveStationInfo(ActiveStationInfo activeStationInfo, boolean bl) {
    }

    default public void updateActiveTVStationState(long l, boolean bl) {
    }

    default public void updatePanelKeySet(KeySet[] keySetArray, boolean bl) {
    }

    default public void updateParentalSettings(ParentalSettings parentalSettings, boolean bl) {
    }

    default public void updateSeekStatus(byte by, boolean bl) {
    }

    default public void updateStationInfo(StationInfo[] stationInfoArray, boolean bl) {
    }

    default public void updateTerminalMode(byte by, boolean bl) {
    }

    default public void updateTunerConfig(long l, boolean bl) {
    }
}

