/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;

public class OilLevelRefillVolumeSerializer {
    public static void putOptionalOilLevelRefillVolume(ISerializer iSerializer, OilLevelRefillVolume oilLevelRefillVolume) {
        boolean bl = oilLevelRefillVolume == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = oilLevelRefillVolume.getValue();
            iSerializer.putInt32(n);
            int n2 = oilLevelRefillVolume.getUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalOilLevelRefillVolumeVarArray(ISerializer iSerializer, OilLevelRefillVolume[] oilLevelRefillVolumeArray) {
        boolean bl = oilLevelRefillVolumeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oilLevelRefillVolumeArray.length);
            for (int i2 = 0; i2 < oilLevelRefillVolumeArray.length; ++i2) {
                OilLevelRefillVolumeSerializer.putOptionalOilLevelRefillVolume(iSerializer, oilLevelRefillVolumeArray[i2]);
            }
        }
    }

    public static OilLevelRefillVolume getOptionalOilLevelRefillVolume(IDeserializer iDeserializer) {
        OilLevelRefillVolume oilLevelRefillVolume = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            oilLevelRefillVolume = new OilLevelRefillVolume();
            oilLevelRefillVolume.value = n2 = iDeserializer.getInt32();
            oilLevelRefillVolume.unit = n = iDeserializer.getInt32();
        }
        return oilLevelRefillVolume;
    }

    public static OilLevelRefillVolume[] getOptionalOilLevelRefillVolumeVarArray(IDeserializer iDeserializer) {
        OilLevelRefillVolume[] oilLevelRefillVolumeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oilLevelRefillVolumeArray = new OilLevelRefillVolume[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oilLevelRefillVolumeArray[i2] = OilLevelRefillVolumeSerializer.getOptionalOilLevelRefillVolume(iDeserializer);
            }
        }
        return oilLevelRefillVolumeArray;
    }
}

