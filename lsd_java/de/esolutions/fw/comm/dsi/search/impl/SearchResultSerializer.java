/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.CountrySerializer;
import de.esolutions.fw.comm.dsi.search.impl.NavPositionSerializer;
import de.esolutions.fw.comm.dsi.search.impl.SuggestionSerializer;
import de.esolutions.fw.comm.dsi.search.impl.TokenSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public class SearchResultSerializer {
    public static void putOptionalSearchResult(ISerializer iSerializer, SearchResult searchResult) {
        boolean bl = searchResult == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = searchResult.getQueryId();
            iSerializer.putInt32(n);
            int n2 = searchResult.getSource();
            iSerializer.putInt32(n2);
            int n3 = searchResult.getListPosition();
            iSerializer.putInt32(n3);
            int n4 = searchResult.getEntryType();
            iSerializer.putInt32(n4);
            int n5 = searchResult.getEntryFlags();
            iSerializer.putInt32(n5);
            int n6 = searchResult.getPoiType();
            iSerializer.putInt32(n6);
            int n7 = searchResult.getIconID();
            iSerializer.putInt32(n7);
            NavPosition navPosition = searchResult.getPosition();
            NavPositionSerializer.putOptionalNavPosition(iSerializer, navPosition);
            int n8 = searchResult.getDistanceMeters();
            iSerializer.putInt32(n8);
            long l = searchResult.getDataId();
            iSerializer.putInt64(l);
            Token[] tokenArray = searchResult.getTokens();
            TokenSerializer.putOptionalTokenVarArray(iSerializer, tokenArray);
            Suggestion suggestion = searchResult.getSuggestion();
            SuggestionSerializer.putOptionalSuggestion(iSerializer, suggestion);
            Country country = searchResult.getCountry();
            CountrySerializer.putOptionalCountry(iSerializer, country);
            byte[] byArray = searchResult.getApplicationData();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalSearchResultVarArray(ISerializer iSerializer, SearchResult[] searchResultArray) {
        boolean bl = searchResultArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(searchResultArray.length);
            for (int i2 = 0; i2 < searchResultArray.length; ++i2) {
                SearchResultSerializer.putOptionalSearchResult(iSerializer, searchResultArray[i2]);
            }
        }
    }

    public static SearchResult getOptionalSearchResult(IDeserializer iDeserializer) {
        SearchResult searchResult = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            Country country;
            Suggestion suggestion;
            long l;
            int n;
            NavPosition navPosition;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            searchResult = new SearchResult();
            searchResult.queryId = n8 = iDeserializer.getInt32();
            searchResult.source = n7 = iDeserializer.getInt32();
            searchResult.listPosition = n6 = iDeserializer.getInt32();
            searchResult.entryType = n5 = iDeserializer.getInt32();
            searchResult.entryFlags = n4 = iDeserializer.getInt32();
            searchResult.poiType = n3 = iDeserializer.getInt32();
            searchResult.iconID = n2 = iDeserializer.getInt32();
            searchResult.position = navPosition = NavPositionSerializer.getOptionalNavPosition(iDeserializer);
            searchResult.distanceMeters = n = iDeserializer.getInt32();
            searchResult.dataId = l = iDeserializer.getInt64();
            Token[] tokenArray = TokenSerializer.getOptionalTokenVarArray(iDeserializer);
            searchResult.tokens = tokenArray;
            searchResult.suggestion = suggestion = SuggestionSerializer.getOptionalSuggestion(iDeserializer);
            searchResult.country = country = CountrySerializer.getOptionalCountry(iDeserializer);
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            searchResult.applicationData = byArray;
        }
        return searchResult;
    }

    public static SearchResult[] getOptionalSearchResultVarArray(IDeserializer iDeserializer) {
        SearchResult[] searchResultArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            searchResultArray = new SearchResult[n];
            for (int i2 = 0; i2 < n; ++i2) {
                searchResultArray[i2] = SearchResultSerializer.getOptionalSearchResult(iDeserializer);
            }
        }
        return searchResultArray;
    }
}

