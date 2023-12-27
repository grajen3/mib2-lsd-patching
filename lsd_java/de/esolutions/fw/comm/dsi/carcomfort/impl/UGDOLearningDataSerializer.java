/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOLearningData;

public class UGDOLearningDataSerializer {
    public static void putOptionalUGDOLearningData(ISerializer iSerializer, UGDOLearningData uGDOLearningData) {
        boolean bl = uGDOLearningData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOLearningData.getASGRequest();
            iSerializer.putInt32(n);
            int n2 = uGDOLearningData.getFSGResponse();
            iSerializer.putInt32(n2);
            int n3 = uGDOLearningData.getCodeSystem();
            iSerializer.putInt32(n3);
            int n4 = uGDOLearningData.getButton();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalUGDOLearningDataVarArray(ISerializer iSerializer, UGDOLearningData[] uGDOLearningDataArray) {
        boolean bl = uGDOLearningDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOLearningDataArray.length);
            for (int i2 = 0; i2 < uGDOLearningDataArray.length; ++i2) {
                UGDOLearningDataSerializer.putOptionalUGDOLearningData(iSerializer, uGDOLearningDataArray[i2]);
            }
        }
    }

    public static UGDOLearningData getOptionalUGDOLearningData(IDeserializer iDeserializer) {
        UGDOLearningData uGDOLearningData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            uGDOLearningData = new UGDOLearningData();
            uGDOLearningData.aSGRequest = n4 = iDeserializer.getInt32();
            uGDOLearningData.fSGResponse = n3 = iDeserializer.getInt32();
            uGDOLearningData.codeSystem = n2 = iDeserializer.getInt32();
            uGDOLearningData.button = n = iDeserializer.getInt32();
        }
        return uGDOLearningData;
    }

    public static UGDOLearningData[] getOptionalUGDOLearningDataVarArray(IDeserializer iDeserializer) {
        UGDOLearningData[] uGDOLearningDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOLearningDataArray = new UGDOLearningData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOLearningDataArray[i2] = UGDOLearningDataSerializer.getOptionalUGDOLearningData(iDeserializer);
            }
        }
        return uGDOLearningDataArray;
    }
}

