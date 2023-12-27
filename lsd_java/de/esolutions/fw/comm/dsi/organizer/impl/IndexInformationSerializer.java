/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.global.impl.CharacterInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.organizer.IndexInformation;

public class IndexInformationSerializer {
    public static void putOptionalIndexInformation(ISerializer iSerializer, IndexInformation indexInformation) {
        boolean bl = indexInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = indexInformation.getViewtype();
            iSerializer.putInt32(n);
            CharacterInfo[] characterInfoArray = indexInformation.getCharacterInfo();
            CharacterInfoSerializer.putOptionalCharacterInfoVarArray(iSerializer, characterInfoArray);
        }
    }

    public static void putOptionalIndexInformationVarArray(ISerializer iSerializer, IndexInformation[] indexInformationArray) {
        boolean bl = indexInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(indexInformationArray.length);
            for (int i2 = 0; i2 < indexInformationArray.length; ++i2) {
                IndexInformationSerializer.putOptionalIndexInformation(iSerializer, indexInformationArray[i2]);
            }
        }
    }

    public static IndexInformation getOptionalIndexInformation(IDeserializer iDeserializer) {
        IndexInformation indexInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            indexInformation = new IndexInformation();
            indexInformation.viewtype = n = iDeserializer.getInt32();
            CharacterInfo[] characterInfoArray = CharacterInfoSerializer.getOptionalCharacterInfoVarArray(iDeserializer);
            indexInformation.characterInfo = characterInfoArray;
        }
        return indexInformation;
    }

    public static IndexInformation[] getOptionalIndexInformationVarArray(IDeserializer iDeserializer) {
        IndexInformation[] indexInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            indexInformationArray = new IndexInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                indexInformationArray[i2] = IndexInformationSerializer.getOptionalIndexInformation(iDeserializer);
            }
        }
        return indexInformationArray;
    }
}

