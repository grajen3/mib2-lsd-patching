/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.PhoneticEntry;

public class PhoneticEntrySerializer {
    public static void putOptionalPhoneticEntry(ISerializer iSerializer, PhoneticEntry phoneticEntry) {
        boolean bl = phoneticEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = phoneticEntry.getAlphabet();
            iSerializer.putOptionalString(string);
            String string2 = phoneticEntry.getLanguage();
            iSerializer.putOptionalString(string2);
            String string3 = phoneticEntry.getTranscription();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalPhoneticEntryVarArray(ISerializer iSerializer, PhoneticEntry[] phoneticEntryArray) {
        boolean bl = phoneticEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(phoneticEntryArray.length);
            for (int i2 = 0; i2 < phoneticEntryArray.length; ++i2) {
                PhoneticEntrySerializer.putOptionalPhoneticEntry(iSerializer, phoneticEntryArray[i2]);
            }
        }
    }

    public static PhoneticEntry getOptionalPhoneticEntry(IDeserializer iDeserializer) {
        PhoneticEntry phoneticEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            phoneticEntry = new PhoneticEntry();
            phoneticEntry.alphabet = string3 = iDeserializer.getOptionalString();
            phoneticEntry.language = string2 = iDeserializer.getOptionalString();
            phoneticEntry.transcription = string = iDeserializer.getOptionalString();
        }
        return phoneticEntry;
    }

    public static PhoneticEntry[] getOptionalPhoneticEntryVarArray(IDeserializer iDeserializer) {
        PhoneticEntry[] phoneticEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            phoneticEntryArray = new PhoneticEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                phoneticEntryArray[i2] = PhoneticEntrySerializer.getOptionalPhoneticEntry(iDeserializer);
            }
        }
        return phoneticEntryArray;
    }
}

