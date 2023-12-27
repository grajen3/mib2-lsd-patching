/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm;

import de.vw.mib.asl.internal.radio.amfm.AmfmControllerBase;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;

public class AmFmControllerJapan
extends AmfmControllerBase {
    private StationNameFreqList stationNameFreqList = null;

    @Override
    public StationNameFreqList getStationNameFreqList() {
        if (null == this.stationNameFreqList) {
            this.stationNameFreqList = new StationNameFreqList();
        }
        return this.stationNameFreqList;
    }
}

