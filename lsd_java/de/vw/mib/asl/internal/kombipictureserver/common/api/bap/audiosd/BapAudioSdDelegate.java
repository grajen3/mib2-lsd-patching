/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService;

public interface BapAudioSdDelegate {
    public static final int BAP_AUDIO_SD_ACTIVE_SOURCE;
    public static final int BAP_AUDIO_SD_CURRENT_STATION_HANDLE;
    public static final int[] BAP_AUDIO_SD_PROPERTIES;

    default public void updateBapAudioSd(BapAudioSdService bapAudioSdService, int n) {
    }

    static {
        BAP_AUDIO_SD_PROPERTIES = new int[]{16, 22};
    }
}

