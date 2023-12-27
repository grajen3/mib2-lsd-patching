/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.PhoneticEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.PhoneticEntry;

public class DictionaryEntrySerializer {
    public static void putOptionalDictionaryEntry(ISerializer iSerializer, DictionaryEntry dictionaryEntry) {
        boolean bl = dictionaryEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = dictionaryEntry.getOrthography();
            iSerializer.putOptionalString(string);
            int n = dictionaryEntry.getTtsTransIndex();
            iSerializer.putInt32(n);
            PhoneticEntry[] phoneticEntryArray = dictionaryEntry.getPhoneticList();
            PhoneticEntrySerializer.putOptionalPhoneticEntryVarArray(iSerializer, phoneticEntryArray);
        }
    }

    public static void putOptionalDictionaryEntryVarArray(ISerializer iSerializer, DictionaryEntry[] dictionaryEntryArray) {
        boolean bl = dictionaryEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dictionaryEntryArray.length);
            for (int i2 = 0; i2 < dictionaryEntryArray.length; ++i2) {
                DictionaryEntrySerializer.putOptionalDictionaryEntry(iSerializer, dictionaryEntryArray[i2]);
            }
        }
    }

    public static DictionaryEntry getOptionalDictionaryEntry(IDeserializer iDeserializer) {
        DictionaryEntry dictionaryEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            dictionaryEntry = new DictionaryEntry();
            dictionaryEntry.orthography = string = iDeserializer.getOptionalString();
            dictionaryEntry.ttsTransIndex = n = iDeserializer.getInt32();
            PhoneticEntry[] phoneticEntryArray = PhoneticEntrySerializer.getOptionalPhoneticEntryVarArray(iDeserializer);
            dictionaryEntry.phoneticList = phoneticEntryArray;
        }
        return dictionaryEntry;
    }

    public static DictionaryEntry[] getOptionalDictionaryEntryVarArray(IDeserializer iDeserializer) {
        DictionaryEntry[] dictionaryEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dictionaryEntryArray = new DictionaryEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dictionaryEntryArray[i2] = DictionaryEntrySerializer.getOptionalDictionaryEntry(iDeserializer);
            }
        }
        return dictionaryEntryArray;
    }
}

