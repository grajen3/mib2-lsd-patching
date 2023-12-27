/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.global.ResourceLocator;

public class AttachmentInformation {
    public int attachmentID;
    public String name;
    public String mimeType;
    public int size;
    public int entryID;
    public ResourceLocator attachmentPath;

    public AttachmentInformation() {
        this.attachmentID = -1;
        this.name = "";
        this.mimeType = "";
        this.size = 0;
        this.entryID = -1;
        this.attachmentPath = new ResourceLocator();
    }

    public AttachmentInformation(int n, String string, String string2, int n2, int n3, ResourceLocator resourceLocator) {
        this.attachmentID = n;
        this.name = string;
        this.mimeType = string2;
        this.size = n2;
        this.entryID = n3;
        this.attachmentPath = resourceLocator;
    }

    public int getAttachmentID() {
        return this.attachmentID;
    }

    public String getName() {
        return this.name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getSize() {
        return this.size;
    }

    public int getEntryID() {
        return this.entryID;
    }

    public ResourceLocator getAttachmentPath() {
        return this.attachmentPath;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1350);
        stringBuffer.append("AttachmentInformation");
        stringBuffer.append('(');
        stringBuffer.append("attachmentID");
        stringBuffer.append('=');
        stringBuffer.append(this.attachmentID);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mimeType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mimeType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("size");
        stringBuffer.append('=');
        stringBuffer.append(this.size);
        stringBuffer.append(',');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("attachmentPath");
        stringBuffer.append('=');
        stringBuffer.append(this.attachmentPath);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

