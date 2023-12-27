/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationListener;
import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl;

class ExboxAudioInformationServiceImpl$3
implements Runnable {
    private final /* synthetic */ ExboxAudioInformationListener val$listener;
    private final /* synthetic */ StationInfoData val$newStationData;
    private final /* synthetic */ ExboxAudioInformationServiceImpl this$0;

    ExboxAudioInformationServiceImpl$3(ExboxAudioInformationServiceImpl exboxAudioInformationServiceImpl, ExboxAudioInformationListener exboxAudioInformationListener, StationInfoData stationInfoData) {
        this.this$0 = exboxAudioInformationServiceImpl;
        this.val$listener = exboxAudioInformationListener;
        this.val$newStationData = stationInfoData;
    }

    @Override
    public void run() {
        this.val$listener.onStationInfoDataUpdate(this.val$newStationData);
    }
}

