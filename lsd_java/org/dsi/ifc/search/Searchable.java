/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class Searchable {
    public int wordType;
    public String token;
    public int tokenPostProcessing;

    public Searchable() {
        this.wordType = -1;
        this.token = null;
        this.tokenPostProcessing = 0;
    }

    public Searchable(int n, String string) {
        this.wordType = n;
        this.token = string;
        this.tokenPostProcessing = 0;
    }

    public Searchable(int n, String string, int n2) {
        this.wordType = n;
        this.token = string;
        this.tokenPostProcessing = n2;
    }

    public int getWordType() {
        return this.wordType;
    }

    public String getToken() {
        return this.token;
    }

    public int getTokenPostProcessing() {
        return this.tokenPostProcessing;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Searchable");
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
        stringBuffer.append("tokenPostProcessing");
        stringBuffer.append('=');
        stringBuffer.append(this.tokenPostProcessing);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

