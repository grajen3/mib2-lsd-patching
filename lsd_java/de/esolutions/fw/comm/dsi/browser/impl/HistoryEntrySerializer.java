/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.global.DateTime;

public class HistoryEntrySerializer {
    public static void putOptionalHistoryEntry(ISerializer iSerializer, HistoryEntry historyEntry) {
        boolean bl = historyEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DateTime dateTime = historyEntry.getTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            String string = historyEntry.getUrl();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalHistoryEntryVarArray(ISerializer iSerializer, HistoryEntry[] historyEntryArray) {
        boolean bl = historyEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(historyEntryArray.length);
            for (int i2 = 0; i2 < historyEntryArray.length; ++i2) {
                HistoryEntrySerializer.putOptionalHistoryEntry(iSerializer, historyEntryArray[i2]);
            }
        }
    }

    public static HistoryEntry getOptionalHistoryEntry(IDeserializer iDeserializer) {
        HistoryEntry historyEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            DateTime dateTime;
            historyEntry = new HistoryEntry();
            historyEntry.time = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            historyEntry.url = string = iDeserializer.getOptionalString();
        }
        return historyEntry;
    }

    public static HistoryEntry[] getOptionalHistoryEntryVarArray(IDeserializer iDeserializer) {
        HistoryEntry[] historyEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            historyEntryArray = new HistoryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                historyEntryArray[i2] = HistoryEntrySerializer.getOptionalHistoryEntry(iDeserializer);
            }
        }
        return historyEntryArray;
    }
}

