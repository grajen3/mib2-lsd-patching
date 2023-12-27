/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService;

public interface TvTunerStationArtDelegate {
    public static final int TV_TUNER_STATION_ART_STATION_ART;
    public static final int TV_TUNER_STATION_ART_VALID;
    public static final int[] TV_TUNER_STATION_ART_PROPERTIES;

    default public void updateTvTunerStationArt(TvTunerStationArtService tvTunerStationArtService, int n) {
    }

    static {
        TV_TUNER_STATION_ART_PROPERTIES = new int[]{2494};
    }
}

