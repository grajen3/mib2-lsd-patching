/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.upnp.ListEntry;

public class ListEntrySerializer {
    public static void putOptionalListEntry(ISerializer iSerializer, ListEntry listEntry) {
        boolean bl = listEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = listEntry.getEntryID();
            iSerializer.putOptionalString(string);
            String string2 = listEntry.getFilename();
            iSerializer.putOptionalString(string2);
            String string3 = listEntry.getTitle();
            iSerializer.putOptionalString(string3);
            int n = listEntry.getContentType();
            iSerializer.putInt32(n);
            int n2 = listEntry.getSecLength();
            iSerializer.putInt32(n2);
            int n3 = listEntry.getFlags();
            iSerializer.putInt32(n3);
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
            int n;
            int n2;
            int n3;
            String string;
            String string2;
            String string3;
            listEntry = new ListEntry();
            listEntry.entryID = string3 = iDeserializer.getOptionalString();
            listEntry.filename = string2 = iDeserializer.getOptionalString();
            listEntry.title = string = iDeserializer.getOptionalString();
            listEntry.contentType = n3 = iDeserializer.getInt32();
            listEntry.secLength = n2 = iDeserializer.getInt32();
            listEntry.flags = n = iDeserializer.getInt32();
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

