/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;

public class LIStateHistoryEntrySerializer {
    public static void putOptionalLIStateHistoryEntry(ISerializer iSerializer, LIStateHistoryEntry lIStateHistoryEntry) {
        boolean bl = lIStateHistoryEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = lIStateHistoryEntry.getName();
            iSerializer.putOptionalString(string);
            boolean bl2 = lIStateHistoryEntry.isCitiesInState();
            iSerializer.putBool(bl2);
            long l = lIStateHistoryEntry.getId();
            iSerializer.putInt64(l);
            LIExtData[] lIExtDataArray = lIStateHistoryEntry.getExtendedData();
            LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
        }
    }

    public static void putOptionalLIStateHistoryEntryVarArray(ISerializer iSerializer, LIStateHistoryEntry[] lIStateHistoryEntryArray) {
        boolean bl = lIStateHistoryEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lIStateHistoryEntryArray.length);
            for (int i2 = 0; i2 < lIStateHistoryEntryArray.length; ++i2) {
                LIStateHistoryEntrySerializer.putOptionalLIStateHistoryEntry(iSerializer, lIStateHistoryEntryArray[i2]);
            }
        }
    }

    public static LIStateHistoryEntry getOptionalLIStateHistoryEntry(IDeserializer iDeserializer) {
        LIStateHistoryEntry lIStateHistoryEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            boolean bl2;
            String string;
            lIStateHistoryEntry = new LIStateHistoryEntry();
            lIStateHistoryEntry.name = string = iDeserializer.getOptionalString();
            lIStateHistoryEntry.citiesInState = bl2 = iDeserializer.getBool();
            lIStateHistoryEntry.id = l = iDeserializer.getInt64();
            LIExtData[] lIExtDataArray = LIExtDataSerializer.getOptionalLIExtDataVarArray(iDeserializer);
            lIStateHistoryEntry.extendedData = lIExtDataArray;
        }
        return lIStateHistoryEntry;
    }

    public static LIStateHistoryEntry[] getOptionalLIStateHistoryEntryVarArray(IDeserializer iDeserializer) {
        LIStateHistoryEntry[] lIStateHistoryEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lIStateHistoryEntryArray = new LIStateHistoryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lIStateHistoryEntryArray[i2] = LIStateHistoryEntrySerializer.getOptionalLIStateHistoryEntry(iDeserializer);
            }
        }
        return lIStateHistoryEntryArray;
    }
}

