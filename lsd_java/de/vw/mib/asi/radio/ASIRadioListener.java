/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.vw.mib.asi.ASIListener;

public interface ASIRadioListener
extends ASIListener {
    default public void updateActiveBand(int n, boolean bl) {
    }

    default public void updateActiveStation(CurrentStation currentStation, boolean bl) {
    }

    default public void updateBandList(int[] nArray, boolean bl) {
    }

    default public void updateRadioStationList(StationInfo[] stationInfoArray, boolean bl) {
    }

    default public void updateSeekStatus(int n, boolean bl) {
    }
}

