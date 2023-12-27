/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class CarPositionSerializer {
    public static void putOptionalCarPosition(ISerializer iSerializer, CarPosition carPosition) {
        boolean bl = carPosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            double d2 = carPosition.getLongitude();
            iSerializer.putDouble(d2);
            double d3 = carPosition.getLatitude();
            iSerializer.putDouble(d3);
            int n = carPosition.getAngle();
            iSerializer.putInt32(n);
            int n2 = carPosition.getSpeed();
            iSerializer.putInt32(n2);
            int n3 = carPosition.getHeight();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCarPositionVarArray(ISerializer iSerializer, CarPosition[] carPositionArray) {
        boolean bl = carPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carPositionArray.length);
            for (int i2 = 0; i2 < carPositionArray.length; ++i2) {
                CarPositionSerializer.putOptionalCarPosition(iSerializer, carPositionArray[i2]);
            }
        }
    }

    public static CarPosition getOptionalCarPosition(IDeserializer iDeserializer) {
        CarPosition carPosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            double d2;
            double d3;
            carPosition = new CarPosition();
            carPosition.longitude = d3 = iDeserializer.getDouble();
            carPosition.latitude = d2 = iDeserializer.getDouble();
            carPosition.angle = n3 = iDeserializer.getInt32();
            carPosition.speed = n2 = iDeserializer.getInt32();
            carPosition.height = n = iDeserializer.getInt32();
        }
        return carPosition;
    }

    public static CarPosition[] getOptionalCarPositionVarArray(IDeserializer iDeserializer) {
        CarPosition[] carPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carPositionArray = new CarPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carPositionArray[i2] = CarPositionSerializer.getOptionalCarPosition(iDeserializer);
            }
        }
        return carPositionArray;
    }
}

