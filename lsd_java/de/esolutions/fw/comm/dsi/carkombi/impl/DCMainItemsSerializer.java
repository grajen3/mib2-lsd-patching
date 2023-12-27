/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCMainItems;

public class DCMainItemsSerializer {
    public static void putOptionalDCMainItems(ISerializer iSerializer, DCMainItems dCMainItems) {
        boolean bl = dCMainItems == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCMainItems.isWeatherTemperature();
            iSerializer.putBool(bl2);
            boolean bl3 = dCMainItems.isRoadSignNotification();
            iSerializer.putBool(bl3);
            boolean bl4 = dCMainItems.isHighBeamAssistant();
            iSerializer.putBool(bl4);
            boolean bl5 = dCMainItems.isFASACC();
            iSerializer.putBool(bl5);
            boolean bl6 = dCMainItems.isSpeedLimitScreen();
            iSerializer.putBool(bl6);
            boolean bl7 = dCMainItems.isTripScreen();
            iSerializer.putBool(bl7);
            boolean bl8 = dCMainItems.isTyrePressureControl();
            iSerializer.putBool(bl8);
            boolean bl9 = dCMainItems.isSportChrono();
            iSerializer.putBool(bl9);
            boolean bl10 = dCMainItems.isShiftAssist();
            iSerializer.putBool(bl10);
            boolean bl11 = dCMainItems.isGForce();
            iSerializer.putBool(bl11);
            boolean bl12 = dCMainItems.isPerformance();
            iSerializer.putBool(bl12);
            boolean bl13 = dCMainItems.isOffroadAllWheel();
            iSerializer.putBool(bl13);
            boolean bl14 = dCMainItems.isEfficiency();
            iSerializer.putBool(bl14);
            boolean bl15 = dCMainItems.isBoost();
            iSerializer.putBool(bl15);
            boolean bl16 = dCMainItems.isHybrid();
            iSerializer.putBool(bl16);
            boolean bl17 = dCMainItems.isEConsumption();
            iSerializer.putBool(bl17);
            boolean bl18 = dCMainItems.isNightvision();
            iSerializer.putBool(bl18);
            boolean bl19 = dCMainItems.isNightvisionMap();
            iSerializer.putBool(bl19);
            boolean bl20 = dCMainItems.isInfo();
            iSerializer.putBool(bl20);
            boolean bl21 = dCMainItems.isCarMain();
            iSerializer.putBool(bl21);
            boolean bl22 = dCMainItems.isEMobility();
            iSerializer.putBool(bl22);
            boolean bl23 = dCMainItems.isNavigation();
            iSerializer.putBool(bl23);
            boolean bl24 = dCMainItems.isIndividual();
            iSerializer.putBool(bl24);
            boolean bl25 = dCMainItems.isAudioMedia();
            iSerializer.putBool(bl25);
            boolean bl26 = dCMainItems.isTelephone();
            iSerializer.putBool(bl26);
            boolean bl27 = dCMainItems.isPowerMonitor();
            iSerializer.putBool(bl27);
            boolean bl28 = dCMainItems.isProtectiveShield();
            iSerializer.putBool(bl28);
            boolean bl29 = dCMainItems.isSpeedometer();
            iSerializer.putBool(bl29);
            boolean bl30 = dCMainItems.isTrafficLightInfo();
            iSerializer.putBool(bl30);
        }
    }

    public static void putOptionalDCMainItemsVarArray(ISerializer iSerializer, DCMainItems[] dCMainItemsArray) {
        boolean bl = dCMainItemsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCMainItemsArray.length);
            for (int i2 = 0; i2 < dCMainItemsArray.length; ++i2) {
                DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, dCMainItemsArray[i2]);
            }
        }
    }

    public static DCMainItems getOptionalDCMainItems(IDeserializer iDeserializer) {
        DCMainItems dCMainItems = null;
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
            boolean bl21;
            boolean bl22;
            boolean bl23;
            boolean bl24;
            boolean bl25;
            boolean bl26;
            boolean bl27;
            boolean bl28;
            boolean bl29;
            boolean bl30;
            dCMainItems = new DCMainItems();
            dCMainItems.weatherTemperature = bl30 = iDeserializer.getBool();
            dCMainItems.roadSignNotification = bl29 = iDeserializer.getBool();
            dCMainItems.highBeamAssistant = bl28 = iDeserializer.getBool();
            dCMainItems.fASACC = bl27 = iDeserializer.getBool();
            dCMainItems.speedLimitScreen = bl26 = iDeserializer.getBool();
            dCMainItems.tripScreen = bl25 = iDeserializer.getBool();
            dCMainItems.tyrePressureControl = bl24 = iDeserializer.getBool();
            dCMainItems.sportChrono = bl23 = iDeserializer.getBool();
            dCMainItems.shiftAssist = bl22 = iDeserializer.getBool();
            dCMainItems.gForce = bl21 = iDeserializer.getBool();
            dCMainItems.performance = bl20 = iDeserializer.getBool();
            dCMainItems.offroadAllWheel = bl19 = iDeserializer.getBool();
            dCMainItems.efficiency = bl18 = iDeserializer.getBool();
            dCMainItems.boost = bl17 = iDeserializer.getBool();
            dCMainItems.hybrid = bl16 = iDeserializer.getBool();
            dCMainItems.eConsumption = bl15 = iDeserializer.getBool();
            dCMainItems.nightvision = bl14 = iDeserializer.getBool();
            dCMainItems.nightvisionMap = bl13 = iDeserializer.getBool();
            dCMainItems.info = bl12 = iDeserializer.getBool();
            dCMainItems.carMain = bl11 = iDeserializer.getBool();
            dCMainItems.eMobility = bl10 = iDeserializer.getBool();
            dCMainItems.navigation = bl9 = iDeserializer.getBool();
            dCMainItems.individual = bl8 = iDeserializer.getBool();
            dCMainItems.audioMedia = bl7 = iDeserializer.getBool();
            dCMainItems.telephone = bl6 = iDeserializer.getBool();
            dCMainItems.powerMonitor = bl5 = iDeserializer.getBool();
            dCMainItems.protectiveShield = bl4 = iDeserializer.getBool();
            dCMainItems.speedometer = bl3 = iDeserializer.getBool();
            dCMainItems.trafficLightInfo = bl2 = iDeserializer.getBool();
        }
        return dCMainItems;
    }

    public static DCMainItems[] getOptionalDCMainItemsVarArray(IDeserializer iDeserializer) {
        DCMainItems[] dCMainItemsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCMainItemsArray = new DCMainItems[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCMainItemsArray[i2] = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
            }
        }
        return dCMainItemsArray;
    }
}

