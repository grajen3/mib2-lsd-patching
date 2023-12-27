/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.upnp.PlaybackMode;

public class PlaybackModeSerializer {
    public static void putOptionalPlaybackMode(ISerializer iSerializer, PlaybackMode playbackMode) {
        boolean bl = playbackMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = playbackMode.getModeID();
            iSerializer.putInt32(n);
            int n2 = playbackMode.getScope();
            iSerializer.putInt32(n2);
            int n3 = playbackMode.getModeFlag();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalPlaybackModeVarArray(ISerializer iSerializer, PlaybackMode[] playbackModeArray) {
        boolean bl = playbackModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(playbackModeArray.length);
            for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
                PlaybackModeSerializer.putOptionalPlaybackMode(iSerializer, playbackModeArray[i2]);
            }
        }
    }

    public static PlaybackMode getOptionalPlaybackMode(IDeserializer iDeserializer) {
        PlaybackMode playbackMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            playbackMode = new PlaybackMode();
            playbackMode.modeID = n3 = iDeserializer.getInt32();
            playbackMode.scope = n2 = iDeserializer.getInt32();
            playbackMode.modeFlag = n = iDeserializer.getInt32();
        }
        return playbackMode;
    }

    public static PlaybackMode[] getOptionalPlaybackModeVarArray(IDeserializer iDeserializer) {
        PlaybackMode[] playbackModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            playbackModeArray = new PlaybackMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                playbackModeArray[i2] = PlaybackModeSerializer.getOptionalPlaybackMode(iDeserializer);
            }
        }
        return playbackModeArray;
    }
}

