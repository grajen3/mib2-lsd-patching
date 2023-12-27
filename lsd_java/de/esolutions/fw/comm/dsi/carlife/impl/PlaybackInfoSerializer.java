/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.PlaybackInfo;

public class PlaybackInfoSerializer {
    public static void putOptionalPlaybackInfo(ISerializer iSerializer, PlaybackInfo playbackInfo) {
        boolean bl = playbackInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = playbackInfo.getStatus();
            iSerializer.putInt32(n);
            String string = playbackInfo.getPlaybackApp();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalPlaybackInfoVarArray(ISerializer iSerializer, PlaybackInfo[] playbackInfoArray) {
        boolean bl = playbackInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(playbackInfoArray.length);
            for (int i2 = 0; i2 < playbackInfoArray.length; ++i2) {
                PlaybackInfoSerializer.putOptionalPlaybackInfo(iSerializer, playbackInfoArray[i2]);
            }
        }
    }

    public static PlaybackInfo getOptionalPlaybackInfo(IDeserializer iDeserializer) {
        PlaybackInfo playbackInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            playbackInfo = new PlaybackInfo();
            playbackInfo.status = n = iDeserializer.getInt32();
            playbackInfo.playbackApp = string = iDeserializer.getOptionalString();
        }
        return playbackInfo;
    }

    public static PlaybackInfo[] getOptionalPlaybackInfoVarArray(IDeserializer iDeserializer) {
        PlaybackInfo[] playbackInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            playbackInfoArray = new PlaybackInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                playbackInfoArray[i2] = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
            }
        }
        return playbackInfoArray;
    }
}

