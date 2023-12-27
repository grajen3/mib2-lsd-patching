/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaBrowserSelectionDataSerializer {
    public static void putOptionalMediaBrowserSelectionData(ISerializer iSerializer, MediaBrowserSelectionData mediaBrowserSelectionData) {
        boolean bl = mediaBrowserSelectionData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mediaBrowserSelectionData.getBrowserInstance();
            iSerializer.putInt32(n);
            long l = mediaBrowserSelectionData.getTrackID();
            iSerializer.putInt64(l);
            boolean bl2 = mediaBrowserSelectionData.isSeamless();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalMediaBrowserSelectionDataVarArray(ISerializer iSerializer, MediaBrowserSelectionData[] mediaBrowserSelectionDataArray) {
        boolean bl = mediaBrowserSelectionDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaBrowserSelectionDataArray.length);
            for (int i2 = 0; i2 < mediaBrowserSelectionDataArray.length; ++i2) {
                MediaBrowserSelectionDataSerializer.putOptionalMediaBrowserSelectionData(iSerializer, mediaBrowserSelectionDataArray[i2]);
            }
        }
    }

    public static MediaBrowserSelectionData getOptionalMediaBrowserSelectionData(IDeserializer iDeserializer) {
        MediaBrowserSelectionData mediaBrowserSelectionData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            long l;
            int n;
            mediaBrowserSelectionData = new MediaBrowserSelectionData();
            mediaBrowserSelectionData.browserInstance = n = iDeserializer.getInt32();
            mediaBrowserSelectionData.trackID = l = iDeserializer.getInt64();
            mediaBrowserSelectionData.seamless = bl2 = iDeserializer.getBool();
        }
        return mediaBrowserSelectionData;
    }

    public static MediaBrowserSelectionData[] getOptionalMediaBrowserSelectionDataVarArray(IDeserializer iDeserializer) {
        MediaBrowserSelectionData[] mediaBrowserSelectionDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaBrowserSelectionDataArray = new MediaBrowserSelectionData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaBrowserSelectionDataArray[i2] = MediaBrowserSelectionDataSerializer.getOptionalMediaBrowserSelectionData(iDeserializer);
            }
        }
        return mediaBrowserSelectionDataArray;
    }
}

