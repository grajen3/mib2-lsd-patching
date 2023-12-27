/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class Bookmark {
    public int bookmarkType;
    public String folder;
    public String title;
    public String url;
    public boolean nonerasable;

    public Bookmark() {
    }

    public Bookmark(int n, String string, String string2, String string3, boolean bl) {
        this.bookmarkType = n;
        this.folder = string;
        this.title = string2;
        this.url = string3;
        this.nonerasable = bl;
    }

    public int getBookmarkType() {
        return this.bookmarkType;
    }

    public void setBookmarkType(int n) {
        this.bookmarkType = n;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String string) {
        this.folder = string;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public boolean isNonerasable() {
        return this.nonerasable;
    }

    public void setNonerasable(boolean bl) {
        this.nonerasable = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("Bookmark");
        stringBuffer.append('(');
        stringBuffer.append("bookmarkType");
        stringBuffer.append('=');
        stringBuffer.append(this.bookmarkType);
        stringBuffer.append(',');
        stringBuffer.append("folder");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.folder);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("nonerasable");
        stringBuffer.append('=');
        stringBuffer.append(this.nonerasable);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

