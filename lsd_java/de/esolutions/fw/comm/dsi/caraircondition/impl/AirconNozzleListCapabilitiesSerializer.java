/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;

public class AirconNozzleListCapabilitiesSerializer {
    public static void putOptionalAirconNozzleListCapabilities(ISerializer iSerializer, AirconNozzleListCapabilities airconNozzleListCapabilities) {
        boolean bl = airconNozzleListCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconNozzleListCapabilities.isHorizontalPosition();
            iSerializer.putBool(bl2);
            boolean bl3 = airconNozzleListCapabilities.isVerticalPosition();
            iSerializer.putBool(bl3);
            boolean bl4 = airconNozzleListCapabilities.isAirflow();
            iSerializer.putBool(bl4);
            boolean bl5 = airconNozzleListCapabilities.isStyle();
            iSerializer.putBool(bl5);
            boolean bl6 = airconNozzleListCapabilities.isIntervalHorizontal();
            iSerializer.putBool(bl6);
            boolean bl7 = airconNozzleListCapabilities.isIntervalVertical();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalAirconNozzleListCapabilitiesVarArray(ISerializer iSerializer, AirconNozzleListCapabilities[] airconNozzleListCapabilitiesArray) {
        boolean bl = airconNozzleListCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconNozzleListCapabilitiesArray.length);
            for (int i2 = 0; i2 < airconNozzleListCapabilitiesArray.length; ++i2) {
                AirconNozzleListCapabilitiesSerializer.putOptionalAirconNozzleListCapabilities(iSerializer, airconNozzleListCapabilitiesArray[i2]);
            }
        }
    }

    public static AirconNozzleListCapabilities getOptionalAirconNozzleListCapabilities(IDeserializer iDeserializer) {
        AirconNozzleListCapabilities airconNozzleListCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            airconNozzleListCapabilities = new AirconNozzleListCapabilities();
            airconNozzleListCapabilities.horizontalPosition = bl7 = iDeserializer.getBool();
            airconNozzleListCapabilities.verticalPosition = bl6 = iDeserializer.getBool();
            airconNozzleListCapabilities.airflow = bl5 = iDeserializer.getBool();
            airconNozzleListCapabilities.style = bl4 = iDeserializer.getBool();
            airconNozzleListCapabilities.intervalHorizontal = bl3 = iDeserializer.getBool();
            airconNozzleListCapabilities.intervalVertical = bl2 = iDeserializer.getBool();
        }
        return airconNozzleListCapabilities;
    }

    public static AirconNozzleListCapabilities[] getOptionalAirconNozzleListCapabilitiesVarArray(IDeserializer iDeserializer) {
        AirconNozzleListCapabilities[] airconNozzleListCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconNozzleListCapabilitiesArray = new AirconNozzleListCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconNozzleListCapabilitiesArray[i2] = AirconNozzleListCapabilitiesSerializer.getOptionalAirconNozzleListCapabilities(iDeserializer);
            }
        }
        return airconNozzleListCapabilitiesArray;
    }
}

