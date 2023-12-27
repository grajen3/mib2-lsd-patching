/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.ListEntryExt;

public class ListEntryExtSerializer {
    public static void putOptionalListEntryExt(ISerializer iSerializer, ListEntryExt listEntryExt) {
        boolean bl = listEntryExt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = listEntryExt.getAlbum();
            iSerializer.putOptionalString(string);
            long l = listEntryExt.getAlbumID();
            iSerializer.putInt64(l);
            String string2 = listEntryExt.getArtist();
            iSerializer.putOptionalString(string2);
            long l2 = listEntryExt.getArtistID();
            iSerializer.putInt64(l2);
            ResourceLocator resourceLocator = listEntryExt.getCoverArtResource();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            long l3 = listEntryExt.getTitleID();
            iSerializer.putInt64(l3);
            int n = listEntryExt.getFileCount();
            iSerializer.putInt32(n);
            int n2 = listEntryExt.getFolderCount();
            iSerializer.putInt32(n2);
            int n3 = listEntryExt.getPlaylistCount();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalListEntryExtVarArray(ISerializer iSerializer, ListEntryExt[] listEntryExtArray) {
        boolean bl = listEntryExtArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(listEntryExtArray.length);
            for (int i2 = 0; i2 < listEntryExtArray.length; ++i2) {
                ListEntryExtSerializer.putOptionalListEntryExt(iSerializer, listEntryExtArray[i2]);
            }
        }
    }

    public static ListEntryExt getOptionalListEntryExt(IDeserializer iDeserializer) {
        ListEntryExt listEntryExt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            long l;
            ResourceLocator resourceLocator;
            long l2;
            String string;
            long l3;
            String string2;
            listEntryExt = new ListEntryExt();
            listEntryExt.album = string2 = iDeserializer.getOptionalString();
            listEntryExt.albumID = l3 = iDeserializer.getInt64();
            listEntryExt.artist = string = iDeserializer.getOptionalString();
            listEntryExt.artistID = l2 = iDeserializer.getInt64();
            listEntryExt.coverArtResource = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            listEntryExt.titleID = l = iDeserializer.getInt64();
            listEntryExt.fileCount = n3 = iDeserializer.getInt32();
            listEntryExt.folderCount = n2 = iDeserializer.getInt32();
            listEntryExt.playlistCount = n = iDeserializer.getInt32();
        }
        return listEntryExt;
    }

    public static ListEntryExt[] getOptionalListEntryExtVarArray(IDeserializer iDeserializer) {
        ListEntryExt[] listEntryExtArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            listEntryExtArray = new ListEntryExt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                listEntryExtArray[i2] = ListEntryExtSerializer.getOptionalListEntryExt(iDeserializer);
            }
        }
        return listEntryExtArray;
    }
}

