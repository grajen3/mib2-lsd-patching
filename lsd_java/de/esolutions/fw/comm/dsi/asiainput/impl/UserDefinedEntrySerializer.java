/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiainput.UserDefinedEntry;

public class UserDefinedEntrySerializer {
    public static void putOptionalUserDefinedEntry(ISerializer iSerializer, UserDefinedEntry userDefinedEntry) {
        boolean bl = userDefinedEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = userDefinedEntry.getPhrase();
            iSerializer.putOptionalString(string);
            String string2 = userDefinedEntry.getSpelling();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalUserDefinedEntryVarArray(ISerializer iSerializer, UserDefinedEntry[] userDefinedEntryArray) {
        boolean bl = userDefinedEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(userDefinedEntryArray.length);
            for (int i2 = 0; i2 < userDefinedEntryArray.length; ++i2) {
                UserDefinedEntrySerializer.putOptionalUserDefinedEntry(iSerializer, userDefinedEntryArray[i2]);
            }
        }
    }

    public static UserDefinedEntry getOptionalUserDefinedEntry(IDeserializer iDeserializer) {
        UserDefinedEntry userDefinedEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            userDefinedEntry = new UserDefinedEntry();
            userDefinedEntry.phrase = string2 = iDeserializer.getOptionalString();
            userDefinedEntry.spelling = string = iDeserializer.getOptionalString();
        }
        return userDefinedEntry;
    }

    public static UserDefinedEntry[] getOptionalUserDefinedEntryVarArray(IDeserializer iDeserializer) {
        UserDefinedEntry[] userDefinedEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            userDefinedEntryArray = new UserDefinedEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                userDefinedEntryArray[i2] = UserDefinedEntrySerializer.getOptionalUserDefinedEntry(iDeserializer);
            }
        }
        return userDefinedEntryArray;
    }
}

