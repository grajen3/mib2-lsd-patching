/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public class AlbumEntryInfoSerializer {
    public static void putOptionalAlbumEntryInfo(ISerializer iSerializer, AlbumEntryInfo albumEntryInfo) {
        boolean bl = albumEntryInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = albumEntryInfo.getAlbumIdx();
            iSerializer.putInt64(l);
            long l2 = albumEntryInfo.getArtistID();
            iSerializer.putInt64(l2);
            String string = albumEntryInfo.getArtist();
            iSerializer.putOptionalString(string);
            long l3 = albumEntryInfo.getAlbumID();
            iSerializer.putInt64(l3);
            String string2 = albumEntryInfo.getAlbum();
            iSerializer.putOptionalString(string2);
            int n = albumEntryInfo.getFlags();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalAlbumEntryInfoVarArray(ISerializer iSerializer, AlbumEntryInfo[] albumEntryInfoArray) {
        boolean bl = albumEntryInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(albumEntryInfoArray.length);
            for (int i2 = 0; i2 < albumEntryInfoArray.length; ++i2) {
                AlbumEntryInfoSerializer.putOptionalAlbumEntryInfo(iSerializer, albumEntryInfoArray[i2]);
            }
        }
    }

    public static AlbumEntryInfo getOptionalAlbumEntryInfo(IDeserializer iDeserializer) {
        AlbumEntryInfo albumEntryInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            long l;
            String string2;
            long l2;
            long l3;
            albumEntryInfo = new AlbumEntryInfo();
            albumEntryInfo.albumIdx = l3 = iDeserializer.getInt64();
            albumEntryInfo.artistID = l2 = iDeserializer.getInt64();
            albumEntryInfo.artist = string2 = iDeserializer.getOptionalString();
            albumEntryInfo.albumID = l = iDeserializer.getInt64();
            albumEntryInfo.album = string = iDeserializer.getOptionalString();
            albumEntryInfo.flags = n = iDeserializer.getInt32();
        }
        return albumEntryInfo;
    }

    public static AlbumEntryInfo[] getOptionalAlbumEntryInfoVarArray(IDeserializer iDeserializer) {
        AlbumEntryInfo[] albumEntryInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            albumEntryInfoArray = new AlbumEntryInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                albumEntryInfoArray[i2] = AlbumEntryInfoSerializer.getOptionalAlbumEntryInfo(iDeserializer);
            }
        }
        return albumEntryInfoArray;
    }
}

