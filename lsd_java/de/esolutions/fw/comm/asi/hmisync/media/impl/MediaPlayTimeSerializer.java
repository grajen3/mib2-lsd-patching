/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaPlayTimeSerializer {
    public static void putOptionalMediaPlayTime(ISerializer iSerializer, MediaPlayTime mediaPlayTime) {
        boolean bl = mediaPlayTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = mediaPlayTime.getId();
            iSerializer.putInt64(l);
            int n = mediaPlayTime.getTime();
            iSerializer.putInt32(n);
            int n2 = mediaPlayTime.getTotalTime();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalMediaPlayTimeVarArray(ISerializer iSerializer, MediaPlayTime[] mediaPlayTimeArray) {
        boolean bl = mediaPlayTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaPlayTimeArray.length);
            for (int i2 = 0; i2 < mediaPlayTimeArray.length; ++i2) {
                MediaPlayTimeSerializer.putOptionalMediaPlayTime(iSerializer, mediaPlayTimeArray[i2]);
            }
        }
    }

    public static MediaPlayTime getOptionalMediaPlayTime(IDeserializer iDeserializer) {
        MediaPlayTime mediaPlayTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            mediaPlayTime = new MediaPlayTime();
            mediaPlayTime.id = l = iDeserializer.getInt64();
            mediaPlayTime.time = n2 = iDeserializer.getInt32();
            mediaPlayTime.totalTime = n = iDeserializer.getInt32();
        }
        return mediaPlayTime;
    }

    public static MediaPlayTime[] getOptionalMediaPlayTimeVarArray(IDeserializer iDeserializer) {
        MediaPlayTime[] mediaPlayTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaPlayTimeArray = new MediaPlayTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaPlayTimeArray[i2] = MediaPlayTimeSerializer.getOptionalMediaPlayTime(iDeserializer);
            }
        }
        return mediaPlayTimeArray;
    }
}

