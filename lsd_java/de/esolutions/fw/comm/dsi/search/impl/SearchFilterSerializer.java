/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.TokenSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.Token;

public class SearchFilterSerializer {
    public static void putOptionalSearchFilter(ISerializer iSerializer, SearchFilter searchFilter) {
        boolean bl = searchFilter == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int[] nArray = searchFilter.getMatchInTokens();
            iSerializer.putOptionalInt32VarArray(nArray);
            Token[] tokenArray = searchFilter.getTokenBasedFilters();
            TokenSerializer.putOptionalTokenVarArray(iSerializer, tokenArray);
            int n = searchFilter.getEntryFlagMask();
            iSerializer.putInt32(n);
            int[] nArray2 = searchFilter.getEntryTypeFilter();
            iSerializer.putOptionalInt32VarArray(nArray2);
        }
    }

    public static void putOptionalSearchFilterVarArray(ISerializer iSerializer, SearchFilter[] searchFilterArray) {
        boolean bl = searchFilterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchFilterArray.length);
            for (int i2 = 0; i2 < searchFilterArray.length; ++i2) {
                SearchFilterSerializer.putOptionalSearchFilter(iSerializer, searchFilterArray[i2]);
            }
        }
    }

    public static SearchFilter getOptionalSearchFilter(IDeserializer iDeserializer) {
        SearchFilter searchFilter = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            searchFilter = new SearchFilter();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            searchFilter.matchInTokens = nArray;
            Token[] tokenArray = TokenSerializer.getOptionalTokenVarArray(iDeserializer);
            searchFilter.tokenBasedFilters = tokenArray;
            searchFilter.entryFlagMask = n = iDeserializer.getInt32();
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            searchFilter.entryTypeFilter = nArray2;
        }
        return searchFilter;
    }

    public static SearchFilter[] getOptionalSearchFilterVarArray(IDeserializer iDeserializer) {
        SearchFilter[] searchFilterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchFilterArray = new SearchFilter[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchFilterArray[i2] = SearchFilterSerializer.getOptionalSearchFilter(iDeserializer);
            }
        }
        return searchFilterArray;
    }
}

