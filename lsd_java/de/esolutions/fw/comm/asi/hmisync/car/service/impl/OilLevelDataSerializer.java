/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class OilLevelDataSerializer {
    public static void putOptionalOilLevelData(ISerializer iSerializer, OilLevelData oilLevelData) {
        boolean bl = oilLevelData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = oilLevelData.getLevel();
            iSerializer.putInt32(n);
            IntBaseType intBaseType = oilLevelData.getRefillVolume();
            IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseType);
            int n2 = oilLevelData.getWarnings();
            iSerializer.putInt32(n2);
            boolean bl2 = oilLevelData.isOilsystem();
            iSerializer.putBool(bl2);
            boolean bl3 = oilLevelData.isBargraph();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalOilLevelDataVarArray(ISerializer iSerializer, OilLevelData[] oilLevelDataArray) {
        boolean bl = oilLevelDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oilLevelDataArray.length);
            for (int i2 = 0; i2 < oilLevelDataArray.length; ++i2) {
                OilLevelDataSerializer.putOptionalOilLevelData(iSerializer, oilLevelDataArray[i2]);
            }
        }
    }

    public static OilLevelData getOptionalOilLevelData(IDeserializer iDeserializer) {
        OilLevelData oilLevelData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            IntBaseType intBaseType;
            int n2;
            oilLevelData = new OilLevelData();
            oilLevelData.level = n2 = iDeserializer.getInt32();
            oilLevelData.refillVolume = intBaseType = IntBaseTypeSerializer.getOptionalIntBaseType(iDeserializer);
            oilLevelData.warnings = n = iDeserializer.getInt32();
            oilLevelData.oilsystem = bl3 = iDeserializer.getBool();
            oilLevelData.bargraph = bl2 = iDeserializer.getBool();
        }
        return oilLevelData;
    }

    public static OilLevelData[] getOptionalOilLevelDataVarArray(IDeserializer iDeserializer) {
        OilLevelData[] oilLevelDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oilLevelDataArray = new OilLevelData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oilLevelDataArray[i2] = OilLevelDataSerializer.getOptionalOilLevelData(iDeserializer);
            }
        }
        return oilLevelDataArray;
    }
}

