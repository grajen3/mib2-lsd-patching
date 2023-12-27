/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCAcceleration;

public class CarBCAccelerationSerializer {
    public static void putOptionalCarBCAcceleration(ISerializer iSerializer, CarBCAcceleration carBCAcceleration) {
        boolean bl = carBCAcceleration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCAcceleration.getState();
            iSerializer.putInt32(n);
            float f2 = carBCAcceleration.getAccelerationValue();
            iSerializer.putFloat(f2);
            int n2 = carBCAcceleration.getAccelerationUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCAccelerationVarArray(ISerializer iSerializer, CarBCAcceleration[] carBCAccelerationArray) {
        boolean bl = carBCAccelerationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCAccelerationArray.length);
            for (int i2 = 0; i2 < carBCAccelerationArray.length; ++i2) {
                CarBCAccelerationSerializer.putOptionalCarBCAcceleration(iSerializer, carBCAccelerationArray[i2]);
            }
        }
    }

    public static CarBCAcceleration getOptionalCarBCAcceleration(IDeserializer iDeserializer) {
        CarBCAcceleration carBCAcceleration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            carBCAcceleration = new CarBCAcceleration();
            carBCAcceleration.state = n2 = iDeserializer.getInt32();
            carBCAcceleration.accelerationValue = f2 = iDeserializer.getFloat();
            carBCAcceleration.accelerationUnit = n = iDeserializer.getInt32();
        }
        return carBCAcceleration;
    }

    public static CarBCAcceleration[] getOptionalCarBCAccelerationVarArray(IDeserializer iDeserializer) {
        CarBCAcceleration[] carBCAccelerationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCAccelerationArray = new CarBCAcceleration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCAccelerationArray[i2] = CarBCAccelerationSerializer.getOptionalCarBCAcceleration(iDeserializer);
            }
        }
        return carBCAccelerationArray;
    }
}

