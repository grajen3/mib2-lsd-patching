/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DictationValueSentenceElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.DictationValueSentence;
import org.dsi.ifc.online.DictationValueSentenceElement;

public class DictationValueSentenceSerializer {
    public static void putOptionalDictationValueSentence(ISerializer iSerializer, DictationValueSentence dictationValueSentence) {
        boolean bl = dictationValueSentence == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dictationValueSentence.getVoiceSourceID();
            iSerializer.putInt32(n);
            String string = dictationValueSentence.getVoiceSourceName();
            iSerializer.putOptionalString(string);
            int n2 = dictationValueSentence.getVoiceRecognizerAudioFormat();
            iSerializer.putInt32(n2);
            String string2 = dictationValueSentence.getImageVoiceUrl();
            iSerializer.putOptionalString(string2);
            String string3 = dictationValueSentence.getImageVoiceCheckSum();
            iSerializer.putOptionalString(string3);
            DictationValueSentenceElement[] dictationValueSentenceElementArray = dictationValueSentence.getList();
            DictationValueSentenceElementSerializer.putOptionalDictationValueSentenceElementVarArray(iSerializer, dictationValueSentenceElementArray);
        }
    }

    public static void putOptionalDictationValueSentenceVarArray(ISerializer iSerializer, DictationValueSentence[] dictationValueSentenceArray) {
        boolean bl = dictationValueSentenceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dictationValueSentenceArray.length);
            for (int i2 = 0; i2 < dictationValueSentenceArray.length; ++i2) {
                DictationValueSentenceSerializer.putOptionalDictationValueSentence(iSerializer, dictationValueSentenceArray[i2]);
            }
        }
    }

    public static DictationValueSentence getOptionalDictationValueSentence(IDeserializer iDeserializer) {
        DictationValueSentence dictationValueSentence = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            String string3;
            int n2;
            dictationValueSentence = new DictationValueSentence();
            dictationValueSentence.voiceSourceID = n2 = iDeserializer.getInt32();
            dictationValueSentence.voiceSourceName = string3 = iDeserializer.getOptionalString();
            dictationValueSentence.voiceRecognizerAudioFormat = n = iDeserializer.getInt32();
            dictationValueSentence.imageVoiceUrl = string2 = iDeserializer.getOptionalString();
            dictationValueSentence.imageVoiceCheckSum = string = iDeserializer.getOptionalString();
            DictationValueSentenceElement[] dictationValueSentenceElementArray = DictationValueSentenceElementSerializer.getOptionalDictationValueSentenceElementVarArray(iDeserializer);
            dictationValueSentence.list = dictationValueSentenceElementArray;
        }
        return dictationValueSentence;
    }

    public static DictationValueSentence[] getOptionalDictationValueSentenceVarArray(IDeserializer iDeserializer) {
        DictationValueSentence[] dictationValueSentenceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dictationValueSentenceArray = new DictationValueSentence[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dictationValueSentenceArray[i2] = DictationValueSentenceSerializer.getOptionalDictationValueSentence(iDeserializer);
            }
        }
        return dictationValueSentenceArray;
    }
}

