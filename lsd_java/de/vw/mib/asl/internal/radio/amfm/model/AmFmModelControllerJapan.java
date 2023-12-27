/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.model;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.model.AmFmModelControllerBase;

public class AmFmModelControllerJapan
extends AmFmModelControllerBase {
    @Override
    public String getAmStationName(AmFmStation amFmStation) {
        StationNameFreqList stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList();
        String string = "";
        if (null != stationNameFreqList && (string = stationNameFreqList.getStationName(amFmStation.getFrequency())) == null) {
            string = "";
        }
        return string;
    }
}

