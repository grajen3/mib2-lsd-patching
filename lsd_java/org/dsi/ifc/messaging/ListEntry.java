/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.MessageListEntry;

public class ListEntry {
    public long listEntryId;
    public int type;
    public FolderEntry folderEntry;
    public MessageListEntry messageListEntry;

    public ListEntry() {
        this.listEntryId = -1L;
        this.type = -1;
        this.folderEntry = null;
        this.messageListEntry = null;
    }

    public ListEntry(long l, int n, FolderEntry folderEntry, MessageListEntry messageListEntry) {
        this.listEntryId = l;
        this.type = n;
        this.folderEntry = folderEntry;
        this.messageListEntry = messageListEntry;
    }

    public long getListEntryId() {
        return this.listEntryId;
    }

    public int getType() {
        return this.type;
    }

    public FolderEntry getFolderEntry() {
        return this.folderEntry;
    }

    public MessageListEntry getMessageListEntry() {
        return this.messageListEntry;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2200);
        stringBuffer.append("ListEntry");
        stringBuffer.append('(');
        stringBuffer.append("listEntryId");
        stringBuffer.append('=');
        stringBuffer.append(this.listEntryId);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("folderEntry");
        stringBuffer.append('=');
        stringBuffer.append(this.folderEntry);
        stringBuffer.append(',');
        stringBuffer.append("messageListEntry");
        stringBuffer.append('=');
        stringBuffer.append(this.messageListEntry);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

