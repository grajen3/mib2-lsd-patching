/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiainput.WordDatabase;

public class WordDatabaseSerializer {
    public static void putOptionalWordDatabase(ISerializer iSerializer, WordDatabase wordDatabase) {
        boolean bl = wordDatabase == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = wordDatabase.getName();
            iSerializer.putOptionalString(string);
            int n = wordDatabase.getPriority();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalWordDatabaseVarArray(ISerializer iSerializer, WordDatabase[] wordDatabaseArray) {
        boolean bl = wordDatabaseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wordDatabaseArray.length);
            for (int i2 = 0; i2 < wordDatabaseArray.length; ++i2) {
                WordDatabaseSerializer.putOptionalWordDatabase(iSerializer, wordDatabaseArray[i2]);
            }
        }
    }

    public static WordDatabase getOptionalWordDatabase(IDeserializer iDeserializer) {
        WordDatabase wordDatabase = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            wordDatabase = new WordDatabase();
            wordDatabase.name = string = iDeserializer.getOptionalString();
            wordDatabase.priority = n = iDeserializer.getInt32();
        }
        return wordDatabase;
    }

    public static WordDatabase[] getOptionalWordDatabaseVarArray(IDeserializer iDeserializer) {
        WordDatabase[] wordDatabaseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wordDatabaseArray = new WordDatabase[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wordDatabaseArray[i2] = WordDatabaseSerializer.getOptionalWordDatabase(iDeserializer);
            }
        }
        return wordDatabaseArray;
    }
}

