/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.comm.dsi.tts.impl.DynamicTTSPromptPartSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tts.DynamicTTSPromptPart;
import org.dsi.ifc.tts.TTSPrompt;

public class TTSPromptSerializer {
    public static void putOptionalTTSPrompt(ISerializer iSerializer, TTSPrompt tTSPrompt) {
        boolean bl = tTSPrompt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tTSPrompt.getPromptType();
            iSerializer.putInt32(n);
            String[] stringArray = tTSPrompt.getPromptPartTexts();
            iSerializer.putOptionalStringVarArray(stringArray);
            int[] nArray = tTSPrompt.getPromptPartIds();
            iSerializer.putOptionalInt32VarArray(nArray);
            DynamicTTSPromptPart[] dynamicTTSPromptPartArray = tTSPrompt.getDynamicParts();
            DynamicTTSPromptPartSerializer.putOptionalDynamicTTSPromptPartVarArray(iSerializer, dynamicTTSPromptPartArray);
        }
    }

    public static void putOptionalTTSPromptVarArray(ISerializer iSerializer, TTSPrompt[] tTSPromptArray) {
        boolean bl = tTSPromptArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tTSPromptArray.length);
            for (int i2 = 0; i2 < tTSPromptArray.length; ++i2) {
                TTSPromptSerializer.putOptionalTTSPrompt(iSerializer, tTSPromptArray[i2]);
            }
        }
    }

    public static TTSPrompt getOptionalTTSPrompt(IDeserializer iDeserializer) {
        TTSPrompt tTSPrompt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            tTSPrompt = new TTSPrompt();
            tTSPrompt.promptType = n = iDeserializer.getInt32();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            tTSPrompt.promptPartTexts = stringArray;
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            tTSPrompt.promptPartIds = nArray;
            DynamicTTSPromptPart[] dynamicTTSPromptPartArray = DynamicTTSPromptPartSerializer.getOptionalDynamicTTSPromptPartVarArray(iDeserializer);
            tTSPrompt.dynamicParts = dynamicTTSPromptPartArray;
        }
        return tTSPrompt;
    }

    public static TTSPrompt[] getOptionalTTSPromptVarArray(IDeserializer iDeserializer) {
        TTSPrompt[] tTSPromptArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tTSPromptArray = new TTSPrompt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tTSPromptArray[i2] = TTSPromptSerializer.getOptionalTTSPrompt(iDeserializer);
            }
        }
        return tTSPromptArray;
    }
}

