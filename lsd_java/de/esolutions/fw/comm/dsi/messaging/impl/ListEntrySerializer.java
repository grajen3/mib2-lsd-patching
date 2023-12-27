/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.messaging.impl.FolderEntrySerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.MessageListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageListEntry;

public class ListEntrySerializer {
    public static void putOptionalListEntry(ISerializer iSerializer, ListEntry listEntry) {
        boolean bl = listEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = listEntry.getListEntryId();
            iSerializer.putInt64(l);
            int n = listEntry.getType();
            iSerializer.putInt32(n);
            FolderEntry folderEntry = listEntry.getFolderEntry();
            FolderEntrySerializer.putOptionalFolderEntry(iSerializer, folderEntry);
            MessageListEntry messageListEntry = listEntry.getMessageListEntry();
            MessageListEntrySerializer.putOptionalMessageListEntry(iSerializer, messageListEntry);
        }
    }

    public static void putOptionalListEntryVarArray(ISerializer iSerializer, ListEntry[] listEntryArray) {
        boolean bl = listEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(listEntryArray.length);
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                ListEntrySerializer.putOptionalListEntry(iSerializer, listEntryArray[i2]);
            }
        }
    }

    public static ListEntry getOptionalListEntry(IDeserializer iDeserializer) {
        ListEntry listEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            MessageListEntry messageListEntry;
            FolderEntry folderEntry;
            int n;
            long l;
            listEntry = new ListEntry();
            listEntry.listEntryId = l = iDeserializer.getInt64();
            listEntry.type = n = iDeserializer.getInt32();
            listEntry.folderEntry = folderEntry = FolderEntrySerializer.getOptionalFolderEntry(iDeserializer);
            listEntry.messageListEntry = messageListEntry = MessageListEntrySerializer.getOptionalMessageListEntry(iDeserializer);
        }
        return listEntry;
    }

    public static ListEntry[] getOptionalListEntryVarArray(IDeserializer iDeserializer) {
        ListEntry[] listEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            listEntryArray = new ListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                listEntryArray[i2] = ListEntrySerializer.getOptionalListEntry(iDeserializer);
            }
        }
        return listEntryArray;
    }
}

