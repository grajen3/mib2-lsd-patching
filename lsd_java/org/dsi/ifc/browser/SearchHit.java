/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class SearchHit {
    public String title;
    public String snippet;
    public String file;

    public SearchHit() {
        this.title = null;
        this.snippet = null;
        this.file = null;
    }

    public SearchHit(String string, String string2, String string3) {
        this.title = string;
        this.snippet = string2;
        this.file = string3;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public void setSnippet(String string) {
        this.snippet = string;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String string) {
        this.file = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SearchHit");
        stringBuffer.append('(');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("snippet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.snippet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("file");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.file);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

