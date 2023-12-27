/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.FolderEntry;

public class FolderEntrySerializer {
    public static void putOptionalFolderEntry(ISerializer iSerializer, FolderEntry folderEntry) {
        boolean bl = folderEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = folderEntry.getFolderID();
            iSerializer.putInt32(n);
            int n2 = folderEntry.getParentFolderID();
            iSerializer.putInt32(n2);
            int n3 = folderEntry.getFolderType();
            iSerializer.putInt32(n3);
            String string = folderEntry.getFolderName();
            iSerializer.putOptionalString(string);
            int n4 = folderEntry.getUnreadMessageCount();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalFolderEntryVarArray(ISerializer iSerializer, FolderEntry[] folderEntryArray) {
        boolean bl = folderEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(folderEntryArray.length);
            for (int i2 = 0; i2 < folderEntryArray.length; ++i2) {
                FolderEntrySerializer.putOptionalFolderEntry(iSerializer, folderEntryArray[i2]);
            }
        }
    }

    public static FolderEntry getOptionalFolderEntry(IDeserializer iDeserializer) {
        FolderEntry folderEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            int n3;
            int n4;
            folderEntry = new FolderEntry();
            folderEntry.folderID = n4 = iDeserializer.getInt32();
            folderEntry.parentFolderID = n3 = iDeserializer.getInt32();
            folderEntry.folderType = n2 = iDeserializer.getInt32();
            folderEntry.folderName = string = iDeserializer.getOptionalString();
            folderEntry.unreadMessageCount = n = iDeserializer.getInt32();
        }
        return folderEntry;
    }

    public static FolderEntry[] getOptionalFolderEntryVarArray(IDeserializer iDeserializer) {
        FolderEntry[] folderEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            folderEntryArray = new FolderEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                folderEntryArray[i2] = FolderEntrySerializer.getOptionalFolderEntry(iDeserializer);
            }
        }
        return folderEntryArray;
    }
}

