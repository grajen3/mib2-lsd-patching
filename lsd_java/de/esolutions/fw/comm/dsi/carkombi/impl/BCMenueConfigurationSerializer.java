/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCMenueConfiguration;

public class BCMenueConfigurationSerializer {
    public static void putOptionalBCMenueConfiguration(ISerializer iSerializer, BCMenueConfiguration bCMenueConfiguration) {
        boolean bl = bCMenueConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCMenueConfiguration.isCruisingRange();
            iSerializer.putBool(bl2);
            boolean bl3 = bCMenueConfiguration.isAverageConsumption();
            iSerializer.putBool(bl3);
            boolean bl4 = bCMenueConfiguration.isCurrentConsumption();
            iSerializer.putBool(bl4);
            boolean bl5 = bCMenueConfiguration.isAverageSpeed();
            iSerializer.putBool(bl5);
            boolean bl6 = bCMenueConfiguration.isDrivingTime();
            iSerializer.putBool(bl6);
            boolean bl7 = bCMenueConfiguration.isDrivenDistance();
            iSerializer.putBool(bl7);
            boolean bl8 = bCMenueConfiguration.isMenueDisplay();
            iSerializer.putBool(bl8);
            boolean bl9 = bCMenueConfiguration.isRefuelVolume();
            iSerializer.putBool(bl9);
            boolean bl10 = bCMenueConfiguration.isSpeedWarningFIS();
            iSerializer.putBool(bl10);
            boolean bl11 = bCMenueConfiguration.isCoolantTemp();
            iSerializer.putBool(bl11);
            boolean bl12 = bCMenueConfiguration.isSecondarySpeed();
            iSerializer.putBool(bl12);
            boolean bl13 = bCMenueConfiguration.isResetTime();
            iSerializer.putBool(bl13);
            boolean bl14 = bCMenueConfiguration.isComfortPowerConsumption();
            iSerializer.putBool(bl14);
            boolean bl15 = bCMenueConfiguration.isZeroEmissionTime();
            iSerializer.putBool(bl15);
            boolean bl16 = bCMenueConfiguration.isZeroEmissionDistance();
            iSerializer.putBool(bl16);
        }
    }

    public static void putOptionalBCMenueConfigurationVarArray(ISerializer iSerializer, BCMenueConfiguration[] bCMenueConfigurationArray) {
        boolean bl = bCMenueConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCMenueConfigurationArray.length);
            for (int i2 = 0; i2 < bCMenueConfigurationArray.length; ++i2) {
                BCMenueConfigurationSerializer.putOptionalBCMenueConfiguration(iSerializer, bCMenueConfigurationArray[i2]);
            }
        }
    }

    public static BCMenueConfiguration getOptionalBCMenueConfiguration(IDeserializer iDeserializer) {
        BCMenueConfiguration bCMenueConfiguration = null;
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
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            bCMenueConfiguration = new BCMenueConfiguration();
            bCMenueConfiguration.cruisingRange = bl16 = iDeserializer.getBool();
            bCMenueConfiguration.averageConsumption = bl15 = iDeserializer.getBool();
            bCMenueConfiguration.currentConsumption = bl14 = iDeserializer.getBool();
            bCMenueConfiguration.averageSpeed = bl13 = iDeserializer.getBool();
            bCMenueConfiguration.drivingTime = bl12 = iDeserializer.getBool();
            bCMenueConfiguration.drivenDistance = bl11 = iDeserializer.getBool();
            bCMenueConfiguration.menueDisplay = bl10 = iDeserializer.getBool();
            bCMenueConfiguration.refuelVolume = bl9 = iDeserializer.getBool();
            bCMenueConfiguration.speedWarningFIS = bl8 = iDeserializer.getBool();
            bCMenueConfiguration.coolantTemp = bl7 = iDeserializer.getBool();
            bCMenueConfiguration.secondarySpeed = bl6 = iDeserializer.getBool();
            bCMenueConfiguration.resetTime = bl5 = iDeserializer.getBool();
            bCMenueConfiguration.comfortPowerConsumption = bl4 = iDeserializer.getBool();
            bCMenueConfiguration.zeroEmissionTime = bl3 = iDeserializer.getBool();
            bCMenueConfiguration.zeroEmissionDistance = bl2 = iDeserializer.getBool();
        }
        return bCMenueConfiguration;
    }

    public static BCMenueConfiguration[] getOptionalBCMenueConfigurationVarArray(IDeserializer iDeserializer) {
        BCMenueConfiguration[] bCMenueConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCMenueConfigurationArray = new BCMenueConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCMenueConfigurationArray[i2] = BCMenueConfigurationSerializer.getOptionalBCMenueConfiguration(iDeserializer);
            }
        }
        return bCMenueConfigurationArray;
    }
}

