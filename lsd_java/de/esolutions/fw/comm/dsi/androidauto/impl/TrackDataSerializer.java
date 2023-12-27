/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.TrackData;

public class TrackDataSerializer {
    public static void putOptionalTrackData(ISerializer iSerializer, TrackData trackData) {
        boolean bl = trackData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = trackData.getTitle();
            iSerializer.putOptionalString(string);
            int n = trackData.getDuration();
            iSerializer.putInt32(n);
            String string2 = trackData.getAlbum();
            iSerializer.putOptionalString(string2);
            String string3 = trackData.getArtist();
            iSerializer.putOptionalString(string3);
            String string4 = trackData.getGenre();
            iSerializer.putOptionalString(string4);
            String string5 = trackData.getComposer();
            iSerializer.putOptionalString(string5);
        }
    }

    public static void putOptionalTrackDataVarArray(ISerializer iSerializer, TrackData[] trackDataArray) {
        boolean bl = trackDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trackDataArray.length);
            for (int i2 = 0; i2 < trackDataArray.length; ++i2) {
                TrackDataSerializer.putOptionalTrackData(iSerializer, trackDataArray[i2]);
            }
        }
    }

    public static TrackData getOptionalTrackData(IDeserializer iDeserializer) {
        TrackData trackData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            int n;
            String string5;
            trackData = new TrackData();
            trackData.title = string5 = iDeserializer.getOptionalString();
            trackData.duration = n = iDeserializer.getInt32();
            trackData.album = string4 = iDeserializer.getOptionalString();
            trackData.artist = string3 = iDeserializer.getOptionalString();
            trackData.genre = string2 = iDeserializer.getOptionalString();
            trackData.composer = string = iDeserializer.getOptionalString();
        }
        return trackData;
    }

    public static TrackData[] getOptionalTrackDataVarArray(IDeserializer iDeserializer) {
        TrackData[] trackDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trackDataArray = new TrackData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trackDataArray[i2] = TrackDataSerializer.getOptionalTrackData(iDeserializer);
            }
        }
        return trackDataArray;
    }
}

