/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class LIStreetHistoryEntrySerializer {
    public static void putOptionalLIStreetHistoryEntry(ISerializer iSerializer, LIStreetHistoryEntry lIStreetHistoryEntry) {
        boolean bl = lIStreetHistoryEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = lIStreetHistoryEntry.getName();
            iSerializer.putOptionalString(string);
            long l = lIStreetHistoryEntry.getId();
            iSerializer.putInt64(l);
            LIExtData[] lIExtDataArray = lIStreetHistoryEntry.getExtendedData();
            LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
        }
    }

    public static void putOptionalLIStreetHistoryEntryVarArray(ISerializer iSerializer, LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        boolean bl = lIStreetHistoryEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lIStreetHistoryEntryArray.length);
            for (int i2 = 0; i2 < lIStreetHistoryEntryArray.length; ++i2) {
                LIStreetHistoryEntrySerializer.putOptionalLIStreetHistoryEntry(iSerializer, lIStreetHistoryEntryArray[i2]);
            }
        }
    }

    public static LIStreetHistoryEntry getOptionalLIStreetHistoryEntry(IDeserializer iDeserializer) {
        LIStreetHistoryEntry lIStreetHistoryEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            String string;
            lIStreetHistoryEntry = new LIStreetHistoryEntry();
            lIStreetHistoryEntry.name = string = iDeserializer.getOptionalString();
            lIStreetHistoryEntry.id = l = iDeserializer.getInt64();
            LIExtData[] lIExtDataArray = LIExtDataSerializer.getOptionalLIExtDataVarArray(iDeserializer);
            lIStreetHistoryEntry.extendedData = lIExtDataArray;
        }
        return lIStreetHistoryEntry;
    }

    public static LIStreetHistoryEntry[] getOptionalLIStreetHistoryEntryVarArray(IDeserializer iDeserializer) {
        LIStreetHistoryEntry[] lIStreetHistoryEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lIStreetHistoryEntryArray = new LIStreetHistoryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lIStreetHistoryEntryArray[i2] = LIStreetHistoryEntrySerializer.getOptionalLIStreetHistoryEntry(iDeserializer);
            }
        }
        return lIStreetHistoryEntryArray;
    }
}

