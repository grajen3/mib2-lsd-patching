/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.search.Highlight;

public class Token {
    public int wordType;
    public String token;
    public Highlight[] highlights;

    public Token() {
        this.wordType = -1;
        this.token = null;
        this.highlights = null;
    }

    public Token(int n, String string, Highlight[] highlightArray) {
        this.wordType = n;
        this.token = string;
        this.highlights = highlightArray;
    }

    public int getWordType() {
        return this.wordType;
    }

    public String getToken() {
        return this.token;
    }

    public Highlight[] getHighlights() {
        return this.highlights;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Token");
        stringBuffer.append('(');
        stringBuffer.append("wordType");
        stringBuffer.append('=');
        stringBuffer.append(this.wordType);
        stringBuffer.append(',');
        stringBuffer.append("token");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.token);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("highlights");
        stringBuffer.append('[');
        if (this.highlights != null) {
            stringBuffer.append(this.highlights.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.highlights != null) {
            int n = this.highlights.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.highlights[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.highlights);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

