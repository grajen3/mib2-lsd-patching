/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaI18NStringSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class MediaEntrySerializer {
    public static void putOptionalMediaEntry(ISerializer iSerializer, MediaEntry mediaEntry) {
        boolean bl = mediaEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = mediaEntry.getId();
            iSerializer.putInt64(l);
            int n = mediaEntry.getType();
            iSerializer.putInt32(n);
            MediaI18NString mediaI18NString = mediaEntry.getTitle();
            MediaI18NStringSerializer.putOptionalMediaI18NString(iSerializer, mediaI18NString);
            MediaI18NString mediaI18NString2 = mediaEntry.getArtist();
            MediaI18NStringSerializer.putOptionalMediaI18NString(iSerializer, mediaI18NString2);
            long l2 = mediaEntry.getArtistID();
            iSerializer.putInt64(l2);
            MediaI18NString mediaI18NString3 = mediaEntry.getAlbum();
            MediaI18NStringSerializer.putOptionalMediaI18NString(iSerializer, mediaI18NString3);
            long l3 = mediaEntry.getAlbumID();
            iSerializer.putInt64(l3);
            long l4 = mediaEntry.getGenreID();
            iSerializer.putInt64(l4);
            String string = mediaEntry.getCoverUrl();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalMediaEntryVarArray(ISerializer iSerializer, MediaEntry[] mediaEntryArray) {
        boolean bl = mediaEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediaEntryArray.length);
            for (int i2 = 0; i2 < mediaEntryArray.length; ++i2) {
                MediaEntrySerializer.putOptionalMediaEntry(iSerializer, mediaEntryArray[i2]);
            }
        }
    }

    public static MediaEntry getOptionalMediaEntry(IDeserializer iDeserializer) {
        MediaEntry mediaEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            long l2;
            MediaI18NString mediaI18NString;
            long l3;
            MediaI18NString mediaI18NString2;
            MediaI18NString mediaI18NString3;
            int n;
            long l4;
            mediaEntry = new MediaEntry();
            mediaEntry.id = l4 = iDeserializer.getInt64();
            mediaEntry.type = n = iDeserializer.getInt32();
            mediaEntry.title = mediaI18NString3 = MediaI18NStringSerializer.getOptionalMediaI18NString(iDeserializer);
            mediaEntry.artist = mediaI18NString2 = MediaI18NStringSerializer.getOptionalMediaI18NString(iDeserializer);
            mediaEntry.artistID = l3 = iDeserializer.getInt64();
            mediaEntry.album = mediaI18NString = MediaI18NStringSerializer.getOptionalMediaI18NString(iDeserializer);
            mediaEntry.albumID = l2 = iDeserializer.getInt64();
            mediaEntry.genreID = l = iDeserializer.getInt64();
            mediaEntry.coverUrl = string = iDeserializer.getOptionalString();
        }
        return mediaEntry;
    }

    public static MediaEntry[] getOptionalMediaEntryVarArray(IDeserializer iDeserializer) {
        MediaEntry[] mediaEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediaEntryArray = new MediaEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediaEntryArray[i2] = MediaEntrySerializer.getOptionalMediaEntry(iDeserializer);
            }
        }
        return mediaEntryArray;
    }
}

