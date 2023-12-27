/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCDistance;

public class CarBCDistanceSerializer {
    public static void putOptionalCarBCDistance(ISerializer iSerializer, CarBCDistance carBCDistance) {
        boolean bl = carBCDistance == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCDistance.getDistanceValueState();
            iSerializer.putInt32(n);
            double d2 = carBCDistance.getDistanceValue();
            iSerializer.putDouble(d2);
            int n2 = carBCDistance.getDistanceUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCDistanceVarArray(ISerializer iSerializer, CarBCDistance[] carBCDistanceArray) {
        boolean bl = carBCDistanceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCDistanceArray.length);
            for (int i2 = 0; i2 < carBCDistanceArray.length; ++i2) {
                CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistanceArray[i2]);
            }
        }
    }

    public static CarBCDistance getOptionalCarBCDistance(IDeserializer iDeserializer) {
        CarBCDistance carBCDistance = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            double d2;
            int n2;
            carBCDistance = new CarBCDistance();
            carBCDistance.distanceValueState = n2 = iDeserializer.getInt32();
            carBCDistance.distanceValue = d2 = iDeserializer.getDouble();
            carBCDistance.distanceUnit = n = iDeserializer.getInt32();
        }
        return carBCDistance;
    }

    public static CarBCDistance[] getOptionalCarBCDistanceVarArray(IDeserializer iDeserializer) {
        CarBCDistance[] carBCDistanceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCDistanceArray = new CarBCDistance[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCDistanceArray[i2] = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            }
        }
        return carBCDistanceArray;
    }
}

