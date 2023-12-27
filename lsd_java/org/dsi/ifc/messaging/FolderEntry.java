/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class FolderEntry {
    public int folderID;
    public int parentFolderID;
    public int folderType;
    public String folderName;
    public int unreadMessageCount;

    public FolderEntry() {
        this.folderID = -1;
        this.parentFolderID = -1;
        this.folderType = 0;
        this.folderName = "";
        this.unreadMessageCount = 0;
    }

    public FolderEntry(int n, int n2, int n3, String string, int n4) {
        this.folderID = n;
        this.parentFolderID = n2;
        this.folderType = n3;
        this.folderName = string;
        this.unreadMessageCount = n4;
    }

    public int getFolderID() {
        return this.folderID;
    }

    public int getParentFolderID() {
        return this.parentFolderID;
    }

    public int getFolderType() {
        return this.folderType;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("FolderEntry");
        stringBuffer.append('(');
        stringBuffer.append("folderID");
        stringBuffer.append('=');
        stringBuffer.append(this.folderID);
        stringBuffer.append(',');
        stringBuffer.append("parentFolderID");
        stringBuffer.append('=');
        stringBuffer.append(this.parentFolderID);
        stringBuffer.append(',');
        stringBuffer.append("folderType");
        stringBuffer.append('=');
        stringBuffer.append(this.folderType);
        stringBuffer.append(',');
        stringBuffer.append("folderName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.folderName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("unreadMessageCount");
        stringBuffer.append('=');
        stringBuffer.append(this.unreadMessageCount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

