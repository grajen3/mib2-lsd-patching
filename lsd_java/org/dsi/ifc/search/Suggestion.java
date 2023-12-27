/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class Suggestion {
    public String query;
    public String suggestion;
    public String fullSuggestion;

    public Suggestion() {
        this.query = null;
        this.suggestion = null;
        this.fullSuggestion = null;
    }

    public Suggestion(String string, String string2, String string3) {
        this.query = string;
        this.suggestion = string2;
        this.fullSuggestion = string3;
    }

    public String getQuery() {
        return this.query;
    }

    public String getSuggestion() {
        return this.suggestion;
    }

    public String getFullSuggestion() {
        return this.fullSuggestion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("Suggestion");
        stringBuffer.append('(');
        stringBuffer.append("query");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.query);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("suggestion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.suggestion);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullSuggestion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fullSuggestion);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

