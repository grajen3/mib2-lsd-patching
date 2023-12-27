/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.SearchListEntry;

public class SearchListEntrySerializer {
    public static void putOptionalSearchListEntry(ISerializer iSerializer, SearchListEntry searchListEntry) {
        boolean bl = searchListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = searchListEntry.getSearchID();
            iSerializer.putInt64(l);
            long l2 = searchListEntry.getEntryID();
            iSerializer.putInt64(l2);
            String string = searchListEntry.getDescription();
            iSerializer.putOptionalString(string);
            int n = searchListEntry.getTagType();
            iSerializer.putInt32(n);
            int n2 = searchListEntry.getFlags();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSearchListEntryVarArray(ISerializer iSerializer, SearchListEntry[] searchListEntryArray) {
        boolean bl = searchListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchListEntryArray.length);
            for (int i2 = 0; i2 < searchListEntryArray.length; ++i2) {
                SearchListEntrySerializer.putOptionalSearchListEntry(iSerializer, searchListEntryArray[i2]);
            }
        }
    }

    public static SearchListEntry getOptionalSearchListEntry(IDeserializer iDeserializer) {
        SearchListEntry searchListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            long l;
            long l2;
            searchListEntry = new SearchListEntry();
            searchListEntry.searchID = l2 = iDeserializer.getInt64();
            searchListEntry.entryID = l = iDeserializer.getInt64();
            searchListEntry.description = string = iDeserializer.getOptionalString();
            searchListEntry.tagType = n2 = iDeserializer.getInt32();
            searchListEntry.flags = n = iDeserializer.getInt32();
        }
        return searchListEntry;
    }

    public static SearchListEntry[] getOptionalSearchListEntryVarArray(IDeserializer iDeserializer) {
        SearchListEntry[] searchListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchListEntryArray = new SearchListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchListEntryArray[i2] = SearchListEntrySerializer.getOptionalSearchListEntry(iDeserializer);
            }
        }
        return searchListEntryArray;
    }
}

