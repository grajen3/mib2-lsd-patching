/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.SearchListEntryExt;

public class SearchListEntryExtSerializer {
    public static void putOptionalSearchListEntryExt(ISerializer iSerializer, SearchListEntryExt searchListEntryExt) {
        boolean bl = searchListEntryExt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = searchListEntryExt.getSearchID();
            iSerializer.putInt64(l);
            long l2 = searchListEntryExt.getEntryID();
            iSerializer.putInt64(l2);
            String string = searchListEntryExt.getDescription();
            iSerializer.putOptionalString(string);
            int n = searchListEntryExt.getTagType();
            iSerializer.putInt32(n);
            long l3 = searchListEntryExt.getArtistID();
            iSerializer.putInt64(l3);
            String string2 = searchListEntryExt.getArtist();
            iSerializer.putOptionalString(string2);
            long l4 = searchListEntryExt.getAlbumID();
            iSerializer.putInt64(l4);
            String string3 = searchListEntryExt.getAlbum();
            iSerializer.putOptionalString(string3);
            int n2 = searchListEntryExt.getFlags();
            iSerializer.putInt32(n2);
            ResourceLocator resourceLocator = searchListEntryExt.getCoverArtResource();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalSearchListEntryExtVarArray(ISerializer iSerializer, SearchListEntryExt[] searchListEntryExtArray) {
        boolean bl = searchListEntryExtArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchListEntryExtArray.length);
            for (int i2 = 0; i2 < searchListEntryExtArray.length; ++i2) {
                SearchListEntryExtSerializer.putOptionalSearchListEntryExt(iSerializer, searchListEntryExtArray[i2]);
            }
        }
    }

    public static SearchListEntryExt getOptionalSearchListEntryExt(IDeserializer iDeserializer) {
        SearchListEntryExt searchListEntryExt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            String string;
            long l;
            String string2;
            long l2;
            int n2;
            String string3;
            long l3;
            long l4;
            searchListEntryExt = new SearchListEntryExt();
            searchListEntryExt.searchID = l4 = iDeserializer.getInt64();
            searchListEntryExt.entryID = l3 = iDeserializer.getInt64();
            searchListEntryExt.description = string3 = iDeserializer.getOptionalString();
            searchListEntryExt.tagType = n2 = iDeserializer.getInt32();
            searchListEntryExt.artistID = l2 = iDeserializer.getInt64();
            searchListEntryExt.artist = string2 = iDeserializer.getOptionalString();
            searchListEntryExt.albumID = l = iDeserializer.getInt64();
            searchListEntryExt.album = string = iDeserializer.getOptionalString();
            searchListEntryExt.flags = n = iDeserializer.getInt32();
            searchListEntryExt.coverArtResource = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return searchListEntryExt;
    }

    public static SearchListEntryExt[] getOptionalSearchListEntryExtVarArray(IDeserializer iDeserializer) {
        SearchListEntryExt[] searchListEntryExtArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchListEntryExtArray = new SearchListEntryExt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchListEntryExtArray[i2] = SearchListEntryExtSerializer.getOptionalSearchListEntryExt(iDeserializer);
            }
        }
        return searchListEntryExtArray;
    }
}

