/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class SearchListEntry {
    public long searchID;
    public long entryID;
    public String description;
    public int tagType;
    public int flags;

    public SearchListEntry() {
        this.searchID = 0L;
        this.entryID = 0L;
        this.description = null;
        this.tagType = 0;
        this.flags = 0;
    }

    public SearchListEntry(long l, long l2, String string, int n, int n2) {
        this.searchID = l;
        this.entryID = l2;
        this.description = string;
        this.tagType = n;
        this.flags = n2;
    }

    public long getSearchID() {
        return this.searchID;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getDescription() {
        return this.description;
    }

    public int getTagType() {
        return this.tagType;
    }

    public int getFlags() {
        return this.flags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("SearchListEntry");
        stringBuffer.append('(');
        stringBuffer.append("searchID");
        stringBuffer.append('=');
        stringBuffer.append(this.searchID);
        stringBuffer.append(',');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tagType");
        stringBuffer.append('=');
        stringBuffer.append(this.tagType);
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

