/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.KeyboardInfo;

public class KeyboardInfoSerializer {
    public static void putOptionalKeyboardInfo(ISerializer iSerializer, KeyboardInfo keyboardInfo) {
        boolean bl = keyboardInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = keyboardInfo.getType();
            iSerializer.putInt32(n);
            String string = keyboardInfo.getTitle();
            iSerializer.putOptionalString(string);
            String string2 = keyboardInfo.getInitialText();
            iSerializer.putOptionalString(string2);
            boolean bl2 = keyboardInfo.isSensitive();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalKeyboardInfoVarArray(ISerializer iSerializer, KeyboardInfo[] keyboardInfoArray) {
        boolean bl = keyboardInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(keyboardInfoArray.length);
            for (int i2 = 0; i2 < keyboardInfoArray.length; ++i2) {
                KeyboardInfoSerializer.putOptionalKeyboardInfo(iSerializer, keyboardInfoArray[i2]);
            }
        }
    }

    public static KeyboardInfo getOptionalKeyboardInfo(IDeserializer iDeserializer) {
        KeyboardInfo keyboardInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            int n;
            keyboardInfo = new KeyboardInfo();
            keyboardInfo.type = n = iDeserializer.getInt32();
            keyboardInfo.title = string2 = iDeserializer.getOptionalString();
            keyboardInfo.initialText = string = iDeserializer.getOptionalString();
            keyboardInfo.sensitive = bl2 = iDeserializer.getBool();
        }
        return keyboardInfo;
    }

    public static KeyboardInfo[] getOptionalKeyboardInfoVarArray(IDeserializer iDeserializer) {
        KeyboardInfo[] keyboardInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            keyboardInfoArray = new KeyboardInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                keyboardInfoArray[i2] = KeyboardInfoSerializer.getOptionalKeyboardInfo(iDeserializer);
            }
        }
        return keyboardInfoArray;
    }
}

