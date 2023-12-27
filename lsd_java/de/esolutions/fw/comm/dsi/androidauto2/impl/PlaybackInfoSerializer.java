/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.PlaybackInfo;

public class PlaybackInfoSerializer {
    public static void putOptionalPlaybackInfo(ISerializer iSerializer, PlaybackInfo playbackInfo) {
        boolean bl = playbackInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = playbackInfo.getStatus();
            iSerializer.putInt32(n);
            int n2 = playbackInfo.getShuffleMode();
            iSerializer.putInt32(n2);
            int n3 = playbackInfo.getRepeatMode();
            iSerializer.putInt32(n3);
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
            int n2;
            int n3;
            playbackInfo = new PlaybackInfo();
            playbackInfo.status = n3 = iDeserializer.getInt32();
            playbackInfo.shuffleMode = n2 = iDeserializer.getInt32();
            playbackInfo.repeatMode = n = iDeserializer.getInt32();
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

