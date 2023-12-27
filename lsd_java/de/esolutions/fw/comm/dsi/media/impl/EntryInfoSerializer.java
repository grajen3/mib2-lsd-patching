/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.ChapterInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.ChapterInfo;
import org.dsi.ifc.media.EntryInfo;

public class EntryInfoSerializer {
    public static void putOptionalEntryInfo(ISerializer iSerializer, EntryInfo entryInfo) {
        boolean bl = entryInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = entryInfo.getEntryID();
            iSerializer.putInt64(l);
            String string = entryInfo.getFilename();
            iSerializer.putOptionalString(string);
            int n = entryInfo.getContentType();
            iSerializer.putInt32(n);
            String string2 = entryInfo.getTitle();
            iSerializer.putOptionalString(string2);
            long l2 = entryInfo.getTrackNo();
            iSerializer.putInt64(l2);
            long l3 = entryInfo.getNumTracks();
            iSerializer.putInt64(l3);
            long l4 = entryInfo.getAlbumID();
            iSerializer.putInt64(l4);
            long l5 = entryInfo.getArtistID();
            iSerializer.putInt64(l5);
            long l6 = entryInfo.getGenreID();
            iSerializer.putInt64(l6);
            String string3 = entryInfo.getAlbum();
            iSerializer.putOptionalString(string3);
            String string4 = entryInfo.getArtist();
            iSerializer.putOptionalString(string4);
            String string5 = entryInfo.getGenre();
            iSerializer.putOptionalString(string5);
            String string6 = entryInfo.getYear();
            iSerializer.putOptionalString(string6);
            String string7 = entryInfo.getComments();
            iSerializer.putOptionalString(string7);
            long l7 = entryInfo.getAvgBitrate();
            iSerializer.putInt64(l7);
            long l8 = entryInfo.getSamplingrate();
            iSerializer.putInt64(l8);
            int n2 = entryInfo.getRating();
            iSerializer.putInt32(n2);
            int n3 = entryInfo.getFlags();
            iSerializer.putInt32(n3);
            ChapterInfo chapterInfo = entryInfo.getChapterInfo();
            ChapterInfoSerializer.putOptionalChapterInfo(iSerializer, chapterInfo);
        }
    }

    public static void putOptionalEntryInfoVarArray(ISerializer iSerializer, EntryInfo[] entryInfoArray) {
        boolean bl = entryInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(entryInfoArray.length);
            for (int i2 = 0; i2 < entryInfoArray.length; ++i2) {
                EntryInfoSerializer.putOptionalEntryInfo(iSerializer, entryInfoArray[i2]);
            }
        }
    }

    public static EntryInfo getOptionalEntryInfo(IDeserializer iDeserializer) {
        EntryInfo entryInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ChapterInfo chapterInfo;
            int n;
            int n2;
            long l;
            long l2;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            long l3;
            long l4;
            long l5;
            long l6;
            long l7;
            String string6;
            int n3;
            String string7;
            long l8;
            entryInfo = new EntryInfo();
            entryInfo.entryID = l8 = iDeserializer.getInt64();
            entryInfo.filename = string7 = iDeserializer.getOptionalString();
            entryInfo.contentType = n3 = iDeserializer.getInt32();
            entryInfo.title = string6 = iDeserializer.getOptionalString();
            entryInfo.trackNo = l7 = iDeserializer.getInt64();
            entryInfo.numTracks = l6 = iDeserializer.getInt64();
            entryInfo.albumID = l5 = iDeserializer.getInt64();
            entryInfo.artistID = l4 = iDeserializer.getInt64();
            entryInfo.genreID = l3 = iDeserializer.getInt64();
            entryInfo.album = string5 = iDeserializer.getOptionalString();
            entryInfo.artist = string4 = iDeserializer.getOptionalString();
            entryInfo.genre = string3 = iDeserializer.getOptionalString();
            entryInfo.year = string2 = iDeserializer.getOptionalString();
            entryInfo.comments = string = iDeserializer.getOptionalString();
            entryInfo.avgBitrate = l2 = iDeserializer.getInt64();
            entryInfo.samplingrate = l = iDeserializer.getInt64();
            entryInfo.rating = n2 = iDeserializer.getInt32();
            entryInfo.flags = n = iDeserializer.getInt32();
            entryInfo.chapterInfo = chapterInfo = ChapterInfoSerializer.getOptionalChapterInfo(iDeserializer);
        }
        return entryInfo;
    }

    public static EntryInfo[] getOptionalEntryInfoVarArray(IDeserializer iDeserializer) {
        EntryInfo[] entryInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            entryInfoArray = new EntryInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                entryInfoArray[i2] = EntryInfoSerializer.getOptionalEntryInfo(iDeserializer);
            }
        }
        return entryInfoArray;
    }
}

