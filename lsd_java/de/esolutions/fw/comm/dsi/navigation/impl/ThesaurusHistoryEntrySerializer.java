/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;

public class ThesaurusHistoryEntrySerializer {
    public static void putOptionalThesaurusHistoryEntry(ISerializer iSerializer, ThesaurusHistoryEntry thesaurusHistoryEntry) {
        boolean bl = thesaurusHistoryEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = thesaurusHistoryEntry.getUid();
            iSerializer.putInt32(n);
            String string = thesaurusHistoryEntry.getExpression();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalThesaurusHistoryEntryVarArray(ISerializer iSerializer, ThesaurusHistoryEntry[] thesaurusHistoryEntryArray) {
        boolean bl = thesaurusHistoryEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(thesaurusHistoryEntryArray.length);
            for (int i2 = 0; i2 < thesaurusHistoryEntryArray.length; ++i2) {
                ThesaurusHistoryEntrySerializer.putOptionalThesaurusHistoryEntry(iSerializer, thesaurusHistoryEntryArray[i2]);
            }
        }
    }

    public static ThesaurusHistoryEntry getOptionalThesaurusHistoryEntry(IDeserializer iDeserializer) {
        ThesaurusHistoryEntry thesaurusHistoryEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            thesaurusHistoryEntry = new ThesaurusHistoryEntry();
            thesaurusHistoryEntry.uid = n = iDeserializer.getInt32();
            thesaurusHistoryEntry.expression = string = iDeserializer.getOptionalString();
        }
        return thesaurusHistoryEntry;
    }

    public static ThesaurusHistoryEntry[] getOptionalThesaurusHistoryEntryVarArray(IDeserializer iDeserializer) {
        ThesaurusHistoryEntry[] thesaurusHistoryEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            thesaurusHistoryEntryArray = new ThesaurusHistoryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                thesaurusHistoryEntryArray[i2] = ThesaurusHistoryEntrySerializer.getOptionalThesaurusHistoryEntry(iDeserializer);
            }
        }
        return thesaurusHistoryEntryArray;
    }
}

