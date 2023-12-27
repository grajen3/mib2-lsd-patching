/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;

public class AirconSteeringWheelHeaterSerializer {
    public static void putOptionalAirconSteeringWheelHeater(ISerializer iSerializer, AirconSteeringWheelHeater airconSteeringWheelHeater) {
        boolean bl = airconSteeringWheelHeater == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconSteeringWheelHeater.isHeating();
            iSerializer.putBool(bl2);
            boolean bl3 = airconSteeringWheelHeater.isCurrentState();
            iSerializer.putBool(bl3);
            boolean bl4 = airconSteeringWheelHeater.isAutoHeating();
            iSerializer.putBool(bl4);
            boolean bl5 = airconSteeringWheelHeater.isAdjustViaSeatHeating();
            iSerializer.putBool(bl5);
            int n = airconSteeringWheelHeater.getHeatingStep();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalAirconSteeringWheelHeaterVarArray(ISerializer iSerializer, AirconSteeringWheelHeater[] airconSteeringWheelHeaterArray) {
        boolean bl = airconSteeringWheelHeaterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconSteeringWheelHeaterArray.length);
            for (int i2 = 0; i2 < airconSteeringWheelHeaterArray.length; ++i2) {
                AirconSteeringWheelHeaterSerializer.putOptionalAirconSteeringWheelHeater(iSerializer, airconSteeringWheelHeaterArray[i2]);
            }
        }
    }

    public static AirconSteeringWheelHeater getOptionalAirconSteeringWheelHeater(IDeserializer iDeserializer) {
        AirconSteeringWheelHeater airconSteeringWheelHeater = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            airconSteeringWheelHeater = new AirconSteeringWheelHeater();
            airconSteeringWheelHeater.heating = bl5 = iDeserializer.getBool();
            airconSteeringWheelHeater.currentState = bl4 = iDeserializer.getBool();
            airconSteeringWheelHeater.autoHeating = bl3 = iDeserializer.getBool();
            airconSteeringWheelHeater.adjustViaSeatHeating = bl2 = iDeserializer.getBool();
            airconSteeringWheelHeater.heatingStep = n = iDeserializer.getInt32();
        }
        return airconSteeringWheelHeater;
    }

    public static AirconSteeringWheelHeater[] getOptionalAirconSteeringWheelHeaterVarArray(IDeserializer iDeserializer) {
        AirconSteeringWheelHeater[] airconSteeringWheelHeaterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconSteeringWheelHeaterArray = new AirconSteeringWheelHeater[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconSteeringWheelHeaterArray[i2] = AirconSteeringWheelHeaterSerializer.getOptionalAirconSteeringWheelHeater(iDeserializer);
            }
        }
        return airconSteeringWheelHeaterArray;
    }
}

