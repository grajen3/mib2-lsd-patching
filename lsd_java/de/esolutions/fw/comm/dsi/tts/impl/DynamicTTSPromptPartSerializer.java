/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tts.DynamicTTSPromptPart;

public class DynamicTTSPromptPartSerializer {
    public static void putOptionalDynamicTTSPromptPart(ISerializer iSerializer, DynamicTTSPromptPart dynamicTTSPromptPart) {
        boolean bl = dynamicTTSPromptPart == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = dynamicTTSPromptPart.getKey();
            iSerializer.putOptionalString(string);
            String string2 = dynamicTTSPromptPart.getValue();
            iSerializer.putOptionalString(string2);
            String string3 = dynamicTTSPromptPart.getAlternativeText();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalDynamicTTSPromptPartVarArray(ISerializer iSerializer, DynamicTTSPromptPart[] dynamicTTSPromptPartArray) {
        boolean bl = dynamicTTSPromptPartArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicTTSPromptPartArray.length);
            for (int i2 = 0; i2 < dynamicTTSPromptPartArray.length; ++i2) {
                DynamicTTSPromptPartSerializer.putOptionalDynamicTTSPromptPart(iSerializer, dynamicTTSPromptPartArray[i2]);
            }
        }
    }

    public static DynamicTTSPromptPart getOptionalDynamicTTSPromptPart(IDeserializer iDeserializer) {
        DynamicTTSPromptPart dynamicTTSPromptPart = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            dynamicTTSPromptPart = new DynamicTTSPromptPart();
            dynamicTTSPromptPart.key = string3 = iDeserializer.getOptionalString();
            dynamicTTSPromptPart.value = string2 = iDeserializer.getOptionalString();
            dynamicTTSPromptPart.alternativeText = string = iDeserializer.getOptionalString();
        }
        return dynamicTTSPromptPart;
    }

    public static DynamicTTSPromptPart[] getOptionalDynamicTTSPromptPartVarArray(IDeserializer iDeserializer) {
        DynamicTTSPromptPart[] dynamicTTSPromptPartArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicTTSPromptPartArray = new DynamicTTSPromptPart[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicTTSPromptPartArray[i2] = DynamicTTSPromptPartSerializer.getOptionalDynamicTTSPromptPart(iDeserializer);
            }
        }
        return dynamicTTSPromptPartArray;
    }
}

