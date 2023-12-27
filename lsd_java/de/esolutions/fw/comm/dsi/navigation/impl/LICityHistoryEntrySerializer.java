/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.LIExtDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIExtData;

public class LICityHistoryEntrySerializer {
    public static void putOptionalLICityHistoryEntry(ISerializer iSerializer, LICityHistoryEntry lICityHistoryEntry) {
        boolean bl = lICityHistoryEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = lICityHistoryEntry.getName();
            iSerializer.putOptionalString(string);
            boolean bl2 = lICityHistoryEntry.isStreetsInCity();
            iSerializer.putBool(bl2);
            long l = lICityHistoryEntry.getId();
            iSerializer.putInt64(l);
            LIExtData[] lIExtDataArray = lICityHistoryEntry.getExtendedData();
            LIExtDataSerializer.putOptionalLIExtDataVarArray(iSerializer, lIExtDataArray);
        }
    }

    public static void putOptionalLICityHistoryEntryVarArray(ISerializer iSerializer, LICityHistoryEntry[] lICityHistoryEntryArray) {
        boolean bl = lICityHistoryEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lICityHistoryEntryArray.length);
            for (int i2 = 0; i2 < lICityHistoryEntryArray.length; ++i2) {
                LICityHistoryEntrySerializer.putOptionalLICityHistoryEntry(iSerializer, lICityHistoryEntryArray[i2]);
            }
        }
    }

    public static LICityHistoryEntry getOptionalLICityHistoryEntry(IDeserializer iDeserializer) {
        LICityHistoryEntry lICityHistoryEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            boolean bl2;
            String string;
            lICityHistoryEntry = new LICityHistoryEntry();
            lICityHistoryEntry.name = string = iDeserializer.getOptionalString();
            lICityHistoryEntry.streetsInCity = bl2 = iDeserializer.getBool();
            lICityHistoryEntry.id = l = iDeserializer.getInt64();
            LIExtData[] lIExtDataArray = LIExtDataSerializer.getOptionalLIExtDataVarArray(iDeserializer);
            lICityHistoryEntry.extendedData = lIExtDataArray;
        }
        return lICityHistoryEntry;
    }

    public static LICityHistoryEntry[] getOptionalLICityHistoryEntryVarArray(IDeserializer iDeserializer) {
        LICityHistoryEntry[] lICityHistoryEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lICityHistoryEntryArray = new LICityHistoryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lICityHistoryEntryArray[i2] = LICityHistoryEntrySerializer.getOptionalLICityHistoryEntry(iDeserializer);
            }
        }
        return lICityHistoryEntryArray;
    }
}

