/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.TrackData;

public class TrackDataSerializer {
    public static void putOptionalTrackData(ISerializer iSerializer, TrackData trackData) {
        boolean bl = trackData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = trackData.getSource();
            iSerializer.putOptionalString(string);
            String string2 = trackData.getTitle();
            iSerializer.putOptionalString(string2);
            int n = trackData.getDuration();
            iSerializer.putInt32(n);
            String string3 = trackData.getAlbum();
            iSerializer.putOptionalString(string3);
            String string4 = trackData.getArtist();
            iSerializer.putOptionalString(string4);
            String string5 = trackData.getPlaylistNum();
            iSerializer.putOptionalString(string5);
            String string6 = trackData.getSongid();
            iSerializer.putOptionalString(string6);
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
            String string6;
            trackData = new TrackData();
            trackData.source = string6 = iDeserializer.getOptionalString();
            trackData.title = string5 = iDeserializer.getOptionalString();
            trackData.duration = n = iDeserializer.getInt32();
            trackData.album = string4 = iDeserializer.getOptionalString();
            trackData.artist = string3 = iDeserializer.getOptionalString();
            trackData.playlistNum = string2 = iDeserializer.getOptionalString();
            trackData.songid = string = iDeserializer.getOptionalString();
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

