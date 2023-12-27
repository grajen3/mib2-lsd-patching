/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.MediaCapabilitiesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;

public class MediaInfoSerializer {
    public static void putOptionalMediaInfo(ISerializer iSerializer, MediaInfo mediaInfo) {
        boolean bl = mediaInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = mediaInfo.getDeviceID();
            iSerializer.putInt64(l);
            long l2 = mediaInfo.getMediaID();
            iSerializer.putInt64(l2);
            int n = mediaInfo.getMediaType();
            iSerializer.putInt32(n);
            String string = mediaInfo.getUniqueMediaID();
            iSerializer.putOptionalString(string);
            String string2 = mediaInfo.getName();
            iSerializer.putOptionalString(string2);
            String string3 = mediaInfo.getMountPoint();
            iSerializer.putOptionalString(string3);
            int n2 = mediaInfo.getFlags();
            iSerializer.putInt32(n2);
            MediaCapabilities mediaCapabilities = mediaInfo.getMediaCaps();
            MediaCapabilitiesSerializer.putOptionalMediaCapabilities(iSerializer, mediaCapabilities);
        }
    }

    public static void putOptionalMediaInfoVarArray(ISerializer iSerializer, MediaInfo[] mediaInfoArray) {
        boolean bl = mediaInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaInfoArray.length);
            for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
                MediaInfoSerializer.putOptionalMediaInfo(iSerializer, mediaInfoArray[i2]);
            }
        }
    }

    public static MediaInfo getOptionalMediaInfo(IDeserializer iDeserializer) {
        MediaInfo mediaInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            MediaCapabilities mediaCapabilities;
            int n;
            String string;
            String string2;
            String string3;
            int n2;
            long l;
            long l2;
            mediaInfo = new MediaInfo();
            mediaInfo.deviceID = l2 = iDeserializer.getInt64();
            mediaInfo.mediaID = l = iDeserializer.getInt64();
            mediaInfo.mediaType = n2 = iDeserializer.getInt32();
            mediaInfo.uniqueMediaID = string3 = iDeserializer.getOptionalString();
            mediaInfo.name = string2 = iDeserializer.getOptionalString();
            mediaInfo.mountPoint = string = iDeserializer.getOptionalString();
            mediaInfo.flags = n = iDeserializer.getInt32();
            mediaInfo.mediaCaps = mediaCapabilities = MediaCapabilitiesSerializer.getOptionalMediaCapabilities(iDeserializer);
        }
        return mediaInfo;
    }

    public static MediaInfo[] getOptionalMediaInfoVarArray(IDeserializer iDeserializer) {
        MediaInfo[] mediaInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaInfoArray = new MediaInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaInfoArray[i2] = MediaInfoSerializer.getOptionalMediaInfo(iDeserializer);
            }
        }
        return mediaInfoArray;
    }
}

