/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;

public interface ExboxAudioInformationListener {
    public static final int AUDIO_SOURCE_BLUETOOTH_STREAM;
    public static final int AUDIO_SOURCE_BLUETOOTH_RCP;
    public static final int AUDIO_SOURCE_DMB;
    public static final int AUDIO_SOURCE_NO_SOURCE_ACTIVE;
    public static final int AUDIO_SOURCE_UNKNOWN_SOURCE;

    default public void onAudioSourceChanges(int n) {
    }

    default public void onStationInfoDataUpdate(StationInfoData stationInfoData) {
    }
}

