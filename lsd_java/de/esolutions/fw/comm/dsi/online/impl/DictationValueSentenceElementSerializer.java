/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.DictationValueSentenceElement;

public class DictationValueSentenceElementSerializer {
    public static void putOptionalDictationValueSentenceElement(ISerializer iSerializer, DictationValueSentenceElement dictationValueSentenceElement) {
        boolean bl = dictationValueSentenceElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String[] stringArray = dictationValueSentenceElement.getWords();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalDictationValueSentenceElementVarArray(ISerializer iSerializer, DictationValueSentenceElement[] dictationValueSentenceElementArray) {
        boolean bl = dictationValueSentenceElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dictationValueSentenceElementArray.length);
            for (int i2 = 0; i2 < dictationValueSentenceElementArray.length; ++i2) {
                DictationValueSentenceElementSerializer.putOptionalDictationValueSentenceElement(iSerializer, dictationValueSentenceElementArray[i2]);
            }
        }
    }

    public static DictationValueSentenceElement getOptionalDictationValueSentenceElement(IDeserializer iDeserializer) {
        DictationValueSentenceElement dictationValueSentenceElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            dictationValueSentenceElement = new DictationValueSentenceElement();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            dictationValueSentenceElement.words = stringArray;
        }
        return dictationValueSentenceElement;
    }

    public static DictationValueSentenceElement[] getOptionalDictationValueSentenceElementVarArray(IDeserializer iDeserializer) {
        DictationValueSentenceElement[] dictationValueSentenceElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dictationValueSentenceElementArray = new DictationValueSentenceElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dictationValueSentenceElementArray[i2] = DictationValueSentenceElementSerializer.getOptionalDictationValueSentenceElement(iDeserializer);
            }
        }
        return dictationValueSentenceElementArray;
    }
}

