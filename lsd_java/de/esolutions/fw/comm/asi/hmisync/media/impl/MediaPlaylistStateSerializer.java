/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaPlaylistStateSerializer {
    public static void putOptionalMediaPlaylistState(ISerializer iSerializer, MediaPlaylistState mediaPlaylistState) {
        boolean bl = mediaPlaylistState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mediaPlaylistState.getFlags();
            iSerializer.putInt32(n);
            long l = mediaPlaylistState.getId();
            iSerializer.putInt64(l);
            int n2 = mediaPlaylistState.getSize();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalMediaPlaylistStateVarArray(ISerializer iSerializer, MediaPlaylistState[] mediaPlaylistStateArray) {
        boolean bl = mediaPlaylistStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaPlaylistStateArray.length);
            for (int i2 = 0; i2 < mediaPlaylistStateArray.length; ++i2) {
                MediaPlaylistStateSerializer.putOptionalMediaPlaylistState(iSerializer, mediaPlaylistStateArray[i2]);
            }
        }
    }

    public static MediaPlaylistState getOptionalMediaPlaylistState(IDeserializer iDeserializer) {
        MediaPlaylistState mediaPlaylistState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            int n2;
            mediaPlaylistState = new MediaPlaylistState();
            mediaPlaylistState.flags = n2 = iDeserializer.getInt32();
            mediaPlaylistState.id = l = iDeserializer.getInt64();
            mediaPlaylistState.size = n = iDeserializer.getInt32();
        }
        return mediaPlaylistState;
    }

    public static MediaPlaylistState[] getOptionalMediaPlaylistStateVarArray(IDeserializer iDeserializer) {
        MediaPlaylistState[] mediaPlaylistStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaPlaylistStateArray = new MediaPlaylistState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaPlaylistStateArray[i2] = MediaPlaylistStateSerializer.getOptionalMediaPlaylistState(iDeserializer);
            }
        }
        return mediaPlaylistStateArray;
    }
}

