/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCTemperature;

public class CarBCTemperatureSerializer {
    public static void putOptionalCarBCTemperature(ISerializer iSerializer, CarBCTemperature carBCTemperature) {
        boolean bl = carBCTemperature == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCTemperature.getState();
            iSerializer.putInt32(n);
            float f2 = carBCTemperature.getTemperatureValue();
            iSerializer.putFloat(f2);
            int n2 = carBCTemperature.getTemperatureUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCTemperatureVarArray(ISerializer iSerializer, CarBCTemperature[] carBCTemperatureArray) {
        boolean bl = carBCTemperatureArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCTemperatureArray.length);
            for (int i2 = 0; i2 < carBCTemperatureArray.length; ++i2) {
                CarBCTemperatureSerializer.putOptionalCarBCTemperature(iSerializer, carBCTemperatureArray[i2]);
            }
        }
    }

    public static CarBCTemperature getOptionalCarBCTemperature(IDeserializer iDeserializer) {
        CarBCTemperature carBCTemperature = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            carBCTemperature = new CarBCTemperature();
            carBCTemperature.state = n2 = iDeserializer.getInt32();
            carBCTemperature.temperatureValue = f2 = iDeserializer.getFloat();
            carBCTemperature.temperatureUnit = n = iDeserializer.getInt32();
        }
        return carBCTemperature;
    }

    public static CarBCTemperature[] getOptionalCarBCTemperatureVarArray(IDeserializer iDeserializer) {
        CarBCTemperature[] carBCTemperatureArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCTemperatureArray = new CarBCTemperature[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCTemperatureArray[i2] = CarBCTemperatureSerializer.getOptionalCarBCTemperature(iDeserializer);
            }
        }
        return carBCTemperatureArray;
    }
}

