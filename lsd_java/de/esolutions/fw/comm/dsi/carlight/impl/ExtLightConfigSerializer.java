/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightConfig;

public class ExtLightConfigSerializer {
    public static void putOptionalExtLightConfig(ISerializer iSerializer, ExtLightConfig extLightConfig) {
        boolean bl = extLightConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = extLightConfig.isLeftHandTraffic();
            iSerializer.putBool(bl2);
            boolean bl3 = extLightConfig.isRainDependency();
            iSerializer.putBool(bl3);
            boolean bl4 = extLightConfig.isSpeedDependency();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalExtLightConfigVarArray(ISerializer iSerializer, ExtLightConfig[] extLightConfigArray) {
        boolean bl = extLightConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightConfigArray.length);
            for (int i2 = 0; i2 < extLightConfigArray.length; ++i2) {
                ExtLightConfigSerializer.putOptionalExtLightConfig(iSerializer, extLightConfigArray[i2]);
            }
        }
    }

    public static ExtLightConfig getOptionalExtLightConfig(IDeserializer iDeserializer) {
        ExtLightConfig extLightConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            extLightConfig = new ExtLightConfig();
            extLightConfig.leftHandTraffic = bl4 = iDeserializer.getBool();
            extLightConfig.rainDependency = bl3 = iDeserializer.getBool();
            extLightConfig.speedDependency = bl2 = iDeserializer.getBool();
        }
        return extLightConfig;
    }

    public static ExtLightConfig[] getOptionalExtLightConfigVarArray(IDeserializer iDeserializer) {
        ExtLightConfig[] extLightConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightConfigArray = new ExtLightConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightConfigArray[i2] = ExtLightConfigSerializer.getOptionalExtLightConfig(iDeserializer);
            }
        }
        return extLightConfigArray;
    }
}

