/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCSpeed;

public class CarBCSpeedSerializer {
    public static void putOptionalCarBCSpeed(ISerializer iSerializer, CarBCSpeed carBCSpeed) {
        boolean bl = carBCSpeed == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCSpeed.getSpeedValueState();
            iSerializer.putInt32(n);
            float f2 = carBCSpeed.getSpeedValue();
            iSerializer.putFloat(f2);
            int n2 = carBCSpeed.getSpeedUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCSpeedVarArray(ISerializer iSerializer, CarBCSpeed[] carBCSpeedArray) {
        boolean bl = carBCSpeedArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCSpeedArray.length);
            for (int i2 = 0; i2 < carBCSpeedArray.length; ++i2) {
                CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeedArray[i2]);
            }
        }
    }

    public static CarBCSpeed getOptionalCarBCSpeed(IDeserializer iDeserializer) {
        CarBCSpeed carBCSpeed = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            carBCSpeed = new CarBCSpeed();
            carBCSpeed.speedValueState = n2 = iDeserializer.getInt32();
            carBCSpeed.speedValue = f2 = iDeserializer.getFloat();
            carBCSpeed.speedUnit = n = iDeserializer.getInt32();
        }
        return carBCSpeed;
    }

    public static CarBCSpeed[] getOptionalCarBCSpeedVarArray(IDeserializer iDeserializer) {
        CarBCSpeed[] carBCSpeedArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCSpeedArray = new CarBCSpeed[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCSpeedArray[i2] = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            }
        }
        return carBCSpeedArray;
    }
}

