/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.PhonemeData;

public class PhonemeDataSerializer {
    public static void putOptionalPhonemeData(ISerializer iSerializer, PhonemeData phonemeData) {
        boolean bl = phonemeData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = phonemeData.getAlphabet();
            iSerializer.putOptionalString(string);
            String string2 = phonemeData.getPhoneme();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalPhonemeDataVarArray(ISerializer iSerializer, PhonemeData[] phonemeDataArray) {
        boolean bl = phonemeDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(phonemeDataArray.length);
            for (int i2 = 0; i2 < phonemeDataArray.length; ++i2) {
                PhonemeDataSerializer.putOptionalPhonemeData(iSerializer, phonemeDataArray[i2]);
            }
        }
    }

    public static PhonemeData getOptionalPhonemeData(IDeserializer iDeserializer) {
        PhonemeData phonemeData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            phonemeData = new PhonemeData();
            phonemeData.alphabet = string2 = iDeserializer.getOptionalString();
            phonemeData.phoneme = string = iDeserializer.getOptionalString();
        }
        return phonemeData;
    }

    public static PhonemeData[] getOptionalPhonemeDataVarArray(IDeserializer iDeserializer) {
        PhonemeData[] phonemeDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            phonemeDataArray = new PhonemeData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                phonemeDataArray[i2] = PhonemeDataSerializer.getOptionalPhonemeData(iDeserializer);
            }
        }
        return phonemeDataArray;
    }
}

