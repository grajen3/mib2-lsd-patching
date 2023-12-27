/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.audioinformation;

public interface StationInfoData {
    public static final int STATION_INFO_TYPE_ALBUM;
    public static final int STATION_INFO_TYPE_ANY_TYPE_UNKNOWN;
    public static final int STATION_INFO_TYPE_ARTIST;
    public static final int STATION_INFO_TYPE_AUDIO_FILE;
    public static final int STATION_INFO_TYPE_AUDIO_FOLDER;
    public static final int STATION_INFO_TYPE_FOLDER;
    public static final int STATION_INFO_TYPE_PLAYLIST;
    public static final int STATION_INFO_TYPE_PLAYLIST_FOLDER;
    public static final int STATION_INFO_TYPE_RADIO_STATION;
    public static final int STATION_INFO_TYPE_TITLE;
    public static final int STATION_INFO_TYPE_TRACK;

    default public int getPrimaryID() {
    }

    default public String getPrimaryInfo() {
    }

    default public int getPrimaryInfoType() {
    }

    default public String getQuaternaryInfo() {
    }

    default public int getQuaternaryInfoType() {
    }

    default public String getSecondaryInfo() {
    }

    default public int getSecondaryInfoType() {
    }

    default public String getTertiaryInfo() {
    }

    default public int getTertiaryInfoType() {
    }
}

