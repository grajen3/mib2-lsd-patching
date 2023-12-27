/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class WheelTemperaturesSerializer {
    public static void putOptionalWheelTemperatures(ISerializer iSerializer, WheelTemperatures wheelTemperatures) {
        boolean bl = wheelTemperatures == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wheelTemperatures.getTemperatureUnit();
            iSerializer.putInt32(n);
            int n2 = wheelTemperatures.getFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = wheelTemperatures.getFrontRight();
            iSerializer.putInt32(n3);
            int n4 = wheelTemperatures.getRearLeft();
            iSerializer.putInt32(n4);
            int n5 = wheelTemperatures.getRearRight();
            iSerializer.putInt32(n5);
            int n6 = wheelTemperatures.getSpareWheel();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalWheelTemperaturesVarArray(ISerializer iSerializer, WheelTemperatures[] wheelTemperaturesArray) {
        boolean bl = wheelTemperaturesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wheelTemperaturesArray.length);
            for (int i2 = 0; i2 < wheelTemperaturesArray.length; ++i2) {
                WheelTemperaturesSerializer.putOptionalWheelTemperatures(iSerializer, wheelTemperaturesArray[i2]);
            }
        }
    }

    public static WheelTemperatures getOptionalWheelTemperatures(IDeserializer iDeserializer) {
        WheelTemperatures wheelTemperatures = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            wheelTemperatures = new WheelTemperatures();
            wheelTemperatures.temperatureUnit = n6 = iDeserializer.getInt32();
            wheelTemperatures.frontLeft = n5 = iDeserializer.getInt32();
            wheelTemperatures.frontRight = n4 = iDeserializer.getInt32();
            wheelTemperatures.rearLeft = n3 = iDeserializer.getInt32();
            wheelTemperatures.rearRight = n2 = iDeserializer.getInt32();
            wheelTemperatures.spareWheel = n = iDeserializer.getInt32();
        }
        return wheelTemperatures;
    }

    public static WheelTemperatures[] getOptionalWheelTemperaturesVarArray(IDeserializer iDeserializer) {
        WheelTemperatures[] wheelTemperaturesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wheelTemperaturesArray = new WheelTemperatures[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wheelTemperaturesArray[i2] = WheelTemperaturesSerializer.getOptionalWheelTemperatures(iDeserializer);
            }
        }
        return wheelTemperaturesArray;
    }
}

