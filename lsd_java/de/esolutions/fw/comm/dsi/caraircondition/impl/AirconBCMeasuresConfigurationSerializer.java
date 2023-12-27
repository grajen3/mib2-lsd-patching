/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;

public class AirconBCMeasuresConfigurationSerializer {
    public static void putOptionalAirconBCMeasuresConfiguration(ISerializer iSerializer, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        boolean bl = airconBCMeasuresConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconBCMeasuresConfiguration.isSwh();
            iSerializer.putBool(bl2);
            boolean bl3 = airconBCMeasuresConfiguration.isSeatHeater();
            iSerializer.putBool(bl3);
            boolean bl4 = airconBCMeasuresConfiguration.isSeatVentilation();
            iSerializer.putBool(bl4);
            boolean bl5 = airconBCMeasuresConfiguration.isSurfaceHeater();
            iSerializer.putBool(bl5);
            boolean bl6 = airconBCMeasuresConfiguration.isNeckHeater();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalAirconBCMeasuresConfigurationVarArray(ISerializer iSerializer, AirconBCMeasuresConfiguration[] airconBCMeasuresConfigurationArray) {
        boolean bl = airconBCMeasuresConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconBCMeasuresConfigurationArray.length);
            for (int i2 = 0; i2 < airconBCMeasuresConfigurationArray.length; ++i2) {
                AirconBCMeasuresConfigurationSerializer.putOptionalAirconBCMeasuresConfiguration(iSerializer, airconBCMeasuresConfigurationArray[i2]);
            }
        }
    }

    public static AirconBCMeasuresConfiguration getOptionalAirconBCMeasuresConfiguration(IDeserializer iDeserializer) {
        AirconBCMeasuresConfiguration airconBCMeasuresConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            airconBCMeasuresConfiguration = new AirconBCMeasuresConfiguration();
            airconBCMeasuresConfiguration.swh = bl6 = iDeserializer.getBool();
            airconBCMeasuresConfiguration.seatHeater = bl5 = iDeserializer.getBool();
            airconBCMeasuresConfiguration.seatVentilation = bl4 = iDeserializer.getBool();
            airconBCMeasuresConfiguration.surfaceHeater = bl3 = iDeserializer.getBool();
            airconBCMeasuresConfiguration.neckHeater = bl2 = iDeserializer.getBool();
        }
        return airconBCMeasuresConfiguration;
    }

    public static AirconBCMeasuresConfiguration[] getOptionalAirconBCMeasuresConfigurationVarArray(IDeserializer iDeserializer) {
        AirconBCMeasuresConfiguration[] airconBCMeasuresConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconBCMeasuresConfigurationArray = new AirconBCMeasuresConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconBCMeasuresConfigurationArray[i2] = AirconBCMeasuresConfigurationSerializer.getOptionalAirconBCMeasuresConfiguration(iDeserializer);
            }
        }
        return airconBCMeasuresConfigurationArray;
    }
}

