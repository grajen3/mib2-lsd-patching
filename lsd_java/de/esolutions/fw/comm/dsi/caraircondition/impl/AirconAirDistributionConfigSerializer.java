/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirDistributionConfig;

public class AirconAirDistributionConfigSerializer {
    public static void putOptionalAirconAirDistributionConfig(ISerializer iSerializer, AirconAirDistributionConfig airconAirDistributionConfig) {
        boolean bl = airconAirDistributionConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconAirDistributionConfig.isAutoSupported();
            iSerializer.putBool(bl2);
            boolean bl3 = airconAirDistributionConfig.isDownUp();
            iSerializer.putBool(bl3);
            boolean bl4 = airconAirDistributionConfig.isUp();
            iSerializer.putBool(bl4);
            boolean bl5 = airconAirDistributionConfig.isUpMiddle();
            iSerializer.putBool(bl5);
            boolean bl6 = airconAirDistributionConfig.isMiddle();
            iSerializer.putBool(bl6);
            boolean bl7 = airconAirDistributionConfig.isDownMiddle();
            iSerializer.putBool(bl7);
            boolean bl8 = airconAirDistributionConfig.isDown();
            iSerializer.putBool(bl8);
            boolean bl9 = airconAirDistributionConfig.isUpMiddleDown();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalAirconAirDistributionConfigVarArray(ISerializer iSerializer, AirconAirDistributionConfig[] airconAirDistributionConfigArray) {
        boolean bl = airconAirDistributionConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconAirDistributionConfigArray.length);
            for (int i2 = 0; i2 < airconAirDistributionConfigArray.length; ++i2) {
                AirconAirDistributionConfigSerializer.putOptionalAirconAirDistributionConfig(iSerializer, airconAirDistributionConfigArray[i2]);
            }
        }
    }

    public static AirconAirDistributionConfig getOptionalAirconAirDistributionConfig(IDeserializer iDeserializer) {
        AirconAirDistributionConfig airconAirDistributionConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            airconAirDistributionConfig = new AirconAirDistributionConfig();
            airconAirDistributionConfig.autoSupported = bl9 = iDeserializer.getBool();
            airconAirDistributionConfig.downUp = bl8 = iDeserializer.getBool();
            airconAirDistributionConfig.up = bl7 = iDeserializer.getBool();
            airconAirDistributionConfig.upMiddle = bl6 = iDeserializer.getBool();
            airconAirDistributionConfig.middle = bl5 = iDeserializer.getBool();
            airconAirDistributionConfig.downMiddle = bl4 = iDeserializer.getBool();
            airconAirDistributionConfig.down = bl3 = iDeserializer.getBool();
            airconAirDistributionConfig.upMiddleDown = bl2 = iDeserializer.getBool();
        }
        return airconAirDistributionConfig;
    }

    public static AirconAirDistributionConfig[] getOptionalAirconAirDistributionConfigVarArray(IDeserializer iDeserializer) {
        AirconAirDistributionConfig[] airconAirDistributionConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconAirDistributionConfigArray = new AirconAirDistributionConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconAirDistributionConfigArray[i2] = AirconAirDistributionConfigSerializer.getOptionalAirconAirDistributionConfig(iDeserializer);
            }
        }
        return airconAirDistributionConfigArray;
    }
}

