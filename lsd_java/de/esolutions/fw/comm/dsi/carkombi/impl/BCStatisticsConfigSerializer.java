/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCStatisticsConfig;

public class BCStatisticsConfigSerializer {
    public static void putOptionalBCStatisticsConfig(ISerializer iSerializer, BCStatisticsConfig bCStatisticsConfig) {
        boolean bl = bCStatisticsConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCStatisticsConfig.isStatisticsTimeState();
            iSerializer.putBool(bl2);
            boolean bl3 = bCStatisticsConfig.isStatisticsDistanceState();
            iSerializer.putBool(bl3);
            boolean bl4 = bCStatisticsConfig.isStatisticsPeriodState();
            iSerializer.putBool(bl4);
            boolean bl5 = bCStatisticsConfig.isStatisticsIntervalState();
            iSerializer.putBool(bl5);
            int n = bCStatisticsConfig.getStatisticsPeriodValue();
            iSerializer.putInt32(n);
            float f2 = bCStatisticsConfig.getStatisticsIntervalValue();
            iSerializer.putFloat(f2);
        }
    }

    public static void putOptionalBCStatisticsConfigVarArray(ISerializer iSerializer, BCStatisticsConfig[] bCStatisticsConfigArray) {
        boolean bl = bCStatisticsConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsConfigArray.length);
            for (int i2 = 0; i2 < bCStatisticsConfigArray.length; ++i2) {
                BCStatisticsConfigSerializer.putOptionalBCStatisticsConfig(iSerializer, bCStatisticsConfigArray[i2]);
            }
        }
    }

    public static BCStatisticsConfig getOptionalBCStatisticsConfig(IDeserializer iDeserializer) {
        BCStatisticsConfig bCStatisticsConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            bCStatisticsConfig = new BCStatisticsConfig();
            bCStatisticsConfig.statisticsTimeState = bl5 = iDeserializer.getBool();
            bCStatisticsConfig.statisticsDistanceState = bl4 = iDeserializer.getBool();
            bCStatisticsConfig.statisticsPeriodState = bl3 = iDeserializer.getBool();
            bCStatisticsConfig.statisticsIntervalState = bl2 = iDeserializer.getBool();
            bCStatisticsConfig.statisticsPeriodValue = n = iDeserializer.getInt32();
            bCStatisticsConfig.statisticsIntervalValue = f2 = iDeserializer.getFloat();
        }
        return bCStatisticsConfig;
    }

    public static BCStatisticsConfig[] getOptionalBCStatisticsConfigVarArray(IDeserializer iDeserializer) {
        BCStatisticsConfig[] bCStatisticsConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsConfigArray = new BCStatisticsConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsConfigArray[i2] = BCStatisticsConfigSerializer.getOptionalBCStatisticsConfig(iDeserializer);
            }
        }
        return bCStatisticsConfigArray;
    }
}

