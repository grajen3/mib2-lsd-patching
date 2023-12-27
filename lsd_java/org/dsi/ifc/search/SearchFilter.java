/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.search.Token;

public class SearchFilter {
    public int[] matchInTokens;
    public Token[] tokenBasedFilters;
    public int entryFlagMask;
    public int[] entryTypeFilter;

    public SearchFilter(int[] nArray, Token[] tokenArray, int n, int[] nArray2) {
        this.matchInTokens = nArray;
        this.tokenBasedFilters = tokenArray;
        this.entryFlagMask = n;
        this.entryTypeFilter = nArray2;
    }

    public SearchFilter() {
        this.matchInTokens = null;
        this.tokenBasedFilters = null;
        this.entryFlagMask = 0;
        this.entryTypeFilter = null;
    }

    public int[] getMatchInTokens() {
        return this.matchInTokens;
    }

    public Token[] getTokenBasedFilters() {
        return this.tokenBasedFilters;
    }

    public int getEntryFlagMask() {
        return this.entryFlagMask;
    }

    public int[] getEntryTypeFilter() {
        return this.entryTypeFilter;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SearchFilter");
        stringBuffer.append('(');
        stringBuffer.append("matchInTokens");
        stringBuffer.append('[');
        if (this.matchInTokens != null) {
            stringBuffer.append(this.matchInTokens.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.matchInTokens != null) {
            n3 = this.matchInTokens.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.matchInTokens[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.matchInTokens);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("tokenBasedFilters");
        stringBuffer.append('[');
        if (this.tokenBasedFilters != null) {
            stringBuffer.append(this.tokenBasedFilters.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.tokenBasedFilters != null) {
            n3 = this.tokenBasedFilters.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.tokenBasedFilters[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.tokenBasedFilters);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("entryFlagMask");
        stringBuffer.append('=');
        stringBuffer.append(this.entryFlagMask);
        stringBuffer.append(',');
        stringBuffer.append("entryTypeFilter");
        stringBuffer.append('[');
        if (this.entryTypeFilter != null) {
            stringBuffer.append(this.entryTypeFilter.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.entryTypeFilter != null) {
            n3 = this.entryTypeFilter.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.entryTypeFilter[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.entryTypeFilter);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

