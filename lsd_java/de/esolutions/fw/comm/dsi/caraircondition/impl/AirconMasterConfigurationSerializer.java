/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconMasterConfiguration;

public class AirconMasterConfigurationSerializer {
    public static void putOptionalAirconMasterConfiguration(ISerializer iSerializer, AirconMasterConfiguration airconMasterConfiguration) {
        boolean bl = airconMasterConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconMasterConfiguration.isCarDriverSide();
            iSerializer.putBool(bl2);
            int n = airconMasterConfiguration.getNumberOfZones();
            iSerializer.putInt32(n);
            boolean bl3 = airconMasterConfiguration.isZl1r();
            iSerializer.putBool(bl3);
            boolean bl4 = airconMasterConfiguration.isZr1r();
            iSerializer.putBool(bl4);
            boolean bl5 = airconMasterConfiguration.isZl2r();
            iSerializer.putBool(bl5);
            boolean bl6 = airconMasterConfiguration.isZr2r();
            iSerializer.putBool(bl6);
            boolean bl7 = airconMasterConfiguration.isZl3r();
            iSerializer.putBool(bl7);
            boolean bl8 = airconMasterConfiguration.isZr3r();
            iSerializer.putBool(bl8);
            boolean bl9 = airconMasterConfiguration.isFreshAirCartridge1();
            iSerializer.putBool(bl9);
            boolean bl10 = airconMasterConfiguration.isFreshAirCartridge2();
            iSerializer.putBool(bl10);
            boolean bl11 = airconMasterConfiguration.isPureAirIonisator();
            iSerializer.putBool(bl11);
            boolean bl12 = airconMasterConfiguration.isPureAirFragrance();
            iSerializer.putBool(bl12);
            boolean bl13 = airconMasterConfiguration.isAirQualityParticleSensor();
            iSerializer.putBool(bl13);
            boolean bl14 = airconMasterConfiguration.isAirQualityInCarQualityCO2();
            iSerializer.putBool(bl14);
            boolean bl15 = airconMasterConfiguration.isAirQualityInCarQualityPollution();
            iSerializer.putBool(bl15);
            boolean bl16 = airconMasterConfiguration.isAirQualityOutsideCustomerThreshold();
            iSerializer.putBool(bl16);
        }
    }

    public static void putOptionalAirconMasterConfigurationVarArray(ISerializer iSerializer, AirconMasterConfiguration[] airconMasterConfigurationArray) {
        boolean bl = airconMasterConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconMasterConfigurationArray.length);
            for (int i2 = 0; i2 < airconMasterConfigurationArray.length; ++i2) {
                AirconMasterConfigurationSerializer.putOptionalAirconMasterConfiguration(iSerializer, airconMasterConfigurationArray[i2]);
            }
        }
    }

    public static AirconMasterConfiguration getOptionalAirconMasterConfiguration(IDeserializer iDeserializer) {
        AirconMasterConfiguration airconMasterConfiguration = null;
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
            int n;
            boolean bl16;
            airconMasterConfiguration = new AirconMasterConfiguration();
            airconMasterConfiguration.carDriverSide = bl16 = iDeserializer.getBool();
            airconMasterConfiguration.numberOfZones = n = iDeserializer.getInt32();
            airconMasterConfiguration.zl1r = bl15 = iDeserializer.getBool();
            airconMasterConfiguration.zr1r = bl14 = iDeserializer.getBool();
            airconMasterConfiguration.zl2r = bl13 = iDeserializer.getBool();
            airconMasterConfiguration.zr2r = bl12 = iDeserializer.getBool();
            airconMasterConfiguration.zl3r = bl11 = iDeserializer.getBool();
            airconMasterConfiguration.zr3r = bl10 = iDeserializer.getBool();
            airconMasterConfiguration.freshAirCartridge1 = bl9 = iDeserializer.getBool();
            airconMasterConfiguration.freshAirCartridge2 = bl8 = iDeserializer.getBool();
            airconMasterConfiguration.pureAirIonisator = bl7 = iDeserializer.getBool();
            airconMasterConfiguration.pureAirFragrance = bl6 = iDeserializer.getBool();
            airconMasterConfiguration.airQualityParticleSensor = bl5 = iDeserializer.getBool();
            airconMasterConfiguration.airQualityInCarQualityCO2 = bl4 = iDeserializer.getBool();
            airconMasterConfiguration.airQualityInCarQualityPollution = bl3 = iDeserializer.getBool();
            airconMasterConfiguration.airQualityOutsideCustomerThreshold = bl2 = iDeserializer.getBool();
        }
        return airconMasterConfiguration;
    }

    public static AirconMasterConfiguration[] getOptionalAirconMasterConfigurationVarArray(IDeserializer iDeserializer) {
        AirconMasterConfiguration[] airconMasterConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconMasterConfigurationArray = new AirconMasterConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconMasterConfigurationArray[i2] = AirconMasterConfigurationSerializer.getOptionalAirconMasterConfiguration(iDeserializer);
            }
        }
        return airconMasterConfigurationArray;
    }
}

