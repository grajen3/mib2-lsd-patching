/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService;

public interface RadioStationArtDelegate {
    public static final int RADIO_STATION_ART_FM_STATION_ART;
    public static final int RADIO_STATION_ART_FM_STATION_ART__RESOURCE_LOCATOR;
    public static final int RADIO_STATION_ART_FM_STATION_ART__VALID;
    public static final int RADIO_STATION_ART_DAB_STATION_ART;
    public static final int RADIO_STATION_ART_DAB_STATION_ART__RESOURCE_LOCATOR;
    public static final int RADIO_STATION_ART_DAB_STATION_ART__VALID;
    public static final int RADIO_STATION_ART_AM_STATION_ART;
    public static final int RADIO_STATION_ART_AM_STATION_ART__RESOURCE_LOCATOR;
    public static final int RADIO_STATION_ART_AM_STATION_ART__VALID;
    public static final int RADIO_STATION_ART_SAT_STATION_ART;
    public static final int RADIO_STATION_ART_SAT_STATION_ART__RESOURCE_LOCATOR;
    public static final int RADIO_STATION_ART_SAT_STATION_ART__VALID;
    public static final int[] RADIO_STATION_ART_PROPERTIES;

    default public void updateRadioStationArt(RadioStationArtService radioStationArtService, int n) {
    }

    static {
        RADIO_STATION_ART_PROPERTIES = new int[]{-1, -2, -3, -4, -5, -6, -7, -8};
    }
}

