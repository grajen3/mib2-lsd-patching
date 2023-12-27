/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class TileListCollector {
    public boolean isAvailableInTheInternet;
    public static final int BEST_AVAILABLE_SOURCE_UNKNOWN;
    public static final int BEST_AVAILABLE_SOURCE_FM;
    public static final int BEST_AVAILABLE_SOURCE_DAB;
    public static final int BEST_AVAILABLE_SOURCE_WEB;
    public int bestAvailableSource;
    public boolean dabStationSupportsSlideShow;
    public int DAB_STATION_STATE_NOT_AVAILABLE = 0;
    public int DAB_STATION_STATE_AVAILABLE = 1;
    public int DAB_STATION_STATE_MAY_NOT_AVAILABLE = 2;
    public int dabStationState;
    public boolean stationIsOnPreset;
    public String stationName = "";
    public boolean isHd;
    public ResourceLocator stationLogo = null;
    public String stationNameFull = "";
    public int listIndex = 0;
    public long frequency = 0L;
    public int subChannelId = 0;
    public int piSid = 0;
    public int ensId = 0;
    public int ecc = 0;
    public int sCIDI = 0;
    public int mode = 0;
    public int sdarsSid = 0;
    public short sdarsStationNumber = 0;
    public boolean isRds = false;
    public boolean isScrollingPs;
    public String originalAmFmStationName;
    public int waveband;
    public int amFmServiceId;
    public String amFmShortNameHd = "";

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Tile stationNameFull: ").append(this.stationNameFull).append(" stationName: ").append(this.stationName).append(" stationLogo: ").append(this.stationLogo).append(" listIndex: ").append(this.listIndex).append(" frequency: ").append(this.frequency).append(" subChannelId: ").append(this.subChannelId).append(" piSid: ").append(this.piSid).append(" ensId: ").append(this.ensId).append(" ecc: ").append(this.ecc).append(" sCIDI: ").append(this.sCIDI).append(" mode: ").append(this.mode).append(" isRds: ").append(this.isRds).append(" sdarsStationNumber: ").append(this.sdarsStationNumber).append(" sdarsSid: ").append(this.sdarsSid);
        return stringBuffer.toString();
    }
}

