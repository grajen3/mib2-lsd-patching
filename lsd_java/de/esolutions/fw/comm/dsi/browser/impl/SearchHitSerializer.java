/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.SearchHit;

public class SearchHitSerializer {
    public static void putOptionalSearchHit(ISerializer iSerializer, SearchHit searchHit) {
        boolean bl = searchHit == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = searchHit.getTitle();
            iSerializer.putOptionalString(string);
            String string2 = searchHit.getSnippet();
            iSerializer.putOptionalString(string2);
            String string3 = searchHit.getFile();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalSearchHitVarArray(ISerializer iSerializer, SearchHit[] searchHitArray) {
        boolean bl = searchHitArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchHitArray.length);
            for (int i2 = 0; i2 < searchHitArray.length; ++i2) {
                SearchHitSerializer.putOptionalSearchHit(iSerializer, searchHitArray[i2]);
            }
        }
    }

    public static SearchHit getOptionalSearchHit(IDeserializer iDeserializer) {
        SearchHit searchHit = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            searchHit = new SearchHit();
            searchHit.title = string3 = iDeserializer.getOptionalString();
            searchHit.snippet = string2 = iDeserializer.getOptionalString();
            searchHit.file = string = iDeserializer.getOptionalString();
        }
        return searchHit;
    }

    public static SearchHit[] getOptionalSearchHitVarArray(IDeserializer iDeserializer) {
        SearchHit[] searchHitArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchHitArray = new SearchHit[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchHitArray[i2] = SearchHitSerializer.getOptionalSearchHit(iDeserializer);
            }
        }
        return searchHitArray;
    }
}

