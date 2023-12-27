/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPPlayer
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DETAILINFO;
    public static final int ATTR_DEVICELIST;
    public static final int ATTR_PLAYBACKMODE;
    public static final int ATTR_PLAYBACKMODELIST;
    public static final int ATTR_PLAYBACKSTATE;
    public static final int ATTR_PLAYPOSITION;
    public static final int ATTR_VOLUME;
    public static final int RT_PAUSE;
    public static final int RT_RESUME;
    public static final int RT_SETENTRY;
    public static final int RT_SETPLAYBACKMODE;
    public static final int RT_SKIP;
    public static final int RT_SEEK;
    public static final int RT_SETVOLUME;
    public static final int RT_INCREASEVOLUME;
    public static final int RT_DECREASEVOLUME;
    public static final int DEVICETYPE_UNKNOWN;
    public static final int DEVICETYPE_MIB_APP;
    public static final int PLAYMODEFLAG_REPEAT;
    public static final int PLAYMODEFLAG_SHUFFLE;
    public static final int PLAYBACKSCOPE_FILE;
    public static final int PLAYBACKSCOPE_DEVICE;
    public static final int PLAYBACKSCOPE_MEDIUM;
    public static final int PLAYBACKSCOPE_SELECTION;
    public static final int PLAYBACKSTATE_INVALID;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEKING;
    public static final int PLAYBACKSTATE_STOPPED_WITH_ERROR;
    public static final int DIRECTION_FW;
    public static final int DIRECTION_BW;
    public static final int SKIP_NEXT_ENTRY;
    public static final int SKIP_PREV_ENTRY;
    public static final int SKIP_BEGIN_ENTRY;
    public static final int PLAYBACKRATE_2X;
    public static final int PLAYBACKRATE_4X;
    public static final int PLAYBACKRATE_8X;
    public static final int PLAYBACKRATE_16X;
    public static final int PLAYBACKRATE_32X;
    public static final int PLAYBACKRATE_1BY2X;
    public static final int PLAYBACKRATE_1BY4X;
    public static final int PLAYBACKRATE_1BY8X;
    public static final int PLAYBACKRATE_1BY16X;
    public static final int PLAYBACKRATE_1BY32X;
    public static final int PLAYBACKRATE_64X;

    default public void setPlaybackMode(String string, int n) {
    }

    default public void setEntry(String[] stringArray, String string, ListEntry[] listEntryArray, int n) {
    }

    default public void resume(String string) {
    }

    default public void pause(String string) {
    }

    default public void skip(String string, int n, int n2) {
    }

    default public void seek(String string, int n, int n2) {
    }

    default public void increaseVolume(String string) {
    }

    default public void decreaseVolume(String string) {
    }

    default public void setVolume(String string, int n) {
    }
}

