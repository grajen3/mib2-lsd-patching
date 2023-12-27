/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CharacterInfo;

public class CharacterInfoSerializer {
    public static void putOptionalCharacterInfo(ISerializer iSerializer, CharacterInfo characterInfo) {
        boolean bl = characterInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = characterInfo.getValue();
            iSerializer.putInt32(n);
            int n2 = characterInfo.getIndex();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCharacterInfoVarArray(ISerializer iSerializer, CharacterInfo[] characterInfoArray) {
        boolean bl = characterInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(characterInfoArray.length);
            for (int i2 = 0; i2 < characterInfoArray.length; ++i2) {
                CharacterInfoSerializer.putOptionalCharacterInfo(iSerializer, characterInfoArray[i2]);
            }
        }
    }

    public static CharacterInfo getOptionalCharacterInfo(IDeserializer iDeserializer) {
        CharacterInfo characterInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            characterInfo = new CharacterInfo();
            characterInfo.value = n2 = iDeserializer.getInt32();
            characterInfo.index = n = iDeserializer.getInt32();
        }
        return characterInfo;
    }

    public static CharacterInfo[] getOptionalCharacterInfoVarArray(IDeserializer iDeserializer) {
        CharacterInfo[] characterInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            characterInfoArray = new CharacterInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                characterInfoArray[i2] = CharacterInfoSerializer.getOptionalCharacterInfo(iDeserializer);
            }
        }
        return characterInfoArray;
    }
}

