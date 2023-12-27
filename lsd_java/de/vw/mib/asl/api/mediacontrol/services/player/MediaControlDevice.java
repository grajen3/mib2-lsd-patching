/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.player;

import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlActiveTrack;

public class MediaControlDevice {
    public static final int DEVICETYPE_UNKNOWN;
    public static final int DEVICETYPE_MIB_APP;
    public String deviceID;
    public String deviceName;
    public int deviceType;
    public MediaControlActiveTrack activeTrack;
    public int playbackState;
    public int volume;
}

