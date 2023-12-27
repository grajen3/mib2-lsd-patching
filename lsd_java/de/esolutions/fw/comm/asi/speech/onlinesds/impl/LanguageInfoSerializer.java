/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class LanguageInfoSerializer {
    public static void putOptionalLanguageInfo(ISerializer iSerializer, LanguageInfo languageInfo) {
        boolean bl = languageInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = languageInfo.getLanguage();
            iSerializer.putOptionalString(string);
            String string2 = languageInfo.getRegion();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalLanguageInfoVarArray(ISerializer iSerializer, LanguageInfo[] languageInfoArray) {
        boolean bl = languageInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(languageInfoArray.length);
            for (int i2 = 0; i2 < languageInfoArray.length; ++i2) {
                LanguageInfoSerializer.putOptionalLanguageInfo(iSerializer, languageInfoArray[i2]);
            }
        }
    }

    public static LanguageInfo getOptionalLanguageInfo(IDeserializer iDeserializer) {
        LanguageInfo languageInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            languageInfo = new LanguageInfo();
            languageInfo.language = string2 = iDeserializer.getOptionalString();
            languageInfo.region = string = iDeserializer.getOptionalString();
        }
        return languageInfo;
    }

    public static LanguageInfo[] getOptionalLanguageInfoVarArray(IDeserializer iDeserializer) {
        LanguageInfo[] languageInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            languageInfoArray = new LanguageInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                languageInfoArray[i2] = LanguageInfoSerializer.getOptionalLanguageInfo(iDeserializer);
            }
        }
        return languageInfoArray;
    }
}

