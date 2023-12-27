/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class SearchQuery {
    public int queryId;
    public int[] sources;
    public String needle;
    public String[] alternativeNeedles;
    public int offset;
    public int count;
    public boolean conflictMode;
    public int conflictModeTypes;
    public int matchingMode;
    public int[] maxCountPerSource;

    public SearchQuery() {
        this.queryId = 0;
        this.sources = null;
        this.needle = null;
        this.alternativeNeedles = null;
        this.offset = 0;
        this.count = 0;
        this.conflictMode = false;
        this.conflictModeTypes = 0;
        this.matchingMode = 0;
        this.maxCountPerSource = null;
    }

    public SearchQuery(int n, int[] nArray, String string, int n2, int n3, boolean bl, int n4, int n5) {
        this.queryId = n;
        this.sources = nArray;
        this.needle = string;
        this.alternativeNeedles = null;
        this.offset = n2;
        this.count = n3;
        this.conflictMode = bl;
        this.conflictModeTypes = n4;
        this.matchingMode = n5;
        this.maxCountPerSource = null;
    }

    public SearchQuery(int n, int[] nArray, String string, String[] stringArray, int n2, int n3, boolean bl, int n4, int n5) {
        this.queryId = n;
        this.sources = nArray;
        this.needle = string;
        this.alternativeNeedles = stringArray;
        this.offset = n2;
        this.count = n3;
        this.conflictMode = bl;
        this.conflictModeTypes = n4;
        this.matchingMode = n5;
        this.maxCountPerSource = null;
    }

    public SearchQuery(int n, int[] nArray, String string, String[] stringArray, int n2, int n3, boolean bl, int n4, int n5, int[] nArray2) {
        this.queryId = n;
        this.sources = nArray;
        this.needle = string;
        this.alternativeNeedles = stringArray;
        this.offset = n2;
        this.count = n3;
        this.conflictMode = bl;
        this.conflictModeTypes = n4;
        this.matchingMode = n5;
        this.maxCountPerSource = nArray2;
    }

    public int getQueryId() {
        return this.queryId;
    }

    public int[] getSources() {
        return this.sources;
    }

    public String getNeedle() {
        return this.needle;
    }

    public String[] getAlternativeNeedles() {
        return this.alternativeNeedles;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getCount() {
        return this.count;
    }

    public int[] getMaxCountPerSource() {
        return this.maxCountPerSource;
    }

    public boolean isConflictMode() {
        return this.conflictMode;
    }

    public int getConflictModeTypes() {
        return this.conflictModeTypes;
    }

    public int getMatchingMode() {
        return this.matchingMode;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("SearchQuery");
        stringBuffer.append('(');
        stringBuffer.append("queryId");
        stringBuffer.append('=');
        stringBuffer.append(this.queryId);
        stringBuffer.append(',');
        stringBuffer.append("sources");
        stringBuffer.append('[');
        if (this.sources != null) {
            stringBuffer.append(this.sources.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.sources != null) {
            n3 = this.sources.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.sources[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.sources);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("needle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.needle);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("alternativeNeedles");
        stringBuffer.append('[');
        if (this.alternativeNeedles != null) {
            stringBuffer.append(this.alternativeNeedles.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.alternativeNeedles != null) {
            n3 = this.alternativeNeedles.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.alternativeNeedles[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.alternativeNeedles);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(',');
        stringBuffer.append("count");
        stringBuffer.append('=');
        stringBuffer.append(this.count);
        stringBuffer.append(',');
        stringBuffer.append("conflictMode");
        stringBuffer.append('=');
        stringBuffer.append(this.conflictMode);
        stringBuffer.append(',');
        stringBuffer.append("conflictModeTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.conflictModeTypes);
        stringBuffer.append(',');
        stringBuffer.append("matchingMode");
        stringBuffer.append('=');
        stringBuffer.append(this.matchingMode);
        stringBuffer.append(',');
        stringBuffer.append("maxCountPerSource");
        stringBuffer.append('[');
        if (this.maxCountPerSource != null) {
            stringBuffer.append(this.maxCountPerSource.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.maxCountPerSource != null) {
            n3 = this.maxCountPerSource.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.maxCountPerSource[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.maxCountPerSource);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

