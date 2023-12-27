/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.SearchQuery;

public class SearchQuerySerializer {
    public static void putOptionalSearchQuery(ISerializer iSerializer, SearchQuery searchQuery) {
        boolean bl = searchQuery == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = searchQuery.getQueryId();
            iSerializer.putInt32(n);
            int[] nArray = searchQuery.getSources();
            iSerializer.putOptionalInt32VarArray(nArray);
            String string = searchQuery.getNeedle();
            iSerializer.putOptionalString(string);
            String[] stringArray = searchQuery.getAlternativeNeedles();
            iSerializer.putOptionalStringVarArray(stringArray);
            int n2 = searchQuery.getOffset();
            iSerializer.putInt32(n2);
            int n3 = searchQuery.getCount();
            iSerializer.putInt32(n3);
            boolean bl2 = searchQuery.isConflictMode();
            iSerializer.putBool(bl2);
            int n4 = searchQuery.getConflictModeTypes();
            iSerializer.putInt32(n4);
            int n5 = searchQuery.getMatchingMode();
            iSerializer.putInt32(n5);
            int[] nArray2 = searchQuery.getMaxCountPerSource();
            iSerializer.putOptionalInt32VarArray(nArray2);
        }
    }

    public static void putOptionalSearchQueryVarArray(ISerializer iSerializer, SearchQuery[] searchQueryArray) {
        boolean bl = searchQueryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchQueryArray.length);
            for (int i2 = 0; i2 < searchQueryArray.length; ++i2) {
                SearchQuerySerializer.putOptionalSearchQuery(iSerializer, searchQueryArray[i2]);
            }
        }
    }

    public static SearchQuery getOptionalSearchQuery(IDeserializer iDeserializer) {
        SearchQuery searchQuery = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            boolean bl2;
            int n3;
            int n4;
            String string;
            int n5;
            searchQuery = new SearchQuery();
            searchQuery.queryId = n5 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            searchQuery.sources = nArray;
            searchQuery.needle = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            searchQuery.alternativeNeedles = stringArray;
            searchQuery.offset = n4 = iDeserializer.getInt32();
            searchQuery.count = n3 = iDeserializer.getInt32();
            searchQuery.conflictMode = bl2 = iDeserializer.getBool();
            searchQuery.conflictModeTypes = n2 = iDeserializer.getInt32();
            searchQuery.matchingMode = n = iDeserializer.getInt32();
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            searchQuery.maxCountPerSource = nArray2;
        }
        return searchQuery;
    }

    public static SearchQuery[] getOptionalSearchQueryVarArray(IDeserializer iDeserializer) {
        SearchQuery[] searchQueryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchQueryArray = new SearchQuery[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchQueryArray[i2] = SearchQuerySerializer.getOptionalSearchQuery(iDeserializer);
            }
        }
        return searchQueryArray;
    }
}

