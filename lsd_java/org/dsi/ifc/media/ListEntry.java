/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.media.ListEntryExt;

public class ListEntry {
    public long entryID;
    public String filename;
    public String title;
    public int contentType;
    public int secLength;
    public int flags;
    public ListEntryExt extInfo;

    public ListEntry() {
        this.entryID = 0L;
        this.filename = null;
        this.title = null;
        this.contentType = 0;
        this.secLength = 0;
        this.flags = 0;
        this.extInfo = null;
    }

    public ListEntry(long l, String string, String string2, int n, int n2, int n3, ListEntryExt listEntryExt) {
        this.entryID = l;
        this.filename = string;
        this.title = string2;
        this.contentType = n;
        this.secLength = n2;
        this.flags = n3;
        this.extInfo = listEntryExt;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getTitle() {
        return this.title;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getSecLength() {
        return this.secLength;
    }

    public int getFlags() {
        return this.flags;
    }

    public ListEntryExt getExtInfo() {
        return this.extInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("ListEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("filename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.filename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("contentType");
        stringBuffer.append('=');
        stringBuffer.append(this.contentType);
        stringBuffer.append(',');
        stringBuffer.append("secLength");
        stringBuffer.append('=');
        stringBuffer.append(this.secLength);
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(',');
        stringBuffer.append("extInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.extInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

