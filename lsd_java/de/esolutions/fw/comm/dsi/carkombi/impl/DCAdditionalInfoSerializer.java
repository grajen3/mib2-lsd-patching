/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInfo;

public class DCAdditionalInfoSerializer {
    public static void putOptionalDCAdditionalInfo(ISerializer iSerializer, DCAdditionalInfo dCAdditionalInfo) {
        boolean bl = dCAdditionalInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCAdditionalInfo.isBlankLine();
            iSerializer.putBool(bl2);
            boolean bl3 = dCAdditionalInfo.isBoostPressure();
            iSerializer.putBool(bl3);
            boolean bl4 = dCAdditionalInfo.isOilPressure();
            iSerializer.putBool(bl4);
            boolean bl5 = dCAdditionalInfo.isOilTemperature();
            iSerializer.putBool(bl5);
            boolean bl6 = dCAdditionalInfo.isCoolantTemperature();
            iSerializer.putBool(bl6);
            boolean bl7 = dCAdditionalInfo.isFuelRange();
            iSerializer.putBool(bl7);
            boolean bl8 = dCAdditionalInfo.isDestinationArrivalTime();
            iSerializer.putBool(bl8);
            boolean bl9 = dCAdditionalInfo.isIntermediateArrivalTime();
            iSerializer.putBool(bl9);
            boolean bl10 = dCAdditionalInfo.isDestinationTripTime();
            iSerializer.putBool(bl10);
            boolean bl11 = dCAdditionalInfo.isIntermediateTripTime();
            iSerializer.putBool(bl11);
            boolean bl12 = dCAdditionalInfo.isCompass();
            iSerializer.putBool(bl12);
            boolean bl13 = dCAdditionalInfo.isGpsHeight();
            iSerializer.putBool(bl13);
            boolean bl14 = dCAdditionalInfo.isTime();
            iSerializer.putBool(bl14);
            boolean bl15 = dCAdditionalInfo.isDate();
            iSerializer.putBool(bl15);
            boolean bl16 = dCAdditionalInfo.isHybridBattery();
            iSerializer.putBool(bl16);
            boolean bl17 = dCAdditionalInfo.isStation();
            iSerializer.putBool(bl17);
            boolean bl18 = dCAdditionalInfo.isPhoneInfo();
            iSerializer.putBool(bl18);
            boolean bl19 = dCAdditionalInfo.isLateralAcceleration();
            iSerializer.putBool(bl19);
            boolean bl20 = dCAdditionalInfo.isAcceleration();
            iSerializer.putBool(bl20);
            boolean bl21 = dCAdditionalInfo.isDeceleration();
            iSerializer.putBool(bl21);
            boolean bl22 = dCAdditionalInfo.isElectricRange();
            iSerializer.putBool(bl22);
            boolean bl23 = dCAdditionalInfo.isBatteryStateOfCharge();
            iSerializer.putBool(bl23);
            boolean bl24 = dCAdditionalInfo.isChargingTimeLeft();
            iSerializer.putBool(bl24);
            boolean bl25 = dCAdditionalInfo.isBatteryTemperature();
            iSerializer.putBool(bl25);
            boolean bl26 = dCAdditionalInfo.isBatteryLevel();
            iSerializer.putBool(bl26);
            boolean bl27 = dCAdditionalInfo.isCoolant();
            iSerializer.putBool(bl27);
            boolean bl28 = dCAdditionalInfo.isBoostLevel();
            iSerializer.putBool(bl28);
            boolean bl29 = dCAdditionalInfo.isBatteryCoolant();
            iSerializer.putBool(bl29);
            boolean bl30 = dCAdditionalInfo.isBatteryBoost();
            iSerializer.putBool(bl30);
            boolean bl31 = dCAdditionalInfo.isBoostCoolant();
            iSerializer.putBool(bl31);
            boolean bl32 = dCAdditionalInfo.isVehicleVoltage();
            iSerializer.putBool(bl32);
            boolean bl33 = dCAdditionalInfo.isAverageConsumption();
            iSerializer.putBool(bl33);
            boolean bl34 = dCAdditionalInfo.isDistance();
            iSerializer.putBool(bl34);
            boolean bl35 = dCAdditionalInfo.isDrivingTime();
            iSerializer.putBool(bl35);
            boolean bl36 = dCAdditionalInfo.isCurrentConsumption();
            iSerializer.putBool(bl36);
            boolean bl37 = dCAdditionalInfo.isZeroEmission();
            iSerializer.putBool(bl37);
            boolean bl38 = dCAdditionalInfo.isDrivingProfile();
            iSerializer.putBool(bl38);
            boolean bl39 = dCAdditionalInfo.isSecondarySpeed();
            iSerializer.putBool(bl39);
            boolean bl40 = dCAdditionalInfo.isDigitalSpeed();
            iSerializer.putBool(bl40);
            boolean bl41 = dCAdditionalInfo.isEnergyFlow();
            iSerializer.putBool(bl41);
            boolean bl42 = dCAdditionalInfo.isACC();
            iSerializer.putBool(bl42);
            boolean bl43 = dCAdditionalInfo.isRouteGuidance();
            iSerializer.putBool(bl43);
            boolean bl44 = dCAdditionalInfo.isTrafficSignDetection();
            iSerializer.putBool(bl44);
            boolean bl45 = dCAdditionalInfo.isShiftUpIndication();
            iSerializer.putBool(bl45);
            boolean bl46 = dCAdditionalInfo.isPerformance();
            iSerializer.putBool(bl46);
            boolean bl47 = dCAdditionalInfo.isPredictiveEfficiencyAssistant();
            iSerializer.putBool(bl47);
            boolean bl48 = dCAdditionalInfo.isWildcard();
            iSerializer.putBool(bl48);
            boolean bl49 = dCAdditionalInfo.isSteeringAngle();
            iSerializer.putBool(bl49);
            boolean bl50 = dCAdditionalInfo.isSlope();
            iSerializer.putBool(bl50);
            boolean bl51 = dCAdditionalInfo.isConsumptionData();
            iSerializer.putBool(bl51);
            boolean bl52 = dCAdditionalInfo.isCombustorConsumption();
            iSerializer.putBool(bl52);
            boolean bl53 = dCAdditionalInfo.isElectricalConsumption();
            iSerializer.putBool(bl53);
            boolean bl54 = dCAdditionalInfo.isAverageSpeed();
            iSerializer.putBool(bl54);
            boolean bl55 = dCAdditionalInfo.isPowermeter();
            iSerializer.putBool(bl55);
            boolean bl56 = dCAdditionalInfo.isTachometer();
            iSerializer.putBool(bl56);
            boolean bl57 = dCAdditionalInfo.isPowermeterAndTachometer();
            iSerializer.putBool(bl57);
            boolean bl58 = dCAdditionalInfo.isHybrid();
            iSerializer.putBool(bl58);
            boolean bl59 = dCAdditionalInfo.isEngineData();
            iSerializer.putBool(bl59);
            boolean bl60 = dCAdditionalInfo.isShortTermData();
            iSerializer.putBool(bl60);
            boolean bl61 = dCAdditionalInfo.isLongTermData();
            iSerializer.putBool(bl61);
            boolean bl62 = dCAdditionalInfo.isGMeter();
            iSerializer.putBool(bl62);
            boolean bl63 = dCAdditionalInfo.isTyrePressureMonitor();
            iSerializer.putBool(bl63);
        }
    }

    public static void putOptionalDCAdditionalInfoVarArray(ISerializer iSerializer, DCAdditionalInfo[] dCAdditionalInfoArray) {
        boolean bl = dCAdditionalInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCAdditionalInfoArray.length);
            for (int i2 = 0; i2 < dCAdditionalInfoArray.length; ++i2) {
                DCAdditionalInfoSerializer.putOptionalDCAdditionalInfo(iSerializer, dCAdditionalInfoArray[i2]);
            }
        }
    }

    public static DCAdditionalInfo getOptionalDCAdditionalInfo(IDeserializer iDeserializer) {
        DCAdditionalInfo dCAdditionalInfo = null;
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
            boolean bl31;
            boolean bl32;
            boolean bl33;
            boolean bl34;
            boolean bl35;
            boolean bl36;
            boolean bl37;
            boolean bl38;
            boolean bl39;
            boolean bl40;
            boolean bl41;
            boolean bl42;
            boolean bl43;
            boolean bl44;
            boolean bl45;
            boolean bl46;
            boolean bl47;
            boolean bl48;
            boolean bl49;
            boolean bl50;
            boolean bl51;
            boolean bl52;
            boolean bl53;
            boolean bl54;
            boolean bl55;
            boolean bl56;
            boolean bl57;
            boolean bl58;
            boolean bl59;
            boolean bl60;
            boolean bl61;
            boolean bl62;
            boolean bl63;
            dCAdditionalInfo = new DCAdditionalInfo();
            dCAdditionalInfo.blankLine = bl63 = iDeserializer.getBool();
            dCAdditionalInfo.boostPressure = bl62 = iDeserializer.getBool();
            dCAdditionalInfo.oilPressure = bl61 = iDeserializer.getBool();
            dCAdditionalInfo.oilTemperature = bl60 = iDeserializer.getBool();
            dCAdditionalInfo.coolantTemperature = bl59 = iDeserializer.getBool();
            dCAdditionalInfo.fuelRange = bl58 = iDeserializer.getBool();
            dCAdditionalInfo.destinationArrivalTime = bl57 = iDeserializer.getBool();
            dCAdditionalInfo.intermediateArrivalTime = bl56 = iDeserializer.getBool();
            dCAdditionalInfo.destinationTripTime = bl55 = iDeserializer.getBool();
            dCAdditionalInfo.intermediateTripTime = bl54 = iDeserializer.getBool();
            dCAdditionalInfo.compass = bl53 = iDeserializer.getBool();
            dCAdditionalInfo.gpsHeight = bl52 = iDeserializer.getBool();
            dCAdditionalInfo.time = bl51 = iDeserializer.getBool();
            dCAdditionalInfo.date = bl50 = iDeserializer.getBool();
            dCAdditionalInfo.hybridBattery = bl49 = iDeserializer.getBool();
            dCAdditionalInfo.station = bl48 = iDeserializer.getBool();
            dCAdditionalInfo.phoneInfo = bl47 = iDeserializer.getBool();
            dCAdditionalInfo.lateralAcceleration = bl46 = iDeserializer.getBool();
            dCAdditionalInfo.acceleration = bl45 = iDeserializer.getBool();
            dCAdditionalInfo.deceleration = bl44 = iDeserializer.getBool();
            dCAdditionalInfo.electricRange = bl43 = iDeserializer.getBool();
            dCAdditionalInfo.batteryStateOfCharge = bl42 = iDeserializer.getBool();
            dCAdditionalInfo.chargingTimeLeft = bl41 = iDeserializer.getBool();
            dCAdditionalInfo.batteryTemperature = bl40 = iDeserializer.getBool();
            dCAdditionalInfo.batteryLevel = bl39 = iDeserializer.getBool();
            dCAdditionalInfo.coolant = bl38 = iDeserializer.getBool();
            dCAdditionalInfo.boostLevel = bl37 = iDeserializer.getBool();
            dCAdditionalInfo.batteryCoolant = bl36 = iDeserializer.getBool();
            dCAdditionalInfo.batteryBoost = bl35 = iDeserializer.getBool();
            dCAdditionalInfo.boostCoolant = bl34 = iDeserializer.getBool();
            dCAdditionalInfo.vehicleVoltage = bl33 = iDeserializer.getBool();
            dCAdditionalInfo.averageConsumption = bl32 = iDeserializer.getBool();
            dCAdditionalInfo.distance = bl31 = iDeserializer.getBool();
            dCAdditionalInfo.drivingTime = bl30 = iDeserializer.getBool();
            dCAdditionalInfo.currentConsumption = bl29 = iDeserializer.getBool();
            dCAdditionalInfo.zeroEmission = bl28 = iDeserializer.getBool();
            dCAdditionalInfo.drivingProfile = bl27 = iDeserializer.getBool();
            dCAdditionalInfo.secondarySpeed = bl26 = iDeserializer.getBool();
            dCAdditionalInfo.digitalSpeed = bl25 = iDeserializer.getBool();
            dCAdditionalInfo.energyFlow = bl24 = iDeserializer.getBool();
            dCAdditionalInfo.aCC = bl23 = iDeserializer.getBool();
            dCAdditionalInfo.routeGuidance = bl22 = iDeserializer.getBool();
            dCAdditionalInfo.trafficSignDetection = bl21 = iDeserializer.getBool();
            dCAdditionalInfo.shiftUpIndication = bl20 = iDeserializer.getBool();
            dCAdditionalInfo.performance = bl19 = iDeserializer.getBool();
            dCAdditionalInfo.predictiveEfficiencyAssistant = bl18 = iDeserializer.getBool();
            dCAdditionalInfo.wildcard = bl17 = iDeserializer.getBool();
            dCAdditionalInfo.steeringAngle = bl16 = iDeserializer.getBool();
            dCAdditionalInfo.slope = bl15 = iDeserializer.getBool();
            dCAdditionalInfo.consumptionData = bl14 = iDeserializer.getBool();
            dCAdditionalInfo.combustorConsumption = bl13 = iDeserializer.getBool();
            dCAdditionalInfo.electricalConsumption = bl12 = iDeserializer.getBool();
            dCAdditionalInfo.averageSpeed = bl11 = iDeserializer.getBool();
            dCAdditionalInfo.powermeter = bl10 = iDeserializer.getBool();
            dCAdditionalInfo.tachometer = bl9 = iDeserializer.getBool();
            dCAdditionalInfo.powermeterAndTachometer = bl8 = iDeserializer.getBool();
            dCAdditionalInfo.hybrid = bl7 = iDeserializer.getBool();
            dCAdditionalInfo.engineData = bl6 = iDeserializer.getBool();
            dCAdditionalInfo.shortTermData = bl5 = iDeserializer.getBool();
            dCAdditionalInfo.longTermData = bl4 = iDeserializer.getBool();
            dCAdditionalInfo.gMeter = bl3 = iDeserializer.getBool();
            dCAdditionalInfo.tyrePressureMonitor = bl2 = iDeserializer.getBool();
        }
        return dCAdditionalInfo;
    }

    public static DCAdditionalInfo[] getOptionalDCAdditionalInfoVarArray(IDeserializer iDeserializer) {
        DCAdditionalInfo[] dCAdditionalInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCAdditionalInfoArray = new DCAdditionalInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCAdditionalInfoArray[i2] = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
            }
        }
        return dCAdditionalInfoArray;
    }
}

