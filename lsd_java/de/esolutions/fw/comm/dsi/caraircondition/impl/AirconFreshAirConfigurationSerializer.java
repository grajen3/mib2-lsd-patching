/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;

public class AirconFreshAirConfigurationSerializer {
    public static void putOptionalAirconFreshAirConfiguration(ISerializer iSerializer, AirconFreshAirConfiguration airconFreshAirConfiguration) {
        boolean bl = airconFreshAirConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconFreshAirConfiguration.getSetup();
            iSerializer.putInt32(n);
            int n2 = airconFreshAirConfiguration.getFlavourSelection();
            iSerializer.putInt32(n2);
            int n3 = airconFreshAirConfiguration.getIntensityCartridge1();
            iSerializer.putInt32(n3);
            int n4 = airconFreshAirConfiguration.getIntensityCartridge2();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalAirconFreshAirConfigurationVarArray(ISerializer iSerializer, AirconFreshAirConfiguration[] airconFreshAirConfigurationArray) {
        boolean bl = airconFreshAirConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconFreshAirConfigurationArray.length);
            for (int i2 = 0; i2 < airconFreshAirConfigurationArray.length; ++i2) {
                AirconFreshAirConfigurationSerializer.putOptionalAirconFreshAirConfiguration(iSerializer, airconFreshAirConfigurationArray[i2]);
            }
        }
    }

    public static AirconFreshAirConfiguration getOptionalAirconFreshAirConfiguration(IDeserializer iDeserializer) {
        AirconFreshAirConfiguration airconFreshAirConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            airconFreshAirConfiguration = new AirconFreshAirConfiguration();
            airconFreshAirConfiguration.setup = n4 = iDeserializer.getInt32();
            airconFreshAirConfiguration.flavourSelection = n3 = iDeserializer.getInt32();
            airconFreshAirConfiguration.intensityCartridge1 = n2 = iDeserializer.getInt32();
            airconFreshAirConfiguration.intensityCartridge2 = n = iDeserializer.getInt32();
        }
        return airconFreshAirConfiguration;
    }

    public static AirconFreshAirConfiguration[] getOptionalAirconFreshAirConfigurationVarArray(IDeserializer iDeserializer) {
        AirconFreshAirConfiguration[] airconFreshAirConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconFreshAirConfigurationArray = new AirconFreshAirConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconFreshAirConfigurationArray[i2] = AirconFreshAirConfigurationSerializer.getOptionalAirconFreshAirConfiguration(iDeserializer);
            }
        }
        return airconFreshAirConfigurationArray;
    }
}

