/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.FrequencyInfo;

public class FrequencyInfoSerializer {
    public static void putOptionalFrequencyInfo(ISerializer iSerializer, FrequencyInfo frequencyInfo) {
        boolean bl = frequencyInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = frequencyInfo.getFrequency();
            iSerializer.putInt64(l);
            String string = frequencyInfo.getLabel();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalFrequencyInfoVarArray(ISerializer iSerializer, FrequencyInfo[] frequencyInfoArray) {
        boolean bl = frequencyInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(frequencyInfoArray.length);
            for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                FrequencyInfoSerializer.putOptionalFrequencyInfo(iSerializer, frequencyInfoArray[i2]);
            }
        }
    }

    public static FrequencyInfo getOptionalFrequencyInfo(IDeserializer iDeserializer) {
        FrequencyInfo frequencyInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            frequencyInfo = new FrequencyInfo();
            frequencyInfo.frequency = l = iDeserializer.getInt64();
            frequencyInfo.label = string = iDeserializer.getOptionalString();
        }
        return frequencyInfo;
    }

    public static FrequencyInfo[] getOptionalFrequencyInfoVarArray(IDeserializer iDeserializer) {
        FrequencyInfo[] frequencyInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            frequencyInfoArray = new FrequencyInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                frequencyInfoArray[i2] = FrequencyInfoSerializer.getOptionalFrequencyInfo(iDeserializer);
            }
        }
        return frequencyInfoArray;
    }
}

