/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public class SearchResult {
    public int queryId;
    public int source;
    public int listPosition;
    public int entryType;
    public int entryFlags;
    public int poiType;
    public int iconID;
    public NavPosition position;
    public int distanceMeters;
    public long dataId;
    public Token[] tokens;
    public Suggestion suggestion;
    public Country country;
    public byte[] applicationData;

    public SearchResult() {
        this.queryId = -1;
        this.source = -1;
        this.listPosition = 0;
        this.entryType = -1;
        this.entryFlags = 0;
        this.poiType = -1;
        this.iconID = -1;
        this.position = null;
        this.distanceMeters = -1;
        this.dataId = 0L;
        this.tokens = null;
        this.suggestion = null;
        this.country = null;
        this.applicationData = null;
    }

    public SearchResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, NavPosition navPosition, int n8, long l, Token[] tokenArray, Suggestion suggestion, Country country, byte[] byArray) {
        this.queryId = n;
        this.source = n2;
        this.listPosition = n3;
        this.entryType = n4;
        this.entryFlags = n5;
        this.poiType = n6;
        this.iconID = n7;
        this.position = navPosition;
        this.distanceMeters = n8;
        this.dataId = l;
        this.tokens = tokenArray;
        this.suggestion = suggestion;
        this.country = country;
        this.applicationData = byArray;
    }

    public int getQueryId() {
        return this.queryId;
    }

    public int getSource() {
        return this.source;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    public int getEntryType() {
        return this.entryType;
    }

    public int getEntryFlags() {
        return this.entryFlags;
    }

    public int getPoiType() {
        return this.poiType;
    }

    public int getIconID() {
        return this.iconID;
    }

    public NavPosition getPosition() {
        return this.position;
    }

    public int getDistanceMeters() {
        return this.distanceMeters;
    }

    public long getDataId() {
        return this.dataId;
    }

    public Token[] getTokens() {
        return this.tokens;
    }

    public Country getCountry() {
        return this.country;
    }

    public Suggestion getSuggestion() {
        return this.suggestion;
    }

    public byte[] getApplicationData() {
        return this.applicationData;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(3650);
        stringBuffer.append("SearchResult");
        stringBuffer.append('(');
        stringBuffer.append("queryId");
        stringBuffer.append('=');
        stringBuffer.append(this.queryId);
        stringBuffer.append(',');
        stringBuffer.append("source");
        stringBuffer.append('=');
        stringBuffer.append(this.source);
        stringBuffer.append(',');
        stringBuffer.append("listPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.listPosition);
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append(this.entryType);
        stringBuffer.append(',');
        stringBuffer.append("entryFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.entryFlags);
        stringBuffer.append(',');
        stringBuffer.append("poiType");
        stringBuffer.append('=');
        stringBuffer.append(this.poiType);
        stringBuffer.append(',');
        stringBuffer.append("iconID");
        stringBuffer.append('=');
        stringBuffer.append(this.iconID);
        stringBuffer.append(',');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("distanceMeters");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceMeters);
        stringBuffer.append(',');
        stringBuffer.append("dataId");
        stringBuffer.append('=');
        stringBuffer.append(this.dataId);
        stringBuffer.append(',');
        stringBuffer.append("tokens");
        stringBuffer.append('[');
        if (this.tokens != null) {
            stringBuffer.append(this.tokens.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.tokens != null) {
            n3 = this.tokens.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.tokens[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.tokens);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("suggestion");
        stringBuffer.append('=');
        stringBuffer.append(this.suggestion);
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append(this.country);
        stringBuffer.append(',');
        stringBuffer.append("applicationData");
        stringBuffer.append('[');
        if (this.applicationData != null) {
            stringBuffer.append(this.applicationData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.applicationData != null) {
            n3 = this.applicationData.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.applicationData[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.applicationData);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

