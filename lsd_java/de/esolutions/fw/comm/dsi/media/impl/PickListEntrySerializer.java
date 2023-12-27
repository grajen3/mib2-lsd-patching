/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.PickListEntry;

public class PickListEntrySerializer {
    public static void putOptionalPickListEntry(ISerializer iSerializer, PickListEntry pickListEntry) {
        boolean bl = pickListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = pickListEntry.getEntryID();
            iSerializer.putInt64(l);
            String string = pickListEntry.getName();
            iSerializer.putOptionalString(string);
            String string2 = pickListEntry.getAdditionalInfo();
            iSerializer.putOptionalString(string2);
            int n = pickListEntry.getAdditionalInfoEntryFlags();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalPickListEntryVarArray(ISerializer iSerializer, PickListEntry[] pickListEntryArray) {
        boolean bl = pickListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pickListEntryArray.length);
            for (int i2 = 0; i2 < pickListEntryArray.length; ++i2) {
                PickListEntrySerializer.putOptionalPickListEntry(iSerializer, pickListEntryArray[i2]);
            }
        }
    }

    public static PickListEntry getOptionalPickListEntry(IDeserializer iDeserializer) {
        PickListEntry pickListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            long l;
            pickListEntry = new PickListEntry();
            pickListEntry.entryID = l = iDeserializer.getInt64();
            pickListEntry.name = string2 = iDeserializer.getOptionalString();
            pickListEntry.additionalInfo = string = iDeserializer.getOptionalString();
            pickListEntry.additionalInfoEntryFlags = n = iDeserializer.getInt32();
        }
        return pickListEntry;
    }

    public static PickListEntry[] getOptionalPickListEntryVarArray(IDeserializer iDeserializer) {
        PickListEntry[] pickListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pickListEntryArray = new PickListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pickListEntryArray[i2] = PickListEntrySerializer.getOptionalPickListEntry(iDeserializer);
            }
        }
        return pickListEntryArray;
    }
}

