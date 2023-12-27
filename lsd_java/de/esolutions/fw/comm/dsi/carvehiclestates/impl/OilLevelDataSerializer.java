/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.carvehiclestates.impl.OilLevelRefillVolumeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;

public class OilLevelDataSerializer {
    public static void putOptionalOilLevelData(ISerializer iSerializer, OilLevelData oilLevelData) {
        boolean bl = oilLevelData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = oilLevelData.getLevel();
            iSerializer.putInt32(n);
            OilLevelRefillVolume oilLevelRefillVolume = oilLevelData.getRefillVolume();
            OilLevelRefillVolumeSerializer.putOptionalOilLevelRefillVolume(iSerializer, oilLevelRefillVolume);
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
            OilLevelRefillVolume oilLevelRefillVolume;
            int n2;
            oilLevelData = new OilLevelData();
            oilLevelData.level = n2 = iDeserializer.getInt32();
            oilLevelData.refillVolume = oilLevelRefillVolume = OilLevelRefillVolumeSerializer.getOptionalOilLevelRefillVolume(iDeserializer);
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

