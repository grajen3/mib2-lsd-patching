/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.exbox.listener;

import de.vw.mib.asl.api.exboxm.audioinformation.ExbocAudioInformationAdapter;
import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxASLDataAdapter;

public class ExboxAudioInformationDataListener
extends ExbocAudioInformationAdapter {
    private ExboxASLDataAdapter exboxService;

    public ExboxAudioInformationDataListener(ExboxASLDataAdapter exboxASLDataAdapter) {
        this.exboxService = exboxASLDataAdapter;
    }

    @Override
    public void onAudioSourceChanges(int n) {
        this.exboxService.onAudioSourceChanges(n);
    }

    @Override
    public void onStationInfoDataUpdate(StationInfoData stationInfoData) {
        this.exboxService.onStationInfoDataUpdate(stationInfoData);
    }
}

