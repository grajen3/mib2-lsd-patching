/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirQuality;

public class AirconAirQualitySerializer {
    public static void putOptionalAirconAirQuality(ISerializer iSerializer, AirconAirQuality airconAirQuality) {
        boolean bl = airconAirQuality == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconAirQuality.getOutsideCustomerThreshold();
            iSerializer.putInt32(n);
            int n2 = airconAirQuality.getOutsideOnlineData();
            iSerializer.putInt32(n2);
            int n3 = airconAirQuality.getIncarCO2();
            iSerializer.putInt32(n3);
            int n4 = airconAirQuality.getIncarPollution();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalAirconAirQualityVarArray(ISerializer iSerializer, AirconAirQuality[] airconAirQualityArray) {
        boolean bl = airconAirQualityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconAirQualityArray.length);
            for (int i2 = 0; i2 < airconAirQualityArray.length; ++i2) {
                AirconAirQualitySerializer.putOptionalAirconAirQuality(iSerializer, airconAirQualityArray[i2]);
            }
        }
    }

    public static AirconAirQuality getOptionalAirconAirQuality(IDeserializer iDeserializer) {
        AirconAirQuality airconAirQuality = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            airconAirQuality = new AirconAirQuality();
            airconAirQuality.outsideCustomerThreshold = n4 = iDeserializer.getInt32();
            airconAirQuality.outsideOnlineData = n3 = iDeserializer.getInt32();
            airconAirQuality.incarCO2 = n2 = iDeserializer.getInt32();
            airconAirQuality.incarPollution = n = iDeserializer.getInt32();
        }
        return airconAirQuality;
    }

    public static AirconAirQuality[] getOptionalAirconAirQualityVarArray(IDeserializer iDeserializer) {
        AirconAirQuality[] airconAirQualityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconAirQualityArray = new AirconAirQuality[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconAirQualityArray[i2] = AirconAirQualitySerializer.getOptionalAirconAirQuality(iDeserializer);
            }
        }
        return airconAirQualityArray;
    }
}

