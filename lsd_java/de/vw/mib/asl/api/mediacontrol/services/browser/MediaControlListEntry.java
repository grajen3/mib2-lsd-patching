/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.browser;

public class MediaControlListEntry {
    public String entryId;
    public String filename;
    public String title;
    public int contentType;
    public int secLength;
    public int flags;

    public MediaControlListEntry() {
        this.entryId = null;
        this.filename = null;
        this.title = null;
        this.contentType = 0;
        this.secLength = 0;
        this.flags = 0;
    }

    public MediaControlListEntry(String string, String string2, String string3, int n, int n2, int n3) {
        this.entryId = string;
        this.filename = string2;
        this.title = string3;
        this.contentType = n;
        this.secLength = n2;
        this.flags = n3;
    }

    public String getEntryId() {
        return this.entryId;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("ListEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryId);
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

