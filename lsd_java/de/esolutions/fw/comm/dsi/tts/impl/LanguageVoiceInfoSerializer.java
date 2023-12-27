/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class LanguageVoiceInfoSerializer {
    public static void putOptionalLanguageVoiceInfo(ISerializer iSerializer, LanguageVoiceInfo languageVoiceInfo) {
        boolean bl = languageVoiceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = languageVoiceInfo.getLanguage();
            iSerializer.putOptionalString(string);
            int[] nArray = languageVoiceInfo.getVoiceIDs();
            iSerializer.putOptionalInt32VarArray(nArray);
            String[] stringArray = languageVoiceInfo.getVoiceNames();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalLanguageVoiceInfoVarArray(ISerializer iSerializer, LanguageVoiceInfo[] languageVoiceInfoArray) {
        boolean bl = languageVoiceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(languageVoiceInfoArray.length);
            for (int i2 = 0; i2 < languageVoiceInfoArray.length; ++i2) {
                LanguageVoiceInfoSerializer.putOptionalLanguageVoiceInfo(iSerializer, languageVoiceInfoArray[i2]);
            }
        }
    }

    public static LanguageVoiceInfo getOptionalLanguageVoiceInfo(IDeserializer iDeserializer) {
        LanguageVoiceInfo languageVoiceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            languageVoiceInfo = new LanguageVoiceInfo();
            languageVoiceInfo.language = string = iDeserializer.getOptionalString();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            languageVoiceInfo.voiceIDs = nArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            languageVoiceInfo.voiceNames = stringArray;
        }
        return languageVoiceInfo;
    }

    public static LanguageVoiceInfo[] getOptionalLanguageVoiceInfoVarArray(IDeserializer iDeserializer) {
        LanguageVoiceInfo[] languageVoiceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            languageVoiceInfoArray = new LanguageVoiceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                languageVoiceInfoArray[i2] = LanguageVoiceInfoSerializer.getOptionalLanguageVoiceInfo(iDeserializer);
            }
        }
        return languageVoiceInfoArray;
    }
}

