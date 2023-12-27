/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;

public class BCFISAdditionalConfigurationSerializer {
    public static void putOptionalBCFISAdditionalConfiguration(ISerializer iSerializer, BCFISAdditionalConfiguration bCFISAdditionalConfiguration) {
        boolean bl = bCFISAdditionalConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCFISAdditionalConfiguration.isFis1();
            iSerializer.putBool(bl2);
            boolean bl3 = bCFISAdditionalConfiguration.isFis2();
            iSerializer.putBool(bl3);
            boolean bl4 = bCFISAdditionalConfiguration.isFis3();
            iSerializer.putBool(bl4);
            boolean bl5 = bCFISAdditionalConfiguration.isStopWatch();
            iSerializer.putBool(bl5);
            boolean bl6 = bCFISAdditionalConfiguration.isOilTemp();
            iSerializer.putBool(bl6);
            boolean bl7 = bCFISAdditionalConfiguration.isDigitalSpeed();
            iSerializer.putBool(bl7);
            boolean bl8 = bCFISAdditionalConfiguration.isRefuelVolume();
            iSerializer.putBool(bl8);
            boolean bl9 = bCFISAdditionalConfiguration.isSpeedWarning();
            iSerializer.putBool(bl9);
            boolean bl10 = bCFISAdditionalConfiguration.isCoolantTemp();
            iSerializer.putBool(bl10);
            boolean bl11 = bCFISAdditionalConfiguration.isSecondarySpeed();
            iSerializer.putBool(bl11);
            boolean bl12 = bCFISAdditionalConfiguration.isVza();
            iSerializer.putBool(bl12);
            boolean bl13 = bCFISAdditionalConfiguration.isResetTime();
            iSerializer.putBool(bl13);
            boolean bl14 = bCFISAdditionalConfiguration.isComfortPowerConsumption();
            iSerializer.putBool(bl14);
            boolean bl15 = bCFISAdditionalConfiguration.isZeroEmissionTime();
            iSerializer.putBool(bl15);
            boolean bl16 = bCFISAdditionalConfiguration.isZeroEmissionDistance();
            iSerializer.putBool(bl16);
            boolean bl17 = bCFISAdditionalConfiguration.isVzaMfa();
            iSerializer.putBool(bl17);
            boolean bl18 = bCFISAdditionalConfiguration.isBcmeConsumerList();
            iSerializer.putBool(bl18);
            boolean bl19 = bCFISAdditionalConfiguration.isBcmeLiveTips();
            iSerializer.putBool(bl19);
            boolean bl20 = bCFISAdditionalConfiguration.isAstaMfa();
            iSerializer.putBool(bl20);
        }
    }

    public static void putOptionalBCFISAdditionalConfigurationVarArray(ISerializer iSerializer, BCFISAdditionalConfiguration[] bCFISAdditionalConfigurationArray) {
        boolean bl = bCFISAdditionalConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCFISAdditionalConfigurationArray.length);
            for (int i2 = 0; i2 < bCFISAdditionalConfigurationArray.length; ++i2) {
                BCFISAdditionalConfigurationSerializer.putOptionalBCFISAdditionalConfiguration(iSerializer, bCFISAdditionalConfigurationArray[i2]);
            }
        }
    }

    public static BCFISAdditionalConfiguration getOptionalBCFISAdditionalConfiguration(IDeserializer iDeserializer) {
        BCFISAdditionalConfiguration bCFISAdditionalConfiguration = null;
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
            boolean bl17;
            boolean bl18;
            boolean bl19;
            boolean bl20;
            bCFISAdditionalConfiguration = new BCFISAdditionalConfiguration();
            bCFISAdditionalConfiguration.fis1 = bl20 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.fis2 = bl19 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.fis3 = bl18 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.stopWatch = bl17 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.oilTemp = bl16 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.digitalSpeed = bl15 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.refuelVolume = bl14 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.speedWarning = bl13 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.coolantTemp = bl12 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.secondarySpeed = bl11 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.vza = bl10 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.resetTime = bl9 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.comfortPowerConsumption = bl8 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.zeroEmissionTime = bl7 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.zeroEmissionDistance = bl6 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.vzaMfa = bl5 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.bcmeConsumerList = bl4 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.bcmeLiveTips = bl3 = iDeserializer.getBool();
            bCFISAdditionalConfiguration.astaMfa = bl2 = iDeserializer.getBool();
        }
        return bCFISAdditionalConfiguration;
    }

    public static BCFISAdditionalConfiguration[] getOptionalBCFISAdditionalConfigurationVarArray(IDeserializer iDeserializer) {
        BCFISAdditionalConfiguration[] bCFISAdditionalConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCFISAdditionalConfigurationArray = new BCFISAdditionalConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCFISAdditionalConfigurationArray[i2] = BCFISAdditionalConfigurationSerializer.getOptionalBCFISAdditionalConfiguration(iDeserializer);
            }
        }
        return bCFISAdditionalConfigurationArray;
    }
}

